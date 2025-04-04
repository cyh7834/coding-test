SELECT
    SUM(price) AS TOTAL_PRICE
FROM
    item_info
GROUP BY
    rarity
HAVING
    rarity = 'LEGEND';