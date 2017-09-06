use projeto06;
create table produto (
	id BIGINT primary key auto_increment,
	nmProduto varchar(50),
	descProduto varchar(255),
	preco FLOAT8,
	quantidade int
);