package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import beens.AdminBean;



public class AdminDAO extends DAO {

	public AdminDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	//管理者一覧取得するメソッド
	public List<AdminBean> adminList() throws Exception{
		List<AdminBean> returnList = new ArrayList<AdminBean>();

		String sql = "SELECT * "+
				"FROM admin_list";

		PreparedStatement statement = getPretaredStatement(sql);

		ResultSet rs = statement.executeQuery();

		while(rs.next()) {
			AdminBean admin = new AdminBean();

			admin.setCode(rs.getInt("adm_code"));
			admin.setId(rs.getString("adm_id"));
			admin.setNick(rs.getString("adm_nick"));
			admin.setPw(rs.getString("adm_pw"));
			admin.setMail(rs.getString("adm_mail"));
			admin.setDate(rs.getString("adm_date"));
			admin.setPre(rs.getString("adm_pre"));

			returnList.add(admin);
		}

		return returnList;

	}
	//管理者新規登録をするメソッド　引数にAdminBean型変数を入れる
	public int tourokuInsert(AdminBean admin) throws Exception{
		String sql ="INSERT INTO team0.admin_list (adm_id,adm_nick,adm_pw,adm_mail,adm_date) " +
				"VALUES(?,?,?,?,now())";
		int result = 0;

		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, admin.getId());
			statement.setString(2, admin.getNick());
			statement.setString(3, admin.getPw());
			statement.setString(4, admin.getMail());

			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}
		return result;
	}
	//管理者詳細を呼び出すメソッド　引数に管理者IDを入れるとAdminBean型で返ってくる
	public AdminBean detail(String id)  throws Exception{
		String sql = "SELECT * " +
				"FROM team0.admin_list " +
				"WHERE adm_id = ?";
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, id);

			ResultSet rs = statement.executeQuery();
			AdminBean adm = new AdminBean();
			try {
			while(rs.next()) {
				adm.setCode(rs.getInt("adm_code"));
				adm.setId(rs.getString("adm_id"));
				adm.setNick(rs.getString("adm_nick"));
				adm.setPw(rs.getString("adm_pw"));
				adm.setMail(rs.getString("adm_mail"));
				adm.setDate(rs.getString("adm_date"));
			}

			return adm;
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
		//管理者編集するメソッド　引数にAdminBean型を入れIDで変更箇所を指定
	public int tourokuEdit(AdminBean adm) throws Exception{
		String sql = "UPDATE admin_list " +
				"SET adm_nick = ?, adm_pw = ? , adm_mail = ? " +
				"WHERE adm_id = ?";
		int result = 0;
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, adm.getNick());
			statement.setString(2, adm.getPw());
			statement.setString(3, adm.getMail());
			statement.setString(4, adm.getId());

			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}
		return result;

	}
	//管理者削除するメソッド　引数にIDを入れ管理者を削除
	//IDがマスターの時何もしない
	public int delete(String id) throws Exception{
		if(id.equals("ADMIN01")) {
			return 0;
		}
		String sql = "DELETE FROM team0.admin_list WHERE adm_id = ?";

		int result = 0;
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, id);

			result = statement.executeUpdate();
			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}

		return result;
	}
}
