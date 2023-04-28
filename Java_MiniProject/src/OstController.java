import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;


public class OstController {
	
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	private String InputId;
	private String InputPw;
	private String nick;
	int rank ;
	int score = 0;
	
	
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
	
	public String getInputId() {
		return InputId;
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
				
				UserDto dto = new UserDto(id, pw, nick, rank); 
				userList.add(dto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		close();
		return userList;
	}
	
	//점수계산
//	public int TotalScore(int InputAnswer) {
//		int Answer = 0;
//		for(int i=0; i<10;i++) {
//			Answer++;
//		}
//		int GameScore = Answer*10;
//		return GameScore;
//	}
	
	//랭킹등록
//	public void RankUpdate(int Score) {
//		getConn();
//		
//		int result = 0;
//        try {
//        	String sql = "insert into 회원정보(RANK) values (?)";
//			pstm = conn.prepareStatement(sql);
//			pstm.setInt(1,Score);
//			
//			result = pstm.executeUpdate();
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//        
//       close();
//		
//		
//	}
	
	

	ArrayList<OstModel> movieList = new ArrayList<OstModel>();
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	MP3Player mp3 = new MP3Player();
	
	
	int index = 0;
	
	UserDao dao = new UserDao();
	
	
	// 생성자
	public OstController() {
		movieList.add(new OstModel("건축학개론", "OST/건축학개론.mp3","ㄱㅊㅎㄱㄹ"));
		movieList.add(new OstModel("늑대의유혹", "OST/늑대의유혹.mp3","ㄴㄷㅇㅇㅎ"));
		movieList.add(new OstModel("라이언킹", "OST/라이언킹.mp3","ㄹㅇㅇㅋ"));
		movieList.add(new OstModel("맘마미아", "OST/맘마미아.mp3","ㅁㅁㅁㅇ"));
		movieList.add(new OstModel("반지의제왕", "OST/반지의제왕.mp3","ㅂㅈㅇㅈㅇ"));
		movieList.add(new OstModel("보헤미안랩소디", "OST/보헤미안랩소디.mp3","ㅂㅎㅁㅇㄹㅅㄷ"));
		movieList.add(new OstModel("사운드오브뮤직", "OST/사운드오브뮤직.mp3","ㅅㅇㄷㅇㅂㅁㅈ"));
		movieList.add(new OstModel("슬램덩크", "OST/슬램덩크.mp3","ㅅㄹㄷㅋ"));
		movieList.add(new OstModel("신세계", "OST/신세계.mp3","ㅅㅅㄱ"));
		movieList.add(new OstModel("아저씨", "OST/아저씨.mp3","ㅇㅈㅆ"));
		movieList.add(new OstModel("영웅", "OST/영웅.mp3","ㅇㅇ"));
		movieList.add(new OstModel("올드보이", "OST/올드보이.mp3","ㅇㄷㅂㅇ"));
		movieList.add(new OstModel("장화홍련", "OST/장화홍련.mp3","ㅈㅎㅎㄹ"));
		movieList.add(new OstModel("전우치", "OST/전우치.mp3","ㅈㅇㅊ"));
		movieList.add(new OstModel("착신아리", "OST/착신아리.mp3","ㅊㅅㅇㄹ"));
		movieList.add(new OstModel("친절한금자씨", "OST/친절한금자씨.mp3","ㅊㅈㅎㄱㅈㅆ"));
		movieList.add(new OstModel("캐리비안의해적", "OST/캐리비안의해적.mp3","ㅋㄹㄹㅇㅇㅎㅈ"));
		movieList.add(new OstModel("캣츠", "OST/캣츠.mp3","ㅋㅊ"));
		movieList.add(new OstModel("탑건", "OST/탑건.mp3","ㅌㄱ"));
		movieList.add(new OstModel("핑크팬더", "OST/핑크팬더.mp3","ㅍㅋㅍㄷ"));
		movieList.add(new OstModel("해리포터", "OST/해리포터.mp3","ㅎㄹㅍㅌ"));
		
		Collections.shuffle(movieList);

	}
	
	public void play() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(movieList.get(index).getOstPath());
	}
	
	public void stop() {
		mp3.stop(); 
	}
	
	public void playOstQuiz() {
		int chance = 1;
		String input;
		
		while(chance <= 3) {
			
			play();
			
			
			if(chance == 1 | chance == 2) {
				System.out.print("정답 입력 : ");
				input = sc.next().trim();
				input = input.trim().replaceAll("\\n", "");
			
				if(movieList.get(index).getTitle().equals(input)) {
					System.out.println("정답!");
					score += 10;
					mp3.stop();
					break;
				} else if (!movieList.get(index).getTitle().equals(input)) {
					System.out.println("틀렸습니다");
					mp3.stop();
					chance++;
			}
				
			} else if (chance == 3) {
				System.out.println("< 초성 HINT : "+movieList.get(index).getHint()+" >");
				System.out.print("정답 입력 : ");
				input = sc.next().trim();
				sc.nextLine();
				
				if(movieList.get(index).getTitle().equals(input)) {
					System.out.println("정답!");
					score += 10;
					mp3.stop();
					break;
				} else if (!movieList.get(index).getTitle().equals(input)) {
					System.out.println("틀렸습니다");
					System.out.println("정답은 ["+movieList.get(index).getTitle()+"] 였습니다!");
					mp3.stop();
					break;
				}
			}
			
		}
		
		mp3.stop();
		index++;
		
//		return score;
		
	}	
	
	
	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public int returnScore(int score, String InputId) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String id = "campus_k_0417_4";
			String pw = "smhrd4";
			
			conn = DriverManager.getConnection(url,id,pw); 
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		 try {
			   String sql = "update 회원정보 set RANK = ? where id = ?";
		         pstm = conn.prepareStatement(sql);
		         
		         pstm.setInt(1, score);
		         pstm.setString(2, InputId);
		         
		         int result =pstm.executeUpdate();

				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		
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
	
	
		return score;
	}
}	
