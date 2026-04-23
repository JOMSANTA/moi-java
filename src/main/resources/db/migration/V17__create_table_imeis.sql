CREATE TABLE imeis (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    imei VARCHAR(50) NOT NULL,
    idProduct BIGINT NOT NULL,
    INDEX (idProduct),
    CONSTRAINT fk_imeis_product
    FOREIGN KEY (idProduct) REFERENCES product(idProduct)
) ENGINE=InnoDB;