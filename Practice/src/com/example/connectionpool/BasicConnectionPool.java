package com.example.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnectionPool implements ConnectionPool{

	
	private String username;
	private String password;
	private String url;
	
	private List<Connection> connectionPool;
	private List<Connection> usedConnection = new ArrayList<>(10);
	private static final Integer INITIAL_POOL_SIZE = 10;
	private static final Integer MAX_POOL_SIZE = 20;
	
	
	public BasicConnectionPool(String url, String username, String password, List<Connection> pool) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.connectionPool = pool;
	}

	public static BasicConnectionPool create(String url,String username, String password) throws SQLException{
		
		List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			pool.add(createConnection(url,username,password));
		}
		return new BasicConnectionPool(url,username,password,pool) ;
		
	}
	
	private static Connection createConnection(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	@Override
	public Connection getConnection() throws IllegalAccessException, SQLException {
		
		if(connectionPool.isEmpty()){
			
			if(usedConnection.size() < MAX_POOL_SIZE){
				connectionPool.add(createConnection(url, username, password));
			}else{
				throw new IllegalAccessException();
			}
		}
		
		
		Connection conn = connectionPool.remove(connectionPool.size() - 1);
		usedConnection.add(conn);
		return conn;
	}

	@Override
	public int getSize() {
		return usedConnection.size() + connectionPool.size();
	}

	@Override
	public void releaseConnection(Connection connection) {
		
		connectionPool.add(connection);
         usedConnection.remove(connection);
         
         
	}

	

}
