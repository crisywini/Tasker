package co.uniquindio.semester7.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements DatabaseConfigurationInit {

	protected Connection connection = instanceConnection();
	
	public DBConnection() {
		
	}
	
	private Connection instanceConnection() {
		try {
			Class.forName(CONTROLLER).newInstance();
			return connection = DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // Carga la clase CONTROLLER
		catch (SQLException e) {
			e.printStackTrace();
		}
		return instanceConnection();
	}

}