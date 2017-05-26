package pl.altkom.shop.cxf;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@Component
@WebService
public class ProductSOAPWebService {

	@Inject
	ProductRepo repo;

	@WebMethod
	public Product findById(@WebParam(name = "id") Long id) {
		return repo.find(id);
	}

	@WebMethod
	public Long save(@WebParam(name = "product") Product product) {
		return repo.insert(product);
	}
}