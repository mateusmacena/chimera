package br.cesed.si.chimera.dtos;

public class CadastrarMesa {
	
	private int idMesa;

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMesa;
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
		CadastrarMesa other = (CadastrarMesa) obj;
		if (idMesa != other.idMesa)
			return false;
		return true;
	}
	
	

}
