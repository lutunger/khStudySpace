package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {

	public List<Employee2> select(String jobName) {

		List<Employee2> empList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost"; // DB서버 -> 115.90.212.22(강의장)
			String port = ":1521";	 // DB서버 -> :9000
			String dbName = ":ORCL";	 // 19c -> :ORCL	,	18c,DB서버	->	:XE
			String user = "kh_kjh";
			String pw = "oracle_kjh123A";
			
			//forName에서 얻어온 driver 클래스를 DriverManager로 사용
			conn = DriverManager.getConnection( type + ip + port + dbName, user, pw);
			
			
			String sql = "SELECT NVL(D.DEPT_TITLE, \'부서없음\') , J.JOB_NAME , E.EMP_NAME , E.EMAIL "
					+ "	FROM EMPLOYEE E"
					+ "	LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID) "
					+ "	LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE) "
					+ "	WHERE J.JOB_NAME = '" + jobName + "'"
					+ "	ORDER BY E.EMP_NAME ";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String deptTitle = rs.getString(1);
				String jobClass = rs.getString(2);
				String empName = rs.getString(3);
				String email = rs.getString(4);
				
				
				Employee2 emp = new Employee2(deptTitle, jobClass, empName, email);
				
				empList.add(emp);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4단계 : JDBC 객체 자원 반환
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return empList;
	}
	
	

}
