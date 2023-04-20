import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BonusController {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String input;
	String answer = null;

	public void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String id = "campus_k_0417_4";
			String pw = "smhrd4";

			conn = DriverManager.getConnection(url, id, pw); // 접속 성공

		} catch (ClassNotFoundException | SQLException e) { // 접속 실패
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BonusModel> bonusGame() {
		getConn();
		ArrayList<BonusModel> bonusGame = new ArrayList<BonusModel>();

		try {
			String sql = "select * from 넌센스퀴즈정보";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				String question = rs.getString(1);
				String answer = rs.getString(2);

				BonusModel mo = new BonusModel(question, answer);
				bonusGame.add(mo);
			}
		} catch (SQLException e) {
			System.out.println("쿼리문 오류");
			e.printStackTrace();
		}
		return bonusGame;
	}

}
