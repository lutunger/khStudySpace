package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.board.model.dao.CommentDAO;

public class CommentService {

	private CommentDAO dao = new CommentDAO();
	
	public int insertComment(int boardNo, String commentContent, int memberNo) throws Exception{

		Connection conn = getConnection();
		
		int commentNo = dao.nextCommentNo(conn);
		
		int result = dao.insertComment(conn, commentNo,
							commentContent, memberNo, boardNo);
		
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int matchCommentWriter(int input, int memberNo) throws Exception{

		Connection conn = getConnection();
		
		int CommentWriterNo = dao.CommentWriterNo(conn, input);
		
		int result = 0;
		
		if(CommentWriterNo == memberNo) {
			result = 1;
		}
		
		close(conn);
		
		return result;
	}

	public int updateComment(int input, String commentContent) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.updateComment(conn, input,	commentContent);
		
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deleteComment(int input) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteComment(conn, input);
		
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
		
	}

}




