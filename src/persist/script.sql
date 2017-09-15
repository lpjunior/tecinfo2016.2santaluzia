
use projeto06;

drop table if exists produto;
create table produto (
	id BIGINT primary key auto_increment,
	nmProduto varchar(50) not null,
	descProduto varchar(255),
	preco FLOAT8 not null,
	quantidade int not null
);

select * from produto;

drop table if exists funcionario;
create table funcionario (
	id BIGINT primary key auto_increment,
	nmFunc varchar(50) not null,
	email varchar(50) not null unique,
	login varchar(50) not null unique,
	senha varchar(50) not null
);

select * from funcionario;