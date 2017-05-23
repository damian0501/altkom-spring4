package pl.altkom.shop.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
			@RequestParam(required = false, value = "orderBy") String orderBy,
			@RequestParam(required = false, value = "order") String order,
			@RequestParam(required = false, value = "query") String query) throws IOException {
		// writer.write("product/list?page=" + page + "&size=" + size +
		// "&orderBy=" + orderBy);
		model.addAttribute("page", page);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("size", size);

		List<Product> products = productService.getAll();
		if (query != null && !query.isEmpty()) {
			products = products.stream().filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()))
					.collect(Collectors.toList());
		}
		/*
		 * if (query != null && !query.isEmpty()) { products =
		 * productService.queryProducts(products, query); }
		 */
		if (orderBy != null && !orderBy.isEmpty()) {
			productService.sortProducts(products, orderBy, order);
		}
		model.addAttribute("productList", products);
		model.addAttribute("newProduct", new Product());
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

	@RequestMapping(value = "/product/new2", method = RequestMethod.GET)
	public String setupProductForm(Model model) {
		model.addAttribute("newProduct", new Product());
		return "redirect:/product/list";
	}

	@RequestMapping(value = "/product/save2", method = RequestMethod.POST)
	public String processProductForm(@ModelAttribute Product newProduct) {
		productService.insert(newProduct);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "/product/new", method = RequestMethod.GET)
	public String prepareForm(Model model) throws Exception {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product/product-form";
	}

	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute Product product) throws Exception {
		Product oldProduct = null;
		if (product.getId() != null) {
			oldProduct = productService.find(product.getId());
		}
		if (oldProduct == null) {
			productService.insert(product);
		} else {
			productService.update(product);
		}
		return "redirect:/product/list";
	}

	@RequestMapping(value = "/product/{id}/edit", method = RequestMethod.GET)
	public String editForm(Model model, @PathVariable("id") Long id) throws Exception {
		Product product = productService.find(id);
		model.addAttribute("product", product);
		return "product/product-form";
	}

}