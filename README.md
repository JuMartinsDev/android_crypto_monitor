# 📱 Android Crypto Monitor

O **Android Crypto Monitor**, é um aplicativo  em Kotlin que tem como objetivo exibir a cotação atual do Bitcoin utilizando boas práticas, consumo de APIs com Retrofit e uma interface.

---

## 🧠 Sobre o Projeto

O objetivo é criar uma ferramenta simples e funcional, para acompanhar as variações do Bitcoin no mercado. O usuário pode visualizar as informações mais relevantes como nome da moeda e valor atual.

---

## 🔌 Retrofit e o consumo da API

Um dos pontos centrais do projeto é o **consumo de dados de uma API pública** do bitoin. Para isso, foi utilizada a biblioteca **Retrofit**, para chamadas HTTP no Android.

O Retrofit **simplifica a comunicação com APIs REST**, transformando automaticamente as respostas JSON em objetos Kotlin e facilita a integração dos dados com o app.

Foi criada uma **interface chamada `CryptoApiService`**, onde definimos os endpoints da API a ser consumida. Essa interface descreve, por exemplo, o método `getCryptocurrencies()`, que retorna uma lista de moedas com seus respectivos dados. Essa chamada é feita de forma assíncrona, e o Retrofit cuida de todo o processo de envio da requisição, recebimento da resposta, e transformação dos dados.

Para que o Retrofit saiba como se comportar, é necessário configurar uma **instância do Retrofit com um `Retrofit.Builder`**, e é aí que entra a **factory**: ela define a base da API (URL principal), o conversor (converter JSON para objeto Kotlin, no caso o `GsonConverterFactory`), e devolve uma instância funcional do Retrofit pronta para ser usada em qualquer lugar do app.

Essa instância é criada em um **singleton** ou função separada (normalmente em um arquivo `ApiFactory.kt`), para evitar que múltiplas instâncias sejam criadas. A vantagem disso é garantir que todas as chamadas de rede estejam centralizadas e otimizadas.

Em resumo: a API fornece os dados, o Retrofit faz a ponte entre a internet e o app, e a `factory` garante que essa ponte esteja sempre bem configurada.

---

## 💼 Service - Como o app conversa com a API?

A camada `service` contém a interface `CryptoApiService`, que define exatamente como o app vai se comunicar com a API. Ali estão os métodos que representam as requisições que o aplicativo pode fazer. Essa interface é interpretada pelo Retrofit, que constrói tudo por trás — desde abrir a conexão até lidar com a resposta e erros.

Separar essa camada é uma boa prática porque desacopla o código da rede do restante do app, facilitando testes e manutenções futuras.

---

## 🧾 Model - Onde os dados ganham forma

A camada `model` contém as classes que representam os dados recebidos da API. Por exemplo, a classe `CryptoCurrency` possui os mesmos atributos que vêm na resposta JSON — como nome, símbolo e valor atual.

Essas classes funcionam como "molde" para o Retrofit preencher com os dados da API. Depois, esses dados são passados para o ViewModel e, por fim, exibidos na interface do usuário.

---

## 🧠 ViewModel - Lógica da tela

O `ViewModel` age como intermediário entre os dados (model + service) e a interface (UI). Ele chama os métodos do `CryptoApiService`, pega os dados e transforma em algo fácil de exibir. Se a API falhar, ele também pode lidar com isso — mostrando mensagens de erro ou um estado de carregamento, por exemplo.

Essa camada ajuda a manter a interface limpa e focada apenas em exibir os dados, sem precisar se preocupar de onde os dados vêm ou como foram obtidos.

---

## 🎨 UI - Interface com Jetpack Compose

A interface foi feita utilizando **Jetpack Compose**, que é uma forma moderna de construir telas no Android diretamente com código Kotlin. Compose facilita a criação de layouts reativos, ou seja, se os dados mudam (como o valor de uma criptomoeda), a tela é automaticamente atualizada.

A tela principal mostra uma lista com as criptomoedas, e cada item da lista exibe o nome da moeda, seu símbolo e o valor atualizado em tempo real. A tela se comunica diretamente com o ViewModel, que fornece os dados prontos para serem exibidos.

---

## 🧾 Android XML?

Apesar da UI principal ter sido construída com Jetpack Compose, ainda usamos alguns arquivos XML, como o `AndroidManifest.xml`, que é essencial para configurar permissões (por exemplo, acesso à internet) e definir a `MainActivity`. Além disso, alguns recursos visuais como cores e temas ainda são definidos via XML nos diretórios `res/values`.

---
