package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import dao.PokemonDAO;
import models.Pokemon;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CrearView {

	private JFrame frmCrear;
	private JLabel lblAlmohadilla;
	private JLabel lblTipos;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblCategoria;
	private JLabel lblHabilidad;
	private JTextField tfNumero;
	private JTextField tfNombre;
	private JTextField tfTipo1;
	private JTextField tfTipo2;
	private JTextField tfAltura;
	private JTextField tfPeso;
	private JTextField tfCategoria;
	private JTextField tfHabilidad;
	private JButton btnCrear;
	private JButton btnVolver;
	private PokemonDAO pokemonDAO;

	/**
	 * Create the application.
	 */
	public CrearView() {
		initialize();
		this.pokemonDAO = new PokemonDAO();
		this.frmCrear.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrear = new JFrame();
		configureUIComponents();
		configureListeners();

	}

	private void configureUIComponents() {
		frmCrear.setTitle("Crear");
		frmCrear.setBounds(100, 100, 450, 300);
		frmCrear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrear.getContentPane().setLayout(null);

		lblAlmohadilla = new JLabel("#");
		lblAlmohadilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlmohadilla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlmohadilla.setBounds(81, 20, 22, 32);
		frmCrear.getContentPane().add(lblAlmohadilla);

		lblTipos = new JLabel("Tipos");
		lblTipos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipos.setBounds(10, 63, 46, 51);
		frmCrear.getContentPane().add(lblTipos);

		lblAltura = new JLabel("Altura");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAltura.setBounds(211, 60, 54, 23);
		frmCrear.getContentPane().add(lblAltura);

		lblPeso = new JLabel("Peso");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPeso.setBounds(211, 94, 54, 23);
		frmCrear.getContentPane().add(lblPeso);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoria.setBounds(71, 125, 89, 23);
		frmCrear.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHabilidad.setBounds(265, 125, 102, 23);
		frmCrear.getContentPane().add(lblHabilidad);

		tfNumero = new JTextField();
		tfNumero.setBounds(107, 24, 40, 23);
		frmCrear.getContentPane().add(tfNumero);
		tfNumero.setColumns(10);

		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(157, 24, 174, 23);
		frmCrear.getContentPane().add(tfNombre);

		tfTipo1 = new JTextField();
		tfTipo1.setBounds(61, 63, 86, 20);
		frmCrear.getContentPane().add(tfTipo1);
		tfTipo1.setColumns(10);

		tfTipo2 = new JTextField();
		tfTipo2.setBounds(61, 94, 86, 20);
		frmCrear.getContentPane().add(tfTipo2);
		tfTipo2.setColumns(10);

		tfAltura = new JTextField();
		tfAltura.setColumns(10);
		tfAltura.setBounds(281, 63, 86, 20);
		frmCrear.getContentPane().add(tfAltura);

		tfPeso = new JTextField();
		tfPeso.setColumns(10);
		tfPeso.setBounds(281, 94, 86, 20);
		frmCrear.getContentPane().add(tfPeso);

		tfCategoria = new JTextField();
		tfCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		tfCategoria.setColumns(10);
		tfCategoria.setBounds(30, 148, 174, 23);
		frmCrear.getContentPane().add(tfCategoria);

		tfHabilidad = new JTextField();
		tfHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		tfHabilidad.setColumns(10);
		tfHabilidad.setBounds(232, 148, 174, 23);
		frmCrear.getContentPane().add(tfHabilidad);

		btnCrear = new JButton("Crear");
		btnCrear.setBounds(115, 196, 89, 23);
		frmCrear.getContentPane().add(btnCrear);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(232, 196, 89, 23);
		frmCrear.getContentPane().add(btnVolver);
	}

	private void configureListeners() {
		/**
		 * Botón Crear: Comprueba si alguna de las celdas está vacía, exceptuando Tipo2.
		 * En caso de que alguna esté vacía excepto Tipo2, devuelve un mensaje de error.
		 * Introduce estos datos en la base de datos, cierra CrearView y abre
		 * PokedexView.
		 */
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfNumero.getText().isEmpty() || tfNombre.getText().isEmpty() || tfTipo1.getText().isEmpty()
						|| tfAltura.getText().isEmpty() || tfPeso.getText().isEmpty() || tfCategoria.getText().isEmpty()
						|| tfHabilidad.getText().isEmpty()) {

					JOptionPane.showMessageDialog(btnCrear, "Rellena todos los campos.");

				} else {

					int numero = Integer.parseInt(tfNumero.getText());
					String nombre = tfNombre.getText();
					String tipo1 = tfTipo1.getText();
					String tipo2 = "";
					if (!tfTipo2.getText().isEmpty()) {
						tipo2 = tfTipo2.getText();
					}
					double altura = Double.parseDouble(tfAltura.getText());
					double peso = Double.parseDouble(tfPeso.getText());
					String categoria = tfCategoria.getText();
					String habilidad = tfHabilidad.getText();

					pokemonDAO.insertar(new Pokemon(numero, nombre, tipo1, tipo2, altura, peso, categoria, habilidad));

					frmCrear.dispose();
					new PokedexView();
				}
			}
		});

		/**
		 * Botón Volver: Cierra CrearView y abre PokedexView.
		 */
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrear.dispose();
				new PokedexView();
			}
		});

	}
}
