package br.com.paulohonfi.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulohonfi.rest.model.Product;
import br.com.paulohonfi.rest.service.ProductService;

/**
 * @author Paulo Honfi
 * Site: www.paulohonfi.com.br
 * @Since 2021-05
 */
@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@PostMapping("/insert")
	public Product insertProduct(@RequestBody final Product product) {
		return service.save(product);
		
	}

}
