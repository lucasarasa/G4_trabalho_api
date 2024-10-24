package br.com.trabalhofinal.grupoquatro.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.trabalhofinal.grupoquatro.security.entities.Categoria;

@Repository
public interface CategoriaRepository extends  JpaRepository<Categoria, Integer>{
	
	@Query(value = "select * from categoria where cat_tx_tipo = :tipo;", nativeQuery = true)
	public Categoria buscarCategoria(String tipo);
}
