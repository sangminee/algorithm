-- 코드를 입력하세요

select *
from 
(SELECT NAME
from ANIMAL_INS
order by DATETIME)
where rownum = 1; 