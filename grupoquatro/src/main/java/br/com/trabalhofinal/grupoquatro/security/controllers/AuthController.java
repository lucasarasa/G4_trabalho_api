package br.com.trabalhofinal.grupoquatro.security.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.trabalhofinal.grupoquatro.security.dto.JwtResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.LoginRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.MessageResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.SignupRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Role;
import br.com.trabalhofinal.grupoquatro.security.entities.User;
import br.com.trabalhofinal.grupoquatro.security.enums.RoleEnum;
import br.com.trabalhofinal.grupoquatro.security.jwt.JwtUtils;
import br.com.trabalhofinal.grupoquatro.security.repositories.RoleRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.UserRepository;
import br.com.trabalhofinal.grupoquatro.security.services.FotoService;
import br.com.trabalhofinal.grupoquatro.security.services.UserDetailsImpl;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	FotoService fotoService;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponseDTO(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser(@Valid @RequestPart SignupRequestDTO signUpRequest, @RequestPart MultipartFile foto) throws IOException {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Username já utilizado!"));
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Email já utilizado!"));
//		}
//
//		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
//				encoder.encode(signUpRequest.getPassword()));
//
//		Set<String> strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		if (strRoles == null) {
//			Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
//					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
//			roles.add(userRole);
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
//							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
//					roles.add(adminRole);
//
//					break;
//				case "mod":
//					Role modRole = roleRepository.findByName(RoleEnum.ROLE_MODERATOR)
//					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
//					roles.add(modRole);
//					
//					break;
//				default:
//					Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
//							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
//					roles.add(userRole);
//				}
//			});
//		}
//
//		user.setRoles(roles);
//		userRepository.save(user);
//		fotoService.cadastrarFoto(foto, user);
//
//		return ResponseEntity.ok(new MessageResponseDTO("Usuário registrado com sucesso!"));
//	}
	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> getFoto(@PathVariable Integer id) throws Exception {
		byte[] foto = fotoService.getFoto(id);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(foto);
	}
}
