package collectionTest;

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		// 컬렉션 객체에 저장되는 데이터는 객체만 저장할 수 있다.
		// 벡터객체생성. 모든객체저장가능
		Vector v1 = new Vector();
		
		System.out.println("처음크기: " + v1.size());
		
//		 데이터 추가1 : add(추가할 테이터 지정)
		// 반환값: 추가 성공시 true, 실패시 false
		v1.add("AAAA"); // 문자열데이터 AAAA객체
		v1.add(new Integer(123)); //숫자데이터는 객체화해서 넣어야함. 
		v1.add(111); //객체화안해도되게 개선됨. 그냥 일반데이터 넣어도 내부에서 자동으로 객체화해서 넣어줌(=auto boxing)
		v1.add('a'); //문자데이터
		v1.add(true);
		boolean r = v1.add(3.14); //3.14가 들어간것이 성공했는지 
		
		System.out.println("v1의 크기 : "+ v1.size()); //자동으로 크기 증가
		System.out.println("반환값 :" + r);//3.14가 들어간것이 성공했는지 
		System.out.println("v1 ===> " + v1); //"v1 ===> " + v1는 v1.toString()과 같음
		System.out.println("v1 ===> " + v1.toString());
		
//		 데이터 추가2: addElement(추가할 데이터)
		// 이전 버전의 Vector에서 사용하던 메서드
		v1.addElement("KKK");
		System.out.println("v1 => " + v1);
		
//		 데이터 추가3: add(index, 데이터) -> index번째에 '데이터'를 끼워 넣는다. 반환값은 없다.
		v1.add(1, "ZZZ"); //1번째 자리에 ZZZ를 추가 . 원래 1번 인덱스에 있던 데이터는 뒤로 밀려남
		System.out.println("v1 => " + v1);
		
//		데이터 수정 : set(index, 새로운 데이터)
		// ==> 'index'번째 자료를 '새로운데이터'로 변경한다
		// 반환값 : 원래의 데이터 
		String temp = (String)v1.set(0, "YYYY"); //String으로 형변환 해줘야함.
		System.out.println("v1=>" + v1);
		System.out.println("원래의 데이터:"+ temp);
		
//		 데이터 삭제 : remove(index)
		// ==> 'index'번째의 데이터를 삭제한다.
		// ==> 반환값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("삭제 후 :"+v1);
		
		temp = (String)v1.remove(0);
		System.out.println("삭제 후 "+v1);
		System.out.println("삭제된 데이터:"+temp);
		
//		 데이터 삭제2 : remove(삭제할 데이터)
		// ==> '삭제할 데이터'를 찾아서 삭제한다.
		// ==> '삭제할 데이터'가 여러개면 앞에서부터 삭제된다.
		// ==> 반환값 : 삭제 성공이면 true, 실패면 false
		// ==> '삭제할 데이터'가 '정수형'이거나 'char형'이면 '삭제할 데이터'를 객체로 변환해서 사용해야 한다.
		v1.remove("KKK");
		System.out.println("삭제후:"+v1);
		
		
//		v1.remove(111); 삭제 안됨. 111을 인덱스로 인식. 때문에 111을 객체화 시켜야함
		v1.remove(new Integer(111));
		System.out.println("삭제후:"+v1);
		
//		v1.remove('a'); ''로 감싼 값은 문자의 코드값으로 바뀌어 처리가됨. 소문자 a의 코드값은 97. 97번째 인덱스로 인식해서 삭제안됨
		v1.remove(new Character('a')); //객체화 시켜야함
		System.out.println("삭제후:"+v1);
		
		v1.remove(true);
		System.out.println("삭제후:"+v1);
		
		v1.remove(3.14);
		System.out.println("삭제후:"+v1);
		
//		데이터 꺼내오기 : get(index)
		// ==> index번째의 데이터를 반환한다.
		int data = (int)v1.get(0); //벡터에는 object형으로 저장되어있기때문에 형변환해줘야함
		System.out.println("0번째 자료:"+ data);
		
		/*
		 제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터의 타입을 외부에서 지정하는 기법
		 객체를 선언할 때  <> 안에 그 객체가 사용할 데이터의 타입을 정해준다. 이런식으로 선언하게 되면 그 데이터 타입 이외의
		 데이터를 저장할 수 없다. 단, 제네릭으로 선언될 수 있는 데이터 타입은  클래스형이어야 한다.
		 예) int ==> Integer
		    boolean => Boolean
		    char ==> Character 등으로 대체해서 사용해야한다.
		  제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요없다.
		 */
		
		Vector<String> v2 = new Vector<>();
		Vector<Integer> v3 = new Vector<>();
		
		v2.add("안녕하세요");
//		v2.add(123); 제네릭 타입과 맞지 않은 자료형이라 에러
		
		String temp2 = v2.get(0); //제네릭 String이라 형변환 불필요
		Vector<Vector> vv = new Vector<>();
		Vector<Vector<Vector>> vvv = new Vector<>();
		
		System.out.println("-----------------------------");
		v2.clear(); // 전체데이터 삭제
		System.out.println("v2의 크기: "+v2.size());
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v4 = new Vector<>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v2 =>"+v2);
		System.out.println("v4 =>"+v4);
		
//		데이터 삭제3 : removeAll(Collection 객체)
		// ==> 'Collection 객체'가 가지고 있는 데이터를 모두 삭제한다.
		// ==> 반환값 : 성공(true), 실패(false)
		
		v2.removeAll(v4); // v2중에 v4가 가지고 있는 것을 지우는 것
		System.out.println("v2 =>"+v2);
		System.out.println();
		
		System.out.println("-------------------------------");
		v2.clear();
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		// Vector의 데이터를 처음부터 차례로 읽어와 처리하고 싶으면 반복문을 사용하면 된다.
		for(int i=0; i<v2.size(); i++){
			System.out.println(i+"번째 자료:"+ v2.get(i));
			
		}
		System.out.println("--------------------------------");
		
		//향상된 for문
		for(String s : v2){ //v2의 개수만큼 반복되고 반복할때마다 v2에서 데이터를 하나 꺼내서 s에 저장하고 실행 반복
			System.out.println(s);
		}
		
		
		
		
		
		
		

		
	}

}
