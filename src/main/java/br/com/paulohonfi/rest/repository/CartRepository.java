package br.com.paulohonfi.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paulohonfi.rest.model.Cart;
import br.com.paulohonfi.rest.type.StatusType;

/**
 * @author Paulo Honfi
 * Site: www.paulohonfi.com.br
 * @Since 2021-05
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	public Cart findByStatus(final StatusType status);
	
	public List<Cart> findAllByStatus(final StatusType status);

}
