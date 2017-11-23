
package com.artmark.avs5router.dispatcher.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.artmark.avs5router.dispatcher.model package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.artmark.avs5router.dispatcher.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AbstractResponse }
     * 
     */
    public AbstractResponse createAbstractResponse() {
        return new AbstractResponse();
    }

    /**
     * Create an instance of {@link UpdateTicketResponse }
     * 
     */
    public UpdateTicketResponse createUpdateTicketResponse() {
        return new UpdateTicketResponse();
    }

    /**
     * Create an instance of {@link AbstractResponse.Error }
     * 
     */
    public AbstractResponse.Error createAbstractResponseError() {
        return new AbstractResponse.Error();
    }

    /**
     * Create an instance of {@link UpdateTicketRequest }
     * 
     */
    public UpdateTicketRequest createUpdateTicketRequest() {
        return new UpdateTicketRequest();
    }

    /**
     * Create an instance of {@link RouteKey }
     * 
     */
    public RouteKey createRouteKey() {
        return new RouteKey();
    }

}
