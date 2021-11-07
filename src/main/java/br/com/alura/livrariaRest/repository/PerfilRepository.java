package br.com.alura.livrariaRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.livrariaRest.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{

}
