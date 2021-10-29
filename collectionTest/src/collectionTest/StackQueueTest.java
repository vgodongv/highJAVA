package collectionTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	/*
	 - Stack: LIFO(후입선출)의 자료구조 
	 
	 - Queue: FIFO(선입선출)의 자료구조
	 
	 Stack과 Queue는 LinkList를 이용해서 사용할 수 있다.
	 (Stack은 Stack이라는 클래스가 별도로 존재한다.)
	 
	 */

	public static void main(String[] args) {
		/*
		   - Stack의 명령
		  1. 자료 입력: push(입력데이터)
		  2. 자료 출력: pop() => 자료를 꺼내온 후 꺼내온 자료를  Stack에서 삭제한다. (목적_실제사용)
		             peek() => 자료를 삭제 없이 꺼내온다. (목적_검사용)
		             
		 */
		Stack<String> stack = new Stack<>();
//		LinkedList<String> stack2 = new LinkedList<>();
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬"); //입구=출구
		
		System.out.println("stack= "+stack);
		String data = stack.pop();
		System.out.println("꺼내온 값: "+data); //강감찬
		System.out.println("꺼내온 값: "+ stack.pop()); //변학도
		System.out.println("stack= "+stack); //두개꺼내서 홍길동, 일지매만 남음
		System.out.println();
		
		stack.push("성춘향");
		System.out.println("stack= "+stack);
		System.out.println("꺼내온 값: "+ stack.pop()); //성춘향
		System.out.println("stack= "+stack);
		System.out.println();
		
		System.out.println("삭제없이 꺼내온값 : "+stack.peek());
		System.out.println("stack= "+stack);
		System.out.println("------------------------------------");
		
		
		/*
		   - Queue의 명령
		  1. 자료 입력: offer(입력데이터)
		  2. 자료 출력: poll() => 자료를 꺼내오고 그 자료를 Queue에서 삭제한다.
		             peek() => 자료를 삭제 없이 꺼내온다. (목적_검사용)
		             
		 */
		
		// LinkedList는 Queue인터페이스를 구현한 List클래스이다.
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("홍길동"); //출구
		queue.offer("이지매");
		queue.offer("변학도");
		queue.offer("강감찬"); //입구
		
		System.out.println("queue= "+queue);
		String temp = queue.poll();
		System.out.println("꺼내온 데이터: "+ temp);
		System.out.println("꺼내온 데이터: "+ queue.poll());
		System.out.println("queue= "+queue);
		System.out.println();
		
		queue.offer("성춘향");
		System.out.println("queue= "+queue);
		System.out.println();
		
		System.out.println("꺼내온 데이터: "+ queue.poll());
		System.out.println("queue= "+queue);
		System.out.println();
		
		System.out.println("삭제없이 꺼내오기: "+queue.peek());
		System.out.println("queue= "+queue);
		System.out.println();
		
		
		
		
		
		
		
		

	}

}
