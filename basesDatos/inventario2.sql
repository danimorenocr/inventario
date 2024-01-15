-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-01-2024 a las 19:18:37
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anchetas`
--

CREATE TABLE `anchetas` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cant_productos` int(11) NOT NULL,
  `precio_parcial` int(11) NOT NULL,
  `utilidad` int(11) NOT NULL,
  `precio_domicilio` int(11) DEFAULT NULL,
  `valor_adicional` int(11) DEFAULT NULL,
  `precio_final` int(11) NOT NULL,
  `tipo_ancheta_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `anchetas`
--

INSERT INTO `anchetas` (`codigo`, `nombre`, `cant_productos`, `precio_parcial`, `utilidad`, `precio_domicilio`, `valor_adicional`, `precio_final`, `tipo_ancheta_codigo`) VALUES
(1, 'Ancheta 1', 5, 20000, 5000, NULL, NULL, 25000, 1),
(2, 'Ancheta 2', 4, 18000, 4500, NULL, NULL, 22500, 2),
(3, 'Ancheta 3', 6, 25000, 6000, NULL, NULL, 31000, 1),
(4, 'Ancheta 4', 3, 15000, 3000, NULL, NULL, 18000, 2),
(5, 'Ancheta 5', 2, 12000, 2000, NULL, NULL, 14000, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias_productos`
--

CREATE TABLE `categorias_productos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categorias_productos`
--

