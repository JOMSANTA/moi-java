CREATE TABLE payroll (
    id INT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    code INT NOT NULL,
    name VARCHAR(45) NOT NULL,
    basico INT DEFAULT NULL,
    prepago INT DEFAULT NULL,
    postpago INT DEFAULT NULL,
    detalle VARCHAR(90) DEFAULT NULL,
    subtotal INT DEFAULT NULL,
    otros INT DEFAULT NULL,
    total INT DEFAULT NULL,
    PRIMARY KEY (id)
);