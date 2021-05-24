package br.com.paulohonfi.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulohonfi.rest.model.Cart;
import br.com.paulohonfi.rest.model.Product;
import br.com.paulohonfi.rest.service.CartService;
import br.com.paulohonfi.rest.service.ProductService;

/**
 * @author Paulo Honfi
 * @link www.paulohonfi.com.br
 * @Since 2021-05
 */
@RestController
@RequestMapping("/market")
public class MarketController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Endpoint para obter o carrinho; Com seu respectivo total.
	 * The getCart
	 */
	@GetMapping("/getCart")
	public Cart getCart() {
		return cartService.getCartSession();
	}
	
	/**
	 * 	Endpoint para inserir produtos no carrinho;
		Caso não exista um carrinho ele deverá criar um carrinho novo;
		Retornar as informações do carrinho junto com os produtos inseridos.
	 * @return 
	 */
	@PostMapping("/insertProductToCart")
	public Cart insertProductToCart(@RequestBody Cart cart) {
		for (Product product : cart.getProducts()) {
			product = productService.save(product);
		}
		
		return cartService.insertProductToCart(cart);
	}
	
	
	/*
	Endpoint para atualizar os produtos no carrinho;
		Podendo atualizar a quantidade que será comprado de cada produto.
		
		TODO - Erro na atualização
	*/
	
	/*
	Endpoint para limpar os produtos do carrinho;
	*/
	
	/*
	Endpoint para finalizar o carrinho;
	*/
	@GetMapping("/checkOutCart")
	public Cart checkOutCart() {
		return cartService.checkOutCart();
	}
	
	/*
	Endpoint para consultar os pedidos (Carrinhos finalizados).
		E Finalizar o carrinho.
	*/
	@GetMapping("/getConcludedCarts")
	public List<Cart> getConcludedCarts() {
		return cartService.findAllFinalized();
	}
	

}
