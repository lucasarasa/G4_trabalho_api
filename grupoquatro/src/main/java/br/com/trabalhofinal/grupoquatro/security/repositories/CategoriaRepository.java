package br.com.trabalhofinal.grupoquatro.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.trabalhofinal.grupoquatro.security.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	@Query(value = "select * from categoria where nome = :nome;", nativeQuery = true)
	public Categoria buscarCategoria(String nome);

}
