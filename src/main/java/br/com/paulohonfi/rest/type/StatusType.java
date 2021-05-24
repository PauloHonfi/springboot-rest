package br.com.paulohonfi.rest.type;

/**
 * @author Paulo Honfi
 * @link www.paulohonfi.com.br
 * @Since 2021-05
 */
public enum StatusType {
	
	ACTIVE("Aberto"),
	FINALIZED("Finalizado");
	
	private String description;
	
	private StatusType(final String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}
