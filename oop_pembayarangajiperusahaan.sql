-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 16, 2023 at 11:48 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop_pembayarangajiperusahaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_datalembur`
--

CREATE TABLE `tb_datalembur` (
  `id` int NOT NULL,
  `id_karyawan` varchar(30) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `durasi_lembur` int NOT NULL,
  `pajak` int NOT NULL,
  `gaji_lembur` int NOT NULL,
  `alasan_lembur` varchar(30) NOT NULL,
  `total_gaji` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_datalembur`
--

INSERT INTO `tb_datalembur` (`id`, `id_karyawan`, `nama_karyawan`, `tanggal`, `durasi_lembur`, `pajak`, `gaji_lembur`, `alasan_lembur`, `total_gaji`) VALUES
(1, 'KRYN014', 'Natan', '12 Desember 2023', 10, 50000, 500000, 'Deadline Yang Ketat', 4450000),
(2, 'KRYN015', 'Tito', '15 Desember 2023', 8, 50000, 400000, 'Beban Kerja Yang Banyak', 4350000),
(3, 'KRYN016', 'Ardiansyah', '16 Desember 2023', 5, 20000, 250000, 'Menambah Penghasilan', 4230000),
(4, 'SKRS001', 'Prayitno', '18 Desember 2023', 4, 20000, 200000, 'Beban Kerja Yang Banyak', 4180000),
(5, 'MNGR002', 'Ferdi', '19 Desember 2023', 7, 25000, 350000, 'Deadline Yang Ketat', 4325000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pembayarangaji`
--

CREATE TABLE `tb_pembayarangaji` (
  `id` int NOT NULL,
  `id_karyawan` varchar(30) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `gaji_pokok` int NOT NULL,
  `tunjangan` int NOT NULL,
  `pajak` int NOT NULL,
  `total_gaji` int NOT NULL,
  `metode_pembayaran` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tb_pembayarangaji`
--

INSERT INTO `tb_pembayarangaji` (`id`, `id_karyawan`, `nama_karyawan`, `email`, `jabatan`, `gaji_pokok`, `tunjangan`, `pajak`, `total_gaji`, `metode_pembayaran`) VALUES
(1, 'KRYN014', 'Natan', 'natan123@gmail.com', 'Karyawan', 4000000, 250000, 100000, 4150000, 'Transfer Bank'),
(2, 'KRYN015', 'Tito', 'tito123@gmail.com', 'Karyawan', 4000000, 300000, 100000, 4200000, 'Tunai'),
(3, 'KRYN016', 'Ardiansyah', 'ardi123@gmail.com', 'Karyawan', 4000000, 200000, 100000, 4100000, 'Tunai'),
(4, 'SKRS001', 'Prayitno', 'prayino123@gmail.com', 'Sekretaris', 5000000, 600000, 150000, 5450000, 'Transfer Bank'),
(5, 'MNGR002', 'Ferdi', 'ferdi123@gmail.com', 'Manager', 7000000, 800000, 200000, 7600000, 'Tunai');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_datalembur`
--
ALTER TABLE `tb_datalembur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_pembayarangaji`
--
ALTER TABLE `tb_pembayarangaji`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_datalembur`
--
ALTER TABLE `tb_datalembur`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tb_pembayarangaji`
--
ALTER TABLE `tb_pembayarangaji`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
