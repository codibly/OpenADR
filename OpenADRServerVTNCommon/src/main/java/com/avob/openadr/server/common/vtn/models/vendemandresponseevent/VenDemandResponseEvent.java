package com.avob.openadr.server.common.vtn.models.vendemandresponseevent;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avob.openadr.server.common.vtn.models.demandresponseevent.DemandResponseEvent;
import com.avob.openadr.server.common.vtn.models.demandresponseevent.DemandResponseEventOptEnum;
import com.avob.openadr.server.common.vtn.models.ven.Ven;

/**
 * 
 * @author bertrand
 *
 */
@Entity
@Table(name = "vendemandresponseevent")
public class VenDemandResponseEvent {

    /**
     * Autogenerated unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Related ven
     */
    @ManyToOne
    @JoinColumn(name = "ven_id")
    private Ven ven;

    /**
     * Related event
     */
    @ManyToOne
    @JoinColumn(name = "demandresponseevent_id")
    private DemandResponseEvent event;

    private long lastSentModificationNumber = -1;

    @Enumerated(EnumType.STRING)
    private DemandResponseEventOptEnum venOpt;

    public VenDemandResponseEvent() {
    }

    public VenDemandResponseEvent(DemandResponseEvent event, Ven ven) {
        this.event = event;
        this.ven = ven;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ven getVen() {
        return ven;
    }

    public void setVen(Ven ven) {
        this.ven = ven;
    }

    public DemandResponseEvent getEvent() {
        return event;
    }

    public void setEvent(DemandResponseEvent event) {
        this.event = event;
    }

    public long getLastSentModificationNumber() {
        return lastSentModificationNumber;
    }

    public void setLastSentModificationNumber(long lastSentModificationNumber) {
        this.lastSentModificationNumber = lastSentModificationNumber;
    }

    public DemandResponseEventOptEnum getVenOpt() {
        return venOpt;
    }

    public void setVenOpt(DemandResponseEventOptEnum venOpt) {
        this.venOpt = venOpt;
    }

    @Override
    public String toString() {
        return "VenDemandResponseEvent [id=" + id + ", ven=" + ven + ", event=" + event
                + ", lastSentModificationNumber=" + lastSentModificationNumber + ", venOpt=" + venOpt + "]";
    }

}
