//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 05:34:24 PM CET 
//


package com.avob.openadr.model.oadr20b.oadr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for oadrServiceNameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="oadrServiceNameType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="EiEvent"/&gt;
 *     &lt;enumeration value="EiOpt"/&gt;
 *     &lt;enumeration value="EiReport"/&gt;
 *     &lt;enumeration value="EiRegisterParty"/&gt;
 *     &lt;enumeration value="OadrPoll"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "oadrServiceNameType")
@XmlEnum
public enum OadrServiceNameType {

    @XmlEnumValue("EiEvent")
    EI_EVENT("EiEvent"),
    @XmlEnumValue("EiOpt")
    EI_OPT("EiOpt"),
    @XmlEnumValue("EiReport")
    EI_REPORT("EiReport"),
    @XmlEnumValue("EiRegisterParty")
    EI_REGISTER_PARTY("EiRegisterParty"),
    @XmlEnumValue("OadrPoll")
    OADR_POLL("OadrPoll");
    private final String value;

    OadrServiceNameType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OadrServiceNameType fromValue(String v) {
        for (OadrServiceNameType c: OadrServiceNameType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
