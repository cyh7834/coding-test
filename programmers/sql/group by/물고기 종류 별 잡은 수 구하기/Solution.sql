SELECT
    COUNT(*) AS fish_count, fni.fish_name
FROM
    fish_info fi
INNER JOIN
    fish_name_info fni
ON
    fi.fish_type = fni.fish_type
GROUP BY
    fni.fish_name
ORDER BY
    fish_COUNT DESC;
