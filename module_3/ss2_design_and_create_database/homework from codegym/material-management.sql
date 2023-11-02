create database material_management;
use material_management;
create table phieu_xuat(
so_px int primary key auto_increment,
ngay_xuat date
);
create table vat_tu(
ma_vtu int primary key auto_increment,
ten_vtu varchar(255)
);
create table phieuxuat_vattu(
id int primary key auto_increment,
dg_xuat int,
sl_xuat int,
so_px int,
ma_vtu int,
foreign key (so_px) references phieu_xuat(so_px),
foreign key (ma_vtu) references vat_tu(ma_vtu)
);
create table phieu_nhap(
so_pn int primary key auto_increment,
ngay_nhap date
);
create table phieunhap_vattu(
id int primary key auto_increment,
dg_nhap int,
sl_nhap int,
so_pn int,
ma_vtu int,
foreign key (so_pn) references phieu_nhap(so_pn),
foreign key (ma_vtu) references vat_tu(ma_vtu)
);
create table nha_cc(
ma_ncc int primary key auto_increment,
ten_ncc varchar(255),
diachi varchar(255)
);
create table don_dh(
so_dh int primary key auto_increment,
ngay_dh date,
ma_ncc int,
foreign key (ma_ncc) references nha_cc(ma_ncc)
);
create table dondh_vattu(
id int primary key auto_increment,
so_dh int,
ma_vtu int,
foreign key (so_dh) references don_dh(so_dh),
foreign key (ma_vtu) references vat_tu(ma_vtu)
);
create table so_dt(
id int primary key auto_increment,
sdt varchar(255),
ma_ncc int,
foreign key (ma_ncc) references nha_cc(ma_ncc)
);