//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 05:34:24 PM CET 
//


package com.avob.openadr.model.oadr20b.power;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Reactive Energy, volt-amperes reactive hours (VARh)
 * 
 * <p>Java class for EnergyReactiveType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnergyReactiveType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://docs.oasis-open.org/ns/emix/2011/06/power}EnergyItemType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="itemUnits" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/ns/emix/2011/06/siscale}siScaleCode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnergyReactiveType")
public class EnergyReactiveType
    extends EnergyItemType
{


}
