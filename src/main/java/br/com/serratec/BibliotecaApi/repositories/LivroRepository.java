package br.com.serratec.BibliotecaApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.BibliotecaApi.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

	Optional<Livro> findByTitulo(String titulo);

}
