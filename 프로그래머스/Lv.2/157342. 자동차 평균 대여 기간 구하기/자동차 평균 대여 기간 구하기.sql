-- 코드를 입력하세요

-- 1) 평균대여 기간이 7일 이상인 자동차 

-- SELECT distinct CAR_ID
--       ,round(sum(END_DATE - START_DATE) / count(CAR_ID),1) as AVERAGE_DURATION
-- from CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- group by CAR_ID
-- having round(sum(END_DATE - START_DATE) / count(CAR_ID),1) >= 7
-- order by AVERAGE_DURATION desc, CAR_ID desc;

-- select CAR_ID
-- from (select CAR_ID
--             ,round(sum(END_DATE - START_DATE) / count(*), 1) as AVERAGE_DURATION
--       from CAR_RENTAL_COMPANY_RENTAL_HISTORY
--       group by CAR_ID)
-- where AVERAGE_DURATION >= 7
-- order by AVERAGE_DURATION desc, CAR_ID desc;


select CAR_ID
       ,round(avg(END_DATE - START_DATE+1),1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
having round(avg(END_DATE - START_DATE+1),1) >= 7
order by AVERAGE_DURATION desc, CAR_ID desc;

