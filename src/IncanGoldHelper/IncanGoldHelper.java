package IncanGoldHelper;

import java.awt.event.ActionEvent;

//import java.util.Scanner;

public class IncanGoldHelper {

	static BadCard spider = new BadCard();
	static BadCard snake = new BadCard();
	static BadCard rocks = new BadCard();
	static BadCard mummy = new BadCard();
	static BadCard fire = new BadCard();

	int  round = 1;
			
	//used to calculate the odds of failure if one decides to stay in that round.
	float failRate = 0,
			deck = 0,
			hazard = 0;
	
	public static void main(String[] args) {
		
		spider.name = "spider";
		rocks.name = "rocks";
		snake.name = "snake";
		mummy.name = "mummy";
		fire.name = "fire";
		
		new GUI();
		

	}
	

	
	
	public String newRound(ActionEvent e) {
		
		String out = "";
		
		String txt = ("<html>"+deck+" cards left in Round: "+round+": <br>");
		
		return txt + out;
		
	}


	private String roundOver() {
		round ++;
		artN = round - artS;
		hazard = 0; spiN = 0; rocN = 0; snaN = 0; mumN = 0; firN = 0; gem = 15;
		if (round < 6) {
			return ("Round "+(round-1)+" over!\n");
		} else {
			round = 1;
			return ("Game over");
		}
		
	}
	
	
	private String calculate() {
		deck = gem + artN +
				(spiMax-spiN) + (rocMax-rocN) + (snaMax-snaN) + (mumMax-mumN) + (firMax-firN);
		failRate = Math.round(100 * (hazard / deck));
		return (failRate + "% chance to fail</html>");
	}

	private String history(ActionEvent e) {
		return "Last card:"+e.getActionCommand();
	}




	public IncanGoldHelper(BadCard rocks) {
		this.rocks = rocks;
	}
}
