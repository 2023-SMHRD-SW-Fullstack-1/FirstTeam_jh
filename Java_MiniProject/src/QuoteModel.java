
public class QuoteModel {

	private String title;  
	private String quotePath;
	private String hint;
	
	// 생성자
	public QuoteModel(String title, String quotePath, String hint) {
		this.title = title;
		this.quotePath = quotePath;
		this.hint = hint;
	}
	

	public String getTitle() {
		return title;
	}

	public String getQuotePath() {
		return quotePath;
	}


	public String getHint() {
		return hint;
	}


	
	
}
