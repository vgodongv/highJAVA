package kr.or.ddit.basic.argtest;

public class ArgsTest {

	// 매개변수로 여러개의 정수들을 받아서  이 정수들의 합계를 구하는 메서드
	// (이 정수들의 개수는 상황에 따라 다르다.)

	public int sumArr(int[] data){

		int sum = 0;

		for(int i=0; i<data.length; i++){
			sum+=data[i];
		}
		return sum;
	}

	//	public void test(int a, int b){  a,b =매개변수
	//		
	//	}
	
	// 가변형 인수 : 메서드의 인수값의 개수가 메서드를 호출할 때마다 다를 때 사용한다.
	// - 가변형 변수는 메서드 안에서는 배열로 처리된다.
	// - 가변형 변수는 한가지 자료형만 사용할 수 있다. public int sumArg(int...data, String... str) 오류
	
	// 가변형 인수를 이용한 메서드
	public int sumArg(int...data){
		
		int sum = 0;

		for(int i=0; i<data.length; i++){
			sum+=data[i];
		}
		return sum;
	}
	
	// 가변형 변수와 일반적인 매개변수를 혼합해서 사용할 수 있다. 단 이 때는 가변형 변수를 제일 뒤쪽에 배치한다. 왜?
	// public String sumArg2(int...data, int name) 일때 앞에 몇개를 가져가야 할지 구분하기 어렵기 때문
	//  public String sumArg2(int name, int...data) 데이터가 여러개면 일반 변수에 한개 주고 나머지는 가변형 변수에 주면 됨
	
	public String sumArg2(String name, int...data){
		int sum = 0;

		for(int i=0; i<data.length; i++){
			sum+=data[i];
		}
		return name+"씨 총점: "+ sum;
	}

	public static void main(String[] args) {
		ArgsTest t = new ArgsTest();
//		t.test(100, 200); 100,200 = 매개변수에 들어갈 인수값
		
		int[] nums = {100,200,300};
		
		int[] nums2;
		nums2= new int[]{1,2,3,4,5};
		
		System.out.println(t.sumArr(nums));
		System.out.println(t.sumArr( new int[]{1,2,3,4,5}) );
		System.out.println();
		
		System.out.println("가변형 합계: "+ t.sumArg(100,200,300));
		System.out.println("가변형 합계: "+ t.sumArg(1,2,3,4,5));
		System.out.println();
		
		System.out.println(t.sumArg2("홍길동", 1,2,3,4,5,6,7,8));
		
		
		
		
		
		
	}

}





