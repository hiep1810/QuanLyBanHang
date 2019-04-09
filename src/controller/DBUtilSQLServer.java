package controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilSQLServer {
	private static Connection connection;
	static final String JDBC_DRIVER = "org.sqlite.JDBC";
	static final String DB_URL = "jdbc:sqlserver://localhost;databaseName=QLBH;user=sa;password=123456";
	
	//check the connection :
	public void checkConnection() {
		        try {
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            connection = DriverManager.getConnection(DB_URL);
		            if(connection != null) {
		                DatabaseMetaData metaObj = (DatabaseMetaData) connection.getMetaData();
		                System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
		            }
		        } catch(Exception sqlException) {
		            sqlException.printStackTrace();
		        }
		        try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

	public Connection getConnection() {
		
			try {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		
	}

}
	
	
