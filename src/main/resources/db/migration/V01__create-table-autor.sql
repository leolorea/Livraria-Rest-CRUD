CREATE TABLE autor (
  id bigint primary key AUTO_INCREMENT,
  data_nascimento datetime NOT NULL,
  nome varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  mini_curriculo varchar(500) NOT NULL
  
  )