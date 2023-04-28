import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		  String inputId = "hi";
	      String id = "";
	      String pw = "";
	      String nick = "";
	      int rank ;
	      boolean isLogin = false;
	      UserDao dao = new UserDao();
	      int bonusScore=0;
	      ArrayList<UserDto> userList = dao.UserList();
	      
	      System.out.println(" ▄▄       ▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄               ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄       ▄▄  ▄▄▄▄▄▄▄▄▄▄▄      ");   
	      System.out.println("▐░░▌     ▐░░▌▐░░░░░░░░░░░▌▐░▌             ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌     ▐░░▌▐░░░░░░░░░░░▌     ");         
	      System.out.println("▐░▌░▌   ▐░▐░▌▐░█▀▀▀▀▀▀▀█░▌ ▐░▌           ▐░▌  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀      ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌   ▐░▐░▌▐░█▀▀▀▀▀▀▀▀▀      ");      
	      System.out.println("▐░▌▐░▌ ▐░▌▐░▌▐░▌       ▐░▌  ▐░▌         ▐░▌       ▐░▌     ▐░▌               ▐░▌          ▐░▌       ▐░▌▐░▌▐░▌ ▐░▌▐░▌▐░▌               ");      
	      System.out.println("▐░▌ ▐░▐░▌ ▐░▌▐░▌       ▐░▌   ▐░▌       ▐░▌        ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄      ▐░▌ ▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▐░▌ ▐░▌▐░█▄▄▄▄▄▄▄▄▄      ");      
	      System.out.println("▐░▌  ▐░▌  ▐░▌▐░▌       ▐░▌    ▐░▌     ▐░▌         ▐░▌     ▐░░░░░░░░░░░▌     ▐░▌▐░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░░░░░░░░░░░▌     ");   
	      System.out.println("▐░▌   ▀   ▐░▌▐░▌       ▐░▌     ▐░▌   ▐░▌          ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀      ▐░▌ ▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌   ▀   ▐░▌▐░█▀▀▀▀▀▀▀▀▀   ");         
	      System.out.println("▐░▌       ▐░▌▐░▌       ▐░▌      ▐░▌ ▐░▌           ▐░▌     ▐░▌               ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ");      
	      System.out.println("▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌       ▐░▐░▌        ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄      ▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄      ");      
	      System.out.println("▐░▌       ▐░▌▐░░░░░░░░░░░▌        ▐░▌        ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌     ");      
	      System.out.println(" ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀          ▀          ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀      ");
	      
	      	      
	      // 회원가입, 로그인, 종료 선택
	      QuoteController quote = new QuoteController();
	      OstController ost = new OstController();
	      
	      while (true) {
	         
	         System.out.print("[1]회원가입 [2]로그인 [3]종료 ");
	         int choice = sc.nextInt();
	         sc.nextLine();
	         
	         // 1. 회원가입
	         if (choice == 1) {
	            System.out.print("ID를 입력하세요: ");
	            id = sc.nextLine();
	            System.out.print("PW를 입력하세요: ");
	            pw = sc.nextLine();
	            System.out.print("닉네임을 입력하세요: ");
	            nick = sc.nextLine();
	            
	            int result = dao.sign(id, pw, nick);
	            
	            if(result>0) { //리턴값으로 성공 실패 판단.
	            	System.out.println("회원가입 성공!");
	            } else {
	            	System.out.println("회원가입 실패!");
	            }
	            
//	            
//	         // 2. 로그인
	            
	         }  else if (choice == 2) {
	            
		      System.out.print("ID를 입력하세요: ");
	          inputId = sc.next();
	          System.out.print("PW를 입력하세요: ");
	          String inputPw = sc.next();

		          nick = dao.login(inputId, inputPw);
		          
		       if(nick != null) {
		          System.out.println(nick+"님 환영합니다!");
		          isLogin = true;
		       }else {
		          System.out.println("로그인 실패!");
		          System.out.println("아이디 또는 비밀번호를 확인해주세요.");
		       }
	            
	            if(isLogin) {// 로그인 성공 시
	            // 명대사 문제
	            System.out.println("명대사 듣고 영화 제목 맞추기 시작!! ");
	    		
	    		for(int i = 1; i <= 10; i++) {
	    			System.out.println("\n< "+i+"번째 문제 >");
	    			
	    			quote.playQuoteQuiz();
	    		}
	    		
	    		// OST 문제
	    		System.out.println("\n\nOST듣고 영화 제목 맞추기!!");
	    		for(int i = 1; i <= 10; i++) {
	    			System.out.println("\n< "+i+"번째 문제 >");
	    			
	    			ost.playOstQuiz();
	    		}
	            
	    		System.out.println("영화 제목 맞추기 게임 종료!\n\n");
	    		
	    		//넌센스 퀴즈 
	    	     BonusController con = new BonusController();
	    	     System.out.println("===넌센스 게임 start!===");
	    	
	    	     
	    	     
	    	     ArrayList<BonusModel> m = con.bonusGame();
	    	     if(m.size()>0) {
	    	     for(int i=0;i<m.size();i++) {
	    	    	 String question = m.get(i).getQuiz();
	    	    	 String answer = m.get(i).getAnswer();
	    	    	 System.out.println(question);
	    	    	 System.out.print("답 : ");
	    	    	 sc.nextLine();
	    	    	 String input = sc.next();
	    	    	 if(input.equals(answer)) {
	    	    		 System.out.println("정답입니다!\n");
	    	    		 bonusScore+=3;
	    	    	 }else {
	    	    		 System.out.printf("틀렸습니다ㅠㅠ 정답은 '%s'입니다\n\n",answer); 
	    	    	 }
	    	     	}
	    	     }
	    	     System.out.println("보너스 게임 끝~");
	    	     break;
	            }

	            // 3. 종료
		         } else if (choice == 3) {
		            System.out.println("게임을 종료합니다.");
		            break;
	
		         // 4. 옳은 번호 선택
		         } else {
		            System.out.println("옳은 번호를 선택하세요.");
		            continue;
	     	}	     
	         
	      }  
	         
	      int totalScore = ost.score+quote.score+bonusScore;
	      int score = ost.returnScore(totalScore, inputId);
	      System.out.println("\n[ 당신의 점수는 " + totalScore+"점! ]\n");
	      
	      // 여기부터 다시 손대기 시작!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	      dao.RankUpdate(totalScore, inputId);
	      
	      
	      
	      // 랭킹 조회(오름차순)
	     
	    
	 System.out.println("=== 랭킹 순위 ===");
     System.out.println("-ID- \t\t  -NICK- \t\t -RANK-");
   
   for(int i = 0; i<userList.size();i++) {
       id = userList.get(i).getId();
       nick = userList.get(i).getNick();
       rank = userList.get(i).getRank();
       
      System.out.println(id+" \t\t"+nick+" \t\t"+rank);
	      
	
}
}
}








	


