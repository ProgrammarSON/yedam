import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;

public class ERP_System extends JFrame implements ActionListener {

	protected JPanel contentPane;
	protected JTable table;
	protected JButton product_add;
	protected JButton stored;
	protected JButton released;
	protected JButton sandr;
	protected JButton stock;
	protected JScrollPane scroll;
	protected DefaultTableModel model;
	protected ERP_DAO dao;
	
	protected SandR sr;
	protected Insert_Product ip;
	
	public ERP_System() {
		
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		dao = new ERP_DAO();
		ip = new Insert_Product(dao);
		sr = new SandR(dao);
		
		
		table = new JTable(model);
		scroll = new JScrollPane(table);
		scroll.setBounds(22, 21, 1400, 520);
		
		
		product_add = new JButton("Product_add");
		product_add.setBounds(22, 578, 180, 50);
		contentPane.add(product_add);
		product_add.addActionListener(this);
		
		stored = new JButton("S&R");
		stored.setBounds(494, 578, 180, 50);
		contentPane.add(stored);
		stored.addActionListener(this);
		
		sandr = new JButton("Check_S&R");
		sandr.setBounds(896, 578, 180, 50);
		contentPane.add(sandr);
		sandr.addActionListener(new ERP_Check());
				
		stock = new JButton("Check_stock");
		stock.setBounds(1242, 578, 180, 50);
		contentPane.add(stock);
				
		setVisible(true);
	}
	
	
	private class ERP_Check implements ActionListener{
		DefaultTableModel model;
		String data[][];
		List<ERP_DTO> list;
		String column[] = {"index","product_id","DATE" };
		
		ERP_Check(){
			data = new String[1000][3];
		}
			

		@Override
		public void actionPerformed(ActionEvent e) {
			list = dao.getSandR();
						
			int i =0;
			for(ERP_DTO d : list)
			{
				data[i][0] = d.getIndex();
				data[i][1] = d.getProduct_id();
				data[i][2] = d.getSar_date();
				i++;
			}
			
			model = new DefaultTableModel(data,column);
			//model.setColumnIdentifiers(data);
			table.setModel(model);
		
			
			if(e.getActionCommand().equals("Check_S&R"))
				contentPane.add(scroll);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Product_add"))
			ip.setVisible(true);
		
		if(e.getActionCommand().equals("S&R"))
			sr.setVisible(true);
		
		
	}
	
	
}
