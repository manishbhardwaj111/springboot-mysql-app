SELECT e.id, e.name, e.department_id as dept_id, d.name as dept_name , e.salary as max_salary from employee e left join department d 
ON e.department_id = d.id 
where salary = (SELECT max(salary) from employee e2 where e2.department_id = e.department_id) ;


SELECT e.*
FROM employee e
WHERE e.salary = (
    SELECT MAX(salary)
    FROM employee
    WHERE department_id = e.department_id
);

SELECT *
FROM (
    SELECT e.*, ROW_NUMBER() OVER (PARTITION BY department_id ORDER BY salary DESC) AS row_num
    FROM employee e
) ranked
WHERE row_num = 1;








