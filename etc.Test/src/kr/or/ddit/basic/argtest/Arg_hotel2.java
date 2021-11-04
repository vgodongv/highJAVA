package kr.or.ddit.basic.argtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

	//������ �ڵ�
public class Arg_hotel2 {
	HashMap<Integer, Rooom> hotelMap =  new HashMap<>();
	Scanner scan = new Scanner(System.in);

	//ȣ�ڿ� ���� ������

	Arg_hotel2() {

		// ���� �ʱ�ȭ
		for(int i=2; i<=4; i++){
			String roomType = null;
			switch(i){
			case 2: roomType = "�̱۷�";
			case 3: roomType = "�����";
			case 4: roomType = "����Ʈ��";

			}

			for(int j=1; j<=9; j++){
				int roomNum = i * 100 + j; // ���� ��ȣ �����
				Rooom r = new Rooom(roomNum, roomType); // Room ��ü ����
				hotelMap.put(roomNum, r); // Map�� ����

			}
		}
	}


	// ���� �޼���
	public void hotelStart(){
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("ȣ�ڹ��� �������ϴ�. �������");
		System.out.println("-------------------------");
		System.out.println();

		while(true){
			int choice = displayMenu();
			switch(choice){
			case 1: checkIn(); break;
			case 2: checkOut(); break;
			case 3: showRoom(); break;
			case 4: System.out.println("ȣ�� ���� �ݾҽ��ϴ�."); return;
			default : System.out.println("�۾� ��ȣ�� �߸� �Է��߽��ϴ�.");
			System.out.println("�ٽ� �Է��ϼ���");
			}

		}

	}

	private void checkOut() {
		
		System.out.println("üũ�ƿ� �� ���ȣ�� �Է�:");

		int num = scan.nextInt();

		if(!hotelMap.containsKey(num)){
			System.out.println("�׷� ���� ����");
			return;
		}

		// �Է¹��� ���ǿ� ���� ������ ����� �̸��� ���ؿ´�.
		String name = hotelMap.get(num).getGuestName();

		// �ش� ���ǿ� �������� ������ �˻�
		//		if(hotelMap.get(num).getGuestName()==null){
		if(name==null){System.out.println("�������� �����ϴ�.");
		return;
		}

		// ������ �̸��� null�� �����ؼ� üũ�ƿ�
		hotelMap.get(num).setGuestName(null);

		System.out.println("üũ���� �Ϸ�Ǿ����ϴ�.");


	}


	private void showRoom() {
		System.out.println();

		// ���ȣ�� ������� �������ϱ� ���ؼ� ���ȣ(Map�� key��)�� List�� ���� �� �����Ͽ� ����Ѵ�.
		ArrayList<Integer> roomNumList = new ArrayList<>(hotelMap.keySet());

		Collections.sort(roomNumList); // ���ȣ�� ������������ ����

		System.out.println("----------------------------------------------");
		System.out.println("���� ���� ����");
		System.out.println("----------------------------------------------");
		System.out.println("���ȣ       ������         ������");
		System.out.println("----------------------------------------------");

		// List���� ���ȣ�� �ϳ��� ������ Map���� �ش� ���ȣ�� ���� Room��ü�� ���ؼ� ����Ѵ�.

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
		System.out.println("üũ��");
		System.out.println("--------------------");
		System.out.println("201~209: �̱۷�");
		System.out.println("301~309: �����");
		System.out.println("401~409: ����Ʈ��");
		System.out.println("�� ��ȣ �Է�>");

		int num = scan.nextInt();

		//�Է��� ���� Map�� Ű���� ������ 
		if(!hotelMap.containsKey(num)){
			System.out.println("�׷� ���� ����");
			return;
		}

		// �ش� ���ǿ� �ٸ� �������� �̹� �ִ��� �˻�
		if(hotelMap.get(num).getGuestName() != null){
			System.out.println(num + "ȣ ���ǿ��� �̹� �ٸ� �մ��� �ֽ��ϴ�.");
			return;
		}

		System.out.println("������ �̸� �Է�>");
		String name = scan.next();


		hotelMap.get(num).setGuestName(name);
		System.out.println(name + "����"+num+"ȣ ���ǿ� üũ�� ��");
		// �Է¹��� ������ �̸��� �ش� ������ ������ ��ܿ� �����Ѵ�.
	}


	// �޴� 
	private int displayMenu(){
		System.out.println("� ������ �Ͻðڽ��ϱ�?");
		System.out.println("1.üũ�� 2.üũ�ƿ� 3.���ǻ��� 4.��������");
		System.out.println("-------------------------");
		System.out.println("����>");
		int num=scan.nextInt(); 
		return num;
	}

	public static void main(String[] args) {
		//		Hotel2 d = new Hotel2();
		//		d.hotelStart();  �̰͵� �Ǵµ� ��� �޼��� ������ ����



		new Arg_hotel2().hotelStart();
		//		new Hotel2().hashCode();
		//		new Hotel2().hotelStart(); new���Ἥ �ҷ����°� �� �ٸ� �����Ͷ���
	}

}


class Rooom{

	private int roomNumber; //���ȣ
	private String roomType; //��Ÿ��
	private String guestName; //������ �̸�

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

