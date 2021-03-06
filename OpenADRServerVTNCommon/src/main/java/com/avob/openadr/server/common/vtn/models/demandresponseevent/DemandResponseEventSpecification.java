package com.avob.openadr.server.common.vtn.models.demandresponseevent;

import java.util.List;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;

import org.springframework.data.jpa.domain.Specification;

import com.avob.openadr.server.common.vtn.models.demandresponseevent.filter.DemandResponseEventFilter;
import com.avob.openadr.server.common.vtn.models.vendemandresponseevent.VenDemandResponseEvent;

public class DemandResponseEventSpecification {

	static public Specification<DemandResponseEvent> isPublished() {
		return (event, cq, cb) -> cb.isTrue(event.get("published"));
	}

	static public Specification<DemandResponseEvent> isPublished(Boolean published) {
		return (event, cq, cb) -> cb.equal(event.get("published"), published);
	}

	static public Specification<DemandResponseEvent> isNotPublished() {
		return (event, cq, cb) -> cb.equal(event.get("published"), false);
	}

	static public Specification<DemandResponseEvent> hasDescriptorState(DemandResponseEventStateEnum state) {
		return (event, cq, cb) -> cb.equal(event.get("descriptor").get("state"), state);
	}

	static public Specification<DemandResponseEvent> hasDescriptorMarketContext(String marketContextName) {
		return (event, cq, cb) -> cb.equal(event.get("descriptor").get("marketContext").get("name"), marketContextName);
	}

	static public Specification<DemandResponseEvent> hasDescriptorOadrProfile(
			DemandResponseEventOadrProfileEnum profile) {
		return (event, cq, cb) -> cb.equal(event.get("descriptor").get("oadrProfile"), profile);
	}

	static public Specification<DemandResponseEvent> hasVenUsername(String username) {
		return (event, cq, cb) -> {
			ListJoin<DemandResponseEvent, VenDemandResponseEvent> joinList = event.joinList("venDemandResponseEvent",
					JoinType.INNER);
			return cb.equal(joinList.get("ven").get("username"), username);
		};
	}

	static public Specification<DemandResponseEvent> hasActivePeriodStartAfter(Long timestamp) {
		return (event, cq, cb) -> cb.ge(event.get("activePeriod").get("start"), timestamp);
	}

	static public Specification<DemandResponseEvent> hasActivePeriodEndNullOrBefore(Long timestamp) {
		return (event, cq, cb) -> {
			return cb.or(cb.isNull(event.get("activePeriod").get("end")),
					cb.lt(event.get("activePeriod").get("end"), timestamp));
		};
	}

	static public Specification<DemandResponseEvent> hasActivePeriodStartBefore(Long timestamp) {
		return (event, cq, cb) -> cb.le(event.get("activePeriod").get("start"), timestamp);
	}

	static public Specification<DemandResponseEvent> hasActivePeriodNotificationStartBefore(Long timestamp) {
		return (event, cq, cb) -> cb.le(event.get("activePeriod").get("startNotification"), timestamp);
	}

	static public Specification<DemandResponseEvent> hasActivePeriodEndNullOrAfter(Long timestamp) {
		return (event, cq, cb) -> {
			return cb.or(cb.isNull(event.get("activePeriod").get("end")),
					cb.gt(event.get("activePeriod").get("end"), timestamp));
		};
	}

	static public Specification<DemandResponseEvent> isSendable(boolean sendable) {
		return (event, cq, cb) -> {
			long now = System.currentTimeMillis();
			Specification<DemandResponseEvent> and = DemandResponseEventSpecification.isPublished()
					.and(DemandResponseEventSpecification.hasActivePeriodEndNullOrAfter(now))
					.and(DemandResponseEventSpecification.hasActivePeriodNotificationStartBefore(now));

			if (!sendable) {
				and = Specification.not(and);
			}

			return and.toPredicate(event, cq, cb);

		};
	}

