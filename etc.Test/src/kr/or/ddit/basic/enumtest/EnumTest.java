package kr.or.ddit.basic.enumtest;


	/*
	 	- enum(열거형) : 서로 관련있는 상수들의 집합을 나타낸다. 클래스처럼 보이게 하는 상수
	 	                           열거형은 class처럼 독립된 java파일에 만들 수 있고, 하나의 java파일에 클래스와 같이 만들 수 있고, 
	 	              class안에 내부 클래스처럼 만들 수 있다.
	 	- 열거형의 속성 및 메서드
	 	1) name() : 열거형 상수의 이름을 문자열로 반환한다.
	 	2) ordinal() : 열거형 상수가 정의된 순서값(index)을 반환한다. (0부터 시작)
	 	3) valueOf("열거형상수명") : 지정된 열거형에서 '열거형상수명'과 일치하는 열거형 상수를 반환한다.
	 	4) 열거형이름.상수명 : valueOf("상수명")메서드와 같다.
	 	
	 	- 열거형 선언하기
	 	방법1) enum 열거형이름 { 상수명1, 상수명2, 상수명3 ...}
	 	방법2) enum 열거형이름{
	 		상수명1(값들...), 값들의 자료형은 전부 같아야함. 1의 값들이 문자형, 정수형이면 나머지 2,3의 자료형도 문자형, 정수형
	 		상수명2(값들...),
	 		상수명3(값들...),
	 		....
	 		상수명n(값들...) ;
	 		
	 		// 값들이 저장될 변수들을 선언해야함. 값들의 개수만큼 변수를 선언한다.
	 		 private 자료형이름 변수명 1;
	 		 ...
	 		 
	 		 // 열거형의 생성자를 만든다.
	 		 // 열거형의 생성자는 '열거형상수'에 값들을 세팅하는 역할을 수행한다.
	 		 // 열겨형 생성자는 묵시적으로 'private'이다.
	 		  
	 		  
	 		 // '변수명'은 값들과 개수가 같고, 각각의 값들과 자료형이 맞아야 한다.
	 		 private 열거형이름(자료형이름 변수명,....){
	 		 	 위에 선언된 변수들을 매개변수를 이용해서 초기화 한다.
	 		 	 
	 		 }
	 		 
	 		 // 구성된 '값들'을 외부에서 블러올 수 있도록 getter메서드를 작성한다.
	 		  public 자료형이름 get변수명1(){
	 		  		return 변수명;
	 		  }
	 		 
	 	}
	 	
	 	
	 */
public class EnumTest {
	//방법1	
	public enum Color { RED, GREEN, BLUE }; // 열거형이름이 클래스와 비슷한 역할
		public enum Count { ONE, TWO, THREE };
	//방법2
	public enum Season{
		봄("3월부터 5월까지"),  // 상수명(값들...)형식 선언
		여름("6월부터 8월까지"), // 생성자와 매칭되면 에러 없어짐
		가을("9월부터 11월까지"),
		겨울("12월부터 2월까지");
		
		// 값이 저장될 변수 선언
		private String span;
		
		// 생성자
		Season(String months){ // 묵시적 private라 pruvate Season(String months){ 과 같음
		span = months; //변수에 값을 초기화하는 작업을 수행한다.
		}
		
		//getter 생성
		public String getSpan(){
			return span;
		}
		
	}
			
	public static void main(String[] args) {
		/*
		System.out.println("Red : "+ ConstTest.RED);
		System.out.println("Three : "+ ConstTest.THREE);
		
		if(ConstTest.RED == ConstTest.TWO){
			System.out.println("-------");
		}else{
			System.out.println("#######");
		}
		
		*/
		
		Color mycol = Color.valueOf("GREEN"); // Color형의 green값을 반환해서 mycol에 저장. Color.GREEN과 같다.
		Count mycnt = Count.ONE; //Count.valueOf("ONE")과 같다.
		
		System.out.println("mycol : " + mycol.name());
		System.out.println("mycnt : " + mycnt.name());
		
		System.out.println("mycol ordinal : " + mycol.ordinal());
		System.out.println("mycnt ordinal : " + mycnt.ordinal());
		
		/* if(Color.RED == Count.TWO){ 열거형 이름이 다르면 비교자체가 불가넝한
			System.out.println("...");
		} */
		
		if(mycol == Color.BLUE){
			System.out.println("같다.");
		}else{
			System.out.println("같지 않다.");
		}
		
		Season ss = Season.valueOf("봄");
		System.out.println("name :" + ss.name());
		System.out.println("ordinal :" + ss.ordinal());
		System.out.println("span : "+ss.getSpan());
		
		// 열거형명.values() : 모든 상수들을 가져와 배열로 반환한다.
		for(Season time : Season.values()){
			System.out.println(time.name() + "==" + time + ":" + time.getSpan() );
		}
		System.out.println();
		
		for(Color col : Color.values()){
			System.out.println(col + ":"+ col.ordinal());
		}
		

	}

}
