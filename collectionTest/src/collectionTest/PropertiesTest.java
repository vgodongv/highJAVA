package collectionTest;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
	/*
	 
	 Properties객체는 Map보다 축소된 기능의 객체라고 할 수 있다.
	 
	 Map은 key값과 value값에 모든 형태의 객체를 사용할 수 있다.
	 Properties는 key값과 value값에 String만 사용할 수 있다. -> 제네릭 없삼
	 
	 Map은 put() 메서드와 get() 메서드를 이용해서 데이터를 입출력 하지만
	 Properties는 setProperty()메서드와 getProperty()메서드를 사용해서 입출력 한다.
	 
	 Properties는 데이터를 파일로 입출력할 수 있다.
	 
	 */
		
		Properties prop = new Properties();

		//데이터 추가
		prop.setProperty("name", "홍길동");
		prop.setProperty("age", "23");
		prop.setProperty("age2", String.valueOf(20)); // 또는 숫자를 문자열화 시켜서 집어넣어야함
		prop.setProperty("tel", "010-1234-1234");
		prop.setProperty("addr", "대전");
		
		//데이터 읽어오기
		String name = prop.getProperty("name");
		int age = Integer.parseInt(prop.getProperty("age"));
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
		System.out.println("전화번호: "+ tel);
		System.out.println("주소: "+ addr);
		
		
	}

}



