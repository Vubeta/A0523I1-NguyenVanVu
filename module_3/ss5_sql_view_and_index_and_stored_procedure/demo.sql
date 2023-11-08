create database demo;
use demo;
create table Products(
Id int primary key auto_increment,
productCode int,
productName varchar(255),
productPrice int,
productAmount int,
productDescription varchar(255),
productStatus bit
);

insert into Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
values
	(1, 'Product 01', 100, 10, 'Product 1', b'1'),
    (2, 'Product 02', 200, 5, 'Product 2', b'0'),
    (3, 'Product 03', 150, 15, 'Product 3', b'1');
    -- b'1' is true (1) and b'0' is false (0)
select * from products;
-- Tao Unique Index trên bang Products (su dung cot productCode đe tao chi muc)
create unique index idx_productCode on Products (productCode);

-- Tao Composite Index trên bang Products (su dung 2 cot productName và productPrice)
create index idx_productName_productPrice on Products (productName, productPrice);

-- Su dung câu lenh EXPLAIN đe biet đuoc câu lenh SQL cua ban thuc thi nhu nào
explain select * from Products where productCode = 2;
explain select * from Products where productName like 'Product 0%' and productPrice > 150;

-- So sánh câu truy van truoc và sau khi tao index

-- Tao view lay ve các thông tin: productCode, productName, productPrice, productStatus tu bang products.
create view user_view as
select productCode, productName, productPrice, productStatus
from Products;
select * from user_view;

-- Tiên hành xoá view
drop view user_view;

-- Tao store procedure lay tat ca thông tin cua tât ca các san phâm trong bang product
delimiter //
create procedure test_procedure()
begin
select * from Products;
end //
delimiter ;
call test_procedure;

-- Tao store procedure thêm mot san pham moi
delimiter //
create procedure test_procedure1(in pC int, in pN varchar(255), in pP int, in pA int, in pD varchar(255), in pS bit)
begin
insert into Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
values (pC, pN, pP, pA, pD, pS);
end //
delimiter ;
call test_procedure1(4, 'Product 04', 500, 15, 'Product 4', b'0');
call test_procedure;

-- Tao store procedure sua thông tin san pham theo id
delimiter //
create procedure test_procedure2(in pID int, in pC int, in pN varchar(255), in pP int, in pA int, in pD varchar(255), in pS bit)
begin
update Products
set productCode = pC, productName = pN, productPrice = pP, productAmount = pA, productDescription = pD, productStatus = pS
where Id = pID;
end //
delimiter ;
call test_procedure2 (2, 5, 'Product 05', 600, 25, 'Product 5', b'1');
call test_procedure;

-- Tao store procedure xoá san pham theo id
delimiter //
create procedure test_procedure3(in pID int)
begin
delete from Products
where Id = pID;
end //
delimiter ;
call test_procedure3(3);
call test_procedure;