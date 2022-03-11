CREATE DATABASE RedSocial;
use RedSocial;
CREATE TABLE usuario(id INT, mail VARCHAR(250), clave VARCHAR(256), 
    creado BIGINT, activo BOOLEAN, accesoNegadoContador INT, instanteBloqueo BIGINT, 
    instanteUltimoAcceso BIGINT, instanteUltimoCambioClave BIGINT,
    regeneraClaveToken VARCHAR(6), regeneraClaveInstante BIGINT,
    primary key(id));
CREATE TABLE rol(id INT, nombre VARCHAR(30), activo BOOL, primary key(id));
CREATE TABLE rolUsuario(idUsuario INT, idRol INT, primary key(idUsuario,idRol), foreign key(idUsuario) references usuario(id), foreign key(idRol) references rol(id));
INSERT INTO usuario VALUES(1,"goose@mail.com", "42a83c6132a2f3801191edec975f7f0f802fdfb373f9c3378043c93dbab70fd4", 0, 1, 0, 0,0,0,"",0); 

INSERT INTO rol VALUES(1,"ADMINISTRADOR", 1);
INSERT INTO rol VALUES(2,"USUARIO", 1);
INSERT INTO rolUsuario VALUES(1,1);
INSERT INTO rolUsuario VALUES(1,2);


CREATE VIEW mailRoles(id,nombre,activo,mail)
AS
    SELECT id,nombre,activo,mail FROM 
        (SELECT mail,idRol FROM usuario JOIN rolUsuario ON usuario.id = rolUsuario.idUsuario) as aux
    JOIN rol ON aux.idRol = rol.id WHERE activo = 1;