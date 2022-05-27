package br.com.serratec.BibliotecaApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.BibliotecaApi.exceptions.LivroExistenteException;
import br.com.serratec.BibliotecaApi.exceptions.LivroInexistenteException;
import br.com.serratec.BibliotecaApi.models.Livro;
import br.com.serratec.BibliotecaApi.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository repositorio;
	
	
	public void criarLivro(Livro livro) throws LivroExistenteException {
		Optional<Livro> livroEncontrado = repositorio.findByTitulo(livro.getTitulo());
		
		if(livroEncontrado.isPresent()) {
			throw new LivroExistenteException();
		}
		repositorio.save(livro);
	}
	
	public List<Livro> retornaLivros() {
		return repositorio.findAll();
	}
	
	public Livro retornaLivro(String titulo) throws LivroInexistenteException {
		Optional<Livro> livroEncontrado = repositorio.findByTitulo(titulo);
		
		if(!livroEncontrado.isPresent())
			throw new LivroInexistenteException();
		
		return livroEncontrado.get();
	}
	
	public void atualizaLivro(String titulo, Livro atualizacao) throws LivroInexistenteException {
		Optional<Livro> livroAchado = repositorio.findByTitulo(titulo);
		Livro livro = livroAchado.get();
		
		if(!livroAchado.isPresent())
			throw new LivroInexistenteException();
		
		
		if(atualizacao.getTitulo() != null) {
			livro.setTitulo(atualizacao.getTitulo());
		}
		if(atualizacao.getAutor() != null) {
			livro.setAutor(atualizacao.getAutor());
		}
		if(atualizacao.getTipo() != null) {
			livro.setTipo(atualizacao.getTipo());
		}
		if(atualizacao.getDataPublicacao() != null) {
			livro.setDataPublicacao(atualizacao.getDataPublicacao());
		}
		
		repositorio.save(livro);
	}
	
	public void deletaLivro(String titulo) throws LivroInexistenteException {
		Optional<Livro> livroAchado = repositorio.findByTitulo(titulo);
		
		if(!livroAchado.isPresent())
			throw new LivroInexistenteException();
		
		repositorio.delete(livroAchado.get());
	}
}
