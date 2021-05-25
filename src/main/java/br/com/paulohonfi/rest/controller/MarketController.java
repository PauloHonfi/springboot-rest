package br.com.paulohonfi.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	 */
	@GetMapping("/getCart")
	public Cart getCart(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		
		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());  
		}
        
		return (Cart) session.getAttribute("cart");
	}
	
	/**
	 * 	Insere produtos no carrinho. Caso não exista um carrinho será criado um novo
	 * @return informações do carrinho junto com os produtos inseridos.
	 */
	@PostMapping("/insertProductToCart")
	public Cart insertProductToCart(HttpServletRequest request, @RequestBody Cart cart) {
		if(request.getSession().getAttribute("cart") == null) {
			request.getSession().setAttribute("cart", new Cart());  
		}

		final Cart cartSession = (Cart) request.getSession().getAttribute("cart");
		
		cartSession.setProducts(new ArrayList<Product>());
		
		for (Product product : cart.getProducts()) {
			product = productService.save(product);
			cartSession.getProducts().add(product);
		}
		
		request.getSession().setAttribute("cart", cartSession);
		
		return cartSession;
	}
	
	
	/**
	 * Atualiza os produtos no carrinho; Podendo atualizar a quantidade que será comprado de cada produto.
	 */
	@PostMapping("/updateCart")
	public Cart updateCart(HttpServletRequest request, @RequestBody Cart cart) {
		final Cart cartSession = (Cart) request.getSession().getAttribute("cart");
		
		cartSession.setProducts(new ArrayList<Product>());
		
		for (Product product : cart.getProducts()) {
			product = productService.save(product);
			cartSession.getProducts().add(product);
		}
		
		request.getSession().setAttribute("cart", cartSession);
		
		return cartSession;
	}
	
	
	/**
	 * Limpar todos os produtos do carrinho
	 */
	@GetMapping("/clearCart")
	public Cart clearCart(HttpServletRequest request) {
		final Cart cartSession = (Cart) request.getSession().getAttribute("cart");
		
		cartSession.setProducts(new ArrayList<Product>());
		
		request.getSession().setAttribute("cart", cartSession);
		
		return cartSession;
	}
	
	/**
	 * Finaliza o carrinho do usuário logado
	 */
	@GetMapping("/checkOutCart")
	public Cart checkOutCart(HttpServletRequest request) {
		final Cart cartSession = (Cart) request.getSession().getAttribute("cart");
		request.getSession().setAttribute("cart", null);
		
		return cartService.checkOutCart(cartSession);
	}
	
	/**
	 * Consultar os pedidos já concluidos (Carrinhos finalizados).
	 */
	@GetMapping("/getConcludedCarts")
	public List<Cart> getConcludedCarts() {
		return cartService.findAllFinalized();
	}
	

}
