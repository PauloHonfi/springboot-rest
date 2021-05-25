package br.com.paulohonfi.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paulohonfi.rest.model.Cart;
import br.com.paulohonfi.rest.repository.CartRepository;
import br.com.paulohonfi.rest.type.StatusType;

/**
 * @author Paulo Honfi
 * @link www.paulohonfi.com.br
 * @Since 2021-05
 */
@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	public List<Cart> findAllFinalized() {
		return cartRepository.findAllByStatus(StatusType.FINALIZED);
	}
	
	public Cart checkOutCart(final Cart cart) {
		
		cart.setStatus(StatusType.FINALIZED);
		
		Cart persisted = cartRepository.save(cart);
		
		return persisted;
	}
	
}
