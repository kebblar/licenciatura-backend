CREATE DATABASE RedSocial;
use RedSocial;
CREATE TABLE usuario(id INT, mail VARCHAR(250), clave VARCHAR(256), creado BIGINT, activo BOOLEAN, accesoNegadoContador INT, instanteBloqueo BIGINT, instanteUltimoAcceso BIGINT, primary key(id));
INSERT INTO usuario VALUES(1,"goose@mail.com", "42a83c6132a2f3801191edec975f7f0f802fdfb373f9c3378043c93dbab70fd4", 0, 1, 0, 0,0); 