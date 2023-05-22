--Mybatis 평가문제


--상품 정보 테이블 생성 SQL
create table com_product(
	code varchar2(10) primary key,
	pname varchar2(30) not null,
	price number not null
);

--판매 정보 테이블 생성 SQL
create table com_sales(
	num number primary key,
	inputdate date default sysdate,
	code varchar2(10) not null,
	quantity number not null,
	constraint code_fk foreign key (code) references com_product(code)
);

--판매 정보 일련번호 생성 SQL
create sequence com_sales_seq;

