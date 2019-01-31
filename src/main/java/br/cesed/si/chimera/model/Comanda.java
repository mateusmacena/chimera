package br.cesed.si.chimera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ControleDeComanda")
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_comanda")
	private Integer idcomanda;

	@Column(name = "numero_mesa")
	private Integer numeroDaMesa;

	@Column(name = "produto_pedido")
	private String produtoPedido;

	private Integer quantidade;

	public Integer getIdcomanda() {
		return idcomanda;
	}

	public void setIdcomanda(int idcomanda) {
		this.idcomanda = idcomanda;
	}

	public Integer getNumeroDaMesa() {
		return numeroDaMesa;
	}

	public void setNumeroDaMesa(int numeroDaMesa) {
		this.numeroDaMesa = numeroDaMesa;
	}

	public String getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(String produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

	public Integer getQuantidadeProdutoPedido() {
		return quantidade;
	}

	public void setQuantidadeProdutoPedido(int quantidadeProdutoPedido) {
		this.quantidade = quantidadeProdutoPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcomanda == null) ? 0 : idcomanda.hashCode());
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
		Comanda other = (Comanda) obj;
		if (idcomanda == null) {
			if (other.idcomanda != null)
				return false;
		} else if (!idcomanda.equals(other.idcomanda))
			return false;
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
