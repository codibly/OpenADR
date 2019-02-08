package com.avob.openadr.server.common.vtn.models.venresource;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.avob.openadr.server.common.vtn.models.ven.Ven;

@Entity
@Table(name = "venresource")
public class VenResource implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 174833018565991554L;

    /**
     * Autogenerated unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique = true)
    private String uniqueName;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "venresource_ven_id")
    private Ven ven;

    public VenResource() {
    }

    public VenResource(String name, Ven ven) {
        this.name = name;
        this.setUniqueName(ven.getUsername() + name);
        this.ven = ven;
    }

    @PreRemove
    public void removeVenResourceFromVen() {
        if (ven != null) {
            ven.removeResource(this);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ven getVen() {
        return ven;
    }

    public void setVen(Ven ven) {
        this.ven = ven;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    private void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

}
