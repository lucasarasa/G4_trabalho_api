package br.com.trabalhofinal.grupoquatro.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.trabalhofinal.grupoquatro.security.dto.ClienteRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ClienteResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Cliente;
import br.com.trabalhofinal.grupoquatro.security.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

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
		Cliente clienteConvert = cliente.toCliente();
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
		clienteTodo.setNome(clienteDto.getNome());
		clienteTodo.setCpf(clienteDto.getCpf());
		clienteTodo.setCartao(clienteDto.getCartao());
		clienteTodo.setDataNascimento(clienteDto.getDataNascimento());
		clienteTodo.setTelefone(clienteDto.getTelefone());
		clienteRepository.save(clienteTodo);
		return "Cliente atualizado com sucesso!";
	}
}