package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {

		int[] arr = new int[9];

		int sum = 0;

		for (int i = 0; i < 9; i++) {

			arr[i] = i + 1;

			System.out.print(arr[i] + " ");

			if (i % 2 == 0) {
				sum += arr[i];
			}

		}

		System.out.println();

		System.out.println("짝수 번째 인덱스 합 : " + sum);

	}

	public void practice2() {

		int[] arr = new int[9];

		int sum = 0;

		for (int i = 0; i < 9; i++) {

			arr[i] = i + 1;

			System.out.print(arr[i] + " ");

			if (i % 2 == 1) {
				sum += arr[i];
			}

		}

		System.out.println();

		System.out.println("짝수 번째 인덱스 합 : " + sum);

	}

	public void practice3() {

		Scanner sc = new Scanner(System.in);

		boolean positiveCheck = true;

		while (positiveCheck) {
			System.out.print("양의 정수 : ");
			int size = sc.nextInt();

			if (size < 0) {
				System.out.println("입력하신 정수가 음수입니다. 양의 정수를 입력해주세요");
			} else {
				positiveCheck = false;
			}

			int[] arr = new int[size];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = i + 1;
			}

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}

		}

	}

	public void practice4() {

		int[] arr = new int[5];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {

			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}

		boolean isSearch = false;

		System.out.print("검색할 값 : ");
		int searchValue = sc.nextInt();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == searchValue) {
				isSearch = true;
				System.out.printf("인덱스 : %d", i);
				break;
			}
		}

		if (isSearch == false) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String inputString = sc.next();

		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);

		int size = inputString.length();

		char[] arr = new char[size];

		int count = 0;

		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : ", inputString, ch);

		for (int i = 0; i < size; i++) {

			arr[i] = inputString.charAt(i);

			if (arr[i] == ch) {
				System.out.print(i + " ");
				count++;
			}
		}

		System.out.println();

		System.out.printf("i 개수 : %d", count);

	}

	public void practice6() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 : ");
		int size = sc.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {

			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();

		}

		int sum = 0;

		for (int i = 0; i < size; i++) {

			System.out.print(arr[i] + " ");
			sum += arr[i];

		}

		System.out.println();

		System.out.println("총 합 : " + sum);

	}

	public void practice7() {

		Scanner sc = new Scanner(System.in);

		System.out.print("주민등록번호(- 포함) : ");
		String personalNumber = sc.next();

		int size = personalNumber.length();

		char[] arr = new char[size];

		for (int i = 0; i < size; i++) {
			if (i < 8) {
				arr[i] = personalNumber.charAt(i);
			} else {
				arr[i] = '*';
			}
		}

		for (int i = 0; i < size; i++) {
			System.out.print(arr[i]);
		}

	}

	public void practice8() {

		Scanner sc = new Scanner(System.in);

		boolean inputCheck = true;

		System.out.print("정수 : ");
		int size = sc.nextInt();

		while (inputCheck) {
			if (size < 3 || size % 2 != 1) {
				System.out.println("다시 입력하세요");
				System.out.print("정수 : ");
				size = sc.nextInt();
			} else {
				inputCheck = false;
			}
		}

		int[] arr = new int[size];

		int index = 0;

		for (int i = 0; i < (size + 1) / 2; i++) {

			arr[index] = i + 1;

			System.out.print(arr[index] + ", ");

			index++;

		}

		for (int i = (size - 1) / 2; i > 0; i--) {

			if (i == 1) {

				arr[index] = i;

				System.out.print(arr[index]);

			} else {

				arr[index] = i;

				System.out.print(arr[index] + ", ");

				index++;
			}
		}

	}

	public void practice9() {

		int[] arr = new int[10];

		System.out.print("발생한 난수 : ");

		for (int i = 0; i < arr.length; i++) {

			arr[i] = (int) ((Math.random() * 9) + 1);

			System.out.print(arr[i] + " ");

		}

	}

	public void practice10() {

		int[] arr = new int[10];

		System.out.print("발생한 난수 : ");

		for (int i = 0; i < arr.length; i++) {

			arr[i] = (int) ((Math.random() * 9) + 1);

			System.out.print(arr[i] + " ");

		}

		int max = 0;
		int min = 11;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}

			if (arr[i] < min) {
				min = arr[i];
			}

		}

		System.out.println();

		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);

	}

	public void practice11() {

		int[] arr = new int[10];

		int[] pickArr = new int[10];

		for (int i = 0; i < pickArr.length; i++) {

			pickArr[i] = i + 1;

		}

		int randomNumber = 0;

		int checkSum = 0;

		boolean check = false;

		while (!check) {
			randomNumber = (int) ((Math.random() * 10));

			if (pickArr[randomNumber] == 0) {
				continue;
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0) {
					arr[i] = pickArr[randomNumber];
					pickArr[randomNumber] = 0;
					break;
				}
			}

			for (int i = 0; i < arr.length; i++) {
				checkSum += pickArr[i];
			}

			if (checkSum == 0) {
				check = true;
			} else {
				checkSum = 0;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public void practice12() {
		// 1~45
		int[] arr = new int[6];

		int[] pickArr = new int[45];

		for (int i = 0; i < pickArr.length; i++) {

			pickArr[i] = i + 1;

		}

		int randomNumber = 0;

		int checkCounter = 0;

		boolean check = false;

		while (!check) {
			randomNumber = (int) ((Math.random() * 45));

			if (pickArr[randomNumber] == 0) {
				continue;
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0) {
					arr[i] = pickArr[randomNumber];
					pickArr[randomNumber] = 0;
					break;
				}
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					checkCounter++;
				}
			}

			if (checkCounter == 6) {
				check = true;
			} else {
				checkCounter = 0;
			}

		}
		// -> 여기까지가 중복없이 뽑기 arr에 저장

		// 아래부터가 sort 하기

		int[] sortedArr = new int[6];

		int sortIndex = 0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					sortIndex++;
				}
			}

			sortedArr[sortIndex] = arr[i];

			sortIndex = 0;
		}

		for (int i = 0; i < sortedArr.length; i++) {
			System.out.print(sortedArr[i] + " ");

		}

	}

	public void practice13() {

		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String inputString = sc.next();

		char[] arr = new char[inputString.length()];

		for (int i = 0; i < inputString.length(); i++) {

			arr[i] = inputString.charAt(i);

		}

		char[] sortToZero = new char[arr.length];
		
		for (int i = 0; i < arr.length; i++) {

			sortToZero[i] = arr[i];
			
			for (int j = 0; j < sortToZero.length; j++) {
				if (i != j) {
					if (sortToZero[i] == sortToZero[j]) {
						sortToZero[i] = 0;
					}
				}
			}

		}
		
		int countChar = sortToZero.length;
		
		System.out.print("문자열에 있는 문자 : ");
		for (int i = 0; i < sortToZero.length ; i ++) {
			if(sortToZero[i] == 0) {
				countChar--;
				continue;
			}
			System.out.print(sortToZero[i] + " ");
			
		}
		
		System.out.println();
		
		System.out.println("문자 개수 : " + countChar);
		

	}

	
	public void practice14() {
		
		
		
		
		
	}
	
	
	
	
	
}
