package App2.test;

import java.sql.*;

@SuppressWarnings("unused")
public class DBConnection {

	private static Connection con = null;

	private DBConnection() {
	}

	static {
		try {
			Class.forName(DBInfo.driver);
			con = DriverManager.getConnection(DBInfo.dbUrl, DBInfo.dbUName, DBInfo.dbPWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {

		return con;
	}
}
