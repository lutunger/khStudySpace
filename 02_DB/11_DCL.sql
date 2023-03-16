
/* DCL(Data Control Language)
 * - 사용자(USER)에 DB 또는 DB객체에 대한 접근 권한을
 *   부여(GRANT, 허가)하고 회수(REVOKE, 다시 뺏어오는?)하는 언어
 * 
 * ** 사용자(계정) 구분 **
 * 1. 관리자 계정
 *  - 데이터베이스의 생성과 관리를 담당하는 계정.
 *	  모든 권한과 책임을 가지는 계정.
 *	  EX) SYS(최고 관리자), SYSTEM(SYS에서 권한 몇개가 제외된 관리자, 중간(부) 관리자)
 * 
 * 2. 사용자 계정
 * 	- 데이터베이스에 대하여 질의, 갱신, 보고서 작성 등의
 * 	  작업을 수행할 수 있는 계정.
 * 
 *  - 업무에 필요한 최소한의 권한만을 가지는 것을 "원칙"으로 한다.
 *    ex) kh계정, workbook 계정
 * 
 * 
 * ** 권한의 종류 **
 * 
 * 1) 시스템 권한 : DB접속, 객체 생성 권한
	-> 관리자 계정 또는 관리자 권한이 있는 계정
	
		CRETAE SESSION   : 데이터베이스 접속 권한
		CREATE TABLE     : 테이블 생성 권한
		CREATE VIEW      : 뷰 생성 권한
		CREATE SEQUENCE  : 시퀀스 생성 권한
		CREATE PROCEDURE : 함수(프로시져) 생성 권한
		CREATE USER      : 사용자(계정) 생성 권한
		DROP USER        : 사용자(계정) 삭제 권한
		DROP ANY TABLE   : 임의 테이블 삭제 권한


	2) 객체 권한 : 특정 객체를 조작할 수 있는 권한	
		객체 : TABLE, VIEW, INDEX, SEQUENCE, USER
		
	  권한 종류                 설정 객체
	    SELECT              TABLE, VIEW, SEQUENCE
	    INSERT              TABLE, VIEW
	    UPDATE              TABLE, VIEW
	    DELETE              TABLE, VIEW
	    ALTER               TABLE, SEQUENCE
	    REFERENCES          TABLE
	    INDEX               TABLE
	    EXECUTE             PROCEDURE
	    
 * 
 * 
 * */

-- (관리자 계정)
-- 사용자 계정 sample 생성.
									-->CLOUD
-- 0. SQL 구문 작성 형식은 일반 형식 (예전 12C 버전 이전 형식)으로 변경
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- 1. 사용자 계정 생성
-- CREATE USER 사용자명 IDENTIFIED BY 비밀번호;
 CREATE USER KJH_SAMPLE IDENTIFIED BY sample1234;
										-- 대소문자 구분

-- 2. 생성된 sample 계정 접속 방법 추가
	--> CREATE SESSION (접속 권한)이 없음
	--> sample 계정에 접속 권한을 부여(GRANT)
	
-- 3. 접속 권한 부여
-- GRANT 권한[,권한...] TO 계정명;
GRANT CREATE SESSION TO KJH_SAMPLE;

-- 4. 권한 부여 후 다시 접속 방법 추가

------------------ sample 계정으로 접속 ------------------

-- 5. 테이블 생성
CREATE TABLE TB_MEMBER(
	MEMBER_NO NUMBER PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PW VARCHAR2(30) NOT NULL
);

-- ORA-01031 : 권한이 불충분합니다
--> 다시 관리자 계정으로 전환해서 테이블 생성 관련 권한을 부여

----------------- 관리자 계정으로 접속 ------------------

-- 6. 테이블 생성 권한 부여
--    + 객체 생성 공간 할당
GRANT CREATE TABLE TO kjh_sample;

ALTER USER kjh_sample DEFAULT TABLESPACE SYSTEM
QUOTA UNLIMITED ON SYSTEM;
		--> 20M이 디폴트

----------------- sample 계정으로 접속 ---------------

-- 7. 다시 테이블 생성 시도
CREATE TABLE TB_MEMBER2(
	MEMBER_NO NUMBER PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PW VARCHAR2(30) NOT NULL
);


-----------------------------------------------------

/* 객체 권한 부여/회수 */

