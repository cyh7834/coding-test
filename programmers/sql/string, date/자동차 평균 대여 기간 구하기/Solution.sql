SELECT car_id,
       ROUND(
           AVG(
               IF(DATEDIFF(end_date, start_date) > 0, DATEDIFF(end_date, start_date) + 1, 1)
           ),
           1
       ) AS average_duration
FROM car_rental_company_rental_history
GROUP BY car_id
HAVING average_duration >= 7
ORDER BY average_duration DESC, car_id DESC;
