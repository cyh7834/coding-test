SELECT 
    t1.id, t2.fish_name, t2.length 
FROM 
    fish_info t1 
INNER JOIN 
    (
        SELECT 
            fni.fish_name, MAX(fi.length) AS length, fni.fish_type 
        FROM 
            fish_info fi 
        INNER JOIN 
            fish_name_info fni 
        ON 
            fi.fish_type = fni.fish_type 
        GROUP BY 
            fni.fish_name, fni.fish_type
    ) t2 
ON 
    t1.length = t2.length AND t1.fish_type = t2.fish_type 
ORDER BY
    t1.id;