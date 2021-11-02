package collectionTest;

import java.util.HashSet;

public class EqualsHashcodTest {

	public static void main(String[] args) {
		
		Person p1 = new Person(); //
		
		p1.setId(1);
		p1.setName("ȫ�浿");
		
		Person p2 = new Person();
//		p2.setId(2);
//		p2.setName("������");
		p2.setId(1);
		p2.setName("ȫ�浿");
		
		Person p3 = p1;
		
		System.out.println(p1==p2); //false �ּҰ�
		System.out.println(p1.equals(p2)); //true ��������ü
		
		HashSet<Person> testSet = new HashSet<>();
		
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("set�� ũ�� : "+ testSet.size());
		
		System.out.println("p1 : "+p1.hashCode());
		System.out.println("p2 : "+p2.hashCode());
		System.out.println("p3 : "+p3.hashCode());
		
		/*
		 - equals() �޼��� : �� ��ü�� ������ ������ �˻��ϴ� ������
		 - hashCode() �޼��� : �� ��ü�� ���ϼ��� �˻��ϴ� ������
		 - HashSet, Hashtable, HashMap�� ���� Hash�� �����ϴ� �÷��� ��ü���� ��ü�� �ǹ̻��� ���ϼ��� ���ϱ� ���ؼ� 
		   hashCode()�޼��带 ȣ���Ͽ� ���Ѵ�. �׷��Ƿ�, ��ü�� ������ ���θ� �����Ϸ��� hashCode()�޼��带 ������ �ؾ��Ѵ�.
		   
		   ����) hashCode() �޼��忡�� ����ϴ� '�ؽ� �˰���'�� ���� �ٸ� ��ü�鿡 ���ؼ� ���� hashcode�� �߻��� �� �ִ�.
		 
		 */

	}
}	

/* object�� ��������ִ� equals
 public boolean equals(Object obj){
 
 return this==obj; //this=p1 obj=2
}
 */


	class Person{//�ƹ��͵� ��ӹ��� ������ �ڵ����� object ��ü ��� �׷��� equals ��������
	
		private int id;
		private String name;

	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		
		/*
		// equals ������ - ��ü�� id���� name���� ������ true�� ��ȯ�ϵ��� �������Ѵ�.
		@Override
		public boolean equals(Object obj) {
			if(obj==null) return false;
			
			// ���� ������ Ŭ�������� �˻�
			if(this.getClass() != obj.getClass()) return false;
			
			// �������� ������ �˻�. �������� ������ true
			if(this==obj) return true;
			
			// �Ű������� ����� ��ü�� ���� ��ü �������� ����ȯ �Ѵ�.
			Person that = (Person)obj;
			
			if(this.name==null && that.name!= null)
				return false;
			
			if(this.id==that.id && this.name==that.name)
				return true;

			if(this.id==that.id && this.name.equals(that.name))
				return true;
			
			return false;
		}
		
		*/
		
		
	
	}
	
	
