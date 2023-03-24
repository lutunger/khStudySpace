package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

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
	
	
	
}
