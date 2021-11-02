package collectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		/*
		- Map : key���� value���� �� ������ �����ϴ� ��ü
		  key���� �ߺ��� ������� �ʰ� ������ ����.(Set�� Ư¡�� ���´�.)
		  value���� �ߺ��� ����Ѵ�.
		 */
		
		HashMap<String, String> map = new HashMap<>();
		
		// �ڷ��߰� : put(Ű��, value��)
		map.put("name", "ȫ�浿");
		map.put("addr", "����");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map:"+map);
		
		// �ڷ����: �����͸� �߰��� �� 'key��'�� ������ ���߿� �Է��� ���� ����ȴ�.
		map.put("addr", "����");
		System.out.println("map:"+map);
		
		// �ڷ����: remove(key��) 'key��'�� ���� �ڷḦ ã�Ƽ� �����Ѵ�. ��ȯ���� ������ �ڷ��� value���̴�.
		
//		String removeTel = map.remove("tel");
//		System.out.println("map:"+map);
//		System.out.println(removeTel);
//		System.out.println();
		
		// �ڷ� �о����: get(key��) 'key��'�� ¦�̵Ǵ� value���� ��ȯ�Ѵ�.
		System.out.println("�̸�!!: "+ map.get("name")+"  �ּ�: "+map.get("addr")+"  ��ȣ: "+map.get("tel"));
		
		//key���� �����ϴ��� ���θ� ��Ÿ���� �޼��� : containsKey(key��) �ش� 'key��'�� �����ϸ� true, �׷��������� false�� ��ȯ�Ѵ�.
		System.out.println("tel Ű���� ���翩��: "+map.containsKey("tel"));
		System.out.println("age Ű���� ���翩��: "+map.containsKey("age"));
		System.out.println();
		
		// Map�� ����� ��� �����͸� �о���� ��� 
		// ���1) ��� key���� �о�ͼ� ó���ϱ� - KeySet() �޼��� ���. Map�� ��� key������ �о�� Set������ ��ȯ�Ѵ�.
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + ":" +value);
		}
		System.out.println();
		
		// ���2) ���1�� ó���� ���� for������ ó���ϱ�
		for(String key : map.keySet()){
			String value = map.get(key);
			System.out.println(key + ":"+value);
		}
		System.out.println();
		
		// ���3) value���� �о�� ó���ϱ�. values() �޼��� ���
		for(String value : map.values()){
			System.out.println(value);
		}
	}

}









