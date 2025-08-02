SELECT flavor
FROM (
  SELECT flavor, total_order
  FROM first_half fh
  UNION
  SELECT flavor, total_order
  FROM july j
) t1
GROUP BY flavor
ORDER BY SUM(t1.total_order) DESC
LIMIT 3;
