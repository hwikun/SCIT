alter table mysite_users add enabled number(1) default 1 check(enabled in (0, 1));
alter table mysite_users add role varchar(20) default 'ROLE_USER' check (role in ('ROLE_USER', 'ROLE_ADMIN'));

select * from mysite_users;

create table spring4_guestbook(
    num number primary key, -- 글번호
	name varchar2(20) not null,
	password varchar2(20) not null,
	message varchar2(1000) not null,
	inputdate date default sysdate
);

create sequence guestbook_seq;

alter table spring4_guestbook modify (password null);

create table spring5_board (
  boardnum number primary key, --글번호 
  memberid varchar2(20) references spring5_member(memberid),--작성자 아이디 
  title varchar(300) not null, --제목 
  contents varchar2(3000) not null, --글내용 
  hits number default 0, --조회수
  inputdate date default sysdate, --작성일 
  orginalfile varchar2(300), --첨부파일 이름
  savedfile varchar2(100)--실제 저장된 파일이름
);
 
alter table spring5_board rename COLUMN orginalfile to originalfile;
 
create sequence spring5_board_seq;
 
commit;
 
select * from spring5_board;
 
update spring5_board set hits = hits+1 where boardnum = 1;

select * from spring5_member;



insert into spring5_board (boardnum, memberid, title, contents) values(spring5_board_seq.nextval, 'test2', 'fkfkf', 'fadfasdfasdf');



-- 댓글
create table spring5_reply (
	replynum 	number 			primary key, -- 댓글번호 
	boardnum 	number 			references spring5_board(boardnum) on delete cascade, -- 본문 글번호;
	memberid 	varchar2(20) 	references spring5_member(memberid), -- 작성자 아이디;
	replytext 	varchar2(1000) 	not null, -- 내용;
	createdat 	date 			default sysdate -- 글쓴 시간;
	-- 
);

-- 댓글시퀀스 
create sequence spring5_reply_seq;

select * from spring5_reply;