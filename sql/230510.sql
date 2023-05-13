-- 230510 수업내용 SQL 함수
-- 학생정보테이블
create table student(
--번호, pk, 정수 일련번호
    num number primary key,
--이름, 문자열
    name VARCHAR2(30) not null,
--전화번호, 문자열
    phone VARCHAR2(20),
--주소, 문자열
    address VARCHAR2(100),
--생년월일, 날짜
    birth date,
--과목1, 정수, 기본값 0
    java number(3) DEFAULT 0,
--과목2, 정수, 기본값 0
    db number(3) DEFAULT 0,
--과목3, 정수, 기본값 0
    html number(3) DEFAULT 0
);

-- 시퀀스 생성
create sequence student_seq;

drop table student;
drop SEQUENCE student_seq;

-- 저장
insert into student values(student_seq.nextval, '홍길동', '010-1111-1111', '서울시 강남구 영동대로513', '2023-3-27', 99, 99, 88);
insert into student values(student_seq.nextval, '김길동', '010-1111-1111', '서울시 강남구 영동대로513', '2023-3-27', 99, 99, 88);
insert into student values(student_seq.nextval, '황길동', '010-1111-1111', '서울시 강남구 영동대로513', '2023-3-27', 99, 99, 88);
insert into student values(student_seq.nextval, '박길동', '010-1111-1111', '서울시 강남구 영동대로513', '2023-3-27', 99, 99, 88);
insert into student values(student_seq.nextval, '오길동', '010-1111-1111', '서울시 강남구 영동대로513', '2023-3-27', 99, 99, 88);

insert into student(num, name) values(student_seq.nextval,'김철수');
commit;

update student set java = 100, db = 90, html = 95 where num = 2;

select * from student;

create sequence abc;
drop SEQUENCE abc;

select abc.nextval from dual; -- 1행 1열 테이블 from dual; 간단한 계산시 활용. 일반 테이블은 그 테이블 행만큼 실행됨.
select abc.currval from dual;

select 1 + 1 from dual;

select * from dual;

--이름이 "홍길동"인 학생의 번호, 이름, 전화번호, 주소
select 
    num, name, phone, address 
from 
    student 
where 
    name like '홍길동';
    
-- java, db, html 점수가 모두 60점 이상
select * from student
where
    java >= 60 and db >= 60 and html >= 60;
    
-- 김씨
select * from student where name like '김%';

-- 평균점수 50점 이하
select * from student where (java + db + html) / 3 <= 50;

-- 주소가 삼성동
select * from student where address like '%삼성동%';

-- 전화번호 없는 사람
select * from student where phone is null;

-- 모든 학생의 평균점수와 이름을 출력
select round((java + db + html) / 3, 3) avg, name from student; -- round(float 값, 몇번째자리?(-1은 반올림한자리)

-- 대문자로 변경
select upper('aBcDe') from dual;
select lower('aBcDe') from dual;

--대소문자 구분하지 않고 이름 검색
select * from student where upper(name) like upper('%kim%');

-- 모든 학생의 이름과 이름 글자수
select name, length(name) 이름글자수 from student;
-- 이름 글자수와 byte 수
select length(name), lengthb(name) B from student;

--이름이 두글자인 학생
select * from student where length(name) = 2;
--전화번호 중 앞 3글자 출력
select name, substr(phone, 1, 3) from student; -- substr(컬럼, 시작번호(1부터), 몇개);
--전화번호 앞 3글자가 010인 사람
select * from student where substr(phone, 1, 3) like '010';

select mod(10, 3) from dual; -- 10 % 3

-- 날짜 데이터
select name, birth from student;
-- 날짜 빼기 : 일단위 차이
select name, sysdate - birth from student;
--날짜더하기 : 일단위 추가
select name, birth + 1 from student;
select sysdate + 1 from dual;
-- 생일 기념 7일 쿠폰
select name, add_months(birth, 1) 한달뒤 from student;

-- 날짜 형식지정해서 문자열로 변환
select sysdate from dual;
select to_char(sysdate, 'yyyy.mm.dd hh.mi.ss') from dual;

select to_char(sysdate, 'hh:mi') from dual;
select to_char(sysdate, 'yyyy-mm-dd') from dual;
select name, to_char(birth, 'mm"월"dd"일"') as 생일 from student;

--생일이 11월 인 학생들
select * from student where to_char(birth, 'mm') > '03';

-- 2000년 출생
select * from student where to_char(birth, 'yyyy') = '2000';

-- 각 학생들의 올해 생일을 "2023년 11월 11일" 형식으로 출력
select name, to_char(sysdate, 'yyyy"년"') || to_char(birth, ' mm"월" dd"일"') from student where birth is not null;

-- 2022년 5월 30일 기준으로 태어난지 며칠?
select name, to_date('20220530', 'yyyy-mm-dd') - birth as dday from student;

