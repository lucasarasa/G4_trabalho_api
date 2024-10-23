package br.com.trabalhofinal.grupoquatro.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import br.com.trabalhofinal.grupoquatro.security.dto.ClienteRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ClienteResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Cliente;
import br.com.trabalhofinal.grupoquatro.security.entities.User;
import br.com.trabalhofinal.grupoquatro.security.repositories.ClienteRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.UserRepository;

@Service
public class ClienteService {

	@Autowired
    PasswordEncoder encoder;
	
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	UserRepository userRepository;
	
	public Cliente adicionarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public ClienteResponseDTO adicionarCliente(ClienteRequestDTO clienteDto) {
		ClienteResponseDTO cliente = new ClienteResponseDTO();
		cliente.setNome(clienteDto.getNome());
		cliente.setCpf(clienteDto.getCpf());
		cliente.setCartao(clienteDto.getCartao());
		cliente.setDataNascimento(clienteDto.getDataNascimento());
		cliente.setTelefone(clienteDto.getTelefone());
		
		User usuario = new User(clienteDto.getUsername(), clienteDto.getEmail(), encoder.encode(clienteDto.getPassword()));
		
		userRepository.save(usuario);
		Cliente clienteConvert = cliente.toCliente();
		clienteConvert.setFkUser(usuario);
		clienteRepository.save(clienteConvert);
		return cliente;
	}

	public Optional<Cliente> buscarPorId(Integer id) {
		return clienteRepository.findById(id);
	}

	public boolean clienteDelete(Integer id) {
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public String atualizarCliente(Integer id, ClienteRequestDTO clienteDto) {
		if(!clienteRepository.existsById(id)) {
			return "Cliente não existe!";
		}
		Cliente clienteTodo = clienteRepository.findById(id).get();
		if(clienteDto.getNome()!=null) {
			clienteTodo.setNome(clienteDto.getNome());			
		}
		if(clienteDto.getCpf()!=null) {
			clienteTodo.setCpf(clienteDto.getCpf());			
		}
		if(clienteDto.getCartao()!=null) {
			clienteTodo.setCartao(clienteDto.getCartao());
		}
		if(clienteDto.getDataNascimento()!=null) {
			clienteTodo.setDataNascimento(clienteDto.getDataNascimento());
		}
		if(clienteDto.getTelefone()!=null) {
			clienteTodo.setTelefone(clienteDto.getTelefone());
		}
		
		clienteRepository.save(clienteTodo);
		return "Cliente atualizado com sucesso!";
	}

	public List<Cliente> clienteList() {
		return clienteRepository.findAll();
	}
}