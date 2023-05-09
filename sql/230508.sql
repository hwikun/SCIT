-- 테이블 생성(학생정보 - 학번, 이름, 점수)
CREATE TABLE student (
    idnum varchar2(20),
    name varchar2(30),
    score number(3)
);

INSERT INTO student (idnum, name, score) values ('1111', '홍길동', 100);

SELECT * from student;

DROP TABLE student;