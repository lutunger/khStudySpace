package edu.kh.variable;

public class VariableEx4 {

	public static void main(String[] args) {
		
		// String(문자열)
		// - 문자열을 저장하는 자료형
		// - 기본 자료형 X
		// - 참조형 O
		
		// 문자열 리터럴 표기법 : "" (쌍따옴표 double quote)
		
		String str1 = "Hello";
		
		System.out.println(str1);
		
		System.out.println(100000000000000000L);
		
		// 출력하고자 하는 값의 리터럴 표기법을 작성
		System.out.println("안녕하세요?");
		
		System.out.println("-----------------------");
		
		String name = "김지환";
		int age = 31;
		char gender = '남';
		
		System.out.println(age + 1); // 정수 + 정수 = 두 수의 합 
		
		System.out.println(name + "입니다"); // 문자열 + 문자열 = 이어쓰기
		
		System.out.println(name + age); // 문자열 + 정수 = 이어쓰기
		
		System.out.println(name + age + gender); // 문자열 + 정수 + 문자형 = 이어쓰기
		
		// 김지환님은 31세 남성입니다.
		System.out.println(name + "님은 " + age + "세 " + gender + "성입니다.");
		
		System.out.printf("%s님은 %d세 %s성입니다.", 
							name,
							age,
							gender
							); // 요건 내가 그냥 써본것...
		
		// 사칙연산 연산 순위 적용(왼쪽 -> 오른쪽)
		System.out.println( 100 + age + name); // 정수 + 정수 + 문자열 = 이어쓰기
												// = 두 정수 합 + 문자열 (이어쓰기)
	}
}
