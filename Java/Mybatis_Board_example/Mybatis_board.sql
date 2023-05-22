--게시판 예제

--회원정보 테이블
create table member (
	id 			varchar2(20) primary key, 
	password 	varchar2(30 byte) not null, 
	name 		varchar2(30) not null
);
--게시글 테이블
create table board (
	num 		number(11) primary key, 
	id 			varchar2(30), 
	title 		varchar2(300) not null, 
	contents 	varchar2(3000) not null, 
	inputdate 	date default sysdate, 
	constraint board_id_fk foreign key (id) references member(id) on delete cascade
);
--글번호 시퀀스
create sequence board_seq;

--저장 예
insert into member values ('aaa','111','홍길동');

insert into board (num, id, title, contents) values (board_seq.nextval, 'aaa','제목','내용');

