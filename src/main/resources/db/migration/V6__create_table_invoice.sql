CREATE TABLE invoice (
    id BIGINT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    name VARCHAR(45),
    document BIGINT NOT NULL,
    codEmployee INT NOT NULL,
    invoice INT NOT NULL,

    PRIMARY KEY (id)
);