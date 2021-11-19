package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 	회원을 관리하는 프로그램을 작성하시오. (MYMEMBER 테이블 이용)
 	아래 메뉴의 기능을 모두 구현하시오. (CRUD 기능 구현하기)
 	메뉴예시) 
 	 -- 작업 선택 --
 	 1. 자료추가
 	 2. 자료삭제
 	 3. 자료수정 UPDATE
 	 4. 전체자료출력
 	 0. 작업끝
 	 
 	 처리조건)
 	 1) 자료추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력 받는다.)
 	 2) 삭제는 '회원ID'를 입력받아서 처리한다.
 	 3) 자료 수정에서 '회원ID'는 변경되지 않는다.
 	 
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

			System.out.println("==작업선택==");
			System.out.println("1.자료추가 2.자료삭제 3.자료수정4.전체자료출력0.작업끝");
			System.out.print("선택>");
			
			int input=sc.nextInt(); 
			sc.nextLine();
			switch(input){
			case 1:  add(); break;
			case 2:  delete();	break;
			case 3:  update(); break;
			case 4:  select(); break;
			case 0:  System.out.println("프로그램을 종료합니다.");
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
				System.out.println("mem_id를 입력해주세요");
			    id = sc.nextLine();
				boolean flag = true;

				while(rs.next()){

					if(rs.getString("mem_id").equals(id)){
						System.out.println("중복입니다. 다시입력해주세요");
						flag = false;
						break;
					}
				}
				if(flag){
					break;
				}
			}
			
			System.out.println("mem_name를 입력해주세요");
			String name = sc.nextLine();
			System.out.println("mem_pass를 입력해주세요");
			String pass = sc.nextLine();
			System.out.println("mem_tel를 입력해주세요");
			String tel = sc.nextLine();
			System.out.println("mem_addr를 입력해주세요");
			String addr = sc.nextLine();
			
			String sql2 = " insert into MYMEMBER values(? , ? , ? , ? , ?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pass);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			
			int cnt =pstmt.executeUpdate();
			
			System.out.println("반환값: "+ cnt);
			if(cnt>0){
				System.out.println("insert 성공");
			}else{
				System.out.println("insert 실패");
			}

			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//자원 반납 : 만들어진 순의 역순으로

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
			
			System.out.println("삭제할 회원ID를 입력하세요");
			String did = sc.nextLine();
			
			String sql3 = "delete from MYMEMBER where mem_id = '" + did + "' ";
			
		/*	String sql3 = "delete from MYMEMBER where mem_id = ? ";*/
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql3);
			
	/*		pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, did);
			int cnt =pstmt.executeUpdate();*/
			
			System.out.println("반환값: "+ cnt);
			
			if(cnt>0){
				System.out.println("delete 성공");
			}else{
				System.out.println("delete 실패");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//자원 반납 : 만들어진 순의 역순으로

			if(stmt!=null) try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		
		
	}
		
	}
	
	
	private void update() {
		
		try {
			System.out.println("수정할 레코드의 mem_id를 입력해주세요");
			String uid = sc.nextLine();
			
			System.out.println("수정할 mem_name를 입력해주세요");
			String name = sc.nextLine();
			System.out.println("수정할 mem_pass를 입력해주세요");
			String pass = sc.nextLine();
			System.out.println("수정할 mem_tel를 입력해주세요");
			String tel = sc.nextLine();
			System.out.println("수정할 mem_addr를 입력해주세요");
			String addr = sc.nextLine();
			
			String sql4 = "update MYMEMBER set mem_name = ?, mem_pass = ?, mem_tel = ?, mem_addr = ? where mem_id = '" + uid + "' ";
			pstmt = conn.prepareStatement(sql4);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			
			int cnt =pstmt.executeUpdate();

			System.out.println("반환값: "+ cnt);
			if(cnt>0){
				System.out.println("update 성공");
			}else{
				System.out.println("update 실패");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			//자원 반납 : 만들어진 순의 역순으로

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
			//자원 반납 : 만들어진 순의 역순으로
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
