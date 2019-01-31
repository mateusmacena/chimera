package br.cesed.si.chimera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cesed.si.chimera.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

}
