package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		인원 수 체크 ==> 입력받음
		System.out.print("인원 수 : ");
		int membersNumber = sc.nextInt();
		
//		사탕 개수 체크 => 입력받음
		System.out.print("사탕 개수 : ");
		int lolipopNumbers = sc.nextInt();
		
//		1인당 사탕 개수에 대한 변수
		int lolipopDivideEqual = lolipopNumbers / membersNumber ;
//		남은 사탕 개수에 대한 변수
		int restOfLolipops = lolipopNumbers % membersNumber;
		
//		output
//		1인당 사탕 개수를 출력
		System.out.println("1인당 사탕 개수 : " + lolipopDivideEqual);
//		남은 사탕 개수를 출력
		System.out.println("남는 사탕 개수 :" + restOfLolipops );
		
		
		
	}
	
}
