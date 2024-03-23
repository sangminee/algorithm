-- 코드를 입력하세요
SELECT WAREHOUSE_ID
      ,WAREHOUSE_NAME
      ,ADDRESS
      ,case FREEZER_YN when 'Y' then 'Y'
                       else 'N'
       end as FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS like '%경기%'
ORDER BY WAREHOUSE_ID;