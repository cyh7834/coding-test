SELECT 
    ingredient_type, SUM(total_order) AS total_order 
FROM 
    first_half fh 
INNER JOIN 
    icecream_info ii 
ON 
    fh.flavor = ii.flavor 
GROUP BY 
    ingredient_type 
ORDER BY 
    total_order;