package collectionTest;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
  문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
   Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오
     이 프로그램에는 아래와 같은 메뉴가 있는데 이 기능을 모두 구현하시오
     
     메뉴예시
      1. 전화번호 등록
      2. 전화번호 수정
      3. 전화번호 삭제
      4. 전화번호 검색
      5. 전화번호 전체 출력
      0. 프로그램 종료
      
      (Map의 구조는 key값으로 저장되는 사람의 이름을 사용하고,
       value값으로는 'phone 클래스의 인스턴스'로 한다.)
       
           실행예시)
             -----------
          	다음 메뉴를 선택하세여
          	 -----------
          	 1. 전화번호 등록 >> 새롭게 등록할 전화번호를 입력하세요. 
          	 이름>> 전화번호>> 주소>> '홍길동'전화번호 등록 완료.  이름 중복시 이미 등록된 사람 > 다음 메뉴를 선택하세요
          	 
          	 2. 전화번호 수정
          	 3. 전화번호 삭제
          	 4. 전화번호 검색
          	 5. 전화번호 전체출력
          	 0. 프로그램 종료
          	 
          	 ------------------------------
          	 번호  이름  전화번호  주소
          	 -----------------------------
          	 1  홍길동  010-1111-1111  대전시
          	 ----------------------------
          	 
          	 1. 전화번호 등록
          	 2. 전화번호 수정
          	 3. 전화번호 삭제
          	 4. 전화번호 검색
          	 5. 전화번호 전체출력
          	 0. 프로그램 종료
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
		System.out.println("메뉴를 선택하세요 ");
		System.out.println(" -----------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체출력");
		System.out.println("0. 프로그램 종료");
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
	
	//전화번호 등록
	public void add(){
	
		System.out.println("새롭게 등록할 전화번호를 입력하세요.");
		
		System.out.println("이름>");
		name =sc.nextLine();
		if(map.containsKey(name)==true){
			System.out.println("중복되는 이름이 있습니다.");
			return;
		}
			
		System.out.println("전화번호>");
		tel=sc.nextLine();
		
		System.out.println("주소>");
		addr=sc.nextLine();
		
		map.put(name, new Phone(name, addr, tel));
		
		
		System.out.println("등록이 완료되었습니다. "+ map.get(name));
		System.out.println();
	}
	
	
	private void edit() {
		
		
		System.out.println("수정할 사람의 이름을 입력:");
		name = sc.nextLine();
		System.out.println("변경할 주소:");
		addr = sc.nextLine();
		System.out.println("변경할 번호:");
		tel = sc.nextLine();
		
		map.put(name, new Phone(name, addr, tel));
		
		System.out.println("변경이 완료되었습니다. "+ map.get(name));
		
	}
	
	
	private void delete() {
	
		System.out.println("삭제할 사람 전화번호의 이름을 입력:");
		name = sc.nextLine();
		map.remove(name);
		
		System.out.println("삭제가 완료되었습니다. ");
		
		for(String key : map.keySet()){
			Phone value = map.get(key);
			System.out.println(key + ":"+value);
		}
	}
	
	private void search() {
		
		System.out.println("검색할 사람의 이름을 입력:");
		name= sc.nextLine();
		System.out.println("검색결과 "+ map.get(name));
		
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
		return "[이름=" + name + ", 주소=" + addr + ", tel=" + tel + "]";
	}
	
	
}
