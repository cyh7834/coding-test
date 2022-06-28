SELECT 
    MAX(MONTHS * SALARY), COUNT(EMPLOYEE_ID)
FROM 
    EMPLOYEE
WHERE 
    MONTHS * SALARY = (SELECT   
                            MAX(MONTHS * SALARY) EARNINGS 
                       FROM 
                            EMPLOYEE);