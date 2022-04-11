CREATE DATABASE IF NOT EXISTS trivial;

USE trivial;

CREATE TABLE IF NOT EXISTS pregunta(
	id int primary key,
	texto tinytext,
	respuesta1 varchar(20),
	respuesta2 varchar(20),
	respuesta3 varchar(20),
	respuestaCorrecta int
)ENGINE=InnoDB;

INSERT INTO pregunta VALUES
(1,"Cargar más la voz o el acento sobre una nota o sílaba","Articular","Efundir","Herir",3),
(2,"Poéticamente, resplandor o brillo pronto y fugaz","Exhalación","Lampo","Farol",2),
(3,"Muerte violenta","Hecatombe","Óbito","Occisión",3),
(4,"Seda que se saca del capullo roto","Filadiz","Hilván","Múcara",1);

CREATE TABLE IF NOT EXISTS usuario(
	nombre varchar(3) primary key,
	puntuacion int
)ENGINE=InnoDB;