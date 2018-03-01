--tipo de atributo
insert into attribute_type (code, name) values (1, 'Mecânico');
insert into attribute_type (code, name) values (2, 'Inteligência');
insert into attribute_type (code, name) values (3, 'Força');
insert into attribute_type (code, name) values (4, 'Velocidade');
insert into attribute_type (code, name) values (5, 'Poder');
--atributo
insert into attribute (code, name, type_code) values (1, 'Braço Mecanico',1);
insert into attribute (code, name, type_code) values (2, 'Esqueleto Reforçado',3);
insert into attribute (code, name, type_code) values (3, 'Sentidos Aguçados',2);
insert into attribute (code, name, type_code) values (4, 'Pele Adaptativa',5);
insert into attribute (code, name, type_code) values (5, 'Raio Laser',5);
--[ braço mecânico, esqueleto reforçado, sentidos aguçados, pele adaptativa, raio laser]

--cyberpunk
insert into cyberpunk_human_robot (id, name, age, version, creation_date) values (1, 'Terminator', 35, '1', sysdate());
insert into cyberpunk_human_robot (id, name, age, creation_date, version) values (2, 'Solid Snake', 31, sysdate(), '1');
insert into cyberpunk_human_robot (id, name, age, creation_date, version) values (3, 'Darth Vader', 29, sysdate(), '1');
insert into cyberpunk_human_robot (id, name, age, creation_date, version) values (4, 'Kusanagi', 40, sysdate(), '1');
--adicionais
--insert into cyberpunk_attribute (id, cyberpunk_code, attribute_code) values (1, 1, 1);
--insert into cyberpunk_attribute (id, cyberpunk_code, attribute_code) values (2, 1, 4);
--insert into cyberpunk_attribute (id, cyberpunk_code, attribute_code) values (3, 2, 2);
--insert into cyberpunk_attribute (id, cyberpunk_code, attribute_code) values (4, 2, 5);
--insert into cyberpunk_attribute (id, cyberpunk_code, attribute_code) values (5, 3, 3);
--insert into cyberpunk_attribute (id, cyberpunk_code, attribute_code) values (6, 4, 6);
--insert into cyberpunk_attribute (id, cyberpunk_code, attribute_code) values (7, 4, 5);
--insert into cyberpunk_attribute (id, cyberpunk_code, attribute_code) values (8, 4, 2);

