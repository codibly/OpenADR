//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 03:54:56 PM CET 
//


package com.avob.openadr.model.oadr20b.xcal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}dtstart"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}duration"/&gt;
 *         &lt;element name="tolerance" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tolerate"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="startafter" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
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
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}x-eiNotification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}x-eiRampUp" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}x-eiRecovery" minOccurs="0"/&gt;
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
    "dtstart",
    "duration",
    "tolerance",
    "xEiNotification",
    "xEiRampUp",
    "xEiRecovery"
})
@XmlRootElement(name = "properties")
public class Properties {

    @XmlElement(required = true)
    protected Dtstart dtstart;
    @XmlElement(required = true)
    protected DurationPropType duration;
    protected Properties.Tolerance tolerance;
    @XmlElement(name = "x-eiNotification", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected DurationPropType xEiNotification;
    @XmlElement(name = "x-eiRampUp", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected DurationPropType xEiRampUp;
    @XmlElement(name = "x-eiRecovery", namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected DurationPropType xEiRecovery;

    /**
     * Gets the value of the dtstart property.
     * 
     * @return
     *     possible object is
     *     {@link Dtstart }
     *     
     */
    public Dtstart getDtstart() {
        return dtstart;
    }

    /**
     * Sets the value of the dtstart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dtstart }
     *     
     */
    public void setDtstart(Dtstart value) {
        this.dtstart = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setDuration(DurationPropType value) {
        this.duration = value;
    }

    /**
     * Gets the value of the tolerance property.
     * 
     * @return
     *     possible object is
     *     {@link Properties.Tolerance }
     *     
     */
    public Properties.Tolerance getTolerance() {
        return tolerance;
    }

    /**
     * Sets the value of the tolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Properties.Tolerance }
     *     
     */
    public void setTolerance(Properties.Tolerance value) {
        this.tolerance = value;
    }

    /**
     * Gets the value of the xEiNotification property.
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getXEiNotification() {
        return xEiNotification;
    }

    /**
     * Sets the value of the xEiNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setXEiNotification(DurationPropType value) {
        this.xEiNotification = value;
    }

    /**
     * Gets the value of the xEiRampUp property.
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getXEiRampUp() {
        return xEiRampUp;
    }

    /**
     * Sets the value of the xEiRampUp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setXEiRampUp(DurationPropType value) {
        this.xEiRampUp = value;
    }

    /**
     * Gets the value of the xEiRecovery property.
     * 
     * @return
     *     possible object is
     *     {@link DurationPropType }
     *     
     */
    public DurationPropType getXEiRecovery() {
        return xEiRecovery;
    }

    /**
     * Sets the value of the xEiRecovery property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationPropType }
     *     
     */
    public void setXEiRecovery(DurationPropType value) {
        this.xEiRecovery = value;
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
     *         &lt;element name="tolerate"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="startafter" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
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
        "tolerate"
    })
    public static class Tolerance {

        @XmlElement(required = true)
        protected Properties.Tolerance.Tolerate tolerate;

        /**
         * Gets the value of the tolerate property.
         * 
         * @return
         *     possible object is
         *     {@link Properties.Tolerance.Tolerate }
         *     
         */
        public Properties.Tolerance.Tolerate getTolerate() {
            return tolerate;
        }

        /**
         * Sets the value of the tolerate property.
         * 
         * @param value
         *     allowed object is
         *     {@link Properties.Tolerance.Tolerate }
         *     
         */
        public void setTolerate(Properties.Tolerance.Tolerate value) {
            this.tolerate = value;
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
         *         &lt;element name="startafter" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
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
            "startafter"
        })
        public static class Tolerate {

            protected String startafter;

            /**
             * Gets the value of the startafter property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStartafter() {
                return startafter;
            }

            /**
             * Sets the value of the startafter property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStartafter(String value) {
                this.startafter = value;
            }

        }

    }

}
