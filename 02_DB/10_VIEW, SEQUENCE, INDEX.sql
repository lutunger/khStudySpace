
/* VIEW
 * 
 * - 논리적 가상 테이블
 * 		-> 테이블 모양을 하고는 있지만, 실제로 값을 저장하고 있진 않음.
 * 
 * - SELECT문의 실행 결과(RESULT SET)를 저장하는 객체
 * 
 * 
 * ** VIEW 사용 목적 **
 *  1) 복잡한 SELECT문을 쉽게 재사용하기 위해
 *  2) 테이블의 진짜 모습을 감출 수 있어 보안상 유리.
 * 
 * ** VIEW 사용 시 주의 사항 **
 *  1) 가상의 테이블(실체 X)이기 때문에 ALTER 구문 사용 불가.
 *  2) VIEW를 이용한 DML(INSERT, UPDATE, DELETE)이 가능한 경우도 있지만
 * 	   제약이 많이 따르기 때문에 조회(SELECT) 용도로 대부분 사용. --> VIEW가지고 DML하지마!
 *  
 * ** VIEW 작성법 **
 * CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름 [컬럼 별칭]
 * AS 서브쿼리(SELECT문)
 * [WITH CHECK OPTION]
 * [WITH READ ONLY]
 * 
 * 1) OR REPLACE 옵션 : 
 * 		기존에 동일한 이름의 VIEW가 존재하면 이를 변경
 * 		없으면 새로 생성
 * 
 * 2) FORCE | NOFORCE 옵션 :
 * 		FORCE : 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성(강제생성)
 * 		NOFORCE(기본값) : 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성
 * 
 * 3) 컬럼 별칭 옵션 : 조회되는 VIEW의 컬럼명을 지정(어차피 서브쿼리에서 별칭지정하는데 굳이?)
 * 
 * 4) WITH CHECK OPTION : 
 * 		옵션을 지정한 컬럼의 값을 수정 불가능하게 함.(근데 VIEW에 DML 하지않는게 좋아서.. 굳이??) 
 * 
 * 5) WITH READ ONLY 옵션 :
 * 		뷰에 대해 SELECT만 가능하도록 지정.
 */



-- EMPLOYEE 테이블에서
-- 모든 사원의 사번, 이름, 부서명, 직급명 조회
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);
--> VIEW 생성

CREATE VIEW V_EMP
AS (SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME
	FROM EMPLOYEE E
	LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
	LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE));

-- ORA-01031: 권한이 불충분합니다

--> SYS 계정으로 접속
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

--> 각자 계정에 CREATE VIEW 권한 부여
GRANT CREATE VIEW TO kh_kjh;

--> 다시 kh 계정으로 접속해서 VIEW 생성 구문 수행

CREATE VIEW V_EMP
AS (SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME
	FROM EMPLOYEE E
	LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
	LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE));
			--> 이제 권한이 생겨서 VIEW 테이블 생성이 가능


-- 생성된 VIEW를 이용해서 조회
SELECT * FROM V_EMP;


-- V_EMP 뷰 수정하기(OR REPLACE)
CREATE VIEW V_EMP
AS (SELECT E.EMP_ID 사번, E.EMP_NAME 이름, D.DEPT_TITLE 부서명, J.JOB_NAME 직급명
	FROM EMPLOYEE E
	LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
	LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE));
-- ORA-00955: 기존의 객체가 이름을 사용하고 있습니다.

CREATE OR REPLACE VIEW V_EMP
AS (SELECT E.EMP_ID 사번, E.EMP_NAME 이름, D.DEPT_TITLE 부서명, J.JOB_NAME 직급명
	FROM EMPLOYEE E
	LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
	LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE));

SELECT * FROM V_EMP;

-- V_EMP에서 직급이 대리인 사원의 정보를 조회
SELECT * FROM V_EMP
WHERE 직급명 = '대리';

---------------------------------------------------------

/* VIEW를 이용한 DML(INSERT, DELETE, UPDATE)*/

-- 테이블 복사
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY2;

-- DEPT_COPY2에서
-- DEPT_ID, LOCATION_ID 칼럼만 조회하는
-- VIEW 생성
CREATE VIEW V_DCOPY2
AS SELECT DEPT_ID, LOCATION_ID
	FROM DEPT_COPY2;

SELECT * FROM V_DCOPY2;

