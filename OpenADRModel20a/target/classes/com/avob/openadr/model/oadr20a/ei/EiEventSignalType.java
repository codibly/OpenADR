//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.13 at 03:23:14 PM CEST 
//


package com.avob.openadr.model.oadr20a.ei;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.avob.openadr.model.oadr20a.strm.Intervals;


/**
 * <p>Java class for eiEventSignalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eiEventSignalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0:stream}intervals"/&gt;
 *         &lt;element name="signalName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}signalType"/&gt;
 *         &lt;element name="signalID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}currentValue"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eiEventSignalType", propOrder = {
    "intervals",
    "signalName",
    "signalType",
    "signalID",
    "currentValue"
})
public class EiEventSignalType {

    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0:stream", required = true)
    protected Intervals intervals;
    @XmlElement(required = true)
    protected String signalName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "token")
    protected SignalTypeEnumeratedType signalType;
    @XmlElement(required = true)
    protected String signalID;
    @XmlElement(required = true)
    protected CurrentValueType currentValue;

    /**
     * Gets the value of the intervals property.
     * 
     * @return
     *     possible object is
     *     {@link Intervals }
     *     
     */
    public Intervals getIntervals() {
        return intervals;
    }

    /**
     * Sets the value of the intervals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Intervals }
     *     
     */
    public void setIntervals(Intervals value) {
        this.intervals = value;
    }

    /**
     * Gets the value of the signalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignalName() {
        return signalName;
    }

    /**
     * Sets the value of the signalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignalName(String value) {
        this.signalName = value;
    }

    /**
     * Gets the value of the signalType property.
     * 
     * @return
     *     possible object is
     *     {@link SignalTypeEnumeratedType }
     *     
     */
    public SignalTypeEnumeratedType getSignalType() {
        return signalType;
    }

    /**
     * Sets the value of the signalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalTypeEnumeratedType }
     *     
     */
    public void setSignalType(SignalTypeEnumeratedType value) {
        this.signalType = value;
    }

    /**
     * Gets the value of the signalID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignalID() {
        return signalID;
    }

    /**
     * Sets the value of the signalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignalID(String value) {
        this.signalID = value;
    }

    /**
     * Gets the value of the currentValue property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentValueType }
     *     
     */
    public CurrentValueType getCurrentValue() {
        return currentValue;
    }

    /**
     * Sets the value of the currentValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentValueType }
     *     
     */
    public void setCurrentValue(CurrentValueType value) {
        this.currentValue = value;
    }

}
