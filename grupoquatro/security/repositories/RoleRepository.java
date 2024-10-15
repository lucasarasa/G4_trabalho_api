package br.com.example.cineMaster.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.cineMaster.security.entities.Role;
import br.com.example.cineMaster.security.enums.RoleEnum;



@Repository("role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleEnum name);
}