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

import br.cesed.si.chimera.dtos.CadastrarMesa;
import br.cesed.si.chimera.model.Mesas;
import br.cesed.si.chimera.service.MesasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Mesas")
@Controller
@RequestMapping("/mesa")
public class MesasController {

	@Autowired
	private MesasService mesasService;

	@ApiOperation(value = "Inseri nova mesa")
	@PostMapping("/novo")
	public ResponseEntity<CadastrarMesa> createMesa(@RequestBody CadastrarMesa mesa) {
		mesasService.createMesa(mesa);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Retorna informação da mesa")
	@GetMapping("/{id}")
	public ResponseEntity<Mesas> readMesa(@PathVariable(name = "id") int id) {
		return new ResponseEntity<Mesas>(mesasService.readMesa(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna todas as mesas")
	@GetMapping("/todos")
	public ResponseEntity<List<Mesas>> readAllMesas() {
		return new ResponseEntity<List<Mesas>>(mesasService.readAllMesas(), HttpStatus.OK);
	}

	@ApiOperation(value = "Exclui uma mesa")
	@DeleteMapping("/{id}/exclusao")
	public ResponseEntity<Mesas> deleteMesas(@PathVariable(name = "id") int id) {
		mesasService.deleteMesa(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Liberar mesas")
	@PutMapping("/livre")
	public ResponseEntity<Mesas> liberarMesas() {
		mesasService.liberarMesas();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Alterar status da mesa")
	@PutMapping("/{id}/alteracao")
	public ResponseEntity<Mesas> alterarStatusMesa(@PathVariable(name = "id") int id) {
		mesasService.alterarStatusMesa(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
