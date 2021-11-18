package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

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

		- �߰�����
		1) 6. ��ȭ��ȣ ���� �޴��� �߰��ϰ� �����Ѵ�.
		(�� �� �������ϸ��� 'phoneData.dat'�� �Ѵ�.
		2) ���α׷��� ���۵� �� ����� ������ ������ �� �����͸� �о��  Map�� �����Ѵ�.
		3) ���α׷��� ������ �� Map�� �����Ͱ� �����ǰų�, �߰� �Ǵ� �����Ǹ� ���� �� ����ǵ��� �Ѵ�.
		
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
          	 6. ��ȭ��ȣ ����
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
           	6. ��ȭ��ȣ ����
          	 0. ���α׷� ����
 */

/* Scanner �޼��� Ư¡ 
1) nextLine�� �ƴ� �޼���� ��, next(). nextInt(), nextDouble()
 - ���̶��, tabŰ, enterŰ�� ���й��ڷ� �и��ؼ� �и��� �ڷḸ �о��. ���̶��, tabŰ, enterŰ�� ������
 
2) nextLine() 
 - �� �� ������ �Է��Ѵ�. �� �ڷḦ �Է��ϰ� EnterŰ�� ������ EnterŰ���� �о��.
 
 nextLine�Է¾��ߴµ� �Ѿ��ó�� ���̴� ����
 nextLine ��������  nextLine�� �ƴ� �޼���� �����
 
 �Է¹��۸� �˻��ߴ��� enterŰ = �����Ͱ� �����־ �� enterŰ�� �������� ����Ѱ�..
 
 �ذ���: nextLine������ scan.nextLine()�� �ѹ� ���Ἥ �Է¹��۸� ����ش�.
 
 int input = sc.nextInt();
 sc.nextLine(); // �Է¹��۸� ����ִ� ������ �Ѵ�.
 System.out.println("�̸�>");
 name =sc.nextLine();
 
 next�� ���̶��, tabŰ, enterŰ�� �и��ؼ� �����͸� �������� ������
 
		System.out.println("�̸�>");
        name =sc.next(); ���� ȫ �� ��
        System.out.println("��ȣ>");
        num = sc.nextInt(); 
        
              �̷��� �Է��ϸ� ȫ�� ������
              �� �̶� ���� ���� �������?�Է¹��ۿ� ��������,,
              �׷��� num�Է¹����� ���� ��.

 	 */

public class PhoneBookTest {



	Scanner sc = new Scanner(System.in);
	

	private HashMap<String, Phone> map;

	/*Set<String> keySet = map.keySet();*/
	
	private String fileName = "d:/d_other/phoneData.dat";
	private String name;
	private String addr;
	private String tel;
	//�����Ͱ� ����Ǿ����� ���θ� ��Ÿ���� �������� �����Ͱ� ����Ǹ� �� �������� true���ȴ�.
	private boolean dataChange;
	
	public PhoneBookTest() {
		
		map = load();
		
		if(map==null){ //������ ���ų� ����� �����϶�
			map = new HashMap<>();
		}
	}
	
	public static void main(String[] args) {
		PhoneBookTest b= new PhoneBookTest();
		b.start();
	}
	
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
			System.out.println("6. ��ȭ��ȣ ����");
			System.out.println("0. ���α׷� ����");
			int input = sc.nextInt();
			sc.nextLine(); // �Է¹��۸� ����ִ� ������ �Ѵ�.

