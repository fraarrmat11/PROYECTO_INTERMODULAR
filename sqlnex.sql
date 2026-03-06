/*CREATE DATABASE sql_nex;
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL ON sql_nex.* TO 'admin'@'localhost'; */
use sql_nex;
-- id, experiencia_necesaria, nombre, recompensa_monedas

INSERT INTO nivel VALUES (NULL, 0,     'pringao', 0);
INSERT INTO nivel VALUES (NULL, 500,   'panoli', 50);
INSERT INTO nivel VALUES (NULL, 1000,  'paquete', 100);
INSERT INTO nivel VALUES (NULL, 1500,  'despistado', 150);
INSERT INTO nivel VALUES (NULL, 2000,  'novato', 200);

INSERT INTO nivel VALUES (NULL, 3000,  'animal doméstico', 300);
INSERT INTO nivel VALUES (NULL, 4000,  'constante', 400);
INSERT INTO nivel VALUES (NULL, 5000,  'disciplinado', 500);
INSERT INTO nivel VALUES (NULL, 6500,  'cumplidor', 650);
INSERT INTO nivel VALUES (NULL, 8000,  'en forma', 800);

INSERT INTO nivel VALUES (NULL, 10000, 'maquina', 1000);
INSERT INTO nivel VALUES (NULL, 12500, 'pro', 1250);
INSERT INTO nivel VALUES (NULL, 15000, 'bestia', 1500);
INSERT INTO nivel VALUES (NULL, 18000, 'leyenda urbana', 1800);
INSERT INTO nivel VALUES (NULL, 22000, 'referente', 2200);

INSERT INTO nivel VALUES (NULL, 27000, 'titán de hábitos', 2700);
INSERT INTO nivel VALUES (NULL, 33000, 'monstruo de la constancia', 3300);
INSERT INTO nivel VALUES (NULL, 40000, 'máquina imparable', 4000);
INSERT INTO nivel VALUES (NULL, 48000, 'semidiós disciplinado', 4800);
INSERT INTO nivel VALUES (NULL, 60000, 'dios absoluto del autocontrol', 6000);
describe skin_tienda;
INSERT INTO skin_tienda VALUES(NULL, "personajeNex.png", "por defecto", 0);
INSERT INTO skin_tienda VALUES(NULL, "personajeNexCarton.png", "Carton", 100);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexConejo.png", "Conejo", 300);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexFriki.png", "Friki", 500);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexPayaso.png", "Payaso", 700);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexEsqueleto.png", "Esqueleto", 1000);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexBoxeador.png", "Boxeador", 1500);

INSERT INTO skin_tienda VALUES (NULL, "personajeNexPirata.png", "Pirata", 1800);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexVaquero.png", "Vaquero", 2200);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexFuerte.png", "Fuerte", 2600);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexNinja.png", "Ninja", 2100);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexEspartano.png", "Espartano", 3000);

INSERT INTO skin_tienda VALUES (NULL, "personajeNexPrincesa.png", "Princesa", 2000);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexRey.png", "Rey", 2300);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexPapaNoel.png", "Papá Noel", 2200);

INSERT INTO skin_tienda VALUES (NULL, "personajeNexDinosaurio.png", "Dinosaurio", 5500);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexRobocop.png", "Robocop", 3500);

INSERT INTO skin_tienda VALUES (NULL, "personajeNexOmniMan.png", "Omni Man", 4000);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexSpiderman.png", "Spiderman", 5000);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexBatman.png", "Batman", 4500);
INSERT INTO skin_tienda VALUES (NULL, "personajeNexWalterWhite.png", "Walter White", 6000);



