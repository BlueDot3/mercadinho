package br.com.projetoSA.model;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name = "pedido")
public class Pedido {
	 	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Size(max=80)
	    @NotNull
	    @Column(name="descricao")
	    private String descricao;

	    @NotNull
	    @Column(name="data")
	    private Date dataPedido;
	    
	    @ManyToMany
	    @JoinTable(name = "pedido_usuario",
	    	joinColumns = @JoinColumn(name="pedido_id"),
	    	inverseJoinColumns = @JoinColumn(name="usuario_id"))
	    private List<Usuario> usuarios;

	    @ManyToMany
	    @JoinTable(name = "pedido_produto",
	    	joinColumns = @JoinColumn(name="pedido_id"),
	    	inverseJoinColumns = @JoinColumn(name="produto_id"))
	    private List<Produto> produtos;
	    
		public List<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(List<Usuario> usuarios) {
			this.usuarios = usuarios;
		}
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Date getDataPedido() {
			return dataPedido;
		}

		public void setDataPedido(Date dataPedido) {
			this.dataPedido = dataPedido;
		}

		@Override
		public String toString() {
			return "Pedido [id=" + id + ", descricao=" + descricao + ", dataPedido=" + dataPedido + "]";
		}
		
	    
}
