CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(10),
    ano INT,
    cor VARCHAR(50),
    valor_diaria DECIMAL(10, 2)
);

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria) VALUES
    ('Volkswagen', 'Gol', 'RST6789', 2022, 'Azul', 110.00);

CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO pessoas (nome, cpf, telefone, email) VALUES
    ('Teste', '123456789', '32121665', 'teste@fiap.com.br');
