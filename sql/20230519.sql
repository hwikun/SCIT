create table member1 (
    id varchar2(20) primary key,
    password varchar2(30 byte) not null,
    name varchar2(30) not null
);
create table posts (
    num number(11) primary key,
    id varchar2(20),
    title varchar2(300),
    contents varchar2(3000),
    inputdate date default sysdate,
    constraint board_id_fk foreign key (id) references member1 (id) on delete cascade
);
drop table posts;


-- 글번호 시퀀스
create sequence posts_seq;

insert into member1 values('aaa', '111', '홍길동');
insert into member1 values('bbb', '222', '김철수');
insert into member1 values('ccc', '333', '이영희');


select * from posts;

select
	num,
	name,
	title,
	to_char(inputdate, 'yy/mm/dd') inputdate
from 
	posts p, member1 m
where
	p.id = m.id
order by
	num desc;
    
select
	num,
	title,
	contents,
	name,
	to_char(inputdate, 'yy/mm/dd') inputdate
from
	posts p, member1 m
where
	p.id = m.id
	and num = 1;
    
select
	num,
	title,
	name,
	to_char(inputdate, 'yy/mm/dd') inputdate
from
	posts p, member1 m
where
	title like '%'|| '코딩' || '%' 
	or contents like '%'|| '코딩' || '%'
    and p.id = m.id
order by
	num desc;
    
DELETE FROM table WHERE 