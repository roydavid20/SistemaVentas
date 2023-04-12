package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.login;
import modelo.loginDAO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtcorreo;
	private JPasswordField txtcontraseña;

	
	
	login lg = new login();
	loginDAO login = new loginDAO();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void validar(){
		String correo = txtcorreo.getText();
		String contraseña = String.valueOf(txtcontraseña.getPassword());
		if (!"".equals(correo) || !"".equals(contraseña)){
			
			
			lg = login.log(correo, contraseña);
			if (lg.getCorreo()!= null && lg.getContraseña()!= null){
				Sistema sis = new Sistema();
				sis.setVisible(true);
				dispose();
			
			}else{
				JOptionPane.showMessageDialog(null, "Correo o Contraseña incorrecta");
			}
		}
	}
	public Login() {
		this.setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(330, 13, 316, 398);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setIcon(new ImageIcon(Login.class.getResource("/img/iniciar.png")));
		label_1.setBounds(113, 28, 121, 60);
		panel_1.add(label_1);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCorreoElectronico.setBounds(41, 120, 180, 16);
		panel_1.add(lblCorreoElectronico);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(43, 224, 121, 16);
		panel_1.add(lblContrasea);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(41, 160, 231, 22);
		panel_1.add(txtcorreo);
		txtcorreo.setColumns(10);
		
		txtcontraseña = new JPasswordField();
		txtcontraseña.setBounds(41, 273, 231, 22);
		panel_1.add(txtcontraseña);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			validar();
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIngresar.setBounds(113, 327, 97, 25);
		panel_1.add(btnIngresar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 0, 408, 424);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/img/49d24dfbf70ce815a39191d7cac53950.png")));
		label_2.setBounds(12, 25, 298, 150);
		panel.add(label_2);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setIcon(new ImageIcon(Login.class.getResource("/img/login.jpg")));
		label.setBounds(408, 0, 302, 424);
		contentPane.add(label);
	}
}
