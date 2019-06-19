import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.geo.dao.ContinenteDAO;
import org.geo.dao.IContinenteDAO;
import org.geo.dao.IPaisDAO;
import org.geo.dao.PaisDAO;
import org.geo.model.continent.Continente;
import org.geo.model.country.FIPS;
import org.geo.model.country.ISO31661;
import org.geo.model.country.Pais;
import org.geo.model.country.iso3166alpha2state.ISO3166Alpha2State;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AgregarPaisForm extends JFrame {

	private JPanel contentPane;
	private JTextField textAceptar;
	private JTextField textCancelar;
	private JTextField textID;
	private JTextField textVecinos;
	private JTextField textCont;
	private JTextField textFips;
	private JTextField textArea;
	private JTextField textPobl;
	private JTextField textCap;
	private JTextField textNom;
	private JTextField textIsoNum;
	private JTextField textIso3;
	private JTextField textIso2;
	private JLabel lblX;
	private JTextField txtBuscar;
	private JTextField textRuta;
	private IPaisDAO daoPais;
	private IContinenteDAO contD;
	private Continente c;
	private ISO3166Alpha2State estado;
	private ISO31661 iso;
	private Pais p;

	public AgregarPaisForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textAceptar = new JTextField();
		textAceptar.setText("Aceptar");
		textAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		textAceptar.setEditable(false);
		textAceptar.setColumns(10);
		textAceptar.setBounds(804, 469, 86, 20);
		contentPane.add(textAceptar);

		textCancelar = new JTextField();
		textCancelar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		textCancelar.setText("Cancelar");
		textCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		textCancelar.setEditable(false);
		textCancelar.setColumns(10);
		textCancelar.setBounds(708, 469, 86, 20);
		contentPane.add(textCancelar);

		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(118, 405, 341, 20);
		contentPane.add(textID);

		textVecinos = new JTextField();
		textVecinos.setColumns(10);
		textVecinos.setBounds(118, 374, 341, 20);
		contentPane.add(textVecinos);

		textCont = new JTextField();
		textCont.setColumns(10);
		textCont.setBounds(118, 343, 341, 20);
		contentPane.add(textCont);

		textFips = new JTextField();
		textFips.setColumns(10);
		textFips.setBounds(118, 312, 341, 20);
		contentPane.add(textFips);

		textArea = new JTextField();
		textArea.setColumns(10);
		textArea.setBounds(118, 281, 341, 20);
		contentPane.add(textArea);
		textArea.setText(" ");

		textPobl = new JTextField();
		textPobl.setColumns(10);
		textPobl.setBounds(118, 250, 341, 20);
		contentPane.add(textPobl);

		textCap = new JTextField();
		textCap.setColumns(10);
		textCap.setBounds(118, 219, 341, 20);
		contentPane.add(textCap);

		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(118, 188, 341, 20);
		contentPane.add(textNom);

		textIsoNum = new JTextField();
		textIsoNum.setColumns(10);
		textIsoNum.setBounds(118, 157, 341, 20);
		contentPane.add(textIsoNum);

		textIso3 = new JTextField();
		textIso3.setColumns(10);
		textIso3.setBounds(118, 126, 341, 20);
		contentPane.add(textIso3);

		textIso2 = new JTextField();
		textIso2.setColumns(10);
		textIso2.setBounds(118, 98, 341, 20);
		contentPane.add(textIso2);

		JLabel labelIso2 = new JLabel("ISO 2(*):");
		labelIso2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIso2.setBounds(62, 101, 46, 14);
		contentPane.add(labelIso2);

		JLabel label_1 = new JLabel("Agregar Pais");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(0, 31, 900, 24);
		contentPane.add(label_1);

		JLabel labelIso3 = new JLabel("ISO 3(*):");
		labelIso3.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIso3.setBounds(62, 129, 46, 14);
		contentPane.add(labelIso3);

		JLabel labelIsoNum = new JLabel("ISO Numerico:");
		labelIsoNum.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIsoNum.setBounds(26, 160, 82, 14);
		contentPane.add(labelIsoNum);

		JLabel labelNom = new JLabel("Nombre(*):");
		labelNom.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNom.setBounds(46, 191, 62, 14);
		contentPane.add(labelNom);

		JLabel labelCap = new JLabel("Capital(*):");
		labelCap.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCap.setBounds(36, 222, 72, 14);
		contentPane.add(labelCap);

		JLabel labelPobl = new JLabel("Poblacion:");
		labelPobl.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPobl.setBounds(26, 253, 82, 14);
		contentPane.add(labelPobl);

		JLabel labelArea = new JLabel("Area:");
		labelArea.setHorizontalAlignment(SwingConstants.RIGHT);
		labelArea.setBounds(62, 284, 46, 14);
		contentPane.add(labelArea);

		JLabel labelFips = new JLabel("Fips(*):");
		labelFips.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFips.setBounds(62, 315, 46, 14);
		contentPane.add(labelFips);

		JLabel labelCont = new JLabel("Continente(*):");
		labelCont.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCont.setBounds(26, 346, 82, 14);
		contentPane.add(labelCont);

		JLabel labelVecinos = new JLabel("Vecinos:");
		labelVecinos.setHorizontalAlignment(SwingConstants.RIGHT);
		labelVecinos.setBounds(46, 377, 62, 14);
		contentPane.add(labelVecinos);

		JLabel labelId = new JLabel("ID:");
		labelId.setHorizontalAlignment(SwingConstants.RIGHT);
		labelId.setBounds(62, 408, 46, 14);
		contentPane.add(labelId);

		lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblX.setBounds(890, 0, 10, 14);
		contentPane.add(lblX);

		JLabel lblLenguajes = new JLabel("Lenguajes:");
		lblLenguajes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLenguajes.setBounds(495, 101, 62, 14);
		contentPane.add(lblLenguajes);

		JRadioButton rdbtnEspaol = new JRadioButton("Espa\u00F1ol");
		rdbtnEspaol.setBounds(563, 97, 62, 23);
		contentPane.add(rdbtnEspaol);

		JRadioButton radioIngles = new JRadioButton("Ingles");
		radioIngles.setBounds(627, 97, 62, 23);
		contentPane.add(radioIngles);

		JRadioButton rdbtnPortugues = new JRadioButton("Portugues");
		rdbtnPortugues.setBounds(691, 97, 82, 23);
		contentPane.add(rdbtnPortugues);

		JRadioButton rdbtnChino = new JRadioButton("Chino");
		rdbtnChino.setBounds(775, 97, 62, 23);
		contentPane.add(rdbtnChino);

		JRadioButton rdbtnArabe = new JRadioButton("Arabe");
		rdbtnArabe.setBounds(563, 126, 62, 23);
		contentPane.add(rdbtnArabe);

		JRadioButton rdbtnItaliano = new JRadioButton("Italiano");
		rdbtnItaliano.setBounds(627, 126, 62, 23);
		contentPane.add(rdbtnItaliano);

		JRadioButton rdbtnAleman = new JRadioButton("Aleman");
		rdbtnAleman.setBounds(691, 126, 62, 23);
		contentPane.add(rdbtnAleman);

		JRadioButton rdbtnFrances = new JRadioButton("Frances");
		rdbtnFrances.setBounds(775, 125, 72, 23);
		contentPane.add(rdbtnFrances);

		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagen.setBounds(495, 191, 62, 14);
		contentPane.add(lblImagen);

		txtBuscar = new JTextField();
		txtBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
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
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setEditable(false);
		txtBuscar.setText("Buscar");
		txtBuscar.setBounds(751, 188, 86, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		textRuta = new JTextField();
		textRuta.setEditable(false);
		textRuta.setBounds(563, 188, 182, 20);
		contentPane.add(textRuta);
		textRuta.setColumns(10);

		iso = new ISO31661();
		daoPais = new PaisDAO();
		DefaultComboBoxModel<ISO3166Alpha2State> modelC = new DefaultComboBoxModel<ISO3166Alpha2State>();
		try {
			for (int i = 0; i < daoPais.verEstados().size(); i++) {
				modelC.addElement(daoPais.verEstados().get(i));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JComboBox<ISO3166Alpha2State> comboBox = new JComboBox<ISO3166Alpha2State>(modelC);
		comboBox.setBounds(563, 250, 274, 20);
		contentPane.add(comboBox);

		JLabel lblEstados = new JLabel("Estado:");
		lblEstados.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstados.setBounds(495, 253, 62, 14);
		contentPane.add(lblEstados);

		setUndecorated(true);

		textAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				p = new Pais();
				iso = new ISO31661();

				try {
					if (daoPais.buscarPaisPorId(Long.valueOf(textID.getText())) == null) {
						if (daoPais.buscarPaisPorIso(textIso2.getText()) == null) {
							if (daoPais.buscarPaisPorIso3(textIso3.getText()) == null) {
								if (daoPais.buscarPaisPorIsoNum(textIsoNum.getText()) == null) {
									if (daoPais.buscarPaisPorNombre(textNom.getText()).size() == 0) {
										if (!(textCap.getText().length() == 0) && !(textNom.getText().length() == 0)
												&& !(textCont.getText().length() == 0)
												&& !(textFips.getText().length() == 0)
												&& !(textIso2.getText().length() == 0)
												&& !(textIso3.getText().length() == 0)) {
											iso.setNumeric(textIsoNum.getText());
											p.setArea(Double.parseDouble(textArea.getText()));
											p.setPopulation(Long.valueOf(textPobl.getText()));
											p.setId(Long.valueOf(textID.getText()));
											estado = new ISO3166Alpha2State();
											estado.setId(Long.valueOf(comboBox.getSelectedIndex() + 1));
											iso.setIso3166Alpha2State(estado);
											ArrayList<String> leng = new ArrayList<String>();
											if (rdbtnAleman.isSelected())
												leng.add("Aleman");
											if (rdbtnArabe.isSelected())
												leng.add("Arabe");
											if (rdbtnChino.isSelected())
												leng.add("Chino");
											if (rdbtnEspaol.isSelected())
												leng.add("Español");
											if (rdbtnFrances.isSelected())
												leng.add("Frances");
											if (rdbtnItaliano.isSelected())
												leng.add("Italiano");
											if (rdbtnPortugues.isSelected())
												leng.add("Portugues");
											p.setLanguages(leng);
											p.setCapital(textCap.getText());
											p.setName(textNom.getText());
											c = new Continente();
											contD = new ContinenteDAO();
											try {
												c.setId(contD.buscarContinentePorNombre(textCont.getText()).get(0)
														.getId());
											} catch (Exception e) {
												e.printStackTrace();
											}
											p.setContinent(c);
											FIPS f = new FIPS();
											f.setFips(textFips.getText());
											p.setFips(f);
											iso.setAlpha2(textIso2.getText());
											iso.setAlpha3(textIso3.getText());
											p.setIso31661(iso);
											IPaisDAO paisD = new PaisDAO();
											try {
												if (paisD.agregarPais(p) == true) {
													paisD.agregarPais(p);
													JOptionPane.showMessageDialog(null, "El pais fue creado");
												} else
													JOptionPane.showMessageDialog(null, "El pais no se pudo crear");
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										} else {
											JOptionPane.showMessageDialog(null,
													"Todos los campos (*) deben estar completados");
										}
									} else {
										JOptionPane.showMessageDialog(null, "Ya existe un pais con el mismo Nombre");
									}
								}else {
									JOptionPane.showMessageDialog(null, "Ya existe un pais con el mismo ISO Numerico");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Ya existe un pais con el mismo ISO 3");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Ya existe un pais con el mismo ISO 2");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Ya existe un pais con el mismo ID");
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Todos los campos (*) deben estar completados");
				}

			}

		});
	}
}
