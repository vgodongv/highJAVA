package kr.or.ddit.basic.generictest;


/*
   제네릭 클래스를 만드는 방법
  형식) class 클래스명<제네릭타입글자>{
  
         제네릭타입글자 변수명; 변수 선언에 제네릭을 사용한 경우
         
         제네릭타입글자 메서드명(매개변수들){  메서드의 반환값에  제네릭을 사용한 경우
      
       return 값;
      }
      
      반환값타입 메서드명(제네릭타입글자 변수명){ 메서드의 매개변수에 제네릭을 사용한 경우
      
      return 값;
      }
      
     }
 */

class MyGeneric<T>{ // MyGeneric<T,V,E> 제네릭 여러개 지정도 가넝한
	
	private T val;
	
	public void setVal(T val){
		this.val = val;
	}
	
	public T getVal(){
		return val;
	}
}


class NonGeneric{
	private Object val; //멤버변수
	
	public void setVal(Object val){
		this.val = val;
	}
	
	public Object getVal(){
		return val;
	}
}



public class GenericTest {

	public static void main(String[] args) {
		NonGeneric ng1 = new NonGeneric();
		ng1.setVal("가나다라"); // 자식 -> 부모 형변환 불필요. 자동 형변환됨

		NonGeneric ng2 = new NonGeneric();
		ng2.setVal(100); //오토박싱
		
		String rtnNg1 = (String)ng1.getVal(); // 부모->자식 형변환 필요
		System.out.println("문자열 반환값: "+ rtnNg1);
		
		Integer rtnNg2 = (Integer)ng2.getVal();
		//int rtnNg2 = (int)ng2.getVal(); 오토 언박싱 일어나서 int로 써도됨
		System.out.println("정수형 반환값: "+ rtnNg2);
		System.out.println();
		
		/* 
		NonGeneric ng3 = new NonGeneric();
		ng3.setVal("홍길동"); 
		
		Integer rtnNg3 = (Integer)ng3.getVal(); // 실행시 오류. 
		System.out.println("ng3: "+ rtnNg3);
		*/
		
		System.out.println("-----------------------------");
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		String rtnMg1 = mg1.getVal();
		System.out.println(rtnMg1);
		int rtnMg2 = mg2.getVal();
		System.out.println(rtnMg2);
		
//		int test = mg1.getVal(); 바로 에러나서 에러를 찾기 쉽돵
		
		
		
		
	}

}






