SELECT 
    SUM(CITY.POPULATION)
FROM 
    CITY AS CITY, COUNTRY AS COUNTRY 
WHERE 
    CITY.COUNTRYCODE = COUNTRY.CODE AND COUNTRY.CONTINENT = 'ASIA';