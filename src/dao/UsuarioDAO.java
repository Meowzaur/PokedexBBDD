package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Usuario;

public class UsuarioDAO {

	final String DB_URL = "jdbc:mysql://localhost/pokedex";
	final String USER = "pablo";
	final String PASS = "123456";

	/**
	 * Imprime todos los usuarios de la BBDD.
	 */
	public void consulta() {
		final String QUERY = "SELECT nombre, password FROM usuario";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				System.out.print("Nombre: " + rs.getString("nombre"));
				System.out.print(", Password: " + rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Selecciona el usuario de la BBDD.
	 * @param usuario Usuario seleccionado.
	 * @return Devuelve el usuario.
	 */
	public boolean login(Usuario usuario) {
		final String QUERY = "SELECT nombre, password FROM usuario " + "WHERE nombre	= '" + usuario.getNombre()
				+ "' AND password = '" + usuario.getPassword() + "'";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Inserta al usuario seleccionado en la BBDD.
	 * @param usuario Usuario seleccionado.
	 */
	public void registrar(Usuario usuario) {
		final String INSERT = "INSERT INTO usuario (nombre, password) VALUES " + "('" + usuario.getNombre() + "','"
				+ usuario.getPassword() + "');";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
