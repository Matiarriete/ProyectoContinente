import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.geo.dao.IUsuariosDAO;
import org.geo.dao.UsuariosDAO;
import org.geo.usuarios.Usuario;
import org.geo.usuarios.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private final Action action = new SwingAction();
	private JTextField Ingresar;
	private JTextField Cancelar;
	private JPasswordField passwordField;
	private int a = 0;

	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(205, 100, 655, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		textUsuario = new JTextField();
		textUsuario.setBounds(191, 127, 267, 30);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogIn.setBounds(191, 58, 267, 56);
		contentPane.add(lblLogIn);

		Ingresar = new JTextField();
		Ingresar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e) {
				IUsuariosDAO usuarioDAO = new UsuariosDAO();
				Usuario user = new Usuario();

				try {
					if (usuarioDAO.buscarUsuario(textUsuario.getText()) != null) {
						if (usuarioDAO.buscarContrasena(passwordField.getText()) != null
								&& usuarioDAO.buscarContrasena(passwordField.getText()).getNombre()
										.equals(usuarioDAO.buscarUsuario(textUsuario.getText()).getNombre())) {
							DisenoAppCopia diseno = new DisenoAppCopia();
							diseno.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Usuario o Contrasena mal ingresados");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Usuario o Contrasena mal ingresados");
					}
					
					

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		Ingresar.setEditable(false);
		Ingresar.setHorizontalAlignment(SwingConstants.CENTER);
		Ingresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		Ingresar.setText("Ingresar");
		Ingresar.setBounds(191, 209, 128, 30);
		contentPane.add(Ingresar);
		Ingresar.setColumns(10);

		Cancelar = new JTextField();
		Cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		Cancelar.setText("Cerrar");
		Cancelar.setHorizontalAlignment(SwingConstants.CENTER);
		Cancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		Cancelar.setEditable(false);
		Cancelar.setColumns(10);
		Cancelar.setBounds(329, 209, 128, 30);
		contentPane.add(Cancelar);

		JLabel lblSiEresNuevo = new JLabel("Si eres nuevo");
		lblSiEresNuevo.setBounds(10, 331, 89, 14);
		contentPane.add(lblSiEresNuevo);

		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrar regis = new Registrar();
				regis.setVisible(true);
				dispose();
			}
		});
		lblRegistrarse.setForeground(new Color(255, 222, 173));
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setBounds(89, 331, 73, 14);
		contentPane.add(lblRegistrarse);

		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(636, 11, 9, 14);
		contentPane.add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(191, 168, 267, 30);
		contentPane.add(passwordField);

		JLabel contra = new JLabel("");
		contra.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\24092_opt.png"));
		contra.setBounds(157, 169, 31, 31);
		contentPane.add(contra);

		JLabel usuario = new JLabel("");
		usuario.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\02hombre-icon_opt.png"));
		usuario.setBounds(157, 127, 29, 31);
		contentPane.add(usuario);

		JLabel Fondo = new JLabel("");
		Fondo.setEnabled(false);
		Fondo.setIcon(
				new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\map-of-the-world-2401458_960_720.jpg"));
		Fondo.setBounds(0, 0, 655, 356);
		contentPane.add(Fondo);

		setUndecorated(true);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

}
