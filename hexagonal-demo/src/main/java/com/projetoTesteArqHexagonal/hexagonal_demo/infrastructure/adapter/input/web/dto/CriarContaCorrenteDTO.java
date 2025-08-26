package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarContaCorrenteDTO {

  @NotBlank(message = "O nome do titular é obrigatório")
  @Schema(description = "Nome do titular da conta")
  private String nomeDoTitular;

  @NotBlank(message = "O número da conta é obrigatório")
  @Pattern(regexp = "^[0-9]{5}$", message = "O número da conta deve conter 5 dígitos")
  @Schema(description = "Número da conta")
  private String numeroDaConta;

  @NotNull(message = "O saldo inicial é obrigatório")
  @Schema(description = "Saldo atual da conta")
  private Double saldoAtual;

}
