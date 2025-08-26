package com.projetoTesteArqHexagonal.hexagonal_demo.domain.service;

import com.projetoTesteArqHexagonal.hexagonal_demo.domain.model.ContaCorrente;
import com.projetoTesteArqHexagonal.hexagonal_demo.domain.port.input.ContaCorrenteUseCase;
import com.projetoTesteArqHexagonal.hexagonal_demo.domain.port.output.ContaCorrenteRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaCorrenteService implements ContaCorrenteUseCase {

  // Injeção da porta de saída (repositório)
  private final ContaCorrenteRepository repository;

  @Override
  public ContaCorrente criarConta(ContaCorrente novaConta) {
    // Adiciona validações de negócio
    if (novaConta.getNumeroDaConta() == null || novaConta.getNumeroDaConta().trim().isEmpty()) {
      throw new IllegalArgumentException("Número da conta não pode ser vazio");
    }

    if (novaConta.getNomeDoTitular() == null || novaConta.getNomeDoTitular().trim().isEmpty()) {
      throw new IllegalArgumentException("Nome do titular não pode ser vazio");
    }

    // Verifica se já existe uma conta com o mesmo número
    Optional<ContaCorrente> contaExistente = repository.findByNumeroDaConta(
        novaConta.getNumeroDaConta());
    if (contaExistente.isPresent()) {
      throw new IllegalArgumentException("Já existe uma conta com este número");
    }

    // Se passar pelas validações, salva a nova conta
    return repository.save(novaConta);
  }

  @Override
  public Optional<ContaCorrente> buscarContaPorId(Long id) {
    // Delega a busca para o repositório
    return repository.findById(id);
  }

  @Override
  public List<ContaCorrente> buscarTodasContas() {
    return repository.findAll();
  }

  @Override
  public Optional<ContaCorrente> buscarContaPorNumero(String numeroDaConta) {
    return repository.findByNumeroDaConta(numeroDaConta);
  }

  @Override
  public List<ContaCorrente> buscarContasPorTitular(String nomeDoTitular) {
    return repository.findByNomeDoTitular(nomeDoTitular);
  }

  @Override
  public Optional<ContaCorrente> atualizarConta(Long id, ContaCorrente contaAtualizada) {

    //verifica se a conta existe
    return repository.findById(id).map(contaExistente -> {
      Optional.ofNullable(contaAtualizada.getNomeDoTitular())
          .ifPresent(contaExistente::setNomeDoTitular);

      Optional.ofNullable(contaAtualizada.getNumeroDaConta())
          .ifPresent(contaExistente::setNumeroDaConta);

      Optional.ofNullable(contaAtualizada.getSaldoAtual())
          .ifPresent(contaExistente::setSaldoAtual);

      return repository.save(contaExistente);
    });
  }


}

