-- 코드를 입력하세요
SELECT count(*) as USERS
from USER_INFO
where to_char(JOINED, 'YYYY') = 2021
and AGE between 20 and 29; 