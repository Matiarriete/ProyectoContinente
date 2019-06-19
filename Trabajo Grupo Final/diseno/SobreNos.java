import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SobreNos extends JFrame {

	private JPanel contentPane;

	public SobreNos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();				
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setBounds(886, 0, 14, 25);
		contentPane.add(lblX);
		
		JLabel lblQuienesSomos = new JLabel("Sobre Nosotros");
		lblQuienesSomos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuienesSomos.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuienesSomos.setBounds(65, 9, 778, 30);
		contentPane.add(lblQuienesSomos);
		
		JLabel lblMailGeonamesgmailcom = new JLabel("Mail : geonames@gmail.com");
		lblMailGeonamesgmailcom.setHorizontalAlignment(SwingConstants.CENTER);
		lblMailGeonamesgmailcom.setBounds(670, 465, 220, 14);
		contentPane.add(lblMailGeonamesgmailcom);
		
		JLabel lblContactanos = new JLabel("Contactanos");
		lblContactanos.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactanos.setBounds(670, 436, 220, 14);
		contentPane.add(lblContactanos);
		
		JLabel lblTelefono = new JLabel("Telefono: 3512345678 ");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setBounds(670, 450, 220, 14);
		contentPane.add(lblTelefono);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(267, 184, 366, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("asi como ver sus continentes y agregar nuevos Continentes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 60, 366, 14);
		panel.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("encarga de ver, modificar, agregar y borrar paises");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 47, 366, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Ingenieria Web realizamos este programa el cual se");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 35, 366, 14);
		panel.add(label_2);
		
		JLabel lblLosCualesComo = new JLabel("los cuales como trabajo para 2\u00B0 parcial de la materia");
		lblLosCualesComo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLosCualesComo.setBounds(0, 21, 366, 14);
		panel.add(lblLosCualesComo);
		
		JLabel lblNewLabel = new JLabel("Somos alumnos de Ingenieria en Informatica");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 7, 366, 14);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setEnabled(false);
		label.setIcon(new ImageIcon("C:\\Users\\matia\\Desktop\\Imagenes Trabajo\\map-of-the-world-2401458_960_720.jpg"));
		label.setBounds(0, 0, 900, 500);
		contentPane.add(label);
		
		setUndecorated(true);
	}
}
