-- 회원정보 테이블

-- 테이블 생성
CREATE TABLE person (
    num NUMBER(10) PRIMARY KEY, --회원번호(숫자, 10자리, PK)
    name VARCHAR2(30) NOT NULL, --이름 (문자열, 10자)
    phone VARCHAR2(20) UNIQUE, --전화번호 (문자열, 20자리)
    age NUMBER(3), --나이(숫자 3자리)
    height NUMBER(4, 1) --키(숫자, 4자리, 소수점 1자리포함)
);

-- 저장
INSERT INTO person VALUES (1, '홍길동', '010-1111-1111', 22, 166.5);
INSERT INTO person (num, name) VALUES (2, '김철수');
--INSERT INTO person (num) VALUES(3); NOT NULL 에러
INSERT INTO person VALUES(3, '김길동', '010-2222-3333', 33, 177.7);
INSERT INTO person VALUES(4, '김길동', '010-2222-3334', 33, 177.7);
INSERT INTO person VALUES(5, '김길동', '010-2222-3335', 23, 177.7);
INSERT INTO person VALUES(6, '김길동', '010-2222-3336', 27, 177.7);
INSERT INTO person VALUES(7, '김길동', '010-2222-3337', 30, 177.7);


-- 수정
UPDATE person SET age = 20, height = 155 WHERE num = 1;

-- 삭제
DELETE FROM person WHERE num = 2;

-- 테이블 삭제
DROP TABLE person;

-- 데이터 조회
SELECT * FROM person; -- 전체조회
SELECT phone FROM person WHERE name = '홍길동';
SELECT num, name, age FROM person; -- projection 열 단위 조회
SELECT * FROM person WHERE num = 1; -- selection 행 단위 조회
SELECT DISTINCT name FROM person; -- 중복제거 DISTINCT
SELECT name abc FROM person; -- 별칭 설정 _(공백)별칭
SELECT name, age+1 FROM person; -- age에 1더해서 'age+1' 컬럼명 출력
SELECT name, age+1 age FROM person; -- age에 1더해서 'age' 별칭으로 출력
SELECT name AS "이름", age "나이" FROM person; -- 한글 출력시 쌍따옴표 권장
-- AS 써도 되고 안써도 됨.

-- 정렬
SELECT * FROM person ORDER BY num; -- num을 기준으로 오름차순으로 조회
SELECT * FROM person ORDER BY num DESC; -- num을 기준으로 내림차순으로 조회
SELECT * FROM person ORDER BY name DESC, num DESC; 
-- name을 기준으로 내림차순 조회, 만약 같은 나이면 num을 기준으로 오름차순으로 조회

-- 연산자 연습

-- 번호가 1번인 회원
select * from person where num = 1; 

-- 나이가 25세 이상인 회원
select * from person where age >= 25; 
select * from person where age >= 25 and age <= 30;

-- 나이가 25~30 인 회원
select * from person where age BETWEEN 25 and 30; 

-- 나이가 23세이거나 27세, 33세인 회원
select * from person where age = 23 or age = 27 or age = 30; 
select * from person where age in (23, 27, 30); 

-- null 연산자 is
select * from person where age is null; -- null 인 행
select * from person where age is not null; -- null이 아닌행

-- 이름이 홍길동인 회원
select * from person where name = '홍길동';
select * from person where name like '홍길동';

-- wildcard 연산자 like
select * from person where name like '홍%'; -- 홍 씨인 회원
select * from person where name like '%길%'; -- 길 을 포함하는 회원
select * from person where name like '%길동'; -- 길동으로 끝나는 회원
select * from person where name like '홍_'; -- 홍 뒤에 한글자, _ 하나당 한글자

-- TCL;
commit; -- 입력 완료. 변경 사항 저장. TCL. 트랜젝션의 시작
select * from person order by num;
delete from person where num = 3;
commit; -- 변경 사항 저장. 3번 없어진거 반영됨.
delete from person where num = 2;
rollback; -- 마지막 commit 까지 돌려놓기. 그 이전은 안됨.


-- employees table 연습
select * from EMPLOYEES;
-- first name 이 A로 시작
select * from EMPLOYEES where FIRST_NAME like 'A%';
-- 전화번호에 "123"이 포함된 사람
select * from EMPLOYEES where PHONE_NUMBER like '%123%';
-- 부서번호가 30, 50, 60중 하나
select * from EMPLOYEES where DEPARTMENT_ID in(30, 50, 60) order by DEPARTMENT_ID;
-- salary 가 5000~10000인 사람
select * from EMPLOYEES where SALARY BETWEEN 5000 and 10000 order by SALARY;
-- 이 회사의 부서번호를 순서대로 출력
select DISTINCT DEPARTMENT_ID from EMPLOYEES order by DEPARTMENT_ID;
-- 문자열 연결
select FIRST_NAME || ' ' || LAST_NAME name from EMPLOYEES;




