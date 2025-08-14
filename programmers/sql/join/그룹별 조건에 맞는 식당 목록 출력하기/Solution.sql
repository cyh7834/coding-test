SELECT 
    mp.member_name,
    rr.review_text,
    DATE_FORMAT(rr.review_date, '%Y-%m-%d') AS review_date
FROM 
    member_profile AS mp
INNER JOIN (
    SELECT 
        COUNT(member_id) OVER (PARTITION BY member_id) AS number_of_member_id,
        member_id,
        review_text,
        review_date
    FROM 
        rest_review
) AS rr
    ON mp.member_id = rr.member_id
WHERE 
    rr.number_of_member_id = (
        SELECT 
            COUNT(member_id) AS max_number
        FROM 
            rest_review
        GROUP BY 
            member_id
        ORDER BY 
            max_number DESC
        LIMIT 1
    )
ORDER BY 
    review_date,
    rr.review_text;
