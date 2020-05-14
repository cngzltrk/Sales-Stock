package tr.com.deneme.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import tr.com.deneme.interfaces.CoreInterfaces;

public class ObjectHelper extends  CoreFields implements CoreInterfaces{

	

	@Override
	public Connection getConnection() {
		Connection connection =null;
		try {
			connection= DriverManager.getConnection(getUrl(),getUserName(),getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}

}
