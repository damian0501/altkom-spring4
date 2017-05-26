package pl.altkom.shop;

import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

import pl.altkom.shop.wsclient.soap.Product;
import pl.altkom.shop.wsclient.soap.ProductSOAPWebService;
import pl.altkom.shop.wsclient.soap.ProductSOAPWebServiceService;

public class MainTest {

	public static void main(String[] args) {
		ProductSOAPWebServiceService productSOAPWebServiceService = new ProductSOAPWebServiceService();
		ProductSOAPWebService productSOAPWebServicePort = productSOAPWebServiceService.getProductSOAPWebServicePort();

		// Turn off chunking so that NTLM can occur
		Client client = ClientProxy.getClient(productSOAPWebServicePort);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		AuthorizationPolicy authorizationPolicy = new AuthorizationPolicy();
		authorizationPolicy.setUserName("rest");
		authorizationPolicy.setPassword("rest");
		http.setAuthorization(authorizationPolicy);
		// HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		// httpClientPolicy.setConnectionTimeout(36000);
		// httpClientPolicy.setAllowChunking(false);
		// http.setClient(httpClientPolicy);

		Product findById = productSOAPWebServicePort.findById(13L);
		System.out.println(findById.getName());
	}
}
