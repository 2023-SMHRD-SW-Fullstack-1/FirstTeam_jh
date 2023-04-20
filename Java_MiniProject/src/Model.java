
public class Model {
	private String quiz;
	private String answer;
	
	public Model(String quiz, String answer) {
		super();
		this.quiz = quiz;
		this.answer = answer;
	}

	public String getQuiz() {
		return quiz;
	}

	public String getAnswer() {
		return answer;
	}
}
