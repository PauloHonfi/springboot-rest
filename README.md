# springboot-rest
Simples exercises for training a rest application with spring boot


####################################################################
##                      API Desafio                               ##
####################################################################

Criar uma API para controlar o carrinho de uma mini loja virtual.

Endpoints Necessários
  - Endpoint para obter o carrinho;
    - Com seu respectivo total.
  - Endpoint para inserir produtos no carrinho;
    - Caso não exista um carrinho ele deverá criar um carrinho novo;
    - Retornar as informações do carrinho junto com os produtos inseridos.
  - Endpoint para atualizar os produtos no carrinho;
    - Podendo atualizar a quantidade que será comprado de cada produto.
  - Endpoint para limpar os produtos do carrinho;
  - Endpoint para finalizar o carrinho;
  - Endpoint para consultar os pedidos (Carrinhos finalizados).
    - E Finalizar o carrinho.

Levar em consideração que os produtos já estão no banco e possuem os valores já estabelecidos:
{
  sku: 'S2390002',
  name: 'Blusa Plus Size Feminina Floral Manga Longa',
  stock: 4,
  is_in_stock: true,
  price: 55.20
}, {
  sku: 'S3904826',
  name: 'Blusa Feminina Laise Manga Curta',
  stock: 3,
  is_in_stock: false,
  price: 20.30
}, {
  sku: 'S6414902',
  name: 'Blusa Regata Feminina Estampa Folhas Alças Finas',
  is_in_stock: true,
  price: 30.40
}, {
  sku: 'S9763423',
  name: 'Blusa Feminina Botões Manga Curta'
  is_in_stock: false,
  price: 45.50
}

Obs: A forma de persistência pode ser escolhida livremente: Mongo, Mysql ou Persistência na memória;
Obs2: Caso não seja na memória será necessário mapear um docker com o banco escolhido.

Serão analisadas as melhores práticas de desenvolvimento e design de API.
Boa sorte :)
