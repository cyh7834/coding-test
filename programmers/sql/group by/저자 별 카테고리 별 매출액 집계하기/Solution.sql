SELECT b.author_id, a.author_name, b.category, SUM(bs.sales * b.price) AS total_sales
FROM book b
INNER JOIN author a ON b.author_id = a.author_id
INNER JOIN (
  SELECT book_id, SUM(sales) AS sales
  FROM book_sales
  WHERE sales_date LIKE '2022-01%'
  GROUP BY book_id
) AS bs ON b.book_id = bs.book_id
GROUP BY b.author_id, a.author_name, b.category
ORDER BY b.author_id, b.category DESC;
