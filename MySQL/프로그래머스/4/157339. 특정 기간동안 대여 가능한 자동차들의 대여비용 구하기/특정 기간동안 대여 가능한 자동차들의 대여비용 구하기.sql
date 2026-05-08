-- 코드를 입력하세요
SELECT c.CAR_ID, c.CAR_TYPE, c.daily_fee*30*(100-dp.discount_rate)/100 AS FEE
FROM CAR_RENTAL_COMPANY_CAR c
LEFT JOIN (SELECT car_type, discount_rate
        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        WHERE car_type IN ('세단', 'SUV')
            AND duration_type = '30일 이상') dp
    ON dp.car_type = c.car_type
WHERE c.car_type IN ('세단', 'SUV')
    AND c.car_id NOT IN (SELECT car_id
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE start_date <='2022-11-30' AND end_date >= '2022-11-01')
GROUP BY car_id
HAVING FEE BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, c.CAR_TYPE, c.CAR_ID DESC
;

