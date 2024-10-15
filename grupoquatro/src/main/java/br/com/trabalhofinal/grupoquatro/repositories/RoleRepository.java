package br.com.trabalhofinal.grupoquatro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.entities.Role;
import com.loja.security.enums.RoleEnum;

@Repository("role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleEnum name);
}