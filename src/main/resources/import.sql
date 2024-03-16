-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into pessoa (id, nome, cpf) values(1, 'Tarantino', '111');
insert into pessoa (id, nome, cpf) values(2, 'Darth Vader', '222');
insert into pessoa (id, nome, cpf) values(3, 'Van gogh ', '333');

insert into estado (nome, sigla) values('Tocantins', 'TO');
insert into estado (nome, sigla) values('Pará', 'PA');

insert into cidade (nome, idEstado) values('Palmas', 1);
insert into cidade (nome, idEstado) values('Paraíso', 1);
insert into cidade (nome, idEtado) values('Goiânia', 2);