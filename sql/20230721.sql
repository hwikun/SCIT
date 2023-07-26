--ajax 예제의 테이블

--추천 기능
create table web_recommend (
	boardnum 	number	primary key,
	cnt			number default 0
);

insert into web_recommend (boardnum) values (1);
update web_recommend set cnt = cnt + 1 where boardnum = 1;

--ID 중복검사 기능
create table web_member (
	memberid	varchar2(20) primary key,
	name		varchar2(20) not null
);

insert into web_member values ('abc', '홍길동');
select * from web_member where memberid = 'abc';
select * from web_member;
select count(*) from web_member where memberid = 'abc';


--댓글 기능
-- Ajax Test용 테이블
create table web_comment (
	num		number primary key,
	name	varchar2(20) not null,
	text	varchar2(200) not null
);

create sequence web_comment_seq;

insert into web_comment values (web_comment_seq.nextval, '홍길동', '댓글내용입니다.');

commit;