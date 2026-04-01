# Sistema de Pedidos em Java (CLI)

## Descrição

Este projeto é um sistema de gerenciamento de pedidos desenvolvido em Java utilizando Programação Orientada a Objetos (POO).

O sistema permite cadastrar clientes e produtos, criar pedidos, adicionar itens e controlar o status das compras, simulando um fluxo básico de um sistema comercial.

---

## Funcionalidades

* Cadastro de clientes
* Listagem de clientes
* Cadastro de produtos
* Listagem de produtos
* Criação de pedidos
* Adição de itens ao pedido
* Atualização automática do total do pedido
* Controle de estoque
* Alteração de status do pedido
* Remoção de clientes, produtos e pedidos

---

## Estrutura do Projeto

```
src/
├─ model/
│  ├─ Cliente.java
│  ├─ Produto.java
│  ├─ ItemPedido.java
│  └─ Pedido.java
│
├─ service/
│  ├─ ClienteService.java
│  ├─ ProdutoService.java
│  └─ PedidoService.java
│
├─ enums/
│  └─ StatusPedido.java
│
├─ app/
│  └─ Main.java
```

---

## Conceitos Utilizados

* Programação Orientada a Objetos (POO)

  * Encapsulamento
  * Abstração
  * Separação de responsabilidades

* Estruturas de dados

  * ArrayList

* Enum

  * Controle de status do pedido

* Organização em camadas (model / service)

---

## Como Executar

1. Clone o repositório:

```
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Abra o projeto em uma IDE (IntelliJ, Eclipse, VS Code)

3. Execute a classe:

```
Main.java
```

---

## Exemplo de Uso

* Criar cliente
* Criar produto
* Criar pedido para um cliente
* Adicionar itens ao pedido
* Visualizar o total atualizado automaticamente

---

## Autor

Luiz Fernando Leal Gomes.
