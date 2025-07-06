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
