CREATE TABLE invoice_detail (
    idDetail BIGINT NOT NULL AUTO_INCREMENT,
    idInvoice BIGINT NOT NULL,
    idProduct BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2),

    PRIMARY KEY (idDetail),

    CONSTRAINT fk_invoice_detail_invoice
        FOREIGN KEY (idInvoice) REFERENCES invoice(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_invoice_detail_product
        FOREIGN KEY (idProduct) REFERENCES product(idProduct)
);