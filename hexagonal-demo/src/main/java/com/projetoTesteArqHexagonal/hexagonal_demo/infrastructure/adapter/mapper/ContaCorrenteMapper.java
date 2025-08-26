package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.mapper;

import com.projetoTesteArqHexagonal.hexagonal_demo.domain.model.ContaCorrente;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.AtualizaContaCorrenteDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.ContaCorrenteRespostaDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.ContaCorrenteResumoDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.CriarContaCorrenteDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.output.persistence.entity.ContaCorrenteEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Interface MapStrucp mapeando diferentes representacoes de ContaCorrente - mapea para input e
 * output
 */

@Mapper(componentModel = "spring")
public interface ContaCorrenteMapper {

  //Convertendo objetos de persistencia em objetos de dominio Entidade -> Dominio
  ContaCorrente paraDomain(ContaCorrenteEntity entity);

  List<ContaCorrente> listaDomain(List<ContaCorrenteEntity> entities);

  //Dominio -> Entidade
  ContaCorrenteEntity paraEntity(ContaCorrente domain);


  //Dominio -> DTO de Resposta
  //target - campo de destino no DTO
  @Mapping(target = "contaPositiva", source = "domain", qualifiedByName = "estaPositiva")
  @Mapping(target = "saldoAtual", source = "saldoAtual")
  ContaCorrenteRespostaDTO paraRepostaDTO(ContaCorrente domain);


  //Mapeia uma lista de objetos de ContaCorrente para uma ContaCorrenteRespotaDTO - usada no controller p lista de titulares
  List<ContaCorrenteRespostaDTO> paraRespotaDTOList(List<ContaCorrente> domains);


  //Dominio -> DTO Resumido
  ContaCorrenteResumoDTO paraResumoDTO(ContaCorrente domain);

  List<ContaCorrenteResumoDTO> paraResumoDTOList(List<ContaCorrente> domains);


  //Metodo auxiliar para determinar se a conta ta positiva
  @Named("estaPositiva")
  default Boolean estaPositiva(ContaCorrente conta) {
    return conta.ContaPositiva();
  }

  // Metodo para converter DTO de atualização para objeto de domínio
  default ContaCorrente paraDominio(AtualizaContaCorrenteDTO dto) {
    return ContaCorrente.builder()
        .nomeDoTitular(dto.getNomeDoTitular())
        .numeroDaConta(dto.getNumeroDaConta())
        .saldoAtual(dto.getSaldoAtual())
        .build();
  }

  // Metodo para converter DTO de criação para objeto de domínio
  ContaCorrente paraDominio(CriarContaCorrenteDTO dto);
}
