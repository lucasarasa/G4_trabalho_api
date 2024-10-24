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
		endereco.setLogradouro(viaCep.getLogradouro());
		endereco.setBairro(viaCep.getBairro());
		endereco.setLocalidade(viaCep.getLocalidade());
		endereco.setUf(viaCep.getUf());
		endereco.setEstado(viaCep.getEstado());
		endereco.setRegiao(viaCep.getRegiao());
		endereco.setComplemento(enderecoRequestDTO.getComplemento());

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
		enderecoResponseDTO.setCep(endereco.get().getCep());
		enderecoResponseDTO.setLogradouro(endereco.get().getLogradouro());
		enderecoResponseDTO.setBairro(endereco.get().getBairro());
		enderecoResponseDTO.setLocalidade(endereco.get().getLocalidade());
		enderecoResponseDTO.setUf(endereco.get().getUf());
		enderecoResponseDTO.setEstado(endereco.get().getEstado());
		enderecoResponseDTO.setRegiao(endereco.get().getRegiao());
		enderecoResponseDTO.setComplemento(endereco.get().getComplemento());
		return enderecoResponseDTO;
	}

	public String atualizarEndereco(Integer id, EnderecoResponseDTO enderecoDTO) {
		if (!enderecoRepository.existsById(id)) {
			return "Endereço não existe!";
		}
		Endereco endereco = enderecoRepository.findById(id).get();
		if (enderecoDTO.getCep() != null) {
			endereco.setCep(enderecoDTO.getCep());
		}
		if (enderecoDTO.getLogradouro() != null) {
			endereco.setLogradouro(enderecoDTO.getLogradouro());
		}
		if (enderecoDTO.getBairro() != null) {
			endereco.setBairro(enderecoDTO.getBairro());
		}
		if (enderecoDTO.getLocalidade() != null) {
			endereco.setLocalidade(enderecoDTO.getLocalidade());
		}
		if (enderecoDTO.getEstado() != null) {
			endereco.setEstado(enderecoDTO.getEstado());
		}
		if (enderecoDTO.getUf() != null) {
			endereco.setUf(enderecoDTO.getUf());
		}
		if (enderecoDTO.getRegiao() != null) {
			endereco.setRegiao(enderecoDTO.getRegiao());
		}
		if (enderecoDTO.getComplemento() != null) {
			endereco.setComplemento(enderecoDTO.getComplemento());
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