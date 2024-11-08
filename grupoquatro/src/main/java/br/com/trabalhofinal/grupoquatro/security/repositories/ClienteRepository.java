package br.com.trabalhofinal.grupoquatro.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.trabalhofinal.grupoquatro.security.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query(value = "select * from cliente where cli_cd_id = :id;", nativeQuery = true)
	public Cliente buscarCliente(Integer id);
}