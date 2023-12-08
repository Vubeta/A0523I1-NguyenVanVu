CREATE DATABASE demo;
USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

delimiter //
create procedure users_list()
begin
select * from users;
end //
delimiter ;

delimiter //
create procedure update_list(new_id  int(3), new_name varchar(120), new_email varchar(220), new_country varchar(120))
begin
	update users
    set `name` = new_name, email = new_email, country = new_country
    where id = new_id;
end //
delimiter ;

delimiter //
create procedure remove_user(idInput int(3))
begin
delete from users where id = idInput;
end //
delimiter ;

select * from users;

call users_list();

call remove_user(3);

call update_list(3,'thienkuto2','thien123','Lao');