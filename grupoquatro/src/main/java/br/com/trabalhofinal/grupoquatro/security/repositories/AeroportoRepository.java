package br.com.trabalhofinal.grupoquatro.security.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.trabalhofinal.grupoquatro.security.entities.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer>{

	@Query(value="select * from aeroporto limit 1", nativeQuery=true)
	public Aeroporto buscarAeroporto();
	
}
