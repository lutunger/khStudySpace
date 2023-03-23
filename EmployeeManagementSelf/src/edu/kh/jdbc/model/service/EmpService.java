package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();
	
	/** 전체 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectAll() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectAll(conn);
		
		close(conn);
		
		return empList;
	}

	/** 퇴직한 전체 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetire() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectRetire(conn);
		
		close(conn);
		
		return empList;
	}

	/** 사번을 통한 사원 정보 반환 서비스
	 * @param input 
	 * @return
	 */
	public Emp selectEmpId(int input) throws SQLException{

		Connection conn = getConnection();
		
		Emp emp = dao.selectEmpId(conn, input);
		
		close(conn);
		
		return emp;
	}

	/** emp 정보를 받아서 사원 정보를 추가하는 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int insertEmp(Emp emp) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.insertEmp(conn, emp);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	/** emp 정보를 받아서 사원 정보를 수정하는 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmp(Emp emp) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.updateEmp(conn, emp);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		
		return result;
	}

	/** 사번을 받아 사번에 맞는 사원 정보를 삭제하는 서비스
	 * @param input 
	 * @return result
	 * @throws SQLException
	 */
	public int deleteEmp(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.deleteEmp(conn, input);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 사원 퇴사 서비스
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int updateRetire(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.updateRetire(conn, input);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
}




