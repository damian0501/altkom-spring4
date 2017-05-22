package pl.altkom.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.altkom.shop.service.ProductService;

@Configuration
public class CoreConfig {

	@Bean
	public ProductService productService() {
		return new ProductService();
	}

}
