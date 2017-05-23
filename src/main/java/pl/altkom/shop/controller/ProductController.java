package pl.altkom.shop.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.service.ProductService;

@Controller
public class ProductController {

	@Inject
	ProductService productService;

	/// product/list?page=1&size=20&orderBy=name
	@RequestMapping(value = "/product/list")
	public String list(Model model, @RequestParam(required = false, value = "page") Integer page,
			@RequestParam(required = false, value = "size") Integer size,
			@RequestParam(required = false, value = "orderBy") String orderBy) throws IOException {
		// writer.write("product/list?page=" + page + "&size=" + size +
		// "&orderBy=" + orderBy);
		model.addAttribute("page", page);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("size", size);

		List<Product> products = productService.getAll();
		if (orderBy != null && !orderBy.isEmpty()) {
			productService.sortProducts(products, orderBy);
		}
		model.addAttribute("productList", products);

		return "product/product-list";
	}

	/// product/12
	@RequestMapping(value = "/product/{id}")
	public void find(Writer writer, @PathVariable("id") Long id) throws IOException {
		writer.write("product/" + id);
	}

	@RequestMapping(value = "/product/{id}/delete")
	public String delete(Model model, @PathVariable("id") Long id) throws IOException {
		productService.delete(id);
		return "redirect:/product/list";
	}

}