//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 05:34:24 PM CET 
//


package com.avob.openadr.model.oadr20b.oadr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.avob.openadr.model.oadr20b.strm.StreamBaseType;


/**
 * eiReport is a Stream of [measurements] recorded over time and delivered to the requestor periodically. The readings may be actual, computed, summed if derived in some other manner.
 * 
 * <p>Java class for oadrReportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="oadrReportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0:stream}StreamBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiReportID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://openadr.org/oadr-2.0b/2012/07}oadrReportDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}reportRequestID"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}reportSpecifierID"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}reportName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}createdDateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oadrReportType", propOrder = {
    "eiReportID",
    "oadrReportDescription",
    "reportRequestID",
    "reportSpecifierID",
    "reportName",
    "createdDateTime"
})
public class OadrReportType
    extends StreamBaseType
{

    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected String eiReportID;
    protected List<OadrReportDescriptionType> oadrReportDescription;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected String reportRequestID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    protected String reportSpecifierID;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110")
    protected String reportName;
    @XmlElement(namespace = "http://docs.oasis-open.org/ns/energyinterop/201110", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDateTime;

    /**
     * reference ID to this report.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEiReportID() {
        return eiReportID;
    }

    /**
     * Sets the value of the eiReportID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEiReportID(String value) {
        this.eiReportID = value;
    }

    /**
     * Define data points the implementation is capable of reporting on. Only used in Metadata report Gets the value of the oadrReportDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oadrReportDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOadrReportDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OadrReportDescriptionType }
     * 
     * 
     */
    public List<OadrReportDescriptionType> getOadrReportDescription() {
        if (oadrReportDescription == null) {
            oadrReportDescription = new ArrayList<OadrReportDescriptionType>();
        }
        return this.oadrReportDescription;
    }

    /**
     * Reference to the oadrCreateReport request that defined this report.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportRequestID() {
        return reportRequestID;
    }

    /**
     * Sets the value of the reportRequestID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportRequestID(String value) {
        this.reportRequestID = value;
    }

    /**
     * Reference to Metadata report from which this report was derived.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportSpecifierID() {
        return reportSpecifierID;
    }

    /**
     * Sets the value of the reportSpecifierID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportSpecifierID(String value) {
        this.reportSpecifierID = value;
    }

    /**
     * Name possibly for use in a user interface.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Sets the value of the reportName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportName(String value) {
        this.reportName = value;
    }

    /**
     * Gets the value of the createdDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * Sets the value of the createdDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDateTime(XMLGregorianCalendar value) {
        this.createdDateTime = value;
    }

}
