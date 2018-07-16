import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insert_Product extends Insert_Product_GUI implements ActionListener{
	
	ERP_DTO dto;
	ERP_DAO dao;
	public Insert_Product(ERP_DAO dao) {
		this.dao = dao;
		dto =new ERP_DTO();
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dto.setProduct_id(pkey_txt.getText());
		dto.setProduct_name(pname_txt.getText());
		dto.setTotal(stock_txt.getText());
		dto.setWarehouse(warehouse_txt.getText());
		dao.insertErp(dto);
		if(e.getActionCommand().equals("INSERT"));
			setVisible(false);
	}
}
