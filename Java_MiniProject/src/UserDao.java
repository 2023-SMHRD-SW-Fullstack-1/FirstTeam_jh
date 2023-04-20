

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class UserDao {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	private String InputId;
	private String InputPw;
	private String nick;
	
	//DB연결
	public void getConn() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String id = "campus_k_0417_4";
			String pw = "smhrd4";
			
			conn = DriverManager.getConnection(url,id,pw); //<- DB 로그인
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//DB연결 해제
	public void close() {
		
		try{
			if (rs != null){
				rs.close();
			}
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//회원가입
	public int sign(String newId,String newPw,String nick) {
		
		getConn();
		int result = 0;
		
		try {
			// 아이디와 비밀번호 중복 확인
	         String sqlDistinct = "select count(*) from 회원정보 where ID = ? or NICK = ?";
	         pstm = conn.prepareStatement(sqlDistinct);
	         pstm.setString(1, newId);
	         pstm.setString(2, nick);
	         rs = pstm.executeQuery();
	         rs.next();
	         int count = rs.getInt(1);
	         if (count > 0) {
	             System.out.println("이미 가입된 아이디 또는 닉네임입니다.");
	             return -1;
	         } else {
	             // 회원가입 처리
	             String sql = "insert into 회원정보(ID, PW, NICK) values (?, ?, ?)";
	             pstm = conn.prepareStatement(sql);
	             pstm.setString(1, newId);
	             pstm.setString(2, newPw);
	             pstm.setString(3, nick);
	         }
			
			result = pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("쿼리문 오류");
			e.printStackTrace();
		}
		
		close();
		return result;
	}
	
	//로그인
	public String login(String InputId, String InputPw) {
		
		getConn();
		
		try {
			
			String sql = "select nick from 회원정보 where id = ? and pw = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,InputId);
			pstm.setString(2,InputPw);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				nick = rs.getString("nick");
			}
			
		} catch (SQLException e) {
			System.out.println("쿼리문 오류");
			e.printStackTrace();
		}
		close();
		return nick;
	}
	
	//랭킹조회
	public ArrayList<UserDto> UserList() {
		// 아이디, 닉네임, 스코어 저장된 것 출력하기.
		
		getConn();
		ArrayList<UserDto> userList = new ArrayList<>();
		
		String sql = "select * from 회원정보 order by RANK DESC";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery(); //쿼리 실행문
		
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String nick = rs.getString("nick");
				
				UserDto dto = new UserDto(id, pw, nick); 
				userList.add(dto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		close();
		return userList;
	}
	
	//점수계산
	public int TotalScore(int InputAnswer) {
		int Answer = 0;
		for(int i=0; i<10;i++) {
			Answer++;
		}
		int GameScore = Answer*10;
		return GameScore;
	}
	
	//랭킹등록
	public void RankUpdate(int Score) {
		getConn();
		
		int result = 0;
        try {
        	String sql = "insert into 회원정보(RANK) values (?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,Score);
			
			result = pstm.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
       close();
		
		
	}

}
