package kr.or.ddit.basic.argtest;


import java.util.HashMap;
import java.util.Scanner;

public class Arg_hotel {
	Scanner sc = new Scanner(System.in);
	static HashMap<Integer, Room> map = new HashMap<>();
	static int roomNum;
	static String roomType;
	static String Name ;


	private void checkin() {

		System.out.println("--------------------");
		System.out.println("체크인");
		System.out.println("--------------------");
		System.out.println("201~209: 싱글룸");
		System.out.println("301~309: 더블룸");
		System.out.println("401~409: 스위트룸");
		System.out.println("방 번호 입력>");

		roomNum = sc.nextInt();

		if(!map.containsKey(roomNum)){
			System.out.println(roomNum+"객실이 존재하지 않습니다.");
			checkin();
		}

		if(!(map.get(roomNum).getName()==null)){
			System.out.println("이미 누가 체크인 했지롱");
			checkin();
		}

		sc.nextLine();
		System.out.println("이름 입력>");
		Name = sc.nextLine();

		map.put(roomNum, new Room(roomNum, map.get(roomNum).getRoomType(), Name));
		System.out.println("체크인이 완료되었습니다. "+ map.get(roomNum));
		System.out.println();

	}


	private void checkout() { 

		System.out.println("--------------------");
		System.out.println("체크아웃");
		System.out.println("--------------------");	
		System.out.println("체크아웃 할 방번호를 입력:");
		roomNum= sc.nextInt();

		if(!map.containsKey(roomNum)){
			System.out.println(roomNum+"객실이 존재하지 않습니다.");
			checkout();
		}

		if(map.get(roomNum).getName()==null){
			System.out.println(roomNum+"방에는 체크인한 사람이 없는데요");
			checkout();
		}

		Name = "체크인한 사람없음";

		map.put(roomNum, new Room(roomNum, map.get(roomNum).getRoomType(), Name));
		System.out.println("체크아웃이 완료되었습니다. "+ map.get(roomNum));



	}

	private void condition() {
		System.out.println("----------------------------------------------");
		System.out.println("현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방번호       방종류         투숙객");
		for(int i=201; i<210; i++){
			System.out.println(map.get(i));
		}

		for(int i=301; i<310; i++){
			System.out.println(map.get(i));
		}

		for(int i=401; i<410; i++){
			System.out.println(map.get(i));
		}

		System.out.println();
	}

	private void start() {


		while(true){

			System.out.println("호텔문을 열었습니다. 어서오세요");
			System.out.println("-------------------------");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("-------------------------");
			System.out.println("선택>");
			int input=sc.nextInt(); 
			switch(input){
			case 1: checkin(); break;
			case 2: checkout(); break;
			case 3: condition(); break;
			case 4: System.out.println("호텔문을 닫았다"); return;

			}
		}


	}


	public HashMap VO(String roomType, int...data){

		for(int i=0; i<data.length; i++){
			map.put(data[i], new Room(data[i], roomType, Name));		
		}
		return map;	
	}

	public static void main(String[] args) {

		Arg_hotel h1 = new Arg_hotel();

		h1.VO("싱글룸",201,202,203,204,205,206,207,208,209);
		h1.VO("더블룸",301,302,303,304,305,306,307,308,309);
		h1.VO("스위트룸",401,402,403,404,405,406,407,408,409);

		System.out.println(map.get(401));
		System.out.println(map.get(402));
		System.out.println(map.get(403));
		System.out.println(map.get(404));
		System.out.println(map.get(405));
		System.out.println(map.get(406));
		System.out.println(map.get(407));
		System.out.println(map.get(408));
		System.out.println(map.get(409));

		h1.start();

	}

}

class Room{
	int RoomNum;
	String Name; // 투숙객 이름 ㅠ
	String RoomType;


	public Room(int roomNum,  String roomType, String name) {
		super();
		RoomNum = roomNum;
		Name = name;
		RoomType = roomType;
	}

	public int getRoomNum() {
		return RoomNum;
	}
	public void setRoomNum(int roomNum) {
		RoomNum = roomNum;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}

	@Override
	public String toString() {
		return "Room [방번호:" + RoomNum + ", 투숙객:" + Name + ", 방종류:"
				+ RoomType + "]";
	}









}
