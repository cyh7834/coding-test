SELECT A.ANIMAL_ID, A.NAME 
FROM ANIMAL_INS AS A 
INNER JOIN ANIMAL_OUTS AS B 
ON A.ANIMAL_ID = B.ANIMAL_ID 
WHERE (B.DATETIME - A.DATETIME ) < 0 
ORDER BY A.DATETIME ASC;