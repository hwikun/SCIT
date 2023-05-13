-- hr 계정 데이터

-- 전체 직원
select * from employees;

-- 이름에 "ne" 포함 직원
select * from employees where upper(first_name) like upper('%ne%') or upper(last_name) like ('%ne%');
--이름의 첫자 성의 첫자 출력
select substr(first_name, 1, 1) || ',' || substr(last_name, 1, 1) as name from employees;
-- 전화번호 뒷자리 4자 출력
select substr(phone_number, 9, 4) as digit from employees;
-- 급여 역순
select * from employees order by salary desc;
-- 2005년 입사자
select * from employees where to_char(hire_date, 'yyyy') like '2005';
-- 급여총액 (급여 + 급여의 일정비율)
select first_name, last_name, salary + (salary * nvl(commission_pct, 0)) as salary_sum from employees;
-- 전체 직원 급여 평균
select round(avg(salary), 2) salary_avg from employees;
-- 80번 부서의 급여 평균
select round(avg(salary), 1) salary_avg from employees where department_id = 80;

-- group by
--부서별 급여 평균
select department_id, round(avg(salary), 1) salary_avg from employees group by department_id;

select 
    department_id, round(avg(salary), 1) salary_avg --4
from 
    employees --1
where 
    department_id is not null --2
group by 
    department_id --3
order by
    department_id; --5
    
-- 급여가 3000 이상인 사원들의 부서별 급여평균
select
    department_id, round(avg(salary), 1) salary_avg
from
    employees
where
    department_id is not null
    and salary >= 3000
group by
    department_id
order by
    department_id;
    
    
-- HAVING
-- 평균이 5000이상인 부서들의 부서별 급여평균을 평균값 역순으로 출력
select
    department_id, round(avg(salary), 1) salary_avg -- 5
from
    employees --1
where
    department_id is not null
    and salary >= 3000 --2
group by
    department_id --3
having 
    round(avg(salary), 1) >= 5000 -- 4
order by
    salary_avg desc; -- 6
    
-- job_id가 IT_PROG, SA_MAN, FI_ACCOUNT, ST_MAN 인 사원들을 대상으로 입사년도별 급여평균을 입사년도순으로 출력
-- 단 급여 평균이 5000~10000인 경우만 출력
select
    to_char(hire_date, 'yyyy') year, round(avg(salary), 1) salary_avg
from 
    employees
where
    job_id in ('IT_PROG', 'SA_MAN', 'FI_ACCOUNT', 'ST_MAN')
group by
    to_char(hire_date, 'yyyy')
having
    round(avg(salary), 1) between 5000 and 10000
order by
    year;
    
-- 급여가 7000 이상인 사원이 부서별 몇명?
select
    department_id, count(*)
from
    employees
where
    salary >= 7000
group by
    department_id
order by
    department_id;
    
-- 서브쿼리
    
-- 전체 급여 평균보다 많은 급여를 받는 사원
select * -- 서브 쿼리 가능
from employees -- 서브쿼리 가능
where
    salary >= (select avg(salary) from employees);

-- 사원이름 부서명 출력
select
    first_name,
    (
        select department_name 
        from departments d
        where e.department_id = d.department_id
    ) as department_name
from
    employees e;