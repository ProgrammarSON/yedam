package TESTSwing1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;


class EventClass implements ActionListener{

	JButton jb;
	JTextField jtf;
	JTextArea jta;
	public EventClass(JButton jb, JTextField jtf,JTextArea jta){
		this.jb = jb;
		this.jtf = jtf;
		this.jta = jta;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String filename;
		
		try {
		if((JButton)e.getSource() == jb) {
			filename = jtf.getText();
			filename += ".txt";
			FileOutputStream fos;
			fos = new FileOutputStream(filename);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF(jta.getText());
			
			fos.close();
			jtf.setText("");
			System.out.println(filename + "파일이 생성 되었음");
			}
		
		}catch (Exception e1) {
		 }
	}
}
class GUI1 extends JFrame implements ActionListener{
	JTextField jtf;
	JTextArea jta;
	JLabel jtl = new JLabel("입력하시오");
	JButton jb;
	public GUI1() {
		jtf = new JTextField(20);
		jta = new JTextArea(10,20);
		jta.setEditable(false);
		jb = new JButton("저장");
		
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		JPanel jp = new JPanel();		
		jp.add(jtf);
		jp.add(jta);
		ct.add(jp);
		ct.add(jtl);
		ct.add(jb);
		
		jtf.addActionListener(this);
		jb.addActionListener(new EventClass(jb,jtf,jta));		
		
		setSize(500,300);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(jta.getLineCount() <= jta.getRows())
		{
			jta.append(e.getActionCommand() + "\n");
			jtf.setText("");
		}
		else 
		{
			jtl.setText("빈 공간이 없네요");
			jtf.setEditable(false);
		}
	
	}
}


public class testSwing1 {
	public static void main(String[] args) {
		new GUI1();		
	}

}
