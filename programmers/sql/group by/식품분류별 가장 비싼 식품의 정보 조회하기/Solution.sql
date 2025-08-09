SELECT category, price AS max_price, product_name
FROM (
    SELECT *,
           ROW_NUMBER() OVER (PARTITION BY category ORDER BY price DESC) AS rn
    FROM food_product
    WHERE category = '과자' OR category = '국' OR category = '김치' OR category = '식용유'
) t
WHERE rn = 1
ORDER BY max_price DESC;
