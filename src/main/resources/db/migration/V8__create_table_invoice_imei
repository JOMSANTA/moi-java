CREATE TABLE invoice_imei (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    idDetail BIGINT NOT NULL,
    imei VARCHAR(20),

    CONSTRAINT fk_invoice_imei_detail
        FOREIGN KEY (idDetail) REFERENCES invoice_detail(idDetail)
        ON DELETE CASCADE
);
