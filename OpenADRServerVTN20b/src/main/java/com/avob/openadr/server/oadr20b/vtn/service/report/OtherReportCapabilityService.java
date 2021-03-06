package com.avob.openadr.server.oadr20b.vtn.service.report;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.avob.openadr.server.common.vtn.models.ven.Ven;
import com.avob.openadr.server.oadr20b.vtn.models.venreport.capability.OtherReportCapability;
import com.avob.openadr.server.oadr20b.vtn.models.venreport.capability.OtherReportCapabilityDao;
import com.avob.openadr.server.oadr20b.vtn.service.GenericService;

@Service
public class OtherReportCapabilityService extends GenericService<OtherReportCapability> {

	@Resource
	private OtherReportCapabilityDao otherReportCapabilityDao;

	public List<OtherReportCapability> findByReportSpecifierIdStartingWith(String reportSpecifierId) {
		return otherReportCapabilityDao.findByReportSpecifierIdStartingWith(reportSpecifierId);
	}

	public List<OtherReportCapability> findByReportRequestId(List<String> payloadReportRequestId) {
		return otherReportCapabilityDao.findByReportRequestIdIn(payloadReportRequestId);
	}

	public OtherReportCapability findByReportSpecifierId(String reportSpecifierId) {
		return otherReportCapabilityDao.findOneByReportSpecifierId(reportSpecifierId);
	}

	public List<OtherReportCapability> findBySource(Ven source) {
		return otherReportCapabilityDao.findBySource(source);
	}

	@Override
	public CrudRepository<OtherReportCapability, Long> getDao() {
		return otherReportCapabilityDao;
	}

}
