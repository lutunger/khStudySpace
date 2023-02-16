package edu.kh.array.practice;

import java.util.Arrays;
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
		for (int i = 0; i < sortToZero.length; i++) {
			if (sortToZero[i] == 0) {
				countChar--;
				continue;
			}
			System.out.print(sortToZero[i] + " ");

		}

		System.out.println();

		System.out.println("문자 개수 : " + countChar);

	}

	public void practice14() {

		Scanner sc = new Scanner(System.in);

		System.out.print("배열의 크기를 입력하세요 : ");
		int askSize = sc.nextInt();

		String[] originArr = new String[askSize];

		sc.nextLine();

		int index = 1;

		for (int i = 0; i < originArr.length; i++) {
			System.out.printf("%d번째 문자열 : ", (i + 1));
			originArr[i] = sc.nextLine();
			index++;
		}

		boolean addChecker = false;

		char yesOrNo = ' ';

		int sizeSum = askSize;

		int wannaAddNumber = 0;

		while (!addChecker) {

			System.out.print("더 값을 입력하시겠습니까?(Y/N)");
			yesOrNo = sc.next().charAt(0);

			if (yesOrNo == 'y') {

				System.out.print("더 입력하고 싶은 개수 : ");

				wannaAddNumber = sc.nextInt();

				sizeSum += wannaAddNumber;

				sc.nextLine();

				String[] resultArr = new String[sizeSum];

				for (int i = 0; i < originArr.length; i++) {

					resultArr[i] = originArr[i];

				}

				for (int i = 0; i < wannaAddNumber; i++) {

					System.out.printf("%d번째 문자열 : ", index);

					resultArr[index - 1] = sc.nextLine();

					index++;

				}

				originArr = resultArr;

			} else if (yesOrNo == 'n') {

				break;

			} else {
				continue;
			}
			continue;
		}

		for (int i = 0; i < originArr.length; i++) {

			if (i == 0) {
				System.out.printf("[%s, ", originArr[i]);
			} else if (i == originArr.length - 1) {
				System.out.printf("%s]", originArr[i]);
			} else {
				System.out.printf("%s, ", originArr[i]);
			}

		}

	}

	public void practice15() {

		String[][] arr = new String[3][3];

		Scanner sc = new Scanner(System.in);

		String value = " ";

		for (int row = 0; row < arr.length; row++) {

			for (int column = 0; column < arr[row].length; column++) {

				value = String.format("(%d, %d)", row, column);

				arr[row][column] = value;

				System.out.print(arr[row][column]);

			}

			System.out.println();

		}

	}

	public void practice16() {

		int[][] arr = new int[4][4];

		int count = 1;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = count;

				count++;

				System.out.printf("%3d", arr[i][j]);

			}

			System.out.println();
		}

	}

	public void practice17() {

		int[][] arr = new int[4][4];

		int count = 16;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = count;

				count--;

				System.out.printf("%3d", arr[i][j]);

			}

			System.out.println();

		}

	}

	public void practice18() {

		int[][] arr = new int[4][4];

		int rowSum = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				if (j == arr[i].length - 1) {
					arr[i][j] = rowSum;
					rowSum = 0;
				} else {
					arr[i][j] = (int) ((Math.random() * 10) + 1);
					rowSum += arr[i][j];
				}

			}

		}

		for (int lastColumn = 0; lastColumn < arr.length; lastColumn++) {

			for (int referenceData = 0; referenceData < arr.length - 1; referenceData++) {

				arr[arr.length - 1][lastColumn] += arr[referenceData][lastColumn];

			}

		}

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				System.out.printf("%3d", arr[i][j]);

			}

			System.out.println();

		}

	}

	public void practice19() {

		Scanner sc = new Scanner(System.in);

		System.out.print("행 크기 : ");
		int rowSize = sc.nextInt();

		while (!(rowSize >= 1 && rowSize <= 10)) {

			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");

			System.out.print("행 크기 : ");
			rowSize = sc.nextInt();

		}

		System.out.print("열 크기 : ");
		int columnSize = sc.nextInt();

		while (!(columnSize >= 1 && columnSize <= 10)) {

			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");

			System.out.print("행 크기 : ");
			columnSize = sc.nextInt();

		}

		char[][] arr = new char[rowSize][columnSize];

		char ch = ' ';

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				ch = (char) ((int) ((Math.random() * 26) + 65));
				arr[i][j] = ch;

				System.out.printf("%2c", arr[i][j]);

			}

			System.out.println();

		}

	}

	public void practice20() {

		Scanner sc = new Scanner(System.in);

		System.out.print("행의 크기 : ");
		int rowSize = sc.nextInt();

		char ch = 'a';

		char[][] arr = new char[rowSize][];

		int[] sizeStoreOfRow = new int[rowSize];

		for (int i = 0; i < arr.length; i++) {

			System.out.printf("%d열의 크기 : ", i);
			sizeStoreOfRow[i] = sc.nextInt();

			arr[i] = new char[sizeStoreOfRow[i]];

		}

		for (int row = 0; row < arr.length; row++) {

			for (int column = 0; column < arr[row].length; column++) {

				arr[row][column] = ch;
				ch++;

				System.out.printf("%2c", arr[row][column]);
			}
			System.out.println();

		}

	}

	public void practice21() {

		String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

		int index = 0;

		String[][] arr1 = new String[3][2];

		String[][] arr2 = new String[3][2];

		System.out.println("== 1분단 ==");

		for (int i = 0; i < arr1.length; i++) {

			for (int j = 0; j < arr1[i].length; j++) {

				arr1[i][j] = students[index];
				index++;
				System.out.printf("%s  ", arr1[i][j]);
			}

			System.out.println();

		}

		System.out.println("== 2분단 ==");

		for (int i = 0; i < arr2.length; i++) {

			for (int j = 0; j < arr2[i].length; j++) {

				arr2[i][j] = students[index];
				index++;
				System.out.printf("%s  ", arr2[i][j]);
			}

			System.out.println();

		}

	}

	public void practice22() {

		Scanner sc = new Scanner(System.in);

		String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

		int index = 0;

		String[][] arr1 = new String[3][2];

		String[][] arr2 = new String[3][2];

		System.out.println("== 1분단 ==");

		for (int i = 0; i < arr1.length; i++) {

			for (int j = 0; j < arr1[i].length; j++) {

				arr1[i][j] = students[index];
				index++;
				System.out.printf("%s  ", arr1[i][j]);
			}

			System.out.println();

		}

		System.out.println("== 2분단 ==");

		for (int i = 0; i < arr2.length; i++) {

			for (int j = 0; j < arr2[i].length; j++) {

				arr2[i][j] = students[index];
				index++;
				System.out.printf("%s  ", arr2[i][j]);
			}

			System.out.println();

		}

		System.out.println("=============================");

		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String searchFor = sc.next();

		boolean isSearch = false;

		int section = 0;
		int row = 0;
		String side = " ";

		while (!isSearch) {

			for (int i = 0; i < arr1.length; i++) {

				for (int j = 0; j < arr1[i].length; j++) {

					if (searchFor.equals(arr1[i][j])) {
						section = 1;
						row = i + 1;
						if (j == 0) {
							side = "왼쪽";
						} else {
							side = "오른쪽";
						}
						isSearch = true;
						break;
					}

				}
				if (isSearch) {
					break;
				}

			}

			for (int i = 0; i < arr2.length; i++) {

				for (int j = 0; j < arr2[i].length; j++) {

					if (searchFor.equals(arr2[i][j])) {
						section = 2;
						row = i + 1;
						if (j == 0) {
							side = "왼쪽";
						} else {
							side = "오른쪽";
						}
						isSearch = true;
						break;
					}

				}
				if (isSearch) {
					break;
				}

			}

		}

		System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.", searchFor, section, row, side);

	}

	public void practice23() {

		Scanner sc = new Scanner(System.in);

		String[][] arr = new String[6][6];

		System.out.print("행 인덱스 입력 : ");
		int rowIndex = sc.nextInt();

		System.out.print("열 인덱스 입력 : ");
		int columnIndex = sc.nextInt();

		for (int row = 0; row < arr.length; row++) {

			for (int column = 0; column < arr[row].length; column++) {
				if (row == 0 && column == 0) {
					arr[row][column] = " ";
					System.out.printf("%2s", arr[row][column]);
				} else if (row == 0) {
					arr[row][column] = String.format("%d", (column - 1));
					System.out.printf("%2s", arr[row][column]);
				} else if (column == 0) {
					arr[row][column] = String.format("%d", (row - 1));
					System.out.printf("%2s", arr[row][column]);
				} else if ((row == rowIndex + 1) && (column == columnIndex + 1)) {
					arr[row][column] = "X";
					System.out.printf("%2s", arr[row][column]);
				} else {
					arr[row][column] = " ";
					System.out.printf("%2s", arr[row][column]);
				}

			}
			System.out.println();

		}
	}

	public void practice24() {

		Scanner sc = new Scanner(System.in);

		String[][] arr = new String[6][6];

		for (int row = 0; row < arr.length; row++) {
			for (int column = 0; column < arr[row].length; column++) {
				if (row == 0 && column == 0) {
					arr[row][column] = " ";
				} else if (row == 0) {
					arr[row][column] = String.format("%d", (column - 1));
				} else if (column == 0) {
					arr[row][column] = String.format("%d", (row - 1));
				} else {
					arr[row][column] = " ";
				}
			}
		}

		int rowIndex = -1;

		int columnIndex = -1;

		boolean isEnd = false;

		while (!isEnd) {

			System.out.print("행 인덱스 입력 : ");
			rowIndex = sc.nextInt();

			if (rowIndex == 99) {
				System.out.println("프로그램 종료");
				break;
			}

			System.out.print("열 인덱스 입력 : ");
			columnIndex = sc.nextInt();

			for (int row = 0; row < arr.length; row++) {

				for (int column = 0; column < arr[row].length; column++) {
					if (row == 0 && column == 0) {
						System.out.printf("%2s", arr[row][column]);
					} else if (row == 0) {
						System.out.printf("%2s", arr[row][column]);
					} else if (column == 0) {
						System.out.printf("%2s", arr[row][column]);
					} else if ((row == rowIndex + 1) && (column == columnIndex + 1)) {
						arr[row][column] = "X";
						System.out.printf("%2s", arr[row][column]);
					} else {
						System.out.printf("%2s", arr[row][column]);
					}

				}
				System.out.println();

			}

		}
	}

	public void bingoGame() {

		Scanner sc = new Scanner(System.in);

		System.out.print("빙고판 크기 지정 : ");
		int size = sc.nextInt();

		String[][] arr = new String[size][size];

		String[] numberGroup = new String[size * size];
		for (int i = 0; i < numberGroup.length; i++) {
			numberGroup[i] = String.format("%d", i + 1);
		}

		for (int row = 0; row < arr.length; row++) {

			for (int column = 0; column < arr[row].length; column++) {

				if (arr[row][column] == null) {

					int random = (int) (Math.random() * numberGroup.length);

					if (numberGroup[random] != "0") {

						arr[row][column] = numberGroup[random];

						numberGroup[random] = "0";

						System.out.printf("%4s", arr[row][column]);

					} else {

						column -= 1;

					}

				}

			}
			System.out.println();
		}

		System.out.println("===============빙고게임 시작===============");

		String searchValue = " ";

		boolean bingo = false;

		int[] bingoCheckerOfRow = new int[arr.length];
		int[] bingoCheckerOfColumn = new int[arr[0].length] ;
		int[] bingoCheckerOfDiagonal = new int[2];
		int bingoCounter = 0;
		// diagonal[0]은 arr[i][j]가 i++,j++로 되는 대각선, 
		// diagonal[1]은 arr[i][j]가 i--,j--로 되는 대각선
		
		boolean valueChecker = false;
		
		while (!bingo) {

			System.out.print("정수를 입력하시오 : ");

			searchValue = sc.next();
			
			while(!valueChecker) {
				
				
				for(int row = 0; row <arr.length; row++) {
					for(int column = 0; column <arr[row].length; column++) {
						if(arr[row][column].equals(searchValue)) {
							valueChecker = true;
							
						}
					}
					
				}
				
				if(!valueChecker) {
					System.out.print("다시 입력해주세요 : ");

					searchValue = sc.next();
					
				}
				
			}
			valueChecker = false;
	
			for (int row = 0; row < arr.length; row++) {

				for (int column = 0; column < arr[row].length; column++) {

					if (arr[row][column].equals(searchValue)) {

						arr[row][column] = "★";
						
						bingoCheckerOfRow[row]++; 
						bingoCheckerOfColumn[column]++;
						
						if(row == column) {
							bingoCheckerOfDiagonal[0]++;
						}
						
						if(arr[row].length - 1 == row + column) {
							bingoCheckerOfDiagonal[1]++;
						}
						

						System.out.printf("%4s", arr[row][column]);
						
						

					} else {

						System.out.printf("%4s", arr[row][column]);

					}

				}

				System.out.println();
				
			}
			
			

			for(int i = 0; i < bingoCheckerOfRow.length ; i++) {
				
				if(bingoCheckerOfRow[i] == arr.length) {
					bingoCounter++;
				}
				
			}
			
			for(int i = 0; i < bingoCheckerOfColumn.length ; i++) {
				
				if(bingoCheckerOfColumn[i] == arr[i].length) {
					bingoCounter++;
				}
				
			}
			
			for(int i = 0; i < bingoCheckerOfDiagonal.length ; i++) {
				
				if(bingoCheckerOfDiagonal[i] == arr.length) {
					bingoCounter++;
				}
				
			}
			
			if(bingoCounter >= 3) {
				bingo = true;
			}
			
			
			
			System.out.printf("현재 %d 빙고", bingoCounter);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			bingoCounter = 0;
		}

		System.out.println("***** BINGO!!! *****");
		
	}
	
	
	
}