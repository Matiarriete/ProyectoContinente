import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.introspect.BasicClassIntrospector.GetterMethodFilter;
import org.geo.Proerties;
import org.geo.dao.ContinenteDAO;
import org.geo.dao.IContinenteDAO;
import org.geo.dao.IPaisDAO;
import org.geo.dao.PaisDAO;
import org.geo.model.continent.Continente;
import org.geo.model.country.Pais;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DisenoAppCopia extends JFrame {

	private JPanel contentPane;
	private JTextField textBContID;
	private JTextField textBContCod;
	private JTextField textBContNom;
	private JTextField cancelarBContCod;
	private JTextField aceptarBContCod;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField cancelarBContNom;
	private JTextField aceptarBContNom;
	private IContinenteDAO daoContinente;
	private IPaisDAO daoPais;
	private AgregarContForm agregarCont;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textIso2BP;
	private JTextField textIso3BP;
	private JTextField textNomBP;
	private JTextField textIsoNumBP;
	private JTextField textContBP;
	private JTextField textIdBP;
	private ButtonGroup botones = new ButtonGroup();
	private Pais p;
	private PaisForm pF;
	private JTextField textField_2;
	private Continente c;
	private LogIn logIn;

	public DisenoAppCopia() {

		daoContinente = new ContinenteDAO();
		daoPais = new PaisDAO();
		agregarCont = new AgregarContForm();
		DefaultListModel<String> model;
		JList listBContNom;
		model = new DefaultListModel();

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\64782954-icono-del-planeta-globo-del-mundo-de-la-tierra-y-el-tema-del-continente-dise\u00F1o-blanco-y-negro-aislado-i.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(205, 100, 900, 500);
		;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		this.setLocationRelativeTo(null);

		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(new Color(192, 192, 192));
		panelIzq.setForeground(new Color(173, 216, 230));
		panelIzq.setBounds(0, 0, 192, 500);
		contentPane.add(panelIzq);
		panelIzq.setLayout(null);

		JLabel lblPaises = new JLabel("Paises");
		lblPaises.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaises.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\Argentina_web-1_opt.png"));
		lblPaises.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblPaises.setBounds(0, 162, 192, 45);
		panelIzq.add(lblPaises);

		JLabel lblSobreNosotros = new JLabel("Sobre Nosotros");
		lblSobreNosotros.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\36601_opt.png"));
		lblSobreNosotros.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				SobreNos sN = new SobreNos();
				sN.setVisible(true);
			}
		});
		lblSobreNosotros.setHorizontalAlignment(SwingConstants.CENTER);
		lblSobreNosotros.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblSobreNosotros.setBounds(0, 444, 192, 45);
		panelIzq.add(lblSobreNosotros);

		JLabel lblBienvenidos = new JLabel("Bienvenidos");
		lblBienvenidos.setBounds(50, 26, 88, 22);
		panelIzq.add(lblBienvenidos);
		lblBienvenidos.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblBienvenidos.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_3 = new JLabel("Continentes");
		lblNewLabel_3.setBounds(0, 98, 192, 45);
		panelIzq.add(lblNewLabel_3);
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblNewLabel_3.setIcon(new ImageIcon(
				"C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\kisspng-world-map-globe-clip-art-5af60add254229_opt.png"));
		
		JLabel lblCerrarSesion = new JLabel("Cerrar Sesion");
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				logIn = new LogIn();
				logIn.setVisible(true);
				dispose();
			}
		});
		lblCerrarSesion.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\de691f7b9e_opt.png"));
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblCerrarSesion.setBounds(0, 388, 192, 45);
		panelIzq.add(lblCerrarSesion);

		JLayeredPane panelDerecha = new JLayeredPane();
		panelDerecha.setBounds(191, 0, 709, 500);
		contentPane.add(panelDerecha);

		JPanel panelPais = new JPanel();
		panelPais.setBackground(new Color(255, 255, 255));
		panelPais.setBounds(0, 0, 709, 500);
		panelDerecha.add(panelPais);
		panelPais.setLayout(null);
		panelPais.setVisible(false);

		JLabel label_8 = new JLabel("X");
		label_8.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				dispose();
			}
		});
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(697, 0, 12, 14);
		panelPais.add(label_8);
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 17));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(235, 0, 474, 500);
		panelPais.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(55, 102, 369, 350);
		panel_1.add(scrollPane_2);

		JList list = new JList(model);
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					try {
						p = daoPais.buscarPaisPorNombre(list.getSelectedValue().toString()).get(0);
						pF = new PaisForm(p);
						pF.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		scrollPane_2.setViewportView(list);

		JLabel lblBuscarPais = new JLabel("Buscar Pais");
		lblBuscarPais.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBuscarPais.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarPais.setBounds(10, 28, 454, 37);
		panel_1.add(lblBuscarPais);

		JLayeredPane panelDerechaPais = new JLayeredPane();
		panelDerechaPais.setBounds(235, 0, 474, 500);
		panelPais.add(panelDerechaPais);

		JPanel panelBTodosPais = new JPanel();
		panelBTodosPais.setLayout(null);
		panelBTodosPais.setBackground(new Color(175, 238, 238));
		panelBTodosPais.setBounds(10, 382, 454, 69);
		panelDerechaPais.add(panelBTodosPais);

		JLabel label_32 = new JLabel("Buscar");
		label_32.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_32.setBounds(154, 11, 82, 25);
		panelBTodosPais.add(label_32);

		JLabel lblTodos = new JLabel("Todos");
		lblTodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTodos.setBounds(210, 42, 82, 16);
		panelBTodosPais.add(lblTodos);

		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelDerechaPais.setVisible(false);
			}
		});
		textField.setText("Cancelar");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(287, 469, 86, 20);
		panelDerechaPais.add(textField);

		textField_1 = new JTextField();
		textField_1.setText("Aceptar");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(378, 469, 86, 20);
		panelDerechaPais.add(textField_1);

		textIso2BP = new JTextField();
		textIso2BP.setToolTipText("");
		textIso2BP.setEditable(false);
		textIso2BP.setBounds(157, 95, 307, 20);
		panelDerechaPais.add(textIso2BP);
		textIso2BP.setColumns(10);

		textIso3BP = new JTextField();
		textIso3BP.setEditable(false);
		textIso3BP.setColumns(10);
		textIso3BP.setBounds(157, 135, 307, 20);
		panelDerechaPais.add(textIso3BP);

		textNomBP = new JTextField();
		textNomBP.setEditable(false);
		textNomBP.setColumns(10);
		textNomBP.setBounds(157, 223, 307, 20);
		panelDerechaPais.add(textNomBP);

		textIsoNumBP = new JTextField();
		textIsoNumBP.setEditable(false);
		textIsoNumBP.setColumns(10);
		textIsoNumBP.setBounds(157, 183, 307, 20);
		panelDerechaPais.add(textIsoNumBP);

		textContBP = new JTextField();
		textContBP.setEditable(false);
		textContBP.setColumns(10);
		textContBP.setBounds(157, 306, 307, 20);
		panelDerechaPais.add(textContBP);

		textIdBP = new JTextField();
		textIdBP.setEditable(false);
		textIdBP.setColumns(10);
		textIdBP.setBounds(157, 266, 307, 20);
		panelDerechaPais.add(textIdBP);

		JRadioButton rdbtnIso2 = new JRadioButton("Buscar por Iso");
		rdbtnIso2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textIso2BP.setEditable(true);
				textIso3BP.setEditable(false);
				textIsoNumBP.setEditable(false);
				textIdBP.setEditable(false);
				textNomBP.setEditable(false);
				textContBP.setEditable(false);
			}
		});
		rdbtnIso2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnIso2.setBounds(6, 94, 145, 23);
		panelDerechaPais.add(rdbtnIso2);

		JRadioButton rdbtnBuscarPorIso3 = new JRadioButton("Buscar por Iso 3");
		rdbtnBuscarPorIso3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textIso2BP.setEditable(false);
				textIso3BP.setEditable(true);
				textIsoNumBP.setEditable(false);
				textIdBP.setEditable(false);
				textNomBP.setEditable(false);
				textContBP.setEditable(false);
			}
		});
		rdbtnBuscarPorIso3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBuscarPorIso3.setBounds(6, 134, 145, 23);
		panelDerechaPais.add(rdbtnBuscarPorIso3);

		JRadioButton rdbtnBuscarPorIsoNum = new JRadioButton("Buscar por Iso Numerico");
		rdbtnBuscarPorIsoNum.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textIso2BP.setEditable(false);
				textIso3BP.setEditable(false);
				textIsoNumBP.setEditable(true);
				textIdBP.setEditable(false);
				textNomBP.setEditable(false);
				textContBP.setEditable(false);
			}
		});
		rdbtnBuscarPorIsoNum.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBuscarPorIsoNum.setBounds(6, 182, 145, 23);
		panelDerechaPais.add(rdbtnBuscarPorIsoNum);

		JRadioButton rdbtnBuscarPorCont = new JRadioButton("Buscar por Cont");
		rdbtnBuscarPorCont.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textIso2BP.setEditable(false);
				textIso3BP.setEditable(false);
				textIsoNumBP.setEditable(false);
				textIdBP.setEditable(false);
				textNomBP.setEditable(false);
				textContBP.setEditable(true);
			}
		});
		rdbtnBuscarPorCont.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBuscarPorCont.setBounds(6, 311, 145, 23);
		panelDerechaPais.add(rdbtnBuscarPorCont);

		JRadioButton rdbtnBuscarPorNombre = new JRadioButton("Buscar por Nombre");
		rdbtnBuscarPorNombre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textIso2BP.setEditable(false);
				textIso3BP.setEditable(false);
				textIsoNumBP.setEditable(false);
				textIdBP.setEditable(false);
				textNomBP.setEditable(true);
				textContBP.setEditable(false);
			}
		});
		rdbtnBuscarPorNombre.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBuscarPorNombre.setBounds(6, 223, 145, 23);
		panelDerechaPais.add(rdbtnBuscarPorNombre);

		JRadioButton rdbtnBuscarPorId = new JRadioButton("Buscar por Id");
		rdbtnBuscarPorId.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textIso2BP.setEditable(false);
				textIso3BP.setEditable(false);
				textIsoNumBP.setEditable(false);
				textIdBP.setEditable(true);
				textNomBP.setEditable(false);
				textContBP.setEditable(false);
			}
		});
		rdbtnBuscarPorId.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBuscarPorId.setBounds(6, 263, 145, 23);
		panelDerechaPais.add(rdbtnBuscarPorId);

		botones.add(rdbtnBuscarPorId);
		botones.add(rdbtnBuscarPorNombre);
		botones.add(rdbtnBuscarPorCont);
		botones.add(rdbtnBuscarPorIsoNum);
		botones.add(rdbtnBuscarPorIso3);
		botones.add(rdbtnIso2);

		JPanel panelBuscarPais = new JPanel();

		panelBuscarPais.setLayout(null);
		panelBuscarPais.setBackground(new Color(210, 180, 140));
		panelBuscarPais.setBounds(15, 113, 208, 80);
		panelPais.add(panelBuscarPais);

		JLabel lblPais_3 = new JLabel("Pais");
		lblPais_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPais_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblPais_3.setBounds(96, 44, 110, 25);
		panelBuscarPais.add(lblPais_3);

		JLabel label_22 = new JLabel("Buscar");
		label_22.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		label_22.setBounds(86, 17, 81, 22);
		panelBuscarPais.add(label_22);

		JLabel label_23 = new JLabel("");
		label_23.setIcon(new ImageIcon(
				"C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\51-514569_dibujo-lupa-png-desenho-lupa-para-colorir_opt.png"));
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		label_23.setBackground(new Color(218, 112, 214));
		label_23.setBounds(6, 2, 70, 74);
		panelBuscarPais.add(label_23);

		JPanel panelVolverIni = new JPanel();
		panelVolverIni.setLayout(null);
		panelVolverIni.setBackground(new Color(233, 150, 122));
		panelVolverIni.setBounds(15, 386, 208, 80);
		panelPais.add(panelVolverIni);

		JLabel label_24 = new JLabel("Inicio");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		label_24.setBounds(96, 44, 110, 25);
		panelVolverIni.add(label_24);

		JLabel label_25 = new JLabel("Volver a");
		label_25.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		label_25.setBounds(86, 17, 81, 22);
		panelVolverIni.add(label_25);

		JLabel label_26 = new JLabel("");
		label_26.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\flecha-volver-png_opt.png"));
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		label_26.setBackground(new Color(218, 112, 214));
		label_26.setBounds(6, 2, 70, 74);
		panelVolverIni.add(label_26);

		JPanel panelAgregarPais = new JPanel();
		panelAgregarPais.setBounds(15, 22, 208, 80);
		panelPais.add(panelAgregarPais);
		panelAgregarPais.setLayout(null);
		panelAgregarPais.setBackground(new Color(173, 216, 230));

		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\69301_opt.png"));
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		label_11.setBackground(new Color(218, 112, 214));
		label_11.setBounds(6, 6, 70, 70);
		panelAgregarPais.add(label_11);

		JLabel lblPais = new JLabel("Pais");
		lblPais.setHorizontalAlignment(SwingConstants.CENTER);
		lblPais.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblPais.setBounds(86, 44, 110, 25);
		panelAgregarPais.add(lblPais);

		JLabel label_14 = new JLabel("Agregar");
		label_14.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		label_14.setBounds(86, 15, 70, 22);
		panelAgregarPais.add(label_14);

		panelAgregarPais.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				AgregarPaisForm agregarPais = new AgregarPaisForm();
				agregarPais.setVisible(true);
			}
		});

		JPanel panelCont = new JPanel();
		panelCont.setBackground(new Color(255, 255, 255));
		panelCont.setBounds(0, 0, 709, 500);
		panelDerecha.add(panelCont);
		panelCont.setLayout(null);
		panelCont.setVisible(false);

		JLabel label = new JLabel("X");
		label.setBounds(697, 0, 12, 15);
		panelCont.add(label);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 17));

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(235, 0, 474, 500);
		panelCont.add(layeredPane);

		JPanel panelBuscarContD = new JPanel();
		panelBuscarContD.setBackground(new Color(255, 255, 255));
		panelBuscarContD.setBounds(0, 0, 474, 500);
		layeredPane.add(panelBuscarContD);
		panelBuscarContD.setLayout(null);
		panelBuscarContD.setVisible(false);

		JPanel opcBuscarID = new JPanel();
		opcBuscarID.setLayout(null);
		opcBuscarID.setBackground(new Color(175, 238, 238));
		opcBuscarID.setBounds(131, 92, 210, 69);
		panelBuscarContD.add(opcBuscarID);

		JLabel label_12 = new JLabel("Buscar");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_12.setBounds(43, 11, 82, 25);
		opcBuscarID.add(label_12);

		JLabel label_13 = new JLabel("Por ID");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_13.setBounds(92, 39, 82, 16);
		opcBuscarID.add(label_13);

		JPanel opcBuscarCodigo = new JPanel();
		opcBuscarCodigo.setLayout(null);
		opcBuscarCodigo.setBackground(new Color(175, 238, 238));
		opcBuscarCodigo.setBounds(131, 172, 210, 69);
		panelBuscarContD.add(opcBuscarCodigo);

		JLabel label_16 = new JLabel("Buscar");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_16.setBounds(43, 11, 82, 25);
		opcBuscarCodigo.add(label_16);

		JLabel label_18 = new JLabel("Por Codigo");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_18.setBounds(83, 33, 105, 25);
		opcBuscarCodigo.add(label_18);

		JPanel opcBuscarNombre = new JPanel();
		opcBuscarNombre.setLayout(null);
		opcBuscarNombre.setBackground(new Color(175, 238, 238));
		opcBuscarNombre.setBounds(131, 252, 210, 69);
		panelBuscarContD.add(opcBuscarNombre);

		JLabel label_21 = new JLabel("Buscar");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_21.setBounds(43, 11, 82, 25);
		opcBuscarNombre.add(label_21);

		JLabel label_27 = new JLabel("Por Nombre");
		label_27.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_27.setBounds(69, 33, 105, 25);
		opcBuscarNombre.add(label_27);

		JPanel opcBuscarTodos = new JPanel();
		opcBuscarTodos.setLayout(null);
		opcBuscarTodos.setBackground(new Color(175, 238, 238));
		opcBuscarTodos.setBounds(131, 332, 210, 69);
		panelBuscarContD.add(opcBuscarTodos);

		JLabel label_28 = new JLabel("Buscar");
		label_28.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_28.setBounds(43, 11, 82, 25);
		opcBuscarTodos.add(label_28);

		JLabel label_29 = new JLabel("Todos");
		label_29.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_29.setBounds(92, 39, 82, 16);
		opcBuscarTodos.add(label_29);

		JPanel panelBuscarContPorCodigo = new JPanel();
		panelBuscarContPorCodigo.setBackground(new Color(255, 255, 255));
		panelBuscarContPorCodigo.setLayout(null);
		panelBuscarContPorCodigo.setBounds(0, 0, 474, 500);
		layeredPane.add(panelBuscarContPorCodigo);

		JLabel lblBuscarContinentePor_1 = new JLabel("Buscar Continente Por Codigo");
		lblBuscarContinentePor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarContinentePor_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBuscarContinentePor_1.setBounds(0, 98, 474, 31);
		panelBuscarContPorCodigo.add(lblBuscarContinentePor_1);

		JLabel lblIngreseElCodigo = new JLabel("Ingrese el Codigo del Continente:");
		lblIngreseElCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIngreseElCodigo.setBounds(10, 172, 182, 14);
		panelBuscarContPorCodigo.add(lblIngreseElCodigo);

		textBContCod = new JTextField();
		textBContCod.setHorizontalAlignment(SwingConstants.CENTER);
		textBContCod.setColumns(10);
		textBContCod.setBounds(213, 169, 251, 20);
		panelBuscarContPorCodigo.add(textBContCod);

		cancelarBContCod = new JTextField();
		cancelarBContCod.setText("Cancelar");
		cancelarBContCod.setHorizontalAlignment(SwingConstants.CENTER);
		cancelarBContCod.setEditable(false);
		cancelarBContCod.setColumns(10);
		cancelarBContCod.setBounds(287, 469, 86, 20);
		panelBuscarContPorCodigo.add(cancelarBContCod);

		aceptarBContCod = new JTextField();
		aceptarBContCod.setText("Aceptar");
		aceptarBContCod.setHorizontalAlignment(SwingConstants.CENTER);
		aceptarBContCod.setEditable(false);
		aceptarBContCod.setColumns(10);
		aceptarBContCod.setBounds(378, 469, 86, 20);
		panelBuscarContPorCodigo.add(aceptarBContCod);

		JPanel panelBuscarContNombre = new JPanel();
		panelBuscarContNombre.setBackground(new Color(255, 255, 255));
		panelBuscarContNombre.setBounds(0, 0, 474, 500);
		layeredPane.add(panelBuscarContNombre);
		panelBuscarContNombre.setLayout(null);

		JLabel lblBuscarContinentePor_2 = new JLabel("Buscar Continente Por Nombre");
		lblBuscarContinentePor_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarContinentePor_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBuscarContinentePor_2.setBounds(0, 98, 474, 31);
		panelBuscarContNombre.add(lblBuscarContinentePor_2);

		JLabel lblIngreseElNombre = new JLabel("Ingrese el Nombre del Continente:");
		lblIngreseElNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIngreseElNombre.setBounds(8, 172, 205, 14);
		panelBuscarContNombre.add(lblIngreseElNombre);

		textBContNom = new JTextField();
		textBContNom.setHorizontalAlignment(SwingConstants.CENTER);
		textBContNom.setColumns(10);
		textBContNom.setBounds(213, 169, 251, 20);
		panelBuscarContNombre.add(textBContNom);

		cancelarBContNom = new JTextField();
		cancelarBContNom.setText("Cancelar");
		cancelarBContNom.setHorizontalAlignment(SwingConstants.CENTER);
		cancelarBContNom.setEditable(false);
		cancelarBContNom.setColumns(10);
		cancelarBContNom.setBounds(287, 469, 86, 20);
		panelBuscarContNombre.add(cancelarBContNom);

		aceptarBContNom = new JTextField();
		aceptarBContNom.setText("Aceptar");
		aceptarBContNom.setHorizontalAlignment(SwingConstants.CENTER);
		aceptarBContNom.setEditable(false);
		aceptarBContNom.setColumns(10);
		aceptarBContNom.setBounds(378, 469, 86, 20);
		panelBuscarContNombre.add(aceptarBContNom);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 203, 474, 255);
		panelBuscarContNombre.add(scrollPane);

		listBContNom = new JList(model);
		scrollPane.setViewportView(listBContNom);

		JPanel panelBuscarContPorID = new JPanel();
		panelBuscarContPorID.setBackground(new Color(255, 255, 255));
		panelBuscarContPorID.setBounds(0, 0, 474, 500);
		layeredPane.add(panelBuscarContPorID);
		panelBuscarContPorID.setLayout(null);

		JLabel lblBuscarContinentePor = new JLabel("Buscar Continente Por ID");
		lblBuscarContinentePor.setBounds(0, 98, 474, 31);
		lblBuscarContinentePor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBuscarContinentePor.setHorizontalAlignment(SwingConstants.CENTER);
		panelBuscarContPorID.add(lblBuscarContinentePor);

		JLabel lblIngreseElId = new JLabel("Ingrese el ID del Continente deseado:");
		lblIngreseElId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIngreseElId.setBounds(10, 172, 193, 14);
		panelBuscarContPorID.add(lblIngreseElId);

		textBContID = new JTextField();
		textBContID.setHorizontalAlignment(SwingConstants.CENTER);
		textBContID.setBounds(213, 169, 251, 20);
		panelBuscarContPorID.add(textBContID);
		textBContID.setColumns(10);

		textField_23 = new JTextField();
		textField_23.setText("Cancelar");
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setEditable(false);
		textField_23.setColumns(10);
		textField_23.setBounds(285, 469, 86, 20);
		panelBuscarContPorID.add(textField_23);

		textField_24 = new JTextField();
		textField_24.setText("Aceptar");
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setEditable(false);
		textField_24.setColumns(10);
		textField_24.setBounds(378, 469, 86, 20);
		panelBuscarContPorID.add(textField_24);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 475, 500);
		layeredPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Continentes Todos");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 44, 475, 23);
		panel.add(lblNewLabel_4);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1, 131, 474, 255);
		panel.add(scrollPane_1);

		JList listFind = new JList(model);
		scrollPane_1.setViewportView(listFind);

		JPanel panelAgregarCont = new JPanel();
		panelAgregarCont.setBackground(new Color(173, 216, 230));
		panelAgregarCont.setBounds(15, 21, 208, 80);
		panelCont.add(panelAgregarCont);
		panelAgregarCont.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(6, 6, 70, 70);
		panelAgregarCont.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBackground(new Color(218, 112, 214));
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\69301_opt.png"));

		JLabel lblNewLabel_1 = new JLabel("Continente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(96, 40, 110, 25);
		panelAgregarCont.add(lblNewLabel_1);

		JLabel lblAgregar = new JLabel("Agregar");
		lblAgregar.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblAgregar.setBounds(86, 15, 70, 22);
		panelAgregarCont.add(lblAgregar);

		JPanel panelBuscarCont = new JPanel();
		panelBuscarCont.setLayout(null);
		panelBuscarCont.setBackground(new Color(210, 180, 140));
		panelBuscarCont.setBounds(17, 112, 208, 80);
		panelCont.add(panelBuscarCont);

		JLabel label_5 = new JLabel("Continente");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		label_5.setBounds(96, 44, 110, 25);
		panelBuscarCont.add(label_5);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblBuscar.setBounds(86, 17, 81, 22);
		panelBuscarCont.add(lblBuscar);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(
				"C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\51-514569_dibujo-lupa-png-desenho-lupa-para-colorir_opt.png"));
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		label_7.setBackground(new Color(218, 112, 214));
		label_7.setBounds(6, 2, 70, 74);
		panelBuscarCont.add(label_7);

		JPanel panelVolverCont = new JPanel();
		panelVolverCont.setLayout(null);
		panelVolverCont.setBackground(new Color(233, 150, 122));
		panelVolverCont.setBounds(15, 387, 208, 80);
		panelCont.add(panelVolverCont);

		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblInicio.setBounds(96, 44, 110, 25);
		panelVolverCont.add(lblInicio);

		JLabel lblVolverA = new JLabel("Volver a");
		lblVolverA.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblVolverA.setBounds(86, 17, 81, 22);
		panelVolverCont.add(lblVolverA);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\flecha-volver-png_opt.png"));
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		label_9.setBackground(new Color(218, 112, 214));
		label_9.setBounds(6, 2, 70, 74);
		panelVolverCont.add(label_9);

		listBContNom.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					try {
						daoContinente = new ContinenteDAO();
						c = new Continente();
						c = daoContinente.buscarContinentePorNombre(listBContNom.getSelectedValue().toString()).get(0);
						ContinenteForm contForm = new ContinenteForm(c);
						contForm.setVisible(true);
						listBContNom.setVisible(false);
						model.removeAllElements();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		cancelarBContNom.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarContNombre.setVisible(false);
				panelBuscarContD.setVisible(true);
			}
		});

		aceptarBContCod.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					c = new Continente();
					daoContinente = new ContinenteDAO();
					c = daoContinente.buscarContinentePorCodigo(textBContCod.getText());
					if (c != null) {
						ContinenteForm contForm = new ContinenteForm(c);
						textBContCod.setText(null);
						contForm.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		cancelarBContCod.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarContPorCodigo.setVisible(false);
				panelBuscarContD.setVisible(true);
			}
		});

		textField_24.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					c = new Continente();
					daoContinente = new ContinenteDAO();
					c = daoContinente.buscarContinentePorId(Long.valueOf(textBContID.getText()));
					if (c != null) {
						ContinenteForm contForm = new ContinenteForm(c);
						contForm.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "El id ingresado es incorrecto");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		opcBuscarCodigo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarContD.setVisible(false);
				panelBuscarContPorCodigo.setVisible(true);
			}
		});

		opcBuscarID.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarContPorID.setVisible(true);
				panelBuscarContD.setVisible(false);
			}
		});

		opcBuscarNombre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarContD.setVisible(false);
				panelBuscarContNombre.setVisible(true);
				listBContNom.setVisible(false);
				scrollPane.setVisible(false);
			}
		});

		opcBuscarTodos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				try {
					panelBuscarContD.setVisible(false);
					panel.setVisible(true);

					for (int i = 0; i < daoContinente.contarFilas(); i++) {
						model.addElement(daoContinente.find().get(i).getShortName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		listFind.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					try {
						panel.setVisible(false);
						daoContinente = new ContinenteDAO();
						c = new Continente();
						for (int i = 0; i <= daoContinente.contarFilas(); i++) {
							if (i <= 0)
								c = daoContinente.buscarContinentePorNombre(listFind.getSelectedValue().toString())
										.get(i);
						}
						ContinenteForm contForm = new ContinenteForm(c);
						contForm.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		label.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});

		aceptarBContNom.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				try {

					int a = daoContinente.buscarContinentePorNombre(textBContNom.getText()).size();
					if (a > 1) {
						listBContNom.setVisible(true);
						scrollPane.setVisible(true);
						for (int i = 0; i < a; i++) {
							model.addElement(daoContinente.buscarContinentePorNombre(textBContNom.getText()).get(i)
									.getShortName());
						}
					} else {

						c = new Continente();
						daoContinente = new ContinenteDAO();
						c = daoContinente.buscarContinentePorNombre(textBContNom.getText()).get(0);
						ContinenteForm cF = new ContinenteForm(c);
						cF.setVisible(true);
					}

					textBContNom.setText(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		panelAgregarCont.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				agregarCont.setVisible(true);
			}
		});

		panelBuscarCont.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				panelBuscarContD.setVisible(true);
				panelCont.setVisible(true);
				panelBuscarContPorID.setVisible(false);
				panelBuscarContNombre.setVisible(false);
				panelBuscarContPorCodigo.setVisible(false);
			}
		});

		textField_23.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarContPorID.setVisible(false);
				panelBuscarContD.setVisible(true);
			}
		});

		JPanel panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 709, 500);
		panelDerecha.add(panelInicio);
		panelInicio.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("X");

		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(697, 0, 12, 14);
		panelInicio.add(lblNewLabel_2);

		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 709, 500);
		panelInicio.add(fondo);
		fondo.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\16F_opt_opt.jpg"));

		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});

		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarContD.setVisible(false);
				panelPais.setVisible(false);
				panelCont.setVisible(true);
				panelBuscarContPorID.setVisible(false);
				panelBuscarContNombre.setVisible(false);
				panelBuscarContPorCodigo.setVisible(false);
				panel.setVisible(false);
			}
		});

		lblPaises.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelPais.setVisible(true);
				panelCont.setVisible(false);
				panelBuscarContD.setVisible(false);
				panelDerechaPais.setVisible(false);
			}
		});

		panelVolverCont.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelBuscarContD.setVisible(false);
				panelCont.setVisible(false);
				panelBuscarContPorID.setVisible(false);
				panelBuscarContNombre.setVisible(false);
				panelBuscarContPorCodigo.setVisible(false);
				panelInicio.setVisible(true);

			}
		});

		panelVolverIni.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panelInicio.setVisible(true);
				panelPais.setVisible(false);
			}
		});

		panelBuscarPais.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				panelDerechaPais.setVisible(true);
				panel_1.setVisible(false);

			}
		});

		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.removeAllElements();
				panelDerechaPais.setVisible(true);
				panel_1.setVisible(false);

			}
		});

		textField_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (rdbtnBuscarPorNombre.isSelected()) {
					try {
						daoPais = new PaisDAO();
						int a = daoPais.buscarPaisPorNombre(textNomBP.getText()).size();
						if (a > 1) {
							panel_1.setVisible(true);
							panelDerechaPais.setVisible(false);
							model.removeAllElements();
							for (int i = 0; i < a; i++) {
								model.addElement(daoPais.buscarPaisPorNombre(textNomBP.getText()).get(i).getName());
							}
						} else {
							p = new Pais();
							p = daoPais.buscarPaisPorNombre(textNomBP.getText()).get(0);
							pF = new PaisForm(p);
							pF.setVisible(true);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "El pais no se encontro");
					}
				}
				if (rdbtnBuscarPorId.isSelected()) {
					p = new Pais();
					daoPais = new PaisDAO();
					try {
						p = daoPais.buscarPaisPorId(Long.valueOf(textIdBP.getText()));
						pF = new PaisForm(p);
						pF.setVisible(true);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Debe ingresar un id");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "El pais no se encontro");
					}
				}
				if (rdbtnBuscarPorIso3.isSelected()) {
					p = new Pais();
					daoPais = new PaisDAO();
					try {
						p = daoPais.buscarPaisPorIso3(textIso3BP.getText());
						pF = new PaisForm(p);
						pF.setVisible(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "El pais no se encontro");
					}
				}
				if (rdbtnBuscarPorIsoNum.isSelected()) {
					p = new Pais();
					daoPais = new PaisDAO();
					try {
						p = daoPais.buscarPaisPorIsoNum(textIsoNumBP.getText());
						pF = new PaisForm(p);
						pF.setVisible(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "El pais no se encontro");
					}
				}
				if (rdbtnIso2.isSelected()) {
					p = new Pais();
					daoPais = new PaisDAO();
					try {
						p = daoPais.buscarPaisPorIso(textIso2BP.getText());
						pF = new PaisForm(p);
						pF.setVisible(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "El pais no se encontro");
					}
				}

				if (rdbtnBuscarPorCont.isSelected()) {
					p = new Pais();
					daoPais = new PaisDAO();
					daoContinente = new ContinenteDAO();

					try {
						panel_1.setVisible(true);
						panelDerechaPais.setVisible(false);
						Long id = daoContinente.buscarContinentePorNombre(textContBP.getText()).get(0).getId();
						List<Pais> paises = new ArrayList<Pais>();
						paises = daoPais.buscarPaisPorContinente(id);
						model.removeAllElements();
						for (int i = 0; i < paises.size(); i++) {
							model.addElement(paises.get(i).getName());
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "El continente no se encontro");
					}
				}
			}
		});

		panelBTodosPais.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					panel_1.setVisible(true);
					model.removeAllElements();
					for (int i = 0; i < daoPais.contarFilasPais(); i++) {
						model.addElement(daoPais.find().get(i).getName());
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}