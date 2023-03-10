
-- 문제 1
SELECT DEPARTMENT_NAME "학과 명", CATEGORY 계열
FROM TB_DEPARTMENT;

-- 문제 2
SELECT DEPARTMENT_NAME || '의 정원은 ' || CAPACITY || '명 입니다.' AS "학과별 정원"
FROM TB_DEPARTMENT;

-- 문제 3
SELECT STUDENT_NAME
FROM TB_STUDENT S
JOIN TB_DEPARTMENT D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)  
WHERE D.DEPARTMENT_NAME = '국어국문학과'
AND S.ABSENCE_YN = 'Y'
AND SUBSTR(S.STUDENT_SSN, 8, 1) = '2';

-- 문제 4
SELECT STUDENT_NAME 
FROM TB_STUDENT S
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119');

-- 문제 5
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

-- 문제 6
SELECT PROFESSOR_NAME 
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 문제 7
SELECT STUDENT_NAME 
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

-- 문제 8 
SELECT CLASS_NO 
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 문제 9
SELECT DISTINCT(CATEGORY)
FROM TB_DEPARTMENT;

-- 문제 10
SELECT STUDENT_NO, STUDENT_NAME , STUDENT_SSN 
FROM TB_STUDENT
WHERE EXTRACT (YEAR FROM ENTRANCE_DATE) = 2002
AND   STUDENT_ADDRESS LIKE '%전주%'
AND   ABSENCE_YN = 'N';
