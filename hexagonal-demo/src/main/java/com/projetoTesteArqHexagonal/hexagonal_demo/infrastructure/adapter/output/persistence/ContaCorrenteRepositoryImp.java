package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.output.persistence;

import com.projetoTesteArqHexagonal.hexagonal_demo.domain.model.ContaCorrente;
import com.projetoTesteArqHexagonal.hexagonal_demo.domain.port.output.ContaCorrenteRepository;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.mapper.ContaCorrenteMapper;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.output.persistence.jpa.ContaCorrenteJpaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ContaCorrenteRepositoryImp implements ContaCorrenteRepository {

  private final ContaCorrenteJpaRepository jpaRepository;
  private final ContaCorrenteMapper mapper;

  @Override
  public List<ContaCorrente> findAll() {
    //busca todas as entidades no banco e converte a lista de modelos de dominio
    return mapper.listaDomain(jpaRepository.findAll());
  }

  @Override
  public Optional<ContaCorrente> findById(Long id) {
    //busca entidade pelo ID, se encontrar, converte p modelo de dominio
    return jpaRepository.findById(id).map(mapper::paraDomain);
  }

  @Override
  public Optional<ContaCorrente> findByNumeroDaConta(String numeroDaConta) {
    return jpaRepository.findByNumeroDaConta(numeroDaConta).map(mapper::paraDomain);
  }

  public List<ContaCorrente> findByNomeDoTitular(String nomeDoTitular) {
    return mapper.listaDomain(jpaRepository.findByNomeDoTitular(nomeDoTitular));
  }

  @Override
  public ContaCorrente save(ContaCorrente contaCorrente) {
    // 1. Converte o modelo de domínio para entidade
    // 2. Salva a entidade
    // 3. Converte a entidade salva de volta para modelo de domínio
    return mapper.paraDomain(jpaRepository.save(mapper.paraEntity(contaCorrente)));
  }
}