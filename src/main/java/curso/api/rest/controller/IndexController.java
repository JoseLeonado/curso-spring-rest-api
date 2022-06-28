package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/{id}/codigo-venda/{venda}", produces = "application/pdf")
	public ResponseEntity<Usuario> relatorio(@PathVariable Long id, @PathVariable Long venda) {
	
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return ResponseEntity.ok(usuario.get());
	}

	/* Serviço RESTful */
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> init(@PathVariable Long id) {
	
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return ResponseEntity.ok(usuario.get());
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> usuarios() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
}
