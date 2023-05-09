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

-- 수정
UPDATE person SET age = 20, height = 155 WHERE num = 1;

-- 삭제
DELETE FROM person WHERE num = 2;

-- 테이블 삭제
DROP TABLE person;

-- 데이터 조회
SELECT * FROM person; -- 전체조회
