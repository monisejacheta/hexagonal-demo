package com.projetoTesteArqHexagonal.hexagonal_demo.domain.port.output;

import com.projetoTesteArqHexagonal.hexagonal_demo.domain.model.ContaCorrente;
import java.util.List;
import java.util.Optional;

public interface ContaCorrenteRepository {


  List<ContaCorrente> findAll();

  Optional<ContaCorrente> findById(Long id);

  Optional<ContaCorrente> findByNumeroDaConta(String numeroDaConta);

  List<ContaCorrente> findByNomeDoTitular(String nomeDoTitular);

  ContaCorrente save(ContaCorrente contaCorrente);

}
