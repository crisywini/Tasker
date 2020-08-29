package co.uniquindio.semester7.model.database;

public interface DatabaseConfigurationInit {
	
	static final String CONTROLLER = "com.mysql.jdbc.Driver";
	static final String URL_DATABASE = "jdbc:mysql://localhost:3306/tasker?autoReconnect=true&useSSL=false";
	static final String URL_INIT = "jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";
	
	static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS tasker;";
}