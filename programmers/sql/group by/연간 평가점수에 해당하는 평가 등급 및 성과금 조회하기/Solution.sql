SELECT 
    he.emp_no, 
    he.emp_name,
    CASE 
        WHEN a.avg_score >= 96 THEN 'S'
        WHEN a.avg_score >= 90 THEN 'A'
        WHEN a.avg_score >= 80 THEN 'B'
        ELSE 'C' 
    END AS grade,
    CASE 
        WHEN a.avg_score >= 96 THEN he.sal * 0.2
        WHEN a.avg_score >= 90 THEN he.sal * 0.15
        WHEN a.avg_score >= 80 THEN he.sal * 0.1
        ELSE 0 
    END AS bonus
FROM 
    hr_employees he
INNER JOIN (
    SELECT 
        emp_no, 
        AVG(score) AS avg_score 
    FROM 
        hr_grade 
    GROUP BY 
        emp_no
) a 
    ON he.emp_no = a.emp_no
ORDER BY 
    he.emp_no;
