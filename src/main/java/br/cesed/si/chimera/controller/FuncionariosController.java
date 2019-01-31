package br.cesed.si.chimera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.cesed.si.chimera.dtos.CadastraFuncionario;
import br.cesed.si.chimera.model.Funcionarios;
import br.cesed.si.chimera.service.FuncionariosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Funcionario")
@Controller
@RequestMapping("/Funcionario")
public class FuncionariosController {

	@Autowired
	private FuncionariosService funcionarioService;

	@ApiOperation(value = "Registra novo funcionario")
	@PostMapping("/novo")
	public ResponseEntity<Funcionarios> createFuncionario(@RequestBody CadastraFuncionario funcionario) {
		funcionarioService.criarFuncionario(funcionario);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna funcionario")
	@GetMapping("/{id}")
	public ResponseEntity<Funcionarios> readFuncionario(@PathVariable(name = "id") int id) {
		return new ResponseEntity<Funcionarios>(funcionarioService.readFuncionario(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna todos os funcionarios")
	@GetMapping("/todos")
	public ResponseEntity<List<Funcionarios>> readAllFuncionarios() {
		return new ResponseEntity<List<Funcionarios>>(funcionarioService.readAllFuncionarios(), HttpStatus.OK);
	}

	@ApiOperation(value = "Altera registro do funcionario")
	@PutMapping("/atualizacao")
	public ResponseEntity<Funcionarios> updateFuncionario(@RequestBody Funcionarios funcionario) {
		funcionarioService.updateFuncionario(funcionario);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Exclui registro do funcionario")
	@DeleteMapping("/{id}/exclusao")
	public ResponseEntity<Funcionarios> deleteFuncionario(@PathVariable(name = "id") int id) {
		funcionarioService.deleteFuncionario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
