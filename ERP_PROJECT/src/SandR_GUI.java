import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SandR_GUI extends JFrame {

	protected JPanel contentPane;
	//protected JTextField sandr_txt;
	protected JTextField pkey_txt;
	protected JTextField amount_txt;
	//protected JLabel sandr_label;
	protected JLabel pkey_label;
	protected JLabel amount_label;
	protected JButton btn;
	protected JButton btn2;
	
	
	public SandR_GUI() {
		
		setBounds(100, 100, 595, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//sandr_label = new JLabel("index");
		//sandr_label.setBounds(12, 10, 87, 32);
		//contentPane.add(sandr_label);
		
		pkey_label = new JLabel("product_id");
		pkey_label.setBounds(41, 10, 87, 32);
		contentPane.add(pkey_label);
		
		amount_label = new JLabel("stock");
		amount_label.setBounds(192, 10, 87, 32);
		contentPane.add(amount_label);
		
		//sandr_txt = new JTextField();
		//sandr_txt.setBounds(12, 52, 74, 21);
		//contentPane.add(sandr_txt);
		//sandr_txt.setColumns(10);
		
		pkey_txt = new JTextField();
		pkey_txt.setColumns(10);
		pkey_txt.setBounds(41, 52, 74, 21);
		contentPane.add(pkey_txt);
		
		amount_txt = new JTextField();
		amount_txt.setColumns(10);
		amount_txt.setBounds(192, 52, 74, 21);
		contentPane.add(amount_txt);
	
		btn = new JButton("stored");
		btn.setBounds(328, 20, 89, 53);
		contentPane.add(btn);
		
		btn2 = new JButton("released");
		btn2.setBounds(443, 20, 97, 53);
		contentPane.add(btn2);
	}

}
