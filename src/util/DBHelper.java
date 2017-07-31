package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DBHelper {

	/**
	 * 加载驱动
	 * 
	 * @return
	 */
	private static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/nothingdb";
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 增
	 * 
	 * @param device
	 * @return
	 */
	public static int DBinsert(Integer num) {
		// 获取连接
		Connection conn = getConn();
		int i = 0;
		String sql = "INSERT INTO nothinginfo(number) VALUES('" + num + "')";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 查
	 * 
	 * @param device
	 * @return
	 */
	public static int DBselect(Integer num) {
		int i = 0;
		Connection conn = getConn();
		String sql = "SELECT COUNT(*) AS rowCount FROM nothinginfo WHERE number = '" + num + "'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			i = rs.getInt("rowCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 查全部
	 * 
	 * @return
	 */
	public static List<NothingInfo> DBselectAll() {
		List<NothingInfo> infolist = new ArrayList<>();
		Connection conn = getConn();
		String sql = "SELECT * FROM nothinginfo";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				NothingInfo info = new NothingInfo();
				info.setId(rs.getInt("id"));
				info.setName(rs.getString("name"));
				info.setNumber(rs.getInt("number"));
				infolist.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infolist;
	}

	/**
	 * 查总数
	 * @return
	 */
	public static int DBselectCount() {
		int i = 0;
		Connection conn = getConn();
		String sql = "SELECT COUNT(*) AS rowCount FROM nothinginfo";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			i = rs.getInt("rowCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
