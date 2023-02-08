package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//정수를 하나 입력받아 양수/음수/0을 구분하세요.
		
//		1. 정수 입력받기
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
//		2.양수/음수/0 구분하기
		String integerClassify = input > 0 ? "양수 입니다" : (input == 0) ? "0 입니다" : "음수입니다" ;    
		
//		3.구분된 정수가 양수/음수/0 출력해보기
		System.out.println(integerClassify);
	
	}
	
}
