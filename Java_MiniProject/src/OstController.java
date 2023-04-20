import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;


public class OstController {

	// 1. 
	ArrayList<OstModel> movieList = new ArrayList<OstModel>(); // 곡에 대한 정보를 가지고 있는 VO객체 Model
	
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	
	MP3Player mp3 = new MP3Player();
	
	int index = rd.nextInt(20)+1;
	
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
	
	}
	
	// 재생
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
			
			System.out.println(movieList.get(index).getTitle());
			
			if(chance == 1 | chance == 2) {
				System.out.print("정답 입력 : ");
				input = sc.next().trim();
				input = input.trim().replaceAll("\\n", "");
				

				if(movieList.get(index).getTitle().equals(input)) {
					System.out.println("정답!");
					mp3.stop();
					break;
				} else if (!movieList.get(index).getTitle().equals(input)) {
					System.out.println("틀렸습니다");
					mp3.stop();
					chance++;
			}
				
			} else if (chance == 3) {
				System.out.println("< 초성 HINT : "+movieList.get(index).getHint()+">");
				System.out.print("정답 입력 : ");
				input = sc.next().trim();
				sc.nextLine();
				
				if(movieList.get(index).getTitle().equals(input)) {
					System.out.println("정답!");
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
	}	
	
}	
