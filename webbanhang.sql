-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 15, 2023 at 10:40 AM
-- Server version: 8.0.33
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webbanhang`
--

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`id`, `name`) VALUES
(1, 'Iphone'),
(2, 'Ipad'),
(3, 'Watch'),
(4, 'Mac'),
(5, 'Airpods'),
(6, 'Phụ kiện');

--
-- Dumping data for table `invoices`
--

INSERT INTO `invoices` (`id`, `invoice_date`, `total`, `user_id`) VALUES
(1, '2023-06-15 12:01:23.680000', 24490000, NULL),
(2, '2023-06-15 13:50:12.856000', 24490000, NULL),
(3, '2023-06-15 15:44:23.933000', 24490000, NULL),
(4, '2023-06-15 16:03:49.031000', 48980000, NULL),
(5, '2023-06-15 17:39:01.943000', 31990000, NULL);

--
-- Dumping data for table `item_invoice`
--

INSERT INTO `item_invoice` (`id`, `quantity`, `invoice_id`, `sanpham_id`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 1),
(3, 1, 3, 1),
(4, 2, 4, 1),
(5, 1, 5, 62);

--
-- Dumping data for table `mau`
--

INSERT INTO `mau` (`id`, `name`) VALUES
(1, 'Deep Purple'),
(2, 'Midnight'),
(3, 'Gold'),
(4, 'Space Black'),
(5, 'Silver'),
(6, 'White'),
(7, 'Red'),
(8, 'Purple'),
(9, 'Pacific Blue'),
(10, 'Pink'),
(11, 'Blue'),
(12, 'Alpine Green'),
(13, 'Space Gray'),
(14, 'Starlight'),
(15, 'Yellow'),
(16, 'Gray'),
(17, 'Orange'),
(18, 'Black'),
(19, 'Brown'),
(20, 'Green');

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `description`, `name`) VALUES
(1, NULL, 'ADMIN'),
(2, NULL, 'USER');

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `price`, `title`, `mau_id`, `image`, `danhmuc_id`) VALUES
(1, 24490000, 'iPhone 14 Pro 128GB - Chính hãng VN/A', 3, '143.png', 1),
(2, 24790000, 'iPhone 14 Pro 128GB - Chính hãng VN/A', 1, '141.png', 1),
(3, 24690000, 'iPhone 14 Pro 128GB - Chính hãng VN/A', 4, '144.png', 1),
(4, 24890000, 'iPhone 14 Pro 128GB - Chính hãng VN/A', 5, '142.png', 1),
(5, 11990000, 'iPhone 11 128GB - Chính hãng VN/A', 2, '111.png', 1),
(7, 11990000, 'iPhone 11 128GB - Chính hãng VN/A', 6, '112.png', 1),
(8, 14690000, 'iPhone 12 64GB - Chính hãng VN/A - MGJ73VN/A', 2, '121.png', 1),
(9, 14790000, 'iPhone 12 64GB - Chính hãng VN/A - MGJ73VN/A', 7, '122.png', 1),
(10, 14790000, 'iPhone 12 64GB - Chính hãng VN/A - MGJ73VN/A', 8, '123.png', 1),
(11, 14790000, 'iPhone 12 64GB - Chính hãng VN/A - MGJ73VN/A', 9, '124.png', 1),
(12, 16390000, 'iPhone 13 128GB - Chính Hãng VN/A', 2, '131.png', 1),
(13, 15990000, 'iPhone 13 128GB - Chính Hãng VN/A', 7, '132.png', 1),
(14, 16490000, 'iPhone 13 128GB - Chính Hãng VN/A', 6, '133.png', 1),
(15, 16490000, 'iPhone 13 128GB - Chính Hãng VN/A', 10, '134.png', 1),
(16, 16390000, 'iPhone 13 128GB - Chính Hãng VN/A', 11, '135.png', 1),
(17, 16490000, 'iPhone 13 128GB - Chính Hãng VN/A', 12, '136.png', 1),
(18, 23990000, 'iPad Pro 11 M2 2022 - Chính hãng VN - MNYD3ZA/A', 13, '1.png', 2),
(19, 23990000, 'iPad Pro 11 M2 2022 - Chính hãng VN - MNYD3ZA/A', 6, '2.png', 2),
(20, 18290000, 'iPad Air 5 256GB Wifi - Chính hãng VN', 8, '3.png', 2),
(21, 18290000, 'iPad Air 5 256GB Wifi - Chính hãng VN', 13, '4.png', 2),
(22, 18290000, 'iPad Air 5 256GB Wifi - Chính hãng VN', 10, '5.png', 2),
(23, 18290000, 'iPad Air 5 256GB Wifi - Chính hãng VN', 14, '6.png', 2),
(24, 18290000, 'iPad Air 5 256GB Wifi - Chính hãng VN', 11, '7.png', 2),
(25, 14390000, 'iPad Gen 10 2022 Wifi + 5G - Chính hãng VN', 10, '8.png', 2),
(26, 14390000, 'iPad Gen 10 2022 Wifi + 5G - Chính hãng VN', 5, '9.png', 2),
(27, 14390000, 'iPad Gen 10 2022 Wifi + 5G - Chính hãng VN', 15, '10.png', 2),
(28, 14390000, 'iPad Gen 10 2022 Wifi + 5G - Chính hãng VN', 11, '11.png', 2),
(29, 13590000, 'iPad Gen 9 256G Wifi + 4G - Chính Hãng VN', 16, '12.png', 2),
(30, 13590000, 'iPad Gen 9 256G Wifi + 4G - Chính Hãng VN', 5, '13.png', 2),
(31, 18990000, 'iPad Mini 6 256G Wifi + 5G - Chính Hãng VN', 8, '14.png', 2),
(32, 18990000, 'iPad Mini 6 256G Wifi + 5G - Chính Hãng VN', 13, '15.png', 2),
(33, 18990000, 'iPad Mini 6 256G Wifi + 5G - Chính Hãng VN', 10, '16.png', 2),
(34, 18990000, 'iPad Mini 6 256G Wifi + 5G - Chính Hãng VN', 14, '17.png', 2),
(35, 19990000, 'Apple Watch Ultra LTE 49mm Dây Ocean Band ', 15, 'vang.png', 3),
(36, 18990000, 'Apple Watch Ultra LTE 49mm Dây Alpine Loop', 17, 'cam.png', 3),
(37, 18990000, 'Apple Watch Ultra LTE 49mm Dây Trail Loop', 16, 'den.png', 3),
(38, 9990000, 'Apple Watch S7 LTE 45mm - Chính Hãng VN/A', 6, 'trang.png', 3),
(39, 12490000, 'Apple Watch S7 LTE 45mm - Chính Hãng VN/A', 20, 'xanhla.png', 3),
(40, 17790000, 'Apple Watch S7 LTE 45mm - Chính Hãng VN/A', 19, 'nau.png', 3),
(41, 17790000, 'Apple Watch S7 LTE 45mm - Chính Hãng VN/A', 16, 'xanh.png', 3),
(42, 13990000, 'Apple Watch S6 LTE 44mm', 16, '18.png', 3),
(43, 8490000, 'Apple Watch S6 GPS 44mm - Chính Hãng VN/A', 7, '19.png', 3),
(44, 8490000, 'Apple Watch S6 GPS 44mm - Chính Hãng VN/A', 10, '20.png', 3),
(45, 8490000, 'Apple Watch S6 GPS 44mm - Chính Hãng VN/A', 5, '21.png', 3),
(46, 8490000, 'Apple Watch S6 GPS 44mm - Chính Hãng VN/Av', 11, '22.png', 3),
(47, 6790000, 'Apple Watch SE 2022 GPS 44mm - Chính hãng VN/A', 2, '23.png', 3),
(48, 7490000, 'Apple Watch SE GPS 44mm - Chính Hãng VN/A', 10, '24.png', 3),
(49, 7490000, 'Apple Watch SE GPS 44mm - Chính Hãng VN/A', 5, '25.png', 3),
(50, 8990000, 'Apple Watch S8 GPS 41mm - Chính hãng VN/A', 18, '26.png', 3),
(51, 8990000, 'Apple Watch S8 GPS 41mm - Chính hãng VN/A', 7, '27.png', 3),
(52, 18490000, 'Apple Watch S8 LTE 41mm - Chính hãng VN/A', 5, '28.png', 3),
(53, 18490000, 'Apple Watch S8 LTE 41mm - Chính hãng VN/A', 18, '29.png', 3),
(54, 18490000, 'Apple Watch S8 LTE 41mm - Chính hãng VN/A', 3, '30.png', 3),
(55, 18890000, 'Apple Watch S8 LTE 41mm - Chính hãng VN/A', 5, '31.png', 3),
(56, 18890000, 'Apple Watch S8 LTE 41mm - Chính hãng VN/A', 3, '32.png', 3),
(57, 4390000, 'Apple Watch S3 GPS 38mm - Chính Hãng VN/A', 16, '33.png', 3),
(58, 4390000, 'Apple Watch S3 GPS 38mm - Chính Hãng VN/A', 5, '34.png', 3),
(59, 25990000, 'MacBook Pro 13\" M1 2020 256GB', 5, '35.png', 4),
(60, 27790000, 'MacBook Pro 13\" M1 2020 256GB', 16, '36.png', 4),
(61, 31990000, 'Macbook Air M2 15 inch 2023 8CPU 10GPU 256GB', 14, '37.png', 4),
(62, 31990000, 'Macbook Air M2 15 inch 2023 8CPU 10GPU 256GB', 5, '38.png', 4),
(63, 52990000, 'Mac Studio Chip Apple M1', 5, 'mac-studio.png', 4),
(64, 40490000, 'iMac M1 2021 24 inch - Chính hãng Apple VN', 11, '39.png', 4),
(65, 35790000, 'iMac M1 2021 24 inch - Chính hãng Apple VN', 17, '40.png', 3),
(66, 46190000, 'iMac M1 2021 24 inch - Chính hãng Apple VN', 8, '41.png', 4),
(67, 39990000, 'iMac M1 2021 24 inch - Chính hãng Apple VN', 15, '42.png', 4),
(68, 14990000, 'Mac mini 2023 M2 256GB SSD', 5, 'macmini.png', 4),
(69, 4990000, 'APPLE TV 4K 64GB chính hãng VN - MXH02ZA/A', 5, 'APPLE TV.png', 4),
(70, 4090000, 'Tai nghe AirPods 3 2022 - Chính hãng VN', 5, 'AirPods 3.png', 5),
(71, 9890000, 'Tai nghe Bluetooth AirPods Max - Chính hãng VN/A', 18, 'ap den.png', 5),
(72, 5790000, 'Tai nghe AirPods Pro 2 - Chính hãng VN', 5, 'ap pro.png', 5),
(73, 2590000, 'Tai nghe Bluetooth AirPods 2 - Chính hãng VN', 5, 'ap2.png', 5);

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `phone`, `provider`, `username`) VALUES
(1, 'lutruongthang2511@gmail.com', '$2a$10$1cPs43RLM2Lh/c2dJi6S9eHFwGujP8OMDyTLzSI3zYo4C9usifasy', '0931798072', NULL, 'truongthang'),
(2, 'demo1@gmail.com', '$2a$10$1cPs43RLM2Lh/c2dJi6S9eHFwGujP8OMDyTLzSI3zYo4C9usifasy', '1111111111', NULL, 'hutechcntt');

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
