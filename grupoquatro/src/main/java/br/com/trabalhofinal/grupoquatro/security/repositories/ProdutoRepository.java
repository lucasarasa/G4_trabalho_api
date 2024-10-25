package br.com.trabalhofinal.grupoquatro.security.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.trabalhofinal.grupoquatro.security.entities.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer>  {

	@Query(value = "select * from produto where pro_cd_id in (:ids)", nativeQuery = true)
	public Set<Produto> retornaLista(Set<Integer> ids);
}
