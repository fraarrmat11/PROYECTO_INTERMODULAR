-- ========================================
-- Script MySQL nex
-- ========================================
-- Crear la base de datos

CREATE DATABASE IF NOT EXISTS app_nex
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- Seleccionar la base de datos
USE app_nex;
-- ========================
-- Tabla: nivel
-- ========================
CREATE TABLE nivel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    experiencia_necesaria INT NOT NULL,
    recompensa_monedas INT DEFAULT 0
);

-- ========================
-- Tabla: usuario
-- ========================
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    experiencia_actual INT DEFAULT 0,
    monedas INT DEFAULT 0,
    nivel_id INT,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (nivel_id) REFERENCES nivel(id)
);

-- ========================
-- Tabla: habito
-- ========================
CREATE TABLE habito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    objetivo INT NOT NULL,
    progreso_actual INT DEFAULT 0,
    experiencia_x_completar INT DEFAULT 0,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- ========================
-- Tabla: registro_habito
-- ========================
CREATE TABLE registro_habito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    habito_id INT NOT NULL,
    fecha DATE NOT NULL,
    cantidad INT NOT NULL,
    completado BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (habito_id) REFERENCES habito(id)
);

-- ========================
-- Tabla: diario
-- ========================
CREATE TABLE diario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    fecha DATE NOT NULL,
    contenido TEXT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- ========================
-- Tabla: logro
-- ========================
CREATE TABLE logro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    requisito INT NOT NULL,
    experiencia_x_desbloquear INT DEFAULT 0
);

-- ========================
-- Tabla: usuario_logro
-- ========================
CREATE TABLE usuario_logro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    logro_id INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (logro_id) REFERENCES logro(id)
);

-- ========================
-- Tabla: skin_tienda
-- ========================
CREATE TABLE skin_tienda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio INT NOT NULL,
    color_principal VARCHAR(7),
    descripcion TEXT
);

-- ========================
-- Tabla: usuario_skin
-- ========================
CREATE TABLE usuario_skin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    skin_id INT NOT NULL,
    fecha_compra DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (skin_id) REFERENCES skin_tienda(id)
);

-- ========================================
-- triggers para sumar experiencia
-- ========================================

-- Trigger para sumar XP al completar un registro de hábito
DELIMITER //
CREATE TRIGGER after_registro_habito_insert
AFTER INSERT ON registro_habito
FOR EACH ROW
BEGIN
    IF NEW.completado = TRUE THEN
        UPDATE usuario u
        JOIN habito h ON h.id = NEW.habito_id
        SET u.experiencia_actual = u.experiencia_actual + h.experiencia_x_completar
        WHERE u.id = h.usuario_id;
    END IF;
END;
//
DELIMITER ;

-- Trigger para sumar XP al desbloquear un logro
DELIMITER //
CREATE TRIGGER after_usuario_logro_insert
AFTER INSERT ON usuario_logro
FOR EACH ROW
BEGIN
    UPDATE usuario u
    JOIN logro l ON l.id = NEW.logro_id
    SET u.experiencia_actual = u.experiencia_actual + l.experiencia_x_desbloquear
    WHERE u.id = NEW.usuario_id;
END;
//
DELIMITER ;
