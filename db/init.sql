USE estoque_db;

CREATE TABLE IF NOT EXISTS users (
    id            INT AUTO_INCREMENT PRIMARY KEY,
    username      VARCHAR(50)  NOT NULL UNIQUE,
    psw           VARCHAR(100) NOT NULL,
    nameFirst     VARCHAR(100),
    sobrenome     VARCHAR(100),
    matricula     VARCHAR(50),
    cpf           VARCHAR(14),
    sexo          VARCHAR(20),
    dtaNascimento VARCHAR(10),
    email         VARCHAR(100),
    telefone      VARCHAR(20),
    funcao        VARCHAR(50),
    cep           VARCHAR(9),
    endereco      VARCHAR(200),
    numero        VARCHAR(10),
    bairro        VARCHAR(100),
    cidade        VARCHAR(100),
    estado        VARCHAR(2),
    complemento   VARCHAR(200)
);
INSERT INTO users (
    username, psw, nameFirst, sobrenome, matricula, cpf,
    sexo, dtaNascimento, email, telefone, funcao,
    cep, endereco, numero, bairro, cidade, estado, complemento
) VALUES (
    'admin', '1234', 'Admin', 'Sistema', '0001', '000.000.000-00',
    'Masculino', '1990-01-01', 'admin@email.com', '71999999999', 'Administrador',
    '40000-000', 'Rua Exemplo', '123', 'Centro', 'Salvador', 'BA', 'N/A'
);