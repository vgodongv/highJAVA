package collectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
  ����) �й�(int), �̸�(String), ��������, ��������, ��������, ����, ����� ����� ���� StudentŬ������ �����.
  
           �� Ŭ������ �����ڿ����� �й�,�̸�, ��������, ��������, ���������� �Ű������� �޾Ƽ� �ʱ�ȭ ó���� �Ѵ�.
           
           �� Student ��ü�� List�� �����Ͽ� �����Ѵ�.
           
      List�� ����� ������(Student)�� �й��� ������������ ������ �� �ִ� ���� ���� ������ �����Ѵ�. 
      
            �׸��� ������ ����(��������?)���� �����ϴµ� ������ ������ �̸��� ������������ ������ �� �� �ִ� �ܺ� ���� ���� Ŭ������ �ۼ��Ѵ�.
            
      (��, ����� List�� ��ü �����Ͱ� �߰��� �Ŀ� ����ǵ��� �Ѵ�. ������)
         
           �� ���� ���ؿ� ���� ���ĵǴ� ���α׷��� �ۼ��Ͻÿ�
        
 */

public class StudentTest {
	
	// ����� ���ϴ� �޼���
	public void setRanking(ArrayList<Student> studentlist){
		for(Student std1 : studentlist){ //���� �����͸� ���ϴ� �ݺ���
			 int rank = 1; //ó������ 1������ �����س��� �����Ѵ�.
			 
			 for(Student std2:studentlist ){ //�� ����� ���ϴ� �ݺ���
				 if(std1.getSum() <std2.getSum()){ 
					 rank++; //�񱳴���� �� ũ�� rank���� ������Ų��.
				 }
			 }
			 
			 std1.setRank(rank);
		}
	}

	public static void main(String[] args) {
		ArrayList<Student> studentlist = new ArrayList<>();
		
		StudentTest stdTest = new StudentTest();
		
		studentlist.add(new Student(20180359, "����",100,100,100)); //new Student() = Student ��ü
		studentlist.add(new Student(10180369, "������",50,50,60));
		studentlist.add(new Student(20170369, "�ٺ�",50,60,50));
		studentlist.add(new Student(10190369, "�ٺ���",50,50,50));
		
		// ����� ���ϴ� �޼��� ȣ��
		stdTest.setRanking(studentlist);
		
		System.out.println("[������]");
		for(Student st : studentlist){
			System.out.println(st);
		}
		System.out.println("------------------------------------");
		
		
		//�й��� ������������ �����ϱ�
		Collections.sort(studentlist);
		System.out.println("[�й� �������� ������]");
		for(Student mem : studentlist){
			System.out.println(mem);
		}
				

	System.out.println("------------------------------------");
	Collections.sort(studentlist, new sumDesc());
	System.out.println("[���� �������� ������ & �̸� �������� ����]");
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
	private int rank; //�� private?
	
	public Student(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		sum= kor + eng + mat;
	}
	
	// getter �Լ��� �����Ͽ� �ܺο��� �� ��� ������ ������ �� �ֵ��� ����. �������������
	
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
		
		return Integer.compare(this.getNum(),o.getNum()); //�����ȣ�� �Ű������� ������ ��ȣ�� ��. copare�⺻���� ��������
	}

}

class sumDesc implements Comparator<Student>{

	@Override
	public int compare(Student sum1, Student sum2) { //�����հ� �������� �̸� ��������

		if(sum1.getSum()>sum2.getSum()){
			return -1; //�ٲ۴�.
		}else if(sum1.getSum()<sum2.getSum()){
			return 1; //�ٲ����ʴ´�.
		}else{
			if(sum1.getSum()>sum2.getSum()){
				return 1; //�ٲ����ʴ´�.
			}else if(sum1.getSum()<sum2.getSum()){
				return -1; //�ٲ۴�.
			}else{
				return 0;
			}
			
//			if(sum1.getSum()==sum2.getSum()){
//				return sum1.getName().compareTo(sum2.getName());
//			}
		}

	}

}



