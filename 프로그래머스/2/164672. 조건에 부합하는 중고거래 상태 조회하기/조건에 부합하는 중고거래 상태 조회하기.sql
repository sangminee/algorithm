-- 코드를 입력하세요
SELECT BOARD_ID
       ,WRITER_ID
       ,TITLE
       ,PRICE
       , CASE WHEN STATUS = 'SALE' THEN '판매중'
              WHEN STATUS = 'RESERVED' THEN '예약중'
              ELSE '거래완료'
        END as STATUS
FROM USED_GOODS_BOARD
WHERE to_char(CREATED_DATE, 'YYYYMMDD') = '20221005'
ORDER BY BOARD_ID DESC;