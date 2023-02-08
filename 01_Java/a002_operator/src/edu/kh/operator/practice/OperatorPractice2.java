package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//이름 입력
		System.out.print("이름 : ");
		String name = sc.next();
		
		//학년(정수)입력
		System.out.print("학년(정수) : ");
		int grade = sc.nextInt();
		
		//반(정수)입력
		System.out.print("반(정수) : ");
		int schoolClass= sc.nextInt();
		
		//번호(정수)입력
		System.out.print("번호(정수) : ");
		int schoolNumber = sc.nextInt();
		
		//성별(남학생/여학생) 입력
		System.out.print("성별(남학생/여학생) : ");
		String gender = sc.next();
		
		//성적(소수점 아래 둘째 자리까지)
		System.out.print("소수점 아래 둘째 자리까지 : " );
		double score = sc.nextDouble();
		
		//출력
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.",
							grade,
							schoolClass,
							schoolNumber,
							name,
							gender,
							score
							);
		
		
				
		
		
	}
	
}
