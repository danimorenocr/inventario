drop database if exists db_vainilla;
CREATE database db_vainilla;
use db_vainilla;

-- tables
-- Table: anchetas
CREATE TABLE anchetas (
    codigo int  NOT NULL AUTO_INCREMENT,
    nombre varchar(100)  NOT NULL,
    cant_productos int  NOT NULL,
    precio_parcial int  NOT NULL,
    utilidad int  NOT NULL,
    precio_domicilio int  NULL,
    valor_adicional int  NULL,
    precio_final int  NOT NULL,
    tipo_ancheta_codigo int  NOT NULL,
    CONSTRAINT anchetas_pk PRIMARY KEY (codigo)
);

-- Table: categorias_productos
CREATE TABLE categorias_productos (
    codigo int  NOT NULL AUTO_INCREMENT,
    nombre varchar(100)  NOT NULL,
    CONSTRAINT categorias_productos_pk PRIMARY KEY (codigo)
);

-- Table: clientes
CREATE TABLE clientes (
    codigo int  NOT NULL AUTO_INCREMENT,
    nombre varchar(100)  NULL,
    telefono varchar(10)  NOT NULL,
    CONSTRAINT clientes_pk PRIMARY KEY (codigo)
);

-- Table: detalles_anchetas
CREATE TABLE detalles_anchetas (
    productos_cod int  NOT NULL AUTO_INCREMENT,
    anchetas_codigo int  NOT NULL,
    CONSTRAINT productos_anchetas_pk PRIMARY KEY (productos_cod,anchetas_codigo)
);

-- Table: historial
CREATE TABLE historial (
    cod_historial int  NOT NULL AUTO_INCREMENT,
    nombre_cliente varchar(100)  NOT NULL,
    nombre_ancheta varchar(100)  NOT NULL,
    precio_compra int  NOT NULL,
    fecha_compra datetime  NOT NULL,
    medio_pago varchar(100)  NOT NULL,
    estado_pago varchar(50)  NOT NULL,
    cant_productos int  NOT NULL,
    productos varchar(100)  NOT NULL,
    pedido_cod_venta int  NOT NULL,
    CONSTRAINT historial_pk PRIMARY KEY (cod_historial)
);

-- Table: pedido
CREATE TABLE pedido (
    cod_venta int  NOT NULL AUTO_INCREMENT,
    nombre_ancheta varchar(100)  NOT NULL,
    nombre_cliente varchar(100)  NOT NULL,
    cant_ancheta int  NOT NULL,
    precio_total int  NOT NULL,
    fecha_venta datetime  NOT NULL,
    fecha_entrega datetime  NOT NULL,
    nombre_destinatario varchar(100)  NOT NULL,
    mensaje longtext  NOT NULL,
    medio_pago varchar(100)  NOT NULL,
    estado_pago varchar(50)  NOT NULL,
    direccion_entrega varchar(50)  NOT NULL,
    anchetas_codigo int  NOT NULL,
    clientes_codigo int  NOT NULL,
    CONSTRAINT pedido_pk PRIMARY KEY (cod_venta)
);

-- Table: productos
CREATE TABLE productos (
    cod int  NOT NULL AUTO_INCREMENT,
    nombre varchar(100)  NOT NULL,
    proveedor varchar(100)  NOT NULL,
    num_cajas int  NULL,
    num_unidad_cajas int  NULL,
    total_unidades int  NOT NULL,
    precio_caja int  NULL,
    precio_unidad int  NOT NULL,
    envio int  NOT NULL,
    precio_final int  NOT NULL,
    fecha_compra date  NOT NULL,
    fecha_vencimiento date  NOT NULL,
    stock int  NOT NULL,
    tamanno decimal(10,2)  NULL,
    categorias_productos_codigo int  NOT NULL,
    CONSTRAINT productos_pk PRIMARY KEY (cod)
);

-- Table: proveedores
CREATE TABLE proveedores (
    cod_proveedor int  NOT NULL AUTO_INCREMENT,
    nombre varchar(100)  NOT NULL,
    ciudad varchar(100)  NOT NULL,
    telefono varchar(10)  NOT NULL,
    CONSTRAINT proveedores_pk PRIMARY KEY (cod_proveedor)
);

