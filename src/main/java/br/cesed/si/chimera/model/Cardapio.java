package br.cesed.si.chimera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cardapio")
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_item")
	private Integer idItem;

	@Column(name = "nome_item")
	private String nomeitem;

	private double preco;

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getNomeitem() {
		return nomeitem;
	}

	public void setNomeitem(String nomeitem) {
		this.nomeitem = nomeitem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
		result = prime * result + ((nomeitem == null) ? 0 : nomeitem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Cardapio other = (Cardapio) obj;
		if (idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!idItem.equals(other.idItem))
			return false;
		if (nomeitem == null) {
			if (other.nomeitem != null)
				return false;
		} else if (!nomeitem.equals(other.nomeitem))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

}
