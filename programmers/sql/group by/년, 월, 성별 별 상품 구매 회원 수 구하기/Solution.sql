SELECT YEAR(sales_date) AS year, MONTH(sales_date) AS month, gender, COUNT(DISTINCT t1.user_id) AS users
FROM (
    SELECT ui.user_id, os.sales_date, ui.gender
    FROM user_info ui
    INNER JOIN online_sale os ON ui.user_id = os.user_id
    WHERE gender IS NOT NULL
) t1
GROUP BY year, month, gender
ORDER BY year, month, gender;
