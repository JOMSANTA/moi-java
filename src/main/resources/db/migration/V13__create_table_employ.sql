CREATE TABLE employ (
    document BIGINT NOT NULL,
    name VARCHAR(45) NOT NULL,
    lastname VARCHAR(45) NOT NULL,
    code INT DEFAULT NULL,
    cel BIGINT NOT NULL,
    email VARCHAR(60) NOT NULL,
    role VARCHAR(45) NOT NULL,
    birthdate DATE DEFAULT NULL,
    branch VARCHAR(60)NOT NULL
);