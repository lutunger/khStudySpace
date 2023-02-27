package edu.kh.collection.list.service;

import java.util.ArrayList;

public class ListService {

	/* List : 자료들을 순차적으로 나열한 자료구조 (배열과 비슷함)
	 * 
	 * - 인덱스를 이용해서 순서를 유지
	 * - 순서 구분이 가능하기 때문에 중복되는 데이터를 저장할 수 있다.
	 * 
	 * List 인터페이스를 구현한 대표적인 클래스
	 * -> ArrayList, Vector, LinkedList
	 */
	
	public void ex1() {
		
		/* 컬렉션 특징
		 * 1) 크기 제약이 없다
		 * 2) 추가, 삭제, 수정 등의 기능이 구현되어있다.
		 * 3) 여러 타입의 객체를 저장할 수 있다.
		 *   -> Object 타입의 참조변수 묶음이기 때문에.
		 */
		
		// ** 컬렉션은 모두 java.util 패키지에 존재 **
		// utility : 유용

		//ArrayList list = new ArrayList(); // 기본 생성자 -> 10칸짜리 생성
		
		ArrayList list = new ArrayList(3); // 매개변수 생성자 -> 3칸짜리 생성
		
		// -> 예상되는 데이터 수에 따라 생성자를 골라서 사용
		//	 -> 생성자에 따라 속도, 메모리 효율이 달라짐
		
		// boolean add(E e)
		// * E(Element) : 요소(객체)를 의미하는 제네릭 표기법
		//				 == Object 타입으로 생각하면 됨.
		
		list.add("아무거나");
		list.add(123);
		list.add(3.14);
		
		System.out.println("------------------");
		
	}
	
}














