
drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists user_info;
create table user_info(
id int not null primary key auto_increment,
user_id varchar(16) not null unique,
password varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
sex tinyint not null Default 0,
email varchar(32) not null,
status tinyint not null Default 0,
logined tinyint not null default 0,
resist_date datetime not null,
update_date datetime
);

drop table if exists product_info;
create table product_info(
id int not null primary key auto_increment,
product_id int not null unique,
product_name varchar(100) not null unique,
product_name_kana varchar(100) not null unique,
product_description varchar(255) not null,
category_id int not null,
price int,
image_file_path varchar(100),
image_file_name varchar(50),
release_date datetime not null,
release_company varchar(50),
status tinyint default 0 not null,
resist_date datetime not null,
update_date datetime
);

drop table if exists cart_info;
create table cart_info(
id int primary key not null auto_increment,
user_id varchar(16) not null,
temp_user_id varchar(16),
product_id int not null,
product_count int not null,
price int not null,
resist_date datetime not null,
update_date datetime
);

drop table if exists purchase_history_info;
create table purchase_history_info(
id int primary key not null auto_increment,
user_id varchar(16) not null,
product_id int,
product_count int not null,
price int not null,
destination_id int not null,
resist_date datetime not null,
update_date datetime
);

drop table if exists destination_info;
create table destination_info(
id int primary key not null auto_increment,
user_id varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
email varchar(32) not null,
tel_number varchar(13) not null,
user_address varchar(50) not null,
resist_date datetime not null,
update_date datetime
);


drop table if exists m_category;
create table m_category(
id int primary key not null auto_increment,
category_id int not null unique,
category_name varchar(20) not null unique,
category_description varchar(100),
insert_date datetime not null,
update_date datetime
);