			switch(input){
			case 1: add(); break;
			case 2: edit(); break;
			case 3: delete(); break;
			case 4: search(); break;
			case 5: print(); break;
			case 6: save(); break;
			case 0: 
				if(dataChange==true){//�����Ͱ� ����Ǿ�����
					System.out.println("����� �����͸� �����մϴ�.");
					save();
				}
				return;
			}
		}

	}

	// ��ȭ��ȣ ���Ϸ� ����
	private void save() {
		ObjectOutputStream oos = null; //��ü�� �����Ϸ��� ObjectOutputStream �ʿ�
		try {
			// ��ü ����� ��� ��Ʈ�� ��ü ����
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			// Map��ü�� ���Ϸ� �����Ѵ�.
			oos.writeObject(map);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//����ߴ� ��Ʈ�� ��ü �ݱ�
			if(oos!=null)
			try {
				oos.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		dataChange=false;
		
	}
	
	// ����� ��ȭ��ȣ ������ �о�ͼ� ��ȯ�ϴ� �޼���
	private HashMap<String,Phone> load(){
		// �о�� �����Ͱ� ����� ���� ����
		HashMap<String, Phone> pMap = null;
		
		File file = new File(fileName);
		if(!file.exists()){ // ����� ������ ������
			return null;
		}
		// ����� ������ �о���� ���� ��Ʈ�� ��ü ���� ����
		ObjectInputStream ois = null;
		try {
			// ���� �Է¿� ��Ʈ�� ��ü ����
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// ���� ������ �о�� Map��ü ������ �����Ѵ�.
			pMap = (HashMap<String, Phone>) ois.readObject();
			
		} catch (IOException e) {
			// TODO: handle exception
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		} finally{
			if(ois!=null)
				try {
					ois.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
		}
		
		return pMap;
	}


	//��ȭ��ȣ ���
	public void add(){

		System.out.println("���Ӱ� ����� ��ȭ��ȣ�� �Է��ϼ���.");

		System.out.println("�̸�>");
		name =sc.nextLine();
		if(map.containsKey(name)==true){
			System.out.println("�ߺ��Ǵ� �̸��� �ֽ��ϴ�.");
			add();
		}

		System.out.println("��ȭ��ȣ>");
		tel=sc.nextLine();

		System.out.println("�ּ�>");
		addr=sc.nextLine();

		//���1)
		/* Phone p = new Phone(name, tel, addr);
		map.put(name, p); */

		//���2)
		map.put(name, new Phone(name, addr, tel));
		System.out.println("����� �Ϸ�Ǿ����ϴ�. "+ map.get(name));
		System.out.println();
		dataChange = true;
	}


	private void edit() {


		System.out.println("������ ����� �̸��� �Է�:");
		name = sc.nextLine();
		
		if(map.containsKey(name)==false){
			System.out.println("�̸� ����");
			edit();
		}
		
		System.out.println("������ �ּ�:");
		addr = sc.nextLine();
		System.out.println("������ ��ȣ:");
		tel = sc.nextLine();

		// ���� ���1 : name�� �̿��ؼ� Phone��ü�� ������ Phone��ü�� ������ ����
		
		/* Phone p = map.get(name);
		p.setTel(tel);
		p.setAddr(addr); */
		
		// ���� ���2 : 
		
		map.put(name, new Phone(name, addr, tel));
		dataChange=true;
		System.out.println("������ �Ϸ�Ǿ����ϴ�. "+ map.get(name));

	}


	private void delete() {

		System.out.println("������ ��� ��ȭ��ȣ�� �̸��� �Է�:");
		name = sc.nextLine();
		
		if(map.containsKey(name)!=true){
			System.out.println("�˻������ʽ��ϴ�.");
			return;
		}
		
		map.remove(name);

		System.out.println("������ �Ϸ�Ǿ����ϴ�. ");

		for(String key : map.keySet()){
			Phone value = map.get(key);
			System.out.println(key + ":"+value);
		}
		
		dataChange = true;
		
	}

	private void search() {



		System.out.println("�˻��� ����� �̸��� �Է�:");
		name= sc.nextLine();
		if(map.containsKey(name)!=true){
			System.out.println("�˻������ʽ��ϴ�.");
			return;
		}
		
		// ���1)
		/* Phone p = map.get(name);
		System.out.println("�̸�: "+p.getName());
		System.out.println("��ȭ��ȣ: "+p.getTel());
		System.out.println("�ּ�: "+p.getAddr());
		*/
		
		
		// ���2)
		System.out.println("�˻���� "+ map.get(name));

	}

	private void print() {


		if(map.size()==0){
			System.out.println("��ϵ� ������ �����ϴ�.");
		} /* else{
			Iterator<String> keyIt = keySet.iterator();
			while(keyIt.hasNext()){
				String name = keyIt.next(); //Ű��
				Phone p = map.get(name); // value��(phone��ü)

				System.out.println(" "+ p.getName()+" "+p.getTel()+" "+ p.getAddr() );
			}
		} */

		for(String key : map.keySet()){
			Phone value = map.get(key);
			System.out.println(key + ":"+value);
		}

	}
}

class Phone implements Serializable{ // ���Ϸ� �����Ϸ��� ����ȭ 
	
	private static final long serialVersionUID = 1L;
	
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
