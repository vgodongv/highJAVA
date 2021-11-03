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
		System.out.println("üũ��");
		System.out.println("--------------------");
		System.out.println("201~209: �̱۷�");
		System.out.println("301~309: �����");
		System.out.println("401~409: ����Ʈ��");
		System.out.println("�� ��ȣ �Է�>");

		roomNum = sc.nextInt();

		if(!map.containsKey(roomNum)){
			System.out.println(roomNum+"������ �������� �ʽ��ϴ�.");
			checkin();
		}

		if(!(map.get(roomNum).getName()==null)){
			System.out.println("�̹� ���� üũ�� ������");
			checkin();
		}

		sc.nextLine();
		System.out.println("�̸� �Է�>");
		Name = sc.nextLine();

		map.put(roomNum, new Room(roomNum, map.get(roomNum).getRoomType(), Name));
		System.out.println("üũ���� �Ϸ�Ǿ����ϴ�. "+ map.get(roomNum));
		System.out.println();

	}


	private void checkout() { 

		System.out.println("--------------------");
		System.out.println("üũ�ƿ�");
		System.out.println("--------------------");	
		System.out.println("üũ�ƿ� �� ���ȣ�� �Է�:");
		roomNum= sc.nextInt();

		if(!map.containsKey(roomNum)){
			System.out.println(roomNum+"������ �������� �ʽ��ϴ�.");
			checkout();
		}

		if(map.get(roomNum).getName()==null){
			System.out.println(roomNum+"�濡�� üũ���� ����� ���µ���");
			checkout();
		}

		Name = "üũ���� �������";

		map.put(roomNum, new Room(roomNum, map.get(roomNum).getRoomType(), Name));
		System.out.println("üũ�ƿ��� �Ϸ�Ǿ����ϴ�. "+ map.get(roomNum));



	}

	private void condition() {
		System.out.println("----------------------------------------------");
		System.out.println("���� ���� ����");
		System.out.println("----------------------------------------------");
		System.out.println("���ȣ       ������         ������");
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

			System.out.println("ȣ�ڹ��� �������ϴ�. �������");
			System.out.println("-------------------------");
			System.out.println("� ������ �Ͻðڽ��ϱ�?");
			System.out.println("1.üũ�� 2.üũ�ƿ� 3.���ǻ��� 4.��������");
			System.out.println("-------------------------");
			System.out.println("����>");
			int input=sc.nextInt(); 
			switch(input){
			case 1: checkin(); break;
			case 2: checkout(); break;
			case 3: condition(); break;
			case 4: System.out.println("ȣ�ڹ��� �ݾҴ�"); return;

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

		h1.VO("�̱۷�",201,202,203,204,205,206,207,208,209);
		h1.VO("�����",301,302,303,304,305,306,307,308,309);
		h1.VO("����Ʈ��",401,402,403,404,405,406,407,408,409);

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
	String Name; // ������ �̸� ��
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
		return "Room [���ȣ:" + RoomNum + ", ������:" + Name + ", ������:"
				+ RoomType + "]";
	}









}
