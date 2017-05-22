package pl.altkom.shop;

import java.util.Collection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.service.ProductService;

public class Runner {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoreConfig.class);
		ProductService productService = (ProductService) context.getBean("productService");
		System.out.println(productService);
		Collection<Product> allProducts = productService.getProductRepo().getAllProducts();
		for (Product product : allProducts) {
			System.out.println(product);
		}
	}

}
