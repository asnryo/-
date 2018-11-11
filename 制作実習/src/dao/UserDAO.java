package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import beens.UserBean;



public class UserDAO extends DAO {

	public UserDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	//ユーザー一覧取得するメソッド
	public List<UserBean> userList() throws Exception{
		List<UserBean> returnList = new ArrayList<UserBean>();

		String sql = "SELECT * "+
				"FROM user_list";

		PreparedStatement statement = getPretaredStatement(sql);

		ResultSet rs = statement.executeQuery();

		while(rs.next()) {
			UserBean user = new UserBean();

			user.setCode(rs.getInt("user_code"));
			user.setId(rs.getString("user_id"));
			user.setNick(rs.getString("user_nick"));
			user.setPw(rs.getString("user_pw"));
			user.setMail(rs.getString("user_mail"));
			user.setDate(rs.getString("user_date"));
			user.setPre(rs.getString("user_pre"));

			returnList.add(user);
		}

		return returnList;

	}

	//ユーザー新規登録をするメソッド　UserBean型を入れると追加
	public int tourokuInsert(UserBean user) throws Exception{
		String sql ="INSERT INTO team0.user_list (user_id,user_nick,user_pw,user_mail,user_date) " +
				"VALUES(?,?,?,?,now())";
		int result = 0;

		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, user.getId());
			statement.setString(2, user.getNick());
			statement.setString(3, user.getPw());
			statement.setString(4, user.getMail());

			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}
		return result;
	}
	//ユーザー詳細を呼び出すメソッド　引数にString id を入れるとUserBean型が返ってくる
	public UserBean detail(String id)  throws Exception{
		String sql = "SELECT * " +
				"FROM team0.user_list " +
				"WHERE user_id = ?";
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, id);


			ResultSet rs = statement.executeQuery();
			UserBean user = new UserBean();
			while(rs.next()) {

				user.setCode(rs.getInt("user_code"));
				user.setId(rs.getString("user_id"));
				user.setNick(rs.getString("user_nick"));
				user.setPw(rs.getString("user_pw"));
				user.setMail(rs.getString("user_mail"));
				user.setDate(rs.getString("user_date"));
			}

			return user;
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
		//ユーザー編集するメソッド　引数にUserBeanを入れるとidに対応するデータを更新
	public int tourokuEdit(UserBean user) throws Exception{
		String sql = "UPDATE user_list " +
				"SET user_nick = ?, user_pw = ? , user_mail = ? " +
				"WHERE user_id = ?";
		int result = 0;
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, user.getNick());
			statement.setString(2, user.getPw());
			statement.setString(3, user.getMail());
			statement.setString(4, user.getId());

			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}
		return result;

	}
	//ユーザー削除するメソッド　idを入れるとデータから削除
	public int delete(String user) throws Exception{
		String sql = "DELETE FROM team0.user_list WHERE user_id = ?";

		int result = 0;
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, user);

			result = statement.executeUpdate();
			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}

		return result;
	}
}
