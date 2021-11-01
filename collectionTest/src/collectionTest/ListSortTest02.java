package collectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1,"ȫ�浿", "010-1111-1111"));
		memList.add(new Member(5,"�̼���", "010-2222-1111"));
		memList.add(new Member(9,"������", "010-3333-1111"));
		memList.add(new Member(3,"������", "010-4444-1111"));
		memList.add(new Member(6,"������", "010-5555-1111"));
		memList.add(new Member(2,"���е�", "010-6666-1111"));
		
		System.out.println("[������]");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("------------------------------------");

		Collections.sort(memList);
		
		System.out.println("[������]");
		for(Member mem : memList){
			System.out.println(mem);
		}
		
		System.out.println("------------------------------------");
		Collections.sort(memList, new SortNumDesc());
		System.out.println("[ȸ����ȣ�� �������� ������]");
		for(Member mem : memList){
			System.out.println(mem);
		}
		
	}

}

// Member Ŭ������ ȸ���̸��� �������� �������� ������ �ǵ��� 
// ���� ���� ���� �߰��ϱ�: Comparable �������̽��� �����Ѵ�.

class Member implements Comparable<Member>{ //ȸ������ Ŭ���� 
	private int num; //ȸ����ȣ
	private String name;
	private String tel;
	
	// alt+shift+s ������ ������ �ڵ�����
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}
	

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	// ���� ���� ������ �����ϴ� �޼��� �����ϱ�
	// (ȸ�� �̸��� �������� ���� ����)
	
	@Override
	public int compareTo(Member mem) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(mem.getName());
		
	}
	
}

//MemberŬ������ ȸ����ȣ(num)�� �������� ���������Ǵ� 
//�ܺ����ı��� class�� �ۼ��Ͻÿ�.

class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		
		/*if(mem1.getNum()>mem2.getNum()){
		 
			return -1;
		}else if(mem1.getNum()<mem2.getNum()){
			return 1;
		}else{
			return 0;
		}
		*/
		
		//WrapperŬ������ �̿��ϴ� ���
		//return new Integer(mem1.getNum()).compareTo(mem2.getNum())* -1;
		
		//WrapperŬ������ �̿��ϴ� ���2
		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
		
	}

}