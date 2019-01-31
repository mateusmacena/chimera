package br.cesed.si.chimera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cesed.si.chimera.dtos.InserirPrato;
import br.cesed.si.chimera.model.Cardapio;
import br.cesed.si.chimera.repository.CardapioRepository;

@Service
public class CardapioService {

	@Autowired
	private CardapioRepository cardapioRepository;

	public void createPrato(InserirPrato prato) {

		Cardapio c = new Cardapio();
		c.setNomeitem(prato.getNomeItem());
		c.setPreco(prato.getPreco());

		cardapioRepository.save(c);
	}
	
	public List<Cardapio> readAllPrato(){
		return cardapioRepository.findAll();
	}

	public Cardapio readPrato(int id) {
		return cardapioRepository.findById(id).get();
	}

	public void updatePrato(Cardapio prato) {
		cardapioRepository.save(prato);
	}

	public void deletePrato(int id) {
		cardapioRepository.deleteById(id);
	}

}
