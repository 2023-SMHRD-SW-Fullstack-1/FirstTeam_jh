import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	      String id = "";
	      String pw = "";
	      String nick = "";
	      boolean isLogin = false;
	      UserDao dao = new UserDao();
	      
	      
	      System.out.println("영화제목 맞추기 게임!");//아스키코드로 꾸밀것!
	      
	      
	      
	      // 회원가입, 로그인, 종료 선택
	      while (true) {
	         
	         System.out.print("[1]회원가입 [2]로그인 [3]종료 ");
	         int choice = sc.nextInt();
	         sc.nextLine();

	         if (choice == 1) {//회원가입
	            System.out.print("ID를 입력하세요: ");
	            id = sc.nextLine();
	            System.out.print("PW를 입력하세요: ");
	            pw = sc.nextLine();
	            System.out.print("닉네임을 입력하세요: ");
	            nick = sc.nextLine();
	            
	            
	            int result = dao.sign(id, pw, nick);
	            
	            if(result>0) { //리턴값으로 성공 실패 판단.
	            	System.out.println("회원가입 성공!");
	            }else {
	            	System.out.println("회원가입 실패!");
	            }
	            
	            

	         } else if (choice == 2) {
	            // 로그인
	            System.out.print("ID를 입력하세요: ");
	            String inputId = sc.next();
	            System.out.print("PW를 입력하세요: ");
	            String inputPw = sc.next();
	            
	            dao.login(inputId, inputPw);

	            // DB에서 ID, PW 확인?

//	            if (id.equals(inputId) && pw.equals(inputPw)) {
//	               System.out.println(nick + "님, 환영합니다!");
//	               isLogin = true;
//	               break;
//	            } else {
//	               System.out.println("ID 또는 PW가 일치하지 않습니다.");
//	            }
//	         } else if (choice == 3) {
//	            System.out.println("게임을 종료합니다.");
//
//	         } else {
//	            System.out.println("옳은 번호를 선택하세요.");
	         }
	      }

	      // 게임모드 선택
//	      int mode = 0;
//	      while (true) {
//	         System.out.println("[1]명대사 듣고 영화제목 맞추기 [2]OST듣고 영화제목 맞추기");
//	         mode = sc.nextInt();
//
//	         if (mode == 1) {
//	            System.out.println("db");
//	            break;
//	         } else if (mode == 2) {
//	            System.out.println("db");
//	            break;
//	         } else {
//	            System.out.println("옳은 번호를 선택하세요.");
//	            continue;
//	         }
//	      }

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
	   }

	// 보너스 게임

	

}
