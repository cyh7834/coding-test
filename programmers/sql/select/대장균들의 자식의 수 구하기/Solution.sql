SELECT T1.ID, (
				SELECT 
					COUNT(*) 
				FROM 
					(
						SELECT 
							ST1.ID
						FROM 
							ECOLI_DATA AS ST1
						INNER JOIN 
							ECOLI_DATA AS ST2
						ON 
							ST1.ID = ST2.PARENT_ID
					) AS T2 
				WHERE 
					T2.ID = T1.ID
				) AS CHILD_COUNT 
FROM 
	ECOLI_DATA AS T1 
ORDER BY 
	T1.ID;