package collectionTest;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Browser b = new Browser();
		
		b.goURL("1. ���̹�");
		b.goURL("2. ����");
		b.goURL("3. ����");
		//back
		
		b.goURL("4. ����");
		//forward

		b.history();
		
		System.out.println("[�ڷΰ��� ��]");
		b.goBack();
		b.history();
		
		System.out.println("[�ڷΰ��� ��]");
		b.goBack();
		b.history();
		
		System.out.println("[������ ���� ��]");
		b.goForward();
		b.history();
		
		System.out.println("[���ο� ����Ʈ �湮 ��]");
		b.goURL("5.����Ʈ");
		b.history();
	}

}

// �� �������� ������ ����, �ڷΰ��� ��� ����(�����̿�)
class Browser{
	private Stack<String> back;    // ���� �湮 ������ ����� ����
	private Stack<String> forward; // ���� �湮 ������ ����� ����
	private String currentURL;     // ����������
	
	// ������
	public Browser(){
		back = new Stack<>();
		forward = new Stack<>();
		currentURL="";
	}
	
	// ����Ʈ�� �湮�ϴ� �޼��� => �Ű� �������� �湮�� url�� ����ȴ�.
	public void goURL(String url){
		System.out.println(url+" ����Ʈ�� �����մϴ�.");
		
		//���� �������� ������
		if(currentURL!=null && !"".equals(currentURL)){
			back.push(currentURL); //���� �������� back���ÿ� �߰��Ѵ�.
		}
		currentURL = url; //���� �������� �����Ѵ�.
		forward.clear();  // forward���� ������ ��ü ����
	}
	
	// �ڷΰ��� �޼���
	public void goBack(){
		// isEmpty() => Stack�� ��������� true, �׷��� ������ false ��ȯ
		if(!back.isEmpty()){
			forward.push(currentURL); //���� �������� forward���ÿ� �߰�
			currentURL=back.pop();    //back���� 1���� ��Ҹ� ������ ���� �������� ����.
			
			
		}
	}
	
	// ������ ���� �޼���
	public void goForward(){
		if(!forward.isEmpty()){
			back.push(currentURL); // ���� �������� back���ÿ� �߰�
			currentURL = forward.pop(); //forward���� 1���� ��Ҹ� ������ ���� �������� ����.
					
		}
	}
	
	// �湮 ��� Ȯ���ϱ�
	public void history(){
		System.out.println("-------------------------");
		System.out.println("��            ��             ��             ��");
		System.out.println("-------------------------");
		System.out.println("back ="+back);
		System.out.println("���������� ="+currentURL);
		System.out.println("forward ="+forward);
		System.out.println("-------------------------");
		System.out.println();
		
	}
}





