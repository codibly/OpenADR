//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.08 at 03:54:56 PM CET 
//


package com.avob.openadr.model.oadr20b.ei;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReadingTypeEnumeratedType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReadingTypeEnumeratedType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Direct Read"/&gt;
 *     &lt;enumeration value="Net"/&gt;
 *     &lt;enumeration value="Allocated"/&gt;
 *     &lt;enumeration value="Estimated"/&gt;
 *     &lt;enumeration value="Summed"/&gt;
 *     &lt;enumeration value="Derived"/&gt;
 *     &lt;enumeration value="Mean"/&gt;
 *     &lt;enumeration value="Peak"/&gt;
 *     &lt;enumeration value="Hybrid"/&gt;
 *     &lt;enumeration value="Contract"/&gt;
 *     &lt;enumeration value="Projected"/&gt;
 *     &lt;enumeration value="x-RMS"/&gt;
 *     &lt;enumeration value="x-notApplicable"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ReadingTypeEnumeratedType")
@XmlEnum
public enum ReadingTypeEnumeratedType {


    /**
     * Reading is read from a device that increases monotonically, and usage must be computed from pairs of start and stop readings.
     * 
     */
    @XmlEnumValue("Direct Read")
    DIRECT_READ("Direct Read"),

    /**
     * Meter or [resource] prepares its own calculation of total use over time.
     * 
     */
    @XmlEnumValue("Net")
    NET("Net"),

    /**
     * Meter covers several [resources] and usage is inferred through some sort of pro data computation.
     * 
     */
    @XmlEnumValue("Allocated")
    ALLOCATED("Allocated"),

    /**
     * Used when a reading is absent in a series in which most readings are present.
     * 
     */
    @XmlEnumValue("Estimated")
    ESTIMATED("Estimated"),

    /**
     * Several meters together provide the reading for this [resource]. This is specifically a different than aggregated, which refers to multiple [resources] in the same payload. See also Hybrid.
     * 
     */
    @XmlEnumValue("Summed")
    SUMMED("Summed"),

    /**
     * Usage is inferred through knowledge of run-time, normal operation, etc.
     * 
     */
    @XmlEnumValue("Derived")
    DERIVED("Derived"),

    /**
     * Reading is the mean value over the period indicated in Granularity
     * 
     */
    @XmlEnumValue("Mean")
    MEAN("Mean"),

    /**
     * Reading is Peak (highest) value over the period indicated in granularity. For some measurements, it may make more sense as the lowest value. May not be consistent with aggregate readings. Only valid for flow-rate Item Bases, i.e., Power not Energy.
     * 
     */
    @XmlEnumValue("Peak")
    PEAK("Peak"),

    /**
     * If aggregated, refers to different reading types in the aggregate number.
     * 
     */
    @XmlEnumValue("Hybrid")
    HYBRID("Hybrid"),

    /**
     * Indicates reading is pro forma, i.e., is reported at agreed upon rates
     * 
     */
    @XmlEnumValue("Contract")
    CONTRACT("Contract"),

    /**
     * Indicates reading is in the future, and has not yet been measured.
     * 
     */
    @XmlEnumValue("Projected")
    PROJECTED("Projected"),

    /**
     * Root Mean Square
     * 
     */
    @XmlEnumValue("x-RMS")
    X_RMS("x-RMS"),

    /**
     * Not Applicable
     * 
     */
    @XmlEnumValue("x-notApplicable")
    X_NOT_APPLICABLE("x-notApplicable");
    private final String value;

    ReadingTypeEnumeratedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReadingTypeEnumeratedType fromValue(String v) {
        for (ReadingTypeEnumeratedType c: ReadingTypeEnumeratedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
