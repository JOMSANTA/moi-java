CREATE TABLE report (
    idReport BIGINT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    sucursal VARCHAR(60) NOT NULL,
    postpago INT DEFAULT NULL,
    kitContado INT DEFAULT NULL,
    kitCuotas INT DEFAULT NULL,
    tv INT DEFAULT NULL,
    otros VARCHAR(100) NOT NULL,
    quantity INT DEFAULT NULL,
    PRIMARY KEY (idReport)
);