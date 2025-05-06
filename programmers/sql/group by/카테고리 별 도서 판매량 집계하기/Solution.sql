SELECT 
    b.category, SUM(bs.sales) AS total_sales
FROM 
    book b
INNER JOIN (
    SELECT 
        * 
    FROM 
        book_sales 
    WHERE 
        sales_date LIKE '2022-01%'
) bs 
ON 
    b.book_id = bs.book_id
GROUP BY 
    b.category
ORDER BY 
    b.category;
