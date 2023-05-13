--게시판

-- 회원 테이블
-- id(pk) pw name
create table member(
    id VARCHAR2(20) primary key,
    password VARCHAR2(30) not null,
    name VARCHAR2(30) not null
);
insert into member values('aaa', '111', '홍길동');
insert into member values('bbb', '111', '김길동');
insert into member values('ccc', '111', '김철수');


-- 게시글 테이블
-- post_id(pk)아마도 시퀀스 title author_id(fk) contents comment_id
create table posts(
    post_id number(11) primary key,
    author_id VARCHAR2(20),
    title VARCHAR2(300),
    contents VARCHAR2(3000),
    createdat date default sysdate, -- 자동으로 입력 시 현재시간 입력
    CONSTRAINT post_id_fk FOREIGN key(author_id) REFERENCES member(id) on delete CASCADE -- 제약조건
);
drop table posts;
create SEQUENCE post_id_seq;
insert into posts (post_id, author_id, title, contents) values(post_id_seq.nextval, 'aaa', '제목', '글내용');
insert into posts (post_id, author_id, title, contents) values(post_id_seq.nextval, 'bbb', '제목', '글내용');
insert into posts (post_id, author_id, title, contents) values(post_id_seq.nextval, 'bbb', 'java로 프로그래', '글내용');
insert into posts (post_id, author_id, title, contents) values(post_id_seq.nextval, 'bbb', '제목', 'java 재미없');

commit;

-- 글 조회
select * from member;
select * from member where id = 'aaa';
select * from posts order by post_id desc;
select * from posts where post_id = 1;
-- 글번호 작성자 작성일을 번호 역순으로 출력
select post_id, author_id, createdat from posts order by post_id desc;

-- 글 삭제
DELETE FROM posts WHERE post_id = 1;

-- 회원 삭제
delete from member where id like 'aaa';
delete from member where id like 'bbb';

-- 글 번호 작성자 이름 제목
select 
    post_id num, id name, title
from
    member m, posts p
where
    m.id = p.author_id
;

-- 회원 별 글 작성 개수를 출력(아이디 글 개수)
select
    id name, count(*)
from
    member m, posts p
where
    m.id = p.author_id
group by
    id
;
-- 글 제목이나 내용에 'java'가 포함된 글
select *
from posts
where
    title like '%java%' or
    contents like '%java%'
;

-- 회원별 글 개수를 모든 회원 이름과 개수로 출력;
select
    id, count(*)
from
    member m, posts p
where
    m.id = p.author_id(+)
group by
    id
;

-- 댓글 테이블
-- comment_id(pk)아마도 시퀀스 post_id(fk) author_id(fk) comment
create table comments(
    comment_id number(12) primary key,
    author_id VARCHAR2(20),
    post_id number(11),
    comments VARCHAR2(300),
    createdat date default sysdate,
    CONSTRAINT author_id_fk FOREIGN KEY(author_id) REFERENCES member(id) on delete CASCADE, 
    CONSTRAINT post_commnet_id_fk FOREIGN KEY(post_id) REFERENCES posts(post_id) on delete CASCADE
);

create SEQUENCE comment_id_seq;

insert into comments (comment_id, author_id, post_id, comments) values(comment_id_seq.nextval, 'aaa', 15, '댓글');



