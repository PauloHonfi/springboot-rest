package br.com.paulohonfi.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulohonfi.rest.model.Product;

/**
 * @author Paulo Honfi
 * Site: www.paulohonfi.com.br
 * @Since 2021-05
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findBySku(final String sku);
	
}
