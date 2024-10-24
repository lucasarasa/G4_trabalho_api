package br.com.trabalhofinal.grupoquatro.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.trabalhofinal.grupoquatro.security.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	@Query(value = "select * from endereco where cep = :cep;", nativeQuery = true)
	public Endereco buscarEndereco(String cep);
	
	@Query(value = "select * from endereco where cep = :cep;", nativeQuery = true)
	public Optional<Endereco> existsByCep(String cep);
	
	@Query(value="select * from Endereco limit 1", nativeQuery =true)
	public Endereco buscarEnderecoUnico();
	
}
