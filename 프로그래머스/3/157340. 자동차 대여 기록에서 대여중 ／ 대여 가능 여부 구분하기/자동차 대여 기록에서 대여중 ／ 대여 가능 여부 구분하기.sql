-- 코드를 입력하세요

-- 대여 중인 자동차 


SELECT a.CAR_ID 
       ,case AVAILABILITY WHEN '대여중' THEN '대여중'
            else '대여 가능'
        end as AVAILABILITY
FROM (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY GROUP BY CAR_ID) a
LEFT JOIN (SELECT CAR_ID, '대여중' as AVAILABILITY
           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
           WHERE to_char(START_DATE, 'YYYYMMDD') <= '20221016'
           AND to_char(END_DATE, 'YYYYMMDD') >= '20221016') b
ON a.CAR_ID = b.CAR_ID
ORDER BY a.car_id desc;
