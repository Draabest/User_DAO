# User_DAO

# 🧪 Análise de Caixa Branca – Complexidade Ciclomática, Grafo de Fluxo e Caminhos Básicos

Este documento apresenta a análise estática realizada sobre o método:

public boolean verificarUsuario(String login, String senha)

🔷 1. Grafo de Fluxo
Nós identificados:

Nº   Descrição
1  |  Início do método
2  |  Obter conexão (conectarBD())
3  |  Montagem da SQL
4  |  Criação do Statement
5  |  Execução do Query
6  |  Decisão: if(rs.next())
7  |  Caminho verdadeiro → Usuário encontrado
8  |  Caminho falso → Usuário não encontrado
9  |  Retorno
Arestas:

1 → 2
2 → 3
3 → 4
4 → 5
5 → 6
6 → 7
6 → 8
7 → 9
8 → 9

🔷 2. Complexidade Ciclomática

A complexidade ciclomática é calculada pelas fórmulas padrão:

Método 1 – Fórmula Geral:

M = E − N + 2

Onde:

E = 9 arestas

N = 9 nós

Então:

M = 9 − 9 + 2 = 2

Método 2 – Contagem de decisões:

Número de decisões + 1

O método possui 1 decisão (if(rs.next())):

M = 1 + 1 = 2

✔ Complexidade Ciclomática Final: 2
🔷 3. Caminhos Básicos

De acordo com a complexidade, existem 2 caminhos independentes:

Caminho Básico 1 – Usuário encontrado

1 → 2 → 3 → 4 → 5 → 6(True) → 7 → 9

Caminho Básico 2 – Usuário não encontrado

1 → 2 → 3 → 4 → 5 → 6(False) → 8 → 9

🔷 4. Planilha de Teste (Caixa Branca)

A planilha preenchida contendo:

Código documentado

Nomenclatura adequada

Legibilidade e organização

Tratamento de NullPointer

Fechamento de conexões

Foi gerada e deve ser colocada na pasta /docs ou na raiz do projeto.
