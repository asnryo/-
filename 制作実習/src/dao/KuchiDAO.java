package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import beens.KuchiBean;

public class KuchiDAO extends DAO {

	//イベントごとの口コミ一覧を取得　イベントコードを入力すると
	//該当するKuchiBean Listをニックネームを付けて取得
	public List<KuchiBean> kuchiList(int eCode) throws Exception{
		List<KuchiBean> returnList = new ArrayList<KuchiBean>();
		String sql ="SELECT kuchi_code , ev_code , kuchi.user_id , user_nick , kuchi_des , kuchi_date , hoshi " +
				"FROM team0.kuchi_list kuchi " +
				"LEFT OUTER JOIN team0.user_list userl " +
				"ON userl.user_id = kuchi.user_id " +
				"WHERE ev_code = ?";
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setInt(1, eCode);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				KuchiBean kuchi = new KuchiBean();

				kuchi.setkCode(rs.getInt("kuchi_code"));
				kuchi.seteCode(rs.getInt("ev_code"));
				kuchi.setUserid(rs.getString("user_id"));
				kuchi.setUserNick(rs.getString("user_nick"));
				kuchi.setDes(rs.getString("kuchi_des"));
				kuchi.setDate(rs.getString("kuchi_date"));
				kuchi.setHoshi(rs.getInt("hoshi"));

				returnList.add(kuchi);
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}
		return returnList;
	}

	//口コミを追加 KuchiBean型を引数に渡すと追加
	public int tourokuInsert(KuchiBean kuchi) throws Exception{
		String sql = "INSERT INTO team0.kuchi_list (ev_code, user_id, kuchi_des, kuchi_date, hoshi) " +
				"VALUES(?,?,?,now(),?)";
		int result = 0;

		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setInt(1, kuchi.geteCode());
			statement.setString(2, kuchi.getUserid());
			statement.setString(3, kuchi.getDes());
			statement.setInt(4, kuchi.getHoshi());

			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}
		return result;

	}

	//口コミ編集 kCodeの入ったKuchiBean型を引数に渡すとそのkCodeの口コミを編集する
	public int tourokuEdit(KuchiBean kuchi) throws Exception{
		String sql = "UPDATE team0.kuchi_list " +
				"SET kuchi_des = ?, hoshi = ? " +
				"WHERE kuchi_code = ?";
		int result = 0;
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, kuchi.getDes());
			statement.setInt(2, kuchi.getHoshi());
			statement.setInt(3, kuchi.getkCode());
			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}
		return result;
	}

	//口コミを削除するメソッド  口コミコードを引数に入れるとそれを削除
	public int delete(int kCode) throws Exception{
		String sql = "DELETE FROM team0.kuchi_list WHERE kuchi_code = ?";

		int result = 0;
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setInt(1, kCode);

			result = statement.executeUpdate();
			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}

		return result;
	}
}
