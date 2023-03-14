
/*1. 전지연 사원이 속해있는 부서원들을 조회하시오 (단, 전지연은 제외)
-- 사번, 사원명, 전화번호, 고용일, 부서명*/

-- 전지연 사원의 부서를 찾아야되는데~
--SELECT E.DEPT_CODE 
--FROM EMPLOYEE E
--WHERE E.EMP_NAME = '전지연';

SELECT E.EMP_ID , E.EMP_NAME , E.PHONE , E.HIRE_DATE, D.DEPT_TITLE  
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
WHERE E.DEPT_CODE = (SELECT E.DEPT_CODE 
					FROM EMPLOYEE E
					WHERE E.EMP_NAME = '전지연')
AND NOT E.EMP_NAME = '전지연';


-- 2. 고용일이 2000년도 이후인 사원들 중 급여가 가장 높은 사원의
-- 사번, 사원명, 전화번호, 급여, 직급명을 조회하시오.

SELECT E.EMP_ID , E.EMP_NAME , E.PHONE , E.SALARY 
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE SALARY = (SELECT MAX(SALARY)
				FROM EMPLOYEE SE
				WHERE EXTRACT (YEAR FROM SE.HIRE_DATE) >= 2000);

			
-- 3. 노옹철 사원과 같은 부서, 같은 직급인 사원을 조회하시오. (단, 노옹철 사원은 제외)
-- 사번, 이름, 부서코드, 직급코드, 부서명, 직급명

-- 노옹철 사원의 부서 , 직급 추출
--SELECT E.DEPT_CODE , E.JOB_CODE 
--FROM EMPLOYEE E
--WHERE E.EMP_NAME = '노옹철';

SELECT E.EMP_ID , E.EMP_NAME , E.DEPT_CODE , E.JOB_CODE , D.DEPT_TITLE , J.JOB_NAME 
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE (E.DEPT_CODE, E.JOB_CODE) = (SELECT E.DEPT_CODE , E.JOB_CODE 
									FROM EMPLOYEE E
									WHERE E.EMP_NAME = '노옹철')
AND NOT E.EMP_NAME = '노옹철';


-- 4. 2000년도에 입사한 사원과 부서와 직급이 같은 사원을 조회하시오
-- 사번, 이름, 부서코드, 직급코드, 고용일

-- 2000년도에 입사한 사원의 부서와 직급을 구해보자
--SELECT E.DEPT_CODE , E.JOB_CODE 
--FROM EMPLOYEE E
--WHERE EXTRACT(YEAR FROM E.HIRE_DATE) = 2000; 

-- 같은 사원 조회
SELECT E.EMP_ID , E.EMP_NAME , E.DEPT_CODE , E.JOB_CODE , E.HIRE_DATE 
FROM EMPLOYEE E
WHERE (E.DEPT_CODE, E.JOB_CODE) = (SELECT E.DEPT_CODE , E.JOB_CODE 
									FROM EMPLOYEE E
									WHERE EXTRACT(YEAR FROM E.HIRE_DATE) = 2000);
							
								
-- 5. 77년생 여자 사원과 동일한 부서이면서 동일한 사수를 가지고 있는 사원을 조회하시오
-- 사번, 이름, 부서코드, 사수번호, 주민번호, 고용일
			
-- 77년생 여자 사원의 부서와 사수 구하기
--SELECT E.DEPT_CODE , E.MANAGER_ID 
--FROM EMPLOYEE E
--WHERE SUBSTR(E.EMP_NO , 8 , 1) = '2'
--AND SUBSTR(E.EMP_NO, 1, 2) = '77';

SELECT E.EMP_ID , E.EMP_NAME , E.JOB_CODE , E.MANAGER_ID , E.EMP_NO , E.HIRE_DATE 
FROM EMPLOYEE E
WHERE (E.DEPT_CODE, E.MANAGER_ID) = (SELECT SE.DEPT_CODE , SE.MANAGER_ID 
									FROM EMPLOYEE SE
									WHERE SUBSTR(SE.EMP_NO , 8 , 1) = '2'
									AND SUBSTR(SE.EMP_NO, 1, 2) = '77');


-- 6. 부서별 입사일이 가장 빠른 사원의
-- 사번, 이름, 부서명(NULL이면 '소속없음'), 직급명, 입사일을 조회하고
-- 입사일이 빠른 순으로 조회하시오
-- 단, 퇴사한 직원은 제외하고 조회..

--부서별 입사일이 가장 빠른 사원 조회
SELECT E.EMP_ID , E.EMP_NAME, NVL(D.DEPT_TITLE, '소속없음') , J.JOB_NAME , E.HIRE_DATE 
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE E.HIRE_DATE = (SELECT MIN(SE.HIRE_DATE)
					FROM EMPLOYEE SE
					WHERE SE.ENT_YN = 'N'
					AND (NVL(E.DEPT_CODE, 1) = NVL(SE.DEPT_CODE, 1)))
ORDER BY E.HIRE_DATE ;



-- 7. 직급별 나이가 가장 어린 직원의
-- 사번, 이름, 직급명, 나이, 보너스 포함 연봉을 조회하고
-- 나이순으로 내림차순 정렬하세요
-- 단 연봉은 \124,800,000 으로 출력되게 하세요. (\ : 원 단위 기호
				
-- 직급별 나이가 가장 어린 직원은?
-- 나이를 어떻게 조회할건데?
SELECT E.EMP_NAME ,	
FLOOR(MONTHS_BETWEEN(SYSDATE , TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD'))/12) "나이",
TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD')
FROM EMPLOYEE E;

-- 나이 포함 테이블
SELECT E.EMP_ID , E.EMP_NAME , J.JOB_NAME , 
	FLOOR(MONTHS_BETWEEN(SYSDATE , TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD'))/12) "나이",
	TO_CHAR(((SALARY * (1 + NVL(E.BONUS, 0))) * 12), 'L999,999,999') "보너스 포함 연봉"
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE FLOOR(MONTHS_BETWEEN(SYSDATE , TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD'))/12) =
				(SELECT MIN(FLOOR(MONTHS_BETWEEN(SYSDATE , TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD'))/12))
				 FROM EMPLOYEE SE
				 WHERE NVL(E.JOB_CODE,0) = NVL(SE.JOB_CODE,0))
ORDER BY FLOOR(MONTHS_BETWEEN(SYSDATE , TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD'))/12) DESC ;
												


