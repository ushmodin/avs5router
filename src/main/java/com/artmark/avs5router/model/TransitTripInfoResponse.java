
package com.artmark.avs5router.model;

import java.util.ArrayList;
import java.util.List;
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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}AbstractResponse">
 *       &lt;sequence>
 *         &lt;element name="Body">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Ticket" type="{}TransitTicket" maxOccurs="unbounded"/>
 *                   &lt;element name="maxSeats" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="freeSeats" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="Carrier" type="{}CarrierType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "", propOrder = {
    "body"
})
@XmlRootElement(name = "TransitTripInfoResponse")
public class TransitTripInfoResponse
    extends AbstractResponse
{

    @XmlElement(name = "Body", required = true)
    protected TransitTripInfoResponse.Body body;

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link TransitTripInfoResponse.Body }
     *     
     */
    public TransitTripInfoResponse.Body getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitTripInfoResponse.Body }
     *     
     */
    public void setBody(TransitTripInfoResponse.Body value) {
        this.body = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Ticket" type="{}TransitTicket" maxOccurs="unbounded"/>
     *         &lt;element name="maxSeats" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="freeSeats" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="Carrier" type="{}CarrierType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ticket",
        "maxSeats",
        "freeSeats",
        "carrier"
    })
    public static class Body {

        @XmlElement(name = "Ticket", required = true)
        protected List<TransitTicket> ticket;
        protected int maxSeats;
        protected int freeSeats;
        @XmlElement(name = "Carrier")
        protected CarrierType carrier;

        /**
         * Gets the value of the ticket property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ticket property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTicket().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TransitTicket }
         * 
         * 
         */
        public List<TransitTicket> getTicket() {
            if (ticket == null) {
                ticket = new ArrayList<TransitTicket>();
            }
            return this.ticket;
        }

        /**
         * Gets the value of the maxSeats property.
         * 
         */
        public int getMaxSeats() {
            return maxSeats;
        }

        /**
         * Sets the value of the maxSeats property.
         * 
         */
        public void setMaxSeats(int value) {
            this.maxSeats = value;
        }

        /**
         * Gets the value of the freeSeats property.
         * 
         */
        public int getFreeSeats() {
            return freeSeats;
        }

        /**
         * Sets the value of the freeSeats property.
         * 
         */
        public void setFreeSeats(int value) {
            this.freeSeats = value;
        }

        /**
         * Gets the value of the carrier property.
         * 
         * @return
         *     possible object is
         *     {@link CarrierType }
         *     
         */
        public CarrierType getCarrier() {
            return carrier;
        }

        /**
         * Sets the value of the carrier property.
         * 
         * @param value
         *     allowed object is
         *     {@link CarrierType }
         *     
         */
        public void setCarrier(CarrierType value) {
            this.carrier = value;
        }

    }

}
