--개인 정보 테이블
create table person (
	num		number		primary key,		--일련번호
	name	varchar2(20) not null,			--이름
	age		number(3)						--나이
);

--개인 정보 테이블의 일련번호에 사용할 시퀀스
create sequence person_seq;

--입력 예
insert into person (num, name, age) values (person_seq.nextval, '홍길동', 20);
commit;
