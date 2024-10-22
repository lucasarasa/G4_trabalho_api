package br.com.trabalhofinal.grupoquatro.security.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.grupoquatro.security.dto.AeroportoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Aeroporto;
import br.com.trabalhofinal.grupoquatro.security.repositories.AeroportoRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.EnderecoRepository;

@Service
public class AeroportoService {

	@Autowired
	AeroportoRepository aeroportoRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	public List<AeroportoRequestDTO> listarAeroporto(){
		List<Aeroporto> aeroportos = aeroportoRepository.findAll();
		return aeroportos.stream().map(aeroporto -> new AeroportoRequestDTO(aeroporto.getNome(),
				aeroporto.getEmail())).collect(Collectors.toList());
	}
	
	public void cadastrarAeroporto(AeroportoRequestDTO aeroportoRequestDTO) {
		Aeroporto aeroporto = new Aeroporto();
		aeroporto.setNome(aeroportoRequestDTO.getNome());
		aeroporto.setEmail(aeroportoRequestDTO.getEmail());

		
		aeroportoRepository.save(aeroporto);
	}
	
	public void atualizarAeroporto(AeroportoRequestDTO aeroportoRequestDTO) {
		Aeroporto aeroporto = aeroportoRepository.buscarAeroporto();
		if(aeroportoRequestDTO.getNome()!=null) {
			aeroporto.setNome(aeroportoRequestDTO.getNome());
		}
		if(aeroportoRequestDTO.getEmail()!=null) {
			aeroporto.setEmail(aeroportoRequestDTO.getEmail());			
		}
		
		aeroportoRepository.save(aeroporto);
	}
	
	public boolean deletarAeroporto(Integer id) {
		if(aeroportoRepository!=null) {
			aeroportoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
