import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;


public class QuoteController {

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	ArrayList<QuoteModel> movieList = new ArrayList<QuoteModel>(); // 곡에 대한 정보를 가지고 있는 VO객체 Model
	
	MP3Player mp3 = new MP3Player();
	private int lastPlayedIndex = -1;
	
	int index = rd.nextInt(18)+1 ;
	// 배열을 개수의 크기만큼 넣고 겹치지않게 넣고, 시행할 때 배열 순서대로
	// 순서는 정해진 거예요? 랜
	
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
				System.out.println("< 초성 HINT : "+movieList.get(index).getHint()+" >");
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
		stop();
	}		
	
}