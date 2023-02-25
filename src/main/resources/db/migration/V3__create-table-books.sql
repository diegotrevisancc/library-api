create table books(
    id bigint not null auto_increment,
    title varchar(100) not null,
    author varchar(100) not null,
    genre varchar(100) not null,
    length varchar(100) not null,

    primary key(id)
);