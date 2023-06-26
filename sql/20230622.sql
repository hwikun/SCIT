
create table spring5_member (
    memberid varchar2(20)   primary key,
    memberpw varchar2(100)  not null,
    membername varchar2(30) not null,
    email varchar2(50),
    phone varchar2(30),
    address varchar2(200),
    enabled number(1) default 1 check (enabled in (0, 1)),
    rolename varchar2(20) default 'ROLE_USER' check (rolename in ('ROLE_USER', 'ROLE_ADMIN'))
);

insert into spring5_member (memberid, memberpw, membername, email, phone, address)
values ('aaa', '123', '홍길동', 'aaa@aaa.com', '010-1111-1111', '서울시 강남구 삼성동');

select * from spring5_member;