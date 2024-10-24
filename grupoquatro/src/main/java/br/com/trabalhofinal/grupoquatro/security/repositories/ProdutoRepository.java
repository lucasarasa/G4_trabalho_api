package br.com.trabalhofinal.grupoquatro.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalhofinal.grupoquatro.security.entities.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer>  {

}
