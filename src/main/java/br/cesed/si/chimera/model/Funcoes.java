package br.cesed.si.chimera.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcoes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idFuncao;

	private String descricao;

	public Integer getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(int idFuncao) {
		this.idFuncao = idFuncao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idFuncao == null) ? 0 : idFuncao.hashCode());
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
		Funcoes other = (Funcoes) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idFuncao == null) {
			if (other.idFuncao != null)
				return false;
		} else if (!idFuncao.equals(other.idFuncao))
			return false;
		return true;
	}

}
