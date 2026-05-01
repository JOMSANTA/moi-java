CREATE TABLE client (
    idCliente BIGINT NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    cel INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    direccion VARCHAR(45),

    PRIMARY KEY (idCliente)
);