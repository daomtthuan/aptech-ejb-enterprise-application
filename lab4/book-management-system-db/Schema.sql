drop schema if exists book_management_system;
create schema book_management_system;
use book_management_system;

create table user
(
  id       int          not null auto_increment,
  username varchar(100) not null,
  password varchar(100) not null,

  primary key (id),
  unique (username)
);

