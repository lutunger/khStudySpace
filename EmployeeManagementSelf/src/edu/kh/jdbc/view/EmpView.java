package edu.kh.jdbc.view;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Emp;
import edu.kh.jdbc.model.service.EmpService;

public class EmpView {
  
	private Scanner sc = new Scanner(System.in);
	
	private EmpService service = new EmpService();
	
	//** 모든 기능에는 예외상황에 따른 출력 구문 필수 작성 **
	//** 필요에 따라 DTO에 생성자 추가 **
	//** 메서드명, 출력 화면은 자유롭게 작성 **
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n*****************************\n");
				System.out.println("***** 사원 관리 프로그램*****");
				
				System.out.println("1. 재직중인 사원 전체 조회"); 
				// 현재 재직중인 사원의
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
				// 직급코드 오름차순으로 조회
				
				
				System.out.println("2. 퇴직한 사원 전체 조회"); 
				// 현재 퇴직한 사원의
				// 사번, 이름, 전화번호, 이메일, 퇴사일을
				// 퇴사일 오름차순으로 조회
				
				
				System.out.println("3. 사번이 일치하는 사원 조회"); 
				// 사번을 입력 받아 일치하는 사원의  
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력
				
				
				System.out.println("4. 사원 정보 추가(INSERT)");
				// 사번(EMP_ID) -> SEQ_EMP_ID SEQUENCE 사용
				
				
				System.out.println("5. 사번으로 사원 정보 수정(UPDATE)");
				// 이메일, 전화번호, 급여, 보너스 수정
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력

				
				System.out.println("6. 사번으로 사원 정보 삭제(DELETE)");
				// 사번을 입력 받아 일치하는 사원 삭제
				// - 사번을 입력 받은 후 정말 삭제할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 삭제, N인 경우 취소
				// - 사번이 일치하는 사원이 없으면
				//   "사번이 일치하는 사원이 없습니다" 출력
				
				
				System.out.println("7. 사번이 일치하는 사원 퇴직 처리");
				// - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
				
				// - 사번을 입력 받은 후 정말 퇴직 처리할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 퇴직 처리, N인 경우 취소
				
				// - 사번이 일치하지 않거나 이미 퇴직 처리된 사원이면
				//   "사번이 일치하는 않거나, 이미 퇴직된 사원입니다." 출력
				
				System.out.println("8. 가장 최근 입사한 사원 5명 조회");
				
				// 가장 최근(입사일이 늦은) 사원 5명의
				// 사번, 이름, 부서명, 입사일을
				// 입사일 내림차순으로 조회
				
				
				System.out.println("9. 부서별 통계 조회"); 
				// 각 부서별
				// 부서명, 인원 수, 급여 평균
				// 부서코드 오름차순 조회
				
				// 자바쪽으로 어떻게 처리할것인가에 대한 문제를 생각해 보아야 한다...
				// HINT.
				// - 별도의 DTO 작성 또는 
				//   Map(LinkedHashMap : key 순서가 유지되는 Map) 이용
				
				
				System.out.println("0. 프로그램 종료");
				
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				
				
