-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 25-04-2025 a las 15:44:59
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

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
(3, 126, 56),
(3, 151, 81),
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
(63, 'Abra'),
(142, 'Aerodactyl'),
(65, 'Alakazam'),
(24, 'Arbok'),
(59, 'Arcanine'),
(144, 'Articuno'),
(15, 'Beedrill'),
(69, 'Bellsprout'),
(9, 'Blastoise'),
(1, 'Bulbasaur'),
(12, 'Butterfree'),
(10, 'Caterpie'),
(113, 'Chansey'),
(6, 'Charizard'),
(4, 'Charmander'),
(5, 'Charmeleon'),
(36, 'Clefable'),
(35, 'Clefairy'),
(91, 'Cloyster'),
(104, 'Cubone'),
(87, 'Dewgong'),
(50, 'Diglett'),
(132, 'Ditto'),
(85, 'Dodrio'),
(84, 'Doduo'),
(148, 'Dragonair'),
(149, 'Dragonite'),
(147, 'Dratini'),
(96, 'Drowzee'),
(51, 'Dugtrio'),
(133, 'Eevee'),
(23, 'Ekans'),
(125, 'Electabuzz'),
(101, 'Electrode'),
(102, 'Exeggcute'),
(103, 'Exeggutor'),
(83, 'Farfetch’d'),
(22, 'Fearow'),
(136, 'Flareon'),
(92, 'Gastly'),
(94, 'Gengar'),
(74, 'Geodude'),
(44, 'Gloom'),
(42, 'Golbat'),
(118, 'Goldeen'),
(55, 'Golduck'),
(76, 'Golem'),
(75, 'Graveler'),
(88, 'Grimer'),
(58, 'Growlithe'),
(130, 'Gyarados'),
(93, 'Haunter'),
(107, 'Hitmonchan'),
(106, 'Hitmonlee'),
(116, 'Horsea'),
(97, 'Hypno'),
(2, 'Ivysaur'),
(39, 'Jigglypuff'),
(135, 'Jolteon'),
(124, 'Jynx'),
(140, 'Kabuto'),
(141, 'Kabutops'),
(64, 'Kadabra'),
(14, 'Kakuna'),
(115, 'Kangaskhan'),
(99, 'Kingler'),
(109, 'Koffing'),
(98, 'Krabby'),
(131, 'Lapras'),
(108, 'Lickitung'),
(68, 'Machamp'),
(67, 'Machoke'),
(66, 'Machop'),
(129, 'Magikarp'),
(126, 'Magmar'),
(81, 'Magnemite'),
(82, 'Magneton'),
(56, 'Mankey'),
(105, 'Marowak'),
(52, 'Meowth'),
(11, 'Metapod'),
(151, 'Mew'),
(150, 'Mewtwo'),
(146, 'Moltres'),
(122, 'Mr. Mime'),
(89, 'Muk'),
(34, 'Nidoking'),
(31, 'Nidoqueen'),
(29, 'Nidoran♀'),
(32, 'Nidoran♂'),
(30, 'Nidorina'),
(33, 'Nidorino'),
(38, 'Ninetales'),
(43, 'Oddish'),
(138, 'Omanyte'),
(139, 'Omastar'),
(95, 'Onix'),
(46, 'Paras'),
(47, 'Parasect'),
(53, 'Persian'),
(18, 'Pidgeot'),
(17, 'Pidgeotto'),
(16, 'Pidgey'),
(25, 'Pikachu'),
(127, 'Pinsir'),
(60, 'Poliwag'),
(61, 'Poliwhirl'),
(62, 'Poliwrath'),
(77, 'Ponyta'),
(137, 'Porygon'),
(57, 'Primeape'),
(54, 'Psyduck'),
(26, 'Raichu'),
(78, 'Rapidash'),
(20, 'Raticate'),
(19, 'Rattata'),
(112, 'Rhydon'),
(111, 'Rhyhorn'),
(27, 'Sandshrew'),
(28, 'Sandslash'),
(123, 'Scyther'),
(117, 'Seadra'),
(119, 'Seaking'),
(86, 'Seel'),
(90, 'Shellder'),
(80, 'Slowbro'),
(79, 'Slowpoke'),
(143, 'Snorlax'),
(21, 'Spearow'),
(7, 'Squirtle'),
(121, 'Starmie'),
(120, 'Staryu'),
(114, 'Tangela'),
(128, 'Tauros'),
(72, 'Tentacool'),
(73, 'Tentacruel'),
(134, 'Vaporeon'),
(49, 'Venomoth'),
(48, 'Venonat'),
(3, 'Venusaur'),
(71, 'Victreebel'),
(45, 'Vileplume'),
(100, 'Voltorb'),
(37, 'Vulpix'),
(8, 'Wartortle'),
(13, 'Weedle'),
(70, 'Weepinbell'),
(110, 'Weezing'),
(40, 'Wigglytuff'),
(145, 'Zapdos'),
(41, 'Zubat');

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
(1, 'Veneno'),
(2, 'Planta'),
(2, 'Veneno'),
(3, 'Planta'),
(3, 'Veneno'),
(4, 'Fuego'),
(5, 'Fuego'),
(6, 'Dragón'),
(6, 'Fuego'),
(6, 'Volador'),
(7, 'Agua'),
(8, 'Agua'),
(9, 'Agua'),
(10, 'Bicho'),
(11, 'Bicho'),
(12, 'Bicho'),
(12, 'Volador'),
(13, 'Bicho'),
(13, 'Veneno'),
(14, 'Bicho'),
(14, 'Veneno'),
(15, 'Bicho'),
(15, 'Veneno'),
(16, 'Normal'),
(16, 'Volador'),
(17, 'Normal'),
(17, 'Volador'),
(18, 'Normal'),
(18, 'Volador'),
(19, 'Normal'),
(20, 'Normal'),
(21, 'Normal'),
(21, 'Volador'),
(22, 'Normal'),
(22, 'Volador'),
(23, 'Veneno'),
(24, 'Veneno'),
(25, 'Eléctrico'),
(26, 'Eléctrico'),
(27, 'Tierra'),
(28, 'Tierra'),
(29, 'Veneno'),
(30, 'Veneno'),
(31, 'Tierra'),
(31, 'Veneno'),
(32, 'Veneno'),
(33, 'Veneno'),
(34, 'Tierra'),
(34, 'Veneno'),
(35, 'Hada'),
(36, 'Hada'),
(39, 'Hada'),
(39, 'Normal'),
(40, 'Hada'),
(40, 'Normal'),
(41, 'Veneno'),
(41, 'Volador'),
(42, 'Veneno'),
(42, 'Volador'),
(43, 'Planta'),
(43, 'Veneno'),
(44, 'Planta'),
(44, 'Veneno'),
(45, 'Planta'),
(45, 'Veneno'),
(46, 'Bicho'),
(46, 'Planta'),
(47, 'Bicho'),
(47, 'Planta'),
(48, 'Bicho'),
(48, 'Veneno'),
(49, 'Bicho'),
(49, 'Veneno'),
(50, 'Tierra'),
(51, 'Tierra'),
(52, 'Normal'),
(53, 'Normal'),
(54, 'Agua'),
(55, 'Agua'),
(56, 'Lucha'),
(57, 'Lucha'),
(58, 'Fuego'),
(59, 'Fuego'),
(60, 'Agua'),
(61, 'Agua'),
(62, 'Agua'),
(62, 'Lucha'),
(63, 'Psíquico'),
(64, 'Psíquico'),
(65, 'Psíquico'),
(66, 'Lucha'),
(67, 'Lucha'),
(68, 'Lucha'),
(69, 'Planta'),
(69, 'Veneno'),
(70, 'Planta'),
(70, 'Veneno'),
(71, 'Planta'),
(71, 'Veneno'),
(72, 'Agua'),
(72, 'Veneno'),
(73, 'Agua'),
(73, 'Veneno'),
(74, 'Roca'),
(74, 'Tierra'),
(75, 'Roca'),
(75, 'Tierra'),
(76, 'Roca'),
(76, 'Tierra'),
(77, 'Fuego'),
(78, 'Fuego'),
(79, 'Agua'),
(79, 'Psíquico'),
(80, 'Agua'),
(80, 'Psíquico'),
(81, 'Acero'),
(81, 'Eléctrico'),
(82, 'Acero'),
(82, 'Eléctrico'),
(83, 'Normal'),
(83, 'Volador'),
(84, 'Normal'),
(84, 'Volador'),
(85, 'Normal'),
(85, 'Volador'),
(86, 'Agua'),
(87, 'Agua'),
(87, 'Hielo'),
(88, 'Veneno'),
(89, 'Veneno'),
(90, 'Agua'),
(91, 'Agua'),
(91, 'Hielo'),
(92, 'Fantasma'),
(92, 'Veneno'),
(93, 'Fantasma'),
(93, 'Veneno'),
(94, 'Fantasma'),
(94, 'Veneno'),
(95, 'Roca'),
(95, 'Tierra'),
(96, 'Psíquico'),
(97, 'Psíquico'),
(98, 'Agua'),
(99, 'Agua'),
(100, 'Eléctrico'),
(101, 'Eléctrico'),
(102, 'Planta'),
(102, 'Psíquico'),
(103, 'Planta'),
(103, 'Psíquico'),
(104, 'Tierra'),
(105, 'Tierra'),
(106, 'Lucha'),
(107, 'Lucha'),
(108, 'Normal'),
(109, 'Veneno'),
(110, 'Veneno'),
(111, 'Roca'),
(111, 'Tierra'),
(112, 'Roca'),
(112, 'Tierra'),
(113, 'Normal'),
(114, 'Planta'),
(115, 'Normal'),
(116, 'Agua'),
(117, 'Agua'),
(118, 'Agua'),
(119, 'Agua'),
(120, 'Agua'),
(121, 'Agua'),
(121, 'Psíquico'),
(122, 'Hada'),
(122, 'Psíquico'),
(123, 'Bicho'),
(123, 'Volador'),
(124, 'Hielo'),
(124, 'Psíquico'),
(125, 'Eléctrico'),
(126, 'Fuego'),
(127, 'Bicho'),
(128, 'Normal'),
(129, 'Agua'),
(130, 'Agua'),
(130, 'Volador'),
(131, 'Agua'),
(131, 'Hielo'),
(132, 'Normal'),
(133, 'Normal'),
(134, 'Agua'),
(135, 'Eléctrico'),
(136, 'Fuego'),
(137, 'Normal'),
(138, 'Agua'),
(138, 'Roca'),
(139, 'Agua'),
(139, 'Roca'),
(140, 'Agua'),
(140, 'Roca'),
(141, 'Agua'),
(141, 'Roca'),
(142, 'Roca'),
(142, 'Volador'),
(143, 'Normal'),
(144, 'Hielo'),
(144, 'Volador'),
(145, 'Eléctrico'),
(145, 'Volador'),
(146, 'Fuego'),
(146, 'Volador'),
(147, 'Dragón'),
(148, 'Dragón'),
(149, 'Dragón'),
(149, 'Volador'),
(150, 'Psíquico'),
(151, 'Psíquico');

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
('Acero'),
('Agua'),
('Bicho'),
('Dragón'),
('Eléctrico'),
('Fantasma'),
('Fuego'),
('Hada'),
('Hielo'),
('Lucha'),
('Normal'),
('Planta'),
('Psíquico'),
('Roca'),
('Siniestro'),
('Tierra'),
('Veneno'),
('Volador');

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
