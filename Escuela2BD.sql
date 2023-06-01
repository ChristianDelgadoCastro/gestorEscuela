DROP DATABASE IF EXISTS Escuelapropuesta;
CREATE DATABASE Escuelapropuesta;
use Escuelapropuesta;

-- Tabla "alumnos"
CREATE TABLE alumnos (
  numControl INT PRIMARY KEY,
  nombre VARCHAR(50),
  apellidos VARCHAR(50),
  telefono int(20)
);

-- Tabla "asignaturas"
CREATE TABLE asignaturas (
  numControlAsignatura INT PRIMARY KEY auto_increment,
  nombreAsignatura VARCHAR(50)
);

-- Tabla "grupo"
CREATE TABLE grupo (
  idGrupo INT PRIMARY KEY AUTO_INCREMENT,
  numControlGrupo VARCHAR(15),
  nombreGrupo VARCHAR(50),
  numControlAsignatura INT,
  FOREIGN KEY (numControlAsignatura) REFERENCES asignaturas(numControlAsignatura)
);

ALTER TABLE grupo ADD INDEX idx_numControlGrupo (numControlGrupo);

DROP TABLE IF EXISTS alumnos_grupo;
CREATE TABLE alumnos_grupo (
  id INT PRIMARY KEY AUTO_INCREMENT,
  numControlGrupo VARCHAR(15),
  numControlAlumno INT,
  nombreAlumno VARCHAR(50),
  apellidosAlumno VARCHAR(50),
  numControlAsignatura INT,
  calificaciones VARCHAR(50),
  FOREIGN KEY (numControlGrupo) REFERENCES grupo(numControlGrupo),
  FOREIGN KEY (numControlAlumno) REFERENCES alumnos(numControl),
  FOREIGN KEY (numControlAsignatura) REFERENCES asignaturas(numControlAsignatura)
);


CREATE TABLE usuarios (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(253) NOT NULL,
  `email` varchar(253) NOT NULL,
  `telefono` varchar(253) NOT NULL,
  `username` varchar(253) NOT NULL,
  `password` varchar(253) NOT NULL,
  `tipo_nivel` varchar(253) NOT NULL,
  PRIMARY KEY (`id_usuario`)
  );
  
INSERT INTO usuarios VALUES (1,'Christian','christian.delgado.exe@gmail.com','4765432101','admin','admin','Administrador');
  
  
  
  