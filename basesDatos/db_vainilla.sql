-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2024 a las 03:17:07
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
-- Base de datos: `db_vainilla`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anchetas`
--

CREATE TABLE `anchetas` (
  `cod_ancheta` int(11) NOT NULL,
  `nombre_ancheta` varchar(100) NOT NULL,
  `tipo_ancheta` varchar(10) NOT NULL,
  `cant_productos` int(11) NOT NULL,
  `precio_parcial` int(11) NOT NULL,
  `utilidad` int(11) NOT NULL,
  `precio_domicilio` int(11) DEFAULT NULL,
  `valor_adicional` int(11) DEFAULT NULL,
  `precio_final` int(11) NOT NULL,
  `publicidad` int(11) DEFAULT NULL
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
(11, 'DECORACION');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cod_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(100) DEFAULT NULL,
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
  `nombre_producto` varchar(100) NOT NULL,
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
  `cod_categoria` int(11) NOT NULL,
  `ud_adq_envio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(29, '77 ', 1, 13, 14027, 1079, 14027, 1625, 15652, '2024-02-06', '2023-12-20', 13, 0.00, 0, 1204, 5, 2, 13),
(30, 'HERSHEYS', 0, 0, 0, 3600, 28800, 1000, 29112, '2024-02-04', '2023-10-31', 8, 0.00, 0, 3639, 2, 5, 8),
(31, 'COOL STAR ', 0, 0, 0, 995, 3980, 250, 4228, '2024-02-05', '2023-11-22', 4, 0.00, 0, 1057, 5, 2, 4),
(32, 'DULCES ALOKADOS', 1, 100, 6800, 68, 6800, 0, 6800, '2024-02-04', '2025-06-21', 100, 0.00, 0, 68, 4, 5, 100),
(33, 'CAMISAS ', 0, 0, 0, 5070, 15210, 0, 15210, '2024-02-04', '2024-02-04', 3, 0.00, 0, 5070, 6, 5, 3),
(34, 'BIGOTES ', 0, 0, 0, 5070, 5070, 0, 5070, '2024-02-04', '2024-02-04', 1, 0.00, 0, 5070, 6, 5, 1),
(35, 'GOMITAS TROLLI', 0, 0, 0, 954, 4770, 625, 5395, '2024-02-04', '2024-07-08', 5, 0.00, 0, 1079, 2, 5, 5),
(36, ' GOMITAS TRULULU FRESITA', 0, 0, 0, 2350, 9400, 0, 9400, '2024-02-04', '2024-05-01', 4, 0.00, 0, 2350, 5, 8, 4),
(37, 'MONT BLANC', 0, 0, 0, 6130, 6130, 0, 6130, '2024-02-04', '2024-07-07', 1, 0.00, 0, 6130, 8, 5, 1),
(38, 'GOMITAS GRISSLY', 0, 0, 0, 2200, 2200, 0, 2200, '2024-02-04', '2024-01-01', 1, 0.00, 0, 2200, 8, 5, 1),
(39, 'BIGBEN', 0, 0, 0, 123, 2091, 0, 2091, '2024-02-03', '2024-02-10', 17, 0.00, 0, 123, 2, 5, 17),
(40, 'CORAZÓN CHERIR', 0, 0, 0, 7000, 7000, 0, 7000, '2024-02-03', '2024-02-03', 1, 0.00, 0, 7000, 8, 5, 1),
(41, 'MASMELOS ', 0, 0, 0, 500, 4000, 0, 4000, '2024-02-10', '2024-02-10', 8, 0.00, 0, 500, 8, 5, 8),
(42, 'FLIPS ', 0, 0, 0, 1241, 2482, 125, 2606, '2024-02-03', '2023-11-04', 2, 0.00, 0, 1303, 5, 2, 2),
(43, 'WAFER JET', 0, 0, 0, 770, 1540, 0, 1540, '2024-02-02', '2024-02-13', 2, 0.00, 0, 770, 2, 5, 2),
(44, 'GALLETAS TOSH FUSION', 0, 0, 0, 655, 1965, 375, 2340, '2024-02-03', '2023-11-03', 3, 0.00, 0, 780, 2, 5, 3),
(45, 'GALLETAS TOSH AJONJOLI', 0, 0, 0, 655, 655, 125, 780, '2024-02-10', '2023-08-30', 1, 0.00, 0, 780, 2, 5, 1),
(46, 'GALLETAS TOSH', 0, 0, 0, 655, 1965, 375, 2340, '2024-02-03', '2023-10-03', 3, 0.00, 0, 780, 2, 5, 3),
(47, 'M&M', 0, 0, 0, 3500, 21000, 750, 21750, '2024-02-03', '2023-08-01', 6, 0.00, 0, 3625, 2, 5, 6),
(48, 'RAFAELLO X3 ', 0, 0, 0, 3900, 11700, 375, 12075, '2024-02-04', '2023-09-02', 3, 0.00, 0, 4025, 5, 2, 3),
(49, 'ALMENDRA SOBRE', 0, 0, 0, 1091, 6546, 750, 7296, '2024-02-04', '2023-12-01', 6, 0.00, 0, 1216, 8, 5, 6),
(50, 'BARRAS GRANOLA TOSH ', 0, 0, 0, 1075, 3225, 0, 3225, '2024-02-03', '2024-02-11', 3, 0.00, 0, 1075, 2, 5, 3),
(51, 'NUCITA', 0, 0, 0, 466, 4194, 1250, 5910, '2024-02-03', '2023-12-30', 9, 0.00, 0, 591, 5, 2, 10),
(52, 'FRITOLAY MANI ', 0, 0, 0, 2000, 8000, 0, 8000, '2024-02-03', '2024-05-07', 4, 0.00, 0, 2000, 2, 5, 4),
(53, 'CHOCOLATINA JET PEQUEÑA ', 1, 50, 24200, 484, 24200, 6250, 30450, '2024-02-10', '2024-02-01', 50, 0.00, 0, 609, 2, 5, 50),
(54, 'BURBU JET ', 0, 0, 0, 2456, 19654, 1000, 20648, '2024-02-03', '2023-11-24', 8, 0.00, 0, 2581, 2, 5, 8),
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
(77, 'CRISPETERA ', 0, 0, 0, 500, 2000, 500, 2500, '2024-02-05', '2024-02-05', 4, 0.00, 0, 625, 4, 2, 4),
(78, 'CC CUBO', 0, 0, 0, 2000, 16000, 1696, 17696, '2024-02-05', '2024-02-05', 8, 0.00, 0, 2212, 11, 4, 8),
(79, 'HEXAGONAL ROSADA', 0, 0, 0, 4900, 14700, 636, 15336, '2024-02-05', '2024-02-05', 3, 0.00, 0, 5112, 11, 4, 3),
(80, 'MADERA CERVEZA', 0, 0, 0, 3500, 17500, 1060, 18560, '2024-02-05', '2024-02-05', 5, 0.00, 0, 3712, 11, 4, 5),
(81, 'CAJA ACETATO', 0, 0, 0, 3300, 13200, 2032, 15232, '2024-02-05', '2024-02-05', 4, 0.00, 0, 3808, 11, 4, 4),
(82, 'CAJA CRAFT ANCHETA', 0, 0, 0, 2500, 12500, 2540, 15040, '2024-02-05', '2024-02-05', 5, 0.00, 0, 3008, 11, 4, 5),
(83, 'CAJA CILINDRO ESTAMPADA ROSA ROJA', 0, 0, 0, 11900, 35700, 1524, 37224, '2024-02-05', '2024-02-05', 3, 0.00, 0, 12408, 11, 4, 3),
(84, 'LONCHERA ACETATO', 0, 0, 0, 3000, 36000, 6096, 42096, '2024-02-05', '2024-02-05', 12, 0.00, 0, 3508, 11, 4, 12),
(85, 'CAJA DURALONCHERA ROSA NEGRA', 0, 0, 0, 17000, 34000, 1016, 35016, '2024-02-05', '2024-02-05', 2, 0.00, 0, 17508, 11, 4, 2),
(86, 'ROSETONES ROSADOS', 0, 0, 0, 1700, 17000, 2120, 19120, '2024-02-05', '2024-02-05', 10, 0.00, 0, 1912, 2, 11, 10),
(87, 'ROSA CARULINA ROSADA', 2, 11, 10900, 990, 21800, 5088, 26444, '2024-02-05', '2024-02-05', 22, 0.00, 0, 1202, 2, 11, 24),
(88, 'ROSA CARTULINA LILA', 2, 12, 10900, 908, 21800, 5088, 26880, '2024-02-05', '2024-02-05', 24, 0.00, 0, 1120, 2, 11, 24),
(89, 'FLOR CARTULINA', 5, 3, 5600, 1866, 28000, 3180, 31170, '2024-02-05', '2024-02-05', 15, 0.00, 0, 2078, 11, 11, 15);

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
  `nombre_proveedor` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(11, 'DECORARTE', 'CALI', '0000000000');

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
  MODIFY `cod_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `cod_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

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
