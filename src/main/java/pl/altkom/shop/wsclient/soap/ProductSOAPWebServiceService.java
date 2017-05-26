
package pl.altkom.shop.wsclient.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ProductSOAPWebServiceService", targetNamespace = "http://cxf.shop.altkom.pl/", wsdlLocation = "http://localhost:8080/spring-shop/services/ProductSOAPWebService?wsdl")
public class ProductSOAPWebServiceService
    extends Service
{

    private final static URL PRODUCTSOAPWEBSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException PRODUCTSOAPWEBSERVICESERVICE_EXCEPTION;
    private final static QName PRODUCTSOAPWEBSERVICESERVICE_QNAME = new QName("http://cxf.shop.altkom.pl/", "ProductSOAPWebServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/spring-shop/services/ProductSOAPWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PRODUCTSOAPWEBSERVICESERVICE_WSDL_LOCATION = url;
        PRODUCTSOAPWEBSERVICESERVICE_EXCEPTION = e;
    }

    public ProductSOAPWebServiceService() {
        super(__getWsdlLocation(), PRODUCTSOAPWEBSERVICESERVICE_QNAME);
    }

    public ProductSOAPWebServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRODUCTSOAPWEBSERVICESERVICE_QNAME, features);
    }

    public ProductSOAPWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, PRODUCTSOAPWEBSERVICESERVICE_QNAME);
    }

    public ProductSOAPWebServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRODUCTSOAPWEBSERVICESERVICE_QNAME, features);
    }

    public ProductSOAPWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductSOAPWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ProductSOAPWebService
     */
    @WebEndpoint(name = "ProductSOAPWebServicePort")
    public ProductSOAPWebService getProductSOAPWebServicePort() {
        return super.getPort(new QName("http://cxf.shop.altkom.pl/", "ProductSOAPWebServicePort"), ProductSOAPWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProductSOAPWebService
     */
    @WebEndpoint(name = "ProductSOAPWebServicePort")
    public ProductSOAPWebService getProductSOAPWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://cxf.shop.altkom.pl/", "ProductSOAPWebServicePort"), ProductSOAPWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRODUCTSOAPWEBSERVICESERVICE_EXCEPTION!= null) {
            throw PRODUCTSOAPWEBSERVICESERVICE_EXCEPTION;
        }
        return PRODUCTSOAPWEBSERVICESERVICE_WSDL_LOCATION;
    }

}
