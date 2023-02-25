create table readers(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    telephone_number varchar(100) not null,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    number varchar(20) not null,
    state char(2) not null,
    city varchar(100) not null,

    primary key(id)
);