SELECT
*
FROM EMPLOYEES;

ALTER TABLE EMPLOYEES
ADD MANAGER_ID NUMBER(6);

UPDATE EMPLOYEES SET MANAGER_ID = NULL WHERE EMPLOYEE_ID = 100;

UPDATE EMPLOYEES SET MANAGER_ID = 100 WHERE EMPLOYEE_ID IN (101,102);

UPDATE EMPLOYEES SET MANAGER_ID = 102 WHERE EMPLOYEE_ID IN (103,104,107);

UPDATE EMPLOYEES SET MANAGER_ID = 124 WHERE EMPLOYEE_ID IN (141,142,143,144);

UPDATE EMPLOYEES SET MANAGER_ID = 149 WHERE EMPLOYEE_ID IN (174,176,178);

UPDATE EMPLOYEES SET MANAGER_ID = 101 WHERE EMPLOYEE_ID IN (200,201,202,205,206);

COMMIT;

SELECT 
*
FROM EMPLOYEES;

SELECT
last_name, salary
FROM EMPLOYEES
WHERE SALARY > 12000;


SELECT
last_name, department_id
FROM EMPLOYEES
WHERE employee_id = 176;

SELECT
last_name, salary
FROM EMPLOYEES
WHERE salary NOT BETWEEN 5000 AND 12000;

SELECT
last_name, job_id, hire_date
FROM EMPLOYEES
WHERE last_name IN ('Matos', 'Taylor')
ORDER BY hire_date;


SELECT
last_name, department_id
FROM EMPLOYEES
WHERE department_id IN (20,50)
ORDER BY last_name;


SELECT
last_name AS Employee, salary AS "Monthly Salary"
FROM EMPLOYEES
WHERE salary BETWEEN 5000 AND 12000
      AND department_id IN (20,50);
    
    
SELECT 
last_name, hire_date
FROM EMPLOYEES
WHERE EXTRACT(YEAR FROM hire_date) = 1994;


SELECT
last_name, job_id
FROM EMPLOYEES
WHERE manager_id IS NULL;


SELECT
last_name, salary, commission_pct
FROM EMPLOYEES
WHERE commission_pct IS NOT NULL
ORDER BY 2 DESC, 3 DESC;


SELECT 
last_name, salary
FROM EMPLOYEES
WHERE salary > &Salary_value;


SELECT
employee_id, first_name, salary, department_id
FROM EMPLOYEES
WHERE manager_id = &manager_id
ORDER BY &sorted_by;


SELECT 
last_name
FROM EMPLOYEES
WHERE last_name LIKE '__a%';


SELECT
last_name
FROM EMPLOYEES
WHERE LOWER(last_name) LIKE '%a%'
AND LOWER(last_name) LIKE '%e%';


SELECT last_name,
       job_id,
       salary
FROM employees
WHERE job_id IN ('SA_REP','ST_CLERK')
AND salary NOT IN (2500,3500,7000);
