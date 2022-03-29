[primeiraSolucao.pdf](https://github.com/jorgeleao/Sorting.a.Json.Array.by.the.values.of.a.key/files/8357972/primeiraSolucao.pdf)
# Sorting.a.Json.Array.by.the.values.of.a.key

Desenvolver uma forma de ordenar dados fornecidos como um array em uma “string json” em JAVA.

Embora a string json seja um array, cada elemento do array é um objeto que possui uma chave (aKey) comum a todos os elementos deste array, além de outros pares chave-valor.

Exemplo:
```javascript
  [
    {"aKey":" valor7 Abraháo uber2","zzz": "yyy"},
    {"aKey":" valor7 Abraháo über","zzz": "yyy"},
    {"zzz": "yyy", "aKey":" valor7 Abrahãm über"},
    {"aKey":"valor5","zzz": "yyy"},
    {"aKey":"  valor8","zzz": "yyy"},
    {"aKey":"valor6","zzz": "yyy"},
    {"zzz": "yyy","aKey":"  valor2"},
    {"zzz": "yyy","anotherKey":"  valor33"},
    {"aKey":" valor4","zzz": "yyy"},
    {"aKey":" valor-1","zzz": "yyy"},
    {"aKey":" valor+1","zzz": "yyy"},
    {"aKey":" valor*1","zzz": "yyy"},
    {"aKey":" valor1","zzz": "yyy"},
    {"aKey":" valor5","zzz": "yyy"},
    {"aKey":"   00valor5","zzz": "yyy"},
    {"aKey":" valor9","zzz": "yyy"}
  ]
```  

Supõe-se o caso geral. em que a posição do par “key:value” em cada objeto do array é arbitrária e irrelevante.

O processo de ordenamento deve ignorar os espaços em branco na frente dos valores, mas não alterá-los.

Se houver um elemento do array sem a chave “aKey”, o objeto json será excluido da saída ordenada.

A saída do ordenamento foi:
```javascript
[
  {"aKey":"   00valor5","zzz":"yyy"},
  {"aKey":" valor*1","zzz":"yyy"},
  {"aKey":" valor+1","zzz":"yyy"},
  {"aKey":" valor-1","zzz":"yyy"},
  {"aKey":" valor1","zzz":"yyy"},
  {"aKey":"  valor2","zzz":"yyy"},
  {"aKey":" valor4","zzz":"yyy"},
  {"aKey":" valor5","zzz":"yyy"},
  {"aKey":"valor6","zzz":"yyy"},
  {"aKey":" valor7 Abrahãm über","zzz":"yyy"},
  {"aKey":" valor7 Abraháo über","zzz":"yyy"},
  {"aKey":" valor7 Abraháo uber2","zzz":"yyy"},
  {"aKey":"  valor8","zzz":"yyy"},
  {"aKey":" valor9","zzz":"yyy"},
  null
]
```

Os valores da chave “aKey” nos objetos do array foram trimmed, toUpperCase e tiveram os diacríticos (acentos, cedilha, etc) removidos.

Uma listagem destas chaves modificadas, que foram usadas para o ordenamento, é:

00VALOR5

VALOR*1

VALOR+1

VALOR-1

VALOR1

VALOR2

VALOR4

VALOR5

VALOR6

VALOR7 ABRAHAM UBER

VALOR7 ABRAHAO UBER

VALOR7 ABRAHAO UBER2

VALOR8

VALOR9

     * TODO:
     
     * - Must accept repeated key values
     
     * - Must process json objects of arbitrary structure/content
     
     *   (not just the ones described by TwoKeyJsonObject)
     
     * - Must include objects without the referenced key at the end
     
