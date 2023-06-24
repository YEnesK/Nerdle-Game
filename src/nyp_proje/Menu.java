package nyp_proje;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Menu {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("NerdleGame");
		
		JLabel label1 = new JLabel();
		label1.setText("20011044 YUSUF ENES KURT");
		label1.setBounds(450, 10, 200, 10);
		//label1.setSize(300, 10);
		
		JButton yeniOyun = new JButton();
		yeniOyun.setText("Yeni Oyun");
		yeniOyun.setFont(new Font("Arial", Font.BOLD, 20));
		yeniOyun.setBounds(25, 500, 200, 100);
		yeniOyun.addActionListener(new ActionListener() {    //Butona týklandýðýnda

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String equation;
				equation = Denklem.generateEquation();
				
				System.out.println(equation);
				
				Oyun oyun = new Oyun();
				oyun.yeniOyun(equation);
				oyun.setVisible(true);
				
				
			}
			
		});
		
		JButton devamEt = new JButton();
		devamEt.setText("Devam Et");
		devamEt.setFont(new Font("Arial", Font.BOLD, 20));
		devamEt.setBounds(250, 500, 200, 100);
		devamEt.addActionListener(new ActionListener() {    //Butona týklandýðýnda

			@Override
			public void actionPerformed(ActionEvent e) {
				String equation;
				equation = Denklem.generateEquation();
				Kayit kayit=DosyaIslemleri.kayitOku();
				Oyun oyun = new Oyun();
				oyun.oyunaDevamEt(equation, kayit);
				oyun.setVisible(true);
				
				
			}
			
		});
		
		JButton test = new JButton();
		test.setText("Test");
		test.setFont(new Font("Arial", Font.BOLD, 20));
		test.setBounds(475, 500, 200, 100);
		test.addActionListener(new ActionListener() {    //Butona týklandýðýnda

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String equation;
				equation = Denklem.generateEquation();
				
				System.out.println(equation);
				
				Test test = new Test(equation);
				test.setVisible(true);
				
				
			}
			
		});
		
		frame.getContentPane().add(label1);
		frame.getContentPane().add(yeniOyun);
		frame.getContentPane().add(devamEt);
		frame.getContentPane().add(test);
		frame.setSize(700,700);
		frame.getContentPane().setLayout(null);
		
		JLabel labelTotal = new JLabel("New label");
		labelTotal.setBounds(155, 108, 412, 50);
		frame.getContentPane().add(labelTotal);
		labelTotal.setText("Oynanan Toplam Oyun Sayýsý: 0");
		
		JLabel labelWin = new JLabel("New label");
		labelWin.setBounds(155, 169, 412, 50);
		frame.getContentPane().add(labelWin);
        labelWin.setText("Kazanýlan Oyun Sayýsý: 0");

		
		JLabel labelLost = new JLabel("New label");
		labelLost.setBounds(155, 230, 412, 50);
		frame.getContentPane().add(labelLost);
		labelLost.setText("Kaybedilen Oyun Sayýsý: 0");
		
		JLabel labelUnf = new JLabel("New label");
		labelUnf.setBounds(155, 291, 412, 50);
		frame.getContentPane().add(labelUnf);
		labelUnf.setText("Yarým Býrakýlmýþ Oyun Sayýsý: 0");
		
		JLabel labelRow = new JLabel("New label");
		labelRow.setBounds(155, 352, 412, 50);
		frame.getContentPane().add(labelRow);
		labelRow.setText("Ortalama Satýr: 0");
		
		
		JLabel labelTime = new JLabel("New label");
		labelTime.setBounds(155, 413, 412, 33);
		frame.getContentPane().add(labelTime);
		labelTime.setText("Ortalama Süre: 0");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		
		File myFile = new File("statics.dat");
		if(myFile.exists()){
	          Istatistik stat = DosyaIslemleri.istatistikOku();
	        labelTotal.setText("Oynanan Toplam Oyun Sayýsý: "+stat.getTotalGames());
	        labelWin.setText("Kazanýlan Oyun Sayýsý: "+stat.getWinGames());
	        labelLost.setText("Kaybedilen Oyun Sayýsý: "+stat.getLostGames());
	        labelUnf.setText("Yarým Býrakýlmýþ Oyun Sayýsý: "+stat.getUnfinishedGames());
	        labelRow.setText(String.format("Ortalama Satýr: %.2f", stat.getAverageRowNumber()));
	        labelTime.setText(String.format("Ortalama Süre: %.1f saniye",stat.getAverageTime()));
	     }else {
	    	 System.out.println("dosya acilamadi");
	     }

	}
	
	

}

