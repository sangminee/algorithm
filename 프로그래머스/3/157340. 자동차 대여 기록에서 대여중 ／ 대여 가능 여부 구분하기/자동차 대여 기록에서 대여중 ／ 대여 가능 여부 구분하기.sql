-- 코드를 입력하세요
SELECT CAR_ID, 
case when CAR_ID IN (
    select CAR_ID 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where '2022-10-16' between START_DATE and END_DATE) 
    then '대여중'
    else '대여 가능'
    end as AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;