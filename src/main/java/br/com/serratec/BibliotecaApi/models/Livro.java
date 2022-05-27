package br.com.serratec.BibliotecaApi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(nullable = false)
	@Size(min=5, max=30)
	String titulo;
	
	@Column(nullable = false)
	@Size(min=3, max=20)
	String tipo;
	
	@Column(nullable = false)
	@Size(min=10, max=40)
	String autor;
	
	@Temporal(TemporalType.DATE)
	Date dataPublicacao;
	
	public Livro() {
		super();
	}
	
	public Livro(Integer id, String titulo, String tipo, String autor, Date dataPublicacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.tipo = tipo;
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
}
