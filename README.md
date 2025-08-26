# Hexagonal Architecture Demo

Este repositório demonstra a implementação de uma arquitetura hexagonal em uma aplicação Java, destacando a separação de preocupações e a flexibilidade estrutural.

## Características do Projeto

- **Arquitetura Hexagonal**: Implementa o padrão de arquitetura hexagonal (ports and adapters), promovendo baixo acoplamento e alta coesão.
- **Camadas Bem Definidas**:
  - **Domain**: Contém a lógica de negócio pura, sem dependências externas.
  - **Application**: Gerencia os casos de uso e serviços da aplicação.
  - **Infrastructure**: Lida com a comunicação com sistemas externos, como bancos de dados e APIs.
- **Testes de Arquitetura**: Utiliza ArchUnit para garantir que as regras arquiteturais sejam seguidas, assegurando que as dependências entre camadas estejam corretas.
- **Flexibilidade e Manutenibilidade**: A estrutura modular facilita a manutenção e a evolução do sistema, permitindo substituições de componentes sem impacto no núcleo do negócio.
- **Isolamento do Domínio**: O domínio é isolado de detalhes de implementação, como frameworks e bibliotecas, garantindo que a lógica de negócio permaneça independente.


##Tecnologias Utilziadas

- **Java:** 17
- **Spring Boot:** 3.3.0
- **MapStruct:** 1.5.5.Final
- **Lombok:** 1.18.30
- **ArchUnit:** 1.4.1
- **Springdoc OpenAPI:** 2.1.0
- **Maven Compiler Plugin:** 3.13.0
- **Maven Resources Plugin:** 3.3.1
- **Spring Boot Maven Plugin:** 3.5.4
- **Banco de dados:** H2 Database

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/hexagonal-demo.git
   
2. Navegue até o diretório do projeto:
    cd hexagonal-demo
   
4. Construa o projeto:
   ./mvnw clean install
   
6. Execute os testes:
   ./mvnw test


##Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias e correções.