-- VIEW를 이용한 INSERT
INSERT INTO V_DCOPY2
VALUES ('D0', 'L3');

-- INSERT 확인
SELECT * FROM V_DCOPY2;
--> VIEW는 값을 저장하지 않는다고 했는데...
--  저장된 것 처럼 보인다!
---> 실제 VIEW에 저장된 것이 아니라
--   VIEW를 생성할 때 사용한 서브쿼리의 테이블(DEPT_COPY2)에
--	 값이 삽입되어있다!

-- 원본 테이블(DEPT_COPY2) 확인
SELECT * FROM DEPT_COPY2;
-- D0	NULL	L3
--> 원본 테이블에 삽입됨을 확인
---> INSERT 구문에 포함되지 않은 DEPT_TITLE 컬럼은
--	 NULL이 삽입되어 있다!(중요)

ROLLBACK;

SELECT * FROM V_DCOPY2;

-- 복사한 테이블(DEPT_COPY2)의
-- DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가
ALTER TABLE DEPT_COPY2 
MODIFY DEPT_TITLE CONSTRAINT NN_DEPT_TITLE NOT NULL;


-- 다시 VIEW를 이용해서 INSERT
INSERT INTO V_DCOPY2 VALUES('DO', 'L3');
--> 원본 테이블 DEPT_ID, LOCATION_ID 컬럼에 'D0', 'L3' 삽입
---> DEPT_TITLE 컬럼에는 NULL 삽입
---> 그런데.... DEPT_TITLE에는 NOT NULL 제약조건이 설정되어
--	 NULL 값이 삽입될 수 없음.

-- ORA-01400: NULL을 ("KH_KJH"."DEPT_COPY2"."DEPT_TITLE") 
-- 안에 삽입할 수 없습니다


-- 데이터 무결성 : 중복 X, NULL X -> 신뢰도 높은 데이터
--> 대부분의 컬럼에 NOT NULL 제약조건 추가되어 있음
---> NOT NULL이 설정된 테이블을 이용해서 VIEW를 만들면
--   INSERT가 거의 불가능함.

--> 결론 : VIEW 가지고 DML을 수행하는 행동을 지양해라.

--------------------------------------------------------

/* WITH READ ONLY 옵션 추가 */
-- 읽기전용 X로 VIEW 변경
CREATE OR REPLACE VIEW V_DCOPY2 
AS SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPT_COPY2;
					-- DEPT_TITLE 포함

INSERT INTO V_DCOPY2 
VALUES('D0', '기획팀', 'L3');

ROLLBACK;


-- 읽기전용 O로 VIEW 변경
CREATE OR REPLACE VIEW V_DCOPY2 
AS SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPT_COPY2
WITH READ ONLY;

-- 다시 INSERT 시도
INSERT INTO V_DCOPY2 
VALUES('D0', '기획팀', 'L3');
-- ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.

-- VIEW의 원래 목적을 좀 더 명확히 하기 위한 읽기 전용 옵션이다... 나름 많이 쓰일듯...



-- FORCE, WITH CHECK는 잘 쓰지않는 옵션이라서... 넘어감..


------------------------------------------------------------

/* SEQUENCE(순서, 연속)
 * - 순차적으로 일정한 간격의 숫자(번호)를 발생시키는 객체
 *   (번호 생성기)
 * 
 * *** SEQUENCE 왜 사용할까?? ***
 * PRIMARY KEY(기본키) : 테이블 내 각 행을 구별하는 식별자 역할
 * 					   NOT NULL + UNIQUE의 의미를 가짐  
 * 
 * PK가 지정된 컬럼에 삽입될 값을 생성할 때 SEQUENCE를 이용하면 좋다!
 * 
 *  [작성법]
  CREATE SEQUENCE 시퀀스이름
  [STRAT WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27제곱 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26제곱) 
  	=> CYCLE과 연결됨 --> CYCLE의 최대,최소값...
  
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정 
  	==> -3 -2 -1 0 1 2 3 ==> 다시 -3(최소값)
  
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
	==> 미리 주문전에 아아 준비해놓고 주문나오면 바로 아아 주는??
	==> 시퀀스 미리 준비해놓고서 쿼리 생성하려고하면 바로바로 시퀀스 만들어주는... 
	==> 미리 세팅된 메모리,, 속도와 연관이 있다...
	
	-- 시퀀스의 캐시 메모리는 할당된 크기만큼 미리 다음 값들을 생성해 저장해둠
	-- --> 시퀀스 호출 시 미리 저장되어진 값들을 가져와 반환하므로 
	--     매번 시퀀스를 생성해서 반환하는 것보다 DB속도가 향상됨.
 * 
 * 
 * ** 사용법 **
 * 				-->NEXT VAL(UE)
 * 1) 시퀸스명.NEXTVAL : 다음 시퀀스 번호를 얻어옴.
 *					  (INCREMENT BY 만큼 증가된 수)
 *					   단, 생성 후 처음 호출된 시퀀스인 경우 
 * 					   START WITH에 작성된 값이 반한됨.
 * 
 * 			-->CURR(ENT) VAL(UE)
 * 2) 시퀀스명.CURRVAL : 현재 시퀀스 번호를 얻어옴.
 * 					   단, 시퀀스가 생성 되자마자 호출할 경우 오류 발생.
 * 					   == 마지막으로 호출한 NEXTVAL 값을 반환.
 * 
 */


