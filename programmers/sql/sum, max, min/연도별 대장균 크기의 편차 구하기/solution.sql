
SELECT 
    YEAR(differentiation_date) AS YEAR, MAX(size_of_colony) OVER(PARTITION BY YEAR(differentiation_date)) - size_of_colony AS YEAR_DEV, ID 
FROM 
    ecoli_data 
ORDER BY 
    year, year_dev;