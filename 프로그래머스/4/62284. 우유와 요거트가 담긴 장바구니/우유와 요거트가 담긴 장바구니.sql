-- 코드를 입력하세요

SELECT distinct CART_ID
FROM CART_PRODUCTS
WHERE NAME = 'Yogurt'
AND CART_ID in (SELECT CART_ID
                FROM CART_PRODUCTS
                WHERE NAME = 'Milk')
ORDER BY CART_ID;
