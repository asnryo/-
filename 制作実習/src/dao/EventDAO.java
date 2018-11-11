package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import beens.EventBean;



public class EventDAO extends DAO {

  //イベント一覧取得するメソッド
  	public List<EventBean> eventList() throws Exception{
  		List<EventBean> returnList = new ArrayList<EventBean>();

  		String sql = "SELECT * "+
  				"FROM team0.ev_list order by end_day";

  		PreparedStatement statement = getPretaredStatement(sql);

  		ResultSet rs = statement.executeQuery();

  		while(rs.next()) {
  			EventBean ev = new EventBean();

  			ev.setCode(rs.getInt("ev_code"));
  			ev.setName(rs.getString("ev_name"));
  			ev.setDes(rs.getString("ev_des"));
  			ev.setOpenDate(rs.getString("op_day"));
  			ev.setEndDate(rs.getString("end_day"));
  			ev.setOpenTime(rs.getString("op_time"));
  			ev.setEndTime(rs.getString("end_time"));
  			ev.setSpot(rs.getString("spot"));
  			ev.setImg(rs.getString("ev_img"));
  			ev.setCate(rs.getString("cate"));
  			ev.setLink(rs.getString("link"));

  			returnList.add(ev);
  		}

  		return returnList;
  	}


	//イベント検索するメソッド
//  	public List<EventBean> eventSearch(String keyword) throws Exception{
//  		List<EventBean> returnList = new ArrayList<EventBean>();
//
//  		String sql = "SELECT * FROM team0.ev_list where ev_name like '%"+ keyword +"%' or ev_des like '%"+ keyword +"%'";
//
//  		PreparedStatement statement = getPretaredStatement(sql);
//  		ResultSet rs = statement.executeQuery();
//
//  		while(rs.next()) {
//  			EventBean ev = new EventBean();
//
//  			ev.setCode(rs.getInt("ev_code"));
//  			ev.setName(rs.getString("ev_name"));
//  			ev.setDes(rs.getString("ev_des"));
//  			ev.setOpenDate(rs.getString("op_day"));
//  			ev.setEndDate(rs.getString("end_day"));
//  			ev.setOpenTime(rs.getString("op_time"));
//  			ev.setEndTime(rs.getString("end_time"));
//  			ev.setSpot(rs.getString("spot"));
//  			ev.setImg(rs.getString("ev_img"));
//  			ev.setCate(rs.getString("cate"));
//  			ev.setLink(rs.getString("link"));
//
//  			returnList.add(ev);
//  		}
//  		return returnList;
//  	}
  	public List<EventBean> eventSearch(EventBean ev) throws Exception{
  		String name = ev.getName();
  		String cate = ev.getCate();
  		String spot = ev.getSpot();

  		String sql = "SELECT * FROM team0.ev_list where (ev_name like '%"+name+"%' or ev_des like '%"+name+"%')  "+
  				"and cate like'%"+cate+"%' and spot like '%"+spot+"%' ";
  		//開始日か終了日が入力されたら文字列連結で日にちを検索
  		System.out.println(ev.getOpenDate());
  		if(!(ev.getOpenDate().equals("") && ev.getEndDate().equals(""))) {
  			String openDate = ev.getOpenDate();
  			String endDate = ev.getEndDate();
  			//もし逆の場合交換
  			if(endDate.compareTo(openDate) < 0) {
  				String koukan = openDate;
  				openDate = endDate;
  				endDate = koukan;
  			}
  			sql = sql.concat("and ((\"" + openDate +"\" between op_day and end_day) or (\""+
  					endDate+"\" between op_day and end_day) ");
  			//両方入っている場合
  			if(!(ev.getOpenDate().equals("") || ev.getEndDate().equals(""))) {
  				sql = sql.concat("or (op_day between \""+ openDate + "\" and \""+ endDate + "\")) ");
  			}else {
  				sql = sql.concat(")");
  			}
  		}
  		sql = sql.concat("order by end_day");
  		try {
  			PreparedStatement statement = getPretaredStatement(sql);
//  			statement.setString(1, ev.getName());
//  			statement.setString(2, ev.getName());
//  			statement.setString(3, ev.getCate());
//  			statement.setString(4, ev.getSpot());
//  			statement.executeUpdate();


  			List<EventBean> returnList = new ArrayList<EventBean>();

  	  		ResultSet rs = statement.executeQuery();

  	  		while(rs.next()) {
  	  			EventBean ev2 = new EventBean();

  	  			ev2.setCode(rs.getInt("ev_code"));
  	  			ev2.setName(rs.getString("ev_name"));
  	  			ev2.setDes(rs.getString("ev_des"));
  	  			ev2.setOpenDate(rs.getString("op_day"));
  	  			ev2.setEndDate(rs.getString("end_day"));
  	  			ev2.setOpenTime(rs.getString("op_time"));
  	  			ev2.setEndTime(rs.getString("end_time"));
  	  			ev2.setSpot(rs.getString("spot"));
  	  			ev2.setImg(rs.getString("ev_img"));
  	  			ev2.setCate(rs.getString("cate"));
  	  			ev2.setLink(rs.getString("link"));

  	  			returnList.add(ev2);
  	  		}
  	  		return returnList;
  		}catch(Exception e) {
  			throw new ServletException(e);
  		}
  	}


