package br.com.trabalhofinal.grupoquatro.security.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioRequestUpdateDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioResponseIdDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Funcionario;
import br.com.trabalhofinal.grupoquatro.security.entities.Role;
import br.com.trabalhofinal.grupoquatro.security.entities.User;
import br.com.trabalhofinal.grupoquatro.security.enums.RoleEnum;
import br.com.trabalhofinal.grupoquatro.security.repositories.FuncionarioRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.RoleRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.UserRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	
	public FuncionarioResponseDTO cadastrarFuncionario(FuncionarioRequestDTO funcionario) {
		FuncionarioResponseDTO newFuncionario = new FuncionarioResponseDTO();
		newFuncionario.setNome(funcionario.getNome());
		newFuncionario.setCpf(funcionario.getCpf());
		newFuncionario.setTelefone(funcionario.getTelefone());
		newFuncionario.setEmail(funcionario.getEmail());
		newFuncionario.setCargo(funcionario.getCargo());
		
		User usuario = new User(funcionario.getUsername(), funcionario.getEmail(),
				encoder.encode(funcionario.getPassword()));

		Set<String> strRoles = funcionario.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(RoleEnum.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(userRole);
				}

			});
		}
		usuario.setRoles(roles);
		userRepository.save(usuario);
		

		Funcionario funcionarioConvert = newFuncionario.toFuncionario();
		funcionarioConvert.setFkUser(usuario);
		funcionarioRepository.save(funcionarioConvert);
		return newFuncionario;
		
		
	}
	
	public FuncionarioResponseDTO atualizarFuncionario(Integer id, FuncionarioRequestUpdateDTO funcionarioDTO) {
	    Funcionario funcionarioOptional = funcionarioRepository.findById(id).orElse(null);
	    if(funcionarioDTO.getTelefone() != null) {
	    funcionarioOptional.setTelefone(funcionarioDTO.getTelefone());
	    }
	    if(funcionarioDTO.getEmail() != null) {
	    funcionarioOptional.getFkUser().setEmail(funcionarioDTO.getEmail());
	    }
	    if(funcionarioDTO.getCargo() != null) {
	    funcionarioOptional.setCargo(funcionarioDTO.getCargo());
	    }
	    if(funcionarioDTO.getUsername() != null) {
	    funcionarioOptional.getFkUser().setUsername(funcionarioDTO.getUsername());
	    }
	    if(funcionarioDTO.getPassword() != null) {
	    funcionarioOptional.getFkUser().setPassword(funcionarioDTO.getPassword());
	    }
	    
	    funcionarioRepository.save(funcionarioOptional);
	    FuncionarioResponseDTO requestDTO = new FuncionarioResponseDTO(funcionarioOptional);

	    return requestDTO;

	}

}
