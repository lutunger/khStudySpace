package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Comment;

public class CommentDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public CommentDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 댓글 목록 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectCommentList(Connection conn, int input) 
														throws Exception{
		
		// 결과 저장용 객체 생성
		List<Comment> commentList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectCommentList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment c = new Comment();
				
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));
				
				commentList.add(c); // 리스트에 추가
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return commentList;
	}

	public int nextCommentNo(Connection conn) throws Exception{
		
		int commentNo = 0;
		
		try {
			String sql = prop.getProperty("nextCommentNo");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				commentNo = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return commentNo;
	}

	public int insertComment(Connection conn, int commentNo, String commentContent, 
			int memberNo, int boardNo) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertComment");
			
//			INSERT INTO "COMMENT"
//			VALUES(?, ?, DEFAULT, DEFAULT, ?, ?)
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, commentNo);
			pstmt.setString(2, commentContent);
			pstmt.setInt(3, memberNo);
			pstmt.setInt(4, boardNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int CommentWriterNo(Connection conn, int input) throws Exception{
		
		int commentWriterNo = 0;
		
		try {
		
		String sql = prop.getProperty("commentWriter");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, input);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			commentWriterNo = rs.getInt(1);
		}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return commentWriterNo;
	}

	public int updateComment(Connection conn, int input, 
			String commentContent) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, input);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteComment(Connection conn, int input) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();
			
		} finally {
		
			close(pstmt);
		
		}
		
		return result;
	}
	
	
}


