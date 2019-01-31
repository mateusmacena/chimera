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

import br.cesed.si.chimera.dtos.InserirProduto;
import br.cesed.si.chimera.model.Estoque;
import br.cesed.si.chimera.service.EstoqueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Estoque")
@Controller
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;

	@ApiOperation(value = "Registra novo produto")
	@PostMapping("/nova")
	public ResponseEntity<Estoque> createProduto(@RequestBody InserirProduto produto) {
		estoqueService.createProduto(produto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna um produto")
	@GetMapping("/{id}")
	public ResponseEntity<Estoque> readProduto(@PathVariable(name = "id") int id) {
		return new ResponseEntity<Estoque>(estoqueService.readProduto(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna todos os produtos do estoque")
	@GetMapping("/todos")
	public ResponseEntity<List<Estoque>> readAllProduto() {
		return new ResponseEntity<List<Estoque>>(estoqueService.readAllProduto(), HttpStatus.OK);
	}

	@ApiOperation(value = "Altera registro de produto")
	@PutMapping("/atualizacao")
	public ResponseEntity<Estoque> updateProduto(@RequestBody Estoque produto) {
		estoqueService.updateProduto(produto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Exclui produto do estoque")
	@DeleteMapping("/{id}/exclusao")
	public ResponseEntity<Estoque> deleteProduto(@PathVariable(name = "id") int id) {
		estoqueService.deleteProduto(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
