package pl.altkom.shop.controller;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value = "/home")
	public void hello(Writer writer) throws IOException {
		writer.write("Hello World");
	}
}
