package br.com.trabalhofinal.grupoquatro.security.services;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.trabalhofinal.grupoquatro.security.entities.Foto;
import br.com.trabalhofinal.grupoquatro.security.entities.User;
import br.com.trabalhofinal.grupoquatro.security.repositories.FotoRepository;

@Service
public class FotoService {
	
	@Autowired
	FotoRepository fotoRepository;
	
	public Foto cadastrarFoto(MultipartFile foto, User user) throws IOException {
		Foto fotoUsuario = new Foto();
		fotoUsuario.setDados(foto.getBytes());
		fotoUsuario.setTipo(foto.getContentType());
		fotoUsuario.setNome(foto.getOriginalFilename());
		fotoUsuario.setUrl(adicionarImagemUri(user));
		fotoUsuario.setFkUser(user);
		
		return fotoRepository.save(fotoUsuario);
		
	}
	public String adicionarImagemUri(User user) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/{id}/foto")
                .buildAndExpand(user.getId()).toUri();
		return uri.toString();
	}
	
	@Transactional(readOnly = true)
	public byte[] getFoto(Integer id) throws Exception {
		Foto foto = fotoRepository.buscarFotoPorIdUsuario(id);
		if(foto == null) {
			throw new Exception("Foto não encontrada para o usúario com ID " + id );
		}
		return foto.getDados();
	}
}
