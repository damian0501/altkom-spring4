package pl.altkom.shop.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.altkom.shop.service.DocumentRequest;
import pl.altkom.shop.service.SaleDocumentService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Inject
	SaleDocumentService service;

	@RequestMapping
	public String list(Model model) throws Exception {
		return "cart";
	}

	@RequestMapping("/process")
	@ResponseBody
	public Long createSaleDocument(@RequestBody DocumentRequest request) throws Exception {
		return service.insert(request);
	}

}