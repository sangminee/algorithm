-- 코드를 입력하세요

-- 취소 되지 않은 진료 

-- APPOINTMENT : 진료예약번호(APNT_NO), 진료예약일시(APNT_YMD)
-- PATIENT : 환자이름(PT_NAME), 환자번호(PT_NO)
-- DOCTOR : 진료과코드(MCDP_CD), 의사이름(DR_NAME)

SELECT ap.APNT_NO, p.PT_NAME, p.PT_NO,  d.MCDP_CD, d.DR_NAME, ap.APNT_YMD
FROM APPOINTMENT ap 
    LEFT JOIN DOCTOR d 
    ON d.DR_ID = ap.MDDR_ID 
    LEFT JOIN PATIENT p 
    ON p.PT_NO = ap.PT_NO
WHERE to_char(ap.APNT_YMD, 'YYYYMMDD') = '20220413' 
      AND APNT_CNCL_YN = 'N'
      AND ap.MCDP_CD = 'CS'
ORDER BY ap.APNT_YMD;