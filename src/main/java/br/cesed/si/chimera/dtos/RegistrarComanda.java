package br.cesed.si.chimera.dtos;

public class RegistrarComanda {

	private Integer numeroDaMesa;

	private String produtoPedido;

	private Integer quantidade;

	public Integer getNumeroDaMesa() {
		return numeroDaMesa;
	}

	public void setNumeroDaMesa(Integer numeroDaMesa) {
		this.numeroDaMesa = numeroDaMesa;
	}

	public String getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(String produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDaMesa == null) ? 0 : numeroDaMesa.hashCode());
		result = prime * result + ((produtoPedido == null) ? 0 : produtoPedido.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrarComanda other = (RegistrarComanda) obj;
		if (numeroDaMesa == null) {
			if (other.numeroDaMesa != null)
				return false;
		} else if (!numeroDaMesa.equals(other.numeroDaMesa))
			return false;
		if (produtoPedido == null) {
			if (other.produtoPedido != null)
				return false;
		} else if (!produtoPedido.equals(other.produtoPedido))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		return true;
	}

}
