-- Tabla factura
CREATE TABLE invoice (
    id BIGINT NOT NULL AUTO_INCREMENT,
    fecha DATE NOT NULL,
    nombre VARCHAR(45),
    documento BIGINT NOT NULL,
    codEmpleado INT NOT NULL,
    factura INT NOT NULL,

    PRIMARY KEY (id)
);

-- Detalle
CREATE TABLE invoice_detail (
    idDetail BIGINT NOT NULL AUTO_INCREMENT,
    idInvoice BIGINT NOT NULL,
    idProduct BIGINT NOT NULL, -- ✅ MISMO TIPO QUE product
    quantity INT NOT NULL,
    price DECIMAL(10,2),

    PRIMARY KEY (idDetail),

    CONSTRAINT fk_invoice_detail_invoice
        FOREIGN KEY (idInvoice) REFERENCES invoice(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_invoice_detail_product
        FOREIGN KEY (idProduct) REFERENCES product(idProduct)
);

-- IMEIs
CREATE TABLE invoice_imei (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    idDetail BIGINT NOT NULL,
    imei VARCHAR(20),

    CONSTRAINT fk_invoice_imei_detail
        FOREIGN KEY (idDetail) REFERENCES invoice_detail(idDetail)
        ON DELETE CASCADE
);