	static public Specification<DemandResponseEvent> toSentByVenUsername(String venUsername) {
		return (event, cq, cb) -> {
			long now = System.currentTimeMillis();
			Specification<DemandResponseEvent> and = DemandResponseEventSpecification.isPublished()
					.and(DemandResponseEventSpecification.hasVenUsername(venUsername))
					.and(DemandResponseEventSpecification.hasActivePeriodEndNullOrAfter(now))
					.and(DemandResponseEventSpecification.hasActivePeriodNotificationStartBefore(now));
			cq.distinct(true);
			return and.toPredicate(event, cq, cb);

		};
	}

	static public Specification<DemandResponseEvent> search(List<DemandResponseEventFilter> filters) {
		Specification<DemandResponseEvent> marketContextPredicates = null;
		Specification<DemandResponseEvent> venPredicates = null;
		Specification<DemandResponseEvent> statePredicates = null;
		Specification<DemandResponseEvent> isPublishedPredicates = null;
		Specification<DemandResponseEvent> isSendablePredicates = null;
		for (DemandResponseEventFilter demandResponseEventFilter : filters) {
			switch (demandResponseEventFilter.getType()) {

			case MARKET_CONTEXT:
				if (marketContextPredicates != null) {
					marketContextPredicates = marketContextPredicates.or(DemandResponseEventSpecification
							.hasDescriptorMarketContext(demandResponseEventFilter.getValue()));
				} else {
					marketContextPredicates = DemandResponseEventSpecification
							.hasDescriptorMarketContext(demandResponseEventFilter.getValue());
				}
				break;
			case VEN:
				if (venPredicates != null) {
					venPredicates = venPredicates
							.or(DemandResponseEventSpecification.hasVenUsername(demandResponseEventFilter.getValue()));
				} else {
					venPredicates = DemandResponseEventSpecification
							.hasVenUsername(demandResponseEventFilter.getValue());
				}
				break;
			case EVENT_STATE:
				DemandResponseEventStateEnum valueOf = DemandResponseEventStateEnum
						.valueOf(demandResponseEventFilter.getValue());
				if (statePredicates != null) {
					statePredicates = statePredicates.or(DemandResponseEventSpecification.hasDescriptorState(valueOf));
				} else {
					statePredicates = DemandResponseEventSpecification.hasDescriptorState(valueOf);
				}
				break;
			case EVENT_PUBLISHED:
				if ("PUBLISHED".equals(demandResponseEventFilter.getValue().toUpperCase())) {
					if (isPublishedPredicates != null) {
						isPublishedPredicates = isPublishedPredicates
								.or(DemandResponseEventSpecification.isPublished(true));
					} else {
						isPublishedPredicates = DemandResponseEventSpecification.isPublished(true);
					}
				} else if ("NOT_PUBLISHED".equals(demandResponseEventFilter.getValue().toUpperCase())) {
					if (isPublishedPredicates != null) {
						isPublishedPredicates = isPublishedPredicates
								.or(DemandResponseEventSpecification.isPublished(false));
					} else {
						isPublishedPredicates = DemandResponseEventSpecification.isPublished(false);
					}
				}

				break;

			case EVENT_SENDABLE:
				if ("SENDABLE".equals(demandResponseEventFilter.getValue().toUpperCase())) {
					if (isSendablePredicates != null) {
						isSendablePredicates = isSendablePredicates
								.or(DemandResponseEventSpecification.isSendable(true));
					} else {
						isSendablePredicates = DemandResponseEventSpecification.isSendable(true);
					}
				} else if ("NOT_SENDABLE".equals(demandResponseEventFilter.getValue().toUpperCase())) {
					if (isSendablePredicates != null) {
						isSendablePredicates = isPublishedPredicates
								.or(DemandResponseEventSpecification.isSendable(false));
					} else {
						isSendablePredicates = DemandResponseEventSpecification.isSendable(false);
					}
				}

				break;

			default:
				break;

			}
		}

		final Specification<DemandResponseEvent> finalRes = Specification.where(marketContextPredicates)
				.and(venPredicates).and(statePredicates).and(isPublishedPredicates).and(isSendablePredicates);

		return (event, cq, cb) -> {
			if (finalRes != null) {
				cq.distinct(true);
				return finalRes.toPredicate(event, cq, cb);
			}
			return null;

		};
	}

}
