package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representação completa de uma conta corrente")

public class ContaCorrenteRespostaDTO {

  @Schema(description = "Identificador único da conta")
  private Long id;

  @Schema(description = "Nome do titular da conta")
  private String nomeDoTitular;

  @Schema(description = "Número da conta")
  private String numeroDaConta;

  @Schema(description = "Saldo atual da conta")
  private Double saldoAtual;

  @Schema(description = "Indica se a conta esta com saldo positivo")
  private Boolean contaPositiva;
}
