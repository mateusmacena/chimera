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

import br.cesed.si.chimera.dtos.RegistrarComanda;
import br.cesed.si.chimera.model.Comanda;
import br.cesed.si.chimera.service.ComandaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Comanda")
@Controller
@RequestMapping("/comanda")
public class ComandaController {

	@Autowired
	private ComandaService comandaService;

	@ApiOperation(value = "Cria uma nova comanda")
	@PostMapping("/nova")
	public ResponseEntity<Comanda> createComanda(@RequestBody RegistrarComanda comanda) {
		comandaService.createComanda(comanda);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Retorna uma comanda")
	@GetMapping("/{id}")
	public ResponseEntity<Comanda> readComanda(@PathVariable(name = "id") int id) {
		return new ResponseEntity<Comanda>(comandaService.readComanda(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna todas as comandas")
	@GetMapping("/todos")
	public ResponseEntity<List<Comanda>> readAllComanda() {
		return new ResponseEntity<List<Comanda>>(comandaService.readAllComanda(), HttpStatus.OK);
	}

	@ApiOperation(value = "Atualiza uma comanda")
	@PutMapping("/atualizacao")
	public ResponseEntity<Comanda> updateComanda(@RequestBody Comanda comanda) {
		comandaService.updateComanda(comanda);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Deleta uma comanda")
	@DeleteMapping("/{id}/exclusao")
	public ResponseEntity<Comanda> deleteComanda(@PathVariable(name = "id") int id) {
		comandaService.deleteComanda(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
