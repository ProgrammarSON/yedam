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

public class ERP_System  extends ERP_System_GUI implements ActionListener {

	protected ERP_DAO dao;
	
	public ERP_System() {
		
		dao = new ERP_DAO();
		ip = new Insert_Product(dao);
		sr = new SandR(dao);
		
		product_add.addActionListener(this);
		stored.addActionListener(this);
		sandr.addActionListener(new ERP_Check());
		stock.addActionListener(new STOCK_Check());
		depot_btn.addActionListener(new DEPOT_Check());
	}
	
	
	private class ERP_Check implements ActionListener{
		DefaultTableModel model;
		String data[][];
		List<ERP_DTO> list;
		String column[] = {"index","product_id","stock","DATE" };
		
		ERP_Check(){
			data = new String[1000][4];
		}
			

		@Override
		public void actionPerformed(ActionEvent e) {
			list = dao.getSandR();
						
			int i =0;
			for(ERP_DTO d : list)
			{
				data[i][0] = d.getIndex();
				data[i][1] = Integer.toString(d.getProduct_id());
				data[i][2] = Integer.toString(d.getAmount());
				data[i][3] = d.getSar_date();
				i++;
			}
			
			model = new DefaultTableModel(data,column);
			//model.setColumnIdentifiers(data);
			table.setModel(model);
		
			
			if(e.getActionCommand().equals("Check_S&R"))
				contentPane.add(scroll);
		}
	}
	
	private class STOCK_Check implements ActionListener{
		DefaultTableModel model;
		String data[][];
		List<ERP_DTO> list;
		String column[] = {"product_id","product_name","stock","warehouse" };
		
		STOCK_Check(){
			data = new String[1000][4];
		}
			

		@Override
		public void actionPerformed(ActionEvent e) {
			list = dao.getStock();
						
			int i =0;
			for(ERP_DTO d : list)
			{
				data[i][0] = Integer.toString(d.getProduct_id());
				data[i][1] = d.getProduct_name();
				data[i][2] = d.getTotal();
				data[i][3] = d.getWarehouse();
				i++;
			}
			
			model = new DefaultTableModel(data,column);
			//model.setColumnIdentifiers(data);
			table.setModel(model);
		
			
			if(e.getActionCommand().equals("Check_stock"))
				contentPane.add(scroll);
		}
	}
	
	
	private class DEPOT_Check implements ActionListener{
		DefaultTableModel model;
		String data[][];
		List<ERP_DTO> list;
		String column[] = {"DEPOT_NAME","DEPOT_TYPE","STOCK"};
		
		DEPOT_Check(){
			data = new String[4][3];
		}
			

		@Override
		public void actionPerformed(ActionEvent e) {
			list = dao.getDepot();
						
			int i =0;
			for(ERP_DTO d : list)
			{
				data[i][0] = d.getWarehouse();
				data[i][1] = d.getDepot_type();
				data[i][2] = d.getTotal();
				i++;
			}
			
			model = new DefaultTableModel(data,column);
			//model.setColumnIdentifiers(data);
			table.setModel(model);
		
			
			if(e.getActionCommand().equals("Check_Depot"));
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
