import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
	      String id = "";
	      String pw = "";
	      String nick = "";
	      boolean isLogin = false;
	      UserDao dao = new UserDao();
	      
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
	          String inputId = sc.next();
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
//	            // 명대사 문제
//	            System.out.println("명대사 듣고 영화 제목 맞추기 시작!! ");
//	    		
//	    		for(int i = 1; i <= 10; i++) {
//	    			System.out.println("< "+i+"번째 문제 >");
//	    			QuoteController quote = new QuoteController();
//	    			quote.playQuoteQuiz();
//	    		}
//	    		
//	    		// OST 문제
//	    		System.out.println("OST듣고 영화 제목 맞추기!!");
//	    		for(int i = 1; i <= 10; i++) {
//	    			System.out.println("< "+i+"번째 문제 >");
//	    			OstController ost = new OstController();
//	    			ost.playOstQuiz();
//	    		}
//	            
	    		System.out.println("영화 제목 맞추기 게임 종료!");
	    		
	    		//넌센스 퀴즈 
	    	     Controller con = new Controller();
	    	     System.out.println("===넌센스 게임 start!===");
	    	
	    	     ArrayList<Model> m = con.bonusGame();
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
	    	    	 }else {
	    	    		 System.out.printf("틀렸습니다ㅠㅠ 정답은 '%s'입니다\n\n",answer); 
	    	    	 }
	    	     	}
	    	     }
	    	     System.out.println("보너스 게임 꿑~");
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
	      
	      // 랭킹 조회(오름차순)
	      System.out.println("=== 랭킹 순위 ===");
	        System.out.println("-ID- \t\t  -NICK-");
	      ArrayList<UserDto> userList = dao.UserList();
	      for(int i = 0; i<userList.size();i++) {
	          id = userList.get(i).getId();
	          nick = userList.get(i).getNick();
	         System.out.println(id+" \t\t"+nick);
	      }

	}
	      
	
}



//	       명대사로 영화제목 맞추기
	  	
	      
	 
//	      int mod2;
//	      while (true) {
//	          String[] qa = getRandQAFromDB(); // DB에서 랜덤한 문제와 정답 가져오기
//	          String question = qa[0]; // 문제
//	          String answer = qa[1]; // 정답
	//
//	           명대사 음성 재생 코드
//	          String audioFilePath = getAudioFilePathFromDB(question);
//	          playAudio(audioFilePath);
////	           getRandQAFromDB()와 getAudioFilePathFromDB()는 DB에서 랜덤한 문제와 정답, 그리고 명대사 음성 파일 경로를 가져오는 함수
////	           playAudio() 함수는 해당 경로의 음성 파일을 재생하는 함수
////	           playAudio(audioFilePath);에서 예를 들어, "C:/Users/MyUser/Music/song.mp3"와 같은 경로를 매개변수로 넣을 수 있음
//	          System.out.print(question);
//	          String userAnswer = sc.nextLine();
	//
//	          if (userAnswer.equals(answer)) {
//	              System.out.println("정답입니다!");
//	          } else {
//	              System.out.println("틀렸습니다ㅠㅠ");
//	              wrongCount++;
	//
//	              if (wrongCount >= 3) {
//	                  System.out.println("정답은 " + answer + "였습니다ㅠㅠ");
//	                  break;
//	              }
//	          }
	//
//	          mode2++;
//	          if (mode2 == 10) {
//	              System.out.println("기회가 없습니다.");
//	              break;
//	       계속 진행

//	      while (true) {
//	         System.out.print("다른 문제를 계속 푸시겠습니까? [1]Yes [2]No");
//	         int choice2 = sc.nextInt();
//	      
//	         if (choice2 == 1) {
//	            break;
//	         } else if (choice2 == 2) {
//	            break;
//	         } else {
//	            System.out.println("옳은 번호를 선택하세요.");
//	            continue;
//	         }
//
//	      }




	


