import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.geo.Proerties;
import org.geo.dao.ContinenteDAO;
import org.geo.dao.IContinenteDAO;
import org.geo.dao.IPaisDAO;
import org.geo.dao.PaisDAO;
import org.geo.model.continent.Continente;
import org.geo.model.country.Pais;

import javax.swing.JList;

public class ContinenteForm extends JFrame {

	private JPanel contentPane;

	public JTextField nombreCont;
	public JTextField codigoCont;
	public JTextField idCont;
	public JTextField wikiURL;
	public JTextField textField_4;
	public JTextField textField_6;
	public JTextField textField_7;
	public JTextField textField_8;

	public ContinenteForm(Continente c) {
		DefaultListModel<String> model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setBounds(886, 0, 14, 24);
		contentPane.add(lblX);

		JLabel label = new JLabel("Continente Encontrado");
		label.setBounds(0, 27, 501, 24);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(label);

		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(23, 83, 92, 14);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Codigo:");
		label_2.setBounds(23, 111, 92, 14);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Id:");
		label_3.setBounds(23, 139, 92, 14);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Wikipedia URL:");
		label_4.setBounds(23, 164, 92, 14);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(label_4);

		nombreCont = new JTextField();
		nombreCont.setBounds(122, 80, 300, 20);
		nombreCont.setEditable(false);
		nombreCont.setColumns(10);
		getContentPane().add(nombreCont);
		nombreCont.setText(c.getShortName());

		codigoCont = new JTextField();
		codigoCont.setBounds(122, 108, 300, 20);
		codigoCont.setEditable(false);
		codigoCont.setColumns(10);
		getContentPane().add(codigoCont);
		codigoCont.setText(c.getCode());

		idCont = new JTextField();
		idCont.setBounds(122, 137, 300, 20);
		idCont.setEditable(false);
		idCont.setColumns(10);
		getContentPane().add(idCont);
		idCont.setText(c.getId().toString());

		wikiURL = new JTextField();
		wikiURL.setBounds(122, 162, 300, 20);
		wikiURL.setEditable(false);
		wikiURL.setColumns(10);
		getContentPane().add(wikiURL);
		wikiURL.setText(c.getWikipediaURL());

		JLabel labelImagen = new JLabel("New label");
		labelImagen.setBounds(122, 193, 300, 249);
		getContentPane().add(labelImagen);
		labelImagen.setIcon(new ImageIcon(
				Proerties.pathFolderContinents + "//" + c.getCode() + "_orthographic_projection_svg.jpg"));

		JLabel label_6 = new JLabel("Paises:");
		label_6.setBounds(498, 77, 46, 14);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(label_6);

		textField_4 = new JTextField();
		textField_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		textField_4.setBounds(804, 469, 86, 20);
		textField_4.setText("Volver");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		getContentPane().add(textField_4);

		textField_6 = new JTextField();
		textField_6.setBounds(708, 469, 86, 20);
		textField_6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				nombreCont.setEditable(true);
				idCont.setEditable(true);
				codigoCont.setEditable(true);
				wikiURL.setEditable(true);
				textField_6.setVisible(false);
				textField_4.setVisible(false);
			}
		});
		textField_6.setText("Modificar");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setBounds(804, 469, 86, 20);
		textField_7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				IContinenteDAO contD = new ContinenteDAO();
				try {
					c.setCode(codigoCont.getText());
					c.setId(Long.valueOf(idCont.getText()));
					c.setShortName(nombreCont.getText());
					c.setWikipediaURL(wikiURL.getText());
					contD.update(c);
					nombreCont.setEditable(false);
					idCont.setEditable(false);
					codigoCont.setEditable(false);
					wikiURL.setEditable(false);
					textField_6.setVisible(true);
					textField_4.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		textField_7.setText("Aceptar");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		getContentPane().add(textField_7);

		textField_8 = new JTextField();
		textField_8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				nombreCont.setEditable(false);
				idCont.setEditable(false);
				codigoCont.setEditable(false);
				wikiURL.setEditable(false);
				textField_6.setVisible(true);
				textField_4.setVisible(true);
			}
		});
		textField_8.setBounds(708, 469, 86, 20);
		textField_8.setText("Volver");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		getContentPane().add(textField_8);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(551, 81, 300, 323);
		contentPane.add(scrollPane);

		model = new DefaultListModel<String>();
		JList list = new JList(model);
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					IPaisDAO pDao = new PaisDAO();
					try {
						Pais p = new Pais();
						p = pDao.buscarPaisPorNombre(list.getSelectedValue().toString()).get(0);
						PaisForm pF = new PaisForm(p);
						pF.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		scrollPane.setViewportView(list);
		IPaisDAO pDao = new PaisDAO();

		try {
			c.setCountries(pDao.buscarPaisPorContinente(c.getId()));
			for (int i = 0; i < c.getCountries().size(); i++) {
				model.addElement(c.getCountries().get(i).getName());

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
