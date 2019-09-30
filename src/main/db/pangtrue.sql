create user 'pangtrue'@'localhost' identified by 'pangtrue1234';
create user 'pangtrue'@'%' identified by 'pangtrue1234';

create database pangtrue default character set utf8;

grant all privileges on pangtrue.* to 'pangtrue'@'localhost' identified by 'pangtrue1234';
grant all privileges on pangtrue.* to 'pangtrue'@'%' identified by 'pangtrue1234';

create table member (
    idx int primary key auto_increment,
    name varchar(32) not null,
    email varchar(32) not null,
    password varchar(32) not null
) engine=innodb;