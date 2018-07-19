import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class ERP_System_GUI extends JFrame{
	protected JPanel contentPane;
	protected JTable table;
	protected JButton product_add;
	protected JButton stored;
	protected JButton released;
	protected JButton sandr;
	protected JButton stock;
	protected JScrollPane scroll;
	protected DefaultTableModel model;
	protected JButton depot_btn;
	//protected ERP_DAO dao;
	
	protected SandR sr;
	protected Insert_Product ip;
	
	public ERP_System_GUI() {
					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 1450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//dao = new ERP_DAO();
		//ip = new Insert_Product(dao);
		//sr = new SandR(dao);
		
		
		table = new JTable(model);
		scroll = new JScrollPane(table);
		scroll.setBounds(22, 21, 1400, 520);
		table.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 20));
		
		product_add = new JButton("Product_add");
		product_add.setBounds(22, 578, 180, 50);
		contentPane.add(product_add);
		//product_add.addActionListener(this);
		
		stored = new JButton("S&R");
		stored.setBounds(330, 578, 180, 50);
		contentPane.add(stored);
		//stored.addActionListener(this);
		
		sandr = new JButton("Check_S&R");
		sandr.setBounds(641, 578, 180, 50);
		contentPane.add(sandr);
		//sandr.addActionListener(new ERP_Check());
				
		stock = new JButton("Check_stock");
		stock.setBounds(956, 578, 180, 50);
		contentPane.add(stock);
		
		depot_btn = new JButton("Check_Depot");
		depot_btn.setBounds(1242, 578, 180, 50);
		contentPane.add(depot_btn);
		//stock.addActionListener(new STOCK_Check());
				
		setVisible(true);
	}
}
