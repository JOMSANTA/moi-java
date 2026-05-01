CREATE TABLE _user (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(20) DEFAULT NULL,
last_name VARCHAR(20) DEFAULT NULL,
username VARCHAR(20) DEFAULT NULL,
role VARCHAR(20) DEFAULT NULL,
password VARCHAR(100) DEFAULT NULL,

UNIQUE KEY UK_user_username (username)
);

INSERT INTO _user (first_name, last_name, username, role, password)
VALUES ('administrador','buimon','admin', 'ADMIN', '$2a$10$X7Qm1Z9yYp5sFJk...');