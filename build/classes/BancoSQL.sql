CREATE TABLE pontos_coleta (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) UNIQUE,
    email VARCHAR(100),
    cidade VARCHAR(100),
    tipo_residuo VARCHAR(100),
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION
);


INSERT INTO pontos_coleta (nome, email, cidade, tipo_residuo, latitude, longitude)
VALUES ('PontoTeste1', 'teste1@email.com', 'CidadeA', 'Lãmpadas', -56.5505, -46.6333);
INSERT INTO pontos_coleta (nome, email, cidade, tipo_residuo, latitude, longitude)
VALUES ('PontoTeste2', 'teste2@email.com', 'CidadeB', 'Pilhas e Baterias', -22.9068, -43.1729);
