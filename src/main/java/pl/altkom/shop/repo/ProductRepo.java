package pl.altkom.shop.repo;

import java.util.Collection;

import pl.altkom.shop.model.Product;

public interface ProductRepo {

	public Collection<Product> getAllProducts();

	public Product getProductById(Long id);

	public Long addProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Long id);
}
