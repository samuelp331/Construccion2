-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-02-2024 a las 04:59:39
-- Versión del servidor: 8.0.33
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


--
-- Base de datos: `veterinary`
--
CREATE DATABASE veterinary;
use veterinary;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bill`
--

CREATE TABLE `bill` (
  `id` int NOT NULL,
  `pet_id` int NOT NULL,
  `owner_id` int NOT NULL,
  `order_id` int NOT NULL,
  `product_name` varchar(250) NOT NULL,
  `value` bigint NOT NULL,
  `quantity` int NOT NULL,
  `date` date NOT NULL
) ;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `history`
--

CREATE TABLE `history` (
  `date` date NOT NULL,
  `doctor` varchar(50) NOT NULL,
  `reason` varchar(250) NOT NULL,
  `symptoms` text NOT NULL,
  `diagnostic` text NOT NULL,
  `procedure_pet` text NOT NULL,
  `medicine` text NOT NULL,
  `dosis` varchar(250) NOT NULL,
  `order_id` bigint NOT NULL,
  `vaccination_record` text NOT NULL,
  `detail` text NOT NULL,
  `cancellation` tinyint(1) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `id` bigint NOT NULL,
  `name` varchar(50) NOT NULL,
  `age` int NOT NULL,
  `id_rol` int NOT NULL
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pet`
--

CREATE TABLE `pet` (
  `id` int NOT NULL,
  `name` int NOT NULL,
  `owner_id` bigint NOT NULL,
  `age` int NOT NULL,
  `species` varchar(250) NOT NULL,
  `breed` varchar(250) NOT NULL,
  `caracteristics` varchar(250) NOT NULL,
  `weight` bigint NOT NULL
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pet_order`
--

CREATE TABLE `pet_order` (
  `id` int NOT NULL,
  `pet_id` int NOT NULL,
  `owner_id` bigint NOT NULL,
  `doctor_id` int NOT NULL,
  `medicine` text NOT NULL,
  `date` date NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL
);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pet`
--
ALTER TABLE `pet`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pet_order`
--
ALTER TABLE `pet_order`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pet`
--
ALTER TABLE `pet`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pet_order`
--
ALTER TABLE `pet_order`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `rol`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

 --
 --
 --
ALTER TABLE `bill`
  ADD CONSTRAINT `fk_pet_id` FOREIGN KEY (`pet_id`) REFERENCES `pet`(`id`),
  ADD CONSTRAINT `fk_owner_id` FOREIGN KEY (`owner_id`) REFERENCES `person`(`id`),
  ADD CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `pet_order`(`id`);

--
--
--
ALTER TABLE `history`
  ADD CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `pet_order`(`id`);

--
--
--
ALTER TABLE `pet`
  ADD CONSTRAINT `fk_owner_id` FOREIGN KEY (`owner_id`) REFERENCES `person`(`id`);

--
--
--
ALTER TABLE `pet_order`
  ADD CONSTRAINT `fk_pet_id` FOREIGN KEY (`pet_id`) REFERENCES `pet`(`id`),
  ADD CONSTRAINT `fk_owner_id` FOREIGN KEY (`owner_id`) REFERENCES `person`(`id`),
  ADD CONSTRAINT `fk_doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `person`(`id`),
COMMIT;

