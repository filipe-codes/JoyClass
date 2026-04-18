CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE pedidos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT,
    valor DECIMAL(10,2),
    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE log_pedidos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pedido_id INT,
    acao VARCHAR(50),
    data_log DATETIME DEFAULT CURRENT_TIMESTAMP
);