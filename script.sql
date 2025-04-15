DROP TABLE peliculas CASCADE CONSTRAINTS;

CREATE TABLE peliculas (
  id               NUMBER(8) NOT NULL,
  titulo           VARCHAR2(500) NOT NULL,
  año              NUMBER(8) NOT NULL,
  director         VARCHAR2(250) NOT NULL,
  genero           VARCHAR2(250) NOT NULL,
  sinopsis         VARCHAR2(500) NOT NULL
);

ALTER TABLE peliculas ADD CONSTRAINT pk_peliculas PRIMARY KEY ( id );


INSERT INTO peliculas VALUES (1,'El Padrino',1972,'Francis Ford Coppola','Crimen/Drama','Don Vito Corleone es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York en los años 40. El hombre tiene cuatro hijos: Connie, Sonny, Fredo y Michael, que no quiere saber nada de los negocios sucios de su padre.');
INSERT INTO peliculas VALUES (2,'Perros de la calle',1992,'Quentin Tarantino','Suspenso/Crimen','Seis criminales profesionales son contratados para robar en un almacén de diamantes, pero la policía aparece inesperadamente en el momento del atraco. Algunos miembros de la banda mueren en el enfrentamiento y otros logran huir.');
INSERT INTO peliculas VALUES (3,'Avatar',2009,'James Cameron','Ciencia ficción/Acción','Entramos en el mundo Avatar de la mano de Jake Sully, un ex-Marine en silla de ruedas, que ha sido reclutado para viajar a Pandora, donde existe un mineral raro y muy preciado que puede solucionar la crisis energética existente en la Tierra.');
INSERT INTO peliculas VALUES (4,'Star Wars: Episodio III - La venganza de los Sith',2005,'George Lucas','Ciencia ficción/Acción','¡Guerra! La República se desmorona bajo los ataques del despiadado Lord Sith, el conde Dooku. Hay héroes en ambos bandos, pero el mal está por doquier.');
INSERT INTO peliculas VALUES (5,'Rápido y furioso: reto Tokio',2006,'Justin Lin','Acción/Crimen','Shaun Boswell es un chico rebelde cuya única conexión con el mundo es a través de las carreras ilegales. Cuando la policía le amenaza con encarcelarle, se va a pasar una temporada con su tío, un militar destinado en Japón.');