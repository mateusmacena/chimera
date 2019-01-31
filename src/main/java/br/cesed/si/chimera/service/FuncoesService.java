package br.cesed.si.chimera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cesed.si.chimera.dtos.CadastraFuncao;
import br.cesed.si.chimera.model.Funcoes;
import br.cesed.si.chimera.repository.FuncoesRepository;

@Service
public class FuncoesService {

	@Autowired
	private FuncoesRepository funcoesRepository;

	public void createFuncao(CadastraFuncao funcao) {

		Funcoes f = new Funcoes();
		f.setDescricao(funcao.getDescricao());

		funcoesRepository.save(f);
	}

	public List<Funcoes> readAllFuncao() {
		return funcoesRepository.findAll();
	}

	public Funcoes readFuncao(int id) {
		return funcoesRepository.findById(id).get();
	}

	public void updateFuncao(Funcoes funcao) {
		funcoesRepository.save(funcao);
	}

	public void deleteFuncao(int id) {
		funcoesRepository.deleteById(id);
	}

}
