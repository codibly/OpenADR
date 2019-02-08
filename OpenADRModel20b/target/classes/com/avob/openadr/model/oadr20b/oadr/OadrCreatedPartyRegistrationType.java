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
import javax.xml.bind.annotation.XmlType;
import com.avob.openadr.model.oadr20b.ei.EiResponseType;
import com.avob.openadr.model.oadr20b.xcal.DurationPropType;


/**
 * <p>Java class for oadrCreatedPartyRegistrationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="oadrCreatedPartyRegistrationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiResponse"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}registrationID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}venID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}vtnID"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrProfiles"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrRequestedOadrPollFreq" minOccurs="0"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrServiceSpecificInfo" minOccurs="0"/&gt;
 *         &lt;element name="oadrExtensions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="oadrExtension" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="oadrExtensionName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "oadrCreatedPartyRegistrationType", propOrder = {
    "eiResponse",
    "registrationID",
    "venID",
    "vtnID",
    "oadrProfiles",
    "oadrRequestedOadrPollFreq",
    "oadrServiceSpecificInfo",
    "oadrExtensions"
})
public class OadrCreatedPartyRegistrationType {

    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected EiResponseType eiResponse;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected String registrationID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected String venID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected String vtnID;
    @XmlElement(required = true)
    protected OadrProfiles oadrProfiles;
    protected DurationPropType oadrRequestedOadrPollFreq;
    protected OadrServiceSpecificInfo oadrServiceSpecificInfo;
    protected OadrCreatedPartyRegistrationType.OadrExtensions oadrExtensions;
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
     * Gets the value of the registrationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationID() {
        return registrationID;
    }

    /**
     * Sets the value of the registrationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationID(String value) {
        this.registrationID = value;
    }

    /**
     * venID not included in query unless already registered
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVenID() {
        return venID;
    }

    /**
     * Sets the value of the venID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVenID(String value) {
        this.venID = value;
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
     * VTN response to query registration returns all supported. This element is not required for a registration  response
     * 
     * @return
     *     possible object is
     *     {@link OadrProfiles }
     *     
     */
    public OadrProfiles getOadrProfiles() {
        return oadrProfiles;
    }

    /**
     * Sets the value of the oadrProfiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link OadrProfiles }
     *     
     */
    public void setOadrProfiles(OadrProfiles value) {
        this.oadrProfiles = value;
    }

    /**
     * HTTP Pull Only - The VEN shall send an oadrPoll payload to the VTN at most once for each duration specified by this element
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getOadrRequestedOadrPollFreq() {
        return oadrRequestedOadrPollFreq;
    }

    /**
     * Sets the value of the oadrRequestedOadrPollFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setOadrRequestedOadrPollFreq(DurationPropType value) {
        this.oadrRequestedOadrPollFreq = value;
    }

    /**
     * Gets the value of the oadrServiceSpecificInfo property.
     * 
     * @return
     *     possible object is
     *     {@link OadrServiceSpecificInfo }
     *     
     */
    public OadrServiceSpecificInfo getOadrServiceSpecificInfo() {
        return oadrServiceSpecificInfo;
    }

    /**
     * Sets the value of the oadrServiceSpecificInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OadrServiceSpecificInfo }
     *     
     */
    public void setOadrServiceSpecificInfo(OadrServiceSpecificInfo value) {
        this.oadrServiceSpecificInfo = value;
    }

    /**
     * Gets the value of the oadrExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link OadrCreatedPartyRegistrationType.OadrExtensions }
     *     
     */
    public OadrCreatedPartyRegistrationType.OadrExtensions getOadrExtensions() {
        return oadrExtensions;
    }

    /**
     * Sets the value of the oadrExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link OadrCreatedPartyRegistrationType.OadrExtensions }
     *     
     */
    public void setOadrExtensions(OadrCreatedPartyRegistrationType.OadrExtensions value) {
        this.oadrExtensions = value;
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
     *         &lt;element name="oadrExtension" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="oadrExtensionName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "oadrExtension"
    })
    public static class OadrExtensions {

        protected List<OadrCreatedPartyRegistrationType.OadrExtensions.OadrExtension> oadrExtension;

        /**
         * Gets the value of the oadrExtension property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the oadrExtension property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOadrExtension().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OadrCreatedPartyRegistrationType.OadrExtensions.OadrExtension }
         * 
         * 
         */
        public List<OadrCreatedPartyRegistrationType.OadrExtensions.OadrExtension> getOadrExtension() {
            if (oadrExtension == null) {
                oadrExtension = new ArrayList<OadrCreatedPartyRegistrationType.OadrExtensions.OadrExtension>();
            }
            return this.oadrExtension;
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
         *         &lt;element name="oadrExtensionName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
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
            "oadrExtensionName",
            "oadrInfo"
        })
        public static class OadrExtension {

            @XmlElement(required = true)
            protected String oadrExtensionName;
            protected List<OadrInfo> oadrInfo;

            /**
             * Gets the value of the oadrExtensionName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOadrExtensionName() {
                return oadrExtensionName;
            }

            /**
             * Sets the value of the oadrExtensionName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOadrExtensionName(String value) {
                this.oadrExtensionName = value;
            }

            /**
             * Gets the value of the oadrInfo property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the oadrInfo property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOadrInfo().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link OadrInfo }
             * 
             * 
             */
            public List<OadrInfo> getOadrInfo() {
                if (oadrInfo == null) {
                    oadrInfo = new ArrayList<OadrInfo>();
                }
                return this.oadrInfo;
            }

        }

    }

}