-- Table: proveedores_productos
CREATE TABLE proveedores_productos (
    proveedores_cod_proveedor int  NOT NULL AUTO_INCREMENT,
    productos_cod int  NOT NULL,
    CONSTRAINT proveedores_productos_pk PRIMARY KEY (proveedores_cod_proveedor,productos_cod)
);

-- Table: tipo_ancheta
CREATE TABLE tipo_ancheta (
    codigo int  NOT NULL AUTO_INCREMENT,
    nombre varchar(50)  NOT NULL,
    CONSTRAINT tipo_ancheta_pk PRIMARY KEY (codigo)
);

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    contrasenna VARCHAR(100) NOT NULL
);

-- foreign keys
-- Reference: Anchetas_categorias_ancheta (table: anchetas)
ALTER TABLE anchetas ADD CONSTRAINT Anchetas_categorias_ancheta FOREIGN KEY Anchetas_categorias_ancheta (tipo_ancheta_codigo)
    REFERENCES tipo_ancheta (codigo);

-- Reference: Products_Categorias (table: productos)
ALTER TABLE productos ADD CONSTRAINT Products_Categorias FOREIGN KEY Products_Categorias (categorias_productos_codigo)
    REFERENCES categorias_productos (codigo);

-- Reference: historial_venta (table: historial)
ALTER TABLE historial ADD CONSTRAINT historial_venta FOREIGN KEY historial_venta (pedido_cod_venta)
    REFERENCES pedido (cod_venta);

-- Reference: productos_anchetas_anchetas (table: detalles_anchetas)
ALTER TABLE detalles_anchetas ADD CONSTRAINT productos_anchetas_anchetas FOREIGN KEY productos_anchetas_anchetas (anchetas_codigo)
    REFERENCES anchetas (codigo);

-- Reference: productos_anchetas_productos (table: detalles_anchetas)
ALTER TABLE detalles_anchetas ADD CONSTRAINT productos_anchetas_productos FOREIGN KEY productos_anchetas_productos (productos_cod)
    REFERENCES productos (cod);

-- Reference: proveedores_productos_productos (table: proveedores_productos)
ALTER TABLE proveedores_productos ADD CONSTRAINT proveedores_productos_productos FOREIGN KEY proveedores_productos_productos (productos_cod)
    REFERENCES productos (cod);

-- Reference: proveedores_productos_proveedores (table: proveedores_productos)
ALTER TABLE proveedores_productos ADD CONSTRAINT proveedores_productos_proveedores FOREIGN KEY proveedores_productos_proveedores (proveedores_cod_proveedor)
    REFERENCES proveedores (cod_proveedor);

-- Reference: venta_anchetas (table: pedido)
ALTER TABLE pedido ADD CONSTRAINT venta_anchetas FOREIGN KEY venta_anchetas (anchetas_codigo)
    REFERENCES anchetas (codigo);

-- Reference: venta_clientes (table: pedido)
ALTER TABLE pedido ADD CONSTRAINT venta_clientes FOREIGN KEY venta_clientes (clientes_codigo)
    REFERENCES clientes (codigo);

-- End of file.

-- CREACION DE TRIGGER
DELIMITER //

CREATE TRIGGER agregar_a_historial
AFTER INSERT ON pedido
FOR EACH ROW
BEGIN
    DECLARE ancheta_nombre VARCHAR(100);
    DECLARE cliente_nombre VARCHAR(100);
    
    SELECT nombre INTO ancheta_nombre
    FROM anchetas
    WHERE codigo = NEW.anchetas_codigo;
    
    SELECT nombre INTO cliente_nombre
    FROM clientes
    WHERE codigo = NEW.clientes_codigo;
    
    INSERT INTO historial (
        nombre_cliente,
        nombre_ancheta,
        precio_compra,
        fecha_compra,
        medio_pago,
        estado_pago,
        cant_productos,
        productos,
        pedido_cod_venta
    )
    VALUES (
        cliente_nombre,
        ancheta_nombre,
        NEW.precio_total,
        NEW.fecha_venta,
        NEW.medio_pago,
        NEW.estado_pago,
        NEW.cant_ancheta,
        '', -- Aquí deberías agregar los productos relacionados con el pedido si los tienes disponibles en la tabla pedido
        NEW.cod_venta
    );
END;
//

DELIMITER ;




