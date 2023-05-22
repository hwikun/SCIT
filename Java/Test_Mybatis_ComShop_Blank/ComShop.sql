--Mybatis �򰡹���


--��ǰ ���� ���̺� ���� SQL
create table com_product(
	code varchar2(10) primary key,
	pname varchar2(30) not null,
	price number not null
);

--�Ǹ� ���� ���̺� ���� SQL
create table com_sales(
	num number primary key,
	inputdate date default sysdate,
	code varchar2(10) not null,
	quantity number not null,
	constraint code_fk foreign key (code) references com_product(code)
);

--�Ǹ� ���� �Ϸù�ȣ ���� SQL
create sequence com_sales_seq;

