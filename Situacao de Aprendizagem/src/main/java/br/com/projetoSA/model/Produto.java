package br.com.projetoSA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	@Column(name="mercadoNome")
	private String mercadoNome;
	
	@NonNull
	@Column(name="preco")
	private float preco;
	
	@NonNull
	@Column(name="tipo")
	private String tipo;
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + mercadoNome.hashCode();
		result = prime * result + nome.hashCode();
		result = prime * result + Float.floatToIntBits(preco);
		result = prime * result + tipo.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!mercadoNome.equals(other.mercadoNome))
			return false;
		if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		return tipo.equals(other.tipo);
	}

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

	public String getMercadoNome() {
		return mercadoNome;
	}

	public void setMercadoNome(String mercadoNome) {
		this.mercadoNome = mercadoNome;
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
		return "Produto [id=" + id + ", nome=" + nome + ", mercadoNome=" + mercadoNome + ", preco=" + preco + ", tipo="
				+ tipo + "]";
	}
	
	
}
