-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Des 2020 pada 04.23
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javagui`
--
CREATE DATABASE IF NOT EXISTS `uas_database` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `uas_database`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `idadmin` char(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`idadmin`, `name`, `email`, `password`) VALUES
('AD001', 'Adellia ', 'Adellia@gmail.com', '001122'),
('AD002', 'Chandra Putra', 'Chandraptr@gmail.com', '112233'),
('AD003', 'Fidelyana', 'Fidelyanafr@gmail.com', '123123'),
('AD004', 'Indira ', 'Indira00@gmail.com', '00567'),
('AD005', 'Jovanka', 'Jovankareal@gmail.com', '98765');

-- --------------------------------------------------------

--
-- Struktur dari tabel `admindata`
--

CREATE TABLE `admindata` (
  `username` varchar(15) NOT NULL,
  `pas` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admindata`
--

INSERT INTO `admindata` (`username`, `pas`) VALUES
('admin', 'admin'),
('admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `cd`
--

CREATE TABLE `cd` (
  `idCD` char(5) NOT NULL,
  `title` varchar(200) NOT NULL,
  `qty` varchar(25) NOT NULL,
  `price` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `cd`
--

INSERT INTO `cd` (`idCD`, `title`, `qty`, `price`, `status`) VALUES
('FM01', 'Dilan 1991', '10', '40000', 'avaliable'),
('FM02', 'Bauty And The Beast', '5', '40000', 'avaliable'),
('FM03', 'Imperfect', '10', '40000', 'avaliable'),
('FM04', 'Milea: Suara dari Dilan ', '0', '40000', 'not avaliable'),
('FM05', 'Laskar Pelangi', '5', '35000', 'avaliable'),
('FM06', 'My Stupid Boss', '3', '40000', 'avaliable'),
('FM07', 'Pengabdi Setan', '9', '50000', 'avaliable'),
('FM08', 'Naruto 2', '0', '25000', 'not avaliable'),
('FM09', 'Tekken 7', '5', '25000', 'avaliable'),
('FM10', 'Winning Eleven', '7', '30000', 'avaliable'),
('FM11', 'PlayStation2 motoGP', '5', '25000', 'avaliable'),
('FM12', 'PlayStation2 FIFA', '0', '25000', 'not avaliable'),
('FM13', 'PS4 Football', '10', '25000', 'avaliable'),
('FM14', 'PlayStation 2 Pokemon', '6', '25000', 'avaliable'),
('FM15', 'Motor Cross', '0', '25000', 'not avaliable'),
('FM16', 'Noah - Sings Legend', '2', '30000', 'avaliable'),
('FM17', 'BTS Love Yourself', '8', '60000', 'avaliable'),
('FM18', 'EXO Exploration', '5', '50000', 'avaliable'),
('FM19', 'Tulus Monokrom ', '0', '30000', 'not avaliable'),
('FM20', 'Music Jazz', '15', '35000', 'avaliable');

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `penyewa` varchar(100) NOT NULL,
  `titleCD` varchar(200) NOT NULL,
  `totalprice` varchar(50) NOT NULL,
  `rentdate` varchar(25) NOT NULL,
  `duedate` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id`, `penyewa`, `titleCD`, `totalprice`, `rentdate`, `duedate`) VALUES
(1, 'Udin', '', '', '22-12-2020', '12-1-2021'),
(2, 'Denn', '', '', '22-12-2020', ''),
(3, 'Popol', '', '', '22-12-2020', '29-12-2020');

-- --------------------------------------------------------

--
-- Struktur dari tabel `employees`
--

CREATE TABLE `employees` (
  `ID` varchar(3) NOT NULL,
  `fullname` varchar(30) NOT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `position` varchar(30) NOT NULL,
  `salary` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `employees`
--

INSERT INTO `employees` (`ID`, `fullname`, `gender`, `position`, `salary`) VALUES
('001', 'Alice', 'Female', 'Director', 4500),
('002', 'Bob', 'Male', 'Operative Manager', 3500),
('003', 'Charlie', 'Male', 'Finace Manager', 3500),
('004', 'Dean', 'Male', 'Staff', 2000),
('005', 'ddd', 'Male', 'Director', 4500);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idadmin`);

--
-- Indeks untuk tabel `cd`
--
ALTER TABLE `cd`
  ADD PRIMARY KEY (`idCD`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
