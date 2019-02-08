//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 05:34:24 PM CET 
//


package com.avob.openadr.model.oadr20b.power;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.avob.openadr.model.oadr20b.gml.FeatureCollection;


/**
 * A customer ServiceLocation has one or more ServiceDeliveryPoint(s), which in turn relate to Meters. The location may be a point or a polygon, depending on the specific circumstances. For distribution, the ServiceLocation is typically the location of the utility customer's premise. 
 * 
 * <p>Java class for ServiceLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceLocationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}FeatureCollection"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceLocationType", propOrder = {
    "featureCollection"
})
public class ServiceLocationType {

    @XmlElement(name = "FeatureCollection", namespace = "http://www.opengis.net/gml/3.2", required = true)
    protected FeatureCollection featureCollection;

    /**
     * Gets the value of the featureCollection property.
     * 
     * @return
     *     possible object is
     *     {@link FeatureCollection }
     *     
     */
    public FeatureCollection getFeatureCollection() {
        return featureCollection;
    }

    /**
     * Sets the value of the featureCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeatureCollection }
     *     
     */
    public void setFeatureCollection(FeatureCollection value) {
        this.featureCollection = value;
    }

}
