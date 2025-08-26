package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade JPA para persistência de ContaCorrente
 */

@Entity
@Table(name = "conta_corrente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ContaCorrenteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nomeDoTitular;

  @Column(unique = true)
  private String numeroDaConta;

  private Double saldoAtual;
}
