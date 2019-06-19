import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.geo.dao.ContinenteDAO;
import org.geo.model.continent.Continente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AgregarContForm extends JFrame {

	private JPanel contentPane;

	private JTextField textNombre;
	private JTextField textCodigo;
	private JTextField textId;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textWiki;
	private JLabel label_4;
	private JTextField textRuta;
	private JTextField textBuscar;
	private ContinenteDAO contD;
	private Continente c;

	public AgregarContForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Agregar Continentes");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 60, 454, 29);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("Nombre:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(39, 140, 82, 29);
		getContentPane().add(label_1);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(121, 140, 328, 29);
		getContentPane().add(textNombre);
		textNombre.setText(null);

		JLabel label_2 = new JLabel("Codigo:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(39, 180, 82, 29);
		getContentPane().add(label_2);

		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(121, 180, 328, 29);
		getContentPane().add(textCodigo);
		textCodigo.setText(null);

		JLabel label_3 = new JLabel("Id:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(39, 220, 82, 29);
		getContentPane().add(label_3);

		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(121, 220, 328, 29);
		getContentPane().add(textId);
		textId.setText(null);

		textField_3 = new JTextField();
		textField_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		textField_3.setText("Cancelar");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(301, 429, 86, 20);
		getContentPane().add(textField_3);

		JLabel lblX = new JLabel("x");
		lblX.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setBounds(488, 0, 12, 18);
		contentPane.add(lblX);

		textWiki = new JTextField();
		textWiki.setColumns(10);
		textWiki.setBounds(121, 260, 328, 29);
		contentPane.add(textWiki);
		textWiki.setText(null);

		JLabel lblWikipediaUrl = new JLabel("Wikipedia URL:");
		lblWikipediaUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWikipediaUrl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWikipediaUrl.setBounds(0, 260, 121, 29);
		contentPane.add(lblWikipediaUrl);

		textField_4 = new JTextField();
		textField_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				try {
					contD = new ContinenteDAO();
					c = new Continente();

					if (textCodigo.getText().length() == 0 || textNombre.getText().length() == 0
							|| textId.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
					} else {
						if (contD.buscarContinentePorCodigo(textCodigo.getText()) == null) {
							if (contD.buscarContinentePorId(Long.valueOf(textId.getText())) == null) {
								if (contD.buscarContinentePorNombre(textNombre.getText()).size() == 0) {
									c.setCode(textCodigo.getText());
									c.setShortName(textNombre.getText());
									try {
										c.setId(Long.valueOf(textId.getText()));
									} catch (NumberFormatException e2) {
										JOptionPane.showMessageDialog(null, "El ID debe ser en forma de numero");
									}

									c.setWikipediaURL(textWiki.getText());
									contD.agregarContinente(c);
									if (contD.agregarContinente(c) == true) {
										JOptionPane.showMessageDialog(null, "El Continente fue creado exitosamente");
										textWiki.setText(null);
										textCodigo.setText(null);
										textNombre.setText(null);
										textId.setText(null);
									} else
										JOptionPane.showMessageDialog(null, "El Continente no se pudo crear");
								} else {
									System.out.println(contD.buscarContinentePorNombre(textNombre.getText()));
									JOptionPane.showMessageDialog(null,"Ya existe un continente con ese nombre");
									
								}
							} else {
								JOptionPane.showMessageDialog(null,"Ya existe un continente con ese ID");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Ya existe un continente con ese codigo");
						}

					}
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "En el el espacio de ID solo deben ingresarse numeros");
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});

		textField_4.setText("Aceptar");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(397, 429, 77, 20);
		getContentPane().add(textField_4);

		label_4 = new JLabel("Imagen:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(43, 300, 78, 29);
		contentPane.add(label_4);

		textRuta = new JTextField();
		textRuta.setEditable(false);
		textRuta.setColumns(10);
		textRuta.setBounds(121, 300, 236, 29);
		contentPane.add(textRuta);

		textBuscar = new JTextField();
		textBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Select an image");
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
				jfc.addChoosableFileFilter(filter);

				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					textRuta.setText(jfc.getSelectedFile().getPath());
				}
			}
		});
		textBuscar.setText("Buscar");
		textBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		textBuscar.setEditable(false);
		textBuscar.setColumns(10);
		textBuscar.setBounds(363, 300, 86, 29);
		contentPane.add(textBuscar);
		setUndecorated(true);
	}
}
