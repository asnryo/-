package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO implements AutoCloseable {

	private Connection connection = null;

	public DAO() {

	}

	public Connection getConnection() throws Exception{

		try {
			if(connection == null || connection.isClosed()) {
				InitialContext initCtx = new InitialContext();
					DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/localDB");
				connection = ds.getConnection();
			}
		}catch(NamingException|SQLException e) {
			e.printStackTrace();
			connection = null;
			throw e;
		}
		return connection;
	}

	public void closeConnection() {
		try {
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection = null;
		}
	}

	public PreparedStatement getPretaredStatement(String sql) throws Exception{
		return getConnection().prepareStatement(sql);
	}


	public void commit() throws SQLException{
		connection.commit();
	}

	public void rollback() throws SQLException{
		connection.rollback();
	}

	@Override
	public void close() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("close connection ----------------------------------");

		try {
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection = null;
		}

	}

}
