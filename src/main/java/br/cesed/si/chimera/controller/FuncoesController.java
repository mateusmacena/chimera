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

import br.cesed.si.chimera.dtos.CadastraFuncao;
import br.cesed.si.chimera.model.Funcoes;
import br.cesed.si.chimera.service.FuncoesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value= "API REST Funcoes")
@Controller
@RequestMapping("/funcao")
public class FuncoesController {
	
	@Autowired
	private FuncoesService funcoesService;
	
	@ApiOperation(value = "Insere uma funcao")
	@PostMapping("/novo")
	public ResponseEntity<Funcoes> createFuncao(@RequestBody CadastraFuncao funcao){
		funcoesService.createFuncao(funcao);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Retorna todas as funcoes")
	@GetMapping("/todos")
	public ResponseEntity<List<Funcoes>> readAllFuncao(){
		return new ResponseEntity<List<Funcoes>>(funcoesService.readAllFuncao(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retorna uma funcao")
	@GetMapping(path = "/{id}")
	public ResponseEntity<Funcoes> readFuncao(@PathVariable(name = "id") int id){
		return new ResponseEntity<Funcoes>(funcoesService.readFuncao(id),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Altera uma funcao")
	@PutMapping("/atualizacao")
	public ResponseEntity<Funcoes> updateFuncao(@RequestBody Funcoes funcao){
		funcoesService.updateFuncao(funcao);
		return new ResponseEntity<Funcoes>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Exclue uma funcao")
	@DeleteMapping("/{id}/exclusao")
	public ResponseEntity<Funcoes> deleteFuncao(@PathVariable(name = "id") int id){
		funcoesService.deleteFuncao(id);
		return new ResponseEntity<Funcoes>(HttpStatus.OK);
	}

}
