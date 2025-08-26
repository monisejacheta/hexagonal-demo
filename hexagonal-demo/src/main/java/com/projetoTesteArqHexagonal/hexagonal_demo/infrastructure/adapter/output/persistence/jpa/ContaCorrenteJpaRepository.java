package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.output.persistence.jpa;

import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.output.persistence.entity.ContaCorrenteEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCorrenteJpaRepository extends JpaRepository<ContaCorrenteEntity, Long> {

  Optional<ContaCorrenteEntity> findByNumeroDaConta(String numeroDaConta);

  @Query("SELECT c FROM ContaCorrenteEntity c WHERE REPLACE(LOWER(c.nomeDoTitular), ' ', '') = REPLACE(LOWER(:nomeDoTitular), ' ', '')")
  List<ContaCorrenteEntity> findByNomeDoTitular(String nomeDoTitular);
}
