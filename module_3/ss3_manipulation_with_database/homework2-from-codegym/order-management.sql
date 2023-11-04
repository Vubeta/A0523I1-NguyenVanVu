create database quanlybanhang;
use quanlybanhang;
create table customer(
cid int primary key,
cname varchar(25),
cage tinyint
);
create table `order`(
oid int primary key,
cid int,
odate datetime,
ototalprice int,
foreign key (cid) references customer(cid)
);
create table `product`(
pid int primary key,
pname varchar(25),
pprice int
);
create table `orderdetail`(
oid int,
pid int,
odqty int,
foreign key (oid) references `order`(oid),
foreign key (pid) references product(pid)
);

insert into customer values (1,'Minh Quan',10), (2,'Ngoc Oanh',20), (3,'Hong Ha',50);
insert into `order` values (1,1,'2006-03-21',null), (2,2,'2006-03-23',null), (3,1,'2006-03-16',null);
insert into product values (1,'May Giat',3), (2,'Tu Lanh',5), (3,'Dieu Hoa',7), (4,'Quat',1), (5,'Bep Dien',2);
insert into orderdetail values (1,1,3), (1,3,7), (1,4,2), (2,1,1), (3,1,8), (2,5,4), (2,3,3);

-- Ex1. Hien thi các thông tin gom oID, oDate, oPrice cua tat ca các hóa đon trong bang Order
select oid, odate, ototalprice from `order`;

-- Ex2. Hien thi danh sách các khách hàng đã mua hàng, và danh sách san pham đuoc mua boi các khách hàng
select co.cid, co.customer_name, co.oid, po.pid, po.pname, po.pprice, po.odqty 
from (select cid, c.cname as customer_name, oid from `order` join customer c using (cid)) as co 
join (select oid, pid, odqty, p.pname, p.pprice from orderdetail join product p using (pid)) as po using(oid);
-- step1: join customer with order (co)
-- select cid, c.cname as customer_name, oid from `order` join customer c using (cid);
-- step 2: join product with orderdetail (po):
-- select oid, pid, odqty, p.pname, p.pprice from orderdetail join product p using (pid);

-- Ex3. Hien thi tên nhung khách hàng không mua bat kỳ mot san pham nào
select cid, cname from customer where cid not in (select cid from `order`);

-- Ex4. Hien thi mã hóa đon, ngày bán và giá tien cua tung hóa đon
-- (giá mot hóa đon đuoc tính bang tung giá bán cua tung loai mat hàng xuat hien trong hóa đon. Giá bán cua tung loai đuoc tính = odQTY*pPrice)
select oid, odate, op.odqty*op.pprice as total_price from `order` join (select oid, pid, odqty, p.pname, p.pprice from orderdetail join product p using (pid)) as op using (oid);
-- list include orderdetail and product
-- select oid, pid, odqty, p.pname, p.pprice from orderdetail join product p using (pid);