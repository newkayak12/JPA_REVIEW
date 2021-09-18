create table MEMBER(
id varchar(255) not null,
name varchar(255),
age Integer not null,
primary key(id)
);


create Table MY_SEQUENCE (
sequence_name varchar(255) not null,
next_val bigint,
primary key(sequence_name)
);