//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 03:54:56 PM CET 
//


package com.avob.openadr.model.oadr20b.avob;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.avob.openadr.model.oadr20b.ei.PayloadBaseType;


/**
 * This is the payload for report sending key-value
 * 				data
 * 			
 * 
 * <p>Java class for payloadAvobVenServiceRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payloadAvobVenServiceRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://docs.oasis-open.org/ns/energyinterop/201110}PayloadBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requests" type="{http://oadr.avob.com}avobVenServiceRequestType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payloadAvobVenServiceRequestType", propOrder = {
    "requests"
})
public class PayloadAvobVenServiceRequestType
    extends PayloadBaseType
{

    protected List<AvobVenServiceRequestType> requests;

    /**
     * Gets the value of the requests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AvobVenServiceRequestType }
     * 
     * 
     */
    public List<AvobVenServiceRequestType> getRequests() {
        if (requests == null) {
            requests = new ArrayList<AvobVenServiceRequestType>();
        }
        return this.requests;
    }

}
