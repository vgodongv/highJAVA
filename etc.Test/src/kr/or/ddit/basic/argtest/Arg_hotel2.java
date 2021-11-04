package kr.or.ddit.basic.argtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

	//선생님 코드
public class Arg_hotel2 {
	HashMap<Integer, Rooom> hotelMap =  new HashMap<>();
	Scanner scan = new Scanner(System.in);

	//호텔에 대한 생성자

	Arg_hotel2() {

		// 객실 초기화
		for(int i=2; i<=4; i++){
			String roomType = null;
			switch(i){
			case 2: roomType = "싱글룸";
			case 3: roomType = "더블룸";
			case 4: roomType = "스위트룸";

			}

			for(int j=1; j<=9; j++){
				int roomNum = i * 100 + j; // 객실 번호 만들기
				Rooom r = new Rooom(roomNum, roomType); // Room 객체 생성
				hotelMap.put(roomNum, r); // Map에 저장

			}
		}
	}


	// 시작 메서드
	public void hotelStart(){
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("호텔문을 열었습니다. 어서오세요");
		System.out.println("-------------------------");
		System.out.println();

		while(true){
			int choice = displayMenu();
			switch(choice){
			case 1: checkIn(); break;
			case 2: checkOut(); break;
			case 3: showRoom(); break;
			case 4: System.out.println("호텔 문을 닫았습니다."); return;
			default : System.out.println("작업 번호를 잘못 입력했습니다.");
			System.out.println("다시 입력하세여");
			}

		}

	}

	private void checkOut() {
		
		System.out.println("체크아웃 할 방번호를 입력:");

		int num = scan.nextInt();

		if(!hotelMap.containsKey(num)){
			System.out.println("그런 방은 없다");
			return;
		}

		// 입력받은 객실에 현재 투숙한 사람의 이름을 구해온다.
		String name = hotelMap.get(num).getGuestName();

		// 해당 객실에 투숙객이 없는지 검사
		//		if(hotelMap.get(num).getGuestName()==null){
		if(name==null){System.out.println("투숙객이 없습니다.");
		return;
		}

		// 투숙객 이름을 null로 변경해서 체크아웃
		hotelMap.get(num).setGuestName(null);

		System.out.println("체크인이 완료되었습니다.");


	}


	private void showRoom() {
		System.out.println();

		// 방번호를 순서대로 나오게하기 위해서 방번호(Map의 key값)만 List에 넣은 후 정렬하여 사용한다.
		ArrayList<Integer> roomNumList = new ArrayList<>(hotelMap.keySet());

		Collections.sort(roomNumList); // 방번호를 오름차순으로 정렬

		System.out.println("----------------------------------------------");
		System.out.println("현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방번호       방종류         투숙객");
		System.out.println("----------------------------------------------");

		// List에서 방번호를 하나씩 꺼내와 Map에서 해당 방번호에 대한 Room객체를 구해서 출력한다.

		for(int i=0; i<roomNumList.size(); i++){
			Rooom r = hotelMap.get(roomNumList.get(i));
			String name = "-";

			if(r.getGuestName()!=null){
				name = r.getGuestName();
			}

			System.out.println(r.getRoomNumber()+"\t"+r.getRoomType()+"\t"+name);
		}	
		System.out.println("----------------------------------------------");
		System.out.println();

	}


	private void checkIn() {
		System.out.println("--------------------");
		System.out.println("체크인");
		System.out.println("--------------------");
		System.out.println("201~209: 싱글룸");
		System.out.println("301~309: 더블룸");
		System.out.println("401~409: 스위트룸");
		System.out.println("방 번호 입력>");

		int num = scan.nextInt();

		//입력한 값이 Map의 키값에 없으면 
		if(!hotelMap.containsKey(num)){
			System.out.println("그런 방은 없다");
			return;
		}

		// 해당 객실에 다른 투숙객이 이미 있는지 검사
		if(hotelMap.get(num).getGuestName() != null){
			System.out.println(num + "호 객실에는 이미 다른 손님이 있습니다.");
			return;
		}

		System.out.println("투숙객 이름 입력>");
		String name = scan.next();


		hotelMap.get(num).setGuestName(name);
		System.out.println(name + "씨가"+num+"호 객실에 체크인 완");
		// 입력받은 투숙객 이름을 해당 객실의 투숙객 명단에 저장한다.
	}


	// 메뉴 
	private int displayMenu(){
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("-------------------------");
		System.out.println("선택>");
		int num=scan.nextInt(); 
		return num;
	}

	public static void main(String[] args) {
		//		Hotel2 d = new Hotel2();
		//		d.hotelStart();  이것도 되는뎅 얘는 메서드 여러개 쓸때



		new Arg_hotel2().hotelStart();
		//		new Hotel2().hashCode();
		//		new Hotel2().hotelStart(); new만써서 불러오는건 다 다른 데이터라함
	}

}


class Rooom{

	private int roomNumber; //방번호
	private String roomType; //방타입
	private String guestName; //투숙객 이름

	public Rooom(int roomNumber, String roomType) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;

	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Override
	public String toString() {
		return "Rooom [roomNumber=" + roomNumber + ", roomType=" + roomType
				+ ", guestName=" + guestName + "]";
	}




}

