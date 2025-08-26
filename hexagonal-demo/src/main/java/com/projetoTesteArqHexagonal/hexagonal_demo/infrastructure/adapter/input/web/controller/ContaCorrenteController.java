package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.controller;

import com.projetoTesteArqHexagonal.hexagonal_demo.domain.port.input.ContaCorrenteUseCase;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.AtualizaContaCorrenteDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.ContaCorrenteRespostaDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.CriarContaCorrenteDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.mapper.ContaCorrenteMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
@Tag(name = "Contas Correntes", description = "API para gerenciamento de contas correntes")
public class ContaCorrenteController {

  private final ContaCorrenteUseCase contaCorrenteUseCase;
  private final ContaCorrenteMapper mapper;

  @GetMapping("/{id}")
  @Operation(summary = "Buscar conta por ID da conta", description = "Retorna os detalhes de uma conta pelo seu ID")
  @ApiResponse(responseCode = "200", description = "Conta encontrada")
  @ApiResponse(responseCode = "404", description = "Conta não encontrada")
  public ResponseEntity<ContaCorrenteRespostaDTO> buscarContaPorId(
      @Parameter(description = "numero da conta") @PathVariable Long id) {
    var ContaParaVerificar = contaCorrenteUseCase.buscarContaPorId(id);

    //se a conta for encontrada converte para DTO e retorna 200
    return ContaParaVerificar.map(conta -> ResponseEntity.ok(mapper.paraRepostaDTO(conta)))
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/titular/{nomeDoTitular}")
  @Operation(summary = "Buscar conta por titular", description = "Retorna uma lista de correspondetes")
  @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
  @ApiResponse(responseCode = "404", description = "Nenhuma conta encontrada para o titular")
  public ResponseEntity<List<ContaCorrenteRespostaDTO>> buscarContasPorTitular(
      @Parameter(description = "Nome do titular da conta") @PathVariable String nomeDoTitular) {

    var contasTitularEncontradas = contaCorrenteUseCase.buscarContasPorTitular(nomeDoTitular);

    if (contasTitularEncontradas.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(mapper.paraRespotaDTOList(contasTitularEncontradas));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Atualizar Conta Corrente", description = "Atualiza os dados de uma conta existente")
  @ApiResponse(responseCode = "200", description = "Conta foi atualizada com sucesso")
  @ApiResponse(responseCode = "404", description = "Conta não foi encontrada")
  public ResponseEntity<ContaCorrenteRespostaDTO> atualizarConta(
      @Parameter(description = "Id da Conta") @PathVariable Long id,
      @RequestBody AtualizaContaCorrenteDTO contaDTO) {

    //converter DTO p modelo
    var contaParaAtualizar = mapper.paraDominio(contaDTO);

    //chamando o usecase de atualizacao
    var contaAtualizada = contaCorrenteUseCase.atualizarConta(id, contaParaAtualizar);

    return contaAtualizada.map(conta -> ResponseEntity.ok(mapper.paraRepostaDTO(conta)))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/")
  @Operation(summary = "Criar nova Conta Corrente", description = "Cria uma nova conta corrente no sistema")
  @ApiResponse(responseCode = "201", description = "Conta Criada com sucesso")
  @ApiResponse(responseCode = "400", description = "Dados inválidos para a criação da conta")
  public ResponseEntity<ContaCorrenteRespostaDTO> criarConta(
      @Valid @RequestBody CriarContaCorrenteDTO contaDTO) {

    var novaConta = mapper.paraDominio(contaDTO);

    var contaCriada = contaCorrenteUseCase.criarConta(novaConta);

    return ResponseEntity.status(201).body(mapper.paraRepostaDTO(contaCriada));
  }

}
