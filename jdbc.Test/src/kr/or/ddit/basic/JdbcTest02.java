package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest02 {
	//����) ����ڷκ��� lprod_id���� �Է¹޾� �Է��� ������ lprod_id�� ū �ڷḦ ����Ͻÿ�.
	
	public static void main(String[] args) {
	// DB�۾��� �ʿ��� ��ü���� ����
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    
    try {
		//1. ����̹� �ε�
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	
    	//2. DB����: Connection��ü ����
    	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JHY990208","java");
    	
    	//3. ����
    	//3-1) ������ SQL�� �ۼ�
    	System.out.println("�Է��ϼ���");
    	int num = sc.nextInt();
    	String sql = "select * from lprod where lprod_id > "+num;
    	//3-2) Statement��ü �Ǵ� PreparedStatement��ü�� �����Ѵ�. (Connection��ü�� �̿��Ͽ� �����Ѵ�.)
    	stmt = conn.createStatement();
    	//3-3) SQL���� DB������ ������ ������ ����� ���´�. ������ ������ SQL���� SELECT���̶� �����  ResultSet��ü�� ����Ǿ� ��ȯ�ȴ�.
    	rs = stmt.executeQuery(sql);
    	
    	//4. ��� ó��
    	// rs.next(): ResultSet��ü�� �����͸� ����Ű�� �����͸� ������ġ�� �̵��ϰ� �� ���� �����Ͱ� ������ true�� ��ȯ�Ѵ�.
    	// �������ϳ��� ���ڵ�
    	while(rs.next()){
    		// �����Ͱ� ����Ű�� ���� �ڷ� ��������
    		// ����1) rs.get�����õ��������ڷ���("�÷���")
    		// ����2) rs.get�����õ��������ڷ���(�÷���ȣ) : �÷���ȣ�� 1���� �����Ѵ�. 0���;ƴ�
    		// ����3) rs.get�����õ��������ڷ���("�÷��� alias��")
    		System.out.println("lprod_id: "+rs.getInt("lprod_id"));
    		System.out.println("lprod_gu: "+rs.getString(2));
    		System.out.println("lprod_nm: "+rs.getString("lprod_nm"));
    		System.out.println();
    	
    	}
    			
	} catch (SQLException e) {
		// TODO: handle exception
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		// 5. �ڿ� �ݳ� : ������� ���� ��������
		if(rs!=null) try {
			rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		if(stmt!=null) try {
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		if(conn!=null) try {
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
		
	}

}
