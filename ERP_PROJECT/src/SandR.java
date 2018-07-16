import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class SandR extends SandR_GUI implements ActionListener{

	ERP_DTO dto;
	ERP_DAO dao;
	
	
	public SandR(ERP_DAO dao) {
		this.dao = dao;
		dto =new ERP_DTO();
		btn.addActionListener(this);
		btn2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dto.setIndex(sandr_txt.getText());
		dto.setProduct_id(pkey_txt.getText());
		
		if(e.getActionCommand().equals("stored"))		
			dto.setAmount(amount_txt.getText());
		if(e.getActionCommand().equals("released"))
			dto.setAmount("-" + amount_txt.getText());
		
		dao.insertSandR(dto);
	}

}
