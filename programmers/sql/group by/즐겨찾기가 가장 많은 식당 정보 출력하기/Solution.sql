SELECT 
    t2.food_type, t1.rest_id, t1.rest_name, t2.favorites
FROM
    rest_info t1
INNER JOIN
    (
        SELECT
            food_type, MAX(favorites) AS favorites
        FROM
            rest_info
        GROUP BY 
            food_type
    ) t2
ON
    t1.food_type = t2.food_type 
AND 
    t1.favorites = t2.favorites
ORDER BY 
    t2.food_type DESC;