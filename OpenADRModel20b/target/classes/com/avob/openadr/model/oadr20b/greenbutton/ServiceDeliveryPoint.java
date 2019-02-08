//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 03:54:56 PM CET 
//


package com.avob.openadr.model.oadr20b.greenbutton;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * [extension] Service Delivery Point is representation of revenue UsagePoint attributes
 * 
 * <p>Java class for ServiceDeliveryPoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceDeliveryPoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://naesb.org/espi}Object"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://naesb.org/espi}String256" minOccurs="0"/&gt;
 *         &lt;element name="tariffProfile" type="{http://naesb.org/espi}String256" minOccurs="0"/&gt;
 *         &lt;element name="customerAgreement" type="{http://naesb.org/espi}String256" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceDeliveryPoint", propOrder = {
    "name",
    "tariffProfile",
    "customerAgreement"
})
public class ServiceDeliveryPoint
    extends Object
{

    protected String name;
    protected String tariffProfile;
    protected String customerAgreement;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the tariffProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffProfile() {
        return tariffProfile;
    }

    /**
     * Sets the value of the tariffProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffProfile(String value) {
        this.tariffProfile = value;
    }

    /**
     * Gets the value of the customerAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerAgreement() {
        return customerAgreement;
    }

    /**
     * Sets the value of the customerAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerAgreement(String value) {
        this.customerAgreement = value;
    }

}
