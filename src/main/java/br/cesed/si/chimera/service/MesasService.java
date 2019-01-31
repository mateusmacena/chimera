package br.cesed.si.chimera.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cesed.si.chimera.dtos.CadastrarMesa;
import br.cesed.si.chimera.model.Mesas;
import br.cesed.si.chimera.repository.MesasRepository;

@Service
public class MesasService {

	@Autowired
	private MesasRepository mesasRepository;

	public void createMesa(CadastrarMesa mesa) {
		Mesas m = new Mesas();
		m.setIdMesa(mesa.getIdMesa());
		m.setStatus("livre");
		mesasRepository.save(m);
	}

	public Mesas readMesa(int id) {
		return mesasRepository.findById(id).get();
	}

	public List<Mesas> readAllMesas() {
		return mesasRepository.findAll();
	}

	public void updateMesa(Mesas mesa) {
		mesasRepository.save(mesa);
	}

	public void deleteMesa(int id) {
		mesasRepository.deleteById(id);
	}

	public void liberarMesas() {
		mesasRepository.liberarMesas("livre");
	}

	@Transactional
	public void alterarStatusMesa(int id) {
		Mesas m = new Mesas();
		String n = mesasRepository.buscarStatus(id);
		if (n.equals("em uso")) {
			m.setIdMesa(id);
			m.setStatus("livre");
		} else {
			m.setIdMesa(id);
			m.setStatus("em uso");
		}
		mesasRepository.save(m);
	}
}
