package collectionTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	/*
	 - Stack: LIFO(���Լ���)�� �ڷᱸ�� 
	 
	 - Queue: FIFO(���Լ���)�� �ڷᱸ��
	 
	 Stack�� Queue�� LinkList�� �̿��ؼ� ����� �� �ִ�.
	 (Stack�� Stack�̶�� Ŭ������ ������ �����Ѵ�.)
	 
	 */

	public static void main(String[] args) {
		/*
		   - Stack�� ���
		  1. �ڷ� �Է�: push(�Էµ�����)
		  2. �ڷ� ���: pop() => �ڷḦ ������ �� ������ �ڷḦ  Stack���� �����Ѵ�. (����_�������)
		             peek() => �ڷḦ ���� ���� �����´�. (����_�˻��)
		             
		 */
		Stack<String> stack = new Stack<>();
//		LinkedList<String> stack2 = new LinkedList<>();
		stack.push("ȫ�浿");
		stack.push("������");
		stack.push("���е�");
		stack.push("������"); //�Ա�=�ⱸ
		
		System.out.println("stack= "+stack);
		String data = stack.pop();
		System.out.println("������ ��: "+data); //������
		System.out.println("������ ��: "+ stack.pop()); //���е�
		System.out.println("stack= "+stack); //�ΰ������� ȫ�浿, �����Ÿ� ����
		System.out.println();
		
		stack.push("������");
		System.out.println("stack= "+stack);
		System.out.println("������ ��: "+ stack.pop()); //������
		System.out.println("stack= "+stack);
		System.out.println();
		
		System.out.println("�������� �����°� : "+stack.peek());
		System.out.println("stack= "+stack);
		System.out.println("------------------------------------");
		
		
		/*
		   - Queue�� ���
		  1. �ڷ� �Է�: offer(�Էµ�����)
		  2. �ڷ� ���: poll() => �ڷḦ �������� �� �ڷḦ Queue���� �����Ѵ�.
		             peek() => �ڷḦ ���� ���� �����´�. (����_�˻��)
		             
		 */
		
		// LinkedList�� Queue�������̽��� ������ ListŬ�����̴�.
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("ȫ�浿"); //�ⱸ
		queue.offer("������");
		queue.offer("���е�");
		queue.offer("������"); //�Ա�
		
		System.out.println("queue= "+queue);
		String temp = queue.poll();
		System.out.println("������ ������: "+ temp);
		System.out.println("������ ������: "+ queue.poll());
		System.out.println("queue= "+queue);
		System.out.println();
		
		queue.offer("������");
		System.out.println("queue= "+queue);
		System.out.println();
		
		System.out.println("������ ������: "+ queue.poll());
		System.out.println("queue= "+queue);
		System.out.println();
		
		System.out.println("�������� ��������: "+queue.peek());
		System.out.println("queue= "+queue);
		System.out.println();
		
		
		
		
		
		
		
		

	}

}
