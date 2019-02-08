//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 05:34:24 PM CET 
//


package com.avob.openadr.model.oadr20b.greenbutton;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * [extension] Line item of detail for additional cost
 * 
 * <p>Java class for LineItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="amount" type="{http://naesb.org/espi}Int48"/&gt;
 *         &lt;element name="rounding" type="{http://naesb.org/espi}Int48" minOccurs="0"/&gt;
 *         &lt;element name="dateTime" type="{http://naesb.org/espi}TimeType"/&gt;
 *         &lt;element name="note" type="{http://naesb.org/espi}String256"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineItem", propOrder = {
    "amount",
    "rounding",
    "dateTime",
    "note"
})
public class LineItem {

    protected long amount;
    protected Long rounding;
    protected long dateTime;
    @XmlElement(required = true)
    protected String note;

    /**
     * Gets the value of the amount property.
     * 
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(long value) {
        this.amount = value;
    }

    /**
     * Gets the value of the rounding property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRounding() {
        return rounding;
    }

    /**
     * Sets the value of the rounding property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRounding(Long value) {
        this.rounding = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     */
    public long getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     */
    public void setDateTime(long value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

}
