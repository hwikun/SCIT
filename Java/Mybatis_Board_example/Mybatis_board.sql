--�Խ��� ����

--ȸ������ ���̺�
create table member (
	id 			varchar2(20) primary key, 
	password 	varchar2(30 byte) not null, 
	name 		varchar2(30) not null
);
--�Խñ� ���̺�
create table board (
	num 		number(11) primary key, 
	id 			varchar2(30), 
	title 		varchar2(300) not null, 
	contents 	varchar2(3000) not null, 
	inputdate 	date default sysdate, 
	constraint board_id_fk foreign key (id) references member(id) on delete cascade
);
--�۹�ȣ ������
create sequence board_seq;

--���� ��
insert into member values ('aaa','111','ȫ�浿');

insert into board (num, id, title, contents) values (board_seq.nextval, 'aaa','����','����');

