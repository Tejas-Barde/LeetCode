/* Write your PL/SQL query statement below */
select department, employee , salary
from (
    select 
        d.name department ,e.name employee, salary , dense_rank() over (partition by departmentid order by salary desc) r
    from employee e join department d
    on e.departmentid = d.id 
)
where r <= 3;