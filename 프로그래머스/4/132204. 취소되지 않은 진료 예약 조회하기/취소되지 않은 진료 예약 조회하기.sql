-- 코드를 입력하세요
-- PATIENT : 환자
-- DOCTOR 
-- APPOINTMENT : 진료 예약목록 


-- 1) 


select a.APNT_NO
      ,p.PT_NAME
      ,p.PT_NO
      ,d.MCDP_CD
      ,d.DR_NAME
      ,APNT_YMD
from (SELECT *
      from APPOINTMENT
      where to_char(APNT_YMD, 'YYYYMMDD') = '20220413'
      and APNT_CNCL_YN = 'N') a
left join PATIENT p on a.PT_NO = p.PT_NO
left join DOCTOR d on a.MDDR_ID = d.DR_ID
order by APNT_YMD; 

