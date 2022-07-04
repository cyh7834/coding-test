SELECT 
    H.HACKER_ID ID, H.NAME NAME
FROM 
    SUBMISSIONS S
JOIN 
    CHALLENGES C
ON 
    S.CHALLENGE_ID = C.CHALLENGE_ID
JOIN 
    DIFFICULTY D
ON 
    D.DIFFICULTY_LEVEL = C.DIFFICULTY_LEVEL
JOIN 
    HACKERS H
ON 
    S.HACKER_ID = H.HACKER_ID
WHERE 
    S.SCORE = D.SCORE
GROUP BY 
    ID, NAME
HAVING 
    COUNT(ID) > 1
ORDER BY 
    COUNT(ID) DESC, ID;