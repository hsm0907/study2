package conn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
	
	private static Vector<Connection> pool = new Vector<>();
	
	private static ConnectionPool instance = new ConnectionPool();
	
	public static ConnectionPool getInstance() {
		if(instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}
	
	private ConnectionPool () {
		try {
			initPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 커넥션 풀 초기화
	private synchronized void initPool () throws SQLException {
		
		destroyPool();
		
		ConnectionFactory factory = ConnectionFactory.getInstance();
		
		for(int i = 0; i < 10; i++) {
			pool.add(factory.getConnection());
		}
		
	}
	
	// 커넥션  풀 제거
	private synchronized void destroyPool () throws SQLException {
		for(Connection conn : pool) {
			conn.close();
		}
		pool.clear();
	}
	
	// 커넥션 대여.
	public synchronized Connection getConnection( ) throws InterruptedException {
		
		while(pool.size() == 0) {
			wait();
		}
		
		Connection conn = pool.remove(pool.size() - 1);
		
		return conn;
	}
	
	// 커넥션 반납.
	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		notifyAll();
	}
}
