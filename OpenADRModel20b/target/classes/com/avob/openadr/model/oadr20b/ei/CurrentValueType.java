//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 03:54:56 PM CET 
//


package com.avob.openadr.model.oadr20b.ei;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for currentValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="currentValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}payloadFloat"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "currentValueType", propOrder = {
    "payloadFloat"
})
public class CurrentValueType {

    protected PayloadFloatType payloadFloat;

    /**
     * Gets the value of the payloadFloat property.
     * 
     * @return
     *     possible object is
     *     {@link PayloadFloatType }
     *     
     */
    public PayloadFloatType getPayloadFloat() {
        return payloadFloat;
    }

    /**
     * Sets the value of the payloadFloat property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayloadFloatType }
     *     
     */
    public void setPayloadFloat(PayloadFloatType value) {
        this.payloadFloat = value;
    }

}
