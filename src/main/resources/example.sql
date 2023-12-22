CREATE INDEX idx_employees_name_age ON employees (age, name);

SELECT * FROM employees
WHERE age > 30 AND name = 'John';