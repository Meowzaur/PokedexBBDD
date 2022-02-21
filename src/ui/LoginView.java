package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UsuarioDAO;
import models.Usuario;

public class LoginView {

	private JFrame frmLogin;
	private JLabel lblTituloLogin;
	private JLabel lblNombreLogin;
	private JTextField tfNombreLogin;
	private JLabel lblPasswordLogin;
	private JPasswordField pfPasswordLogin;
	private JButton btnEntrarLogin;
	private JButton btnIrARegistrar;
	private UsuarioDAO usuarioDAO;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		this.usuarioDAO = new UsuarioDAO();
		this.frmLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		configureUIComponents();
		configureListeners();
	}

	private void configureUIComponents() {
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		lblTituloLogin = new JLabel("POK\u00C9DEX");
		lblTituloLogin.setFont(new Font("Lucida Console", Font.BOLD | Font.ITALIC, 29));
		lblTituloLogin.setBounds(148, 25, 131, 53);
		frmLogin.getContentPane().add(lblTituloLogin);

		lblNombreLogin = new JLabel("Usuario");
		lblNombreLogin.setBounds(71, 101, 59, 14);
		frmLogin.getContentPane().add(lblNombreLogin);

		tfNombreLogin = new JTextField();
		tfNombreLogin.setBounds(135, 98, 185, 20);
		frmLogin.getContentPane().add(tfNombreLogin);
		tfNombreLogin.setColumns(10);

		lblPasswordLogin = new JLabel("Password");
		lblPasswordLogin.setBounds(71, 152, 59, 14);
		frmLogin.getContentPane().add(lblPasswordLogin);

		pfPasswordLogin = new JPasswordField();
		pfPasswordLogin.setBounds(136, 149, 184, 20);
		frmLogin.getContentPane().add(pfPasswordLogin);

		btnEntrarLogin = new JButton("Entrar");
		btnEntrarLogin.setBounds(169, 200, 89, 23);
		frmLogin.getContentPane().add(btnEntrarLogin);

		btnIrARegistrar = new JButton("Reg\u00EDstrate");
		btnIrARegistrar.setBounds(298, 214, 113, 23);
		frmLogin.getContentPane().add(btnIrARegistrar);
	}

	public void configureListeners() {

		btnEntrarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarLogin();
			}
		});

		pfPasswordLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					comprobarLogin();
				}
			}
		});

		btnIrARegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
				new RegistroView();
			}
		});
	}

	private void comprobarLogin() {
		String nombre = tfNombreLogin.getText();
		String password = new String(pfPasswordLogin.getPassword());
		Usuario usuario = new Usuario(0, nombre, password);
		boolean entrar = usuarioDAO.login(usuario);
		if (entrar) {
			frmLogin.dispose();
			new PokedexView();
		} else {
			JOptionPane.showMessageDialog(btnEntrarLogin, "Login incorrecto");
		}
	}
}