-- 테이블 생성
CREATE TABLE TB_TEST(
	TEST_NO 	NUMBER 			PRIMARY KEY,
	TEST_NAME 	VARCHAR2(30)	NOT NULL
);

-- 시퀀스 생성
CREATE SEQUENCE SEQ_TEST_NO
START WITH 100	-- 100번부터 시작
INCREMENT BY 5	-- 5씩 증가
MAXVALUE 150	-- 최대값 150
NOMINVALUE		-- 최소값 없음
NOCYCLE			-- 반복 X
NOCACHE;		-- 미리 만들어두는 숫자 없음

-- 시퀀스 생성 확인

SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 100

SELECT SEQ_TEST_NO.CURRVAL FROM DUAL; -- 100
-- ORA-08002: 시퀀스 SEQ_TEST_NO.CURRVAL은 
--				이 세션에서는 정의 되어 있지 않습니다
-- NEXTVAL 하고 CURRVAL 하면 CURRVAL이 실행됨..

-- 다시 NEXTVAL 호출
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 105
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 110
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 115
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 120

SELECT SEQ_TEST_NO.CURRVAL FROM DUAL; -- 120

-- TB_TEST에 값 삽입
INSERT INTO TB_TEST 
VALUES( SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL );

SELECT * FROM TB_TEST; -- 삽입 확인

-- INSERT 추가 수행(3번)
INSERT INTO TB_TEST 
VALUES( SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL );

SELECT * FROM TB_TEST;


-- UPDATE 시퀸스 사용
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);

-- UPDATE 확인
SELECT * FROM TB_TEST;

-- UPDATE 추가 수행
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);
-- ORA-08004: 시퀀스 SEQ_TEST_NO.NEXTVAL exceeds 
--				MAXVALUE은 사례로 될 수 없습니다
--				-> SEQUENCE MAXVALUE 초과



-- 가장 마지막 TEST_NO를 조회하는 SELECT
SELECT MAX(TEST_NO) FROM TB_TEST;

SELECT * FROM 
	(SELECT TEST_NO FROM TB_TEST
	ORDER BY TEST_NO DESC)
WHERE ROWNUM = 1;

--SELECT SEQ_TEST_NO.CURRVAL
--FROM TB_TEST
--WHERE ROWNUM = 1;
--
--SELECT TEST_NO FROM TB_TEST
--ORDER BY TEST_NO DESC;



-----------------------------------------

-- SEQUENCE 변경(ALTER)
/*
  [작성법]
  ALTER SEQUENCE 시퀀스이름 
  -- 시작값 수정 불가 --
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27제곱 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26제곱) 
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정 
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
*/

-- SEQ_TEST_NO의 증가값을 1, 최대값 155로 수정
ALTER SEQUENCE SEQ_TEST_NO
INCREMENT BY 1
MAXVALUE 155;


-- UPDATE 구문 다시 수행
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);

-- UPDATE 확인
SELECT * FROM TB_TEST;


------------------------------------------------------

-- VIEW, SEQUENCE 삭제
DROP VIEW V_DCOPY2; -- VIEW 삭제
DROP SEQUENCE SEQ_TEST_NO; -- SEQUENCE 삭제
-- 시퀀스는 START WITH를 변경하고 싶을 때 삭제 후 다시 생성해야 한다.

--------------------------------------------------------

