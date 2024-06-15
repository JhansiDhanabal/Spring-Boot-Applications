use employee_directory;

drop table if exists users;
create table users(
	`username` varchar(45) not null,
    `password` varchar(45) not null,
    `enabled`  tinyint not null,
    primary key(`username`)
) Engine = InnoDB default charset=latin1;

insert into users values
	("john", "{noop}test123", 1),
    ("mary", "{noop}test123", 1),
    ("susan", "{noop}test123", 1);
drop table if exists authorities;
create table authorities(
	`username` varchar(50) not null,
    `authority` varchar(50) not null
) Engine = InnoDB default charset=latin1;

insert into authorities values
("john", 'ROLE_EMPLOYEE'),
("mary", 'ROLE_EMPLOYEE'),
("mary", 'ROLE_MANAGER'),
("susan", 'ROLE_EMPLOYEE'),
("susan", 'ROLE_MANAGER'),
("susan", 'ROLE_ADMIN');



use jhansi;

create table employee_members(
	`username` varchar(45) not null,
    `password` varchar(120) not null,
    `enabled`  tinyint not null,
    primary key(`username`)
) Engine = InnoDB default charset=latin1;

insert into employee_members values
	("john", "{noop}test@123", 1),
    ("mary", "{noop}test@123", 1),
    ("susan", "{noop}test@123", 1);

create table employee_roles(
	`username` varchar(50) not null,
    `authority` varchar(50) not null
) Engine = InnoDB default charset=latin1;

insert into employee_roles values
("john", 'ROLE_EMPLOYEE'),
("mary", 'ROLE_EMPLOYEE'),
("mary", 'ROLE_MANAGER'),
("susan", 'ROLE_EMPLOYEE'),
("susan", 'ROLE_MANAGER'),
("susan", 'ROLE_ADMIN');


