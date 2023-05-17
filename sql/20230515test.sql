-- 20230515 시험

create table lunchbox (
    lunchbox_id VARCHAR2(10) primary key,
    menu_title VARCHAR2(150) not null,
    price number(7) not null
);

-- 5-1 입력
insert into lunchbox values('m01', '스파게티', 10000);
insert into lunchbox values('m02', '소바', 10000);
insert into lunchbox values('m03', '비빔밥', 10000);
insert into lunchbox values('m04', '짜장면', 10000);
insert into lunchbox values('m05', '탕수육', 10000);
insert into lunchbox values('m06', '치킨', 10000);

-- 5-2 조회
select * from lunchbox;

-- 8
select * from lunchbox where menu_title like '%치킨%';

drop table lunchbox;

create table customer (
    cust_id varchar2(10) primary key,
    cust_name varchar2(30) not null,
    address varchar2(100) not null,
    phone varchar2(20) not null
);
insert into customer values('gildong', '홍길동', '서울시 강남구', '010-1111-2222');
insert into customer values('gilsun', '홍길순', '서울시 강남구', '010-1111-2223');
insert into customer values('gilmi', '홍길미', '서울시 강남구', '010-1111-2233');
insert into customer values('miyoung', '길미영', '서울시 용산구', '010-3333-2222');
insert into customer values('chulsu', '김철수', '서울시 강남구', '010-2222-2222');

select * from customer;


create table orderinfo (
    order_id number primary key,
    cust_id varchar2(10),
    lunchbox_id varchar2(10),
    order_count number default 1,
    order_date date default sysdate,
    CONSTRAINT cust_id_fk FOREIGN KEY(cust_id) REFERENCES customer(cust_id),
    CONSTRAINT lunchbox_id_fk FOREIGN KEY(lunchbox_id) REFERENCES lunchbox(lunchbox_id)
);

insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'gildong', 'm01');
insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'gilsun', 'm02');
insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'gildong', 'm03');
insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'gilmi', 'm04');
insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'miyoung', 'm05');
insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'chulsu', 'm01');
insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'gildong', 'm01');
insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'gildong', 'm01');
insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'gildong', 'm01');
insert into orderinfo(order_id, cust_id, lunchbox_id) values(order_seq.nextval, 'gildong', 'm01');

select * from orderinfo;

-- 9
select
    cust_name 고객이름,
    menu_title 도시락이름,
    price 가격,
    order_count 주문수량,
    price * order_count 주문금액,
    order_date 주문일
from
    customer c, orderinfo o, lunchbox l
where
    o.cust_id = c.cust_id and
    o.lunchbox_id = l.lunchbox_id
order by
    o.order_date desc;
    

create SEQUENCE order_seq;


select
    menu_title 도시락이름,
    (
        select
            count(*)
        from
            orderinfo o 
        where
    ) 총판매수량,
    () 총판매금액
from
    orderinfo;

