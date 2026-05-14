SELECT 
    ii.item_id, 
    ii.item_name
FROM 
    item_info ii
WHERE 
    ii.item_id IN (
        SELECT 
            item_id
        FROM 
            item_tree
        WHERE 
            parent_item_id IS NULL
    );