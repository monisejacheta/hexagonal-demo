package com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.mapper;

import com.projetoTesteArqHexagonal.hexagonal_demo.domain.model.ContaCorrente;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.ContaCorrenteRespostaDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.ContaCorrenteResumoDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.input.web.dto.CriarContaCorrenteDTO;
import com.projetoTesteArqHexagonal.hexagonal_demo.infrastructure.adapter.output.persistence.entity.ContaCorrenteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-11T16:38:02-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Eclipse Adoptium)"
)
@Component
public class ContaCorrenteMapperImpl implements ContaCorrenteMapper {

    @Override
    public ContaCorrente paraDomain(ContaCorrenteEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ContaCorrente.ContaCorrenteBuilder contaCorrente = ContaCorrente.builder();

        contaCorrente.id( entity.getId() );
        contaCorrente.nomeDoTitular( entity.getNomeDoTitular() );
        contaCorrente.numeroDaConta( entity.getNumeroDaConta() );
        contaCorrente.saldoAtual( entity.getSaldoAtual() );

        return contaCorrente.build();
    }

    @Override
    public List<ContaCorrente> listaDomain(List<ContaCorrenteEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ContaCorrente> list = new ArrayList<ContaCorrente>( entities.size() );
        for ( ContaCorrenteEntity contaCorrenteEntity : entities ) {
            list.add( paraDomain( contaCorrenteEntity ) );
        }

        return list;
    }

    @Override
    public ContaCorrenteEntity paraEntity(ContaCorrente domain) {
        if ( domain == null ) {
            return null;
        }

        ContaCorrenteEntity.ContaCorrenteEntityBuilder contaCorrenteEntity = ContaCorrenteEntity.builder();

        contaCorrenteEntity.id( domain.getId() );
        contaCorrenteEntity.nomeDoTitular( domain.getNomeDoTitular() );
        contaCorrenteEntity.numeroDaConta( domain.getNumeroDaConta() );
        contaCorrenteEntity.saldoAtual( domain.getSaldoAtual() );

        return contaCorrenteEntity.build();
    }

    @Override
    public ContaCorrenteRespostaDTO paraRepostaDTO(ContaCorrente domain) {
        if ( domain == null ) {
            return null;
        }

        ContaCorrenteRespostaDTO.ContaCorrenteRespostaDTOBuilder contaCorrenteRespostaDTO = ContaCorrenteRespostaDTO.builder();

        contaCorrenteRespostaDTO.contaPositiva( estaPositiva( domain ) );
        contaCorrenteRespostaDTO.saldoAtual( domain.getSaldoAtual() );
        contaCorrenteRespostaDTO.id( domain.getId() );
        contaCorrenteRespostaDTO.nomeDoTitular( domain.getNomeDoTitular() );
        contaCorrenteRespostaDTO.numeroDaConta( domain.getNumeroDaConta() );

        return contaCorrenteRespostaDTO.build();
    }

    @Override
    public List<ContaCorrenteRespostaDTO> paraRespotaDTOList(List<ContaCorrente> domains) {
        if ( domains == null ) {
            return null;
        }

        List<ContaCorrenteRespostaDTO> list = new ArrayList<ContaCorrenteRespostaDTO>( domains.size() );
        for ( ContaCorrente contaCorrente : domains ) {
            list.add( paraRepostaDTO( contaCorrente ) );
        }

        return list;
    }

    @Override
    public ContaCorrenteResumoDTO paraResumoDTO(ContaCorrente domain) {
        if ( domain == null ) {
            return null;
        }

        ContaCorrenteResumoDTO.ContaCorrenteResumoDTOBuilder contaCorrenteResumoDTO = ContaCorrenteResumoDTO.builder();

        contaCorrenteResumoDTO.id( domain.getId() );

        return contaCorrenteResumoDTO.build();
    }

    @Override
    public List<ContaCorrenteResumoDTO> paraResumoDTOList(List<ContaCorrente> domains) {
        if ( domains == null ) {
            return null;
        }

        List<ContaCorrenteResumoDTO> list = new ArrayList<ContaCorrenteResumoDTO>( domains.size() );
        for ( ContaCorrente contaCorrente : domains ) {
            list.add( paraResumoDTO( contaCorrente ) );
        }

        return list;
    }

    @Override
    public ContaCorrente paraDominio(CriarContaCorrenteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ContaCorrente.ContaCorrenteBuilder contaCorrente = ContaCorrente.builder();

        contaCorrente.nomeDoTitular( dto.getNomeDoTitular() );
        contaCorrente.numeroDaConta( dto.getNumeroDaConta() );
        contaCorrente.saldoAtual( dto.getSaldoAtual() );

        return contaCorrente.build();
    }
}
