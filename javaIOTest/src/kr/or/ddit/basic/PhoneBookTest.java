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

		- 추가조건
		1) 6. 전화번호 저장 메뉴를 추가하고 구현한다.
		(이 때 저장파일명은 'phoneData.dat'로 한다.
		2) 프로그램이 시작될 때 저장된 파일이 있으면 그 데이터를 읽어와  Map에 세팅한다.
		3) 프로그램을 종료할 때 Map의 데이터가 수정되거나, 추가 또는 삭제되면 저장 후 종료되도록 한다.
		
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
          	 6. 전화번호 저장
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
           	6. 전화번호 저장
          	 0. 프로그램 종료
 */

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

public class PhoneBookTest {



	Scanner sc = new Scanner(System.in);
	

	private HashMap<String, Phone> map;

	/*Set<String> keySet = map.keySet();*/
	
	private String fileName = "d:/d_other/phoneData.dat";
	private String name;
	private String addr;
	private String tel;
	//데이터가 변경되었는지 여부를 나타내는 변수선언 데이터가 변경되면 이 변수값이 true가된다.
	private boolean dataChange;
	
	public PhoneBookTest() {
		
		map = load();
		
		if(map==null){ //파일이 없거나 입출력 오류일때
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
			System.out.println("메뉴를 선택하세요 ");
			System.out.println(" -----------");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체출력");
			System.out.println("6. 전화번호 저장");
			System.out.println("0. 프로그램 종료");
			int input = sc.nextInt();
			sc.nextLine(); // 입력버퍼를 비워주는 역할을 한다.

			switch(input){
			case 1: add(); break;
			case 2: edit(); break;
			case 3: delete(); break;
			case 4: search(); break;
			case 5: print(); break;
			case 6: save(); break;
			case 0: 
				if(dataChange==true){//데이터가 변경되었으면
					System.out.println("변경된 데이터를 저장합니다.");
					save();
				}
				return;
			}
		}

	}

	// 전화번호 파일로 저장
	private void save() {
		ObjectOutputStream oos = null; //객체로 저장하려면 ObjectOutputStream 필요
		try {
			// 객체 저장용 출력 스트림 객체 생성
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			// Map객체를 파일로 저장한다.
			oos.writeObject(map);
			System.out.println("저장이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//사용했던 스트림 객체 닫기
			if(oos!=null)
			try {
				oos.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		dataChange=false;
		
	}
	
	// 저장된 전화번호 정보를 읽어와서 반환하는 메서드
	private HashMap<String,Phone> load(){
		// 읽어온 데이터가 저장될 변수 선언
		HashMap<String, Phone> pMap = null;
		
		File file = new File(fileName);
		if(!file.exists()){ // 저장된 파일이 없으면
			return null;
		}
		// 저장된 파일을 읽어오기 위한 스트림 객체 변수 선언
		ObjectInputStream ois = null;
		try {
			// 파일 입력용 스트림 객체 생성
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// 파일 내용을 읽어와 Map객체 변수에 저장한다.
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
		dataChange = true;
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
		dataChange=true;
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
		
		dataChange = true;
		
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

class Phone implements Serializable{ // 파일로 저장하려면 직렬화 
	
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
		return "[이름=" + name + ", 주소=" + addr + ", tel=" + tel + "]";
	}


}
