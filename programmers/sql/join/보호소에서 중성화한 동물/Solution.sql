SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.ANIMAL_TYPE, ANIMAL_OUTS.NAME 
FROM ANIMAL_INS
INNER JOIN ANIMAL_OUTS  
ON ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID 
WHERE ANIMAL_INS.SEX_UPON_INTAKE LIKE 'Intact%' 
AND (ANIMAL_OUTS.SEX_UPON_OUTCOME LIKE 'Spayed%' OR ANIMAL_OUTS.SEX_UPON_OUTCOME LIKE 'Neutered%') 
ORDER BY ANIMAL_OUTS.ANIMAL_ID;