  	//イベント新規登録をするメソッド
  	public int tourokuInsert(EventBean ev) throws Exception{
  		String sql ="INSERT INTO team0.ev_list (ev_name,ev_des,op_day,end_day,op_time,end_time,spot,ev_img,cate,link) " +
  				"VALUES(?,?,?,?,?,?,?,?,?,?)";
  		int result = 0;

  		try {
  			PreparedStatement statement = getPretaredStatement(sql);
  			statement.setString(1, ev.getName());
  			statement.setString(2, ev.getDes());
  			statement.setString(3, ev.getOpenDate());
  			statement.setString(4, ev.getEndDate());
  			statement.setString(5, ev.getOpenTime());
  			statement.setString(6, ev.getEndTime());
  			statement.setString(7, ev.getSpot());
  			statement.setString(8, ev.getImg());
  			statement.setString(9, ev.getCate());
  			statement.setString(10, ev.getLink());

  			result = statement.executeUpdate();

  			super.commit();
  		}catch(Exception e) {
  			super.rollback();
  			throw e;
  		}
  		return result;
  	}

  	//イベント詳細を呼び出すメソッド
  	public EventBean detail(int code)  throws Exception{
  		EventBean ev = new EventBean();

  		String sql = "SELECT * " +
  				"FROM team0.ev_list " +
  				"WHERE ev_code = ?";
  		try {
  			PreparedStatement statement = getPretaredStatement(sql);
  			statement.setInt(1, code);

  			ResultSet rs = statement.executeQuery();
  			while(rs.next()) {

  	  			ev.setCode(rs.getInt("ev_code"));
  	  			ev.setName(rs.getString("ev_name"));
  	  			ev.setDes(rs.getString("ev_des"));
  	  			ev.setOpenDate(rs.getString("op_day"));
  	  			ev.setEndDate(rs.getString("end_day"));
  	  			ev.setOpenTime(rs.getString("op_time"));
  	  			ev.setEndTime(rs.getString("end_time"));
  	  			ev.setSpot(rs.getString("spot"));
  	  			ev.setImg(rs.getString("ev_img"));
  	  			ev.setCate(rs.getString("cate"));
  	  			ev.setLink(rs.getString("link"));
  			}
  			return ev;

  		}catch(Exception e) {
  			throw new ServletException(e);
  		}
  	}

	//イベント編集するメソッド
	public int tourokuEdit(EventBean ev) throws Exception{
		String sql = "UPDATE team0.ev_list " +
				"SET ev_name = ?, ev_des = ? , op_day = ?, end_day = ? , op_time = ? , end_time = ?  , spot = ? , ev_img = ? , cate = ? , link = ? " +
				"WHERE ev_code = ?";
		int result = 0;
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setString(1, ev.getName());
  			statement.setString(2, ev.getDes());
  			statement.setString(3, ev.getOpenDate());
  			statement.setString(4, ev.getEndDate());
  			statement.setString(5, ev.getOpenTime());
  			statement.setString(6, ev.getEndTime());
  			statement.setString(7, ev.getSpot());
  			statement.setString(8, ev.getImg());
  			statement.setString(9, ev.getCate());
  			statement.setString(10, ev.getLink());
  			statement.setInt(11, ev.getCode());

			result = statement.executeUpdate();

			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}
		return result;
	}

	//イベント削除するメソッド
	public int delete(int code) throws Exception{
		String sql = "DELETE FROM team0.ev_list WHERE ev_code = ?";

		int result = 0;
		try {
			PreparedStatement statement = getPretaredStatement(sql);
			statement.setInt(1, code);

			result = statement.executeUpdate();
			super.commit();
		}catch(Exception e) {
			super.rollback();
			throw e;
		}

		return result;
	}


}

