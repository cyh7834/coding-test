SELECT
    ugu.user_id, ugu.nickname, SUM(ugb.price) AS total_sales
FROM
    (
        SELECT
            writer_id, price, status
        FROM
            used_goods_board
        WHERE
            status = 'DONE'
    ) ugb
INNER JOIN
    used_goods_user ugu
ON
    ugb.writer_id = ugu.user_id
GROUP BY
    ugb.writer_id
HAVING
    total_sales >= 700000
ORDER BY
    total_sales;