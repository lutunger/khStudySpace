package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int inputNumber = sc.nextInt();
		
		if(inputNumber < 0) {
			System.out.println("양수만 입력하세요.");
		}else if(inputNumber % 2 == 0) {
			System.out.println("짝수입니다.");
		}else {
			System.out.println("홀수입니다.");
		}
		
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int koreanScore = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int englishScore = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int mathScore = sc.nextInt();
		
		int sum = koreanScore + englishScore + mathScore;
		
		double average = sum / 3.0;
		
		String passCheck;
		
		boolean passInfo = false;
		
		if(koreanScore >= 40 && englishScore >= 40 && mathScore >= 40 && average >= 60) {
			passCheck = "축하합니다, 합격입니다!";
			passInfo = true;
		}else {
			passCheck = "불합격입니다.";
		}
		
		if(passInfo == false) {
			System.out.println(passCheck);
		}else { 
			System.out.println("국어점수 : " + koreanScore);
			System.out.println("수학점수 : " + mathScore);
			System.out.println("영어점수 : " + englishScore);
			System.out.println("합계 : " +sum);
			System.out.printf("평균 : %.1f \n", average);
			System.out.println(passCheck);
		
		}
		
	}

	
	
	
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int monthInput = sc.nextInt();
		
		switch(monthInput) {
		
		case 2 :
			System.out.println("2월은 28일까지 있습니다.");
		
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12:
			System.out.printf("%d월은 31일까지 있습니다", monthInput); break;
		
		case 4 : case 6 : case 9 : case 11 : 
			System.out.printf("%d월은 30일까지 있습니다."); break;
		
		default : System.out.printf("%d월은 잘못 입력된 달입니다.", monthInput);
			
		}
		
	}
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmiIndex = weight / (height * height);
		
		String bmiChecker;
		
		if(bmiIndex < 18.5) {
			bmiChecker = "저체중";
		} else if(bmiIndex < 23) {
			bmiChecker = "정상체중";
		} else if(bmiIndex < 25) {
			bmiChecker = "과체중";
		} else if(bmiIndex < 30) {
			bmiChecker = "비만";
		} else {
			bmiChecker = "고도 비만";
		}
		
		System.out.println("키(m)를 입력해 주세요 : " + height);
		System.out.println("몸무게(kg)를 입력해 주세요 : " + weight);
		System.out.println("BMI 지수 : " + bmiIndex);
		System.out.println(bmiChecker);
		
		
	}
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int middleTestScore = sc.nextInt();
		
		System.out.print("기말 고사 점수 : ");
		int finalTestScore = sc.nextInt();
		
		System.out.print("과제 점수 : ");
		int homeworkScore = sc.nextInt();
		
		System.out.print("출석 횟수 : ");
		int appearNumber = sc.nextInt();
		
		double scoreSum = (middleTestScore * 0.2) + (finalTestScore * 0.3) + (homeworkScore * 0.3) + (appearNumber * 1.0); 
		
		int passChecker = 0; // 0 = pass , 1 = fail [점수 미달] , 2[출석 횟수 부족 (10/20) ]
		
		if (appearNumber < 20 * (1 - 0.3)) {
			passChecker = 2;
		} else if (scoreSum < 70) {
			passChecker = 1;
		}
		
		
		System.out.println("============= 결과 ================");
		
		switch(passChecker) {
		case 0 : 
			System.out.printf("중간 고사 점수(20) : %.1f\n", middleTestScore * 0.2);
			System.out.printf("기말 고사 점수(30) : %.1f\n", finalTestScore * 0.3);
			System.out.printf("과제 점수		(30) : %.1f\n", homeworkScore * 0.3);
			System.out.printf("출석 점수		(20) : %.1f\n", appearNumber * 1.0);
			System.out.printf("총점 : %.1f\n", scoreSum);
			System.out.println("PASS");
			break;
		
		case 1 :
			System.out.printf("중간 고사 점수(20) : %.1f\n", middleTestScore * 0.2);
			System.out.printf("기말 고사 점수(30) : %.1f\n", finalTestScore * 0.3);
			System.out.printf("과제 점수		(30) : %.1f\n", homeworkScore * 0.3);
			System.out.printf("출석 점수		(20) : %.1f\n", appearNumber * 1.0);
			System.out.printf("총점 : %.1f\n", scoreSum);
			System.out.println("Fail [점수 미달]");
			break;
			
		case 2 :
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]", appearNumber);
			break;
			
		default :
			System.out.println("몰라..;;; 모야 어떻게 접근한거예요????");
		}
		
		
	}
	
	
	
	
	
	
	
}
