package nyp_proje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Test extends JFrame {

	private JPanel contentPane;
	private String denklem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String denklem="";
					Test frame = new Test(denklem);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test(String equation) {
		setTitle("Test");
		
		denklem=equation;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField a[] = new JTextField[9];
		
		String[] str = null;
		str = denklem.split("");
		
		for(int i=0 ; i<denklem.length() ; i++) {
			a[i] = new JTextField();
			a[i].setBounds(75+i*50,40, 50,50);
			a[i].setText(str[i]);
			a[i].setFont(new Font("Tahoma", Font.BOLD, 20));
			a[i].setHorizontalAlignment(NORMAL);
			a[i].setEditable(false);
	    	contentPane.add(a[i]);
		}
		if(denklem.length()==8) {
			a[8] = new JTextField();
			a[8].setBounds(75+400,40, 50,50);
			a[8].setFont(new Font("Tahoma", Font.BOLD, 20));
			a[8].setHorizontalAlignment(NORMAL);
			a[8].setEditable(false);
			a[8].setVisible(false);
			contentPane.add(a[8]);
		}else if(denklem.length()==7) {
			a[7] = new JTextField();
			a[7].setBounds(75+350,40, 50,50);
			a[7].setFont(new Font("Tahoma", Font.BOLD, 20));
			a[7].setHorizontalAlignment(NORMAL);
			a[7].setEditable(false);
			a[7].setVisible(false);
			contentPane.add(a[7]);
			
			a[8] = new JTextField();
			a[8].setBounds(75+400,40, 50,50);
			a[8].setFont(new Font("Tahoma", Font.BOLD, 20));
			a[8].setHorizontalAlignment(NORMAL);
			a[8].setEditable(false);
			a[8].setVisible(false);
			contentPane.add(a[8]);
		}
		
		
		JButton btnNewButton = new JButton("Yeniden Uret");
		btnNewButton.setBounds(162, 123, 269, 57);
		btnNewButton.addActionListener(new ActionListener() {    //Butona týklandýðýnda

			@Override
			public void actionPerformed(ActionEvent e) {
				
				denklem = Denklem.generateEquation();
				
				a[7].setVisible(true);
				a[8].setVisible(true);
				
				if(denklem.length()==8) {
					a[8].setVisible(false);
				}else if(denklem.length()==7) {
					a[7].setVisible(false);
					a[8].setVisible(false);
				}
				
				String[] str = null;
				str = denklem.split("");
				
				for(int i=0 ; i<denklem.length() ; i++) {
					a[i].setText(str[i]);
				}
				
			}
			
		});
		contentPane.add(btnNewButton);
		
		
		JTextPane txtpnYusufEnes = new JTextPane();
		txtpnYusufEnes.setBackground(SystemColor.control);
		txtpnYusufEnes.setToolTipText("");
		txtpnYusufEnes.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnYusufEnes.setEditable(false);
		txtpnYusufEnes.setText("20011044 YUSUF ENES KURT");
		txtpnYusufEnes.setBounds(43, 261, 478, 39);
		contentPane.add(txtpnYusufEnes);
	}
}
