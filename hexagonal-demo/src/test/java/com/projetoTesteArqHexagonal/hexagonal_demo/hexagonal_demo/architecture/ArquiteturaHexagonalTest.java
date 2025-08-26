package com.projetoTesteArqHexagonal.hexagonal_demo.hexagonal_demo.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public class ArquiteturaHexagonalTest {

  private final JavaClasses classesImportadas = new ClassFileImporter()
      .importPackages("com.projetoTesteArqHexagonal");

  @Test
  public void domainNaoDeveDependeDeInfrastructure() {
    ArchRule regra = noClasses().that().resideInAPackage("..domain..")
        .should().dependOnClassesThat().resideInAPackage("..infrastructure..");

    regra.check(classesImportadas);
  }

  @Test
  public void servicosDevemSerAcessadosApenasControllers() {
    ArchRule regra = classes()
        .that().areAnnotatedWith(Service.class)
        .should().onlyBeAccessed().byAnyPackage("..controller..", "..config..", "..service..");

    regra.check(classesImportadas);
  }

  @Test
  public void repositoriosDevemSerAcessadosApenasServicos() {
    ArchRule regra = classes()
        .that().areAssignableTo(JpaRepository.class).or().areAnnotatedWith(Repository.class)
        .should().onlyBeAccessed().byAnyPackage("..service..", "..repository..", "..config..");

    regra.check(classesImportadas);
  }

  @Test
  public void arquiteturaEmCamadasDeveSerRespeitada() {
    ArchRule regra = layeredArchitecture()
        .layer("Domain").definedBy("..domain..")
        .layer("Infrastructure").definedBy("..infrastructure..")
        .layer("Application").definedBy("..application..")

        .whereLayer("Application").mayNotBeAccessedByAnyLayer()
        .whereLayer("Domain").mayOnlyBeAccessedByLayers("Application", "Infrastructure")
        .whereLayer("Infrastructure").mayNotBeAccessedByAnyLayer();

    regra.check(classesImportadas);
  }

  @Test
  public void modelosDeDominioNaoDevemTerAnotacoesJPA() {
    ArchRule regra = classes()
        .that().resideInAPackage("..domain.model..")
        .should().notBeAnnotatedWith("jakarta.persistence.Entity")
        .andShould().notBeAnnotatedWith("jakarta.persistence.Table");

    regra.check(classesImportadas);
  }

  @Test
  public void repositoriosJPADevemEstarNaCamadaDeInfraestrutura() {
    ArchRule regra = classes()
        .that().areAssignableTo(JpaRepository.class)
        .should().resideInAPackage("..infrastructure.adapter.output.persistence..");

    regra.check(classesImportadas);
  }

  @Test
  public void implementacoesDeRepositorioDevemDependeDePortasDeDominio() {
    ArchRule regra = classes()
        .that().resideInAPackage("..infrastructure.adapter.output.persistence..")
        .and().haveNameMatching(".*RepositoryImpl")
        .should().accessClassesThat().resideInAPackage("..domain.port.output..");

    regra.check(classesImportadas);
  }

  @Test
  public void servicosDevemDependeDePortasDeEntrada() {
    ArchRule regra = classes()
        .that().areAnnotatedWith(Service.class)
        .should().accessClassesThat().resideInAPackage("..domain.port.input..");

    regra.check(classesImportadas);
  }
}