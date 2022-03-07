package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.UsuarioDAO;
import models.Usuario;

import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class RegistroView {

	private JFrame frmRegistro;
	private JLabel lblNombreRegistro;
	private JTextField tfNombreRegistro;
	private JLabel lblPasswordRegistro;
	private JPasswordField pfPasswordRegistro;
	private JLabel lblRepetirPasswordRegistro;
	private JPasswordField pfRepetirPasswordRegistro;
	private JButton btnCrearRegistro;
	private JButton btnVolverALogin;
	private UsuarioDAO usuarioDAO;

	/**
	 * Create the application.
	 */
	public RegistroView() {
		initialize();
		this.usuarioDAO = new UsuarioDAO();
		this.frmRegistro.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistro = new JFrame();
		configureUIComponents();
		configureListeners();
	}

	private void configureUIComponents() {
		frmRegistro.setTitle("Registro");
		frmRegistro.setBounds(100, 100, 450, 300);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.setVisible(true);
		frmRegistro.getContentPane().setLayout(null);

		lblNombreRegistro = new JLabel("Nuevo usuario");
		lblNombreRegistro.setBounds(45, 51, 119, 14);
		frmRegistro.getContentPane().add(lblNombreRegistro);

		tfNombreRegistro = new JTextField();
		tfNombreRegistro.setBounds(174, 48, 169, 20);
		frmRegistro.getContentPane().add(tfNombreRegistro);
		tfNombreRegistro.setColumns(10);

		lblPasswordRegistro = new JLabel("Nuevo password");
		lblPasswordRegistro.setBounds(45, 103, 119, 14);
		frmRegistro.getContentPane().add(lblPasswordRegistro);

		pfPasswordRegistro = new JPasswordField();
		pfPasswordRegistro.setBounds(174, 100, 169, 20);
		frmRegistro.getContentPane().add(pfPasswordRegistro);

		lblRepetirPasswordRegistro = new JLabel("Repetir password");
		lblRepetirPasswordRegistro.setBounds(45, 134, 119, 14);
		frmRegistro.getContentPane().add(lblRepetirPasswordRegistro);

		pfRepetirPasswordRegistro = new JPasswordField();
		pfRepetirPasswordRegistro.setBounds(174, 131, 169, 20);
		frmRegistro.getContentPane().add(pfRepetirPasswordRegistro);

		btnCrearRegistro = new JButton("Crear usuario");
		btnCrearRegistro.setBounds(145, 187, 128, 23);
		frmRegistro.getContentPane().add(btnCrearRegistro);

		btnVolverALogin = new JButton("Volver");
		btnVolverALogin.setBounds(323, 215, 89, 23);
		frmRegistro.getContentPane().add(btnVolverALogin);
	}

	private void configureListeners() {

		/**
		 * Botón Crear: ejecuta "crearRegistro".
		 */
		btnCrearRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearRegistro();
			}
		});

		/**
		 * Pulsar Intro en la ranura de Password: ejecuta "crearRegistro".
		 */
		pfRepetirPasswordRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					crearRegistro();
				}
			}
		});

		/**
		 * Botón Volver: cierra RegistroView y abre LoginView.
		 */
		btnVolverALogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistro.dispose();
				new LoginView();
			}
		});

	}

	/**
	 * Coge los datos introducidos. Si alguno está vacío o Password es distinto a
	 * RepetirPassword, salta error. En caso contrario, introduce los datos en la
	 * BBDD.
	 */
	private void crearRegistro() {
		String nombre = tfNombreRegistro.getText();
		String password = new String(pfPasswordRegistro.getPassword());
		String repetirPassword = new String(pfRepetirPasswordRegistro.getPassword());
		if (password.equals(repetirPassword) && !nombre.isEmpty() && !password.isEmpty()) {
			Usuario u = new Usuario(0, nombre, password);
			usuarioDAO.registrar(u);
			JOptionPane.showMessageDialog(btnCrearRegistro, "Usuario añadido correctamente.");
		} else {
			JOptionPane.showMessageDialog(btnCrearRegistro, "Error de creación.");
		}
	}
}
