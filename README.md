
# 💸 Simulador de Investimentos com Correção pela Inflação

Este projeto é uma evolução da primeira versão do simulador. Ele é uma aplicação Java orientada a objetos que
simula o retorno de investimentos em ativos reais, corrigidos pela inflação com integração do banco de dados SQLite.
Os dados foram coletados de fontes confiáveis como Google Finance, Status Invest, 
Banco Central do Brasil e CoinMarketCap. O objetivo é apresentar o rendimento **nominal** 
e **real** de diferentes ativos ao longo do tempo, utilizando conceitos de **POO**, 
**herança**, **interfaces**, **listas genéricas (`ArrayList`)** e **tratamento de dados históricos**.

-- AVISOS --

Esse programa é apenas um simulador de investimentos em ativos reais 
com dados coletados do passado até o momento presente (04/2025). 
Logo, é APENAS UMA DEMONSTRAÇÃO do poder dos juros compostos ao longo dos anos, 
SEM QUALQUER TIPO DE RECOMENDAÇÃO DE INVESTIMENTOS!

ESTE PROGRAMA FOI DESENVOLVIDO ESTRITAMENTE PARA FINS ACADÊMICOS!

NÃO ESTOU RECOMENDANDO QUALQUER INVESTIMENTO!

ME EXIMO DE QUALQUER DECISÃO INDIVIDUAL A RESPEITO DESTE TÓPICO!

RENDIMENTOS PASSADOS NÃO SÃO GARANTIA DE RENDIMENTOS FUTUROS!


-- AVISOS --

---

## ✅ Funcionalidades

- Cadastro de usuários
- Redefinição de senha do usuário
- Excusão de conta do usuário
- Simula investimentos em:
  - Tesouro SELIC (Renda Fixa)
  - PIBB11 (ETF Brasil)
  - IVVB11 (ETF Estados Unidos)
  - Bitcoin (Criptomoeda)
- Apresenta:
  - Rentabilidade percentual
  - Rendimento nominal
  - Valor corrigido pela inflação
  - Rendimento real (em R$)
- Interface gráfica com `JOptionPane`
- Baseado em dados reais

---

## 📦 Estrutura de Classes



---

## 📈 Diagrama UML



---

## 📊 Exemplo de saída (Renda Fixa)

```text
→ SIMULAÇÃO DO INVESTIMENTO EM TESOURO SELIC
  Valor investido: R$ 1000.00

05 anos - 12/2019 | 12/2024
  Rentabilidade: 51.11%
  Rendimento nominal: R$ 1511.09
  Inflação do período: 61.06%
  Valor corrigido pela inflação: R$ 1610.58
  ► Rendimento real: R$ -99.49
```

---

## 📚 Fontes dos Dados

Banco Central do Brasil: Calculadora do Cidadão
https://www3.bcb.gov.br/CALCIDADAO/publico/exibirFormCorrecaoValores.do?method=exibirFormCorrecaoValores&aba=1

Google Finance: PIBB11 e IVVB11
https://www.google.com/finance/quote/PIBB11:BVMF?sa=X&ved=2ahUKEwjnm6PP2eqMAxVeP7kGHR_EDvoQ3ecFegQIJxAX&window=MAX

https://www.google.com/finance/quote/IVVB11:BVMF?sa=X&ved=2ahUKEwi4mZ_Rke2MAxXfD7kGHTYtFDcQ3ecFegQILxAX&window=MAX

Status Invest: ETF IVVB11
https://statusinvest.com.br/etfs/ivvb11

CoinMarketCap: histórico do Bitcoin
https://coinmarketcap.com/currencies/bitcoin/

---

## 🧠 Conceitos Aplicados

- ✅ Herança (classe `Ativo`)
- ✅ Polimorfismo (implementação diferente em cada tipo de ativo)
- ✅ Interface (`Operacoes`)
- ✅ Classe abstrata (`Ativo`)
- ✅ Estrutura de dados (`ArrayList`)
- ✅ Cálculo com valores reais e inflação acumulada
- ✅ Interface gráfica MDI
- ✅ Integração com Banco de Dados SQLite

---

## 🛠️ Tecnologias utilizadas

- Java 17
- Swing (`JOptionPane`)
- NetBeans / VSCode
- Maven (opcional)

---

## 🚀 Como executar

1. Clone o repositório ou copie os arquivos
2. Abra no NetBeans, Eclipse ou IntelliJ
3. Compile e execute `Principal.java`
4. Insira o valor do investimento quando solicitado
5. Veja o relatório completo com rendimento real

---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos e educacionais. Livre para uso não comercial.
