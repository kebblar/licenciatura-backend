CREATE DATABASE RedSocial;
use RedSocial;
CREATE TABLE usuario(id SERIAL, mail VARCHAR(250), clave VARCHAR(256), 
    creado BIGINT, activo BOOLEAN, accesoNegadoContador INT, instanteBloqueo BIGINT, 
    instanteUltimoAcceso BIGINT, instanteUltimoCambioClave BIGINT,
    regeneraClaveToken VARCHAR(6), regeneraClaveInstante BIGINT,
    primary key(id));

CREATE TABLE usuario(id SERIAL, 
    titulo VARCHAR(256), 
    propietario_mail VARCHAR(256), 
    texto_plano VARCHAR(256), 
    comentarios VARCHAR(256),
    n_me_gusta BIGINT);

CREATE TABLE rol(id INT, nombre VARCHAR(30), activo BOOL, primary key(id));
CREATE TABLE rolUsuario(idUsuario BIGINT UNSIGNED, idRol INT, primary key(idUsuario,idRol), foreign key(idUsuario) references usuario(id), foreign key(idRol) references rol(id));

CREATE TABLE usuarioDetalle(idUsuario BIGINT UNSIGNED primary key, nombre VARCHAR(50), primerApellido VARCHAR(50), segundoApellido VARCHAR(50),
 nickName VARCHAR(50), fechaNacimiento DATE, telefonoCelular VARCHAR(12), foreign key(idUsuario) references usuario(id));

CREATE TABLE preregistro(idUsuario SERIAL, nick VARCHAR(50), 
correo VARCHAR(50), claveHash VARCHAR(256), randomString VARCHAR(20),
instanteRegistro BIGINT, fechaNacimiento DATE, telefono VARCHAR(12), nombre VARCHAR(50), primerApellido VARCHAR(50), 
segundoApellido VARCHAR(50));

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

CREATE TABLE publicacion(
    publicacion_id VARCHAR(50) NOT NULL,
    usuario_creador_id VARCHAR(50) NOT NULL,
    texto_publicacion VARCHAR(1000),
    fecha_creacion TIMESTAMP NOT NULL,
    es_publica BOOLEAN NOT NULL DEFAULT FALSE,
    primary key(publicion_id)
);

CREATE TABLE comentario(
    comentario_id VARCHAR(50) NOT NULL,
    publicacion_id VARCHAR(50) NOT NULL,
    usuario_creador_id VARCHAR(50) NOT NULL,
    comentario VARCHAR(1000) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    primary key(comentario_id),
    foreign key(comentario_id) references publicaion(publicacion_id)
);

CREATE TABLE imagen(
    imagen_id VARCHAR(50) NOT NULL,
    publicacion_id VARCHAR(50) NOT NULL,
    imagen BYTEA NOT NULL,
    primary key(imagen_id),
    foreign key(imagen_id) references publicaion(publicacion_id)
);

CREATE TABLE video(
    video_id VARCHAR(50) NOT NULL,
    publicacion_id VARCHAR(50) NOT NULL,
    video VARCHAR NOT NULL,
    primary key(video_id),
    foreign key(video_id) references publicaion(publicacion_id)
);

CREATE TABLE gif(
    gif_id VARCHAR(50) NOT NULL,
    publicacion_id VARCHAR(50) NOT NULL,
    gif VARCHAR NOT NULL,
    primary key(gif_id),
    foreign key(gif_id) references publicaion(publicacion_id)
);