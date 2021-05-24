package br.com.paulohonfi.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paulohonfi.rest.model.Cart;
import br.com.paulohonfi.rest.model.Product;
import br.com.paulohonfi.rest.repository.CartRepository;
import br.com.paulohonfi.rest.type.StatusType;

/**
 * @author Paulo Honfi
 * @link www.paulohonfi.com.br
 * @Since 2021-05
 */
@Service
public class CartService {
	
	private static Cart cartSession; 
	
	@Autowired
	private CartRepository cartRepository;
	
	public Cart getCartSession() {
		if (cartSession != null) {
			this.calculateAmountProductsPrice(cartSession);
		}
		
		return cartSession;
	}

	public List<Cart> findAllFinalized() {
		return cartRepository.findAllByStatus(StatusType.FINALIZED);
	}
	
	public Cart insertProductToCart(final Cart cart) {
		
		if(cart.getId() == null) {
			cartSession = new Cart();
			cartSession.setStatus(StatusType.ACTIVE);
			cartSession.setProducts(new ArrayList<Product>());
		}
		
		cartSession.getProducts().addAll(cart.getProducts());
		
		this.calculateAmountProductsPrice(cartSession);
		Cart persisted = cartRepository.save(cartSession);
		
		return persisted;
	}
	
	public Cart checkOutCart() {
		
		cartSession = null;

		Cart activeCart = cartRepository.findByStatus(StatusType.ACTIVE);
		activeCart.setStatus(StatusType.FINALIZED);
		
		Cart persisted = cartRepository.save(activeCart);
		
		return persisted;
	}

	
	/**
	 * The calculateAmountProductsPrice
	 */
	private void calculateAmountProductsPrice(final Cart cart) {
		cart.setTotal((double) 0);
		for (Product product : cart.getProducts()) {
			cart.setTotal(cart.getTotal() + product.getPrice());
		}
	}


}
