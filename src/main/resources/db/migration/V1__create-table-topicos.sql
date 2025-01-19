CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(1000) NOT NULL,
    fecha_de_creacion DATETIME NOT NULL,
    status BOOLEAN NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    UNIQUE (titulo, mensaje(255))
);
