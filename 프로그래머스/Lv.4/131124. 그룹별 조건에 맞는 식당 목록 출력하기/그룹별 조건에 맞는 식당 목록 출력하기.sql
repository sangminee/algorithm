-- 코드를 입력하세요

-- 1) 리뷰를 가장 많이 작성한 회원의 리뷰 조회 


select MEMBER_NAME,
       REVIEW_TEXT, 
       to_char(REVIEW_DATE, 'YYYY-MM-DD') as REVIEW_DATE
from REST_REVIEW rr2 
inner join
      (select MEMBER_ID, count(*) as count 
       from REST_REVIEW
       group by MEMBER_ID) rr1
on rr1.MEMBER_ID = rr2.MEMBER_ID
inner join MEMBER_PROFILE rp
on rr2.MEMBER_ID = rp.MEMBER_ID
where count = (select max(count) from (select MEMBER_ID, count(*) as count 
                                       from REST_REVIEW
                                       group by MEMBER_ID))
order by REVIEW_DATE, REVIEW_TEXT;