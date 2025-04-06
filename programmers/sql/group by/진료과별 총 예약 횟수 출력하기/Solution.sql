SELECT 
    DISTINCT mcdp_cd AS 진료과코드, COUNT(*) OVER(PARTITION BY mcdp_cd) AS 5월예약건수
FROM 
    appointment 
WHERE 
    apnt_ymd LIKE '2022-05%' 
ORDER BY 
    5월예약건수, 진료과코드;