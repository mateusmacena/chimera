package br.cesed.si.chimera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.cesed.si.chimera.model.Mesas;


@Repository
public interface MesasRepository extends JpaRepository<Mesas, Integer> {

	@Modifying
	@Transactional
	@Query(value = "update mesas set status = ?1",nativeQuery = true)
	public void liberarMesas(String status);
	
	@Query(value = "SELECT status FROM mesas u WHERE u.id_mesa = ?1",nativeQuery = true)
	public String buscarStatus(Integer id);
}
