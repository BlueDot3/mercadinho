package br.com.projetoSA.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;


@Entity(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@Size(max = 120)
	@Column(name="nome")
	private String nome;

	@NonNull
	@Size(max = 120)
	@Column(name="login")
	private String login;

	@NonNull
	@Size(max = 120)
	@Column(name="senha")
	private String senha;

	@Size(max = 11)
	@Column(name="cpf")
	private String cpf;
	
	@Size(max = 11)
	@Column(name="rua")
	private String rua;
	
	@Size(max = 11)
	@Column(name="bairro")
	private String bairro;
	
	@Size(max = 11)
	@Column(name="numero")
	private int numero;
	
	@Size(max = 11)
	@Column(name="complemento")
	private String complemento;
	
	@ManyToMany(mappedBy="usuarios")
    private List<Pedido> pedido;

	@ManyToMany
	@JoinTable(name = "usuario_permissao", 
	   joinColumns = @JoinColumn(name = "usuario_id"), 
	   inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private List<Permissao> permissoes;
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	
	

}