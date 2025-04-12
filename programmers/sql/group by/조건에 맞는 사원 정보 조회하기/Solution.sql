SELECT
    SUM(score) AS score, he.emp_no, he.emp_name, he.position, he.email
FROM
    hr_department hd
INNER JOIN
    hr_employees he
ON
    hd.dept_id = he.dept_id
INNER JOIN
    hr_grade hg
ON
    he.emp_no = hg.emp_no
GROUP BY  
    he.emp_no
ORDER BY 
    score DESC
LIMIT
    1;