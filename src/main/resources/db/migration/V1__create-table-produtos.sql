create table produtos (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    preco decimal(10,2) not null,

    primary key(id)
);