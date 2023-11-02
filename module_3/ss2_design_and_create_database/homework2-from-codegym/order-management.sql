create database quanlybanhang;
use quanlybanhang;
create table customer(
cid int primary key auto_increment,
cname varchar(255),
cage int
);
create table `order`(
oid int primary key auto_increment,
cid int,
odate date,
ototalprice int,
foreign key (cid) references customer(cid)
);
create table `product`(
pid int primary key auto_increment,
pname varchar(255),
pprice int
);
create table `orderdetail`(
oid int,
pid int,
odqty int,
primary key (oid,pid),
foreign key (oid) references `order`(oid),
foreign key (pid) references product(pid)
);