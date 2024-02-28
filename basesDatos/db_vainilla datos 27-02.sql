-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 28-02-2024 a las 04:09:38
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_vainilla`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anchetas`
--

DROP TABLE IF EXISTS `anchetas`;
CREATE TABLE IF NOT EXISTS `anchetas` (
  `cod_ancheta` int NOT NULL AUTO_INCREMENT,
  `nombre_ancheta` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `tipo_ancheta` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `cant_productos` int NOT NULL,
  `valor_canasta` int NOT NULL,
  `utilidad` int NOT NULL,
  `domicilio` int DEFAULT NULL,
  `subtotal` int NOT NULL,
  `otros` int DEFAULT NULL,
  `precio_final` int NOT NULL,
  `publicidad` int DEFAULT NULL,
  PRIMARY KEY (`cod_ancheta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_productos`
--

DROP TABLE IF EXISTS `categoria_productos`;
CREATE TABLE IF NOT EXISTS `categoria_productos` (
  `cod_categoria` int NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`cod_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria_productos`
--

INSERT INTO `categoria_productos` (`cod_categoria`, `nombre_categoria`) VALUES
(1, 'ESFERAS ACRILICAS '),
(2, 'PELUCHES '),
(3, 'COJIN'),
(4, 'CAJAS '),
(5, 'CHOCOLATES'),
(6, 'CERVEZAS '),
(7, 'VINOS'),
(8, 'POCILLOS '),
(9, 'GLOBOS '),
(10, 'INSUMOS'),
(11, 'DECORACION'),
(12, 'BASE ICOPOR '),
(13, 'CINTAS'),
(14, 'PIN'),
(15, 'VIDRIO'),
(16, 'MADERA'),
(17, 'TAZAS'),
(18, 'DESTAPADOR'),
(19, 'LAMPARAS'),
(20, 'RELOJ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `cod_cliente` int NOT NULL,
  `nombre_cliente` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `cod_pedido` int NOT NULL,
  `nombre_ancheta` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `cant_ancheta` int NOT NULL,
  `precio_total` int NOT NULL,
  `fecha_venta` datetime NOT NULL,
  `fecha_entrega` datetime NOT NULL,
  `nombre_destinatario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `mensaje` longtext COLLATE utf8mb4_general_ci NOT NULL,
  `medio_pago` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `direccion_entrega` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `cod_ancheta` int NOT NULL,
  `cod_cliente` int NOT NULL,
  PRIMARY KEY (`cod_pedido`),
  KEY `FK_PEDIDO` (`cod_ancheta`),
  KEY `FK_PEDIDO_CLIENTE` (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `cod_producto` int NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `num_cajas` int DEFAULT NULL,
  `num_unidad_cajas` int DEFAULT NULL,
  `precio_caja` int DEFAULT NULL,
  `precio_unidad` int NOT NULL,
  `precio_total_compra` int NOT NULL,
  `envio` int NOT NULL,
  `precio_final` int NOT NULL,
  `fecha_compra` date NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `stock` int NOT NULL,
  `tamanno` decimal(10,2) DEFAULT NULL,
  `precioMetro` int DEFAULT NULL,
  `precio_unidad_con_envio` int NOT NULL,
  `cod_proveedor` int NOT NULL,
  `cod_categoria` int NOT NULL,
  `ud_adq_envio` int NOT NULL,
  PRIMARY KEY (`cod_producto`),
  KEY `FK_PRODUCTS` (`cod_proveedor`),
  KEY `FK_PRODUCTS_CAT` (`cod_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`cod_producto`, `nombre_producto`, `num_cajas`, `num_unidad_cajas`, `precio_caja`, `precio_unidad`, `precio_total_compra`, `envio`, `precio_final`, `fecha_compra`, `fecha_vencimiento`, `stock`, `tamanno`, `precioMetro`, `precio_unidad_con_envio`, `cod_proveedor`, `cod_categoria`, `ud_adq_envio`) VALUES
(1, 'ESFERA 8\" ', 0, 0, 0, 3200, 115200, 16600, 131328, '2023-11-28', '2024-02-04', 36, 0.00, 0, 3648, 1, 1, 37),
(2, 'TOTORO', 0, 0, 0, 15500, 31000, 500, 31500, '2023-02-15', '2024-02-22', 2, 0.00, 0, 15750, 2, 2, 2),
(3, 'STICH', 0, 0, 0, 28000, 56000, 500, 56500, '2023-02-04', '2024-02-09', 2, 34.00, 823, 28250, 2, 2, 2),
(4, 'PANDA CORAZON CHALECO', 0, 0, 0, 28000, 28000, 500, 28500, '2023-02-04', '2024-02-04', 1, 59.00, 474, 28500, 2, 2, 1),
(5, 'OSO AHUACATE', 0, 0, 0, 43000, 43000, 500, 43500, '2023-02-04', '2024-02-04', 1, 44.00, 977, 43500, 2, 2, 1),
(6, 'PERRO FALDA ', 0, 0, 0, 38000, 38000, 500, 38500, '2023-02-04', '2024-02-15', 1, 50.00, 760, 38500, 2, 2, 1),
(7, 'LEON BUSO BABY', 0, 0, 0, 26000, 52000, 500, 52500, '2023-02-04', '2024-02-07', 2, 30.00, 866, 26250, 2, 2, 2),
(8, 'PERRO CORBATIN ROJO ', 0, 0, 0, 17000, 17000, 500, 17500, '2023-02-04', '2024-02-07', 1, 29.00, 586, 17500, 2, 2, 1),
(9, 'OSO GOROO RAYAS  ROSADO', 0, 0, 0, 22000, 22000, 500, 22500, '2023-02-04', '2024-02-03', 1, 30.00, 733, 22500, 2, 2, 1),
(10, 'LEONA ', 0, 0, 0, 14500, 29000, 1000, 30000, '2023-02-04', '2024-02-15', 2, 27.00, 537, 15000, 2, 2, 2),
(11, 'ELEFANTE PATAS LARGAS ', 0, 0, 0, 18000, 18000, 500, 18500, '2023-02-04', '2024-02-15', 1, 32.00, 562, 18500, 2, 2, 1),
(12, 'ERIZO', 0, 0, 0, 20000, 20000, 500, 20500, '2023-02-04', '2024-02-09', 1, 24.00, 833, 20500, 2, 2, 1),
(13, 'PANDA BUFANDA ', 0, 0, 0, 24000, 24000, 500, 24500, '2023-02-04', '2024-02-10', 1, 23.00, 1043, 24500, 2, 2, 1),
(14, 'OSO BUFANDA ', 0, 0, 0, 24000, 24000, 500, 24500, '2023-02-04', '2024-02-10', 1, 24.00, 1000, 24500, 2, 2, 1),
(15, 'OSO BUSO VINOTINTO ', 0, 0, 0, 20000, 20000, 500, 20500, '2023-02-04', '2024-02-17', 1, 24.00, 833, 20500, 2, 2, 1),
(16, 'PERRO COLLAR JASONTOY', 0, 0, 0, 15000, 30000, 1000, 31000, '2023-02-04', '2024-02-10', 2, 22.00, 681, 15500, 2, 2, 2),
(17, 'OSO CAFE CORBATIN ', 0, 0, 0, 16500, 33000, 1000, 34000, '2023-02-04', '2024-02-09', 2, 22.00, 750, 17000, 2, 2, 2),
(18, 'PANDA OVEROL ROJO', 0, 0, 0, 8000, 8000, 500, 8500, '2023-02-04', '2024-02-10', 1, 25.00, 320, 8500, 2, 2, 1),
(19, 'PERRO BLANCO CORBATIN NEGRO ', 0, 0, 0, 16500, 16500, 500, 17000, '2023-02-04', '2024-02-03', 1, 22.00, 750, 17000, 2, 2, 1),
(20, 'PERRO MOÑO CAFE SHY', 0, 0, 0, 8000, 8000, 500, 8500, '2023-02-04', '2024-02-10', 1, 20.00, 400, 8500, 2, 2, 1),
(21, 'PERRO CINTA CAFE CORAZÓN ', 0, 0, 0, 18000, 18000, 500, 18500, '2023-02-04', '2024-02-10', 1, 26.00, 692, 18500, 2, 2, 1),
(22, 'PERRO, MICO CORBATA RAYAS ', 0, 0, 0, 10000, 20000, 1000, 21000, '2023-02-04', '2024-02-10', 2, 20.00, 500, 10500, 2, 2, 2),
(23, 'CORAZÓN SONIDO AMOR, TE AMO ', 0, 0, 0, 9000, 27000, 1500, 28500, '2023-02-04', '2024-02-10', 3, 15.00, 600, 9500, 2, 3, 3),
(24, 'CORAZÓN NORMAL ROJO, ROSADO ', 0, 0, 0, 6000, 12000, 1000, 13000, '2023-02-04', '2024-02-08', 2, 15.00, 400, 6500, 2, 3, 2),
(25, 'CORAZÓN ROJOS T AMO, QUIERO', 0, 0, 0, 6500, 19500, 1500, 21000, '2023-02-04', '2023-02-04', 3, 13.00, 500, 7000, 2, 3, 3),
(26, 'CILINDRO CORBATA, CERVEZA', 0, 0, 0, 17200, 34400, 1500, 35900, '2023-02-04', '2023-02-04', 2, 38.00, 452, 17950, 2, 3, 2),
(27, 'UP', 0, 0, 0, 22000, 22000, 500, 22500, '2023-02-04', '2023-02-04', 1, 33.00, 666, 22500, 2, 3, 1),
(28, 'PRINGLES PEQUEÑA', 0, 0, 0, 6000, 6000, 0, 6000, '2024-02-06', '2024-02-06', 1, 0.00, 0, 6000, 2, 5, 1),
(29, '77', 1, 10, 10790, 1079, 10790, 1250, 12040, '2024-02-06', '2023-12-20', 10, 0.00, 0, 1204, 2, 5, 10),
(30, 'HERSHEYS ', 0, 0, 0, 3400, 30600, 1125, 31725, '2024-02-04', '2023-10-31', 9, 0.00, 0, 3525, 5, 5, 9),
(31, 'COOL STAR', 0, 0, 0, 995, 995, 125, 1120, '2024-02-05', '2023-11-22', 1, 0.00, 0, 1120, 5, 5, 1),
(32, 'DULCES ALOKADOS', 1, 100, 6800, 68, 6800, 0, 6800, '2024-02-04', '2025-06-21', 100, 0.00, 0, 68, 4, 5, 100),
(33, 'CAMISAS ', 0, 0, 0, 5070, 15210, 0, 15210, '2024-02-04', '2024-02-04', 3, 0.00, 0, 5070, 6, 5, 3),
(34, 'BIGOTES ', 0, 0, 0, 5070, 10140, 0, 10140, '2024-02-04', '2024-02-04', 2, 0.00, 0, 5070, 5, 5, 2),
(35, 'GOMITAS TROLLI', 0, 0, 0, 954, 4770, 625, 5395, '2024-02-04', '2024-07-08', 5, 0.00, 0, 1079, 2, 5, 5),
(36, 'GOMITAS TRULULU FRESITA ', 0, 0, 0, 2350, 9400, 0, 9400, '2024-02-04', '2024-05-01', 4, 0.00, 0, 2350, 5, 5, 4),
(37, 'MONT BLANC', 0, 0, 0, 6130, 6130, 0, 6130, '2024-02-04', '2024-07-07', 1, 0.00, 0, 6130, 8, 5, 1),
(38, 'GOMITAS GRISSLY', 0, 0, 0, 2200, 2200, 0, 2200, '2024-02-04', '2024-01-01', 1, 0.00, 0, 2200, 8, 5, 1),
(39, 'BIGBEN', 0, 0, 0, 123, 2091, 0, 2091, '2024-02-03', '2024-02-10', 17, 0.00, 0, 123, 2, 5, 17),
(40, 'CORAZÓN CHERIR', 0, 0, 0, 7000, 7000, 0, 7000, '2024-02-03', '2024-02-03', 1, 0.00, 0, 7000, 8, 5, 1),
(41, 'MASMELOS ', 0, 0, 0, 500, 4000, 0, 4000, '2024-02-10', '2024-02-10', 8, 0.00, 0, 500, 8, 5, 8),
(42, 'FLIPS', 0, 0, 0, 1241, 2482, 250, 2732, '2024-02-03', '2023-11-04', 2, 0.00, 0, 1366, 5, 5, 2),
(43, 'WAFER JET', 0, 0, 0, 770, 1540, 0, 1540, '2024-02-02', '2024-02-13', 2, 0.00, 0, 770, 2, 5, 2),
(44, 'GALLETAS TOSH FUSION', 0, 0, 0, 655, 1965, 375, 2340, '2024-02-03', '2023-11-03', 3, 0.00, 0, 780, 2, 5, 3),
(45, 'GALLETAS TOSH AJONJOLI', 0, 0, 0, 655, 655, 125, 780, '2024-02-10', '2023-08-30', 1, 0.00, 0, 780, 2, 5, 1),
(46, 'GALLETAS TOSH', 0, 0, 0, 655, 1965, 375, 2340, '2024-02-03', '2023-10-03', 3, 0.00, 0, 780, 2, 5, 3),
(47, 'M&M', 0, 0, 0, 3500, 21000, 750, 21750, '2024-02-03', '2023-08-01', 6, 0.00, 0, 3625, 2, 5, 6),
(48, 'RAFAELLO X3', 0, 0, 0, 3900, 11700, 375, 12075, '2024-02-04', '2023-09-02', 3, 0.00, 0, 4025, 5, 5, 3),
(49, 'ALMENDRA SOBRE', 0, 0, 0, 1091, 6546, 0, 6546, '2024-02-04', '2023-12-01', 6, 0.00, 0, 1091, 8, 5, 6),
(50, 'BARRAS GRANOLA TOSH ', 0, 0, 0, 1075, 3225, 0, 3225, '2024-02-03', '2024-02-11', 3, 0.00, 0, 1075, 2, 5, 3),
(51, 'NUCITA ', 0, 0, 0, 466, 4194, 1250, 5910, '2024-02-03', '2023-12-30', 9, 0.00, 0, 591, 2, 5, 10),
(52, 'FRITOLAY MANI ', 0, 0, 0, 2500, 10000, 0, 10000, '2024-02-03', '2024-05-07', 4, 0.00, 0, 2500, 2, 5, 4),
(53, 'CHOCOLATINA JET PEQUEÑA ', 1, 33, 15972, 484, 15972, 4125, 20097, '2024-02-10', '2024-02-01', 33, 0.00, 0, 609, 5, 5, 33),
(54, 'BURBU JET', 0, 0, 0, 2456, 17192, 1000, 18067, '2024-02-03', '2023-11-24', 7, 0.00, 0, 2581, 5, 5, 8),
(55, 'CHOCOMELOS ', 0, 0, 0, 1490, 8940, 750, 9690, '2024-02-03', '2024-01-01', 6, 0.00, 0, 1615, 2, 5, 6),
(56, 'MINI KINDER ', 0, 0, 0, 1000, 6000, 0, 6000, '2024-02-03', '2024-01-09', 6, 0.00, 0, 1000, 8, 5, 6),
(57, 'PIAZAS', 1, 18, 5688, 316, 5688, 2250, 7938, '2024-02-03', '2024-10-19', 18, 0.00, 0, 441, 2, 5, 18),
(58, 'FERRERO CORAZÓN', 0, 0, 0, 20900, 62700, 375, 63075, '2024-02-03', '2023-07-14', 3, 0.00, 0, 21025, 2, 5, 3),
(59, 'FERRERO X 4 ', 0, 0, 0, 7000, 28000, 500, 28500, '2024-02-03', '2023-09-05', 4, 0.00, 0, 7125, 4, 5, 4),
(60, 'FERRERO X 3 ', 2, 16, 73200, 4575, 146400, 4000, 150400, '2024-02-03', '2024-03-09', 32, 0.00, 0, 4700, 2, 5, 32),
(61, 'MOMENTS', 0, 0, 0, 3600, 3600, 0, 3600, '2024-02-03', '2023-10-01', 1, 0.00, 0, 3600, 2, 5, 1),
(62, 'STARS PEQUEÑA PLANA ', 0, 0, 0, 1978, 3956, 328, 4284, '2024-02-05', '2024-02-05', 2, 0.00, 0, 2142, 4, 9, 2),
(63, 'STARS PEQUEÑA VENTANA', 0, 0, 0, 2157, 4314, 328, 4642, '2024-02-05', '2024-02-05', 2, 0.00, 0, 2321, 9, 4, 2),
(64, 'STARS BASIC VENTANA', 0, 0, 0, 3209, 12836, 656, 13492, '2024-02-05', '2024-02-05', 4, 0.00, 0, 3373, 9, 4, 4),
(65, 'STARS BASIC PLANA', 0, 0, 0, 2831, 8493, 492, 8985, '2024-02-05', '2024-02-05', 3, 0.00, 0, 2995, 9, 4, 3),
(66, 'CRAFT GRUESA', 0, 0, 0, 978, 9780, 1640, 11420, '2024-02-05', '2024-02-05', 10, 0.00, 0, 1142, 9, 4, 10),
(67, 'POP - G', 0, 0, 0, 2286, 16002, 259, 16261, '2024-02-05', '2024-02-05', 7, 0.00, 0, 2323, 9, 4, 7),
(68, 'POP - P LOVE', 0, 0, 0, 1398, 46134, 1221, 47355, '2024-02-05', '2024-02-05', 33, 0.00, 0, 1435, 9, 4, 33),
(69, 'POP - M', 0, 0, 0, 1600, 1600, 37, 1637, '2024-02-05', '2024-02-05', 1, 0.00, 0, 1637, 9, 4, 1),
(70, 'CANASTA DUS', 0, 0, 0, 4220, 12660, 1680, 14340, '2024-02-05', '2024-02-05', 3, 0.00, 0, 4780, 10, 4, 3),
(71, 'CAJA CBS ', 0, 0, 0, 3999, 7998, 1120, 9118, '2024-02-05', '2024-02-05', 2, 0.00, 0, 4559, 4, 10, 2),
(72, 'BANDEJA M', 0, 0, 0, 2680, 8040, 1680, 9720, '2024-02-05', '2024-02-05', 3, 0.00, 0, 3240, 10, 4, 3),
(73, 'ANSP', 0, 0, 0, 4000, 4000, 0, 4000, '2024-02-05', '2024-02-05', 1, 0.00, 0, 4000, 10, 4, 1),
(74, 'EXH', 0, 0, 0, 3690, 11070, 1680, 12750, '2024-02-05', '2024-02-05', 3, 0.00, 0, 4250, 10, 4, 3),
(75, 'CUBO B', 0, 0, 0, 2105, 8420, 2240, 10660, '2024-02-05', '2024-02-05', 4, 0.00, 0, 2665, 10, 4, 4),
(76, 'EMPAQUES POCILLO', 0, 0, 0, 2150, 12900, 4620, 17520, '2024-02-05', '2024-02-05', 6, 0.00, 0, 2920, 6, 4, 6),
(77, 'CRISPETERA', 0, 0, 0, 500, 2000, 500, 2500, '2024-02-05', '2024-02-05', 4, 0.00, 0, 625, 2, 4, 4),
(78, 'CC CUBO', 0, 0, 0, 2000, 16000, 1696, 17696, '2024-02-05', '2024-02-05', 8, 0.00, 0, 2212, 11, 4, 8),
(79, 'HEXAGONAL ROSADA', 0, 0, 0, 4900, 14700, 636, 15336, '2024-02-05', '2024-02-05', 3, 0.00, 0, 5112, 11, 4, 3),
(80, 'MADERA CERVEZA', 0, 0, 0, 3500, 17500, 1060, 18560, '2024-02-05', '2024-02-05', 5, 0.00, 0, 3712, 11, 4, 5),
(81, 'CAJA ACETATO', 0, 0, 0, 3300, 13200, 2032, 15232, '2024-02-05', '2024-02-05', 4, 0.00, 0, 3808, 11, 4, 4),
(82, 'CAJA CRAFT ANCHETA', 0, 0, 0, 2500, 12500, 2540, 15040, '2024-02-05', '2024-02-05', 5, 0.00, 0, 3008, 11, 4, 5),
(83, 'CAJA CILINDRO ESTAMPADA ROSA ROJA', 0, 0, 0, 11900, 35700, 1524, 37224, '2024-02-05', '2024-02-05', 3, 0.00, 0, 12408, 11, 4, 3),
(84, 'LONCHERA ACETATO', 0, 0, 0, 3000, 36000, 6096, 42096, '2024-02-05', '2024-02-05', 12, 0.00, 0, 3508, 11, 4, 12),
(85, 'CAJA DURALONCHERA ROSA NEGRA', 0, 0, 0, 17000, 34000, 1016, 35016, '2024-02-05', '2024-02-05', 2, 0.00, 0, 17508, 11, 4, 2),
(86, 'ROSETONES ROSADOS', 0, 0, 0, 1700, 17000, 2120, 19120, '2024-02-05', '2024-02-05', 10, 0.00, 0, 1912, 11, 11, 10),
(87, 'ROSA CARULINA ROSADA', 2, 11, 10900, 990, 21800, 5088, 26444, '2024-02-05', '2024-02-05', 22, 0.00, 0, 1202, 2, 11, 24),
(88, 'ROSA CARTULINA LILA', 2, 12, 10900, 908, 10900, 5088, 26880, '2024-02-05', '2024-02-05', 24, 0.00, 0, 1120, 11, 11, 24),
(89, 'FLOR CARTULINA', 5, 3, 5600, 1866, 28000, 3180, 31170, '2024-02-05', '2024-02-05', 15, 0.00, 0, 2078, 11, 11, 15),
(90, 'FERRERO SUELTO', 0, 0, 0, 1566, 6266, 0, 6264, '2024-02-13', '2024-02-13', 4, 1.00, 1566, 1566, 2, 5, 4),
(91, 'PONQUE PERSONAL ', 2, 12, 2000, 166, 4000, 0, 3984, '2024-02-03', '2024-02-03', 24, 0.00, 0, 166, 12, 12, 24),
(92, 'EJEM2', 2, 21, 550, 26, 11000, 12000, 2268, '2024-02-15', '2024-02-16', 42, 0.00, 0, 54, 10, 4, 42),
(93, 'EJEM3', 0, 0, 0, 12000, 12000, 2000, 14000, '2024-02-16', '2024-02-16', 1, 0.00, 0, 14000, 10, 4, 1),
(94, 'JUMBO MINI BROWNIE', 1, 7, 8000, 1142, 8000, 0, 7994, '2024-02-15', '2024-09-18', 7, 0.00, 0, 1142, 12, 5, 7),
(95, 'CARRO LONDRES', 0, 0, 0, 5200, 5200, 770, 5970, '2024-02-27', '2024-02-27', 1, 0.00, 0, 5970, 6, 8, 1),
(96, 'BICICLETA', 0, 0, 0, 5200, 5200, 770, 5970, '2024-02-27', '2024-02-27', 1, 0.00, 0, 5970, 6, 8, 1),
(97, 'CLASICO', 0, 0, 0, 5200, 5200, 770, 5970, '2024-02-27', '2024-02-27', 1, 0.00, 0, 5970, 6, 8, 1),
(98, 'OSITO', 0, 0, 0, 5200, 5200, 770, 5970, '2024-02-27', '2024-02-27', 1, 0.00, 0, 5970, 6, 8, 1),
(99, 'VACA', 0, 0, 0, 20000, 20000, 0, 20000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 20000, 2, 8, 1),
(100, 'GATO TAPA OREJA DORADA', 0, 0, 0, 25000, 25000, 0, 25000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 25000, 2, 8, 1),
(101, 'PANDA CORBATIN AZUL', 0, 0, 0, 18000, 18000, 0, 18000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 18000, 2, 8, 1),
(102, 'TIGRE', 0, 0, 0, 17000, 17000, 0, 17000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 17000, 2, 8, 1),
(103, 'PANDA BAMBOO', 0, 0, 0, 18000, 18000, 0, 18000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 18000, 2, 8, 1),
(104, 'PANDA GAFAS ROSADAS', 0, 0, 0, 18000, 18000, 0, 18000, '2024-02-27', '2024-02-26', 1, 0.00, 0, 18000, 2, 8, 1),
(105, 'RANA', 0, 0, 0, 22000, 22000, 0, 22000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 22000, 2, 8, 1),
(106, 'ESPEJO CORAZON CAFE', 0, 0, 0, 11400, 22800, 0, 22800, '2024-02-27', '2024-02-27', 2, 0.00, 0, 11400, 2, 8, 2),
(107, 'HELLO KITTY BOLAS', 0, 0, 0, 22800, 22800, 0, 22800, '2024-02-27', '2024-02-27', 1, 0.00, 0, 22800, 2, 8, 1),
(108, 'PAREJA LOVE', 0, 0, 0, 38200, 38200, 0, 38200, '2024-02-27', '2024-02-27', 1, 0.00, 0, 38200, 2, 8, 1),
(109, 'PAREJA REY', 0, 0, 0, 38200, 38200, 0, 38200, '2024-02-27', '2024-02-27', 1, 0.00, 0, 38200, 2, 8, 1),
(110, 'COPAS SURTIDA', 0, 0, 0, 5000, 30000, 750, 30750, '2024-02-27', '2024-02-27', 6, 0.00, 0, 5125, 2, 8, 6),
(111, 'MUG SURTIDO', 0, 0, 0, 4400, 30800, 875, 31675, '2024-02-27', '2024-02-27', 7, 0.00, 0, 4525, 2, 8, 7),
(112, 'TERMO HELLO KITTY', 0, 0, 0, 13000, 13000, 0, 13000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 13000, 2, 8, 1),
(113, 'TERMO DIGITAL', 0, 0, 0, 25000, 25000, 0, 25000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 25000, 2, 8, 1),
(114, 'MUG HELLO KITTY', 0, 0, 0, 6000, 12000, 0, 12000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 6000, 2, 8, 2),
(115, 'MUG TRANSPARENTE', 0, 0, 0, 5000, 15000, 0, 15000, '2024-02-27', '2024-02-27', 3, 0.00, 0, 5000, 2, 8, 3),
(116, 'CAJA CORAZON PEQUEÑA DURA', 0, 0, 0, 12000, 12000, 0, 12000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 12000, 12, 4, 1),
(117, 'CAJA CORAZON GRANDE', 0, 0, 0, 14000, 14000, 0, 14000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 14000, 12, 4, 1),
(118, 'TACON CERVEZA', 0, 0, 0, 500, 4500, 1125, 5625, '2024-02-27', '2024-02-27', 9, 0.00, 0, 625, 2, 14, 9),
(119, 'PADRE', 0, 0, 0, 350, 4900, 1750, 6650, '2024-02-27', '2024-02-27', 14, 0.00, 0, 475, 2, 14, 14),
(120, 'CANELO', 0, 0, 0, 700, 7700, 1375, 9075, '2024-02-27', '2024-02-27', 11, 0.00, 0, 825, 2, 14, 11),
(121, 'SANDRA', 0, 0, 0, 583, 20405, 4375, 24780, '2024-02-27', '2024-02-27', 35, 0.00, 0, 708, 2, 14, 35),
(122, 'CORAZONES DECORATIVOS', 1, 70, 16000, 228, 16000, 0, 15960, '2024-02-27', '2024-02-27', 70, 0.00, 0, 228, 12, 14, 70),
(123, 'BOMBILLO MEDIANO', 0, 0, 0, 2500, 30000, 0, 30000, '2024-02-27', '2024-02-27', 12, 0.00, 0, 2500, 2, 15, 12),
(124, 'COMPOTA', 0, 0, 0, 1800, 36000, 2500, 38500, '2024-02-27', '2024-02-27', 20, 0.00, 0, 1925, 2, 15, 20),
(125, 'JUGO', 0, 0, 0, 1700, 17000, 1250, 18250, '2024-02-27', '2024-02-27', 10, 0.00, 0, 1825, 2, 15, 10),
(126, 'LAMINA FELIZ DIA', 0, 0, 0, 1700, 6800, 848, 7648, '2024-02-27', '2024-02-27', 4, 0.00, 0, 1912, 11, 11, 4),
(127, 'MENSAJE TE AMO-LOVE', 0, 0, 0, 751, 18024, 2016, 20040, '2024-02-27', '2024-02-27', 24, 0.00, 0, 835, 11, 11, 24),
(128, 'LAMINA DORADA', 0, 0, 0, 948, 23700, 500, 24200, '2024-02-27', '2024-02-27', 25, 0.00, 0, 968, 11, 11, 25),
(129, 'CINTA PUNTOS', 0, 0, 0, 1900, 5700, 1524, 7224, '2024-02-27', '2024-02-27', 3, 0.00, 0, 2408, 11, 10, 3),
(130, 'DOBLE', 0, 0, 0, 12000, 24000, 0, 24000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 12000, 15, 16, 2),
(131, 'DESAYUNO GRANDE', 0, 0, 0, 10000, 20000, 0, 20000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 10000, 15, 16, 2),
(132, 'BALDES MEDIANO', 0, 0, 0, 9000, 18000, 0, 18000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 9000, 15, 16, 2),
(133, 'BALDE PEQUEÑO U', 0, 0, 0, 6300, 6300, 2200, 8500, '2024-02-27', '2024-02-27', 1, 0.00, 0, 8500, 16, 16, 1),
(134, 'HEXAGONAL', 0, 0, 0, 8400, 16800, 2200, 19000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 9500, 16, 16, 2),
(136, 'CANASTA W', 0, 0, 0, 7900, 15800, 2200, 18000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 9000, 16, 16, 2),
(137, 'DESAYUNO PATAS L', 0, 0, 0, 8800, 8800, 2200, 11000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 11000, 16, 16, 1),
(138, 'DESAYUNO D', 0, 0, 0, 6800, 6800, 2200, 9000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 9000, 16, 16, 1),
(139, 'DESAYUNO C', 0, 0, 0, 5800, 5800, 2200, 8000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 8000, 16, 16, 1),
(140, 'DESAYUNO I', 0, 0, 0, 6800, 6800, 2200, 9000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 9000, 16, 16, 1),
(141, 'DESAYUNO B', 0, 0, 0, 5800, 5800, 2200, 8000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 8000, 16, 16, 1),
(142, 'DESAYUNO LABRADA', 0, 0, 0, 5800, 5800, 2200, 8000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 8000, 16, 16, 1),
(143, 'DESAYUNO GRANDE PATAS', 0, 0, 0, 7800, 7800, 2200, 10000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 10000, 16, 16, 1),
(144, 'FRUTA C 8 ONZAS', 0, 0, 0, 750, 750, 0, 750, '2024-02-27', '2024-02-27', 1, 0.00, 0, 750, 8, 17, 1),
(145, 'FRUTA C 16 ONZAS', 0, 0, 0, 1050, 4200, 0, 4200, '2024-02-27', '2024-02-27', 4, 0.00, 0, 1050, 8, 17, 4),
(146, 'REDONDA S 8 ONZAS', 0, 0, 0, 733, 3665, 0, 3665, '2024-02-27', '2024-02-27', 5, 0.00, 0, 733, 8, 17, 5),
(147, 'REDONDA M 11 ONZAS', 0, 0, 0, 866, 5196, 0, 5196, '2024-02-27', '2024-02-27', 6, 0.00, 0, 866, 8, 17, 6),
(148, 'DULCERA GRANDE', 0, 0, 0, 3500, 3500, 0, 3500, '2024-02-27', '2024-02-27', 1, 0.00, 0, 3500, 8, 17, 1),
(149, 'DOMO MEDIA LIBRA', 0, 0, 0, 400, 1200, 0, 1200, '2024-02-27', '2024-02-27', 3, 0.00, 0, 400, 8, 17, 3),
(150, 'DOMO 1 LIBRA', 0, 0, 0, 575, 6900, 0, 6900, '2024-02-27', '2024-02-27', 12, 0.00, 0, 575, 8, 17, 123),
(151, 'VASO JUGO DOMO', 0, 0, 0, 1000, 2000, 0, 2000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 1000, 8, 17, 2),
(152, 'VASO JUGO 12 ONZAS', 0, 0, 0, 900, 1800, 0, 1800, '2024-02-27', '2024-02-27', 2, 0.00, 0, 900, 8, 17, 2),
(153, 'TRIANGULO', 0, 0, 0, 1000, 1000, 0, 1000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 1000, 8, 17, 1),
(154, 'CORONA', 0, 0, 0, 4100, 4100, 0, 4100, '2024-02-27', '2024-02-27', 1, 0.00, 0, 4100, 4, 6, 1),
(155, 'CORONA PEQUEÑA', 0, 0, 0, 2714, 5428, 0, 5428, '2024-02-27', '2024-02-27', 2, 0.00, 0, 2714, 4, 6, 2),
(156, 'GATO NEGRO 175', 0, 0, 0, 9800, 49000, 0, 49000, '2024-02-27', '2024-02-27', 5, 0.00, 0, 9800, 2, 6, 5),
(157, 'HEINEKEN LATA', 0, 0, 0, 3000, 6000, 0, 6000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 3000, 5, 6, 2),
(158, 'HEINEKEN PEQUEÑA', 0, 0, 0, 2128, 6384, 0, 6384, '2024-02-27', '2024-02-27', 3, 0.00, 0, 2128, 4, 6, 3),
(159, 'LATA CORONA LIMON', 0, 0, 0, 6900, 6900, 0, 6900, '2024-02-27', '2024-02-27', 1, 0.00, 0, 6900, 4, 6, 1),
(160, 'COCTEL JP LATA', 0, 0, 0, 10417, 31251, 0, 31251, '2024-02-27', '2024-02-27', 3, 0.00, 0, 10417, 4, 6, 3),
(161, 'HATSU BOTELLA 400', 0, 0, 0, 4200, 4200, 0, 4200, '2024-02-27', '2024-02-27', 1, 0.00, 0, 4200, 7, 6, 1),
(162, 'VODKA MINI', 0, 0, 0, 10000, 10000, 0, 10000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 10000, 3, 6, 1),
(163, 'HATSU LATA', 0, 0, 0, 2400, 2400, 0, 2400, '2024-02-27', '2024-02-27', 1, 0.00, 0, 2400, 3, 6, 1),
(164, 'HATSU TAPA 300', 0, 0, 0, 3000, 6000, 0, 6000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 3000, 3, 6, 2),
(165, 'CORONA PEQ', 0, 0, 0, 2749, 10996, 0, 10996, '2024-02-27', '2024-02-27', 4, 0.00, 0, 2749, 17, 6, 4),
(166, 'CORONA GRAN', 0, 0, 0, 3499, 31491, 0, 31491, '2024-02-27', '2024-02-27', 9, 0.00, 0, 3499, 17, 6, 9),
(167, 'GATO NEGRO 375', 0, 0, 0, 17000, 34000, 0, 34000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 17000, 2, 6, 2),
(168, 'JP ROJO ROSADO 750', 0, 0, 0, 50000, 100000, 0, 100000, '2024-02-27', '2024-02-27', 2, 0.00, 0, 50000, 2, 6, 2),
(170, 'JP ROJO ROSADO 200', 0, 0, 0, 22900, 114500, 0, 114500, '2024-02-27', '2024-02-27', 5, 0.00, 0, 22900, 18, 6, 5),
(171, 'BAILYS 375', 0, 0, 0, 40000, 40000, 0, 40000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 40000, 18, 6, 1),
(172, 'BOMBAS LATEX', 0, 0, 0, 500, 9500, 0, 9500, '2024-02-27', '2024-02-27', 19, 0.00, 0, 500, 8, 9, 19),
(173, 'BURBUJA 18\"', 0, 0, 0, 700, 23100, 4125, 27225, '2024-02-27', '2024-02-27', 33, 0.00, 0, 825, 19, 9, 33),
(174, 'BURBUJA 20\"', 0, 0, 0, 700, 33600, 6000, 39600, '2024-02-27', '2024-02-27', 48, 0.00, 0, 825, 19, 9, 48),
(175, 'BURBUJA 10\"', 0, 0, 0, 400, 10800, 3375, 14175, '2024-02-27', '2024-02-27', 27, 0.00, 0, 525, 19, 9, 27),
(176, 'CROMADO R6', 0, 0, 0, 130, 13780, 13250, 27030, '2024-02-27', '2024-02-27', 106, 0.00, 0, 255, 19, 9, 106),
(177, 'CROMADO FELIZ DIA', 0, 0, 0, 400, 15200, 4750, 19950, '2024-02-27', '2024-02-27', 38, 0.00, 0, 525, 19, 9, 38),
(178, 'CROMADO R12', 0, 0, 0, 325, 22100, 6800, 28900, '2024-02-27', '2024-02-27', 68, 0.00, 0, 425, 19, 9, 68),
(179, 'CROMADO SATIN RFUCCIA', 0, 0, 0, 300, 15000, 0, 15000, '2024-02-27', '2024-02-27', 50, 0.00, 0, 300, 21, 9, 50),
(180, 'CROMADO R5', 0, 0, 0, 150, 22500, 0, 22500, '2024-02-27', '2024-02-27', 150, 0.00, 0, 150, 21, 9, 150),
(181, 'METALIZADO 18\"', 0, 0, 0, 800, 39200, 6125, 45325, '2024-02-27', '2024-02-27', 49, 0.00, 0, 925, 20, 9, 49),
(182, 'METALIZADO  18\"', 0, 0, 0, 800, 20000, 0, 20000, '2024-02-27', '2024-02-27', 25, 0.00, 0, 800, 21, 9, 49),
(183, 'METALIZADO RAYAS 18\"', 0, 0, 0, 1000, 3000, 0, 3000, '2024-02-27', '2024-02-27', 3, 0.00, 0, 1000, 21, 9, 3),
(184, 'METALIZADO 9\"', 0, 0, 0, 600, 18000, 3750, 21750, '2024-02-27', '2024-02-27', 30, 0.00, 0, 725, 20, 9, 30),
(185, 'METALIZADO  9\"', 0, 0, 0, 500, 35000, 0, 35000, '2024-02-27', '2024-02-27', 70, 0.00, 0, 500, 21, 9, 70),
(186, 'METALIZADO ESTAMPADO 9\"', 0, 0, 0, 700, 7700, 0, 7700, '2024-02-27', '2024-02-27', 11, 0.00, 0, 700, 21, 9, 111),
(187, 'MILFIGURAS', 0, 0, 0, 130, 10400, 10000, 20400, '2024-02-27', '2024-02-27', 80, 0.00, 0, 255, 20, 9, 80),
(188, 'PALO BOMBA', 0, 0, 0, 80, 13040, 20375, 33415, '2024-02-27', '2024-02-27', 163, 0.00, 0, 205, 20, 9, 163),
(189, 'PALO BURBUJA GR', 0, 0, 0, 400, 17600, 5500, 23100, '2024-02-27', '2024-02-27', 44, 0.00, 0, 525, 20, 9, 44),
(190, 'PALO BURBUJA PEQ', 0, 0, 0, 150, 14850, 12375, 27225, '2024-02-27', '2024-02-27', 99, 0.00, 0, 275, 20, 9, 99),
(191, 'GLOBO BLANCO R12', 0, 0, 0, 142, 2130, 1875, 4005, '2024-02-27', '2024-02-27', 15, 0.00, 0, 267, 20, 9, 15),
(192, 'GLOBO NEGRO R12', 0, 0, 0, 130, 13000, 12500, 25500, '2024-02-27', '2024-02-27', 100, 0.00, 0, 255, 20, 9, 100),
(193, 'CONFETI GLOBO', 0, 0, 0, 1662, 19944, 1500, 21444, '2024-02-27', '2024-02-27', 12, 0.00, 0, 1787, 20, 9, 12),
(194, 'CORAZON METALIZADO', 0, 0, 0, 1400, 7000, 2540, 9540, '2024-02-27', '2024-02-27', 5, 0.00, 0, 1908, 11, 9, 5),
(195, 'CORAZON METALIZADO 10\"', 0, 0, 0, 1000, 10000, 5080, 15080, '2024-02-27', '2024-02-27', 10, 0.00, 0, 1508, 11, 9, 10),
(196, 'JUMBO MINI', 0, 0, 0, 1875, 1875, 0, 1875, '2024-02-27', '2024-02-27', 1, 0.00, 0, 1875, 12, 5, 1),
(197, 'DESTAPADOR CERVEZAS', 0, 0, 0, 2900, 26100, 1125, 27225, '2024-02-27', '2024-02-27', 9, 0.00, 0, 3025, 22, 18, 9),
(198, 'DESTAPADOR CAJA', 0, 0, 0, 6500, 6500, 770, 7270, '2024-02-27', '2024-02-27', 1, 0.00, 0, 7270, 6, 18, 1),
(199, 'KITTY', 0, 0, 0, 40000, 40000, 0, 40000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 40000, 2, 19, 1),
(200, 'CONEJO', 0, 0, 0, 40000, 40000, 0, 40000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 40000, 2, 19, 1),
(201, 'OSO', 0, 0, 0, 40000, 40000, 0, 40000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 40000, 2, 19, 1),
(202, 'I8', 0, 0, 0, 50000, 50000, 0, 50000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 50000, 2, 20, 1),
(203, 'L18', 0, 0, 0, 95000, 95000, 0, 95000, '2024-02-27', '2024-02-27', 1, 0.00, 0, 95000, 2, 20, 1),
(204, 'BOTILITO ELEFANTE', 0, 0, 0, 15600, 15600, 0, 15600, '2024-02-27', '2024-02-27', 1, 0.00, 0, 15600, 2, 8, 1),
(205, 'PAPEL 4X50', 0, 0, 0, 2400, 19200, 1000, 19216, '2024-02-27', '2024-02-27', 8, 45.00, 53, 2402, 2, 13, 360),
(206, 'PAPEL 9X100', 0, 0, 0, 5500, 44000, 1000, 44008, '2024-02-27', '2024-02-27', 8, 91.00, 60, 5501, 2, 13, 728),
(207, 'TELA PEQ 50', 0, 0, 0, 12000, 84000, 875, 84014, '2024-02-27', '2024-02-27', 7, 50.00, 240, 12002, 2, 13, 350),
(208, 'TELA PEQ BLANCA', 0, 0, 0, 9000, 9000, 125, 9002, '2024-02-27', '2024-02-27', 1, 50.00, 180, 9002, 2, 13, 50),
(209, 'TELA GRANDE', 0, 0, 0, 18250, 91250, 625, 91260, '2024-02-27', '2024-02-27', 5, 50.00, 365, 18252, 2, 13, 250),
(210, 'PAPEL VERDE ANCHO', 0, 0, 0, 5000, 5000, 0, 5000, '2024-02-27', '2024-02-27', 1, 50.00, 100, 5000, 19, 13, 50),
(211, 'PAPEL BLANCO ANCHO', 0, 0, 0, 5000, 5000, 0, 5000, '2024-02-27', '2024-02-27', 1, 50.00, 100, 5000, 19, 13, 50),
(212, 'PAPEL DELGADO FUCCIA', 0, 0, 0, 4000, 4000, 0, 4000, '2024-02-27', '2024-02-27', 1, 50.00, 80, 4000, 2, 13, 50),
(213, 'PAPEL DELGADO ROJO', 0, 0, 0, 4000, 4000, 0, 4000, '2024-02-27', '2024-02-27', 1, 50.00, 80, 4000, 2, 13, 50),
(214, 'PAPEL AZUL ', 0, 0, 0, 6500, 6500, 0, 6500, '2024-02-27', '2024-02-27', 1, 50.00, 130, 6500, 2, 13, 50),
(215, 'PAPEL PUNTOS ROSADA ', 0, 0, 0, 186, 4100, 0, 4092, '2024-02-27', '2024-02-27', 22, 0.00, 0, 186, 2, 13, 22),
(216, 'PAPEL PUNTOS VERDE', 0, 0, 0, 186, 4100, 0, 4092, '2024-02-27', '2024-02-27', 22, 0.00, 0, 186, 2, 13, 22),
(217, 'PAPEL PUNTOS AZUL', 0, 0, 0, 154, 3400, 0, 3388, '2024-02-27', '2024-02-27', 22, 0.00, 0, 154, 2, 13, 22),
(218, 'PAPEL PUNTOS MORADO', 0, 0, 0, 154, 3400, 0, 3388, '2024-02-27', '2024-02-27', 22, 0.00, 0, 154, 2, 13, 22),
(219, 'PINCHOS', 1, 96, 1824, 19, 1824, 0, 1824, '2024-02-27', '2024-02-27', 96, 0.00, 0, 19, 2, 10, 96),
(220, 'OPALINA', 1, 20, 8000, 400, 8000, 0, 8000, '2024-02-27', '2024-02-27', 20, 0.00, 0, 400, 2, 10, 96),
(221, 'SILICONA', 1, 36, 18720, 520, 18720, 0, 18720, '2024-02-27', '2024-02-27', 36, 0.00, 0, 520, 2, 10, 96),
(222, 'TUL', 0, 0, 0, 180, 9000, 0, 9000, '2024-02-27', '2024-02-27', 50, 0.00, 0, 180, 2, 10, 50),
(223, 'FLORES ARTIFICIALES', 0, 0, 0, 1000, 15000, 0, 15000, '2024-02-27', '2024-02-27', 15, 0.00, 0, 1000, 2, 10, 50),
(224, 'OASIS', 0, 0, 0, 1400, 46200, 0, 46200, '2024-02-27', '2024-02-27', 33, 0.00, 0, 1400, 2, 10, 33),
(225, 'PINTURA GLOBOS', 0, 0, 0, 55, 23100, 0, 23100, '2024-02-27', '2024-02-27', 420, 0.00, 0, 55, 2, 10, 420),
(226, 'YUTE DELGADO', 0, 0, 0, 461, 6000, 0, 5993, '2024-02-27', '2024-02-27', 13, 0.00, 0, 461, 2, 10, 13),
(227, 'YUTE GRUESO', 0, 0, 0, 100, 300, 0, 300, '2024-02-27', '2024-02-27', 3, 0.00, 0, 100, 2, 10, 3),
(228, 'STICKER', 0, 0, 0, 81, 46332, 0, 46332, '2024-02-27', '2024-02-27', 572, 0.00, 0, 81, 2, 10, 572),
(229, 'CEDA', 0, 0, 0, 150, 78750, 0, 78750, '2024-02-27', '2024-02-27', 525, 0.00, 0, 150, 2, 10, 525),
(230, 'PAPEL ADHESIVO FOTOGRAFICO TRANSPARENTE', 0, 0, 0, 1525, 28975, 0, 28975, '2024-02-27', '2024-02-27', 19, 0.00, 0, 1525, 2, 10, 19),
(231, 'PAPEL ADHESIVO FOTOGRAFICO', 0, 0, 0, 675, 13500, 0, 13500, '2024-02-27', '2024-02-27', 20, 0.00, 0, 675, 2, 10, 20),
(232, 'CARTULINA ESPEJO', 0, 0, 0, 2000, 8000, 0, 8000, '2024-02-27', '2024-02-27', 4, 0.00, 0, 2000, 2, 10, 4),
(233, 'TRUFAS', 0, 0, 0, 1000, 9000, 0, 9000, '2024-02-27', '2024-02-27', 9, 0.00, 0, 1000, 12, 5, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_anchetas`
--

DROP TABLE IF EXISTS `productos_anchetas`;
CREATE TABLE IF NOT EXISTS `productos_anchetas` (
  `cod_producto` int NOT NULL,
  `cod_ancheta` int NOT NULL,
  `cantidad_productos` int NOT NULL,
  `precio_total_producto` int NOT NULL,
  PRIMARY KEY (`cod_producto`,`cod_ancheta`),
  KEY `cod_ancheta` (`cod_ancheta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
CREATE TABLE IF NOT EXISTS `proveedores` (
  `cod_proveedor` int NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `ciudad` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`cod_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`cod_proveedor`, `nombre_proveedor`, `ciudad`, `telefono`) VALUES
(1, 'MILGER PAPELERIA', 'BOGOTA', '3163973329'),
(2, 'BOGOTA ', 'BOGOTA ', '0000000000'),
(3, 'MUCHACHO CENTRO', 'TUNJA ', '1010101010'),
(4, 'CHISPAZO', 'TUNJA ', '1010101010'),
(5, 'EXITO ', 'TUNJA ', '1010101010'),
(6, 'FUTURO ', 'BOGOTÁ', '1010101010'),
(7, 'VECINO ', 'TUNJA', '1010101010'),
(8, 'TUNJA ', 'TUNJA ', '1010101010'),
(9, 'SORCKERITOS', 'BOGOTA', '3143692801'),
(10, 'AMORE', 'BOGOTA', '3005799389'),
(11, 'DECORARTE', 'CALI', '0000000000'),
(12, 'DOLLARCITY', 'TUNJA ', '1010101010'),
(13, 'LA 11', 'TUNJA ', '1010101010'),
(15, 'BOGOTA CALLE', 'BOGOTA', '0123456789'),
(16, 'BOGOTA PEDIDO', 'BOGOTA', '0123456789'),
(17, 'YOPAL', 'YOPAL', '0123456789'),
(18, 'JUMBO', 'TUNJA', '0123456789'),
(19, 'GLOBOS', 'BOGOTA', '0123456789'),
(20, 'PIÑATERIA', 'BOGOTA', '0123456789'),
(21, 'DEISY', 'BOGOTA', '0123456789'),
(22, 'RAPELUCHES', 'TUNJA', '0123456789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `cod_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
