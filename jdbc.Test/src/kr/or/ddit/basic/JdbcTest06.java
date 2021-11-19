package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 	ȸ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�. (MYMEMBER ���̺� �̿�)
 	�Ʒ� �޴��� ����� ��� �����Ͻÿ�. (CRUD ��� �����ϱ�)
 	�޴�����) 
 	 -- �۾� ���� --
 	 1. �ڷ��߰�
 	 2. �ڷ����
 	 3. �ڷ���� UPDATE
 	 4. ��ü�ڷ����
 	 0. �۾���
 	 
 	 ó������)
 	 1) �ڷ��߰����� 'ȸ��ID'�� �ߺ����� �ʴ´�.(�ߺ��Ǹ� �ٽ� �Է� �޴´�.)
 	 2) ������ 'ȸ��ID'�� �Է¹޾Ƽ� ó���Ѵ�.
 	 3) �ڷ� �������� 'ȸ��ID'�� ������� �ʴ´�.
 	 
 */
public class JdbcTest06 {
	static Scanner sc = new Scanner(System.in);
	
	
	static Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	
	public static void main(String[] args) {
		
		conn = DBUtil.getConnection();
		JdbcTest06 j = new JdbcTest06();
		j.start();
		
	}
	
	private void start() {
		
		while(true){

			System.out.println("==�۾�����==");
			System.out.println("1.�ڷ��߰� 2.�ڷ���� 3.�ڷ����4.��ü�ڷ����0.�۾���");
			System.out.print("����>");
			
			int input=sc.nextInt(); 
			sc.nextLine();
			switch(input){
			case 1:  add(); break;
			case 2:  delete();	break;
			case 3:  update(); break;
			case 4:  select(); break;
			case 0:  System.out.println("���α׷��� �����մϴ�.");
			        return;

			}
		}


	}

	private void add() {
		try {
			
			String sql = "select mem_id from MYMEMBER";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			String id = "";
			
			while(true){
				System.out.println("mem_id�� �Է����ּ���");
			    id = sc.nextLine();
				boolean flag = true;

				while(rs.next()){

					if(rs.getString("mem_id").equals(id)){
						System.out.println("�ߺ��Դϴ�. �ٽ��Է����ּ���");
						flag = false;
						break;
					}
				}
				if(flag){
					break;
				}
			}
			
			System.out.println("mem_name�� �Է����ּ���");
			String name = sc.nextLine();
			System.out.println("mem_pass�� �Է����ּ���");
			String pass = sc.nextLine();
			System.out.println("mem_tel�� �Է����ּ���");
			String tel = sc.nextLine();
			System.out.println("mem_addr�� �Է����ּ���");
			String addr = sc.nextLine();
			
			String sql2 = " insert into MYMEMBER values(? , ? , ? , ? , ?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pass);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			
			int cnt =pstmt.executeUpdate();
			
			System.out.println("��ȯ��: "+ cnt);
			if(cnt>0){
				System.out.println("insert ����");
			}else{
				System.out.println("insert ����");
			}

			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//�ڿ� �ݳ� : ������� ���� ��������

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
			if(pstmt!=null) try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
	
		}
	}
	
	
	private void delete() {
		try {
			
			System.out.println("������ ȸ��ID�� �Է��ϼ���");
			String did = sc.nextLine();
			
			String sql3 = "delete from MYMEMBER where mem_id = '" + did + "' ";
			
		/*	String sql3 = "delete from MYMEMBER where mem_id = ? ";*/
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql3);
			
	/*		pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, did);
			int cnt =pstmt.executeUpdate();*/
			
			System.out.println("��ȯ��: "+ cnt);
			
			if(cnt>0){
				System.out.println("delete ����");
			}else{
				System.out.println("delete ����");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//�ڿ� �ݳ� : ������� ���� ��������

			if(stmt!=null) try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		
		
	}
		
	}
	
	
	private void update() {
		
		try {
			System.out.println("������ ���ڵ��� mem_id�� �Է����ּ���");
			String uid = sc.nextLine();
			
			System.out.println("������ mem_name�� �Է����ּ���");
			String name = sc.nextLine();
			System.out.println("������ mem_pass�� �Է����ּ���");
			String pass = sc.nextLine();
			System.out.println("������ mem_tel�� �Է����ּ���");
			String tel = sc.nextLine();
			System.out.println("������ mem_addr�� �Է����ּ���");
			String addr = sc.nextLine();
			
			String sql4 = "update MYMEMBER set mem_name = ?, mem_pass = ?, mem_tel = ?, mem_addr = ? where mem_id = '" + uid + "' ";
			pstmt = conn.prepareStatement(sql4);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			
			int cnt =pstmt.executeUpdate();

			System.out.println("��ȯ��: "+ cnt);
			if(cnt>0){
				System.out.println("update ����");
			}else{
				System.out.println("update ����");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//�ڿ� �ݳ� : ������� ���� ��������

			if(pstmt!=null) try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		
	}
		
	}
		
	
	
	private void select() {
		try {
			String sql5 = "select * from MYMEMBER";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql5);
			
			
			while(rs.next()){
	   
	    		System.out.println("mem_id: "+rs.getString("mem_id"));
	    		System.out.println("mem_name: "+rs.getString("mem_name"));
	    		System.out.println("mem_pass: "+rs.getString("mem_pass"));
	    		System.out.println("mem_tel: "+rs.getString("mem_tel"));
	    		System.out.println("mem_addr: "+rs.getString("mem_addr"));
	    		System.out.println();
	    	
	    	}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//�ڿ� �ݳ� : ������� ���� ��������
			if(stmt!=null) try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(rs!=null) try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		
	}
		
	}



}
