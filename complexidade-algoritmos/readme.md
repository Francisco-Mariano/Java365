# Complexidade de Algoritmos

## Introdução à Complexidade de Algoritmos

## Explicação da Notação Big O

## Exemplos de diferentes complexidades

## Código de Complexidade O(n)

### Busca Linear

O primeiro e mais simples exemplo é a _[Busca Linear](https://www.geeksforgeeks.org/linear-search/)_. Esse algoritmo percorre sequencialmente uma lista de valores (neste caso, nomes) e compara cada elemento com o valor desejado. Se encontrar uma correspondência, a busca é encerrada; caso contrário, continua até o final da lista. Esse método é intuitivo, mas pode ser ineficiente para listas grandes, pois sua complexidade no pior caso é _O(n)_.

##### Pseudocódigo

```
LINEAR-SEARCH(A, v)
1  for i = 1 to A.length
2      if A[i] == v
3          return true      // Retorna true, que foi encontrado o valor na busca (poderia retornar o índice de onde o elemento está)
4  return false             // Retorna false, que não foi encontrado o valor na busca (poderia retornar nulo)
```

O tempo de execução deste algoritmo depende da posição do elemento na lista:

|    Caso    |Complexidade| Informacões                                                                                                                    |
|------------|----|--------------------------------------------------------------------------------------------------------------------------------|
|Melhor caso |O(1)| Se o nome estiver na primeira posição, encontramos imediatamente e encerramos a busca                                          |
|Pior caso   |O(n)| Se o nome estiver na última posição ou não existir na lista, precisamos percorrer todos os elementos antes de concluir a busca |

Se você se interessou pelo algoritmo e deseja ver sua implementação em Java, confira o código disponível [aqui](./codes/LinearSearch.java).

### Verificação de Unicidade com Hash Table

Esse segundo exemplo é um pouco mais complexo, pois verifica a presença de valores duplicados em uma lista. Para resolver esse problema em tempo O(n), utilizamos o conceito de _[Hash Table](https://www.geeksforgeeks.org/hash-table-data-structure/)_.

O algoritmo percorre a lista e armazena cada valor em uma estrutura de dados com busca rápida, que no caso é a Hash Table. Como essa estrutura tem complexidade O(1) na média para inserção e busca, conseguimos garantir que o algoritmo funcione em O(n).

Se quiser conhecer mais sobre Hash, que significa "cortar e misturar", recomendamos fortemente a leitura do material da _[TopTal](https://www.toptal.com/big-data/consistent-hashing)_, que fornece uma excelente base para o entendimento e aplicação do conceito, além da estrutura de dados utilizada no Java.

##### Pseudocódigo

```
UNIQUENESS-CHECK(A)
1  Create Empty Hash Table 
2  hasDuplicated ← false
3  for i = 1 to A.length
4      if A[i] is in Hash Table
5          hasDuplicated ← true
6          break
7      else
8          Add A[i] to Hash Table
9  return hasDuplicated
```

A complexidade da verificação de duplicatas usando uma Hash Table é geralmente considerada O(n), pois a maioria das operações de inserção e busca ocorre em tempo constante, O(1), na média. Isso significa que, ao percorrer n elementos e realizar uma inserção ou verificação para cada um, o tempo total esperado é proporcional a n.

No entanto, é importante notar que, no pior caso, a complexidade pode se degradar para O(n²). Esse cenário extremo ocorreria se uma função hash mal projetada fizesse com que todos os elementos fossem mapeados para o mesmo bucket. Nessa situação, cada operação de busca ou inserção precisaria percorrer uma lista com n elementos, fazendo com que cada operação tivesse complexidade O(n). Assim, ao realizar essas operações para cada um dos n elementos, teríamos um custo total de O(n) × O(n) = O(n²).

O tempo de execução deste algoritmo:

|       Caso        |Complexidade| Informacões                                                                                                       |
|-------------------|------------|-------------------------------------------------------------------------------------------------------------------|
|Caso médio         |O(n)        | Devido à eficiência das operações de hash                                                                         |
|Pior caso          |O(n)        | Se houver muitas colisões na Hash Table, tornando a busca O(n) em casos extremos                                  |
|Pior caso teórico  |O(n²)       | Se ocorrerem colisões massivas que forcem todas as operações a percorrerem listas de tamanho n em um único bucket |

Nós consideramos que o pior caso é O(n), pois atualmente as implementações modernas de Hash Table como o HashMap/HashTable do Java e de outras linguagens, utilizam técnicas como:

- Redimensionamento Dinâmico: Ajustam o tamanho da tabela automaticamente para evitar muitas colisões;
- Funções Hash Eficientes: Distribuem bem os valores, reduzindo a chance de colisões excessivas;
- Encadeamento e Endereçamento Aberto: Técnicas que mantêm as operações rápidas mesmo em caso de colisões;

Portanto, na prática, a complexidade se mantém O(n) na maioria dos casos reais.

Se você se interessou pelo algoritmo e deseja ver sua implementação em Java, confira o código disponível [aqui](./codes/UniquenessCheck.java). Na versão anterior, para simplificar, usei o nome como chave e o valor 0. Porém, você pode armazenar o objeto completo Pessoa como valor. Confira [aqui](./codes/CompleteUniquenessCheck.java) um exemplo que utiliza a classe Pessoa completa.

### Verificação de Unicidade com Set

A interface Set faz parte do pacote java.util e estende a interface Collection. Ela representa um conjunto de elementos sem uma ordem definida e não permite valores duplicados.

O HashSet é muito útil quando precisamos armazenar elementos únicos sem nos preocupar com a ordem. Ele usa uma tabela hash, o que torna as operações de inserção, remoção e busca muito rápidas, com uma complexidade média de O(1).

##### Pseudocódigo

```
UNIQUENESS-CHECK-SET(A)
1  INICIO
2   listaNomes ← ["Jose", "João", "Maria", "Pedro", "Paula", "Jose"]
3   setNomes ← {}  // Conjunto vazio
4
5    PARA CADA elemento EM listaNomes FAÇA
6        SE elemento ESTÁ EM setNomes ENTÃO
7             EXIBIR "Nome duplicado: " + elemento
8        SENÃO
9             ADICIONAR elemento A setNomes
10              EXIBIR elemento
11       FIM SE
12   FIM PARA
12 FIM
```
- No exemplo, temos uma lista com valores repetidos e queremos garantir que os elementos fiquem únicos. Para isso, utilizamos o HashSet, que automaticamente elimina duplicatas.

|       Caso        |Complexidade| Informacões                                                                                                                            |
|-------------------|------------|----------------------------------------------------------------------------------------------------------------------------------------|
|Caso médio         |O(n)        | As operações de inserção, pesquisa e remoção em uma tabela hash têm complexidade O(1), ou seja, são muito rápidas.                     |
|Pior caso          |O(n)        | Se houver muitas colisões na tabela hash, a complexidade pode aumentar para O(n), mas isso é raro quando a função de hash é eficiente. |

## Código de Complexidade O(n²)

A notação O(n²) representa a complexidade de algoritmos cujo tempo de execução cresce quadraticamente em relação ao tamanho da entrada. Isso significa que, se dobrarmos o número 
de elementos de entrada (n), o tempo de execução será aproximadamente quatro vezes maior.

Essa complexidade ocorre, geralmente, quando um algoritmo possui dois loops aninhados iterando sobre os elementos de entrada. Como resultado, para cada elemento processado no primeiro
loop, o segundo loop também percorre todos os elementos, multiplicando o número total de operações.

```
UNIQUENESS-CHECK-BubbleSort(A)
1 INICIO
2   INICIAR listaMassaDados ← [2, 8, 5, 3, 9, 4, 1]
3    tamanhoLista ← tamanho(listaMassaDados)
4
5    PARA i de 1 até tamanhoLista - 1 FAÇA
6        PARA j de 0 até tamanhoLista - 2 FAÇA
7            SE listaMassaDados[j] > listaMassaDados[j + 1] ENTÃO
8                Trocar listaMassaDados[j] e listaMassaDados[j + 1]
9            FIM SE
10        FIM PARA
11    FIM PARA
12    Exibir listaMassaDados
13 FIM ALGORITMO
```

| Caso         | Complexidade | Informacões                                                                                                            |
|--------------|--------------|------------------------------------------------------------------------------------------------------------------------|
| Caso médio   | O(n²)        | O Bubble Sort, no caso médio, executa O(n²) operações, pois metade das trocas ainda é necessária para ordenar a lista. |
| Melhor Casdo | O(n²)        | No Bubble Sort, o melhor caso ocorre quando a lista já está totalmente ordenada.                                       |
| Pior caso    | O(n²)        | Ocorre quando a entrada está na pior disposição possível, exigindo o máximo número de operações.                       |




### Bubble Sort

## Recursos adicionais para aprofundamento

## Referências

- [A Guide to Consistent Hashing](https://www.toptal.com/big-data/consistent-hashing)
- [Hash Table](https://www.geeksforgeeks.org/hash-table-data-structure/)
- [Class HashMap<K,V> O](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
- [HashMap containsKey() Method in Java](https://www.geeksforgeeks.org/hashmap-containskey-method-in-java/)
- [Linear Search](https://www.geeksforgeeks.org/linear-search/)
- [HashSet](https://www.geeksforgeeks.org/hashset-in-java/)
- [BubbleSort](https://www.youtube.com/watch?v=xli_FI7CuzA)