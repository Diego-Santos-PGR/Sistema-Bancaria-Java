# Sistema de Conta Bancária em Java

Projeto desenvolvido com foco na consolidação de Programação Orientada a Objetos (POO), aplicação prática dos princípios SOLID e Design Patterns, estruturado como projeto de portifólio para nível Java Júnior.

## Objetivo do Projeto

Simular a arquitetura de um sistema bancário simplificado, aplicando boas práticas de desenvolvimento, organização em camadas e baixo acoplamento entre componetes.

O projeot demonstra capacidade de:

- Modelagem Orientada a Obsjetos
- Organização arquitetural
- Aplicação prática de padrões de projeto
- Separação de responsabilidade
- Escrita de código limpo e extensível

## Tecnologias e Conceitos Aplicados

- Java (JDK 21+)
- Programação Orientada a Objetos
   - Encapsulamento
   - Herança
   - Polimorfismo
- Princípios SOLID
- Design Patterns
   - Factory
   - Observer
   - Singleton
- Tratamento de Exceções customizadas
- Organização por camadas
- 
### Pré-requisitos

- Java JDK 21 ou Superior
- IDE Java (IntelliJ IDEA, Eclipse ou VS Code)

### Executando Projeto

1. Clone o repositório
2. Abra o projeto na IDE
3. Localize a class 'Main'
4. Execute o método 'main'

## Estrutura do Projeto

O projeto está organizado em pacotes, seguindo boas práticas de separação de responsabilidades.

- model -> ContaBancaria - ContaPoupanca
- service -> ContaService
- factory -> ContaFactory
- observer -> EventoConta -> Observer -> UsuarioObserver
- singleton -> Logger
- main -> Main

### Estrutura e Responsabilidade

### model

#### Responsável pelo domínio da aplicação

- ContaBancaria (classe abstract)
- ContaPoupanca

#### Função:

- Representa estado da conta
- Executar operações básicas (creditar, debitar)
- implementar comportamento específico (rendimento)

> Aplicação do SRP (Single Responsability Principle).

### service

#### Camada responsável por regras de negócio.

- Validação de valores
- Controle de saldo
- Registro de logs
- Disparo de eventos

> Centraliza a lógica e mantém o sistema desacoplado.

### factory

Implementa o padrão factory para criação de contas.

#### Benefícios:

- Evita uso direto de new
- Facilita extensão futura
- Atende ao princípio OCP

> Aplicação de OCP (Open Closed Principle)

### observer

Implementa o padrão Observer, permitindo que usuários sejam notificados automaticamente quando eventos ocorrem no service com depósitos ou saques.

#### Fluxo:

- Uma operação é realizada
- Um evento é criado
- Observadores são notificados
- Logger registra a operação

> Permite adicionar novos tipos de notificação sem alterar regras de negócio.

> Aplicação DIP (Dependency Inversion Principle)

> Aplicação OCP (Open Closed Principle)

### logging

implementação de um Logger como Singleton, garantindo: 

- Apenas uma instância no sistema
- Controle centralizado de logs
- Baixo acoplamento

### exception

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

SRP - Single Responsibility Principle
- Cada classe possui responsabilidade única

OCP - Open Closed Principle
- Novos tipos de contas ou observadores podem ser adicionados sem modificar códigos existente. 

LSP - Liskov Substitution Principle
- ContaPoupanca pode substituir ContaBancaria sem quebrar sistema.

ISP - Interfaces Segregation Principle
- interfaces pequenas e especificas (Observer, Logger).

DIP - Dependency Inversion Principle
- Service depende de abstrações, não implementações concretas.