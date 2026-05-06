# 🧾 ERP Sistema em Java (Console)

Sistema simples de ERP desenvolvido em Java com foco em prática de Programação Orientada a Objetos (POO), controle de estoque e autenticação de usuários com permissões.

## 🚀 Objetivo do Projeto

Este projeto foi criado para simular um sistema básico de ERP com funcionalidades de:

- Cadastro de produtos
- Controle de estoque
- Atualização de preços
- Sistema de login com múltiplos usuários
- Controle de permissões (Gerente e Funcionário)

O foco principal é praticar conceitos de POO, como encapsulamento, separação de responsabilidades e controle de acesso.

## 🧠 Funcionalidades

### 👤 Sistema de Usuários
- Login com nome e senha
- Suporte a múltiplos usuários
- Definição de tipos:
  - GERENTE
  - FUNCIONARIO
- Usuário autenticado é armazenado como sessão atual

---

### 📦 Gestão de Produtos
- Adicionar produto (restrito a GERENTE)
- Listar produtos
- Buscar produto por nome
- Remover produto (restrito a GERENTE)
- Atualizar preço (restrito a GERENTE)
- Gerenciar estoque (entrada e saída)

## 🔐 Sistema de Permissões

O sistema possui controle simples de permissões baseado no tipo de usuário:

- **GERENTE**
  - Pode adicionar produtos
  - Pode remover produtos
  - Pode alterar preços
  - Pode gerenciar estoque

- **FUNCIONARIO**
  - Pode visualizar produtos
  - Pode movimentar estoque

## 🏗️ Estrutura do Projeto

ERP/
├── Cadastro/
│ └── Cadastro.java
├── Produto/
│ └── Produto.java
├── Usuarios/
│ └── Usuario.java
├── Menu/
│ └── Menu.java

## 🧪 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Estruturas de dados (ArrayList)
- Console (CLI)

## 📌 Aprendizados

Durante o desenvolvimento deste projeto, foram aplicados conceitos como:

- Encapsulamento de dados
- Separação de responsabilidades por classe
- Controle de acesso baseado em regras de negócio
- Manipulação de listas em Java
- Lógica de autenticação simples

## ⚠️ Observações

- Projeto desenvolvido para fins educacionais
- Não utiliza banco de dados (dados em memória)

## 📈 Possíveis melhorias futuras

- Interface gráfica com Java Swing ou JavaFX
- Persistência em banco de dados (MySQL)
- Sistema de registro de usuários
- Histórico de movimentações de estoque
- Logs de ações por usuário


## 👨‍💻 Autor

Edson Emanuel  
Estudante e desenvolvedor em formação, focado em Java e Programação Orientada a Objetos (POO).

Projeto desenvolvido para prática de arquitetura de sistemas, lógica de negócio e simulação de ERP.
