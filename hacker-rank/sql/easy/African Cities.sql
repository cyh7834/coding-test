SELECT 
    CITY.NAME
FROM 
    CITY AS CITY, COUNTRY AS COUNTRY
WHERE 
    CITY.COUNTRYCODE = COUNTRY.CODE AND COUNTRY.CONTINENT = 'AFRICA';