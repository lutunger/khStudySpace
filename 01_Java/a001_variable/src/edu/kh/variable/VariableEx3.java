package edu.kh.variable;

public class VariableEx3 {
	
	public static void main(String[] args) {
		
		// 변수 : 메모리에 값을 저장할 수 있는 공간
		//		  저장된 값은 변할 수 있다.
		
		// 상수 : 메모리에 값을 저장 할 수 있는 공간
		//		  한번 저장된 값은 변할 수 없다.
		
		// 상수 예약어 : final
		
		// 변수 값 변경 확인
		int num1 = 100;
		num1 = 200;
		
		// 상수 값 변경 확인
		final int num2 = 99;
//		num2 = 999;
//		The final local variable num2 cannot be assigned. 
//		It must be blank and not using a compound assignment
//		상수니까 할당을 복수로 해선 안된다.
//		-> 한 번 값이 저장된 상수 num2에 다른 값을 저장하지 못함
		
		
		
		/* 상수(constant) 명명 규칙 및 활용법 */
		// - 명명규칙 : 모두 대문자 표기, 단어 구분시 _ 사용
		//
		
		final int CONSTANT_NUMBER = 100;
		
		// - 활용법
		
		final double PI = 3.14; 
		
		double result = PI * 10 * 10;
		
		System.out.println(result);
		
		final int UP = 5;
		final int DOWN = -5;
		final int INIT = 0; // 초기화(처음으로), init = initialize/initialization
		
		System.out.println("-----------------------");
		
		int result2 = INIT;
		System.out.println(result2); // 0
		
		// 대입 연산자(-) 기호를 기준으로
		// 오른쪽부터 해석
		result2 = result2 + UP;
		System.out.println(result2);
		
		result2 = result2 + DOWN + DOWN;
		//			5  -5 -5  = -5
		System.out.println(result2); // -5
		
		// ** 변수 명명 규칙 (반드시 지키세요!) **
		
		// 1. 대소문자 구분되며, 길이 제한 X
		int apple;
//		int apple; //Duplicate (local) variable apple (변수명 중복)
		int applE; //대소문자가 구별되어 apple과는 다른 변수로 인식된다.
		
		int freeTradeAgreement;
		int showMeTheMoney;
		int asdfasdfjlsadlfjasdlfjkzxcasdlkfhxczlbkhasdoifuqwelfkjsad;
		
		// 2. 예약어 사용 금지
//		int int;
//		double char;
//		boolean final;
		// => three expression comes to error
		
		// 3. 숫자로 시작 금지
//		long 100number; //error
		long number100;
		
		// 4. 특수문자는 $, _만 사용 가능
		float $num$ber;
		float _num_ber;
//		float @num@ber; // error
//		float #num#ber; // error
		
		// 5. 카멜 표기법 (개발자들 간의 약속)
		// - 변수명 첫 글자는 소문자
		// - 연결된 단어의 첫 글자는 대문자
		
		int studentAge;
		char helloWorld;
		
		
		// 참고) 변수명에 언어 제한이 없음
		int 정수1번;
		double 실수1번입니다;
		char 東;
		// 인코딩의 문제가 있을 수 있다.(타 나라에서 타 언어는 보이지 않는 경우가 존재)
		// 오픈소스로 코드를 배포를 하는 경우가 많은데 가장 범용적인 영어를 되도록이면 쓰자.
		
		
	}

}
