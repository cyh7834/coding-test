SELECT 
    p.product_code, 
    os.sales_amount * p.price AS sales
FROM 
    product p
INNER JOIN (
    SELECT 
        product_id, 
        SUM(sales_amount) AS sales_amount
    FROM 
        offline_sale
    GROUP BY 
        product_id
) AS os
    ON p.product_id = os.product_id
ORDER BY 
    sales DESC, 
    product_code;
