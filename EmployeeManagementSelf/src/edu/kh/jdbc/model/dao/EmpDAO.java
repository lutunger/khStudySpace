package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt2;
	private ResultSet rs;

	/**
	 * 전체 사원 조회 SQL 수행 후 결과 반환 메서드
	 * 
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectAll(Connection conn) throws SQLException {

		List<Emp> empList = new ArrayList<>();

		try {

			String sql = "SELECT E.EMP_ID , E.EMP_NAME , D.DEPT_TITLE , J.JOB_NAME , E.SALARY , E.PHONE , E.EMAIL \r\n"
						+ "FROM EMPLOYEE E\r\n"
						+ "LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)\r\n"
						+ "LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)\r\n"
						+ "WHERE ENT_YN = 'N'\r\n"
						+ "ORDER BY E.JOB_CODE";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
				// 직급코드 오름차순으로 조회

				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);

				Emp emp = new Emp(empId, empName, email, phone, salary, departmentTitle, jobName);

				empList.add(emp);

			}

		} finally {

			close(stmt);
			close(rs);

		}

		return empList;
	}

	
	/** 퇴직한 전체 사원 정보 반환 서비스
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetire(Connection conn) throws SQLException {
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT E.EMP_ID , E.EMP_NAME , E.PHONE , E.EMAIL , E.ENT_DATE \r\n"
						+ "FROM EMPLOYEE E\r\n"
						+ "WHERE ENT_YN = 'Y'\r\n"
						+ "ORDER BY ENT_DATE ";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// 현재 퇴직한 사원의
				// 사번, 이름, 전화번호, 이메일, 퇴사일을
				// 퇴사일 오름차순으로 조회
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String Phone = rs.getString(3);
				String Email = rs.getString(4);
				Date SQLEntDate = rs.getDate(5);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String entDate = sdf.format(SQLEntDate);
				
				Emp emp = new Emp(empId, empName, Email, Phone, entDate);
				
				empList.add(emp);
				
			}
			
		} finally {
			close(stmt);
			close(rs);
		}
		
		
		return empList;
	}


	/** 사번을 통해 조회한 사원의 정보 반환
	 * @param conn
	 * @param input 
	 * @return
	 */
	public Emp selectEmpId(Connection conn, int input) throws SQLException{
		
		Emp emp = null;
		
		try {
			String sql = "SELECT E.EMP_ID , E.EMP_NAME , NVL(D.DEPT_TITLE, '소속없음') , J.JOB_NAME ,\r\n"
						+ "		E.SALARY , E.PHONE , E.EMAIL , E.HIRE_DATE , E.ENT_YN \r\n"
						+ "FROM EMPLOYEE E\r\n"
						+ "LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)\r\n"
						+ "LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)\r\n"
						+ "WHERE E.EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			// 사번을 입력 받아 일치하는 사원의  
			// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 
			// 이메일, 입사일, 퇴직여부 조회
			// 단, 사번이 일치하는 사원이 없으면
			// "사번이 일치하는 사원이 없습니다" 출력
			
			if(rs.next()){
			
			int empId = rs.getInt(1);
			String empName = rs.getString(2);
			String departmentTitle = rs.getString(3);
			String jobName = rs.getString(4);
			int salary = rs.getInt(5);
			String phone = rs.getString(6);
			String email = rs.getString(7);
			Date hireDate = rs.getDate(8);
			String entYN = rs.getString(9);
			
			
			emp = new Emp(empId, empName, email, phone, salary, hireDate, entYN, departmentTitle, jobName);
			
			}
		} finally {
			
			close(rs);
			close(stmt);
			
		}
		
		
		return emp;
	}


	/** 사원 정보를 삽입하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return
	 */
	public int insertEmp(Connection conn, Emp emp) throws SQLException{
		
		int result = 0;
		
		try {
//			EMP_NAME 1
//			EMP_NO	2
//			EMAIL	3
//			PHONE	4
//			DEPT_CODE	5
//			JOB_CODE	6
//			SAL_LEVEL	7
//			SALARY	8
//			BONUS	9
//			MANAGER_ID	10

			String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_WORKBOOK_NO.NEXTVAL,"
					+ "?, ?, ?, ?, ?, ?, ?, ? , ?, ? , SYSDATE , NULL, 'N') ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());
			
			result = pstmt.executeUpdate();
			
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 사원 정보를 수정하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmp(Connection conn, Emp emp) throws SQLException{
		
		int result = 0;
		
		try {
			
			String sql = "UPDATE EMPLOYEE\r\n"
						+ "SET EMAIL = ?,\r\n"
						+ "	PHONE = ?,\r\n"
						+ "	SALARY = ?,\r\n"
						+ "	BONUS = ?\r\n"
						+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 삭제 처리 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int deleteEmp(Connection conn, int input) throws SQLException{

		int result = 0;
		
		try {
			
			String sql = "DELETE FROM EMPLOYEE\r\n"
						+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}


	/** 퇴사 처리 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int updateRetire(Connection conn, int input) throws SQLException{
		
		int result = 0;
		
		try {
			
			// - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
			String sql = "UPDATE EMPLOYEE "
						+ "SET ENT_YN 	= 'Y' , "
						+ "	   ENT_DATE = SYSDATE "
						+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
		}
//		
//		try {
//			
//			String sql = "SELECT ENT_YN "
//						+ "FROM EMPLOYEE "
//						+ "WHERE EMP_ID = ?	";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1, input);
//			
//			rs = pstmt.executeQuery();
//			
//			rs.next();
//			String fired = rs.getString(1);
//			
//			if(fired == "Y") {
//				result = 100;
//			}
//			
//		} finally {
//			
//			close(pstmt);
//		}

		return result;
	}
	
}










