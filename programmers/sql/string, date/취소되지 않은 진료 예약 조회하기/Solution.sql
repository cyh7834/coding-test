SELECT 
    a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
FROM 
    doctor d
INNER JOIN (
    SELECT 
        apnt_no, pt_no, mcdp_cd, apnt_ymd, mddr_id
    FROM 
        appointment
    WHERE 
        apnt_cncl_yn = 'N'
        AND apnt_ymd LIKE '2022-04-13%'
) a 
    ON d.dr_id = a.mddr_id
INNER JOIN 
    patient p 
    ON a.pt_no = p.pt_no
ORDER BY 
    a.apnt_ymd;
