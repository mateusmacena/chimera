package br.cesed.si.chimera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cesed.si.chimera.dtos.CadastraFuncionario;
import br.cesed.si.chimera.model.Funcionarios;
import br.cesed.si.chimera.repository.FuncionariosRepository;

@Service
public class FuncionariosService {

	@Autowired
	private FuncionariosRepository funcionariosRepository;

	public void criarFuncionario(CadastraFuncionario funcionario) {

		Funcionarios f = new Funcionarios();
		f.setNome(funcionario.getNome());
		f.setCpf(funcionario.getCpf());
		f.setTelefone(funcionario.getTelefone());
		f.setEmail(funcionario.getEmail());
		f.setEndereco(funcionario.getEndereco());
		f.setSalario(funcionario.getSalario());
		f.setFuncao(funcionario.getFuncao());
		f.setDataFuncionarioContratado(java.time.LocalDate.now());

		funcionariosRepository.save(f);
	}
	
	public List<Funcionarios> readAllFuncionarios(){
		return funcionariosRepository.findAll();
	}

	public Funcionarios readFuncionario(int id) {
		return funcionariosRepository.findById(id).get();
	}

	public void updateFuncionario(Funcionarios funcionario) {
		funcionariosRepository.save(funcionario);
	}

	public void deleteFuncionario(int id) {
		funcionariosRepository.deleteById(id);
	}

}
