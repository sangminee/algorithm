-- 코드를 입력하세요

-- ANIMAL_INS : 동물 보호소에 들어온 동물 정보 (ai) 
-- ANIMAL_OUTS : 입양 (ao)

-- 입양 간 동물 중,
-- 보호기간이 가장 길었던(ai.DATETIME  - ao.DATETIME) 2마리 이름 조회  

select *
from (select ao.ANIMAL_ID
            ,ao.NAME
     from ANIMAL_OUTS ao
      inner join ANIMAL_INS ai on ao.ANIMAL_ID = ai.ANIMAL_ID
     where ao.ANIMAL_ID is not null
     order by ao.DATETIME-ai.DATETIME desc)
where rownum <=2;


