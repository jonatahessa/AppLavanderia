create table pdv(
    cnpj_pdv int not null primary key,
    nome_pdv varchar(255) not null
);

create table funcionario(
    CPF int not null primary key,
    Nome varchar(255) not null,
    Login varchar(255) not null,
    Senha varchar(255) not null,
    Cargo varchar(255) not null,
    Admissao date not null,
    PDV_funcionario int not null,
    CTPS varchar(255) not null,
    enabled varchar(20), 
    alterado_em date,
    alterado_por varchar(255)
);

create table venda(
    id_venda int not null primary key,
    Cliente_Cpf varchar(255) not null,
    pdv_venda varchar(255) not null,
    Servico varchar(255) not null,
    Quantidade int not null,
    Total varchar(255) not null,
    Data date not null
);

create table cliente(
    CPF int not null primary key,
    Nome varchar(255) not null,
    Email varchar(255) not null,
    Telefone varchar(255) not null,
    Sexo varchar(20) not null,
    enabled varchar(20) not null,
    alterado_em date,
    alterado_por varchar(255)
);

create table Servico(
    id_servico int not null primary key,
    Nome varchar(255) not null,
    Preco varchar(255) not null,
    enabled varchar(20) not null,
    alterado_em date,
    alterado_por varchar(255)
);

-- lógica para adicionar venda de cliente já cadastrado
INSERT INTO...... 
WHERE cod_tipo_usuario IN (SELECT cod_tipo_usuario FROM Tipos_Usuarios)

