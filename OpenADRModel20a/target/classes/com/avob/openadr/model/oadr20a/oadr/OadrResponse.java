//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.13 at 03:23:14 PM CEST 
//


package com.avob.openadr.model.oadr20a.oadr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.avob.openadr.model.oadr20a.ei.EiResponse;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "eiResponse"
})
@XmlRootElement(name = "oadrResponse")
public class OadrResponse {

    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected EiResponse eiResponse;

    /**
     * Gets the value of the eiResponse property.
     * 
     * @return
     *     possible object is
     *     {@link EiResponse }
     *     
     */
    public EiResponse getEiResponse() {
        return eiResponse;
    }

    /**
     * Sets the value of the eiResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link EiResponse }
     *     
     */
    public void setEiResponse(EiResponse value) {
        this.eiResponse = value;
    }

}
