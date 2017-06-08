
package com.artmark.avs5router.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransitSeat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransitSeat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seatId" type="{}IDType"/>
 *         &lt;element name="seatNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransitSeat", propOrder = {
    "seatId",
    "seatNum"
})
public class TransitSeat {

    @XmlElement(required = true)
    protected String seatId;
    protected int seatNum;

    /**
     * Gets the value of the seatId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatId() {
        return seatId;
    }

    /**
     * Sets the value of the seatId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatId(String value) {
        this.seatId = value;
    }

    /**
     * Gets the value of the seatNum property.
     * 
     */
    public int getSeatNum() {
        return seatNum;
    }

    /**
     * Sets the value of the seatNum property.
     * 
     */
    public void setSeatNum(int value) {
        this.seatNum = value;
    }

}
