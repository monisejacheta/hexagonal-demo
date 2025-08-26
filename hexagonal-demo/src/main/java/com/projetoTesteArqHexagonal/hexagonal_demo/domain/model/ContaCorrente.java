package com.projetoTesteArqHexagonal.hexagonal_demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ContaCorrente {

  private Long id;
  private String nomeDoTitular;
  private String numeroDaConta;
  private Double saldoAtual;

  /**
   * Metodo para formatar os dados da conta para exibicao
   *
   * @return String formatada com os dados principais da conta
   */

  public String ExibirDadosConta() {
    return String.format(
        "Dados da conta:\n" +
            "- Titular: %s\n" +
            "- Número da Conta: %s\n" +
            "- Saldo Atual: R$ %.2f",
        nomeDoTitular, numeroDaConta, saldoAtual
    );
  }

  public boolean ContaPositiva() {
    return saldoAtual >= 0;
  }
}