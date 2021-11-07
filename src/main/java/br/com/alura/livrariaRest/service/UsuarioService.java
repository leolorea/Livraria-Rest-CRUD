package br.com.alura.livrariaRest.service;



import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaRest.dto.UsuarioDto;
import br.com.alura.livrariaRest.dto.UsuarioFormDto;
import br.com.alura.livrariaRest.model.Perfil;
import br.com.alura.livrariaRest.model.Usuario;
import br.com.alura.livrariaRest.repository.PerfilRespository;
import br.com.alura.livrariaRest.repository.UsuarioRepository;


@Service

public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PerfilRespository perfilRepository;
	
	private ModelMapper mapper = new ModelMapper();

	
	
	public Page<UsuarioDto> listarUsuarios(Pageable pageable) {
		 Page<Usuario> usuarios = repository.findAll(pageable);
		return usuarios.map(t -> mapper.map(t, UsuarioDto.class));

	}
	
	public Page<UsuarioDto> listarLivros(Pageable pageable) {
		Page<Usuario> usuario = repository.findAll(pageable);

		return usuario.map(t -> mapper.map(t, UsuarioDto.class));
	}
	


	@Transactional
	public UsuarioDto cadastrarUsuario(UsuarioFormDto usuarioFormDto) {

		try {String key =  usuarioFormDto.getSenha();
			usuarioFormDto.setSenha(encoder.encode(key));
			Usuario usuario = mapper.map(usuarioFormDto, Usuario.class);
			Perfil perfil = perfilRepository.getById(usuarioFormDto.getPerfilId());
			usuario.adicionarPerfil(perfil);
			Usuario usuarioSalvado = repository.save(usuario);
			UsuarioDto dto = mapper.map(usuarioSalvado, UsuarioDto.class);
			return dto;

		} catch (EntityNotFoundException e) {
			throw new IllegalArgumentException("Usuário Inexistente");
		}

	}

	public UsuarioDto listarUsuarios(Long id) {
		Usuario usuario = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		UsuarioDto dto = mapper.map(usuario, UsuarioDto.class);
		return dto;
	}

	@Transactional
	public UsuarioDto deletarUsuario(Long id) {

		if (repository.existsById(id)) {
			Optional<Usuario> usuario = repository.findById(id);
			repository.deleteById(id);
			return mapper.map(usuario, UsuarioDto.class);
		}
		throw new EntityNotFoundException("Usuário Inexistente");

	}

}
