package curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class IndexController {

	/* Serviço RESTful */
	@GetMapping("/")
	public ResponseEntity<Usuario> init() {
	
		Usuario usuario = new Usuario();
		usuario.setId(50L);
		usuario.setLogin("leonardo_cordeirobahia@hotmail.com");
		usuario.setNome("José Leonardo Cordeiro Bahia");
		usuario.setSenha("15484844884");
		
		Usuario usuario2 = new Usuario();
		usuario.setId(50L);
		usuario.setLogin("asdad	@hotmail.com");
		usuario.setNome("sdada");
		usuario.setSenha("48484848");
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario);
		usuarios.add(usuario2);
		
		return new ResponseEntity(usuarios, HttpStatus.OK);
	}
	
}
