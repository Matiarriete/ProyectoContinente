import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.introspect.BasicClassIntrospector.GetterMethodFilter;
import org.geo.Proerties;
import org.geo.dao.ContinenteDAO;
import org.geo.dao.IPaisDAO;
import org.geo.dao.PaisDAO;
import org.geo.model.continent.Continente;
import org.geo.model.country.FIPS;
import org.geo.model.country.ISO31661;
import org.geo.model.country.Pais;
import org.geo.model.country.iso3166alpha2state.ISO3166Alpha2State;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class PaisForm extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textCont;
	private JTextField textFips;
	private JTextField textArea;
	private JTextField textPobl;
	private JTextField textCap;
	private JTextField textNombre;
	private JTextField textIsoNum;
	private JTextField textIso3;
	private JTextField textIso2;
	private IPaisDAO pDao;
	private JTextField textVolver;
	private JTextField textModi;
	private JTextField textAceptarMod;
	private JTextField textVolverMod;
	private ContinenteDAO daoCont;
	private JTextField textField_1;
	private JTextField textField_2;

	public PaisForm(Pais p) {

		pDao = new PaisDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelImagen = new JLabel("");
		labelImagen.setBounds(501, 264, 342, 177);
		getContentPane().add(labelImagen);
		labelImagen.setIcon(new ImageIcon(
				Proerties.pathFolderCountries + "//" + p.getIso31661().getAlpha2() + "_national_flag_gif.png"));

		textId = new JTextField();
		textId.setEditable(false);
		textId.setColumns(10);
		textId.setBounds(102, 357, 341, 20);
		contentPane.add(textId);

		textCont = new JTextField();
		textCont.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				daoCont = new ContinenteDAO();
				Continente c = new Continente();
				try {
					c = daoCont.buscarContinentePorNombre(textCont.getText()).get(0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ContinenteForm cF = new ContinenteForm(c);
				cF.setVisible(true);
				dispose();
			}
		});
		textCont.setEditable(false);
		textCont.setColumns(10);
		textCont.setBounds(102, 326, 341, 20);
		contentPane.add(textCont);

		textFips = new JTextField();
		textFips.setEditable(false);
		textFips.setColumns(10);
		textFips.setBounds(102, 295, 341, 20);
		contentPane.add(textFips);

		textArea = new JTextField();
		textArea.setEditable(false);
		textArea.setColumns(10);
		textArea.setBounds(102, 264, 341, 20);
		contentPane.add(textArea);

		textPobl = new JTextField();
		textPobl.setEditable(false);
		textPobl.setColumns(10);
		textPobl.setBounds(102, 233, 341, 20);
		contentPane.add(textPobl);

		textCap = new JTextField();
		textCap.setEditable(false);
		textCap.setColumns(10);
		textCap.setBounds(102, 202, 341, 20);
		contentPane.add(textCap);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(102, 171, 341, 20);
		contentPane.add(textNombre);

		textIsoNum = new JTextField();
		textIsoNum.setEditable(false);
		textIsoNum.setColumns(10);
		textIsoNum.setBounds(102, 140, 341, 20);
		contentPane.add(textIsoNum);

		textIso3 = new JTextField();
		textIso3.setEditable(false);
		textIso3.setColumns(10);
		textIso3.setBounds(102, 109, 341, 20);
		contentPane.add(textIso3);

		textIso2 = new JTextField();
		textIso2.setEditable(false);
		textIso2.setColumns(10);
		textIso2.setBounds(102, 81, 341, 20);
		contentPane.add(textIso2);

		JLabel label = new JLabel("ISO 2:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(46, 84, 46, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("ISO 3:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(46, 112, 46, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("ISO Numerico:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(10, 143, 82, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Nombre:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(30, 174, 62, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Capital:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(46, 205, 46, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Poblacion:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(30, 236, 62, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("Area:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(46, 267, 46, 14);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("Fips:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(46, 298, 46, 14);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("Continente:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(20, 329, 72, 14);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("Vecinos:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(471, 87, 62, 14);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("ID:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(46, 360, 46, 14);
		contentPane.add(label_10);

		JLabel lblPaisEncontrado = new JLabel("Pais Encontrado");
		lblPaisEncontrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaisEncontrado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPaisEncontrado.setBounds(0, 23, 900, 34);
		contentPane.add(lblPaisEncontrado);

		textIso2.setText(p.getIso31661().getAlpha2());
		textIso3.setText(p.getIso31661().getAlpha3());
		textIsoNum.setText(p.getIso31661().getNumeric());
		textId.setText(p.getId().toString());
		textArea.setText(p.getArea().toString());
		textCap.setText(p.getCapital());
		ContinenteDAO contD = new ContinenteDAO();
		try {
			String cont = contD.buscarContinentePorId(p.getContinent().getId()).getShortName();
			textCont.setText(cont);
		} catch (Exception e) {
			e.printStackTrace();
		}

		textFips.setText(p.getFips().getFips());
		textNombre.setText(p.getName());
		textPobl.setText(p.getPopulation().toString());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(543, 81, 300, 91);
		contentPane.add(scrollPane);

		DefaultListModel<String> model = new DefaultListModel<String>();
		JList list = new JList(model);
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					try {
						Pais pais = new Pais();
						pais = pDao.buscarPaisPorNombre(list.getSelectedValue().toString()).get(0);
						PaisForm pF = new PaisForm(pais);
						pF.setVisible(true);
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		scrollPane.setViewportView(list);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setBounds(886, 0, 14, 20);
		contentPane.add(lblX);

		textVolver = new JTextField();
		textVolver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		textVolver.setText("Volver");
		textVolver.setHorizontalAlignment(SwingConstants.CENTER);
		textVolver.setEditable(false);
		textVolver.setColumns(10);
		textVolver.setBounds(804, 469, 86, 20);
		contentPane.add(textVolver);

		textModi = new JTextField();
		textModi.setText("Modificar");
		textModi.setHorizontalAlignment(SwingConstants.CENTER);
		textModi.setEditable(false);
		textModi.setColumns(10);
		textModi.setBounds(708, 469, 86, 20);
		contentPane.add(textModi);

		textAceptarMod = new JTextField();

		textAceptarMod.setText("Aceptar");
		textAceptarMod.setHorizontalAlignment(SwingConstants.CENTER);
		textAceptarMod.setEditable(false);
		textAceptarMod.setColumns(10);
		textAceptarMod.setBounds(804, 469, 86, 20);
		contentPane.add(textAceptarMod);

		textVolverMod = new JTextField();
		textVolverMod.setText("Volver");
		textVolverMod.setHorizontalAlignment(SwingConstants.CENTER);
		textVolverMod.setEditable(false);
		textVolverMod.setColumns(10);
		textVolverMod.setBounds(708, 469, 86, 20);
		contentPane.add(textVolverMod);

		JRadioButton radioButton = new JRadioButton("Espa\u00F1ol");
		radioButton.setBounds(543, 179, 62, 23);
		contentPane.add(radioButton);
		radioButton.setEnabled(false);

		JRadioButton radioButton_1 = new JRadioButton("Ingles");
		radioButton_1.setBounds(607, 179, 62, 23);
		contentPane.add(radioButton_1);
		radioButton_1.setEnabled(false);

		JRadioButton radioButton_2 = new JRadioButton("Portugues");
		radioButton_2.setBounds(671, 179, 82, 23);
		contentPane.add(radioButton_2);
		radioButton_2.setEnabled(false);

		JRadioButton radioButton_3 = new JRadioButton("Chino");
		radioButton_3.setBounds(755, 179, 62, 23);
		contentPane.add(radioButton_3);
		radioButton_3.setEnabled(false);

		JRadioButton radioButton_4 = new JRadioButton("Arabe");
		radioButton_4.setBounds(543, 208, 62, 23);
		contentPane.add(radioButton_4);
		radioButton_4.setEnabled(false);

		JRadioButton radioButton_5 = new JRadioButton("Italiano");
		radioButton_5.setBounds(607, 208, 62, 23);
		contentPane.add(radioButton_5);
		radioButton_5.setEnabled(false);

		JRadioButton radioButton_6 = new JRadioButton("Aleman");
		radioButton_6.setBounds(671, 208, 62, 23);
		contentPane.add(radioButton_6);
		radioButton_6.setEnabled(false);

		JRadioButton radioButton_7 = new JRadioButton("Frances");
		radioButton_7.setBounds(755, 207, 72, 23);
		contentPane.add(radioButton_7);
		radioButton_7.setEnabled(false);

		for (int i = 0; i < p.getLanguages().size(); i++) {
			if (p.getLanguages().get(i).toLowerCase().equals("es")
					|| p.getLanguages().get(i).toLowerCase().equals("español")) {
				radioButton.setSelected(true);
			} else {
				if (p.getLanguages().get(i).toLowerCase().equals("en")
						|| p.getLanguages().get(i).toLowerCase().equals("ingles")) {
					radioButton_1.setSelected(true);
				} else {
					if (p.getLanguages().get(i).toLowerCase().equals("")
							|| p.getLanguages().get(i).toLowerCase().equals("portugues")) {
						radioButton_2.setSelected(true);
					} else {
						if (p.getLanguages().get(i).toLowerCase().equals("ch")
								|| p.getLanguages().get(i).toLowerCase().equals("chino")) {
							radioButton_3.setSelected(true);
						} else {
							if (p.getLanguages().get(i).toLowerCase().equals("ar")
									|| p.getLanguages().get(i).toLowerCase().equals("arabe")) {
								radioButton_4.setSelected(true);
							} else {
								if (p.getLanguages().get(i).toLowerCase().equals("it")
										|| p.getLanguages().get(i).toLowerCase().equals("italiano")) {
									radioButton_5.setSelected(true);
								} else {
									if (p.getLanguages().get(i).toLowerCase().equals("al")
											|| p.getLanguages().get(i).toLowerCase().equals("aleman")) {
										radioButton_6.setSelected(true);
									} else {
										if (p.getLanguages().get(i).toLowerCase().equals("fr")
												|| p.getLanguages().get(i).toLowerCase().equals("frances")) {
											radioButton_7.setSelected(true);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		JLabel label_11 = new JLabel("Imagen:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(475, 273, 62, 14);
		contentPane.add(label_11);
		label_11.setVisible(false);

		textField_1 = new JTextField();
		textField_1.setText("Buscar");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(731, 270, 86, 20);
		contentPane.add(textField_1);
		textField_1.setVisible(false);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(543, 270, 182, 20);
		contentPane.add(textField_2);
		textField_2.setVisible(false);

		DefaultComboBoxModel<ISO3166Alpha2State> modelC = new DefaultComboBoxModel<ISO3166Alpha2State>();
		try {
			for (int i = 0; i < pDao.verEstados().size(); i++) {
				modelC.addElement(pDao.verEstados().get(i));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JComboBox<ISO3166Alpha2State> comboBox = new JComboBox<ISO3166Alpha2State>(modelC);
		comboBox.setBounds(102, 388, 341, 20);
		contentPane.add(comboBox);
		comboBox.setSelectedItem(p.getIso31661().getIso3166Alpha2State());
		comboBox.setEnabled(false);

		JLabel label_12 = new JLabel("Estados:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setBounds(46, 391, 46, 14);
		contentPane.add(label_12);
		try {
			for (int i = 0; i < p.getNeighbours().size(); i++) {
				model.addElement(pDao.buscarPaisPorId(p.getNeighbours().get(i).getId()).getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		textVolverMod.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textArea.setEditable(false);
				textCap.setEditable(false);
				textCont.setEditable(false);
				textFips.setEditable(false);
				textId.setEditable(false);
				textIso2.setEditable(false);
				textIso3.setEditable(false);
				textIsoNum.setEditable(false);
				textNombre.setEditable(false);
				textPobl.setEditable(false);
				textModi.setVisible(true);
				textVolver.setVisible(true);
				labelImagen.setVisible(true);
				textField_2.setVisible(false);
				textField_1.setVisible(false);
				label_11.setVisible(false);
				comboBox.setEnabled(false);
				radioButton.setEnabled(false);
				radioButton_1.setEnabled(false);
				radioButton_2.setEnabled(false);
				radioButton_3.setEnabled(false);
				radioButton_4.setEnabled(false);
				radioButton_5.setEnabled(false);
				radioButton_6.setEnabled(false);
				radioButton_7.setEnabled(false);

			}
		});

		textModi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textArea.setEditable(true);
				textCap.setEditable(true);
				textCont.setEditable(true);
				textFips.setEditable(true);
				textId.setEditable(true);
				textIso2.setEditable(true);
				textIso3.setEditable(true);
				textIsoNum.setEditable(true);
				textNombre.setEditable(true);
				textPobl.setEditable(true);
				textModi.setVisible(false);
				textVolver.setVisible(false);
				labelImagen.setVisible(false);
				comboBox.setVisible(true);
				textField_2.setVisible(true);
				textField_1.setVisible(true);
				label_11.setVisible(true);
				comboBox.setEnabled(true);
				radioButton.setEnabled(true);
				radioButton_1.setEnabled(true);
				radioButton_2.setEnabled(true);
				radioButton_3.setEnabled(true);
				radioButton_4.setEnabled(true);
				radioButton_5.setEnabled(true);
				radioButton_6.setEnabled(true);
				radioButton_7.setEnabled(true);
			}
		});

		textAceptarMod.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				p.setArea(Double.valueOf(textArea.getText()));
				p.setCapital(textCap.getText());
				try {
					Continente c = new Continente();
					daoCont = new ContinenteDAO();
					Long s = daoCont.buscarContinentePorNombre(textCont.getText()).get(0).getId();
					c = daoCont.buscarContinentePorId(s);
					p.setContinent(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				FIPS f = new FIPS();
				f.setFips(textFips.getText());
				p.setFips(f);
				p.setName(textNombre.getText());
				p.setId(Long.valueOf(textId.getText()));
				ISO31661 iso = new ISO31661();
				iso.setAlpha2(textIso2.getText());
				iso.setAlpha3(textIso3.getText());
				iso.setNumeric(textIsoNum.getText());
				ISO3166Alpha2State isoEstado = new ISO3166Alpha2State();
				isoEstado.setId(Long.valueOf(comboBox.getSelectedIndex() + 1));
				iso.setIso3166Alpha2State(isoEstado);
				p.setIso31661(iso);
				List<String> leng = new ArrayList<String>();
				if (radioButton.isSelected())
					leng.add("Español");
				if (radioButton_1.isSelected())
					leng.add("Ingles");
				if (radioButton_2.isSelected())
					leng.add("Español");
				if (radioButton_3.isSelected())
					leng.add("Ingles");
				if (radioButton_4.isSelected())
					leng.add("Español");
				if (radioButton_5.isSelected())
					leng.add("Ingles");
				if (radioButton_6.isSelected())
					leng.add("Español");
				if (radioButton_7.isSelected())
					leng.add("Ingles");
				p.setLanguages(leng);
				p.setPopulation(Long.valueOf(textPobl.getText()));
				try {
					pDao.update(p);
					textArea.setEditable(false);
					textCap.setEditable(false);
					textCont.setEditable(false);
					textFips.setEditable(false);
					textId.setEditable(false);
					textIso2.setEditable(false);
					textIso3.setEditable(false);
					textIsoNum.setEditable(false);
					textNombre.setEditable(false);
					textPobl.setEditable(false);
					textModi.setVisible(true);
					textVolver.setVisible(true);
					labelImagen.setVisible(true);
					textField_2.setVisible(false);
					textField_1.setVisible(false);
					label_11.setVisible(false);
					comboBox.setEnabled(false);
					radioButton.setEnabled(false);
					radioButton_1.setEnabled(false);
					radioButton_2.setEnabled(false);
					radioButton_3.setEnabled(false);
					radioButton_4.setEnabled(false);
					radioButton_5.setEnabled(false);
					radioButton_6.setEnabled(false);
					radioButton_7.setEnabled(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		setUndecorated(true);
	}
}
