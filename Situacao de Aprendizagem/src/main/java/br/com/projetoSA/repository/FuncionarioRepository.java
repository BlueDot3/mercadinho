package br.com.projetoSA.repository;

import br.com.projetoSA.model.Funcionario;

public interface FuncionarioRepository {
  Funcionario findFuncionario(String nome, String cargo);
}