CREATE DATABASE `order-management`;
USE `order-management`;
CREATE TABLE `don_vi_dat_hang` (
	ma_dv VARCHAR(45) PRIMARY KEY,
    ten_dv VARCHAR(45),
    dia_chi VARCHAR (255),
    dien_thoai VARCHAR(45)
);
CREATE TABLE `don_vi_khach_hang` (
	ma_dv VARCHAR(45) PRIMARY KEY,
    ten_dv VARCHAR(45),
    dia_chi VARCHAR (255)
);
CREATE TABLE `hang` (
	ma_hang VARCHAR(45) PRIMARY KEY,
    ten_hang VARCHAR(255),
	dv_tinh VARCHAR(45),
    mo_ta_hang VARCHAR(45)
);
CREATE TABLE `nguoi_dat` (
	ma_so_nd VARCHAR(45) PRIMARY KEY,
    ho_ten_nd VARCHAR(255)
);
CREATE TABLE `noi_giao` (
	ma_so_ddg VARCHAR(45) PRIMARY KEY,
    ten_noi_giao VARCHAR(255)
);
CREATE TABLE `nguoi_nhan` (
	ma_so_nn VARCHAR(45) PRIMARY KEY,
    ho_ten_nn VARCHAR(255)
);
CREATE TABLE `nguoi_giao` (
	ma_so_ng VARCHAR(45) PRIMARY KEY,
    ho_ten_ng VARCHAR(255)
);





