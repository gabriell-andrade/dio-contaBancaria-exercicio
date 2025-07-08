# 💰 Projeto Conta Bancária

Este projeto é uma simulação simples de uma conta bancária, desenvolvida em Java, com foco em lógica de programação e orientação a objetos. O sistema permite realizar operações básicas como depósitos, saques, pagamentos e uso de cheque especial, respeitando regras realistas de funcionamento bancário.

---

## 🚀 Funcionalidades

- Consultar saldo e cheque especial
- Depositar dinheiro
- Sacar dinheiro com ou sem uso do cheque especial
- Pagar boletos
- Verificar se a conta está usando o cheque especial
- Aplicação de taxa de 20% sobre o valor utilizado do cheque especial

---

## 📌 Regras de negócio implementadas

- O cheque especial é definido no momento da criação da conta:
  - Se o depósito inicial for **R$500 ou menos**, o limite é **R$50 fixo**
  - Se o depósito inicial for **maior que R$500**, o limite é **50% do valor depositado**
- O cheque especial **diminui conforme é usado** e **só é recuperado via depósito**
- O valor do cheque especial **nunca ultrapassa o valor inicial definido**
- Ao utilizar o cheque especial (saldo negativo), é cobrada uma **taxa de 20%**
- O saldo **não pode ultrapassar o limite de saque (saldo + cheque especial disponível)**
- Interface simples via terminal com menu interativo

---

## 🧪 Exemplo de uso (via terminal)

```
Escolha uma opção:
1. Consultar Saldo
2. Consultar Cheque Especial
3. Depositar Dinheiro
4. Sacar Dinheiro
5. Pagar um Boleto
6. Verificar se está usando cheque especial
7. Sair
```

---

## 🛠 Tecnologias

- Java 17+
- Programação Orientada a Objetos
- Lógica de controle de fluxo
- `Scanner` para entrada de dados no terminal

---

## 📁 Estrutura

```
├── Main.java
└── ContaBancaria.java
```

---

## 📌 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/gabriell-andrade/conta-bancaria-java.git
   ```
2. Compile os arquivos:
   ```bash
   javac Main.java ContaBancaria.java
   ```
3. Execute o programa:
   ```bash
   java Main
   ```

---

## 🧠 Aprendizados

- Simulação de regras bancárias reais
- Boas práticas com métodos e validações
- Controle de estado (saldo vs. cheque especial)
- Cálculos e restrições com `Math.min()`, condicionais e fluxos complexos

---

## 📜 Licença

Este projeto é open-source e está sob a licença MIT.

---

## 👥 Colaboradores

| [<img src="https://avatars.githubusercontent.com/u/128552944?v=4" width="80"><br><sub>Gabriel Andrade</sub>](https://github.com/gabriell-andrade) |
|:--:|
