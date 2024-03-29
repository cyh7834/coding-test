SELECT
    CASE
        WHEN OCCUPATION = 'DOCTOR' THEN CONCAT(NAME, '(D)')
        WHEN OCCUPATION = 'PROFESSOR' THEN CONCAT(NAME, '(P)')
        WHEN OCCUPATION = 'SINGER' THEN CONCAT(NAME, '(S)')
        WHEN OCCUPATION = 'ACTOR' THEN CONCAT(NAME, '(A)')
        END AS NAME
        FROM 
            OCCUPATIONS
        ORDER BY 
            NAME;
SELECT 
    CONCAT('THERE ARE A TOTAL OF ', COUNT(*), ' ', LOWER(OCCUPATION), 'S.') AS RESULT
FROM 
    OCCUPATIONS
GROUP BY 
    OCCUPATION
ORDER BY 
    RESULT;