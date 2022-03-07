package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import dao.PokemonDAO;
import models.Pokemon;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PokedexView {

	private JFrame frmPokedex;
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
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnActualizar;
	private JButton btnCrear;
	private JButton btnBorrar;
	private JButton btnActualizarConfirmar;
	private JButton btnActualizarCancelar;
	private PokemonDAO pokemonDAO;
	private ArrayList<Pokemon> pokemons;
	private int contador = 0;

	/**
	 * Create the application.
	 */
	public PokedexView() {
		initialize();
		this.pokemonDAO = new PokemonDAO();
		this.pokemons = pokemonDAO.getAll();
		initialize();
		if (pokemons.size() > 0) {
			actualizarVista();
		}
		this.frmPokedex.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokedex = new JFrame();
		configureUIComponents();
		configureListeners();

	}

	private void configureUIComponents() {
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setBounds(100, 100, 450, 300);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedex.getContentPane().setLayout(null);

		lblAlmohadilla = new JLabel("#");
		lblAlmohadilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlmohadilla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlmohadilla.setBounds(81, 20, 22, 32);
		frmPokedex.getContentPane().add(lblAlmohadilla);

		lblTipos = new JLabel("Tipos");
		lblTipos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipos.setBounds(10, 63, 46, 51);
		frmPokedex.getContentPane().add(lblTipos);

		lblAltura = new JLabel("Altura");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAltura.setBounds(211, 60, 54, 23);
		frmPokedex.getContentPane().add(lblAltura);

		lblPeso = new JLabel("Peso");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPeso.setBounds(211, 94, 54, 23);
		frmPokedex.getContentPane().add(lblPeso);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoria.setBounds(71, 125, 89, 23);
		frmPokedex.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHabilidad.setBounds(265, 125, 102, 23);
		frmPokedex.getContentPane().add(lblHabilidad);

		tfNumero = new JTextField();
		tfNumero.setEditable(false);
		tfNumero.setBounds(107, 24, 40, 23);
		frmPokedex.getContentPane().add(tfNumero);
		tfNumero.setColumns(10);

		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setColumns(10);
		tfNombre.setBounds(157, 24, 174, 23);
		frmPokedex.getContentPane().add(tfNombre);

		tfTipo1 = new JTextField();
		tfTipo1.setEditable(false);
		tfTipo1.setBounds(61, 63, 86, 20);
		frmPokedex.getContentPane().add(tfTipo1);
		tfTipo1.setColumns(10);

		tfTipo2 = new JTextField();
		tfTipo2.setEditable(false);
		tfTipo2.setBounds(61, 94, 86, 20);
		frmPokedex.getContentPane().add(tfTipo2);
		tfTipo2.setColumns(10);

		tfAltura = new JTextField();
		tfAltura.setEditable(false);
		tfAltura.setColumns(10);
		tfAltura.setBounds(281, 63, 86, 20);
		frmPokedex.getContentPane().add(tfAltura);

		tfPeso = new JTextField();
		tfPeso.setEditable(false);
		tfPeso.setColumns(10);
		tfPeso.setBounds(281, 94, 86, 20);
		frmPokedex.getContentPane().add(tfPeso);

		tfCategoria = new JTextField();
		tfCategoria.setEditable(false);
		tfCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		tfCategoria.setColumns(10);
		tfCategoria.setBounds(30, 148, 174, 23);
		frmPokedex.getContentPane().add(tfCategoria);

		tfHabilidad = new JTextField();
		tfHabilidad.setEditable(false);
		tfHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		tfHabilidad.setColumns(10);
		tfHabilidad.setBounds(232, 148, 174, 23);
		frmPokedex.getContentPane().add(tfHabilidad);

		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(115, 193, 89, 23);
		frmPokedex.getContentPane().add(btnAnterior);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(221, 193, 89, 23);
		frmPokedex.getContentPane().add(btnSiguiente);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(169, 227, 96, 23);
		frmPokedex.getContentPane().add(btnActualizar);

		btnCrear = new JButton("Crear");
		btnCrear.setBounds(58, 227, 89, 23);
		frmPokedex.getContentPane().add(btnCrear);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(281, 227, 89, 23);
		frmPokedex.getContentPane().add(btnBorrar);

		btnActualizarConfirmar = new JButton("Actualizar");
		btnActualizarConfirmar.setBounds(108, 210, 96, 23);
		frmPokedex.getContentPane().add(btnActualizarConfirmar);
		btnActualizarConfirmar.setVisible(false);

		btnActualizarCancelar = new JButton("Cancelar");
		btnActualizarCancelar.setBounds(231, 210, 96, 23);
		frmPokedex.getContentPane().add(btnActualizarCancelar);
		btnActualizarCancelar.setVisible(false);
	}

	private void configureListeners() {
		/**
		 * Botón Anterior: Resta un número al contador, pero si el número es menor que
		 * 0, cambia al último número de la lista de la BBDD. Luego, actualiza la vista.
		 */
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador--;
				if (contador < 0) {
					contador = pokemons.size() - 1;
				}
				actualizarVista();
			}
		});

		/**
		 * Botón Siguiente: Suma un número al contador, pero si el número es mayor que
		 * la última posición de la lista de la BBDD, cambia a 0. Luego, actualiza la
		 * vista.
		 */
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador++;
				if (contador >= pokemons.size()) {
					contador = 0;
				}
				actualizarVista();
			}
		});

		/**
		 * Botón Actualizar: ejecuta "invertirElementos".
		 */
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invertirElementos();
			}
		});

		/**
		 * Botón Crear: Cierra PokedexView y abre CrearView.
		 */
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new CrearView();
			}
		});

		/**
		 * Botón Borrar: Respecto a la vista, borrará ese elemento incluso de su BBDD.
		 * Reseteará el contador. Si quedan elementos en la BBDD, ejecuta
		 * "actualizarVista"; si no, ejecuta "listaVacia".
		 */
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon p = pokemons.get(contador);
				pokemonDAO.borrar(p);
				pokemons.remove(contador);
				contador = 0;
				if (pokemons.size() > 0) {
					actualizarVista();
				} else {
					listaVacia();
				}
			}
		});

		/**
		 * Botón Confirmar: ejecuta "actualizarPokemon" e "invertirElementos".
		 */
		btnActualizarConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarPokemon();
				invertirElementos();
			}
		});

		/**
		 * Botón Cancelar: ejecuta "invertirElementos".
		 */
		btnActualizarCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invertirElementos();
			}
		});

	}

	/**
	 * Respecto al número del contador, imprime la posición del elemento de la BBDD.
	 */
	public void actualizarVista() {
		Pokemon p = pokemons.get(contador);
		tfNumero.setText(String.valueOf(p.getNumero()));
		tfNombre.setText(p.getNombre());
		tfTipo1.setText(p.getTipo1());
		tfTipo2.setText(p.getTipo2());
		tfAltura.setText(String.valueOf(p.getAltura()));
		tfPeso.setText(String.valueOf(p.getPeso()));
		tfCategoria.setText(p.getCategoria());
		tfHabilidad.setText(p.getHabilidad());
	}

	/**
	 * Imprime los campos pero vacíos.
	 */
	public void listaVacia() {
		tfNumero.setText("");
		tfNombre.setText("");
		tfTipo1.setText("");
		tfTipo2.setText("");
		tfAltura.setText("");
		tfPeso.setText("");
		tfCategoria.setText("");
		tfHabilidad.setText("");

	}

	/**
	 * Hace editable los campos si no son editables y viceversa. También oculta los
	 * botones visibles y viceversa.
	 */
	public void invertirElementos() {
		tfNombre.setEditable(!tfNombre.isEditable());
		tfTipo1.setEditable(!tfTipo1.isEditable());
		tfTipo2.setEditable(!tfTipo2.isEditable());
		tfAltura.setEditable(!tfAltura.isEditable());
		tfPeso.setEditable(!tfPeso.isEditable());
		tfCategoria.setEditable(!tfCategoria.isEditable());
		tfHabilidad.setEditable(!tfHabilidad.isEditable());
		btnAnterior.setVisible(!btnAnterior.isVisible());
		btnSiguiente.setVisible(!btnSiguiente.isVisible());
		btnActualizar.setVisible(!btnActualizar.isVisible());
		btnCrear.setVisible(!btnCrear.isVisible());
		btnBorrar.setVisible(!btnBorrar.isVisible());
		btnActualizarConfirmar.setVisible(!btnActualizarConfirmar.isVisible());
		btnActualizarCancelar.setVisible(!btnActualizarCancelar.isVisible());
		actualizarVista();
	}

	/**
	 * Actualiza los datos cambiados en la BBDD.
	 */
	public void actualizarPokemon() {
		Pokemon p = pokemons.get(contador);
		p.setNombre(tfNombre.getText());
		p.setTipo1(tfTipo1.getText());
		p.setTipo2(tfTipo2.getText());
		p.setAltura(Double.parseDouble(tfAltura.getText()));
		p.setPeso(Double.parseDouble(tfPeso.getText()));
		p.setCategoria(tfCategoria.getText());
		p.setHabilidad(tfHabilidad.getText());

		pokemonDAO.actualizar(p);
	}
}
