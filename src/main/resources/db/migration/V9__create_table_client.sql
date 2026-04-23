CREATE TABLE client (
    idClient BIGINT NOT NULL,
    name VARCHAR(45) NOT NULL,
    lastname VARCHAR(45) NOT NULL,
    cel INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(45),

    PRIMARY KEY (idClient)
);