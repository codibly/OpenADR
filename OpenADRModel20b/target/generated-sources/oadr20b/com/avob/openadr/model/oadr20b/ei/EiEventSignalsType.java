//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 05:34:24 PM CET 
//


package com.avob.openadr.model.oadr20b.ei;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eiEventSignalsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eiEventSignalsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiEventSignal" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/energyinterop/201110}eiEventBaseline" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eiEventSignalsType", propOrder = {
    "eiEventSignal",
    "eiEventBaseline"
})
public class EiEventSignalsType {

    @XmlElement(required = true)
    protected List<EiEventSignalType> eiEventSignal;
    protected EiEventBaselineType eiEventBaseline;

    /**
     * Interval data for an event Gets the value of the eiEventSignal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eiEventSignal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEiEventSignal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EiEventSignalType }
     * 
     * 
     */
    public List<EiEventSignalType> getEiEventSignal() {
        if (eiEventSignal == null) {
            eiEventSignal = new ArrayList<EiEventSignalType>();
        }
        return this.eiEventSignal;
    }

    /**
     * Interval data for a baseline
     * 
     * @return
     *     possible object is
     *     {@link EiEventBaselineType }
     *     
     */
    public EiEventBaselineType getEiEventBaseline() {
        return eiEventBaseline;
    }

    /**
     * Sets the value of the eiEventBaseline property.
     * 
     * @param value
     *     allowed object is
     *     {@link EiEventBaselineType }
     *     
     */
    public void setEiEventBaseline(EiEventBaselineType value) {
        this.eiEventBaseline = value;
    }

}
