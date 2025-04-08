-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-04-2025 a las 11:25:38
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pokemondb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador_tiene`
--

CREATE TABLE `entrenador_tiene` (
  `trainer_id` int(11) NOT NULL,
  `pokemon_id` int(11) NOT NULL,
  `cp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrenador_tiene`
--

INSERT INTO `entrenador_tiene` (`trainer_id`, `pokemon_id`, `cp`) VALUES
(2, 2, 82),
(2, 4, 71),
(3, 1, 84),
(3, 2, 48),
(3, 4, 99),
(6, 4, 44);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon`
--

CREATE TABLE `pokemon` (
  `id_pokedex` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pokemon`
--

INSERT INTO `pokemon` (`id_pokedex`, `name`) VALUES
(1, 'Bulbasaur'),
(6, 'Charizard'),
(4, 'Charmander'),
(2, 'Ivysaur');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon_es_tipo`
--

CREATE TABLE `pokemon_es_tipo` (
  `pokemon_id` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pokemon_es_tipo`
--

INSERT INTO `pokemon_es_tipo` (`pokemon_id`, `tipo`) VALUES
(1, 'Planta'),
(4, 'Fuego'),
(6, 'Dragón'),
(6, 'Fuego');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos`
--

CREATE TABLE `tipos` (
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipos`
--

INSERT INTO `tipos` (`tipo`) VALUES
('Dragón'),
('Fuego'),
('Normal'),
('Planta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trainer`
--

CREATE TABLE `trainer` (
  `id` int(11) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `trainer`
--

INSERT INTO `trainer` (`id`, `nickname`, `password`) VALUES
(1, 'AdminTrainer', 'AdminTrainer'),
(2, 'Jeremy', 'Jeremy'),
(3, 'Marc', 'Marc'),
(4, 'Miquel Bardaji', 'MBardaji'),
(6, 'Valeria', 'Valeria'),
(9, 'prueba', 'prueba');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrenador_tiene`
--
ALTER TABLE `entrenador_tiene`
  ADD PRIMARY KEY (`trainer_id`,`pokemon_id`),
  ADD KEY `pokemon_id` (`pokemon_id`);

--
-- Indices de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`id_pokedex`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indices de la tabla `pokemon_es_tipo`
--
ALTER TABLE `pokemon_es_tipo`
  ADD PRIMARY KEY (`pokemon_id`,`tipo`),
  ADD KEY `tipo` (`tipo`);

--
-- Indices de la tabla `tipos`
--
ALTER TABLE `tipos`
  ADD PRIMARY KEY (`tipo`);

--
-- Indices de la tabla `trainer`
--
ALTER TABLE `trainer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nickname` (`nickname`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `trainer`
--
ALTER TABLE `trainer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entrenador_tiene`
--
ALTER TABLE `entrenador_tiene`
  ADD CONSTRAINT `entrenador_tiene_ibfk_1` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`id`),
  ADD CONSTRAINT `entrenador_tiene_ibfk_2` FOREIGN KEY (`pokemon_id`) REFERENCES `pokemon` (`id_pokedex`);

--
-- Filtros para la tabla `pokemon_es_tipo`
--
ALTER TABLE `pokemon_es_tipo`
  ADD CONSTRAINT `pokemon_es_tipo_ibfk_1` FOREIGN KEY (`tipo`) REFERENCES `tipos` (`tipo`),
  ADD CONSTRAINT `pokemon_es_tipo_ibfk_2` FOREIGN KEY (`pokemon_id`) REFERENCES `pokemon` (`id_pokedex`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
