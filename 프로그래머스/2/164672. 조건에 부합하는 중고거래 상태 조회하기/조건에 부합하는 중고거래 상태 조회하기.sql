-- 코드를 입력하세요
SELECT BOARD_ID
      ,WRITER_ID
      ,TITLE
      ,PRICE
      ,case when STATUS = 'SALE' then '판매중'
             when STATUS = 'RESERVED' then '예약중'
             else '거래완료'
       end as STATUS
from USED_GOODS_BOARD 
where to_char(CREATED_DATE, 'YYYYMMDD') = '20221005'
order by BOARD_ID desc;