-------------- sample 계정으로 접속 -----------------------
-- 1. kh계정의 EMPLOYEE 테이블 조회
SELECT * FROM kh_kjh.EMPLOYEE;
--> ORA-00942: 테이블 또는 뷰가 존재하지 않습니다
--> 권한이 없어서 다른 계정의 테이블이 보이지 않음(안보이니까 모르겠다~)

-------------- kh 계정으로 접속 -----------------------
-- 2. sample 계정에 EMPLOYEE 테이블 SELECT 권한 부여

-- 시스템 권한 부여 : GRANT 권한[,권한...] TO 계정명;

-- 객체 권한 부여 : GRANT 권한[,권한...] ON 객체명 TO 계정명;

GRANT SELECT ON EMPLOYEE TO kjh_sample;

-------------- sample 계정으로 접속 -----------------------
-- 3. 다시 kh계정의 EMPLOYEE 테이블 조회
SELECT * FROM kh_kjh.EMPLOYEE;

-- 4. 선동일 삭제
DELETE FROM KH_KJH.EMPLOYEE
WHERE EMP_ID = 200;
-- ORA-01031: 권한이 불충분합니다

-------------- kh 계정으로 접속 ----------------------
-- 5. sample 계정의 employee 테이블 조회 권한 회수
REVOKE SELECT ON EMPLOYEE FROM KJH_SAMPLE;

-- 시스템 권한 회수 : REVOKE 권한[,권한...] FROM 계정명;
-- 객체 권한 회수 : REVOKE 권한[,권한...] ON 객체명 FROM 계정명;

------------- sample 계정으로 접속 ------------------------
-- 6. 다시 EMPLOYEE 테이블 조회
SELECT * FROM KH_KJH.EMPLOYEE;
-- ORA-00942: 테이블 또는 뷰가 존재하지 않습니다

-- 시스템 권한 부여 : GRANT 권한[,권한...] TO 계정명;
-- 객체 권한 부여 : GRANT 권한[,권한...] ON 객체명 TO 계정명;

-- 시스템 권한 회수 : REVOKE 권한[,권한...] FROM 계정명;
-- 객체 권한 회수 : REVOKE 권한[,권한...] ON 객체명 FROM 계정명;

---------------------------------------------------------------


/* ROLE (역할 == 권한의 묶음)
 * - 여러 권한을 하나로 묶어둠.
 * - 어려운 권한명(SESSION)을 쉽게 변경
 * 
 * 
 * */


------------------ 관리자 계정으로 접속 ------------------------
-- 1) RESOURCE : DB 사용을 위한 기본 객체 생성 권한의 묶음
SELECT * FROM ROLE_SYS_PRIVS --> PRIVILEGE
WHERE ROLE = 'RESOURCE'; -- 8행

--> sample 계정에 시퀸스, 프로시저, 클러스, 인덱스타입, 연산자, 타입
--				트리거, 테이블 생성 권한 부여

GRANT CREATE SEQUENCE,
		CREATE PROCEDURE,
		CREATE CLUSTER,
		CREATE INDEXTYPE,
		CREATE OPERATOR,
		CREATE TYPE,
		CREATE TRIGGER,
		CREATE TABLE TO KJH_SAMPLE;

--> ROLE을 이용해서 간단히 부여 / 회수
GRANT RESOURCE TO KJH_SAMPLE;
REVOKE RESOURCE FROM KJH_SAMPLE;

-- 사용자에게 부여된 시스템 권한 조회
SELECT * FROM DBA_SYS_PRIVS
WHERE GRANTEE = 'KJH_SAMPLE';

-- 사용자에게 부여된 롤 권한 조회
SELECT * FROM DBA_ROLE_PRIVS
WHERE GRANTEE = 'KJH_SAMPLE';


-- 2) CONNECT(연결하다, 접촉하다)
-- CREATE SEESION(DB 접속 권한) 하나만을 가지고 있는 ROLE
SELECT * FROM ROLE_SYS_PRIVS --> PRIVILEGE
WHERE ROLE = 'CONNECT'; -- 8행


-- 앞으로 사용자 계정을 생성할 경우 권한 부여 구문
GRANT CONNECT, RESOURCE, CREATE VIEW TO KJH_SAMPLE;
										--(계정명)

REVOKE  FROM KJH_SAMPLE;


-- USER 생성, GRANT, REVOKE 구문, 
-- CONNECT, RESOURCE ROLE 이정도만 알아두어라~

