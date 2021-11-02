package collectionTest;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
  ����) �̸�, �ּ�, ��ȭ��ȣ�� ����� ���� PhoneŬ������ �����
   Map�� �̿��Ͽ� ��ȭ��ȣ ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�
     �� ���α׷����� �Ʒ��� ���� �޴��� �ִµ� �� ����� ��� �����Ͻÿ�
     
     �޴�����
      1. ��ȭ��ȣ ���
      2. ��ȭ��ȣ ����
      3. ��ȭ��ȣ ����
      4. ��ȭ��ȣ �˻�
      5. ��ȭ��ȣ ��ü ���
      0. ���α׷� ����
      
      (Map�� ������ key������ ����Ǵ� ����� �̸��� ����ϰ�,
       value�����δ� 'phone Ŭ������ �ν��Ͻ�'�� �Ѵ�.)
       
           ���࿹��)
             -----------
          	���� �޴��� �����ϼ���
          	 -----------
          	 1. ��ȭ��ȣ ��� >> ���Ӱ� ����� ��ȭ��ȣ�� �Է��ϼ���. 
          	 �̸�>> ��ȭ��ȣ>> �ּ�>> 'ȫ�浿'��ȭ��ȣ ��� �Ϸ�.  �̸� �ߺ��� �̹� ��ϵ� ��� > ���� �޴��� �����ϼ���
          	 
          	 2. ��ȭ��ȣ ����
          	 3. ��ȭ��ȣ ����
          	 4. ��ȭ��ȣ �˻�
          	 5. ��ȭ��ȣ ��ü���
          	 0. ���α׷� ����
          	 
          	 ------------------------------
          	 ��ȣ  �̸�  ��ȭ��ȣ  �ּ�
          	 -----------------------------
          	 1  ȫ�浿  010-1111-1111  ������
          	 ----------------------------
          	 
          	 1. ��ȭ��ȣ ���
          	 2. ��ȭ��ȣ ����
          	 3. ��ȭ��ȣ ����
          	 4. ��ȭ��ȣ �˻�
          	 5. ��ȭ��ȣ ��ü���
          	 0. ���α׷� ����
 */

public class PhoneBookTest {

	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		PhoneBookTest b= new PhoneBookTest();
		b.start();
	}

	HashMap<String, Phone> map = new HashMap<>();
	HashMap<String, String> map2 = new HashMap<>();
	Set<String> keySet = map.keySet();
	
	public void start(){
		
		while(true){
		System.out.println(" -----------");
		System.out.println("�޴��� �����ϼ��� ");
		System.out.println(" -----------");
		System.out.println("1. ��ȭ��ȣ ���");
		System.out.println("2. ��ȭ��ȣ ����");
		System.out.println("3. ��ȭ��ȣ ����");
		System.out.println("4. ��ȭ��ȣ �˻�");
		System.out.println("5. ��ȭ��ȣ ��ü���");
		System.out.println("0. ���α׷� ����");
		int input = sc.nextInt();
		sc.nextLine();
		
		switch(input){
		case 1: add(); break;
		case 2: edit(); break;
		case 3: delete(); break;
		case 4: search(); break;
		case 5: print(); break;
		case 0: return;
		}
		}
		
	}
	
	
	private String name;
	private String addr;
	private String tel;
	
	//��ȭ��ȣ ���
	public void add(){
	
		System.out.println("���Ӱ� ����� ��ȭ��ȣ�� �Է��ϼ���.");
		
		System.out.println("�̸�>");
		name =sc.nextLine();
		if(map.containsKey(name)==true){
			System.out.println("�ߺ��Ǵ� �̸��� �ֽ��ϴ�.");
			return;
		}
			
		System.out.println("��ȭ��ȣ>");
		tel=sc.nextLine();
		
		System.out.println("�ּ�>");
		addr=sc.nextLine();
		
		map.put(name, new Phone(name, addr, tel));
		
		
		System.out.println("����� �Ϸ�Ǿ����ϴ�. "+ map.get(name));
		System.out.println();
	}
	
	
	private void edit() {
		
		
		System.out.println("������ ����� �̸��� �Է�:");
		name = sc.nextLine();
		System.out.println("������ �ּ�:");
		addr = sc.nextLine();
		System.out.println("������ ��ȣ:");
		tel = sc.nextLine();
		
		map.put(name, new Phone(name, addr, tel));
		
		System.out.println("������ �Ϸ�Ǿ����ϴ�. "+ map.get(name));
		
	}
	
	
	private void delete() {
	
		System.out.println("������ ��� ��ȭ��ȣ�� �̸��� �Է�:");
		name = sc.nextLine();
		map.remove(name);
		
		System.out.println("������ �Ϸ�Ǿ����ϴ�. ");
		
		for(String key : map.keySet()){
			Phone value = map.get(key);
			System.out.println(key + ":"+value);
		}
	}
	
	private void search() {
		
		System.out.println("�˻��� ����� �̸��� �Է�:");
		name= sc.nextLine();
		System.out.println("�˻���� "+ map.get(name));
		
	}
	
	private void print() {
		for(String key : map.keySet()){
			Phone value = map.get(key);
			System.out.println(key + ":"+value);
		}
		
	}
	

}

class Phone{
	
	private String name;
	private String addr;
	private String tel;
	

	public Phone(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "[�̸�=" + name + ", �ּ�=" + addr + ", tel=" + tel + "]";
	}
	
	
}
