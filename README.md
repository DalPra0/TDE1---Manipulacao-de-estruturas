# TDE1 — Pilhas e Filas Dinâmicas
Autor: Lucas Dal Pra

## Estrutura do projeto
- **Main.java** — menu central do trabalho (ponto de entrada principal).
- **StackLinkedList.java** — pilha implementada com lista encadeada (`insere`, `remove`, `imprime`).
- **QueueLinkedList.java** — fila implementada com lista encadeada (`insere`, `remove`, `imprime`).
- **MergeList.java** — operação *merge* de duas filas ordenadas (implementação com lista encadeada).
- **MergeArray.java** — operação *merge* de duas filas ordenadas (implementação com vetor circular).

## Requisitos
- Java JDK 8 ou superior instalado.
- Compilador `javac` e comando `java` configurados no PATH.

## Como compilar
No terminal, dentro da pasta `src` (ou onde estão os arquivos):
```bash
javac *.java
````

## Como executar

O projeto agora tem um **menu centralizado**. Basta rodar:

```bash
java Main
```

## Menu principal

Ao rodar o `Main`, você verá:

```
=== TDE1 — Pilhas e Filas Dinâmicas ===
1) Pilha (StackLinkedList)
2) Fila (QueueLinkedList)
3) Merge com listas encadeadas
4) Merge com arrays
0) Sair
```

Cada opção abre o programa correspondente:

* **1** → pilha (inserir, remover, imprimir, demo).
* **2** → fila (inserir, remover, imprimir, demo).
* **3** → merge de filas encadeadas (modo demo ou manual).
* **4** → merge de filas em array (modo demo ou manual).
* **0** → sair.

## Exemplo de teste (valores do enunciado)

Se você escolher **3** (Merge com listas encadeadas) e rodar o demo:

* Fila A: `12 35 52 64`
* Fila B: `5 15 23 55 75`
* Resultado esperado do merge:

```
5 12 15 23 35 52 55 64 75
```

O mesmo vale para a opção **4** (Merge com arrays).

## Observações importantes

* Todos os elementos são do tipo `int`, conforme exigido no enunciado.
* Não foi utilizada nenhuma coleção pronta do Java (`Vector`, `LinkedList`, `ArrayList` etc.).
* Cada arquivo também pode ser executado individualmente se necessário, mas o **Main.java** centraliza tudo.
* Teste os programas antes de entregar e esteja pronto para explicar em sala como cada método funciona.

---
