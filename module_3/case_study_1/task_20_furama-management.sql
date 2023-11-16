create database furama_management;
use furama_management;

-- Luu tru thông tin vi trí làm tai resort cua nhân viên
create table vi_tri(
vtid int primary key auto_increment,
vtname varchar(45)
);

-- Luu tru thông tin trình đo cua nhân viên.
create table trinh_do(
tdid int primary key auto_increment,
tdname varchar(45)
);

-- Luu tru thông tin nhân viên nào se thuoc phòng ban nào.
create table bo_phan(
bpid int primary key auto_increment,
bpname varchar(45)
);

-- Luu tru thông tin cua nhân viên.
create table nhan_vien(
nvid int primary key auto_increment,
nvhoten varchar(45),
nvngaysinh date,
nvcmnd varchar(9),
nvsdt varchar(11),
nvemail varchar(45),
nvluong int,
nvdiachi varchar(255),
nvtrinhdoid int,
nvvitriid int,
nvbophanid int,
foreign key (nvtrinhdoid) references trinh_do(tdid),
foreign key (nvvitriid) references vi_tri(vtid),
foreign key (nvbophanid) references bo_phan(bpid)
);

-- Luu tru thông tin các loai khách hàng.
create table loai_khach(
lkid int primary key auto_increment,
lkname varchar(45)
);

-- Luu tru thông tin cua khách hàng.
create table khach_hang(
khid int primary key auto_increment,
khhoten varchar(45),
khngaysinh date,
khgioitinh varchar(45),
khcmnd varchar(9),
khsdt varchar(11),
khemail varchar(45),
khloaikhachid int,
khdiachi varchar(45),
foreign key (khloaikhachid) references loai_khach(lkid)
);

-- Luu tru các loai dich vu o resort.
create table loai_dich_vu(
ldvid int primary key auto_increment,
ldvname varchar(45)
);

-- Luu tru các loai kieu thuê nhu: theo gia, theo ngày, theo tháng, theo năm.
create table kieu_thue(
ktid int primary key auto_increment,
ktname varchar(45)
);

-- Luu tru thông tin các dich vu mà resort cung cap.
create table dich_vu(
dvid int primary key auto_increment,
dvname varchar(45),
dvarea double,
dvprice int,
dvmaxnumpeople int,
dvkieuthueid int,
dvstandardroom varchar(45),
dvtiennghikhac varchar(255),
dvpoolarea double,
dvsotang int,
dvfreeservice varchar(45),
dvloaidvid int,
foreign key (dvkieuthueid) references kieu_thue(ktid),
foreign key (dvloaidvid) references loai_dich_vu(ldvid)
);

-- Luu tru thông tin khách hàng thuc hien thuê dich vu tai resort.
create table hop_dong(
hdid int primary key auto_increment,
hdbegindate date,
hdenddate date,
hdcoctruoc int,
hdtotalpay int,
hdnhanvienid int,
hdkhachhangid int,
hddichvuid int,
foreign key (hdnhanvienid) references nhan_vien(nvid),
foreign key (hdkhachhangid) references khach_hang(khid),
foreign key (hddichvuid) references dich_vu(dvid)
);

-- Luu tru thông tin các dich vu đi kèm khi khách hàng thuê Phòng, Villa, House tai resort.
create table dich_vu_di_kem(
dvdkid int primary key auto_increment,
dvdkname varchar(45),
dvdkdonvi varchar(45),
dvdkprice int,
dvstatus varchar(255)
);

-- Luu tru thông tin mot khách hàng có the thuê nhieu dich vu đi kèm.
create table hop_dong_chi_tiet(
hdctid int primary key auto_increment,
hdcthdid int,
hdctdvdkid int,
soluong int,
foreign key (hdcthdid) references hop_dong(hdid),
foreign key (hdctdvdkid) references dich_vu_di_kem(dvdkid)
);

INSERT INTO vi_tri (vtname) VALUES ('Le tan'), ('Phuc vu'), ('Chuyen vien'), ('Giam sat'), ('Quan ly'), ('Giam doc');
INSERT INTO trinh_do (tdname) VALUES ('Trung cap'), ('Cao dang'), ('Dai hoc'), ('Sau dai hoc');
INSERT INTO bo_phan (bpname) VALUES ('Sale - Marketing'), ('Hanh chinh'), ('Phuc vu'), ('Quan ly');
INSERT INTO loai_khach (lkname) VALUES ('Diamond'), ('Platinum'), ('Gold'), ('Silver'), ('Member');
INSERT INTO loai_dich_vu (ldvname) VALUES ('Villa'), ('House'), ('Room');
INSERT INTO kieu_thue (ktname) VALUES ('year'), ('month'), ('day'), ('hour');

