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
	
	/* Scanner 메서드 특징 
	1) nextLine이 아닌 메서드들 즉, next(). nextInt(), nextDouble()
	 - 사이띄기, tab키, enter키를 구분문자로 분리해서 분리된 자료만 읽어간다. 사이띄기, tab키, enter키는 남겨짐
	 
	2) nextLine() 
	 - 한 줄 단위로 입력한다. 즉 자료를 입력하고 Enter키를 누르면 Enter키까지 읽어간다.
	 
	 nextLine입력안했는데 넘어간것처럼 보이는 이유
	 nextLine 쓰기전에  nextLine이 아닌 메서드들 사용후
	 
	 입력버퍼를 검사했더니 enter키 = 데이터가 남아있어서 그 enter키를 가져가서 사용한것..
	 
	 해결방법: nextLine직전에 scan.nextLine()을 한번 더써서 입력버퍼를 비워준다.
	 
	 int input = sc.nextInt();
	 sc.nextLine(); // 입력버퍼를 비워주는 역할을 한다.
	 System.out.println("이름>");
	 name =sc.nextLine();
	 
	 next는 사이띄기, tab키, enter키로 분리해서 데이터를 가져가기 때문에
	 
			System.out.println("이름>");
	        name =sc.next(); 에서 홍 길 동
	        System.out.println("번호>");
	        num = sc.nextInt(); 
	        
	              이렇게 입력하면 홍만 가져감
	              길 이랑 동은 어디로 갔을까요?입력버퍼에 남아있음,,
	              그래서 num입력받을때 오류 남.

	 	 */

	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		PhoneBookTest b= new PhoneBookTest();
		b.start();
	}

	HashMap<String, Phone> map = new HashMap<>();

	Set<String> keySet = map.keySet();

	private String name;
	private String addr;
	private String tel;

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
			sc.nextLine(); // 입력버퍼를 비워주는 역할을 한다.

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


	//전화번호 등록
	public void add(){

		System.out.println("새롭게 등록할 전화번호를 입력하세요.");

		System.out.println("이름>");
		name =sc.nextLine();
		if(map.containsKey(name)==true){
			System.out.println("중복되는 이름이 있습니다.");
			add();
		}

		System.out.println("전화번호>");
		tel=sc.nextLine();

		System.out.println("주소>");
		addr=sc.nextLine();

		//방법1)
		/* Phone p = new Phone(name, tel, addr);
		map.put(name, p); */

		//방법2)
		map.put(name, new Phone(name, addr, tel));
		System.out.println("등록이 완료되었습니다. "+ map.get(name));
		System.out.println();
	}


	private void edit() {


		System.out.println("수정할 사람의 이름을 입력:");
		name = sc.nextLine();
		
		if(map.containsKey(name)==false){
			System.out.println("이름 없음");
			edit();
		}
		
		System.out.println("변경할 주소:");
		addr = sc.nextLine();
		System.out.println("변경할 번호:");
		tel = sc.nextLine();

		// 수정 방법1 : name을 이용해서 Phone객체를 구한후 Phone객체의 내용을 변경
		
		/* Phone p = map.get(name);
		p.setTel(tel);
		p.setAddr(addr); */
		
		// 수정 방법2 : 
		
		map.put(name, new Phone(name, addr, tel));

		System.out.println("변경이 완료되었습니다. "+ map.get(name));

	}


	private void delete() {

		System.out.println("삭제할 사람 전화번호의 이름을 입력:");
		name = sc.nextLine();
		
		if(map.containsKey(name)!=true){
			System.out.println("검색되지않습니다.");
			return;
		}
		
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
		if(map.containsKey(name)!=true){
			System.out.println("검색되지않습니다.");
			return;
		}
		
		// 방법1)
		/* Phone p = map.get(name);
		System.out.println("이름: "+p.getName());
		System.out.println("전화번호: "+p.getTel());
		System.out.println("주소: "+p.getAddr());
		*/
		
		
		// 방법2)
		System.out.println("검색결과 "+ map.get(name));

	}

	private void print() {


		if(map.size()==0){
			System.out.println("등록된 정보가 없습니다.");
		} /* else{
			Iterator<String> keyIt = keySet.iterator();
			while(keyIt.hasNext()){
				String name = keyIt.next(); //키값
				Phone p = map.get(name); // value값(phone객체)

				System.out.println(" "+ p.getName()+" "+p.getTel()+" "+ p.getAddr() );
			}
		} */

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
