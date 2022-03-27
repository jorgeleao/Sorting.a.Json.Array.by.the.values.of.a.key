# Sorting.a.Json.Array.by.the.values.of.a.key

Desenvolver uma forma de ordenar dados fornecidos como um array em uma “string json” em JAVA.

Embora a string json seja um array, cada elemento do array é um objeto que possui uma chave (aKey) comum a todos os elementos deste array, além de outros pares chave-valor.

Exemplo:

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

Observe que a linha em amarelo não possui a chave “aKey”.

Supõe-se o caso geral. em que a posição do par “key:value” em cada objeto do array é arbitrária e irrelevante.

O processo de ordenamento deve ignorar os espaços em branco na frente dos valores, mas não alterá-los.

Se houver um elemento do array sem a chave “aKey”, o objeto json será excluido da saída ordenada.

A saída do ordenamento foi:

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
