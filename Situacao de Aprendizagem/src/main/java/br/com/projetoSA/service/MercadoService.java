package br.com.projetoSA.service;

import br.com.projetoSA.model.Mercado;


public interface MercadoService {
	
	String saveMercado(Mercado mercado);

    String deleteMercado(String login);

    String updateUsuarioMercado(Mercado Mercado);

}
