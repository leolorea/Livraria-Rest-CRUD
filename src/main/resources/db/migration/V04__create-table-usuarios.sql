CREATE table usuario 
(id bigint primary key AUTO_INCREMENT,
login varchar(20) NOT NULL,
senha varchar(100) NOT NULL );

insert into usuario values ('1', 'admin','$2a$10$eHxMzKeo81os./xjxPA24OsbSgGxQfUI1J25UseF0B0RO9OSojEB2');