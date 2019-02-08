//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 03:54:56 PM CET 
//


package com.avob.openadr.model.oadr20b.strm;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.avob.openadr.model.oadr20b.strm package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StreamPayloadBase_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0:stream", "streamPayloadBase");
    private final static QName _StreamBase_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0:stream", "streamBase");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.avob.openadr.model.oadr20b.strm
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Intervals }
     * 
     */
    public Intervals createIntervals() {
        return new Intervals();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StreamPayloadBaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StreamPayloadBaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0:stream", name = "streamPayloadBase")
    public JAXBElement<StreamPayloadBaseType> createStreamPayloadBase(StreamPayloadBaseType value) {
        return new JAXBElement<StreamPayloadBaseType>(_StreamPayloadBase_QNAME, StreamPayloadBaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StreamBaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StreamBaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0:stream", name = "streamBase")
    public JAXBElement<StreamBaseType> createStreamBase(StreamBaseType value) {
        return new JAXBElement<StreamBaseType>(_StreamBase_QNAME, StreamBaseType.class, null, value);
    }

}
