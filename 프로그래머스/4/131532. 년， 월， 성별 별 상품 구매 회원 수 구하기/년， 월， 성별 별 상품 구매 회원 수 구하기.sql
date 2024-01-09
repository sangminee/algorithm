-- 코드를 입력하세요
-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계

SELECT to_char(SALES_DATE, 'YYYY') as YEAR
      ,to_number(to_char(SALES_DATE, 'MM')) as MONTH
      ,GENDER
      ,count(distinct (os.user_id)) as USERS
from (select * 
      from ONLINE_SALE
      where USER_ID in (select USER_ID
                        from USER_INFO 
                        where GENDER is not NULL)) os
left join USER_INFO u on os.USER_ID = u.USER_ID
group by to_char(SALES_DATE, 'YYYY')
        ,to_char(SALES_DATE, 'MM')
        ,GENDER
order by YEAR, MONTH, GENDER;