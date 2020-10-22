-- Inserindo dados iniciais de produto
INSERT INTO `produto` (`produto_id`, `descricao`, `preco`) VALUES
(1, 'Notebook Dell', 4160.21),
(2, 'Impressora HP', 2289.99),
(3, 'Mouse logitec', 41.99),
(4, 'Mochila Empirica', 345.99),
(5, 'Cadeira gamer', 2467.00),
(6, 'Celular Morotola G8', 999.99),
(7, 'Samsung Galaxy A5', 1199.19),
(8, 'Iphone 10', 7899.99),
(9, 'Tablet Positivo', 419.99),
(10, 'Monitor LG', 299.21);


-- Inserindo dados iniciais de carrinho
INSERT INTO `carrinho` (`carrinho_id`) VALUES
(1),
(2),
(3),
(4),
(5);

-- Inserindo dados iniciais de carrinho_produto
INSERT INTO `carrinho_produto` (`carrinho_id`, `produto_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(2, 6),
(4, 7),
(4, 9),
(4, 8),
(5, 9),
(5, 7),
(5, 10),