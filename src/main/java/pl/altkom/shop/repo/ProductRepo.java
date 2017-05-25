package pl.altkom.shop.repo;

import java.util.List;

import pl.altkom.shop.model.Product;

public interface ProductRepo {
	// @Secured("ROLE_ADMIN")
	public Long insert(Product product);

	Long count();

	public void delete(Long id);

	public Product find(Long id);

	// @Secured("ROLE_ADMIN")
	// @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void update(Product product);

	// @Monitoring
	// @PreAuthorize("hasAnyRole('ROLE_USER')")
	public List<Product> getAll();
}
