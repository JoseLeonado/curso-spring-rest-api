package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/{id}/codigo-venda/{venda}")
	public ResponseEntity<Usuario> buscarCodigoDeVenda(@PathVariable Long id, @PathVariable Long venda) {
	
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return ResponseEntity.ok(usuario.get());
	}

	/* Serviço RESTful */
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
	
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return ResponseEntity.ok(usuario.get());
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@PostMapping("/{idUser}/idVenda/{idVenda}")
	public ResponseEntity<?> cadastrarVenda(@PathVariable Long idUser, @PathVariable Long idVenda) {
		
		/* Aqui seria o processo de venda */
		//Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity("idUser: " + idUser + " idVenda: " + idVenda, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
		
		/* Outras rotinas antes de atualizar */
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		
		usuarioRepository.deleteById(id);
		
		return "ok";
	}
	
	@DeleteMapping("/{id}/venda")
	public String deletarVenda(@PathVariable Long id) {
		
		/* Irá deletar todas as vendas do usuário */
		usuarioRepository.deleteById(id);
		
		return "ok";
	}
	
}
