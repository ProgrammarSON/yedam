import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;

public class ERP_GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton product_add;
	private JButton stored;
	private JButton released;
	private JButton sandr;
	private JButton stock;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private String []column = {"index","pro_id","amount","date" };
	private ERP_DAO dao;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERP_GUI frame = new ERP_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ERP_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1700, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		table = new JTable();
		table.setBounds(22, 21, 1630, 920);
		scroll = new JScrollPane(table);
		contentPane.add(scroll);
		
		product_add = new JButton("Product_add");
		product_add.setBounds(22, 990, 250, 83);
		contentPane.add(product_add);
		
		stored = new JButton("Stored");
		stored.setBounds(488, 990, 125, 83);
		contentPane.add(stored);
		
		released = new JButton("Released");
		released.setBounds(612, 990, 125, 83);
		contentPane.add(released);
		
		sandr = new JButton("Check_S&R");
		sandr.setBounds(957, 990, 250, 83);
		contentPane.add(sandr);
		
		sandr.addActionListener(new ActionListener(){
			List<ERP_DTO> list = dao.getSandR();
			String data[][] = new String[list.size()][4];
			
			//model = new DefaultTableModel(data,column);
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		
		stock = new JButton("Check_stock");
		stock.setBounds(1402, 990, 250, 83);
		contentPane.add(stock);
		
		setVisible(true);
	}
	
	
	
	
	/*
	private class ERP_Check implements ActionListener{
		JButton sandr;
		JTable table;
		
		ERP_Check(JButton sandr,JTable table){
			this.sandr = sandr;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}*/
	 
}
