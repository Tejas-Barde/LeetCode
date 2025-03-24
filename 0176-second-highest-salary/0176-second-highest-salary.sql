/* Write your PL/SQL query statement below */
WITH highest_salary as (
    SELECT max(salary) as salary FROM employee
)

SELECT max(salary) as SecondHighestSalary
FROM employee
WHERE salary < (select salary from highest_salary);