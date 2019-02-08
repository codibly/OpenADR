//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 03:54:56 PM CET 
//


package com.avob.openadr.model.oadr20b.power;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.avob.openadr.model.oadr20b.emix.ItemBaseType;
import com.avob.openadr.model.oadr20b.siscale.SiScaleCodeType;


/**
 * Base for the measurement of Energy
 * 
 * <p>Java class for EnergyItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnergyItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://docs.oasis-open.org/ns/emix/2011/06}ItemBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="itemUnits" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/emix/2011/06/siscale}siScaleCode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnergyItemType", propOrder = {
    "itemDescription",
    "itemUnits",
    "siScaleCode"
})
@XmlSeeAlso({
    EnergyApparentType.class,
    EnergyReactiveType.class,
    EnergyRealType.class
})
public abstract class EnergyItemType
    extends ItemBaseType
{

    @XmlElement(required = true)
    protected String itemDescription;
    @XmlElement(required = true)
    protected String itemUnits;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/emix/2011/06/siscale", required = true)
    @XmlSchemaType(name = "string")
    protected SiScaleCodeType siScaleCode;

    /**
     * Gets the value of the itemDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Sets the value of the itemDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemDescription(String value) {
        this.itemDescription = value;
    }

    /**
     * Gets the value of the itemUnits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemUnits() {
        return itemUnits;
    }

    /**
     * Sets the value of the itemUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemUnits(String value) {
        this.itemUnits = value;
    }

    /**
     * Gets the value of the siScaleCode property.
     * 
     * @return
     *     possible object is
     *     {@link SiScaleCodeType }
     *     
     */
    public SiScaleCodeType getSiScaleCode() {
        return siScaleCode;
    }

    /**
     * Sets the value of the siScaleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SiScaleCodeType }
     *     
     */
    public void setSiScaleCode(SiScaleCodeType value) {
        this.siScaleCode = value;
    }

}
