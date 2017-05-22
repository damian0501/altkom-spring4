package pl.altkom.shop.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import pl.altkom.shop.model.Product;

@Repository
public class InMemoryProductRepo implements ProductRepo {

	private Map<Long, Product> map = new HashMap<>();

	@Value(value = "classpath:img/cos.png")
	Resource resource;

	@PostConstruct
	void init() {
		System.out.println("Add product: " + addProduct(new Product("Produkt 1")));
		System.out.println("Add product: " + addProduct(new Product("Produkt 2")));
	}

	@Override
	public Collection<Product> getAllProducts() {
		return map.values();
	}

	@Override
	public Product getProductById(Long id) {
		return map.get(id);
	}

	@Override
	public Long addProduct(Product product) {
		product.setId(map.size() + 1L);
		map.put(product.getId(), product);
		return product.getId();
	}

	@Override
	public void updateProduct(Product product) {
		map.put(product.getId(), product);
	}

	@Override
	public void deleteProduct(Long id) {
		map.remove(id);
	}
}
