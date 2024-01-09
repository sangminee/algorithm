-- 코드를 입력하세요
SELECT  ri.REST_ID
       ,REST_NAME
       ,FOOD_TYPE
       ,FAVORITES	
       ,ADDRESS
       ,SCORE
from REST_INFO ri
inner join (select REST_ID
                 ,round(AVG(REVIEW_SCORE),2) as SCORE
            from REST_REVIEW
            group by REST_ID) rr 
on ri.REST_ID=rr.REST_ID
where ADDRESS like '서울'||'%'
order by SCORE desc, FAVORITES desc;