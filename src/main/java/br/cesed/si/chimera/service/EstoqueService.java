package br.cesed.si.chimera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cesed.si.chimera.dtos.InserirProduto;
import br.cesed.si.chimera.model.Estoque;
import br.cesed.si.chimera.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;

	public void createProduto(InserirProduto produto) {

		Estoque e = new Estoque();
		e.setNome(produto.getNome());
		e.setQuantidade(produto.getQuantidade());
		e.setValidade(produto.getValidate());
		e.setValor(produto.getValor());

		estoqueRepository.save(e);
	}
	
	public List<Estoque> readAllProduto(){
		return estoqueRepository.findAll();
	}

	public Estoque readProduto(int id) {
		return estoqueRepository.findById(id).get();
	}

	public void updateProduto(Estoque produto) {
		estoqueRepository.save(produto);
	}

	public void deleteProduto(int id) {
		estoqueRepository.deleteById(id);
	}

}
