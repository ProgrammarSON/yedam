import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Insert_Product_GUI extends JFrame {

	protected JPanel contentPane;
	protected JTextField pkey_txt;
	protected JTextField pname_txt;
	protected JTextField stock_txt;
	protected JTextField warehouse_txt;
	protected JLabel pkey_label;
	protected JLabel pname_label;
	protected JLabel stock_label;
	protected JLabel warehouse_label;
	protected JButton btn;
		
	
	public Insert_Product_GUI() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
			
		pkey_label = new JLabel("product_id");
		pkey_label.setBounds(12, 10, 87, 32);
		contentPane.add(pkey_label);
		
		pname_label = new JLabel("product_name");
		pname_label.setBounds(159, 10, 87, 32);
		contentPane.add(pname_label);
		
		stock_label = new JLabel("stock");
		stock_label.setBounds(300, 10, 87, 32);
		contentPane.add(stock_label);
		
		warehouse_label = new JLabel("warehouse");
		warehouse_label.setBounds(446, 10, 87, 32);
		contentPane.add(warehouse_label);
		
		pkey_txt = new JTextField();
		pkey_txt.setBounds(12, 52, 74, 21);
		contentPane.add(pkey_txt);
		pkey_txt.setColumns(10);
		
		pname_txt = new JTextField();
		pname_txt.setColumns(10);
		pname_txt.setBounds(159, 52, 74, 21);
		contentPane.add(pname_txt);
		
		stock_txt = new JTextField();
		stock_txt.setColumns(10);
		stock_txt.setBounds(300, 52, 74, 21);
		contentPane.add(stock_txt);
		
		warehouse_txt = new JTextField();
		warehouse_txt.setColumns(10);
		warehouse_txt.setBounds(446, 52, 74, 21);
		contentPane.add(warehouse_txt);
		
		btn = new JButton("INSERT");
		btn.setBounds(558, 21, 97, 53);
		contentPane.add(btn);
	}
	
}
