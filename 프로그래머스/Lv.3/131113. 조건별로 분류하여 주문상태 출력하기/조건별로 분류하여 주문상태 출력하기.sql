-- 코드를 입력하세요
SELECT ORDER_ID,
       PRODUCT_ID,
       to_char(OUT_DATE, 'YYYY-MM-DD'),
       case when to_char(OUT_DATE, 'YYYYMMDD') <= '20220501' then '출고완료'
             when to_char(OUT_DATE, 'YYYYMMDD')  > '20220501' then '출고대기'
             else '출고미정'
        end as 출고여부
FROM FOOD_ORDER
order by ORDER_ID;