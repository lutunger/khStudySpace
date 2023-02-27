package edu.kh.collection.list.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.collection.list.dto.Student;
import edu.kh.collection.list.service.StudentService;

public class StudentView {

	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	public void displayMenu() {
		int input = 0;
		
		do {
			try {
				System.out.println("\n--- 학생 관리 프로그램 ---\n");
				System.out.println("1. 학생 정보 추가");
				System.out.println("2. 학생 전체 조회");
				System.out.println("3. 학생 정보 수정");
				System.out.println("4. 학생 정보 제거");
				System.out.println("5. 학생 이름 검색");
				System.out.println("6. 학생 주소 검색");
				System.out.println("7. 학년별 조회");
				System.out.println("8. 성별 조회");
				System.out.println("9. 성적 순서 조회");
				System.out.println();
				
				System.out.println("0. 프로그램종료");

				System.out.print("메뉴 선택 >> ");
				
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼에 남은 개행문자 제거
				
				System.out.println();
				
				switch(input) {
				case 1 : addStudent(); break;
				case 2 : break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 7 : break;
				case 8 : break;
				case 9 : break;
				case 0 : System.out.println("[프로그램 종료]"); break;
				default : System.out.println("[잘못 입력하셨습니다]");
				}
				
			}catch (InputMismatchException e) {
				System.out.println("[잘못된 형식의 입력입니다.]");
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 내용 제거
				input = -1; // 반복문이 종료 되는 것을 방지
			}
			
			System.out.println();
		}while(input != 0);
		
		
	}
	
	
	/**
	 * 학생 추가하기
	 */
	private void addStudent() {
		System.out.println("\n--- 학생 정보 추가---\n");
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int classRoom  = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().toUpperCase().charAt(0);
		// String.toUpperCase() : 모두 대문자로 변경
		// String.toLowerCase() : 모두 소문자로 변경
		
		System.out.print("성적 : ");
		int score = sc.nextInt();
		
		Student std = new Student(name, grade, classRoom, number,
									address, gender, score);
		
		if(service.addStudent(std)) {
			System.out.println("[학생 정보가 추가되었습니다.]");
		}
		
	}
	
	
	
}
