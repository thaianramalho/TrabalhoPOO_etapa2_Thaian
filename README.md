# Trabalho de Programação Orientada a Objetos

## Thaian Ramalho

### O que foi solicitado:

Crie as classes abstratas Produto e FormaPagamento. A classe Produto deve conter atributos
como código, nome, descrição, preço de custo, preço de venda, quantidade em estoque e
categoria (utilizar uma interface para definir as categorias). A classe FormaPagamento deve
conter atributos como tipo (dinheiro, cartão, cheque) e valor pago.
Crie as classes concretas ProdutoEletronico, ProdutoAlimenticio e ProdutoLimpeza, que
herdam da classe abstrata Produto. Cada classe concreta pode ter atributos e métodos
específicos, de acordo com a necessidade. Não é possível remover produtos que possuam
vendas realizadas;
Crie a classe concretas Cliente, com os seguintes atributos: nome, cpf, data de nascimento e email. Não é possível remover clientes que possuam compras;
Crie as classes concretas Dinheiro, Cartao e Cheque, que herdam da classe abstrata
FormaPagamento. Cada classe concreta deve implementar os métodos específicos para cada
forma de pagamento.
Crie uma classe Venda que armazene os produtos vendidos, o cliente, a forma de pagamento
utilizada e o valor total da venda. A classe deve conter métodos para adicionar produtos,
calcular o valor total da venda, aplicar descontos e finalizar a venda.
Crie uma classe GerenciadorEstoque que armazene uma lista de produtos e suas respectivas
quantidades. A classe deve fornecer métodos para adicionar, remover, buscar e atualizar
produtos, além gerar relatórios de estoque.
Todos os dados devem ser persistidos em banco de dados (mySQL).
Implemente uma interface gráfica utilizando o Java Swing que permita ao usuário:
Cadastrar novos produtos, informando todos os detalhes;
Consultar produtos por código, nome ou categoria;
Atualizar as informações de um produto;
Remover um produto do estoque;
Cadastrar, Editar e Remover Clientes;
Realizar vendas, selecionando os produtos, a quantidade e a forma de pagamento;
Visualizar o histórico de vendas;
Gerar relatórios de estoque;
Gerar relatórios de vendas com filtro de data de início e fim.