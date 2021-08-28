package br.com.paulohonfi.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paulohonfi.rest.model.Product;
import br.com.paulohonfi.rest.repository.ProductRepository;

/**
 * @author Paulo Honfi
 * Site: www.paulohonfi.com.br
 * @Since 2021-05
 */
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product findBysku(final String sku) {
		return productRepository.findBySku(sku);
	}

	public Product save(final Product product) {
		Product result = productRepository.findBySku(product.getSku());
		
		if(result == null) {
			result = productRepository.save(product);
		} else {
			productRepository.delete(result);
			result.setQuantityStock(result.getQuantityStock() - 1);
			result = productRepository.save(result);
		}
		
		return result;
	}

}
