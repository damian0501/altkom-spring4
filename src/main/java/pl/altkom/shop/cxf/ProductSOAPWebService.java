package pl.altkom.shop.cxf;

import javax.jws.WebParam;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

//@Component
//@WebService
public class ProductSOAPWebService {

	// @Inject
	ProductRepo repo;

	// @WebMethod
	public Product findById(@WebParam(name = "id") Long id) {
		return repo.find(id);
	}
}