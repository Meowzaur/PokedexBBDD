package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;

public class PokemonDAO {

	final String DB_URL = "jdbc:mysql://localhost/pokedex";
	final String USER = "pablo";
	final String PASS = "123456";

	/**
	 * Selecciona el primer registro de la BBDD.
	 * @return Devuelve el primer Pokemon de la BBDD.
	 */
	public Pokemon primero() {
		final String QUERY = "SELECT numero, nombre, tipo1, tipo2, "
				+ "altura, peso, categoria, habilidad FROM pokemon LIMIT 1";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				int numero = rs.getInt("numero");
				String nombre = rs.getString("nombre");
				String tipo1 = rs.getString("tipo1");
				String tipo2 = rs.getString("tipo2");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				String categoria = rs.getString("categoria");
				String habilidad = rs.getString("habilidad");
				Pokemon p = new Pokemon(numero, nombre, tipo1, tipo2, altura, peso, categoria, habilidad);
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Hace un ArrayList con los datos de la BBDD.
	 * @return Devuelve un ArrayList con los datos de la BBDD.
	 */
	public ArrayList<Pokemon> getAll() {
		final String QUERY = "SELECT numero, nombre, tipo1, tipo2, "
				+ "altura, peso, categoria, habilidad FROM pokemon";
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				int numero = rs.getInt("numero");
				String nombre = rs.getString("nombre");
				String tipo1 = rs.getString("tipo1");
				String tipo2 = rs.getString("tipo2");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				String categoria = rs.getString("categoria");
				String habilidad = rs.getString("habilidad");
				Pokemon p = new Pokemon(numero, nombre, tipo1, tipo2, altura, peso, categoria, habilidad);
				pokemons.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemons;
	}

	/**
	 * Inserta el Pokemon seleccionado.
	 * @param p Pokemon seleccionado.
	 */
	public void insertar(Pokemon p) {
		final String INSERT = "INSERT INTO pokemon(numero,nombre,tipo1,tipo2,altura,peso,categoria,habilidad) "
				+ "VALUES('" + p.getNumero() + "','" + p.getNombre() + "','" + p.getTipo1() + "','" + p.getTipo2()
				+ "','" + p.getAltura() + "','" + p.getPeso() + "','" + p.getCategoria() + "','" + p.getHabilidad()
				+ "')";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Borra el Pokemon seleccionado.
	 * @param p Pokémon seleccionado.
	 */
	public void borrar(Pokemon p) {
		final String DELETE = "DELETE FROM pokemon WHERE numero='" + p.getNumero() + "'";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(DELETE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza el Pokemon seleccionado.
	 * @param p Pokemon seleccionado.
	 */
	public void actualizar(Pokemon p) {
		final String UPDATE = "UPDATE pokemon SET nombre = '" + p.getNombre() + "', tipo1 = '" + p.getTipo1()
				+ "', tipo2 = '" + p.getTipo2() + "', altura = '" + p.getAltura() + "', peso = '" + p.getPeso()
				+ "', categoria = '" + p.getCategoria() + "', habilidad = '" + p.getHabilidad() + "' WHERE numero = "
				+ p.getNumero() + ";";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
