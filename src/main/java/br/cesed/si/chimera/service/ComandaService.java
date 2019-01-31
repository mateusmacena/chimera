package br.cesed.si.chimera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cesed.si.chimera.dtos.RegistrarComanda;
import br.cesed.si.chimera.model.Comanda;
import br.cesed.si.chimera.repository.ComandaRepository;

@Service
public class ComandaService {

	@Autowired
	private ComandaRepository comandaRepository;

	public void createComanda(RegistrarComanda comanda) {

		Comanda c = new Comanda();
		c.setNumeroDaMesa(comanda.getNumeroDaMesa());
		c.setProdutoPedido(comanda.getProdutoPedido());
		c.setQuantidadeProdutoPedido(comanda.getQuantidade());

		comandaRepository.save(c);
	}
	
	public List<Comanda> readAllComanda(){
		return comandaRepository.findAll();
	}

	public Comanda readComanda(int id) {
		return comandaRepository.findById(id).get();
	}

	public void updateComanda(Comanda comanda) {
		comandaRepository.save(comanda);
	}

	public void deleteComanda(int id) {
		comandaRepository.deleteById(id);
	}
}
