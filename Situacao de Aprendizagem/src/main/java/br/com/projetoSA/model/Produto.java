package br.com.projetoSA.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity(name="produto")
public class Produto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(name="nome")
	private String nome;
	
	@NonNull
	@Column(name="preco")
	private float preco;
	
	@NonNull
	@Column(name="tipo")
	private String tipo;
	
	@ManyToMany(mappedBy="produtos")
    private List<Pedido> pedido;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", mercadoNome="  + ", preco=" + preco + ", tipo="
				+ tipo + "]";
	}
	
	
}
