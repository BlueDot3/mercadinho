package br.com.projetoSA.repository;

import br.com.projetoSA.model.Funcionario;

public interface FuncionarioRepository {
  public Funcionario findFuncionario(String nome, String cargo);
}