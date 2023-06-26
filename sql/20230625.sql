create table mysite_users (
    usersq number primary key,
    username VARCHAR2(20) unique,
    password VARCHAR2(100) not null,
    email varchar2(100) unique,
    phone varchar2(30) unique,
    address varchar2(200) not null,
    createdAt date default sysdate
);

create SEQUENCE users_seq;

select * from mysite_users;