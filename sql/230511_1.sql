--230511 수업내용 

-- 생일이 이달
select name, birth from student where to_char(birth, 'mm') = to_char(sysdate, 'mm');
-- 생일이 10일 이내
select name, birth from student where to_date(to_char(sysdate, 'yyyy') || to_char(birth, 'mmdd'), 'yyyymmdd') between sysdate and sysdate +10 and birth is not null;
-- 생일이 5, 6 10월
select name, birth from student where to_char(birth, 'mm') in (5, 6, 10);
-- 각 학생의 나이
select name, birth, to_number(to_char(sysdate, 'yyyy')) - to_number(to_char(birth, 'yyyy')) age from student where birth is not null;

commit;


-- null 처리함수
select name, birth, java from student;
select name, birth, java + 10 from student; -- 무슨계산을 해도 null은 계산 안됨.
select name, birth, nvl(java, 0) + 10 from student; -- null이면 0으로 지정.
select name, birth, nvl(birth, sysdate) from student;
select name, nvl(address, 'x') from student;
select name, nvl2(address, 'o', 'x') from student; -- 컬럼 ? 'o' : 'x'

-- decode(컬럼,
            -- 조건, 결과 ...
            -- ) as nickname 
            
-- case 컬럼 when 조건 then 쿼리 .... end 
            
-- 다중행함수
select sum(nvl(java, 0)), avg(nvl(java, 0)), min(java), count(java) from student;
-- 행과열이 개수가 맞는것끼리 나열 가능. select name, count(java) 이거 안됨

-- 김씨인 학생수
select count(*) from student where name like '김%';
