SELECT 
    CASE 
        WHEN (A + B) <= C OR (A + C) <= B OR (B + C) <= A THEN 'NOT A TRIANGLE' 
        WHEN A = B AND B = C THEN 'EQUILATERAL' 
        WHEN A = B OR B = C OR A = C THEN 'ISOSCELES' 
        ELSE 'SCALENE' 
        END 
FROM 
    TRIANGLES;