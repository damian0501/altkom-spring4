package pl.altkom.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

public class ProductService {
	@Autowired
	private ProductRepo repo;

	public List<Product> getAll() {
		return repo.getAll();
	}

}
