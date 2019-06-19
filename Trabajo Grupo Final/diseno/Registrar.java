import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.geo.dao.UsuariosDAO;
import org.geo.usuarios.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Registrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtVolver;
	private JTextField txtAceptar;
	private JTextField usuario;
	private JPasswordField contrasena;
	private JLabel lblRepetirContrasea;
	private JTextField mail;
	private JPasswordField repetirContra;
	private JLabel lblMail;
	private JLabel lblRegistro;
	private ButtonGroup botones = new ButtonGroup();
	private JLabel lblNewLabel;

	public Registrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(205, 100, 655, 356);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setBounds(636, 11, 9, 14);
		contentPane.add(lblX);

		txtVolver = new JTextField();
		txtVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogIn logIn = new LogIn();
				logIn.setVisible(true);
				dispose();
			}
		});
		txtVolver.setHorizontalAlignment(SwingConstants.CENTER);
		txtVolver.setText("Volver");
		txtVolver.setEditable(false);
		txtVolver.setBounds(576, 325, 69, 20);
		contentPane.add(txtVolver);
		txtVolver.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(160, 107, 48, 14);
		contentPane.add(lblUsuario);

		usuario = new JTextField();
		usuario.setBounds(211, 105, 236, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		usuario.setText(null);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(139, 135, 77, 14);
		contentPane.add(lblContrasea);

		contrasena = new JPasswordField();
		contrasena.setBounds(211, 133, 236, 20);
		contentPane.add(contrasena);

		lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepetirContrasea.setBounds(96, 166, 120, 14);
		contentPane.add(lblRepetirContrasea);

		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(211, 193, 236, 20);
		contentPane.add(mail);

		repetirContra = new JPasswordField();
		repetirContra.setBounds(211, 164, 236, 20);
		contentPane.add(repetirContra);

		lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMail.setBounds(181, 195, 33, 14);
		contentPane.add(lblMail);

		lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(211, 37, 236, 67);
		contentPane.add(lblRegistro);

		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBackground(new Color(169, 169, 169));
		rdbtnMasculino.setBounds(212, 221, 77, 23);
		contentPane.add(rdbtnMasculino);

		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBackground(new Color(169, 169, 169));
		rdbtnFemenino.setBounds(294, 221, 77, 23);
		contentPane.add(rdbtnFemenino);

		botones.add(rdbtnFemenino);
		botones.add(rdbtnMasculino);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSexo.setBounds(177, 224, 33, 14);
		contentPane.add(lblSexo);

		JComboBox comboEdad = new JComboBox();
		comboEdad.setModel(
				new DefaultComboBoxModel(new String[] { "1-10", "11-20", "21-30", "31-40", "41-50", "50 \u00F3 mas" }));
		comboEdad.setBounds(213, 256, 236, 24);
		contentPane.add(comboEdad);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdad.setBounds(178, 259, 33, 14);
		contentPane.add(lblEdad);
		setUndecorated(true);

		txtAceptar = new JTextField();
		txtAceptar.addMouseListener(new MouseAdapter() {

			@SuppressWarnings("unlikely-arg-type")
			public void mouseClicked(MouseEvent e) {
				UsuariosDAO userDAO = new UsuariosDAO();
				Usuario user = new Usuario();

				try {
					user.setNombre(usuario.getText());
					if (user.getNombre() != null) {
						user.setContrasena(contrasena.getText());
						if (user.getContrasena().equals(repetirContra.getText())) {
							user.setMail(mail.getText());
							if (rdbtnFemenino.isSelected()) {
								user.setSexo("Femenino");
							} else {
								if (rdbtnMasculino.isSelected()) {
									user.setSexo("Masculino");
								}
							}
							if (comboEdad.getSelectedItem() != null) {
								user.setEdad(comboEdad.getSelectedItem().toString());
								userDAO.agregarUsuario(user);
								usuario.setText(null);
								contrasena.setText(null);
								mail.setText(null);
								repetirContra.setText(null);
								comboEdad.setSelectedItem(null);
								botones.clearSelection();
							} else {
								JOptionPane.showMessageDialog(null, "Seleccione edad");
							}

						} else {
							JOptionPane.showMessageDialog(null, "Las contrasenas deben ser iguales");
						}
					} else {
						JOptionPane.showMessageDialog(null, "El usuario no puede ser nulo");
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		txtAceptar.setText("Aceptar");
		txtAceptar.setEditable(false);
		txtAceptar.setBounds(489, 325, 77, 20);
		contentPane.add(txtAceptar);
		txtAceptar.setColumns(10);

		lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setIcon(
				new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\map-of-the-world-2401458_960_720.jpg"));
		lblNewLabel.setBounds(0, 0, 655, 356);
		contentPane.add(lblNewLabel);

	}
}
