package collectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 

���İ� ���õ� interface�� Comparable, Comparator �̷��� �� ������ �ִ�.
- Comparable�� Collection�� �߰��Ǵ� ������ ��ü�� ���� ������ �ְ� ���� �� �����ϴ� �������̽��̴�. (���� ���ı��� �����ϱ�)

- Comparator�� �ܺο� ������ ���� ������ �����ϰ� ���� �� ����ϴ� �������̽��̴�.(�ܺ����� ���� �����ϱ�)

- Comparable������ compareTo()�޼��带 �������ϰ�, Comparator������ compare()�޼��带 �������ؾ��Ѵ�.

- StringŬ����, Wrapper Ŭ����, DateŬ����, File Ŭ�������� ���� ���� ������ �����Ǿ� �ִ�. 
(���� ���� ������ ������������ ó���ǵ��� �����Ǿ� �ִ�.)


*/

public class ListSortTest {

public static void main(String[] args) {
ArrayList<String> list = new ArrayList<>();

list.add("������");
list.add("ȫ�浿");
list.add("������");
list.add("���е�");
list.add("�̼���");

System.out.println("������: "+ list);

// ������ Collections.sort() �޼��带 �̿��Ͽ� �����Ѵ�.
// Collections.sort()�޼���� �⺻������ ���� ���� �������� �����Ѵ�.
// ���� ���� ���� => Collection�� �߰��Ǵ� ������ ��ü�� ������ ���� ����(������ String�� ���� ���� ����)
//           => �⺻������ �ڹٿ��� �����Ǵ� �ڷ����� ���� ���� ������ ������������ ���ĵǵ��� ������� �ִ�.

Collections.sort(list);
System.out.println("������: "+list); //�������� ������

Collections.shuffle(list);
System.out.println("�ڷἯ�� ��: "+list);		

// �ܺ� ���� ������ ����ؼ� �����ϱ�
Collections.sort(list, new Desc());
System.out.println("�������� ���� ��: "+ list);
}

}

//���� ����� �����ִ� class����� (�ܺ� ���� ���� class�����)
class Desc implements Comparator<String>{

/* 
compare�޼����� ��ȯ��
- ��ȯ���� 0 : �� ���� ����.
- ��ȯ���� ���: �� ���� ������ �ٲ۴�.
- ��ȯ���� ����: �� ���� ������ �ٲ��� �ʴ´�.

��) ���������� ���: ���� ���� ũ�� ���, ������ 0 / ���� ���� ũ�� ������ ��ȯ�ǵ��� �����Ѵ�.
*/

@Override
public int compare(String str1, String str2) {
//������������ �����Ϸ��� �Ѵ�.
/* if(str1.compareTo(str2)>0){
	return -1;
}else if(str1.compareTo(str2)<0){
	return 1;
}else{
	return 0;	
}
*/

return str1.compareTo(str2) * -1;
}

}














