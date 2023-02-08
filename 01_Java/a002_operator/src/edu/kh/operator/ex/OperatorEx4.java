package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // Scanner 생성
		
		System.out.println("[홀짝 검사기]");
		
		System.out.print("정수 하나를 입력해주세요 : ");
		
		int input = sc.nextInt(); // 정수 입력 받기
		
//--->self		
//		boolean evenChecker = input % 2 == 0;
//		
//		String checkerResult = evenChecker ? "짝수" : "홀수";
//		
//		System.out.printf("입력하신 %d는 %s입니다",
//							input,
//							checkerResult
//							);

		// 삼항연산자
		// 조건식 ? true인 경우 : false인 경우
		
		// Math.abs(숫자) -> 절대값
		String result = Math.abs(input) % 2 == 1 ? "홀수 입니다." 
				: input == 0 ? "0입니다" : "짝수 입니다.";
		
		System.out.println(result);
		
		
		
	}

}