INSERT INTO `categorias_productos` (`codigo`, `nombre`) VALUES
(1, 'Electrónicos'),
(2, 'Ropa'),
(3, 'Hogar'),
(4, 'Alimentos'),
(5, 'Juguetes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`codigo`, `nombre`, `telefono`) VALUES
(1, 'Juan Pérez', '1234567890'),
(2, 'María García', '9876543210'),
(3, 'Luis Rodríguez', '5555555555'),
(4, 'Ana Martínez', '9999999999'),
(5, 'Pedro López', '1111111111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_anchetas`
--

CREATE TABLE `detalles_anchetas` (
  `productos_cod` int(11) NOT NULL,
  `anchetas_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalles_anchetas`
--

INSERT INTO `detalles_anchetas` (`productos_cod`, `anchetas_codigo`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `cod_historial` int(11) NOT NULL,
  `nombre_cliente` varchar(100) NOT NULL,
  `nombre_ancheta` varchar(100) NOT NULL,
  `precio_compra` int(11) NOT NULL,
  `fecha_compra` datetime NOT NULL,
  `medio_pago` varchar(100) NOT NULL,
  `estado_pago` varchar(50) NOT NULL,
  `cant_productos` int(11) NOT NULL,
  `productos` varchar(100) NOT NULL,
  `pedido_cod_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`cod_historial`, `nombre_cliente`, `nombre_ancheta`, `precio_compra`, `fecha_compra`, `medio_pago`, `estado_pago`, `cant_productos`, `productos`, `pedido_cod_venta`) VALUES
(101, 'Juan Pérez', 'Ancheta 1', 25000, '2023-01-15 08:00:00', 'Tarjeta de crédito', 'Pendiente', 2, 'Lista de productos', 101),
(102, 'María García', 'Ancheta 2', 22500, '2023-01-16 09:30:00', 'Transferencia bancaria', 'Pendiente', 1, 'Lista de productos', 102),
(103, 'Luis Rodríguez', 'Ancheta 3', 31000, '2023-01-17 10:45:00', 'Efectivo', 'Pendiente', 3, 'Lista de productos', 103),
(104, 'Ana Martínez', 'Ancheta 4', 18000, '2023-01-18 11:00:00', 'Efectivo', 'Pendiente', 1, 'Lista de productos', 104),
(105, 'Pedro López', 'Ancheta 5', 14000, '2023-01-19 12:00:00', 'Tarjeta de crédito', 'Pendiente', 2, 'Lista de productos', 105);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `cod_venta` int(11) NOT NULL,
  `nombre_ancheta` varchar(100) NOT NULL,
  `nombre_cliente` varchar(100) NOT NULL,
  `cant_ancheta` int(11) NOT NULL,
  `precio_total` int(11) NOT NULL,
  `fecha_venta` datetime NOT NULL,
  `fecha_entrega` datetime NOT NULL,
  `nombre_destinatario` varchar(100) NOT NULL,
  `mensaje` longtext NOT NULL,
  `medio_pago` varchar(100) NOT NULL,
  `direccion_entrega` varchar(50) NOT NULL,
  `anchetas_codigo` int(11) NOT NULL,
  `clientes_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`cod_venta`, `nombre_ancheta`, `nombre_cliente`, `cant_ancheta`, `precio_total`, `fecha_venta`, `fecha_entrega`, `nombre_destinatario`, `mensaje`, `medio_pago`, `direccion_entrega`, `anchetas_codigo`, `clientes_codigo`) VALUES
(101, 'Ancheta 1', 'Juan Pérez', 2, 25000, '2023-01-15 08:00:00', '2023-01-17 09:00:00', 'María Pérez', 'Feliz cumpleaños', 'Tarjeta de crédito', 'Calle 123, Ciudad', 1, 1),
(102, 'Ancheta 2', 'María García', 1, 22500, '2023-01-16 09:30:00', '2023-01-18 10:00:00', 'Ana García', 'Aniversario', 'Transferencia bancaria', 'Carrera 45, Ciudad', 2, 2),
(103, 'Ancheta 3', 'Luis Rodríguez', 3, 31000, '2023-01-17 10:45:00', '2023-01-19 11:00:00', 'Carlos Rodríguez', 'Celebración', 'Efectivo', 'Avenida 10, Ciudad', 3, 3),
(104, 'Ancheta 4', 'Ana Martínez', 1, 18000, '2023-01-18 11:00:00', '2023-01-20 12:00:00', 'Laura Martínez', 'Regalo', 'Efectivo', 'Calle 67, Ciudad', 4, 4),
(105, 'Ancheta 5', 'Pedro López', 2, 14000, '2023-01-19 12:00:00', '2023-01-21 13:00:00', 'María López', 'Agradecimiento', 'Tarjeta de crédito', 'Avenida Central, Ciudad', 5, 5);

--
-- Disparadores `pedido`
--
DELIMITER $$
CREATE TRIGGER `after_insert_pedido` AFTER INSERT ON `pedido` FOR EACH ROW BEGIN
    DECLARE cliente_nombre VARCHAR(100);

    -- Obtener el nombre del cliente para el registro de historial
    SELECT nombre INTO cliente_nombre
    FROM clientes
    WHERE codigo = NEW.clientes_codigo;

    -- Insertar el registro en la tabla historial
    INSERT INTO historial (cod_historial, nombre_cliente, nombre_ancheta, precio_compra, fecha_compra, medio_pago, estado_pago, cant_productos, productos, pedido_cod_venta)
    VALUES (NEW.cod_venta, cliente_nombre, NEW.nombre_ancheta, NEW.precio_total, NEW.fecha_venta, NEW.medio_pago, 'Pendiente', NEW.cant_ancheta, 'Lista de productos', NEW.cod_venta);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `cod` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `proveedor` varchar(100) NOT NULL,
  `num_cajas` int(11) DEFAULT NULL,
  `num_unidad_cajas` int(11) DEFAULT NULL,
  `total_unidades` int(11) NOT NULL,
  `precio_caja` int(11) DEFAULT NULL,
  `precio_unidad` int(11) NOT NULL,
  `envio` int(11) NOT NULL,
  `precio_final` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `stock` int(11) NOT NULL,
  `tamanno` decimal(10,2) DEFAULT NULL,
  `categorias_productos_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`cod`, `nombre`, `proveedor`, `num_cajas`, `num_unidad_cajas`, `total_unidades`, `precio_caja`, `precio_unidad`, `envio`, `precio_final`, `fecha_compra`, `fecha_vencimiento`, `stock`, `tamanno`, `categorias_productos_codigo`) VALUES
(1, 'Producto 1', 'Proveedor A', NULL, NULL, 100, NULL, 1500, 0, 0, '2023-01-01', '2023-12-31', 50, 10.50, 1),
(2, 'Producto 2', 'Proveedor B', NULL, NULL, 200, NULL, 800, 0, 0, '2023-01-02', '2023-12-30', 100, 8.00, 2),
(3, 'Producto 3', 'Proveedor C', NULL, NULL, 150, NULL, 2000, 0, 0, '2023-01-03', '2023-12-29', 75, 5.20, 1),
(4, 'Producto 4', 'Proveedor D', NULL, NULL, 120, NULL, 3000, 0, 0, '2023-01-04', '2023-12-28', 60, 15.00, 3),
(5, 'Producto 5', 'Proveedor E', NULL, NULL, 80, NULL, 500, 0, 0, '2023-01-05', '2023-12-27', 40, 3.80, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `cod_proveedor` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `telefono` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`cod_proveedor`, `nombre`, `ciudad`, `telefono`) VALUES
(1, 'Proveedor A', 'Ciudad A', '1111111111'),
(2, 'Proveedor B', 'Ciudad B', '2222222222'),
(3, 'Proveedor C', 'Ciudad C', '3333333333'),
(4, 'Proveedor D', 'Ciudad D', '4444444444'),
(5, 'Proveedor E', 'Ciudad E', '5555555555');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores_productos`
--

CREATE TABLE `proveedores_productos` (
  `proveedores_cod_proveedor` int(11) NOT NULL,
  `productos_cod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedores_productos`
--

INSERT INTO `proveedores_productos` (`proveedores_cod_proveedor`, `productos_cod`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_ancheta`
--

CREATE TABLE `tipo_ancheta` (
  `codigo` int(11) NOT NULL,
  `nombre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_ancheta`
--

INSERT INTO `tipo_ancheta` (`codigo`, `nombre`) VALUES
(1, 0),
(2, 0),
(3, 0),
(4, 0),
(5, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anchetas`
--
ALTER TABLE `anchetas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `Anchetas_categorias_ancheta` (`tipo_ancheta_codigo`);

--
-- Indices de la tabla `categorias_productos`
--
ALTER TABLE `categorias_productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `detalles_anchetas`
--
ALTER TABLE `detalles_anchetas`
  ADD PRIMARY KEY (`productos_cod`,`anchetas_codigo`),
  ADD KEY `productos_anchetas_anchetas` (`anchetas_codigo`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`cod_historial`),
  ADD KEY `historial_venta` (`pedido_cod_venta`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`cod_venta`),
  ADD KEY `venta_anchetas` (`anchetas_codigo`),
  ADD KEY `venta_clientes` (`clientes_codigo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`cod`),
  ADD KEY `Products_Categorias` (`categorias_productos_codigo`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`cod_proveedor`);

--
-- Indices de la tabla `proveedores_productos`
--
ALTER TABLE `proveedores_productos`
  ADD PRIMARY KEY (`proveedores_cod_proveedor`,`productos_cod`),
  ADD KEY `proveedores_productos_productos` (`productos_cod`);

--
-- Indices de la tabla `tipo_ancheta`
--
ALTER TABLE `tipo_ancheta`
  ADD PRIMARY KEY (`codigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `anchetas`
--
ALTER TABLE `anchetas`
  ADD CONSTRAINT `Anchetas_categorias_ancheta` FOREIGN KEY (`tipo_ancheta_codigo`) REFERENCES `tipo_ancheta` (`codigo`);

--
-- Filtros para la tabla `detalles_anchetas`
--
ALTER TABLE `detalles_anchetas`
  ADD CONSTRAINT `productos_anchetas_anchetas` FOREIGN KEY (`anchetas_codigo`) REFERENCES `anchetas` (`codigo`),
  ADD CONSTRAINT `productos_anchetas_productos` FOREIGN KEY (`productos_cod`) REFERENCES `productos` (`cod`);

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_venta` FOREIGN KEY (`pedido_cod_venta`) REFERENCES `pedido` (`cod_venta`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `venta_anchetas` FOREIGN KEY (`anchetas_codigo`) REFERENCES `anchetas` (`codigo`),
  ADD CONSTRAINT `venta_clientes` FOREIGN KEY (`clientes_codigo`) REFERENCES `clientes` (`codigo`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `Products_Categorias` FOREIGN KEY (`categorias_productos_codigo`) REFERENCES `categorias_productos` (`codigo`);

--
-- Filtros para la tabla `proveedores_productos`
--
ALTER TABLE `proveedores_productos`
  ADD CONSTRAINT `proveedores_productos_productos` FOREIGN KEY (`productos_cod`) REFERENCES `productos` (`cod`),
  ADD CONSTRAINT `proveedores_productos_proveedores` FOREIGN KEY (`proveedores_cod_proveedor`) REFERENCES `proveedores` (`cod_proveedor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