-- INSERCION DE DATOS
-- Inserción de datos en la tabla proveedores
INSERT INTO proveedores (nombre, ciudad, telefono)
VALUES 
('Proveedor 1', 'Ciudad 1', '1111111111'),
('Proveedor 2', 'Ciudad 2', '2222222222'),
('Proveedor 3', 'Ciudad 3', '3333333333'),
('Proveedor 4', 'Ciudad 4', '4444444444'),
('Proveedor 5', 'Ciudad 5', '5555555555');

-- Inserción de datos en la tabla categorias_productos
INSERT INTO categorias_productos (nombre)
VALUES 
('Categoria 1'),
('Categoria 2'),
('Categoria 3'),
('Categoria 4'),
('Categoria 5');

-- Inserción de datos en la tabla productos
INSERT INTO productos (nombre, proveedor, total_unidades, precio_unidad, envio, precio_final, fecha_compra, fecha_vencimiento, stock, categorias_productos_codigo)
VALUES 
('Producto 1', 'Proveedor 1', 100, 500, 100, 550, '2022-01-01', '2023-01-01', 50, 1),
('Producto 2', 'Proveedor 2', 150, 700, 120, 750, '2022-02-01', '2023-02-01', 80, 2),
('Producto 3', 'Proveedor 3', 200, 900, 150, 950, '2022-03-01', '2023-03-01', 100, 3),
('Producto 4', 'Proveedor 4', 120, 600, 110, 650, '2022-04-01', '2023-04-01', 70, 4),
('Producto 5', 'Proveedor 5', 180, 800, 130, 850, '2022-05-01', '2023-05-01', 90, 5);

-- Inserción de datos en la tabla proveedores_productos
INSERT INTO proveedores_productos (proveedores_cod_proveedor, productos_cod)
VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);


-- Inserción de datos en la tabla tipo_ancheta
INSERT INTO tipo_ancheta (nombre)
VALUES 
('Tipo 1'),
('Tipo 2'),
('Tipo 3'),
('Tipo 4'),
('Tipo 5');

-- Inserción de datos en la tabla anchetas
INSERT INTO anchetas (nombre, cant_productos, precio_parcial, utilidad, precio_final, tipo_ancheta_codigo)
VALUES 
('Ancheta 1', 10, 20000, 5000, 25000, 1),
('Ancheta 2', 8, 18000, 4000, 22000, 2),
('Ancheta 3', 12, 25000, 6000, 31000, 1),
('Ancheta 4', 6, 15000, 3000, 18000, 3),
('Ancheta 5', 15, 30000, 7000, 37000, 2);

-- Inserción de datos en la tabla detalles_anchetas
INSERT INTO detalles_anchetas (productos_cod, anchetas_codigo)
VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Inserción de datos en la tabla clientes
INSERT INTO clientes (nombre, telefono)
VALUES 
('Cliente 1', '1234567890'),
('Cliente 2', '0987654321'),
('Cliente 3', '1112223333'),
('Cliente 4', '4445556666'),
('Cliente 5', '7778889999');




-- Inserción de datos en la tabla pedido
INSERT INTO pedido (nombre_ancheta, cant_ancheta, precio_total, fecha_venta, fecha_entrega, nombre_destinatario, mensaje, medio_pago, estado_pago, direccion_entrega, anchetas_codigo, clientes_codigo)
VALUES 
('Ancheta 1',  1, 25000, '2023-01-15 10:00:00', '2023-01-20 09:00:00', 'Destinatario 1', 'Mensaje 1', 'Tarjeta', 'Pagado', 'Dirección 1', 1, 1),
('Ancheta 2',  1, 22000, '2023-02-20 12:30:00', '2023-02-25 10:00:00', 'Destinatario 2', 'Mensaje 2', 'Efectivo', 'Pendiente', 'Dirección 2', 2, 2),
('Ancheta 3',  1, 31000, '2023-03-10 15:45:00', '2023-03-15 08:30:00', 'Destinatario 3', 'Mensaje 3', 'Transferencia', 'Pagado', 'Dirección 3', 3, 3),
('Ancheta 4',  1, 18000, '2023-04-05 09:20:00', '2023-04-10 11:00:00', 'Destinatario 4', 'Mensaje 4', 'Tarjeta', 'Pagado', 'Dirección 4', 4, 4),
('Ancheta 5', 1, 37000, '2023-05-12 14:00:00', '2023-05-18 13:45:00', 'Destinatario 5', 'Mensaje 5', 'Efectivo', 'Entregado', 'Dirección 5', 5, 5);





