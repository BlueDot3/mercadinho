package br.com.projetoSA.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity(name="mercado")
public class Mercado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(name="nome")
	private String nome;
	
	@NonNull
	@Column(name="login")
	private String login;
	
	@NonNull
	@Column(name="cnpj")
	private String cnpj;
	
	@NonNull
	@Column(name="senha")
	private String senha;
	
	@ManyToMany
	@JoinTable(name = "mercado_permissao", joinColumns = @JoinColumn(name = "mercado_id"), inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private List<Permissao> permissoes;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "endereco", 
      joinColumns = 
        { @JoinColumn(name = "mercado_id", referencedColumnName = "id") },
      inverseJoinColumns = 
        { @JoinColumn(name = "endereco_id", referencedColumnName = "id") })
    private Endereco endereco;
	

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
