package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//국어
		System.out.print("국어 : ");
		int korean = sc.nextInt();
		
		//영어
		System.out.print("영어 : ");
		int english = sc.nextInt();
		
		//수학
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		//세 과목에 대한 합계
		int scoreSum = korean + english + math;
		
		//평균
		double scoreAverage = scoreSum / 3.0;
		
		//합격 여부 판단
		String sucsessCheck = ((korean >= 40 && english >= 40 && math >= 40) && // 세 과목 점수 각각 40점 이상
								(scoreAverage >= 60)) ? // 평균이 60점 이상
								 "합격" : "불합격" ;
		
		//출력하기
		System.out.printf("합계 : %d \n평균 : %.1f \n%s",
							scoreSum,
							scoreAverage,
							sucsessCheck
							);
		
		
		
		
	}
	
}
