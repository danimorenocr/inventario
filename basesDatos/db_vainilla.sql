-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-02-2024 a las 02:59:41
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
-- Base de datos: `inventario_final`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anchetas`
--

CREATE TABLE `anchetas` (
  `cod_ancheta` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipo_ancheta` varchar(10) NOT NULL,
  `cant_productos` int(11) NOT NULL,
  `precio_parcial` int(11) NOT NULL,
  `utilidad` int(11) NOT NULL,
  `precio_domicilio` int(11) DEFAULT NULL,
  `valor_adicional` int(11) DEFAULT NULL,
  `precio_final` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_productos`
--

CREATE TABLE `categoria_productos` (
  `cod_categoria` int(11) NOT NULL,
  `nombre_categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria_productos`
--

INSERT INTO `categoria_productos` (`cod_categoria`, `nombre`) VALUES
(15, 'GLOBOS '),
(16, 'ESFERAS ACRILICAS '),
(17, 'CINTAS'),
(18, 'ESFERAS PLASTICAS'),
(19, 'RESMA FOTOGRAF'),
(20, 'PELUCHES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cod_cliente` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `cod_pedido` int(11) NOT NULL,
  `nombre_ancheta` varchar(100) NOT NULL,
  `cant_ancheta` int(11) NOT NULL,
  `precio_total` int(11) NOT NULL,
  `fecha_venta` datetime NOT NULL,
  `fecha_entrega` datetime NOT NULL,
  `nombre_destinatario` varchar(100) NOT NULL,
  `mensaje` longtext NOT NULL,
  `medio_pago` varchar(100) NOT NULL,
  `direccion_entrega` varchar(50) NOT NULL,
  `cod_ancheta` int(11) NOT NULL,
  `cod_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `cod_producto` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `num_cajas` int(11) DEFAULT NULL,
  `num_unidad_cajas` int(11) DEFAULT NULL,
  `precio_caja` int(11) DEFAULT NULL,
  `precio_unidad` int(11) NOT NULL,
  `precio_total_compra` int(11) NOT NULL,
  `envio` int(11) NOT NULL,
  `precio_final` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `stock` int(11) NOT NULL,
  `tamanno` decimal(10,2) DEFAULT NULL,
  `precioMetro` int(11) DEFAULT NULL,
  `precio_unidad_con_envio` int(11) NOT NULL,
  `cod_proveedor` int(11) NOT NULL,
  `cod_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`cod_producto`, `nombre`, `num_cajas`, `num_unidad_cajas`, `precio_caja`, `precio_unidad`, `precio_total_compra`, `envio`, `precio_final`, `fecha_compra`, `fecha_vencimiento`, `stock`, `tamanno`, `precioMetro`, `precio_unidad_con_envio`, `cod_proveedor`, `cod_categoria`) VALUES
(1, 'OSO', 0, 0, 0, 50000, 50000, 2000, 52000, '2017-11-10', '2024-01-06', 1, 0.00, 0, 52000, 9, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_anchetas`
--

CREATE TABLE `productos_anchetas` (
  `cod_producto` int(11) NOT NULL,
  `cod_ancheta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `cod_proveedor` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`cod_proveedor`, `nombre`, `ciudad`, `telefono`) VALUES
(9, 'BOGOTA ', 'BOGOTA ', '3112155118'),
(10, 'MILGER PAPELERIA ', 'BOGOTA ', '3163973329'),
(11, 'CENTRO ', 'TUNJA', '3112185118');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `cod_usuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anchetas`
--
ALTER TABLE `anchetas`
  ADD PRIMARY KEY (`cod_ancheta`);

--
-- Indices de la tabla `categoria_productos`
--
ALTER TABLE `categoria_productos`
  ADD PRIMARY KEY (`cod_categoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`cod_cliente`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`cod_pedido`),
  ADD KEY `FK_PEDIDO` (`cod_ancheta`),
  ADD KEY `FK_PEDIDO_CLIENTE` (`cod_cliente`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`cod_producto`),
  ADD KEY `FK_PRODUCTS` (`cod_proveedor`),
  ADD KEY `FK_PRODUCTS_CAT` (`cod_categoria`);

--
-- Indices de la tabla `productos_anchetas`
--
ALTER TABLE `productos_anchetas`
  ADD PRIMARY KEY (`cod_producto`,`cod_ancheta`),
  ADD KEY `cod_ancheta` (`cod_ancheta`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`cod_proveedor`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`cod_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria_productos`
--
ALTER TABLE `categoria_productos`
  MODIFY `cod_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `cod_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `cod_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `cod_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_PEDIDO` FOREIGN KEY (`cod_ancheta`) REFERENCES `anchetas` (`cod_ancheta`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_PEDIDO_CLIENTE` FOREIGN KEY (`cod_cliente`) REFERENCES `clientes` (`cod_cliente`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `FK_PRODUCTS` FOREIGN KEY (`cod_proveedor`) REFERENCES `proveedores` (`cod_proveedor`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_PRODUCTS_CAT` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria_productos` (`cod_categoria`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos_anchetas`
--
ALTER TABLE `productos_anchetas`
  ADD CONSTRAINT `productos_anchetas_ibfk_1` FOREIGN KEY (`cod_producto`) REFERENCES `productos` (`cod_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productos_anchetas_ibfk_2` FOREIGN KEY (`cod_ancheta`) REFERENCES `anchetas` (`cod_ancheta`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
