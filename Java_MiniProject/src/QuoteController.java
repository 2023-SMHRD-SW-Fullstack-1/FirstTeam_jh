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


public class QuoteController {


	
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	ArrayList<QuoteModel> movieList = new ArrayList<QuoteModel>(); // 곡에 대한 정보를 가지고 있는 VO객체 Model
	
	MP3Player mp3 = new MP3Player();
	
	int index = 0;

	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	private String InputId;
	private String InputPw;
	private String nick;
	int rank;
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
				
				UserDto dto = new UserDto(id, pw, nick,rank); 
				userList.add(dto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		close();
		return userList;
	}
	
	// 생성자
	public QuoteController() {
		
		movieList.add(new QuoteModel("7번방의선물", "Quote/7번방의선물.mp3","7ㅂㅂㅇㅅㅁ"));
		movieList.add(new QuoteModel("곡성", "Quote/곡성.mp3","ㄱㅅ"));
		movieList.add(new QuoteModel("관상", "Quote/관상.mp3","ㄱㅅ"));
		movieList.add(new QuoteModel("내부자들", "Quote/내부자들.mp3","ㄴㅂㅈㄷ"));
		movieList.add(new QuoteModel("말아톤", "Quote/말아톤.mp3","ㅁㅇㅌ"));
		movieList.add(new QuoteModel("범죄도시", "Quote/범죄도시.mp3","ㅂㅈㄷㅅ"));
		movieList.add(new QuoteModel("베테랑", "Quote/베테랑.mp3","ㅂㅌㄹ"));
		movieList.add(new QuoteModel("부당거래", "Quote/부당거래.mp3","ㅂㄷㄱㄹ"));
		movieList.add(new QuoteModel("스타워즈", "Quote/스타워즈.mp3","ㅅㅌㅇㅈ"));
		movieList.add(new QuoteModel("신세계", "Quote/신세계.mp3","ㅅㅅㄱ"));
		movieList.add(new QuoteModel("아수라", "Quote/아수라.mp3","ㅇㅅㄹ"));
		movieList.add(new QuoteModel("암살", "Quote/암살.mp3","ㅇㅅ"));
		movieList.add(new QuoteModel("엽기적인그녀", "Quote/엽기적인그녀.mp3","ㅇㄱㅈㅇㄱㄴ"));
		movieList.add(new QuoteModel("올드보이", "Quote/올드보이.mp3","ㅇㄷㅂㅇ"));
		movieList.add(new QuoteModel("친절한금자씨", "Quote/친절한금자씨.mp3","ㅊㅈㅎㄱㅈㅆ"));
		movieList.add(new QuoteModel("타이타닉", "Quote/타이타닉.mp3","ㅌㅇㅌㄴ"));
		movieList.add(new QuoteModel("택시운전사", "Quote/택시운전사.mp3","ㅌㅅㅇㅈㅅ"));
		movieList.add(new QuoteModel("해리포터", "Quote/해리포터.mp3","ㅎㄹㅍㅌ"));
		movieList.add(new QuoteModel("해바라기", "Quote/해바라기.mp3","ㅎㅂㄹㄱ"));
		
		Collections.shuffle(movieList);
	}
	
	
	public void play() {

		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(movieList.get(index).getQuotePath());
	
	}
	
	
	public void stop() {
		mp3.stop(); 
	}
	
	public void playQuoteQuiz() {
		
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

		         System.out.println(score);
				
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