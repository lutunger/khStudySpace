package edu.kh.control.loop.practice;

import java.util.Scanner;

// 실습문제용 클래스
public class ForPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int numberInput = sc.nextInt();

		if (numberInput >= 1) {
			for (int i = 1; i <= numberInput; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}

	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int numberInput = sc.nextInt();

		if (numberInput >= 1) {
			for (int i = numberInput; i >= 1; i--) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}

	}

	public void practice3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 하나 입력하세요 : ");
		int numberInput = sc.nextInt();

		int sum = 0;

		if (numberInput >= 1) {
			for (int i = 1; i <= numberInput; i++) {

				sum += i;

				System.out.print(i + " ");
				if (i < numberInput) {
					System.out.print("+ ");
				} else if (i == numberInput) {
					System.out.print("= ");
				}

			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}

		System.out.print(sum);

	}

	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 숫자 : ");
		int numberInput1 = sc.nextInt();

		System.out.print("두 번째 숫자 : ");
		int numberInput2 = sc.nextInt();

		if (numberInput1 >= 1 && numberInput2 >= 1) {
			if (numberInput1 > numberInput2) {

				for (int i = numberInput2; i <= numberInput1; i++) {
					System.out.print(i + " ");

				}
			} else if (numberInput2 > numberInput1) {

				for (int i = numberInput1; i <= numberInput2; i++) {
					System.out.print(i + " ");
				}

			} else {
				System.out.print(numberInput1);
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
	}

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int numberInput = sc.nextInt();

		System.out.printf("===== %d단 ===== \n", numberInput);
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d \n", numberInput, i, numberInput * i);
		}

	}

	public void practice6() {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int numberInput = sc.nextInt();

		if (numberInput > 9 || numberInput < 2) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		} else {
			for (int j = numberInput; j <= 9; j++) {
				System.out.printf("===== %d단 ===== \n", j);
				for (int i = 1; i <= 9; i++) {
					System.out.printf("%d * %d = %d \n", j, i, j * i);
				}
			}
		}

	}

	public void practice7() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int numberInput = sc.nextInt();

		if (numberInput >= 1) {
			for (int i = 1; i <= numberInput; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}

	}

	public void practice8() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int numberInput = sc.nextInt();

		if (numberInput >= 1) {
			for (int i = numberInput; i >= 1; i--) {
				for (int j = i; j >= 1; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
	}

	public void practice9() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int numberInput = sc.nextInt();

		int count = 0;

		if (numberInput >= 1) {

			for (int i = 1; i <= numberInput; i++) {
				count++;
				for (int j = 1; j <= (numberInput - i); j++) {
					System.out.print(" ");
				}
				for (int k = 1; k <= count; k++) {
					System.out.print("*");
				}
				System.out.println();

			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}

	}

	public void practice10() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int numberInput = sc.nextInt();

		if (numberInput >= 1) {
			for (int i = 1; i <= numberInput; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = (numberInput - 1); i >= 1; i--) {
				for (int j = i; j >= 1; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}

	}

	public void practice11() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int numberInput = sc.nextInt();
		
		int row = 1;
		
		if (numberInput >= 1) {
			for(int i = numberInput ; i >= 1 ; i--) {
				for(int j = 1; j <= (i -1) ; j++) {
					System.out.print(" ");
				}
				for(int k = ((2 * row) - 1); k >= 1  ; k-- ) {
					System.out.print("*");
				}
				System.out.println();
				row++;
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}

	}
	
	
	
	public void practice12() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int numberInput = sc.nextInt();
		
		int row = 1;
		
		if (numberInput >= 1) {
			
			for(int i = 1; i <= numberInput ; i ++) {
				if(row == 1 || row == numberInput) {
					for(int j = 1 ; j <= numberInput ; j++) {
						System.out.print("*");
					}
				}else {
					for(int k = 1 ; k <= numberInput ; k++) {
						if(k == 1 || k == numberInput) {
							System.out.print("*");
						}else {
							System.out.print(" ");
						}
					}
				}
				System.out.println();
				row++;
			}
			
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}

		
	}
	
	
	
	public void practice13() {
		

		Scanner sc = new Scanner(System.in);

		System.out.print("자연수 하나를 입력하세요 : ");
		int numberInput = sc.nextInt();
		
		int count = 0;
		
		if (numberInput >= 1) {
			
			for(int i = 1 ; i <= numberInput ; i++ ) {
				
				if(i % 2 == 0 || i % 3 == 0) {
					System.out.print(i + " ");
				}
				
				if(i % 2 == 0 && i % 3 ==0) {
					count++;
				}
				
			}
			System.out.println();
			System.out.println("count : " + count);
			
			
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}

		
		
		
		
	}
		
	
	
	
	
	

}
