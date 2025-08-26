package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO resumido para listagem de contas - trazer somente os dados necessários (mais velocidade)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representação resumida de uma conta corrente")
public class ContaCorrenteResumoDTO {

    @Schema(description = "Identificador único da conta")
    private Long id;

    @Schema(description = "Nome do titular da conta")
    private String nomeTitular;

    @Schema(description = "Número da conta")
    private String numeroConta;
}