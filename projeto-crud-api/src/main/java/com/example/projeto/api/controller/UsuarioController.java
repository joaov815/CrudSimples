package com.example.projeto.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.api.exception.ResourceNotFoundException;
import com.example.projeto.api.model.Usuario;
import com.example.projeto.api.repository.UsuarioRepository;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario")
	public List<Usuario> listar() {
		return usuarioRepository.findAll(); 
	}
	
	
	@GetMapping("/usuario/{codigo}")
	public ResponseEntity<Usuario> getUsuarioByCodigo(@PathVariable(value = "codigo") Integer usuarioId)
		throws ResourceNotFoundException {
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("O usuario seguinte não existe: " + usuarioId));
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping("/usuario")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/usuario/{codigo}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "codigo") Integer usuarioId,
		@Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("O usuario seguinte não existe: " + usuarioId));

		usuario.setCpf(usuarioDetails.getCpf());
		usuario.setNome(usuarioDetails.getNome());
		usuario.setDtnasc(usuarioDetails.getDtnasc());
		usuario.setEstcivil(usuarioDetails.getEstcivil());
		usuario.setRg(usuarioDetails.getRg());
		usuario.setSexo(usuarioDetails.getSexo());
		
		final Usuario updatedUsuario = usuarioRepository.save(usuario);
		return ResponseEntity.ok(updatedUsuario);
	}
	
	@DeleteMapping("/usuario/{usuario}")
	public Map<String, Boolean> deleteUsuario(@PathVariable(value = "usuario") Integer usuarioId)
		throws ResourceNotFoundException {
		Usuario usuario= usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("O usuario seguinte não existe: " + usuarioId));
		
		usuarioRepository.delete(usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
