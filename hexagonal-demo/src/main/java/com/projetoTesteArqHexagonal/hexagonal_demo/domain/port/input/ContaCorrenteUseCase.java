package com.projetoTesteArqHexagonal.hexagonal_demo.domain.port.input;

import com.projetoTesteArqHexagonal.hexagonal_demo.domain.model.ContaCorrente;
import java.util.List;
import java.util.Optional;

public interface ContaCorrenteUseCase {

  //Criar
  ContaCorrente criarConta(ContaCorrente novaConta);

  //Consultar
  List<ContaCorrente> buscarTodasContas();

  Optional<ContaCorrente> buscarContaPorId(Long id);

  Optional<ContaCorrente> buscarContaPorNumero(String numeroDaConta);

  List<ContaCorrente> buscarContasPorTitular(String nomeDoTitular);

  //Atualizar
  Optional<ContaCorrente> atualizarConta(Long id, ContaCorrente contaAtualizada);

}
