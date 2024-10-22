package br.com.trabalhofinal.grupoquatro.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.trabalhofinal.grupoquatro.security.entities.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer>{

}
