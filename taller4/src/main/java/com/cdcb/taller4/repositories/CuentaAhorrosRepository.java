package com.cdcb.taller4.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cdcb.taller4.exceptions.CuentaNoEncontrada;
import com.cdcb.taller4.model.CuentaAhorros;

public class CuentaAhorrosRepository extends CuentaRepository implements IRepository<CuentaAhorros> {

	public CuentaAhorrosRepository(String fileDB) {
		super(fileDB);
	}
	
	@Override
	public void insert(CuentaAhorros entity) {
		Connection connection = null;
		String sql = "INSERT INTO cuentas(numero, saldo, propietario, retiros) VALUES(?,?,?,?)";
		try {
			connection = DriverManager.getConnection(this.fileDB);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setDouble(1, entity.getNumero());
			pstmt.setDouble(2, entity.getSaldo());
			pstmt.setString(3, entity.getPropietario());
			pstmt.setDouble(4, entity.getCantidadRetiros());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			this.disconnect(connection);
		}
	}

	@Override
	public List<CuentaAhorros> selectAll() {
		Connection connection = null;
		List<CuentaAhorros> cuentas = new ArrayList<>();
		String sql = "SELECT * FROM cuentas";
		try {
			connection = DriverManager.getConnection(super.fileDB);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CuentaAhorros cuenta = new CuentaAhorros(
					rs.getInt("numero"),
					rs.getInt("saldo"),
					rs.getNString("propíetario")
				);
				cuenta.setCantidadRetiros(rs.getInt("retiros"));
				cuentas.add(cuenta);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			super.disconnect(connection);
		}
		return cuentas;
	}

	@Override
	public CuentaAhorros selectById(int id) throws CuentaNoEncontrada {
		CuentaAhorros cuenta = null;
		Connection connection = null;
		String sql = "SELECT * FROM cuentas WHERE id = ?";
		try {
			connection = DriverManager.getConnection(super.fileDB);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setDouble(1, id);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				cuenta = new CuentaAhorros(
					rs.getInt("numero"),
					rs.getInt("saldo"),
					rs.getString("propietario")
				);
				cuenta.setCantidadRetiros(rs.getInt("retiros"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			super.disconnect(connection);
		}
		if(cuenta == null) {
			throw new CuentaNoEncontrada("La cuenta no existe");
		}else{
			return cuenta;
		}
	}

	@Override
	public void update(CuentaAhorros entity, int id) throws CuentaNoEncontrada {
		int response = 0;
		Connection connection = null;
		String sql = "UPDATE cuentas SET numero=?, saldo=?, propietario=?, retiros=? WHERE id=?";
		try {
			connection = DriverManager.getConnection(super.fileDB);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setDouble(1, entity.getNumero());
			pstmt.setDouble(2, entity.getSaldo());
			pstmt.setString(3, entity.getPropietario());
			pstmt.setDouble(4, entity.getCantidadRetiros());
			pstmt.setInt(5, id);
			response = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			super.disconnect(connection);
		}
		if(response == 0){
			throw new CuentaNoEncontrada("Cuenta no encontrada");
		}
	}
}
