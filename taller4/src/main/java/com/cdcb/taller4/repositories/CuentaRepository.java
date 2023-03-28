package com.cdcb.taller4.repositories;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.cdcb.taller4.exceptions.CuentaNoEncontrada;
import com.cdcb.taller4.model.Cuenta;

public class CuentaRepository{
	protected String fileDB;
	
	public CuentaRepository(String fileDB) {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
			this.fileDB = "jdbc:sqlite:"+fileDB;
			this.connect();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} 
	}

	public void connect() {
		Connection connection = null;
        try{
			connection = DriverManager.getConnection(this.fileDB);
			if (connection != null) {
				DatabaseMetaData meta = connection.getMetaData();
				System.out.println("Database connected: " + meta.getDatabaseProductName());
				System.out.println("The driver name is " + meta.getDriverName());
			}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
			this.disconnect(connection);
		}
	}

	protected void disconnect(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	public void executeQuery(String query) {
		Connection connection = null;
        try {
			connection = DriverManager.getConnection(this.fileDB);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
			this.disconnect(connection);
		}
	}


	public void delete(int id) {
		int response = 0;
		Connection connection = null;
		String sql = "DELETE FROM cuentas WHERE id = ?";
		try {
			connection = DriverManager.getConnection(this.fileDB);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			response = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			this.disconnect(connection);
		}
		if(response == 0){
			throw new CuentaNoEncontrada("Cuenta no encontrada");
		}
	}

	public void createTable(){
		this.executeQuery("DROP TABLE IF EXISTS cuentas");
		this.executeQuery(Cuenta.DDL);
	}
}
