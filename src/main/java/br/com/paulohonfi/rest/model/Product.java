package br.com.paulohonfi.rest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Paulo Honfi
 * Site: www.paulohonfi.com.br
 * @Since 2021-05
 */
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 7945060284398978293L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sku;

	private String name;

	private int quantityStock;

	private Boolean stock;

	private Double price;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantityStock
	 */
	public int getQuantityStock() {
		return quantityStock;
	}

	/**
	 * @param quantityStock the quantityStock to set
	 */
	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

	/**
	 * @return the stock
	 */
	public Boolean getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Boolean stock) {
		this.stock = stock;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

}
