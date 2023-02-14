package edu.kh.array.practice;

public class ArrayPractice {
	
	public void practice1() {
		
		int[] arr = new int[9];
		
		int sum = 0;
		
		for(int i = 0 ; i < 9 ; i ++) {
			
			arr[i] = i+1;
			
			System.out.print(arr[i] + " ");
			
			if(i % 2 == 0) {
				sum += arr[i];
			}
			
		}
		
		System.out.println();
		
		System.out.println("짝수 번째 인덱스 합 : " + sum);
		
		
	}
	
	
}
