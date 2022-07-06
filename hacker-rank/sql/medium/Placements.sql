SELECT 
    S.NAME
FROM 
    FRIENDS F
INNER JOIN 
    STUDENTS S
ON 
    F.ID = S.ID
INNER JOIN 
    PACKAGES P
ON 
    S.ID = P.ID
INNER JOIN 
    PACKAGES FS
ON 
    FS.ID = F.FRIEND_ID
WHERE 
    P.SALARY < FS.SALARY
ORDER BY 
    FS.SALARY;