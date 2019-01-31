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

import br.cesed.si.chimera.dtos.InserirPrato;
import br.cesed.si.chimera.model.Cardapio;
import br.cesed.si.chimera.service.CardapioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Cardapio")
@Controller
@RequestMapping("/cardapio")
public class CardapioController {

	@Autowired
	private CardapioService cardapioService;

	@ApiOperation(value = "Cadastra novo prato")
	@PostMapping("/novo")
	public ResponseEntity<Cardapio> createPrato(@RequestBody InserirPrato prato) {
		cardapioService.createPrato(prato);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Retorna um prato")
	@GetMapping("/{id}")
	public ResponseEntity<Cardapio> readPrato(@PathVariable(name = "id") int id) {
		return new ResponseEntity<Cardapio>(cardapioService.readPrato(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna todos os pratos do cardapio")
	@GetMapping("/todos")
	public ResponseEntity<List<Cardapio>> readAllPratos() {
		return new ResponseEntity<List<Cardapio>>(cardapioService.readAllPrato(), HttpStatus.OK);
	}

	@ApiOperation(value = "Altera um prato")
	@PutMapping("/atualizacao")
	public ResponseEntity<Cardapio> updatePrato(@RequestBody Cardapio prato) {
		cardapioService.updatePrato(prato);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Exclui um prato")
	@DeleteMapping("/{id}/exclusao")
	public ResponseEntity<Cardapio> deletePrato(@PathVariable(name = "id") int id) {
		cardapioService.deletePrato(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
