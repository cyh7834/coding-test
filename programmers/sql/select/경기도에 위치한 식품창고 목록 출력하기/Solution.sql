SELECT 
    warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N') as FREEZER_YN 
FROM
    food_warehouse 
WHERE
    address LIKE '경기도%' 
ORDER BY 
    warehouse_id;