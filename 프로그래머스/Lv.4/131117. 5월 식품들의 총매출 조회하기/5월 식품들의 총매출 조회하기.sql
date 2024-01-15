-- 코드를 입력하세요

-- FOOD_PRODUCT : 식품의 정보 (fp)
-- FOOD_ORDER : 주문 정보  (fo)

-- 1) 2022.05 생산한 식품 (PRODUCE_DATE)
-- 2) 총 매출 -> fp.PRICE * count(PRODUCT_ID) * AMOUNT


select fo.PRODUCT_ID, 
       fp.PRODUCT_NAME, 
       sum(AMOUNT)  * PRICE as TOTAL_SALES
from FOOD_ORDER fo 
right join FOOD_PRODUCT fp on fo.PRODUCT_ID = fp.PRODUCT_ID
where to_char(PRODUCE_DATE, 'YYYYMM') = '202205'
group by fo.product_id, fp.PRODUCT_NAME, PRICE
order by TOTAL_SALES desc, fo.PRODUCT_ID;