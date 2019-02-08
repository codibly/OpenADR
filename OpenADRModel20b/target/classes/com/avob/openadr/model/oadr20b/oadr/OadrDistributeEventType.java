//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 03:54:56 PM CET 
//


package com.avob.openadr.model.oadr20b.oadr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.avob.openadr.model.oadr20b.ei.EiEventType;
import com.avob.openadr.model.oadr20b.ei.EiResponseType;


/**
 * <p>Java class for oadrDistributeEventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="oadrDistributeEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiResponse" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110/payloads}requestID"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}vtnID"/&gt;
 *         &lt;element name="oadrEvent" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiEvent"/&gt;
 *                   &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrResponseRequired"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://docs.oasis-open.org/ns/energyinterop/201110}schemaVersion"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oadrDistributeEventType", propOrder = {
    "eiResponse",
    "requestID",
    "vtnID",
    "oadrEvent"
})
public class OadrDistributeEventType {

    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected EiResponseType eiResponse;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110/payloads", required = true)
    protected String requestID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected String vtnID;
    protected List<OadrDistributeEventType.OadrEvent> oadrEvent;
    @XmlAttribute(name = "schemaVersion", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected String schemaVersion;

    /**
     * Gets the value of the eiResponse property.
     * 
     * @return
     *     possible object is
     *     {@link EiResponseType }
     *     
     */
    public EiResponseType getEiResponse() {
        return eiResponse;
    }

    /**
     * Sets the value of the eiResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link EiResponseType }
     *     
     */
    public void setEiResponse(EiResponseType value) {
        this.eiResponse = value;
    }

    /**
     * Gets the value of the requestID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * Sets the value of the requestID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestID(String value) {
        this.requestID = value;
    }

    /**
     * Gets the value of the vtnID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVtnID() {
        return vtnID;
    }

    /**
     * Sets the value of the vtnID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVtnID(String value) {
        this.vtnID = value;
    }

    /**
     * Gets the value of the oadrEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oadrEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOadrEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OadrDistributeEventType.OadrEvent }
     * 
     * 
     */
    public List<OadrDistributeEventType.OadrEvent> getOadrEvent() {
        if (oadrEvent == null) {
            oadrEvent = new ArrayList<OadrDistributeEventType.OadrEvent>();
        }
        return this.oadrEvent;
    }

    /**
     * Gets the value of the schemaVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Sets the value of the schemaVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaVersion(String value) {
        this.schemaVersion = value;
    }


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
     *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiEvent"/&gt;
     *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrResponseRequired"/&gt;
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
        "eiEvent",
        "oadrResponseRequired"
    })
    public static class OadrEvent {

        @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
        protected EiEventType eiEvent;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected ResponseRequiredType oadrResponseRequired;

        /**
         * Gets the value of the eiEvent property.
         * 
         * @return
         *     possible object is
         *     {@link EiEventType }
         *     
         */
        public EiEventType getEiEvent() {
            return eiEvent;
        }

        /**
         * Sets the value of the eiEvent property.
         * 
         * @param value
         *     allowed object is
         *     {@link EiEventType }
         *     
         */
        public void setEiEvent(EiEventType value) {
            this.eiEvent = value;
        }

        /**
         * Gets the value of the oadrResponseRequired property.
         * 
         * @return
         *     possible object is
         *     {@link ResponseRequiredType }
         *     
         */
        public ResponseRequiredType getOadrResponseRequired() {
            return oadrResponseRequired;
        }

        /**
         * Sets the value of the oadrResponseRequired property.
         * 
         * @param value
         *     allowed object is
         *     {@link ResponseRequiredType }
         *     
         */
        public void setOadrResponseRequired(ResponseRequiredType value) {
            this.oadrResponseRequired = value;
        }

    }

}
