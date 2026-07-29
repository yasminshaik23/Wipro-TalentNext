DESC DEPARTMENTS;

SELECT * FROM DEPARTMENTS;

SELECT employee_id,
       last_name,
       job_id,
       hire_date AS STARTDATE
FROM employees;

SELECT DISTINCT job_id
FROM employees;

SELECT employee_id AS "Emp #",
       last_name AS Employee,
       job_id AS Job,
       hire_date AS "Hire Date"
FROM employees;