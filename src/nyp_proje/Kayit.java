package nyp_proje;

import java.io.Serializable;

import javax.swing.JButton;

public class Kayit implements Serializable{
	
    private int satir;
    private int time;
    private String denklem;
    private JButton[][] buttons;

    public Kayit( int satir,  int time, String denklem, JButton[][] buttons) {
        this.satir = satir;
        this.time = time;
        this.denklem = denklem;
        this.buttons = buttons;
    }


	public int getSatir() {
		return satir;
	}

	public int getTime() {
		return time;
	}

	public String getDenklem() {
		return denklem;
	}

	public JButton[][] getButtons() {
		return buttons;
	}

	
    

}
