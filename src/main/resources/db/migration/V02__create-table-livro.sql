CREATE TABLE livro (
  id bigint primary key AUTO_INCREMENT,
  data_lancamento datetime NOT NULL,
  titulo varchar(45) NOT NULL,
  numero_paginas bigint not null,
  autor_id bigint not null
  )