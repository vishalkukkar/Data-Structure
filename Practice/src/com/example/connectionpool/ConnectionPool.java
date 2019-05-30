package com.example.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {

	
	Connection getConnection() throws IllegalAccessException, SQLException;
	
	int getSize();
	
	void releaseConnection(Connection connection);
}
