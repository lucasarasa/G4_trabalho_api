package br.com.trabalhofinal.grupoquatro.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.grupoquatro.security.dto.EnderecoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.EnderecoResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Endereco;
import br.com.trabalhofinal.grupoquatro.security.repositories.EnderecoRepository;
import br.com.trabalhofinal.grupoquatro.utils.Util;

@Service
public class EnderecoService {

	@Autowired
	Util util;

	@Autowired
	EnderecoRepository enderecoRepository;

	public EnderecoResponseDTO cadastrarEndereco(EnderecoRequestDTO enderecoRequestDTO) {
		EnderecoResponseDTO viaCep = util.buscarEndereco(enderecoRequestDTO.getCep());

		EnderecoResponseDTO endereco = new EnderecoResponseDTO();
		endereco.setCep(viaCep.getCep());
		endereco.setBairro(viaCep.getBairro());
		endereco.setComplemento(enderecoRequestDTO.getComplemento());
		endereco.setEstado(viaCep.getEstado());
		endereco.setLogradouro(viaCep.getLogradouro());
		endereco.setLocalidade(viaCep.getLocalidade());
		endereco.setUf(viaCep.getUf());
		endereco.setRegiao(viaCep.getRegiao());
		endereco.setNumero(enderecoRequestDTO.getNumero());

		Endereco enderecoConvertido = endereco.toEndereco();
		enderecoRepository.save(enderecoConvertido);

		return endereco;
	}

	public List<EnderecoResponseDTO> buscarTodos() {
		List<Endereco> enderecos = enderecoRepository.findAll();
		List<EnderecoResponseDTO> enderecosDTO = new ArrayList<EnderecoResponseDTO>();
		for (Endereco end : enderecos) {
			enderecosDTO.add(end.toResponseDTO());
		}

		return enderecosDTO;
	}

	public EnderecoResponseDTO buscarEndereco(Integer id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
		enderecoResponseDTO.setBairro(endereco.get().getBairro());
		enderecoResponseDTO.setCep(endereco.get().getCep());
		enderecoResponseDTO.setLogradouro(endereco.get().getLogradouro());
		enderecoResponseDTO.setUf(endereco.get().getUf());
		enderecoResponseDTO.setNumero(endereco.get().getNumero());
		enderecoResponseDTO.setComplemento(endereco.get().getComplemento());
		enderecoResponseDTO.setEstado(endereco.get().getEstado());
		enderecoResponseDTO.setLocalidade(endereco.get().getLocalidade());
		enderecoResponseDTO.setRegiao(endereco.get().getRegiao());
		return enderecoResponseDTO;
	}

	public String atualizarEndereco(Integer id, EnderecoRequestDTO enderecoRequest) {
		if (!enderecoRepository.existsById(id)) {
			return "Endereço não existe!";
		}
		Endereco endereco = enderecoRepository.findById(id).get();

		EnderecoResponseDTO viaCep = util.buscarEndereco(enderecoRequest.getCep());

		if (enderecoRequest.getCep() != null) {
			endereco.setCep(viaCep.getCep());
			endereco.setBairro(viaCep.getBairro());
			endereco.setEstado(viaCep.getEstado());
			endereco.setLogradouro(viaCep.getLogradouro());
			endereco.setLocalidade(viaCep.getLocalidade());
			endereco.setUf(viaCep.getUf());
			endereco.setRegiao(viaCep.getRegiao());
		}
		if (enderecoRequest.getComplemento() != null) {
			endereco.setComplemento(enderecoRequest.getComplemento());
		}
		if (enderecoRequest.getNumero() != null) {
			endereco.setNumero(enderecoRequest.getNumero());
		}
		
		enderecoRepository.save(endereco);

		return "Endereço atualizado com sucesso!";
	}

	public ResponseEntity<?> deletarEndereco(Integer id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);

		if (endereco.isPresent()) {
			enderecoRepository.deleteById(endereco.get().getId());
			return ResponseEntity.ok("Endereço deletado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
