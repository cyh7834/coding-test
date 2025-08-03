SELECT fp.product_id, fp.product_name, fp.price * fo.amount AS price
FROM food_product fp
INNER JOIN (
  SELECT product_id, SUM(amount) AS amount
  FROM food_order
  WHERE produce_date LIKE '2022-05%'
  GROUP BY product_id
) fo ON fp.product_id = fo.product_id
ORDER BY price DESC, product_id;
