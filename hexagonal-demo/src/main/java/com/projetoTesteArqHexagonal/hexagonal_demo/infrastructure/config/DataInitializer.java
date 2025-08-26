package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.config;

import com.projetoTesteArqHexagonal.hexagonal_demo.domain.model.ContaCorrente;
import com.projetoTesteArqHexagonal.hexagonal_demo.domain.port.output.ContaCorrenteRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por inicializar dados de teste no banco de dados quando a aplicação é
 * iniciada
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

  private final ContaCorrenteRepository contaCorrenteRepository;

  @Override
  public void run(String... args) {
    // Verificar se já existem dados
    List<ContaCorrente> contas = contaCorrenteRepository.findAll();
    if (contas.isEmpty()) {
      System.out.println("Inicializando dados de teste...");

      // Criar objetos de domínio (não entidades JPA)
      ContaCorrente conta1 = ContaCorrente.builder()
          .nomeDoTitular("João Silva")
          .numeroDaConta("12345")
          .saldoAtual(1000.00)
          .build();

      ContaCorrente conta2 = ContaCorrente.builder()
          .nomeDoTitular("Maria Oliveira")
          .numeroDaConta("56789")
          .saldoAtual(2500.50)
          .build();

      ContaCorrente conta3 = ContaCorrente.builder()
          .nomeDoTitular("Pedro Santos")
          .numeroDaConta("98765")
          .saldoAtual(-150.75)
          .build();

      // Salvar cada conta usando o repositório do domínio
      contaCorrenteRepository.save(conta1);
      contaCorrenteRepository.save(conta2);
      contaCorrenteRepository.save(conta3);

      System.out.println("Dados de teste inicializados com sucesso!");
    }
  }
}