INSERT INTO dich_vu (dvname, dvarea, dvprice, dvmaxnumpeople, dvstandardroom, dvtiennghikhac, dvpoolarea, dvsotang, dvfreeservice, dvkieuthueid, dvloaidvid)
VALUES 
('Villa Beach Front',25000,1000000,10,'vip','Co ho boi',500,4,null,3,1),
('House Princess 01',14000,5000000,7,'vip','Co them bep nuong',null,3,null,2,2),
('Room Twin 01',5000,1000000,2,'normal','Co tivi',null,null,'1 Xe may, 1 Xe dap',4,3),
('Villa No Beach Front',22000,9000000,8,'normal','Co ho boi',300,3,null,3,1),
('House Princess 02',10000,4000000,5,'normal','Co them bep nuong',null,2,null,3,2),
('Room Twin 02',3000,900000,2,'normal','Co tivi',null,null,'1 Xe may',4,3);

INSERT INTO dich_vu_di_kem (dvdkname, dvdkprice, dvdkdonvi, dvstatus)
VALUES 
('Karaoke',10000,'gio','tien nghi, hien tai'),
('Thue xe may',10000,'chiec','hong 1 xe'),
('Thue xe dap',20000,'chiec','tot'),
('Buffet buoi sang',15000,'suat','day du do an, trang mieng'),
('Buffet buoi trua',90000,'suat','day du do an, trang mieng'),
('Buffet buoi toi',16000,'suat','day du do an, trang mieng');

INSERT INTO nhan_vien (nvhoten, nvngaysinh, nvcmnd, nvluong, nvsdt, nvemail, nvdiachi, nvvitriid, nvtrinhdoid, nvbophanid)
VALUES 
('Nguyen Van An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyen Tat Thanh, Da Nang',1,3,1),
('Le Van Binh','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yen Bai, Da Nang',1,2,2),
('Ho Thi Yen','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Dien Bien Phu, Gia Lai',1,3,2),
('Vo Cong Toan','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoang Dieu, Quang Tri',1,4,4),
('Nguyen Binh Phat','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yen Bai, Da Nang',2,1,1),
('Khuc Nguyen An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyen Tat Thanh, Da Nang',2,2,3),
('Nguyen Huu Ha','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguyen Chi Thanh, Hue',2,3,2),
('Nguyen Ha Dong','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hung Vuong, Ha Noi',2,4,4),
('Tong Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 Ham Nghi, Da Nang',2,4,4),
('Nguyen Cong Dao','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoa Khanh, Dong Nai',2,3,2);

INSERT INTO khach_hang (khhoten, khngaysinh, khgioitinh, khcmnd, khsdt, khemail, khdiachi, khloaikhachid)
VALUES 
('Nguyen Thi Hao','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyen Hoang, Da Nang',5),
('Pham Xuan Dieu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thai Phien, Quang Tri',3),
('Truong Dinh Nghe','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ong Ich Khiem, Vinh',1),
('Duong Van Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Le Loi, Da Nang',1),
('Hoang Tran Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Ly Thai To, Gia Lai',4),
('Ton Nu Moc Chau','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yen The, Da Nang',4),
('Nguyen My Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Le Loi, Ho Chi Minh',1),
('Nguyen Thi Hao','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyen Van Linh, Kon Tum',3),
('Tran Dai Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Ly Thuong Kiet, Quang Ngai',1),
('Nguyen Tam Dac','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngo Quyen, Da Nang',2);

INSERT INTO hop_dong (hdbegindate, hdenddate, hdcoctruoc, hdnhanvienid, hdkhachhangid, hddichvuid)
VALUES 
('2020-12-08','2020-12-08',0,3,1,3),
('2020-07-14','2020-07-21',200000,7,3,1),
('2021-03-15','2021-03-17',50000,3,4,2),
('2021-01-14','2021-01-18',100000,7,5,5),
('2021-07-14','2021-07-15',0,7,2,6),
('2021-06-01','2021-06-03',0,7,7,6),
('2021-09-02','2021-09-05',100000,7,4,4),
('2021-06-17','2021-06-18',150000,3,4,1),
('2020-11-19','2020-11-19',0,3,4,3),
('2021-04-12','2021-04-14',0,10,3,5),
('2021-04-25','2021-04-25',0,2,2,1),
('2021-05-25','2021-05-27',0,7,10,1);

INSERT INTO hop_dong_chi_tiet (soluong, hdcthdid, hdctdvdkid)
VALUES 
(5,2,4),
(8,2,5),
(15,2,6),
(1,3,1),
(11,3,2),
(1,1,3),
(2,1,2),
(2,12,2);

-- Task 20.	Hiên thi thông tin cua tât ca các nhân viên và khách hàng có trong hê thông, 
-- thông tin hiên thi bao gôm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
