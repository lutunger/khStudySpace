package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;

import edu.kh.collection.list.dto.Student;

public class StudentService {
	
	private List<Student> studentList = new ArrayList<Student>();
	
	public StudentService() {
		
		studentList.add(new Student("홍길동", 3, 5, 17, "서울시 중구 남대문로", 'M', 75));
		studentList.add(new Student("갑돌이", 2, 8, 11, "서울시 영등포구 시청", 'M', 85));
		studentList.add(new Student("둘리", 6, 5, 23, "깐따삐야 별", 'M', 120));
		studentList.add(new Student("또치", 4, 2, 5, "콜롬비야 별", 'M', 11));
		studentList.add(new Student("영심이", 5, 8, 19, "서울 한남동", 'F', 90));
		
		
	}
	
	/** studentList에 학생 추가
	 * @param std
	 * @return true
	 */
	public boolean addStudent(Student std) {
		return studentList.add(std);
	}
	
}
