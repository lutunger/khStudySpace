package edu.kh.project.common.exception;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
						
						//runtime
						//sql
	// 500에러 은근 자주떠서 개발할때는 굳이 설정해야되나 싶은 경우도 있다..
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace(); // 에러 내용 콘솔에 출력
		return "error/500";	// 	/templates/error/500.html
	}
	
}
