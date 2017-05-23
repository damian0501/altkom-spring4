package pl.altkom.shop.service;

import java.util.ArrayList;
import java.util.Collections;
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

	public Long insert(Product product) {
		return repo.insert(product);
	}

	Long count() {
		return repo.count();
	}

	public void delete(Long id) {
		repo.delete(id);
	}

	public Product find(Long id) {
		return repo.find(id);
	}

	public void update(Product product) {
		repo.update(product);
	}

	public List<Product> sortProducts(List<Product> products, String sortBy) {
		if ("ID".equals(sortBy)) {
			Collections.sort(products, (p1, p2) -> p1.getId().compareTo(p2.getId()));
		} else if ("NAME".equals(sortBy)) {
			Collections.sort(products, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		} else if ("DESCRIPTION".equals(sortBy)) {
			Collections.sort(products, (p1, p2) -> p1.getDescription().compareTo(p2.getDescription()));
		} else if ("QUANTITY".equals(sortBy)) {
			Collections.sort(products, (p1, p2) -> p1.getQuantity().compareTo(p2.getQuantity()));
		} else if ("PRICE".equals(sortBy)) {
			Collections.sort(products, (p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));
		}
		return products;

	}

	public List<Product> queryProducts(List<Product> products, String query) {
		List<Product> result = new ArrayList<>();
		for (Product product : products) {
			if (product.getName().contains(query)) {
				result.add(product);
			}

		}
		return result;

	}

}
