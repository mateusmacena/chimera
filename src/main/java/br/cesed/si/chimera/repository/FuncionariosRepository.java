package br.cesed.si.chimera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cesed.si.chimera.model.Funcionarios;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Integer> {

}