				switch(input) {
				case 1:  selectAll(); break;
				case 2:  selectRetire(); break;
				case 3:  selectEmpId(); break;
				case 4:  insertEmp(); break;
				case 5:  updateEmp(); break;
				case 6:  deleteEmp(); break;
				case 7:  updateRetire(); break;
				case 8:  selectNewcomer(); break;
				case 9:  selectDeptAvg(); break;
				case 0: System.out.println("\n[프로그램을 종료합니다...]\n"); break;
				
				default: System.out.println("\n[메뉴에 존재하는 번호를 입력하세요.]\n");
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다.]\n");
				sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거
				input = -1; // while문이 종료되지 않게하기 위한 값 대입
			}
			
		}while(input != 0);
		
	}

	/** 1. 재직중인 사원 전체 조회
	 * // 현재 재직중인 사원의
		// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
		// 직급코드 오름차순으로 조회
	 */
	private void selectAll() {
		
		System.out.println("\n----- 재직중인 전체 사원 조회 -----\n");
		
		try {
			List<Emp> empList = service.selectAll();
			
			if(empList.isEmpty()) {
				System.out.println("[사원이 존재하지 않습니다]");
				return;
			}
			
			for(Emp emp : empList) {
				System.out.printf("%d / %s / %s / %s / %d / %s / %s \n",
									emp.getEmpId(),
									emp.getEmpName(),
									emp.getDepartmentTitle(),
									emp.getJobName(),
									emp.getSalary(),
									emp.getPhone(),
									emp.getEmail()
						);
			}
			
		} catch (SQLException e) {
			System.out.println("\n[사원 전체 정보 조회 중 예외 발생]\n");
			e.printStackTrace();
		}
	}

	
	/** 2. 퇴직한 사원 전체 조회
	 * // 현재 퇴직한 사원의
		// 사번, 이름, 전화번호, 이메일, 퇴사일을
		// 퇴사일 오름차순으로 조회
	 */
	private void selectRetire() {
		
		System.out.println("\n----- 퇴직한 사원 전체 조회 -----\n");
		
		try {
			List<Emp> empList = service.selectRetire();
			
			if(empList.isEmpty()) {
				System.out.println("[사원이 존재하지 않습니다]");
				return;
			}
			
			for(Emp emp : empList) {
				System.out.printf("%d / %s / %s / %s / %s \n",
									emp.getEmpId(),
									emp.getEmpName(),
									emp.getPhone(),
									emp.getEmail(),
									emp.getEntDate()
									);
			}
			
		} catch (SQLException e) {
			System.out.println("\n[퇴직한 사원 전체 조회 중 예외 발생]\n");
			e.printStackTrace();
		}
		
	}

	
	
	/** 3. 사번이 일치하는 사원 조회
	 * // 사번을 입력 받아 일치하는 사원의  
		// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 
		 * 이메일, 입사일, 퇴직여부 조회
		// 단, 사번이 일치하는 사원이 없으면
		// "사번이 일치하는 사원이 없습니다" 출력
	 */
	private void selectEmpId() {
		System.out.println("\n----- 사원 조회(사번) -----\n");
		
		System.out.print("사번 입력: ");
		int input = sc.nextInt();
		
		try {
			Emp emp = service.selectEmpId(input);
			
			if(emp == null) {
				System.out.println("[사번이 일치하는 사원이 없습니다]");
				return;
			}
			
			String isFired = "";
			
			if(emp.getEntYN().toUpperCase().charAt(0) == 'Y'){
				isFired = "퇴사자";
			}else {
				isFired = "재직자";
			}
			
			// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 
//			* 이메일, 입사일, 퇴직여부 조회
			System.out.printf("\n%d / %s / %s / %s / %d / %s / "
								+ "%s / %s / %s\n",
								emp.getEmpId(),
								emp.getEmpName(),
								emp.getDepartmentTitle(),
								emp.getJobName(),
								emp.getSalary(),
								emp.getPhone(),
								emp.getEmail(),
								emp.getHireDate().toString(),
								isFired
										);
			
		} catch (SQLException e) {
			System.out.println("\n[사번으로 사원 조회 중 예외 발생]\n");
			e.printStackTrace();
		}
		
	}

	
	/** 4. 사원 정보 추가(INSERT)
	 * 사번(EMP_ID) -> SEQ_EMP_ID SEQUENCE 사용
	 */
	private void insertEmp() {
		
		System.out.println("----- 사원 추가 -----");
//		private int empId; 		// 사원 번호(사번)
		// -> 시퀀스 자동 설정
		
		
		System.out.print("사원 이름 : ");
		String empName = sc.next();
		
		System.out.print("주민등록번호 : ");
		String empNo = sc.next();
		
		System.out.print("이메일 : ");
		String email = sc.next();

		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		
		System.out.print("부서코드 : ");
		String deptCode = sc.next();

		System.out.print("직급코드 : ");
		String jobCode = sc.next();
		
		System.out.print("급여등급 : ");
		String salLevel = sc.next();
		
		System.out.print("보너스 : ");
		double bonus = sc.nextDouble();

		System.out.print("사수번호 : ");
		int managerId = sc.nextInt();
		
		sc.nextLine();
		
		Emp emp = new Emp(empName, empNo, email, phone, salary, 
						deptCode, jobCode, salLevel, bonus, managerId);
		
		try {
			int result = service.insertEmp(emp);
			
			if(result > 0) {
				System.out.println("[삽입 성공!!!]");
			}else {
				System.out.println("[삽입 실패...]");
			}
			 
		} catch (SQLException e) {
			System.out.println("\n[사원 정보 삽입 중 예외 발생]\n");
			e.printStackTrace();
		}
			
		
	}

	
	
	/** 5. 사번으로 사원 정보 수정(UPDATE)
	 * // 이메일, 전화번호, 급여, 보너스 수정
		// 단, 사번이 일치하는 사원이 없으면
		// "사번이 일치하는 사원이 없습니다" 출력
	 */
	private void updateEmp() {
		
		System.out.println("\n----- 사번으로 사원 정보 수정 -----\n");
		
		System.out.print("수정할 수원의 사번 : ");
		int empId = sc.nextInt();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("급여 :  ");
		int salary = sc.nextInt();
		
		System.out.print("보너스 :  ");
		double bonus = sc.nextDouble();
		sc.nextLine();
		
		Emp emp = new Emp(empId, email, phone, salary, bonus);
		
		try {
			int result = service.updateEmp(emp);
			
			if(result > 0) {
				System.out.println("[수정 성공]");
			}else {
				System.out.println("[사번이 일치하는 사원이 없습니다]");
			}
			
			
		} catch (SQLException e) {
			System.out.println("\n[회원 정보 수정 중 예외 발생]\n");
			e.printStackTrace();
		}
		
	}

	
	
	/** 6. 사번으로 사원 정보 삭제(DELETE)
	 * // 사번을 입력 받아 일치하는 사원 삭제
	// - 사번을 입력 받은 후 정말 삭제할 것인지 Y/N을 입력 받아 
	//   Y인 경우에만 삭제, N인 경우 취소
	// - 사번이 일치하는 사원이 없으면
	//   "사번이 일치하는 사원이 없습니다" 출력
	 */
	private void deleteEmp() {
		System.out.println("\n----- 사번으로 사원 정보 삭제 -----\n");
		
		System.out.print("정보를 삭제할 사원의 사번 입력 : ");
		int input = sc.nextInt();
		
		System.out.print("정말 삭제 하시겠습니까?(Y/N) ");
		char check = sc.next().toUpperCase().charAt(0);
		
		if(check == 'N') {
			System.out.println("[취소되었습니다]");
			return;
		}
		
		if(check != 'Y') {
			System.out.println("[잘못 입력하셨습니다]");
			return;
		}
		
		try {
			int result = service.deleteEmp(input);
			
			if(result > 0) {
				System.out.println("[삭제 성공]");
			}else {
				System.out.println("[사번이 일치하는 사원이 없습니다]");
			}
			
		} catch (SQLException e) {
			System.out.println("\n[삭제 처리 중 예외 발생]\n");
			e.printStackTrace();
		}
		
		
	}

	
	
	/** 7. 사번이 일치하는 사원 퇴직 처리
	 * // - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
				
	// - 사번을 입력 받은 후 정말 퇴직 처리할 것인지 Y/N을 입력 받아 
	//   Y인 경우에만 퇴직 처리, N인 경우 취소
	
	// - 사번이 일치하지 않거나 이미 퇴직 처리된 사원이면
	//   "사번이 일치하는 않거나, 이미 퇴직된 사원입니다." 출력
	 */
	private void updateRetire() {
		
		System.out.println("\n----- 퇴직 처리 -----\n");
		
		System.out.print("사번 입력 : ");
		int input = sc.nextInt();
		
		System.out.print("정말 퇴직 처리하시겠습니까?(Y/N) ");
		char check = sc.next().toUpperCase().charAt(0);
		
		if(check == 'N') {
			System.out.println("[취소되었습니다]");
			return;
		}
			
		if(check != 'Y' ) {
			System.out.println("[잘못입력하셨습니다]");
			return;
		}
		
		try {
			int result = service.updateRetire(input);
			
			if(result > 0 && result != 100) {
				System.out.println("[퇴사처리 되었습니다]");
			}else {
				System.out.println("[사번이 일치하는 않거나, 이미 퇴직된 사원입니다.]");
			}
			
		} catch (SQLException e) {
			System.out.println("[퇴사 처리 과정중 예외 상황 발생]");
			e.printStackTrace();
		}
		
	}

	
	
	
	/** 8. 가장 최근 입사한 사원 5명 조회
	 * // 가장 최근(입사일이 늦은) 사원 5명의
		// 사번, 이름, 부서명, 입사일을
		// 입사일 내림차순으로 조회
	 */
	private void selectNewcomer() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	/** 9. 부서별 통계 조회
	 * // 각 부서별
	// 부서명, 인원 수, 급여 평균
	// 부서코드 오름차순 조회
	
	// 자바쪽으로 어떻게 처리할것인가에 대한 문제를 생각해 보아야 한다...
	// HINT.
	// - 별도의 DTO 작성 또는 
	//   Map(LinkedHashMap : key 순서가 유지되는 Map) 이용
	 */
	private void selectDeptAvg() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
}
