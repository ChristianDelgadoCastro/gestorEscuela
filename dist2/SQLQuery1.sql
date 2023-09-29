use dbo;
CREATE TABLE calificaciones_asignatura (
    ncontrol int NOT NULL,
    grupo char(7) NOT NULL,
    nControlAsignatura char(5) NOT NULL,
    practicas decimal(3, 1),
    examen decimal(3, 1),
	vidaEscolar decimal(3, 1),
    promedioAsignatura decimal(3, 1),
    PRIMARY KEY (ncontrol, grupo, nControlAsignatura),
    FOREIGN KEY (ncontrol) REFERENCES alumnos(ncontrol), -- Ajusta el nombre de la tabla alumnos si es diferente
    FOREIGN KEY (grupo) REFERENCES grupos(grupo), -- Ajusta el nombre de la tabla grupos si es diferente
    FOREIGN KEY (nControlAsignatura) REFERENCES asignaturas(nControlAsignatura) -- Ajusta el nombre de la tabla asignaturas si es diferente
);