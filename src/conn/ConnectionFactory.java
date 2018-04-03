package conn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private static ConnectionFactory instance = new ConnectionFactory();
	
	public static ConnectionFactory getInstance() {
		if(instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}
	
	private ConnectionFactory () {
		
		try {
			
			Properties prop = new Properties();
			
			prop.load(new FileReader("src/db.properties"));
			
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		
			Class.forName(driver);		// 드라이버 로딩
			System.out.println("드라이버 로딩 성공......");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
}
