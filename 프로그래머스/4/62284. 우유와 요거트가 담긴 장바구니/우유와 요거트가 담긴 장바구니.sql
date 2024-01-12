-- 코드를 입력하세요'

-- 1) 우유와 요거트를 동시구매한 장바구니 구하기 -> 아이디순

-- select * 
-- from CART_PRODUCTS
-- where CART_ID in (select CART_ID from CART_PRODUCTS where NAME = 'Milk'); 

-- (select CART_ID from CART_PRODUCTS where NAME = 'Milk'
-- union
-- select CART_ID from CART_PRODUCTS where NAME = 'Yogurt')
-- order by CART_ID;


select a.CART_ID 
from (select * from CART_PRODUCTS where NAME = 'Milk') a
inner join (select * from CART_PRODUCTS where NAME = 'Yogurt') b
on a.CART_ID = b.CART_ID
order by a.CART_ID;