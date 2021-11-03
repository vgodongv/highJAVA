package kr.or.ddit.basic.argtest;

public class ArgsTest {

	// �Ű������� �������� �������� �޾Ƽ�  �� �������� �հ踦 ���ϴ� �޼���
	// (�� �������� ������ ��Ȳ�� ���� �ٸ���.)

	public int sumArr(int[] data){

		int sum = 0;

		for(int i=0; i<data.length; i++){
			sum+=data[i];
		}
		return sum;
	}

	//	public void test(int a, int b){  a,b =�Ű�����
	//		
	//	}
	
	// ������ �μ� : �޼����� �μ����� ������ �޼��带 ȣ���� ������ �ٸ� �� ����Ѵ�.
	// - ������ ������ �޼��� �ȿ����� �迭�� ó���ȴ�.
	// - ������ ������ �Ѱ��� �ڷ����� ����� �� �ִ�. public int sumArg(int...data, String... str) ����
	
	// ������ �μ��� �̿��� �޼���
	public int sumArg(int...data){
		
		int sum = 0;

		for(int i=0; i<data.length; i++){
			sum+=data[i];
		}
		return sum;
	}
	
	// ������ ������ �Ϲ����� �Ű������� ȥ���ؼ� ����� �� �ִ�. �� �� ���� ������ ������ ���� ���ʿ� ��ġ�Ѵ�. ��?
	// public String sumArg2(int...data, int name) �϶� �տ� ��� �������� ���� �����ϱ� ��Ʊ� ����
	//  public String sumArg2(int name, int...data) �����Ͱ� �������� �Ϲ� ������ �Ѱ� �ְ� �������� ������ ������ �ָ� ��
	
	public String sumArg2(String name, int...data){
		int sum = 0;

		for(int i=0; i<data.length; i++){
			sum+=data[i];
		}
		return name+"�� ����: "+ sum;
	}

	public static void main(String[] args) {
		ArgsTest t = new ArgsTest();
//		t.test(100, 200); 100,200 = �Ű������� �� �μ���
		
		int[] nums = {100,200,300};
		
		int[] nums2;
		nums2= new int[]{1,2,3,4,5};
		
		System.out.println(t.sumArr(nums));
		System.out.println(t.sumArr( new int[]{1,2,3,4,5}) );
		System.out.println();
		
		System.out.println("������ �հ�: "+ t.sumArg(100,200,300));
		System.out.println("������ �հ�: "+ t.sumArg(1,2,3,4,5));
		System.out.println();
		
		System.out.println(t.sumArg2("ȫ�浿", 1,2,3,4,5,6,7,8));
		
		
		
		
		
		
	}

}





