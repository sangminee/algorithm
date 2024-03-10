-- 코드를 입력하세요

-- 2021 상품을 구매한 회원 수 / 2021년에 가입한 전체 회원 수 


SELECT TO_CHAR(SALES_DATE, 'YYYY') as YEAR,
       TO_NUMBER(TO_CHAR(SALES_DATE, 'MM')) as MONTH,
       COUNT(distinct (USER_ID)) as PUCHASED_USERS, 
       ROUND(COUNT(distinct(USER_ID)) / (SELECT COUNT(*) 
                                      FROM USER_INFO
                                      WHERE to_char(JOINED, 'YYYY') = '2021') , 1) as PUCHASED_RATIO
FROM ONLINE_SALE 
WHERE USER_ID IN (SELECT USER_ID 
                  FROM USER_INFO 
                  WHERE to_char(JOINED, 'YYYY') = '2021')
GROUP BY TO_CHAR(SALES_DATE, 'YYYY'), TO_CHAR(SALES_DATE, 'MM')
ORDER BY YEAR, MONTH; 


