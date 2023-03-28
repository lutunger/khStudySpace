package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.model.dto.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	public List<Member> selectMemberList() throws Exception{
		
		Connection conn = getConnection();
		
		List<Member> memberList = dao.SelectMemberList(conn);
		
		close(conn);
		
		return memberList;
	}

	/** 
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(String memberName, 
			String memberGender, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		// dao 호출 후 결과 반환 받기
		int result = dao.updateMember(conn, memberName, memberGender, memberNo);
		
		// 트랜잭션 처리
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int updatePassword(String curPass, String newPass, 
								int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updatePassword(conn, curPass, newPass, memberNo);
		
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		
		
		close(conn);
		
		return result;
		
		
	}
	
	
	/** 숫자 6가지 보안코드 생성 서비스
	 * @return code
	 */
	public String createSecurityCode() {
		
		StringBuffer code = new StringBuffer();
		
		// String : 불변성
		// StringBuffer : 가변성
		
		Random ran = new Random(); // 난수 생성 객체 
		
		for(int i = 0; i < 6 ; i++) {
			int x = ran.nextInt(10); // 0이상 10 미만 정수
			code.append(x); // StringBuffer 마지막에 추가(뒤에 이어 붙임)
		}
		
		return code.toString();
	}

	/** 회원 탈퇴 서비스
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int unRegisterMember(String memberPw, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.unRegisterMember(conn, memberPw, memberNo);
		
		if (result > 0) commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
}









