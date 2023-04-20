
public class OstModel {

	private String title;  
	private String ostPath;
	private String hint;
	
	// 생성자
	public OstModel(String title, String ostPath, String hint) {
		this.title = title;
		this.ostPath = ostPath;
		this.hint = hint;
		
	}
	

	public String getTitle() {
		return title;
	}

	public String getOstPath() {
		return ostPath;
	}


	public String getHint() {
		return hint;
	}

	
	
	
}