/* INDEX(색인)
 * - SQL 구문 중 SELECT 처리 속도를 향상 시키기 위해
 *   컬럼에 대하여 생성하는 객체
 * 					
 * - 인덱스 내부 구조는 B* 트리 형식으로 되어있음.
 * 					--> BINARY(보통은~), BALANCED
 * 					--> 이진트리, 바이너리 트리
 * 
 * ** INDEX의 장점 **
 * - 이진 트리 형식으로 구성되어 자동 정렬 및 검색 속도 증가.
 * - 조회 시 테이블의 전체 내용을 확인하며 조회하는 것이 아닌
 *   인덱스가 지정된 컬럼만을 이용해서 조회하기 때문에
 *   시스템의 부하가 낮아짐. --> 검색하는 속도가 빨라진다라는 것만 알아도..
 * 
 * ** 인덱스의 단점 **
 * - 데이터 변경(INSERT,UPDATE,DELETE) 작업 시 
 *   이진 트리 구조에 변형이 일어남
 *    -> DML 작업이 비번한 경우 시스템 부하가 늘어 성능이 저하됨.
 * 
 * - 인덱스도 하나의 객체이다 보니 별도 저장공간이 필요(메모리 소비)
 * 
 * - 인덱스 생성 시간이 필요함.
 * 
 * SELECT를 많이 하는 테이블에다가 인덱스 만들어라~~
 * --> 도서관 책 찾는거에?
 * 
 * 회원가입에는 INDEX 잘 안쓸듯...
 * 
 * 
 * [작성법]
 * CREATE [UNIQUE] INDEX 인덱스명
 * ON 테이블명 (컬럼명[, 컬럼명 | 함수명(계산식)]); --> 복합키
 * -- 이름은 동명이인이 있어서.. UNIQUE 옵션이 안될듯...
 * 
 * DROP INDEX 인덱스명
 * 
 * 
 * ** 인덱스가 자동 생성되는 경우 **
 * -> PK 또는 UNIQUE 제약조건이 설정된 컬럼에 대해 
 *    UNIQUE INDEX가 자동 생성된다.
 * */

-- INDEX를 사용 X 검색
SELECT * FROM EMPLOYEE
WHERE EMP_NAME != '0';


-- INDEX를 사용 O 검색
---> WHERE에 INDEX가 설정된 컬럼을 언급
SELECT * FROM EMPLOYEE
WHERE EMP_ID != '0';
--> 데이터가 적어서 차이 식별 불가

-- 데이터베이스가 커질수록 검색속도의 격차는 더 커진다.




-- 인덱스 확인용 테이블 생성
CREATE TABLE TB_INDEX_TEST(
	TEST_NO 	NUMBER 			PRIMARY KEY, -- UNIQUE INDEX 자동 생성
	TEST_ID 	VARCHAR2(20) 	NOT NULL
);

-- TB_INDEX_TEST 테이블에 샘플 데이터 100만개 삽입
-- (PL/SQL 사용) 프로시저널 바이 SQL,, SQL을 통한 절차적 언어 방식

BEGIN 
	FOR I IN 1..1000000 -- 1부터 1000000까지 1씩 증가
	LOOP --> FOR문 중괄호 역할 
		INSERT INTO TB_INDEX_TEST VALUES(I, 'TEST' || I);
	END LOOP;
	
	COMMIT;
END;


-- 인덱스 사용 X 조회
SELECT * FROM TB_INDEX_TEST
WHERE TEST_ID = 'TEST500000'; -- 37ms / 31ms / 30ms 

-- 인덱스 사용 O 조회
SELECT * FROM TB_INDEX_TEST 
WHERE TEST_NO = 500000; -- 3ms / 1ms / 0ms



-- 아니 그냥~ 숫자, 문자열 검색 차이 아님???
--> 에 대한 반박~
-- TEST_ID 컬럼에 대한 인덱스 생성
CREATE INDEX IDX_TEST_ID
ON TB_INDEX_TEST(TEST_ID);

-- 인덱스 생성 후 조회
SELECT * FROM TB_INDEX_TEST
WHERE TEST_ID = 'TEST500000'; -- 26ms / 1ms / 2ms / 1ms	

-------------------------------------

-- 인덱스 삭제
DROP INDEX IDX_TEST_ID;

SELECT * FROM TB_INDEX_TEST
WHERE TEST_ID = 'TEST500000'; -- 31 28 21 23

-- 테스트용 테이블 삭제
DROP TABLE TB_INDEX_TEST;

