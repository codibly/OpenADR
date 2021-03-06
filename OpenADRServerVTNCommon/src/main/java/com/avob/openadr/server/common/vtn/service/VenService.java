package com.avob.openadr.server.common.vtn.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.avob.openadr.server.common.vtn.exception.GenerateX509VenException;
import com.avob.openadr.server.common.vtn.models.ven.Ven;
import com.avob.openadr.server.common.vtn.models.ven.VenCreateDto;
import com.avob.openadr.server.common.vtn.models.ven.VenDao;
import com.avob.openadr.server.common.vtn.models.ven.VenSpecification;
import com.avob.openadr.server.common.vtn.models.ven.filter.VenFilter;
import com.avob.openadr.server.common.vtn.models.vendemandresponseevent.VenDemandResponseEventDao;
import com.avob.openadr.server.common.vtn.models.venmarketcontext.VenMarketContext;
import com.avob.openadr.server.common.vtn.models.venresource.VenResourceDao;

@Service
public class VenService extends AbstractUserService<Ven> {

	private static final Integer DEFAULT_SEARCH_SIZE = 20;

	@Resource
	private VenDao venDao;

	@Resource
	private VenResourceDao venResourceDao;

	@Resource
	private VenDemandResponseEventDao venDemandResponseEventDao;

	@Autowired(required = false)
	private GenerateX509CertificateService generateX509VenService;

	private Mapper mapper = new DozerBeanMapper();

	public Ven prepare(String username, String password) {
		return super.prepare(new Ven(), username, password);
	}

	/**
	 * @param username
	 * @return
	 */
	public Ven prepare(String username) {
		return super.prepare(new Ven(), username);
	}

	/**
	 * @param username
	 * @return
	 */
	public Ven prepare(VenCreateDto dto) {
		Ven prepare;
		if (dto.getPassword() != null) {
			prepare = super.prepare(new Ven(), dto.getUsername(), dto.getPassword());
		} else {
			prepare = super.prepare(new Ven(), dto.getUsername());
		}

		mapper.map(dto, prepare);

		return prepare;
	}

	public Optional<File> generateCertificateIfRequired(VenCreateDto dto, Ven ven) throws GenerateX509VenException {

		if (dto.getAuthenticationType() != null && !"no".equals(dto.getAuthenticationType())) {

			if (generateX509VenService != null) {
				File generateCredentials = generateX509VenService.generateCredentials(dto, ven);
				return Optional.of(generateCredentials);
			} else {
				throw new GenerateX509VenException(
						"Client certificate feature require CA certificate to be provided to the vtn");
			}
		}

		return Optional.empty();

	}

	@Override
	@Transactional
	public void delete(Ven instance) {
		venResourceDao.deleteByVenId(instance.getId());
		venDemandResponseEventDao.deleteByVenId(instance.getId());
		venDao.delete(instance);
	}

	@Override
	public void delete(Iterable<Ven> instances) {
		venDao.deleteAll(instances);
	}

	@Override
	public Ven save(Ven instance) {
		return venDao.save(instance);
	}

	@Override
	public void save(Iterable<Ven> instances) {
		venDao.saveAll(instances);
	}

	public Ven findOneByUsername(String username) {
		return venDao.findOneByUsername(username);
	}

	public Ven findOneByRegistrationId(String registrationId) {
		return venDao.findOneByRegistrationId(registrationId);
	}

	public List<Ven> findByUsernameInAndVenMarketContextsContains(List<String> username,
			VenMarketContext venMarketContext) {
		return venDao.findByUsernameInAndVenMarketContextsContains(username, venMarketContext);
	}

	public List<Ven> findByGroupName(List<String> groupName) {
		return venDao.findByVenGroupsName(groupName);
	}

	public List<Ven> findByMarketContextName(List<String> groupName) {
		return venDao.findByVenMarketContextsName(groupName);
	}

	public Ven findOne(Long id) {
		return venDao.findById(id).get();
	}

	public Iterable<Ven> findAll() {
		return venDao.findAll();
	}

	public long count() {
		return venDao.count();
	}

	public void cleanRegistration(Ven ven) {
		ven.setRegistrationId(null);
		ven.setXmlSignature(false);
		this.save(ven);
	}

	public Page<Ven> search(List<VenFilter> filters) {
		return search(filters, null, null);
	}

	public Page<Ven> search(List<VenFilter> filters, Integer page, Integer size) {
		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = DEFAULT_SEARCH_SIZE;
		}
		return venDao.findAll(VenSpecification.search(filters), PageRequest.of(page, size));
	}

}
