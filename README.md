# Sistema de Conta Bancária em Java

Projeto desenvolvido com foco na consolidação de Programação Orientada a Objetos (POO), aplicação prática dos princípios SOLID e Design Patterns, estruturado como projeto de portifólio para nível Java Júnior.

# Objetivo do Projeto

Simular a arquitetura de um sistema bancário simplificado, aplicando boas práticas de desenvolvimento, organização em camadas e baixo acoplamento entre componetes.

# O projeto demonstra:

- Modelagem Orientada a Obsjetos
- Organização arquitetural
- Aplicação prática de padrões de projeto
- Separação de responsabilidade
- Código limpo, extensível e desacoplado

# Tecnologias e Conceitos Aplicados

- Java (JDK 25+)
- Programação Orientada a Objetos
   - Encapsulamento
   - Herança
   - Polimorfismo
   - Abstract
- Princípios SOLID
- Design Patterns
   - Factory
   - Observer
   - Singleton
- Tratamento de Exceções customizadas
- Organização por camadas

# Pré-requisitos

- Java JDK 25
- IDE Java (IntelliJ IDEA, Eclipse ou VS Code)

# Executando Projeto

1. Clone o repositório
2. Abra o projeto na IDE
3. Localize a class 'Main'
4. Execute o método 'main'

# Estrutura do Projeto

O projeto está organizado em pacotes, seguindo boas práticas de separação de responsabilidades.

- model -> ContaBancaria - ContaPoupanca
- service -> ContaService
- factory -> ContaFactory - ContaPoupancaFactory
- observer -> TipoEvento (ENUM) -> EventoConta -> Observer -> UsuarioObserver -> AuditoriaObserver -> GerenciadorNotificacao
- logging -> Logger -> ConsoleLogger (Holder)
- main -> Main

# Estrutura e Responsabilidade

## model

#### Responsável pelo domínio da aplicação

- ContaBancaria (classe abstract)
- ContaPoupanca

#### Função:

- Representa estado da conta- 
- implementar comportamento específico (rendimento)
- Mantém regras estruturais da entidade

> Aplicação do SRP (Single Responsability Principle).

## service

#### Camada responsável por regras de negócio.

- Validação de valores
- Controle de saldo
- Registro de logs
- Disparo de eventos

#### Centraliza a lógica e mantém o sistema desacoplado.
> Aplicação de DIP (Dependency Inversion Principle)

## factory

Implementa o padrão factory para criação de contas.

#### Benefícios:

- Evita uso direto de new
- Facilita extensão futura
- Atende ao princípio OCP

> Aplicação de OCP (Open/Closed Principle)

# observer

Implementa o padrão Observer, permitindo que usuários sejam notificados automaticamente quando eventos ocorrem no service com depósitos ou saques.

#### Fluxo:

- operação executa no Service
- Um evento é criado
- Observadores são notificados
- Logger registra a operação

 Permite extensão sem alterar regras existentes.

> Aplicação DIP (Dependency Inversion Principle)

> Aplicação OCP (Open/Closed Principle)

# logging

implementação de um Logger como Singleton (Holder Pattern) garantindo: 

- Apenas uma instância no sistema
- Controle centralizado de logs
- Baixo acoplamento

# exception

Eceções customizadas:

- ValorInvalidoException
- SaldoInsuficienteException


## Fluxo de Aplicação

1. A aplicação inicia na classe Main
2. A conta é criada via Factory
3. Observadores são registrados
4. Operaçães executadas via Service
5. Evento disparados
6. Observadores recebem notificação
7. Logger registra a operação

## Onde SOLID foi aplicado:

> SRP - Single Responsibility Principle
- Cada classe possui responsabilidade única

> OCP - Open/Closed Principle
- Novos tipos de contas ou observadores podem ser adicionados sem modificar códigos existente. 

> LSP - Liskov Substitution Principle
- ContaPoupanca e ContaCorrente pode substituir ContaBancaria sem quebrar o sistema.

> ISP - Interfaces Segregation Principle
- interfaces pequenas e especificas (Observer, Logger, Rendivel).

> DIP - Dependency Inversion Principle
- Service depende de abstrações, não implementações concretas.