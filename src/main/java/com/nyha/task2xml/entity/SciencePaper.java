//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.02 at 01:33:12 AM MSK 
//


package com.nyha.task2xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Science complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Science">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:papers}Paper">
 *       &lt;sequence>
 *         &lt;element name="attestation-organization">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SciencePaper", propOrder = {
    "attestationOrganization"
})
public class SciencePaper
    extends Paper
{

    @XmlElement(name = "attestation-organization", required = true)
    protected String attestationOrganization;

    /**
     * Gets the value of the attestationOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttestationOrganization() {
        return attestationOrganization;
    }

    /**
     * Sets the value of the attestationOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttestationOrganization(String value) {
        this.attestationOrganization = value;
    }

}
