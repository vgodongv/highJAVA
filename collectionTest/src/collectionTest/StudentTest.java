package collectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
  문제) 학번(int), 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
  
           이 클래스의 생성자에서는 학번,이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
           
           이 Student 객체는 List에 저장하여 관리한다.
           
      List에 저장된 데이터(Student)는 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현한다. 
      
            그리고 총점의 역순(내림차순?)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 될 수 있는 외부 정렬 기준 클래스를 작성한다.
            
      (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다. 응안해)
         
           위 정렬 기준에 맞춰 정렬되는 프로그램을 작성하시오
        
 */

public class StudentTest {
	
	// 등수를 구하는 메서드
	public void setRanking(ArrayList<Student> studentlist){
		for(Student std1 : studentlist){ //기준 데이터를 구하는 반복문
			 int rank = 1; //처음에는 1등으로 설정해놓고 시작한다.
			 
			 for(Student std2:studentlist ){ //비교 대상을 구하는 반복문
				 if(std1.getSum() <std2.getSum()){ 
					 rank++; //비교대상이 더 크면 rank값을 증가시킨다.
				 }
			 }
			 
			 std1.setRank(rank);
		}
	}

	public static void main(String[] args) {
		ArrayList<Student> studentlist = new ArrayList<>();
		
		StudentTest stdTest = new StudentTest();
		
		studentlist.add(new Student(20180359, "고동자",100,100,100)); //new Student() = Student 객체
		studentlist.add(new Student(10180369, "조슥경",50,50,60));
		studentlist.add(new Student(20170369, "바보",50,60,50));
		studentlist.add(new Student(10190369, "바보보",50,50,50));
		
		// 등수를 구하는 메서드 호출
		stdTest.setRanking(studentlist);
		
		System.out.println("[정렬전]");
		for(Student st : studentlist){
			System.out.println(st);
		}
		System.out.println("------------------------------------");
		
		
		//학번의 오름차순으로 정렬하기
		Collections.sort(studentlist);
		System.out.println("[학번 오름차순 정렬후]");
		for(Student mem : studentlist){
			System.out.println(mem);
		}
				

	System.out.println("------------------------------------");
	Collections.sort(studentlist, new sumDesc());
	System.out.println("[점수 내림차순 정렬후 & 이름 오름차순 정렬]");
		for(Student mem : studentlist){
			System.out.println(mem);
		}
		
	}
}


class Student implements Comparable<Student> {
	
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	private int rank; //왜 private?
	
	public Student(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		sum= kor + eng + mat;
	}
	
	// getter 함수를 구현하여 외부에서 각 멤버 변수에 접근할 수 있도록 구현. 멤버변수가뭐냐
	
	public int getNum() {
		return num;
	}
	
	public int getSum() {
		return sum;
	}


	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}


	public int getMat() {
		return mat;
	}
	
	
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor
				+ ", eng=" + eng + ", mat=" + mat + ", sum="+sum+",  rank="+rank+"]";
	}



	@Override
	public int compareTo(Student o) {
		
		return Integer.compare(this.getNum(),o.getNum()); //현재번호와 매개변수로 가져온 번호와 비교. copare기본값이 오름차순
	}

}

class sumDesc implements Comparator<Student>{

	@Override
	public int compare(Student sum1, Student sum2) { //점수합계 내림차순 이름 오름차순

		if(sum1.getSum()>sum2.getSum()){
			return -1; //바꾼다.
		}else if(sum1.getSum()<sum2.getSum()){
			return 1; //바꾸지않는다.
		}else{
			if(sum1.getSum()>sum2.getSum()){
				return 1; //바꾸지않는다.
			}else if(sum1.getSum()<sum2.getSum()){
				return -1; //바꾼다.
			}else{
				return 0;
			}
			
//			if(sum1.getSum()==sum2.getSum()){
//				return sum1.getName().compareTo(sum2.getName());
//			}
		}

	}

}



