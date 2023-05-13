--230512 수업내용

--부서별 인원
select 
    department_id, count(*) 
from 
    employees
group by
    department_id
order by
    department_id;

-- 모든 사원들의 성을 알파벳 순으로 중복 제외
select DISTINCT last_name
from employees
order by last_name;

-- 2명 이상 존재하는 성을 인원수와 함께 출력;
select last_name, count(*)
from employees
group by last_name
having count(*) > 1
order by last_name;

-- 서브쿼리
-- 사원이름, 부서명 출력, 전체 급여 평균보다 높은 급여를 받는 사원만.
select
    first_name, last_name, 
    (
        select 
            department_name 
        from 
            departments d 
        where
            d.department_id = e.department_id
    ) as department_name,
    salary
from
    employees e
where
    salary >= (select avg(salary) from employees)
;

-- 사원 이름, 그 사원의 매니저 이름
select
    first_name || ' ' || last_name,
    (
        select
            first_name || ' ' || last_name -- 값을 하나만.
        from 
            employees e2 -- 이름을 다르게
        where
            e.manager_id = e2.employee_id
    )
from
    employees e -- 같은 테이블 부를때
;

-- join
select * from employees e, departments d where e.department_id = d.department_id and salary > 13000;

-- 이름 부서명
select first_name, last_name, department_name from employees e, departments d where e.department_id = d.department_id;

-- 도시명과 국가명
select city, country_name from locations l, countries c; -- 단순 곱하기
select city, country_name from locations l, countries c where l.country_id = c.country_id;

-- 테이블 세 개 조인(사원명, 부서명, 도시명)
select
    first_name, last_name, department_name, city
from 
    employees e, departments d, locations l
where
    e.department_id = d.department_id
    and d.location_id = l.location_id
;

select
    city,
    count(*)
from 
    employees e, departments d, locations l
where
    e.department_id = d.department_id
    and d.location_id = l.location_id
group by
    city
;

-- 테이블 4개 이상
select
    country_name, count(*)
from 
    employees e, departments d, locations l, countries c
where
    e.department_id = d.department_id
    and d.location_id = l.location_id
    and l.country_id = c.country_id
group by
    country_name
;

-- 도시별 급여평균, 평균금액이 6000이상, 금액 내림차순으로 출력
select
    city, round(avg(salary), 2) avg
from
    employees e, departments d, locations l
where
    e.department_id = d.department_id
    and d.location_id = l.location_id
group by
    city
having
    round(avg(salary), 2) >= 6000
order by
    avg desc
;

-- 직원 이름과 그 매니저 이름 (조인으로)
select
    e.first_name || ' ' || e.last_name,
    m.first_name || ' ' || m.last_name
from
    employees e, employees m
where
    e.manager_id = m.employee_id(+) -- (+)는 조인 조건이 Null이던 아니던 출력.
    and e.salary > 13000;


