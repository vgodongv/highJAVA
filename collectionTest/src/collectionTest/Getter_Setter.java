

package collectionTest;

public class Getter_Setter {
	public static void main(String[] args) {
		Value v= new Value();
		
		// Value에 있는 값을 가져오려면
		v.num1 = 200; //public이면 객체변수를 이용해 변수를 직접사용할 수 있다.
//		v.num2 = 200; 오류발생. private일때는 Value 클래스에서만 사용가능하고 Value 클래스에 감쳐줘서 = 캡슐화 되어서 다른 클래스에서 직접 사용불가
//	        데이터를 써야하는데 왜감추냐? 외부에서 사용못하게 보호 = 엉뚱한 값이 못들어가게 . num2에 데이터를 넣거나 데이터를 가져오고 싶으면? getter/setter
//		데이터를 넣고 싶으면? 
		v.setNum2(200);
		System.out.println("num1 : "+ v.num1 );
		System.out.println("num2 : "+ v.getNum2() );
		
		
	}

}

class Value{
	//getter setter 왜쓰냐????????
	public int num1; //  아무곳에서나 접근
	private int num2; // 자기자신 클래스안에서만 접근
	
	public int getNum2() { // getter, setter는 public이라 외부에서 쓸 수 있음. 
		return num2;
	}
	public void setNum2(int num2) { // getter, setter를 내가 필요한데로 재정의 가능.
		if(num2<0 || num2>100){
			System.out.println("num2 자료 오류");
		}else{
		this.num2 = num2;
		}
	}
	

	
}

