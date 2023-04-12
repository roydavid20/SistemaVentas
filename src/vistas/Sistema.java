package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Proveedor;
import modelo.ProveedorDAO;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sistema extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodventa;
	private JTextField txtdescventa;
	private JTextField txtcanventa;
	private JTextField txtprecventa;
	private JTextField txtstockventa;
	private JTable tableventa;
	private JTextField txtdniventa;
	private JTextField txtnomventa;
	private JTextField txtdnicliente;
	private JTextField txtnomcliente;
	private JTextField txttelefonocliente;
	private JTextField txtdireccioncliente;
	private JTextField txtrazoncliente;
	private JTable tablecliente;
	private JTextField txtrucprove;
	private JTextField txtnomprov;
	private JTextField txttelefonoprov;
	private JTextField txtdireccionprov;
	private JTextField txtrazonprov;
	private JTable tableprov;
	private JTextField txtcodprod;
	private JTextField txtdescprod;
	private JTextField txtcantprod;
	private JTextField txtprecioprod;
	private JTable tableprod;
	private JTable table_4;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField txttelefonoCV;
	private JTextField txtdireccionCV;
	private JTextField txtrazonCV;
	private JTextField txtIDcliente;
	private JTextField txtIDproveedor;
	private JTextField txtIDprod;
	private JTextField txtIDventa;
	private JTextField txtIDprodu;
	DefaultTableModel modelo;
	JTabbedPane jTabbedPane = new JTabbedPane();


	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	ProveedorDAO prDAO = new ProveedorDAO();
	Proveedor pr = new Proveedor();
	Cliente cl = new Cliente();
	ClienteDAO client = new ClienteDAO();
	private JButton btnClientes;
	private JButton btnProveedor;
	
	
	
	private void limpiarcliente(){
		txtIDcliente.setText("");
		txtdnicliente.setText("");
		txtnomcliente.setText("");
		txttelefonocliente.setText("");
		txtdireccioncliente.setText("");
		txtrazoncliente.setText("");
	}
	private void limpiarproveedores(){
		txtIDproveedor.setText("");
		txtrucprove.setText("");
		txtnomprov.setText("");
		txttelefonoprov.setText("");
		txtdireccionprov.setText("");
		txtrazonprov.setText("");
	}
	public void LimpiarTabla(JTable tabla){
	    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
	    while(modelo.getRowCount() > 0){
	        modelo.removeRow(0);
	    }
	}

	public void ListarClientes(){
		List<Cliente> ListCl = client.ListarCliente();
		modelo = (DefaultTableModel) tablecliente.getModel();
		Object[] ob = new Object[6];
		for (int i = 0; i < ListCl.size(); i++) {
			ob[0] = ListCl.get(i).getId();
			ob[1] = ListCl.get(i).getDni();
			ob[2] = ListCl.get(i).getNombre();
			ob[3] = ListCl.get(i).getTelefono();
			ob[4] = ListCl.get(i).getDireccion();
			ob[5] = ListCl.get(i).getRazon();
			modelo.addRow(ob);
		}
		tablecliente.setModel(modelo);
		
		
	}
	public void ListarProveedores(){
		List<Proveedor> Listpr = prDAO.ListarProveedor();
		modelo = (DefaultTableModel) tableprov.getModel();
		Object[] ob = new Object[6];
		for (int i = 0; i < Listpr.size(); i++) {
			ob[0] = Listpr.get(i).getId();
			ob[1] = Listpr.get(i).getRuc();
			ob[2] = Listpr.get(i).getNombre();
			ob[3] = Listpr.get(i).getTelefono();
			ob[4] = Listpr.get(i).getDireccion();
			ob[5] = Listpr.get(i).getRazon();
			modelo.addRow(ob);
		}
		tableprov.setModel(modelo);
		
		
	}
	public Sistema() {
		
		
		this.setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1141, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 301, 699);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNuevaVenta = new JButton("Nueva Venta");
		btnNuevaVenta.setIcon(new ImageIcon(Sistema.class.getResource("/img/Nventa.png")));
		btnNuevaVenta.setBounds(0, 213, 301, 38);
		panel.add(btnNuevaVenta);
		
		btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarTabla(tablecliente);
				ListarClientes();
				jTabbedPane.setSelectedIndex(1);

				
				
				
			}
		});
		btnClientes.setIcon(new ImageIcon(Sistema.class.getResource("/img/Clientes.png")));
		btnClientes.setBounds(0, 284, 301, 38);
		panel.add(btnClientes);
		
		btnProveedor = new JButton("Proveedor");
		btnProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarTabla(tablecliente);
				ListarProveedores();
				jTabbedPane.setSelectedIndex(2);
			}
		});
		btnProveedor.setIcon(new ImageIcon(Sistema.class.getResource("/img/proveedor.png")));
		btnProveedor.setBounds(0, 356, 301, 38);
		panel.add(btnProveedor);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setIcon(new ImageIcon(Sistema.class.getResource("/img/producto.png")));
		btnProductos.setBounds(0, 444, 301, 38);
		panel.add(btnProductos);
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.setIcon(new ImageIcon(Sistema.class.getResource("/img/Carrito-de-compras.png")));
		btnVentas.setBounds(0, 519, 301, 38);
		panel.add(btnVentas);
		
		JButton btnConfig = new JButton("Config");
		btnConfig.setIcon(new ImageIcon(Sistema.class.getResource("/img/config.png")));
		btnConfig.setBounds(0, 590, 301, 38);
		panel.add(btnConfig);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setIcon(new ImageIcon(Sistema.class.getResource("/img/encabezado.png")));
		label.setBounds(301, 0, 797, 164);
		contentPane.add(label);
		
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		jTabbedPane.setBounds(301, 177, 810, 522);
		contentPane.add(jTabbedPane);
		
		JPanel panel_1 = new JPanel();
		jTabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 34, 56, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescripcion.setBounds(129, 34, 77, 16);
		panel_1.add(lblDescripcion);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidad.setBounds(298, 34, 71, 16);
		panel_1.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(418, 34, 56, 16);
		panel_1.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock Disponible");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStock.setBounds(539, 34, 116, 16);
		panel_1.add(lblStock);
		
		txtcodventa = new JTextField();
		txtcodventa.setBounds(12, 63, 83, 22);
		panel_1.add(txtcodventa);
		txtcodventa.setColumns(10);
		
		txtdescventa = new JTextField();
		txtdescventa.setColumns(10);
		txtdescventa.setBounds(129, 63, 157, 22);
		panel_1.add(txtdescventa);
		
		txtcanventa = new JTextField();
		txtcanventa.setColumns(10);
		txtcanventa.setBounds(298, 63, 94, 22);
		panel_1.add(txtcanventa);
		
		txtprecventa = new JTextField();
		txtprecventa.setColumns(10);
		txtprecventa.setBounds(419, 63, 94, 22);
		panel_1.add(txtprecventa);
		
		txtstockventa = new JTextField();
		txtstockventa.setColumns(10);
		txtstockventa.setBounds(539, 63, 92, 22);
		panel_1.add(txtstockventa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 781, 271);
		panel_1.add(scrollPane);
		
		tableventa = new JTable();
		tableventa.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion", "Cantidad", "Precio", "Total"
			}
		));
		tableventa.getColumnModel().getColumn(1).setPreferredWidth(200);
		scrollPane.setViewportView(tableventa);
		
		JButton btneliminarventa = new JButton("");
		btneliminarventa.setIcon(new ImageIcon(Sistema.class.getResource("/img/eliminar.png")));
		btneliminarventa.setBounds(681, 62, 97, 25);
		panel_1.add(btneliminarventa);
		
		JLabel lblNewLabel_1 = new JLabel("DNI/RUC");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 419, 56, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(198, 419, 56, 16);
		panel_1.add(lblNombre);
		
		txtdniventa = new JTextField();
		txtdniventa.setBounds(12, 448, 116, 22);
		panel_1.add(txtdniventa);
		txtdniventa.setColumns(10);
		
		txtnomventa = new JTextField();
		txtnomventa.setEditable(false);
		txtnomventa.setColumns(10);
		txtnomventa.setBounds(198, 448, 116, 22);
		panel_1.add(txtnomventa);
		
		JButton btngenerarventa = new JButton("");
		btngenerarventa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btngenerarventa.setIcon(new ImageIcon(Sistema.class.getResource("/img/print.png")));
		btngenerarventa.setBounds(416, 435, 97, 35);
		panel_1.add(btngenerarventa);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar");
		lblTotalAPagar.setIcon(new ImageIcon(Sistema.class.getResource("/img/money.png")));
		lblTotalAPagar.setBounds(539, 435, 116, 35);
		panel_1.add(lblTotalAPagar);
		
		JLabel lbltotalventa = new JLabel(".................");
		lbltotalventa.setBounds(696, 435, 71, 32);
		panel_1.add(lbltotalventa);
		
		txttelefonoCV = new JTextField();
		txttelefonoCV.setBounds(331, 448, 15, 22);
		panel_1.add(txttelefonoCV);
		txttelefonoCV.setColumns(10);
		
		txtdireccionCV = new JTextField();
		txtdireccionCV.setColumns(10);
		txtdireccionCV.setBounds(358, 448, 15, 22);
		panel_1.add(txtdireccionCV);
		
		txtrazonCV = new JTextField();
		txtrazonCV.setColumns(10);
		txtrazonCV.setBounds(385, 448, 15, 22);
		panel_1.add(txtrazonCV);
		
		txtIDprodu = new JTextField();
		txtIDprodu.setBounds(643, 63, 27, 22);
		panel_1.add(txtIDprodu);
		txtIDprodu.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		jTabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("DNI/RUC");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(27, 62, 56, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(27, 133, 56, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(27, 200, 56, 16);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5.setBounds(27, 266, 71, 16);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Razon social");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_6.setBounds(27, 336, 89, 16);
		panel_2.add(lblNewLabel_6);
		
		txtdnicliente = new JTextField();
		txtdnicliente.setBounds(94, 59, 137, 22);
		panel_2.add(txtdnicliente);
		txtdnicliente.setColumns(10);
		
		txtnomcliente = new JTextField();
		txtnomcliente.setColumns(10);
		txtnomcliente.setBounds(94, 130, 137, 22);
		panel_2.add(txtnomcliente);
		
		txttelefonocliente = new JTextField();
		txttelefonocliente.setColumns(10);
		txttelefonocliente.setBounds(95, 197, 116, 22);
		panel_2.add(txttelefonocliente);
		
		txtdireccioncliente = new JTextField();
		txtdireccioncliente.setColumns(10);
		txtdireccioncliente.setBounds(94, 263, 137, 22);
		panel_2.add(txtdireccioncliente);
		
		txtrazoncliente = new JTextField();
		txtrazoncliente.setColumns(10);
		txtrazoncliente.setBounds(115, 333, 116, 22);
		panel_2.add(txtrazoncliente);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(243, 62, 533, 417);
		panel_2.add(scrollPane_1);
		
		tablecliente = new JTable();
		tablecliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int fila = tablecliente.rowAtPoint(arg0.getPoint());
				txtIDcliente.setText(tablecliente.getValueAt(fila, 0).toString());
				txtdnicliente.setText(tablecliente.getValueAt(fila, 1).toString());
				txtnomcliente.setText(tablecliente.getValueAt(fila, 2).toString());
				txttelefonocliente.setText(tablecliente.getValueAt(fila, 3).toString());
				txtdireccioncliente.setText(tablecliente.getValueAt(fila, 4).toString());
				
			}
		});
		tablecliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI/RUC", "Nombre", "Telefono", "Direccion", "Razon social"
			}
		));
		tablecliente.getColumnModel().getColumn(1).setPreferredWidth(180);
		tablecliente.getColumnModel().getColumn(3).setPreferredWidth(179);
		tablecliente.getColumnModel().getColumn(4).setPreferredWidth(96);
		scrollPane_1.setViewportView(tablecliente);
		
		JButton btnguardarcliente = new JButton("");
		btnguardarcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!"".equals(txtdnicliente.getText()) || !"".equals(txtnomcliente.getText()) || !"".equals(txttelefonocliente.getText()) || !"".equals(txtdireccioncliente.getText())){
					cl.setDni(Integer.parseInt(txtdnicliente.getText()));
					cl.setNombre(txtnomcliente.getText());
					cl.setTelefono(Integer.parseInt(txttelefonocliente.getText()));
					cl.setDireccion(txtdireccioncliente.getText());
					cl.setRazon(txtrazoncliente.getText());
					client.RegistrarCliente(cl);
					LimpiarTabla(tablecliente);
					limpiarcliente();
					ListarClientes();
					JOptionPane.showMessageDialog(null, "Cliente Registrado");
				}else{
					JOptionPane.showMessageDialog(null, "Los campos estan vacios");
				}
					
			
				
			}
		});
		btnguardarcliente.setIcon(new ImageIcon(Sistema.class.getResource("/img/GuardarTodo.png")));
		btnguardarcliente.setBounds(12, 375, 97, 39);
		panel_2.add(btnguardarcliente);
		
		JButton btnactualizarcliente = new JButton("");
		btnactualizarcliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        
		        if("".equals(txtIDcliente.getText())){
		            JOptionPane.showMessageDialog(null, "Seleccione una fila");
		        } else {
		            
		            
		            if(!"".equals(txtdnicliente.getText()) || !"".equals(txtnomcliente.getText()) || !"".equals(txttelefonocliente.getText())){
		            	cl.setDni(Integer.parseInt(txtdnicliente.getText()));
			            cl.setTelefono(Integer.parseInt(txttelefonocliente.getText()));
			            cl.setDireccion(txtdireccioncliente.getText());
			            cl.setRazon(txtrazoncliente.getText());
			            cl.setNombre(txtnomcliente.getText());
			            cl.setId(Integer.parseInt(txtIDcliente.getText()));
		                client.ModificarCliente(cl);
		                LimpiarTabla(tablecliente);
		                limpiarcliente();
		                ListarClientes();
		            }else{
		            	JOptionPane.showMessageDialog(null, "Los campos estan vacios");
		            }
		        }
		        
		    }
		});

		btnactualizarcliente.setIcon(new ImageIcon(Sistema.class.getResource("/img/Actualizar (2).png")));
		btnactualizarcliente.setBounds(134, 375, 97, 39);
		panel_2.add(btnactualizarcliente);
		
		JButton btnnuevocliente = new JButton("");
		btnnuevocliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarTabla(tablecliente);
			}
		});
		btnnuevocliente.setIcon(new ImageIcon(Sistema.class.getResource("/img/nuevo.png")));
		btnnuevocliente.setBounds(12, 427, 97, 40);
		panel_2.add(btnnuevocliente);
		
		JButton btneliminarcliente = new JButton("");
		btneliminarcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!"".equals(txtIDcliente.getText())){
					int  pregunta = JOptionPane.showConfirmDialog(null,"Estas seguro de eliminar?");
					if(pregunta == 0){
						int id = Integer.parseInt(txtIDcliente.getText());
						client.EliminarCliente(id);
						LimpiarTabla(tablecliente);
						limpiarcliente();
						ListarClientes();
					}
				}
			}
		});
		btneliminarcliente.setIcon(new ImageIcon(Sistema.class.getResource("/img/eliminar.png")));
		btneliminarcliente.setBounds(134, 427, 97, 40);
		panel_2.add(btneliminarcliente);
		
		txtIDcliente = new JTextField();
		txtIDcliente.setVisible(false);
		txtIDcliente.setBounds(243, 27, 17, 22);
		panel_2.add(txtIDcliente);
		txtIDcliente.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		jTabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblRuc = new JLabel("RUC");
		lblRuc.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRuc.setBounds(25, 59, 90, 16);
		panel_3.add(lblRuc);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombre_1.setBounds(25, 125, 90, 16);
		panel_3.add(lblNombre_1);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelefono.setBounds(25, 185, 90, 16);
		panel_3.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDireccion.setBounds(25, 247, 90, 16);
		panel_3.add(lblDireccion);
		
		JLabel lblRazonSocial = new JLabel("Razon social");
		lblRazonSocial.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRazonSocial.setBounds(25, 312, 90, 16);
		panel_3.add(lblRazonSocial);
		
		txtrucprove = new JTextField();
		txtrucprove.setBounds(71, 56, 106, 22);
		panel_3.add(txtrucprove);
		txtrucprove.setColumns(10);
		
		txtnomprov = new JTextField();
		txtnomprov.setColumns(10);
		txtnomprov.setBounds(86, 122, 147, 22);
		panel_3.add(txtnomprov);
		
		txttelefonoprov = new JTextField();
		txttelefonoprov.setColumns(10);
		txttelefonoprov.setBounds(86, 182, 140, 22);
		panel_3.add(txttelefonoprov);
		
		txtdireccionprov = new JTextField();
		txtdireccionprov.setColumns(10);
		txtdireccionprov.setBounds(96, 244, 137, 22);
		panel_3.add(txtdireccionprov);
		
		txtrazonprov = new JTextField();
		txtrazonprov.setColumns(10);
		txtrazonprov.setBounds(117, 309, 116, 22);
		panel_3.add(txtrazonprov);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(264, 59, 529, 420);
		panel_3.add(scrollPane_2);
		
		tableprov = new JTable();
		tableprov.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int fila = tableprov.rowAtPoint(arg0.getPoint());
				txtIDproveedor.setText(tableprov.getValueAt(fila, 0).toString());
				txtrucprove.setText(tableprov.getValueAt(fila, 1).toString());
				txtnomprov.setText(tableprov.getValueAt(fila, 2).toString());
				txttelefonoprov.setText(tableprov.getValueAt(fila, 3).toString());
				txtdireccionprov.setText(tableprov.getValueAt(fila, 4).toString());
				txtrazonprov.setText(tableprov.getValueAt(fila, 5).toString());
				
			}
		});
		tableprov.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "RUC", "Nombre", "Telefono", "Direccion", "Razon social"
			}
		));
		tableprov.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableprov.getColumnModel().getColumn(2).setPreferredWidth(180);
		tableprov.getColumnModel().getColumn(4).setPreferredWidth(180);
		tableprov.getColumnModel().getColumn(5).setPreferredWidth(101);
		scrollPane_2.setViewportView(tableprov);
		
		JButton btnguardarprov = new JButton("");
		btnguardarprov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!"".equals(txtrucprove.getText()) || !"".equals(txtnomprov.getText()) || !"".equals(txttelefonoprov.getText())|| !"".equals(txtdireccionprov.getText()) || !"".equals(txtrazonprov.getText())){
					pr.setRuc(Integer.parseInt(txtrucprove.getText()));
					pr.setNombre(txtnomprov.getText());
					pr.setTelefono(Integer.parseInt(txttelefonoprov.getText()));
					pr.setDireccion(txtdireccionprov.getText());
					pr.setRazon(txtrazonprov.getText());
					prDAO.RegistrarProveedor(pr);
					LimpiarTabla(tableprov);
					ListarProveedores();
					limpiarproveedores();
					
				}else{
					JOptionPane.showMessageDialog(null, "los campos estan vacios");
				}
			}
		});
		btnguardarprov.setIcon(new ImageIcon(Sistema.class.getResource("/img/GuardarTodo.png")));
		btnguardarprov.setBounds(12, 360, 103, 44);
		panel_3.add(btnguardarprov);
		
		JButton btnactualizarprov = new JButton("");
		btnactualizarprov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if("".equals(txtIDproveedor.getText())){
				    JOptionPane.showMessageDialog(null, "Seleccione una fila");
				}else{
				    if(!"".equals(txtrucprove.getText()) || !"".equals(txtnomprov.getText()) || !"".equals(txttelefonoprov.getText()) || !"".equals(txtdireccionprov.getText()) || !"".equals(txtrazonprov.getText())){
				        pr.setRuc(Integer.parseInt(txtrucprove.getText()));
				        pr.setNombre(txtnomprov.getText());
				        pr.setTelefono(Integer.parseInt(txttelefonoprov.getText()));
				        pr.setDireccion(txtdireccionprov.getText());
				        pr.setRazon(txtrazonprov.getText());
				        pr.setId(Integer.parseInt(txtIDproveedor.getText()));
				        prDAO.ModificarProveedor(pr);
				        LimpiarTabla(tableprov);
				        ListarProveedores();
				        limpiarproveedores();
				    }
				}
			}
		});
		btnactualizarprov.setIcon(new ImageIcon(Sistema.class.getResource("/img/Actualizar (2).png")));
		btnactualizarprov.setBounds(136, 360, 97, 44);
		panel_3.add(btnactualizarprov);
		
		JButton btnnuevoprov = new JButton("");
		btnnuevoprov.setIcon(new ImageIcon(Sistema.class.getResource("/img/nuevo.png")));
		btnnuevoprov.setBounds(12, 417, 103, 44);
		panel_3.add(btnnuevoprov);
		
		JButton btneliminarprov = new JButton("");
		btneliminarprov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(!"".equals(txtIDproveedor.getText())){
				    int pregunta = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar");
				    if(pregunta == 0){
				        int id = Integer.parseInt(txtIDproveedor.getText());
				        LimpiarTabla(tableprov);
				        prDAO.EliminarProveedor(id);
				        ListarProveedores();
				        limpiarproveedores();
				    }
				}
                  else{
					JOptionPane.showMessageDialog(null, "Seleccione una fila");
				}
			}
		});
		btneliminarprov.setIcon(new ImageIcon(Sistema.class.getResource("/img/eliminar.png")));
		btneliminarprov.setBounds(136, 417, 97, 44);
		panel_3.add(btneliminarprov);
		
		txtIDproveedor = new JTextField();
		txtIDproveedor.setBounds(264, 24, 32, 22);
		panel_3.add(txtIDproveedor);
		txtIDproveedor.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		jTabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Codigo");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_7.setBounds(30, 57, 56, 16);
		panel_4.add(lblNewLabel_7);
		
		JLabel lblDescripcion_1 = new JLabel("Descripcion");
		lblDescripcion_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDescripcion_1.setBounds(30, 122, 80, 16);
		panel_4.add(lblDescripcion_1);
		
		JLabel lblCantidad_1 = new JLabel("Cantidad");
		lblCantidad_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCantidad_1.setBounds(30, 183, 80, 16);
		panel_4.add(lblCantidad_1);
		
		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPrecio_1.setBounds(30, 241, 56, 16);
		panel_4.add(lblPrecio_1);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblProveedor.setBounds(30, 305, 80, 16);
		panel_4.add(lblProveedor);
		
		txtcodprod = new JTextField();
		txtcodprod.setBounds(87, 54, 89, 22);
		panel_4.add(txtcodprod);
		txtcodprod.setColumns(10);
		
		txtdescprod = new JTextField();
		txtdescprod.setColumns(10);
		txtdescprod.setBounds(122, 119, 138, 22);
		panel_4.add(txtdescprod);
		
		txtcantprod = new JTextField();
		txtcantprod.setColumns(10);
		txtcantprod.setBounds(106, 180, 103, 22);
		panel_4.add(txtcantprod);
		
		txtprecioprod = new JTextField();
		txtprecioprod.setColumns(10);
		txtprecioprod.setBounds(98, 238, 111, 22);
		panel_4.add(txtprecioprod);
		
		JComboBox cboproveprod = new JComboBox();
		cboproveprod.setBounds(110, 302, 112, 22);
		panel_4.add(cboproveprod);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(290, 57, 503, 411);
		panel_4.add(scrollPane_3);
		
		tableprod = new JTable();
		tableprod.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion", "Stock", "precio", "Proveedor"
			}
		));
		tableprod.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableprod.getColumnModel().getColumn(1).setPreferredWidth(180);
		tableprod.getColumnModel().getColumn(4).setPreferredWidth(140);
		scrollPane_3.setViewportView(tableprod);
		
		JButton btnguardarprod = new JButton("");
		btnguardarprod.setIcon(new ImageIcon(Sistema.class.getResource("/img/GuardarTodo.png")));
		btnguardarprod.setBounds(13, 353, 89, 39);
		panel_4.add(btnguardarprod);
		
		JButton btnactualizarprod = new JButton("");
		btnactualizarprod.setIcon(new ImageIcon(Sistema.class.getResource("/img/Actualizar (2).png")));
		btnactualizarprod.setBounds(106, 353, 89, 39);
		panel_4.add(btnactualizarprod);
		
		JButton btnnuevoprod = new JButton("");
		btnnuevoprod.setIcon(new ImageIcon(Sistema.class.getResource("/img/nuevo.png")));
		btnnuevoprod.setBounds(13, 406, 89, 39);
		panel_4.add(btnnuevoprod);
		
		JButton btneliminarprod = new JButton("");
		btneliminarprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btneliminarprod.setIcon(new ImageIcon(Sistema.class.getResource("/img/eliminar.png")));
		btneliminarprod.setBounds(106, 406, 89, 39);
		panel_4.add(btneliminarprod);
		
		JButton btnexcelprod = new JButton("");
		btnexcelprod.setIcon(new ImageIcon(Sistema.class.getResource("/img/excel.png")));
		btnexcelprod.setBounds(202, 380, 80, 45);
		panel_4.add(btnexcelprod);
		
		txtIDprod = new JTextField();
		txtIDprod.setBounds(290, 22, 48, 22);
		panel_4.add(txtIDprod);
		txtIDprod.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		jTabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(12, 126, 793, 353);
		panel_5.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Cliente", "Vendedor", "Total"
			}
		));
		scrollPane_4.setViewportView(table_4);
		
		JButton button_13 = new JButton("");
		button_13.setIcon(new ImageIcon(Sistema.class.getResource("/img/pdf.png")));
		button_13.setBounds(12, 53, 121, 39);
		panel_5.add(button_13);
		
		txtIDventa = new JTextField();
		txtIDventa.setBounds(175, 67, 116, 22);
		panel_5.add(txtIDventa);
		txtIDventa.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		jTabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("RUC");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_8.setBounds(72, 143, 56, 16);
		panel_6.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nombre");
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_9.setBounds(288, 143, 56, 16);
		panel_6.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Telefono");
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_10.setBounds(574, 143, 56, 16);
		panel_6.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Direccion");
		lblNewLabel_11.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_11.setBounds(72, 262, 98, 16);
		panel_6.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Razon social");
		lblNewLabel_12.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_12.setBounds(305, 262, 98, 16);
		panel_6.add(lblNewLabel_12);
		
		textField_21 = new JTextField();
		textField_21.setBounds(70, 177, 170, 22);
		panel_6.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(288, 177, 201, 22);
		panel_6.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(574, 177, 161, 22);
		panel_6.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(70, 291, 170, 22);
		panel_6.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(292, 291, 152, 22);
		panel_6.add(textField_25);
		
		JLabel lblNewLabel_13 = new JLabel("DATOS DE LA EMPRESA");
		lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_13.setBounds(225, 60, 336, 37);
		panel_6.add(lblNewLabel_13);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setIcon(new ImageIcon(Sistema.class.getResource("/img/Actualizar (2).png")));
		btnActualizar.setBounds(305, 388, 152, 25);
		panel_6.add(btnActualizar);
	}
}
