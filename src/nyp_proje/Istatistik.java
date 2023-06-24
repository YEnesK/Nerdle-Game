package nyp_proje;

import java.io.Serializable;

public class Istatistik implements Serializable{
	 	private int totalGames;
	    private int winGames;
	    private int lostGames;
	    private int unfinishedGames;
	    private int totalTime;
	    private double averageTime;
	    private int totalRows;
	    private double averageRowNumber;
	    
	    public void incTotalGames(){
	        totalGames++;
	    }
	    
	    public void incWinGames(){
	        winGames++;
	    }
	    
	    public void incLostGames(){
	        lostGames++;
	    }
	    
	    public void incUnfinishedGames(){
	        unfinishedGames++;
	    }
	    
	    public void setAverageRowNumber(int round){
	        totalRows+=round;
	        averageRowNumber = (double) totalRows/winGames;
	    }
	    
	    public void setAverageTime(int time){
	        totalTime+=time;
	        averageTime = (double) totalTime/winGames;
	    }
	    

	    public int getTotalGames() {
	        return totalGames;
	    }

	    public int getWinGames() {
	        return winGames;
	    }

	    public int getLostGames() {
	        return lostGames;
	    }

	    public int getUnfinishedGames() {
	        return unfinishedGames;
	    }

	    public double getAverageTime() {
	        return averageTime;
	    }

	    public double getAverageRowNumber() {
	        return averageRowNumber;
	    }
}
