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
@Schema(description = "Dados para a atulização de uma conta corrente")
public class AtualizaContaCorrenteDTO {

  @Schema(description = "Nome do titular da conta")
  private String nomeDoTitular;

  @Schema(description = "Numero da conta")
  private String numeroDaConta;

  @Schema(description = "Saldo atual da conta")
  private Double saldoAtual;

}
