# Crypto Monitor (Jetpack Compose)

## Sobre o projeto

O **Crypto Monitor** é um aplicativo Android que permite acompanhar o valor e a data/hora de cotações de criptomoedas, utilizando dados da **API do Mercado Bitcoin**.

O projeto original do semestre passado utilizava **layouts em XML**, e nesta versão ele foi migrado para **Jetpack Compose**, mantendo **toda a funcionalidade original**. Ou seja, a interface agora é declarativa, mas a lógica de consulta e exibição dos dados permanece a mesma.

---
## Dupla

Julia Martins de Almeida Antunes RM98601
Ana Luisa Giaquinto Zólio RM99348

---

## Objetivos da migração

* Transformar o layout XML em **Jetpack Compose**.
* Preservar a funcionalidade do app original (exibir valor e data/hora da cotação, atualizar via API).
* Aproveitar os recursos modernos do Compose, como **estados reativos**, recomposição automática e layouts declarativos.
* Melhorar organização e legibilidade do código.

---

## Estrutura do projeto

### MainActivity.kt

Classe principal que inicia a interface declarativa:

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoMonitorarTheme {
                CryptoScreen()
            }
        }
    }
}
```

* `setContent {}` substitui o antigo `setContentView()` do XML.
* `CryptoScreen()` é o Composable principal da interface.
* `CryptoMonitorarTheme` aplica o tema do Material Design 3.

---

### CryptoScreen.kt

Composable que renderiza a tela principal:

* **Estados mutáveis** (`value` e `date`) para manter os dados da cotação.
* Consulta a **API do Mercado Bitcoin** usando `CoroutineScope` integrado ao Compose (`rememberCoroutineScope()`).
* Formata o **valor da criptomoeda** com `NumberFormat` para moeda brasileira.
* Formata a **data/hora** com `SimpleDateFormat` ajustado para o fuso horário de Brasília (`America/Sao_Paulo`).
* Layout declarativo usando `Column`, `Spacer` e outros composables.

---

### ToolbarMain.kt e QuoteInformation.kt

* `ToolbarMain`: barra superior da tela, substituindo o antigo `Toolbar` XML.
* `QuoteInformation`: exibe valor e data/hora da cotação, e contém botão para atualizar os dados.

---

### MercadoBitcoinServiceFactory.kt

Responsável por criar o serviço de requisição HTTP à API.

* Utiliza Retrofit para consultas.
* Retorna os dados da cotação (valor e timestamp).
* A lógica de parsing e atualização permanece igual à versão XML.

---

## Migração para Jetpack Compose

* **Layouts declarativos** substituem XML.
* `@Composable` substitui Views do XML.
* `remember { mutableStateOf(...) }` substitui o gerenciamento manual de estados.
* Layouts como `Column`, `Box` e `Spacer` substituem `LinearLayout` e `FrameLayout`.
* Recomposição automática: quando os estados `value` e `date` mudam, a UI atualiza sem métodos extras.

---

## Tecnologias utilizadas

* Kotlin
* Jetpack Compose (Material3)
* Retrofit + Coroutines
* SimpleDateFormat e NumberFormat
* Theme personalizado com Compose

---

## Considerações finais

O projeto mantém **todas as funcionalidades do app XML**, mas agora com **uma abordagem moderna e declarativa** usando Jetpack Compose.
Isso permite código mais limpo, manutenção mais fácil e melhor desempenho de UI reativa.

---

<img width="487" height="755" alt="image" src="https://github.com/user-attachments/assets/5d7d10d0-2859-46c2-a030-ddf60f6d6ac4" />

---

<img width="450" height="835" alt="image" src="https://github.com/user-attachments/assets/6b2c36ec-2bfb-46fa-a764-e7512cdffc32" />


