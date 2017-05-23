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
	public String list(Model model, @RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam("orderBy") String orderBy) throws IOException {
		// writer.write("product/list?page=" + page + "&size=" + size +
		// "&orderBy=" + orderBy);
		model.addAttribute("page", page);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("size", size);

		List<Product> products = productService.getAll();
		model.addAttribute("productList", products);

		return "product/product-list";
	}

	/// product/12
	@RequestMapping(value = "/product/{id}")
	public void one(Writer writer, @PathVariable("id") Integer id) throws IOException {
		writer.write("product/" + id);
	}

	/*
	 * @RequestMapping(value = "/productlist") public void one(Writer writer,
	 * Req) throws IOException { List<Product> productList =
	 * productService.getAll(); req.setAttribute("productList", productList);
	 * model.addAttribute("page", page); model.addAttribute("orderBy ",
	 * orderBy);
	 * 
	 * List<Product> products = repo.getAll(); model.addAttribute("products",
	 * products);
	 * 
	 * return "product/product-list"; }
	 */
}
/*
 * 1. Informacje z poprzedniego ćwiczenia (/product/list?
 * page=1&size=20&orderBy=name) zaprezentuj na stronie JSP korzystając z wyrażeń
 * ${nazwaParanetru}. Dodaj odpowiedni plik JSP
 * /WEB-INF/pages/product/product-list.jsp (skopiuj index.jsp) oraz zwróć z
 * kontrolera identyfikator widoku „product/productlist” który pokaże
 * product/product-list.jsp 2. Pobierz listę wszystkich produktów i wyświetl je
 * w formie tabelki
 */