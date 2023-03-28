package com.cdcb.taller4.repositories.Cuenta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cdcb.taller4.domain.CuentaCorriente;
import com.cdcb.taller4.exceptions.CuentaNoEncontrada;
import com.cdcb.taller4.repositories.IRepository;

public class CuentaCorrienteRepository extends CuentaRepository implements IRepository<CuentaCorriente> {
	
	public CuentaCorrienteRepository(String fileDB) {
		super(fileDB);
	}

	@Override
	public void insert(CuentaCorriente entity) {
		Connection connection = null;
		String sql = "INSERT INTO cuentas(numero, saldo, propietario, retiros, depositos, tipo) VALUES(?,?,?,?,?,?)";
		try {
			connection = DriverManager.getConnection(this.fileDB);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setDouble(1, entity.getNumero());
			pstmt.setDouble(2, entity.getSaldo());
			pstmt.setString(3, entity.getPropietario());
			pstmt.setDouble(4, entity.getCantidadRetiros());
			pstmt.setDouble(5, entity.getCantidadDepositos());
			pstmt.setString(6, "Corriente");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			this.disconnect(connection);
		}
	}

	@Override
	public List<CuentaCorriente> selectAll() {
		Connection connection = null;
		List<CuentaCorriente> cuentas = new ArrayList<>();
		String sql = "SELECT * FROM cuentas WHERE tipo = 'Corriente'";
		try {
			connection = DriverManager.getConnection(super.fileDB);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CuentaCorriente cuenta = new CuentaCorriente(
					rs.getInt("numero"),
					rs.getInt("saldo"),
					rs.getNString("propíetario")
				);
				cuenta.setCantidadRetiros(rs.getInt("retiros"));
				cuenta.setCantidadRetiros(rs.getInt("depositos"));
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
	public CuentaCorriente selectById(int id) {
		CuentaCorriente cuenta = null;
		Connection connection = null;
		String sql = "SELECT * FROM cuentas WHERE numero = ? AND tipo = 'Corriente'";
		try {
			connection = DriverManager.getConnection(super.fileDB);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setDouble(1, id);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				cuenta = new CuentaCorriente(
					rs.getInt("numero"),
					rs.getInt("saldo"),
					rs.getString("propietario")
				);
				cuenta.setCantidadRetiros(rs.getInt("retiros"));
				cuenta.setCantidadDepositos(rs.getInt("depositos"));
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
	public void update(CuentaCorriente entity, int id) {
		int response = 0;
		Connection connection = null;
		String sql = "UPDATE cuentas SET numero=?, saldo=?, propietario=?, retiros=? WHERE numero=?";
		try {
			connection = DriverManager.getConnection(super.fileDB);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setDouble(1, entity.getNumero());
			pstmt.setDouble(2, entity.getSaldo());
			pstmt.setString(3, entity.getPropietario());
			pstmt.setDouble(4, entity.getCantidadRetiros());
			pstmt.setDouble(5, entity.getCantidadDepositos());
			pstmt.setInt(6, id);
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
