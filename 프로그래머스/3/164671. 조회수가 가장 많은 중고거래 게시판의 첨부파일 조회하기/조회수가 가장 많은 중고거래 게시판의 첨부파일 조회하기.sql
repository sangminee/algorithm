-- 코드를 입력하세요

-- USED_GOODS_BOARD : 중고거래 게시판 정보 
-- USED_GOODS_FILE : 중고거래 게시판 첨부파일 정보 (fk : BOARD_ID)

-- 1) 게시판에서 조회수가 가장 높은 게시판 찾기 
-- 2) /home/grep/src/  -> 추가 

select ('/home/grep/src/' || b.BOARD_ID || '/' || f.FILE_ID || f.FILE_NAME||f.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD b
left join USED_GOODS_FILE f 
on b.BOARD_ID = f.BOARD_ID
where VIEWS = (select max(VIEWS) from USED_GOODS_BOARD)
order by FILE_ID desc;