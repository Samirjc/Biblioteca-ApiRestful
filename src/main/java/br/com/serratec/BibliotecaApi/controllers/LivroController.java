package br.com.serratec.BibliotecaApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.BibliotecaApi.exceptions.LivroExistenteException;
import br.com.serratec.BibliotecaApi.exceptions.LivroInexistenteException;
import br.com.serratec.BibliotecaApi.models.Livro;
import br.com.serratec.BibliotecaApi.services.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@PostMapping
	public void createLivro(@RequestBody Livro livro) throws LivroExistenteException {
		livroService.criarLivro(livro);
	}
	
	@GetMapping
	public List<Livro> readLivros() {
		return livroService.retornaLivros();
	}
	
	@GetMapping("/{titulo}")
	public Livro readLivro(@PathVariable String titulo) throws LivroInexistenteException {
		return livroService.retornaLivro(titulo);
	}
	
	@PutMapping("/{titulo}")
	public void updateLivro(@PathVariable String titulo, @RequestBody Livro atualizacao) throws LivroInexistenteException {
		livroService.atualizaLivro(titulo, atualizacao);
	}
	
	@DeleteMapping("/{titulo}")
	public void deleteLivro(@PathVariable String titulo) throws LivroInexistenteException {
		livroService.deletaLivro(titulo);
	}
}
