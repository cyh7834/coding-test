WITH cte AS (
    SELECT COUNT(*) AS total_user
    FROM user_info
    WHERE YEAR(joined) = 2021
)

SELECT 
    year, 
    month, 
    COUNT(*) AS purchased_users, 
    ROUND((COUNT(*) / total_user), 1) AS purchased_ratio
FROM (
    SELECT DISTINCT 
        user_id, 
        YEAR(sales_date)  AS year, 
        MONTH(sales_date) AS month
    FROM online_sale os
    WHERE os.user_id IN (
        SELECT user_id
        FROM user_info
        WHERE YEAR(joined) = 2021
    )
) t1, cte
GROUP BY 
    year, month
ORDER BY 
    year, month;