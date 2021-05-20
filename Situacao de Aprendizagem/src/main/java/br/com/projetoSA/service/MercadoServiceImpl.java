package br.com.projetoSA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.projetoSA.model.Mercado;
import br.com.projetoSA.model.Permissao;
import br.com.projetoSA.repository.MercadoRepository;
import br.com.projetoSA.repository.PermissaoRepository;
import br.com.projetoSA.repository.UsuarioRepository;

public class MercadoServiceImpl implements MercadoService {

	 @Autowired
	    MercadoRepository mercadoRepository;

		@Autowired
		PermissaoRepository permissaoRepository;

		@Override
		public String saveMercado(Mercado mercado) {
			if (mercadoRepository.findByLogin(mercado.getLogin()) == null && mercadoRepository.findByCnpj(mercado.getCnpj()) == null && mercadoRepository.findByNome(mercado.getNome()) == null) {

				mercado.setSenha(new BCryptPasswordEncoder().encode(mercado.getSenha()));
				
				List<Permissao> permissoes = permissaoRepository.findByNome("cliente");

				mercado.setPermissoes(permissoes);

				mercadoRepository.save(mercado);
				
				return "redirect:/login";

			} else {
				
				System.out.println("Este usuário já existe!");

				return "redirect:/usuario/add";
			}
		}

		@Override
		public String deleteMercado(String login) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String updateUsuarioMercado(Mercado Mercado) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
}
