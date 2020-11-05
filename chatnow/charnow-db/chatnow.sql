drop schema if exists chatnow;
create schema chatnow;
use chatnow;

create table account(
	id bigint not null auto_increment,
    username varchar(100) not null,
    password varchar(100) not null,
    name varchar(100) not null,
    status bit not null default 1,
    
    primary key(id),
    unique(username)
);

create table role(
	id bigint not null auto_increment,
    name varchar(100) not null,
    status bit not null default 1,
    
	primary key(id),
    unique(name)
);

create table permission(
	id bigint not null auto_increment,
    account_id bigint not null,
    role_id bigint not null,
    
    primary key(id),
    unique(account_id, role_id),
    foreign key(account_id) references account(id),
    foreign key(role_id) references role(id)
);

insert into role(name) values
	('admin'),
    ('user');
    
insert into account(username, password, name) values
	('admin', '1', 'Dao Minh Trung Thuan'),
    ('user1', '1', 'Nguyen Van An'),
    ('user2', '1', 'Tran Van Binh');
    
insert into permission(account_id, role_id) values
	(1, 1),
    (1, 2),
    (2, 2),
    (3, 2);