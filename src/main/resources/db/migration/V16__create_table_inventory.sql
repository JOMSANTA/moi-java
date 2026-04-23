CREATE TABLE inventory (
idInventory BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
quantity INT DEFAULT 0,
idProduct BIGINT NOT NULL,
INDEX (idProduct),
FOREIGN KEY (idProduct) REFERENCES product(idProduct)
);
