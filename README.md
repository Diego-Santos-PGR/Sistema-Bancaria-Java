# Sistema de Conta Bancária em Java

Projeto desenvolvido com objetivo de consolidar conceitos avançados de Programação Orientada a Objetos (POO) e aplicação prática dos princípios SOLID e Design Patterns, simulando a arquitetura de um sistema bancário simplificado.

## Objetivo do Projeto

Demonstrar
- Organização em camadas
- Baixo acoplamento
- Separação de responsabilidade
- Aplicação prática de Design Patterns
- Estrutura pensanda como projeto de portifólio nível Junior

## Tecnologias e Conceitos Utilizados

- Java (JDK 21+)
- Programação Orientada a Objetos (Encapsulamento, Abstração, Polimorfismo)
- Princípios SOLID
- Design Patterns
   - Factory
   - Observer
   - Singleton
- Tratamento de Exceções
- Organização de pacotes
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

- model -> ContaBancaria
- service -> ContaService
- factory -> ContaFactory
- observer -> EventoConta -> Observer -> UsuarioObserver
- singleton -> Logger
- main -> Main

### Estrutura e Responsabilidade

### model

Contém a classe ContaBancaria, responsável apenas pelo estado e regras básicas da conta.

Responsabilidade:
- Armazena saldo
- Executar depósito e saque
- dispara eventos

Aplicação do SRP (Single Responsability Principle).

### service

Camada responsável por orquestrar as operações do sistema.

Responsabilidade:
- Intermediar chamadas entre Main e Model
- Aplicar regras de negócio
- Manter o sistema desacoplado

Aplicação de separação de camadas

### factory

Implementa o padrão factory, centralizando a criação de contas.

Benefícios:
- Evita instanciar diretamente com new espalhado pelo código
- Facilita futuras extensões
- Melhora manutenção

Aplicação de OCP (Open Closed Principle)

### observer

Implementa o padrão Observer, permitindo que usuários sejam notificados automaticamente quando eventos ocorrem na conta bancária, com depósitos ou saques.

Fluxo:
- A conta executa uma operação
- Um evento é criado
- Observadores são notificados

Benefícios:
- Baixo acoplamento
- Sistema extensível
- Separação entre regra de negócio e notificação

Aplicação DIP (Dependency Inversion Principle)
Aplicação OCP (Open Closed Principle)

### singleton

implementação de um Logger como Singleton, garantindo: 

- Apenas uma instância no sistema
- Controle centralizado de logs

Benefício:
- Evita múltiplas instâncias desnecessárias
- Padrão comum em sistemas reais

## Fluxo de Aplicação

1. A aplicação inicia na classe Main
2. A conta é criada via Factory
3. Observadores são registrados
4. Operaçães de saque ou depósito são executadas via Service
5. Evento são disparados
6. Observadores recebem notificação
7. Logger registra a operação

## Onde SOLID foi aplicado:

SRP - Single Responsibility Principle

Cada classe tem uma responsabilidade:
- Conta -> estado e operações
- service -> regras de negócio
- Factory -> criação
- Logger -> registro

OCP - Open Closed Principle

É possível:
- Criar novos tipos de Observadores
- Criar novos tipos de conta sem modificar código existente

LSP - Liskov Substitution Principle

Arquitetura permite extensão futura mantendo comportamento esperado das abstrações.

ISP - Interfaces Segregation Principle

Observer implementam apenas a interface necessária.

DIP - Dependency Inversion Principle

A conta depende da abstração Observer, não de implementação concretas.





