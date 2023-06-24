package nyp_proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Oyun extends JFrame {

	private JPanel contentPane;
	private String denklem;
	private JButton clicked;
	private int sutun;
	private int satir;
	JButton a[][] = new JButton[9][6];
	private Timer timer;
	private int gecenSure;
	private JLabel sure ;
	private Istatistik stat;
	private Oyun mine=this;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*try {
					String denklem="";
					Oyun frame = new Oyun(denklem);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
			}
		});
	}
	
	public Oyun() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Oyun");
		setBounds(100, 100, 800, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		init();
		
		File myFile = new File("statics.dat");
        
		if(!myFile.exists()) 
            stat=new Istatistik(); 
        else
            stat = DosyaIslemleri.istatistikOku();		
		
		setTimer();
		
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {}

			@Override
			public void windowClosing(WindowEvent e) {
				stat.incUnfinishedGames();
				DosyaIslemleri.istatistikKaydet(stat);
				mine.dispose();
				
			}

			@Override
			public void windowClosed(WindowEvent e) {}

			@Override
			public void windowIconified(WindowEvent e) {}

			@Override
			public void windowDeiconified(WindowEvent e) {}

			@Override
			public void windowActivated(WindowEvent e) {}

			@Override
			public void windowDeactivated(WindowEvent e) {}
			
		});
	}
	
	
	
	public void oyunaDevamEt(String equation, Kayit kayit) {
		
		gecenSure = kayit.getTime();
		sure.setText(String.format("%02d:%02d", gecenSure/60,gecenSure%60));
		satir = kayit.getSatir();
		denklem=kayit.getDenklem();
		a=kayit.getButtons();
		
		for(int i=0 ; i<denklem.length() ; i++) {                                    //kareleri olusturma
			for(int j=0 ; j<6 ; j++) {
				contentPane.add(a[i][j]);
			}
		}
		
		clicked=a[0][satir];
		
		for(int i=0 ; i<denklem.length() ; i++) {                                     //tiklanan kareyi bulma
			for(int j=0 ; j<6 ; j++) {
				a[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clicked = (JButton)e.getSource();
					}
				});
				
			}	
		}
		
		activateSatir(satir);
		
		
	}

	public void yeniOyun(String equation) {
		setTitle("Oyun");
		
		denklem=equation;
		satir = 0;
		
		
		
		
		for(int i=0 ; i<denklem.length() ; i++) {                                    //kareleri olusturma
			for(int j=0 ; j<6 ; j++) {
				a[i][j] = new JButton();
				a[i][j].setBounds(10+55*i,10+55*j, 50,50);
				a[i][j].setFont(new Font("Arial" , Font.BOLD, 20));
				a[i][j].setHorizontalAlignment(JTextField.CENTER);
				contentPane.add(a[i][j]);
				/*if(j != 0)
					a[i][j].setVisible(false);*/
			}
		}
		
		clicked=a[0][satir];
		
		for(int i=0 ; i<denklem.length() ; i++) {                                     //tiklanan kareyi bulma
			for(int j=0 ; j<6 ; j++) {
				a[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clicked = (JButton)e.getSource();
					}
				});
				
			}	
		}
		
		activateSatir(satir);
	}
	public void init() {
		JButton nmb0 = new JButton("0");                                         //Sifir Butonu
		nmb0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				clicked.setText("0");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];
				
				
			}
		});
		nmb0.setFont(new Font("Arial", Font.BOLD, 11));
		nmb0.setBounds(634, 181, 40, 40);
		contentPane.add(nmb0);	
		
		
		
		
		JButton nmb1 = new JButton("1");                                           //Bir Butonu
		nmb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("1");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];

			}
		});
		nmb1.setFont(new Font("Arial", Font.BOLD, 11));
		nmb1.setBounds(634, 28, 40, 40);
		contentPane.add(nmb1);
		
		
		
		
		JButton nmb2 = new JButton("2");                                             //Ýki Butonu
		nmb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("2");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];

			}
		});
		nmb2.setFont(new Font("Arial", Font.BOLD, 11));
		nmb2.setBounds(684, 28, 40, 40);
		contentPane.add(nmb2);
		
		
		
		
		JButton nmb3 = new JButton("3");
		nmb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("3");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];

			}
		});
		nmb3.setFont(new Font("Arial", Font.BOLD, 11));
		nmb3.setBounds(734, 28, 40, 40);
		contentPane.add(nmb3);
		
		
		
		
		JButton nmb4 = new JButton("4");
		nmb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("4");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];

			}
		});
		nmb4.setFont(new Font("Arial", Font.BOLD, 11));
		nmb4.setBounds(634, 79, 40, 40);
		contentPane.add(nmb4);
		
		
		
		
		JButton nmb5 = new JButton("5");
		nmb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("5");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];

			}
		});
		nmb5.setFont(new Font("Arial", Font.BOLD, 11));
		nmb5.setBounds(684, 79, 40, 40);
		contentPane.add(nmb5);
		
		
		
		
		JButton nmb6 = new JButton("6");
		nmb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("6");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];

			}
		});
		nmb6.setFont(new Font("Arial", Font.BOLD, 11));
		nmb6.setBounds(734, 79, 40, 40);
		contentPane.add(nmb6);
		
		
		
		
		JButton nmb7 = new JButton("7");
		nmb7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("7");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];

			}
		});
		nmb7.setFont(new Font("Arial", Font.BOLD, 11));
		nmb7.setBounds(634, 130, 40, 40);
		contentPane.add(nmb7);
		
		
		
		
		JButton nmb8 = new JButton("8");
		nmb8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("8");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];

			}
		});
		nmb8.setFont(new Font("Arial", Font.BOLD, 11));
		nmb8.setBounds(684, 130, 40, 40);
		contentPane.add(nmb8);
		
		
		
		
		JButton nmb9 = new JButton("9");
		nmb9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("9");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];

			}
		});
		nmb9.setFont(new Font("Arial", Font.BOLD, 11));
		nmb9.setBounds(734, 130, 40, 40);
		contentPane.add(nmb9);
		
		
		
		
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("+");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];
			}
		});
		plus.setFont(new Font("Arial", Font.BOLD, 11));
		plus.setBounds(684, 181, 40, 40);
		contentPane.add(plus);
		
		
		
		
		JButton minus = new JButton("-");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("-");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];
			}
		});
		minus.setFont(new Font("Arial", Font.BOLD, 15));
		minus.setBounds(734, 181, 40, 40);
		contentPane.add(minus);
		
		
		
		
		JButton divide = new JButton("/");
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("/");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];
			}
		});
		divide.setFont(new Font("Arial", Font.BOLD, 13));
		divide.setBounds(634, 232, 40, 40);
		contentPane.add(divide);
		
		
		
		
		JButton multiply = new JButton("*");
		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("*");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];
			}
		});
		multiply.setFont(new Font("Arial", Font.BOLD, 15));
		multiply.setBounds(684, 232, 40, 40);
		contentPane.add(multiply);
		
		
		
		
		JButton equal = new JButton("=");
		equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clicked.setText("=");
				
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				i++;
				clicked=a[i][satir];
			}
		});
		equal.setFont(new Font("Arial", Font.BOLD, 10));
		equal.setBounds(734, 232, 40, 40);
		contentPane.add(equal);
		JButton sil = new JButton("Sil");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicked.setText("");
				int i=0;
				while(clicked!=a[i][satir]) {
					i++;
				}
				clicked=a[i-1][satir];
			}
		});
		sil.setFont(new Font("Arial", Font.BOLD, 13));
		sil.setBounds(634, 283, 140, 40);
		contentPane.add(sil);
		
		
		
		
		JButton tahmin = new JButton("Tahmin Et");
		tahmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Denklem dnk = new Denklem();
				String eq=a[0][satir].getText();
				for(int i=1 ; i<denklem.length() ; i++)
					eq += a[i][satir].getText();
				
				if(dnk.checkEquation(eq)) {
					
					boolean isThere;
					int i=0;
					
					while(i<denklem.length()){
						isThere = false;
						if(a[i][satir].getText().charAt(0)==denklem.charAt(i)) {
							a[i][satir].setBackground(Color.GREEN);
						}else {
							for(int j=0 ; j<denklem.length() ; j++) {
								if(a[i][satir].getText().charAt(0)==denklem.charAt(j))
									isThere = true;	
							}
							if(!isThere) {
								a[i][satir].setBackground(Color.RED);
							}else {
								a[i][satir].setBackground(Color.ORANGE);
							}
							
						}
						i++;
					}
				}else {
					showDialog("Lütfen Geçerli bir denklem giriniz");
					return;
				}
				
				boolean kazandin = true;
				
				for(int i=0 ; i<denklem.length() ; i++) {
					if(a[i][satir].getText().charAt(0)!=denklem.charAt(i))
						kazandin = false;
				}
				
				if(kazandin) {
					timer.stop();
					showDialog("Tebrikler Oyunu Kazandýnýz!\nGecen Süre: "+String.format("%02d:%02d", gecenSure/60,gecenSure%60));
					stat.incTotalGames();
	                stat.incWinGames();
	                stat.setAverageRowNumber(satir+1);
	                stat.setAverageTime(gecenSure);
	                DosyaIslemleri.istatistikKaydet(stat);
					mine.dispose();
						
				}else if(satir != 5){
					satir++;
					activateSatir(satir);
					clicked=a[0][satir];
					
				}else {
					timer.stop();
					showDialog("Oyunu Kaybettiniz!");
					stat.incTotalGames();
					stat.incLostGames();
					DosyaIslemleri.istatistikKaydet(stat);
					mine.dispose();
					
				}
				
				
				
				
				
				
			}
		});
		tahmin.setFont(new Font("Arial", Font.BOLD, 13));
		tahmin.setBounds(634, 334, 140, 40);
		contentPane.add(tahmin);
		
		
		
		
		JButton sonra = new JButton("Sonra Bitir");
		sonra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				DosyaIslemleri.kaydet(new Kayit(satir,gecenSure,denklem,a));
				mine.dispose();
			}
		});
		sonra.setFont(new Font("Arial", Font.BOLD, 13));
		sonra.setBounds(634, 385, 140, 40);
		contentPane.add(sonra);
		
		JTextPane txtpnYusufEnes = new JTextPane();
		txtpnYusufEnes.setToolTipText("");
		txtpnYusufEnes.setText("20011044 YUSUF ENES KURT");
		txtpnYusufEnes.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnYusufEnes.setEditable(false);
		txtpnYusufEnes.setBackground(SystemColor.control);
		txtpnYusufEnes.setBounds(10, 472, 478, 39);
		contentPane.add(txtpnYusufEnes);   
		
		sure = new JLabel("");
		sure.setHorizontalAlignment(SwingConstants.CENTER);
		sure.setFont(new Font("Tahoma", Font.BOLD, 14));
		sure.setBounds(634, 448, 140, 39);
		contentPane.add(sure);
		
	}
	
	public void showDialog(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	
	
	public void activateSatir(int satirNo) {
		for(int i=0;i<6;i++){
			if(i!=satirNo) {
				for(int j=0;j<denklem.length();j++){
					a[j][i].setEnabled(false);
				}
			}else {
				for(int j=0;j<denklem.length();j++){
					a[j][i].setEnabled(true);
				}
			}
			
		}
	}
	
	private void setTimer(){ 
        sure.setText(String.format("%02d:%02d", gecenSure/60,gecenSure%60));
        timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gecenSure++;
            sure.setText(String.format("%02d:%02d", gecenSure/60,gecenSure%60));
        }
    });
        timer.start();
    }
}
