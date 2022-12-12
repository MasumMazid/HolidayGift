create database HolidayGift;
use HolidayGift;

create table user_login(
user_id INT NOT NULL,
PRIMARY KEY (user_id),
name VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
role VARCHAR(45) NOT NULL
);
create table Gifts(
product_id INT  NOT NULL,
PRIMARY KEY (product_id),
product_name VARCHAR(45) NOT NULL,
product_price int not null
);
create table purchases(
user_id INT ,
product_id INT,
quantity int,
FOREIGN KEY (user_id) references user_login(user_id), 
FOREIGN KEY (product_id) references Gifts(product_id)
);
