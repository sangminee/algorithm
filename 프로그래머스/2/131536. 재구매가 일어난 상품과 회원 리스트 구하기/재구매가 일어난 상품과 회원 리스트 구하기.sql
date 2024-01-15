-- 코드를 입력하세요

-- 동일한 상품을 재구매한 데이터 구하기

-- 1) USER_ID가 PRODUCT_ID를 몇개 구했는지 구하기 
SELECT USER_ID
       ,PRODUCT_ID
from ONLINE_SALE
group by USER_ID, PRODUCT_ID
having count(ONLINE_SALE_ID) > 1
order by USER_ID asc, PRODUCT_ID desc; 