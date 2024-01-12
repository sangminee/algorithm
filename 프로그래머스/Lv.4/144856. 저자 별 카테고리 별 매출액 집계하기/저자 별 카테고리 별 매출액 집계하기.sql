-- 코드를 입력하세요

-- 2022-01 의 도서 판매 데이터 기준으로 -> BOOK_SALES 
-- 저자별, 카테고리 매출액 (SALES * PRICE ) 구해 

-- 1) 202201 도서 판매 데이터 
--  >> 도서 별 판매액 구하기 
-- 2) 카테고리별 매출액 구하기 

select a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(b.TOTAL_SALES) as TOTAL_SALES
from AUTHOR a
right join (select (price * sales) as TOTAL_SALES
                   ,author_id
                   ,category
            from BOOK b
            left join (select  BOOK_ID
                              ,sum(SALES) as SALES
                       from BOOK_SALES
                       where to_char(SALES_DATE, 'YYYYMM') = '202201'
                       group by BOOK_ID) bs
on b.BOOK_ID = bs.BOOK_ID) b 
on a.AUTHOR_ID = b.AUTHOR_ID
group by a.AUTHOR_ID, a.AUTHOR_NAME, CATEGORY
order by a.AUTHOR_ID, CATEGORY desc;