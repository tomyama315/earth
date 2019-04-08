
drop database if exists earth;

create database if not exists earth;
use earth;

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
regist_date datetime not null,
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
regist_date datetime not null,
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
regist_date datetime not null,
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
regist_date datetime not null,
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
regist_date datetime not null,
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

insert into user_info values
(1,"guest","guest","インターノウス","ゲストユーザー","いんたーのうす","げすとゆーざー",0,"guest@gmail.com",0,0,now(),now()),
(2,"guest2","guest2","インターノウス","ゲストユーザー2","いんたーのうす","げすとゆーざー2",0,"guest2@gmail.com",0,0,now(),now()),
(3,"guest3","guest3","インターノウス","ゲストユーザー3","いんたーのうす","げすとゆーざー3",0,"guest3@gmail.com",0,0,now(),now()),
(4,"guest4","guest4","インターノウス","ゲストユーザー4","いんたーのうす","げすとゆーざー4",0,"guest4@gmail.com",0,0,now(),now()),
(5,"guest5","guest5","インターノウス","ゲストユーザー5","いんたーのうす","げすとゆーざー5",0,"guest5@gmail.com",0,0,now(),now()),
(6,"guest6","guest6","インターノウス","ゲストユーザー6","いんたーのうす","げすとゆーざー6",0,"guest6@gmail.com",0,0,now(),now()),
(7,"guest7","guest7","インターノウス","ゲストユーザー7","いんたーのうす","げすとゆーざー7",0,"guest7@gmail.com",0,0,now(),now()),
(8,"guest8","guest8","インターノウス","ゲストユーザー8","いんたーのうす","げすとゆーざー8",0,"guest8@gmail.com",0,0,now(),now()),
(9,"guest9","guest9","インターノウス","ゲストユーザー9","いんたーのうす","げすとゆーざー9",0,"guest9@gmail.com",0,0,now(),now()),
(10,"guest10","guest10","インターノウス","ゲストユーザー10","いんたーのうす","げすとゆーざー10",0,"guest10@gmail.com",0,0,now(),now()),
(11,"guest11","guest11","インターノウス","ゲストユーザー11","いんたーのうす","げすとゆーざー11",0,"guest11@gmail.com",0,0,now(),now()),
(12,"guest12","guest12","インターノウス","ゲストユーザー12","いんたーのうす","げすとゆーざー12",0,"guest12@gmail.com",0,0,now(),now());

insert into m_category values
(1,1,"全てのカテゴリー","和菓子、ケーキ、駄菓子、クッキー全てのカテゴリーが対象となります",now(), null),
(2,2,"和菓子","和菓子に関するカテゴリーが対象となります",now(),now()),
(3,3,"ケーキ","ケーキに関するカテゴリーが対象となります",now(),now()),
(4,4,"駄菓子","駄菓子に関するカテゴリーが対象となります",now(),now()),
(5,5,"クッキー","クッキーに関するカテゴリーが対象となります",now(),now());

insert into product_info values
( 1, 1,"チョコチップクッキー","ちょこちっぷくっきー","チョコチップクッキーの商品詳細",5,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 2, 2,"羊羹","ようかん","羊羹の商品詳細",2,200,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 3, 3,"ショートケーキ","しょーとけーき","ショートケーキの商品詳細",3,300,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 4, 4,"うまい棒","うまいぼう","うまい棒の商品詳細",4,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 5, 5,"中嶋祐介","なかじまゆうすけ","中嶋祐介の商品詳細",5,200,"./images","sample.jpg",now(),"発売会社",0,now(),now());

insert into cart_info values
(1,1,1,1,3,100,now(),now()),
(2,1,1,2,2,200,now(),now()),
(3,1,1,3,5,300,now(),now()),
(4,2,2,4,4,100,now(),now()),
(5,1,2,5,12,200,now(),now());