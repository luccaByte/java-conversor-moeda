# Conversor de Moedas

Este é um projeto em Java que realiza conversão de moedas usando dados de uma API de taxas de câmbio em tempo real.

## Visão Geral

O **Conversor de Moedas** permite que o usuário escolha duas moedas e insira um valor para ser convertido. A aplicação faz a consulta à API de taxas de câmbio e exibe o valor convertido com base nas taxas de câmbio atuais.

## Tecnologias

- **Java 21**
- **ExchangeRateApi**: [Clique aqui!](https://www.exchangerate-api.com/)
- **Gson**: Biblioteca desenvolvida pela Google para manipulação de JSONs

## Configuração do projeto

1. Clone o repositório:

```bash
git clone https://github.com/luccaByte/java-conversor-moeda
cd java-conversor-moeda
```

2. Adicione a dependência do Gson:

Se você estiver usando Maven, adicione a seguinte dependência ao seu arquivo pom.xml:
```xml
<dependency>
<groupId>com.google.code.gson</groupId>
<artifactId>gson</artifactId>
<version>2.10.1</version>
</dependency>
```
Se estiver usando Gradle, adicione ao seu arquivo build.gradle:

```groovy
implementation 'com.google.code.gson:gson:2.10.1'
```
Caso esteja utilizando o JAR do Gson, certifique-se de que o JAR esteja incluído no seu classpath.
