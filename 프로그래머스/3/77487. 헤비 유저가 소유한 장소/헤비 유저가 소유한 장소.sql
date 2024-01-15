-- 코드를 입력하세요

-- 공간을 둘 이상 등록한 사람 -> 헤비 유저 찾기 (공간 아이디 순으로 정렬)


select * 
from PLACES 
where HOST_ID in (select HOST_ID
                  from (SELECT HOST_ID, count(*) as count 
                        from PLACES 
group by HOST_ID)
where count > 1 )
order by ID;