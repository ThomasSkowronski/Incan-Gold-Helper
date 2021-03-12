package IncanGoldHelper;

import java.awt.event.ActionEvent;

//import java.util.Scanner;

public class IncanGoldHelper {

	
	
	//variables
	int  round = 1,
			//the number of any card drawn (use in switch case)
			spiN = 0,
			rocN = 0,
			snaN = 0,
			mumN = 0,
			firN = 0,
			gem = 15,
			artN = 0,
			//number of artifacts stolen thus, removed from the game.
			artS = 0,
			//number of hazards left in the deck. If a hazard is drawn for the second time during a round,
			//	that round ends and that hazard is removed from the game.
			spiMax = 3,
			rocMax = 3,
			snaMax = 3,
			mumMax = 3,
			firMax = 3;
	
	//used to calculate the odds of failure if one decides to stay in that round.
	float failRate = 0,
			deck = 0,
			hazard = 0;
	
	public static void main(String[] args) {
				
		new GUI();
		

	}
	

	
	
	public String newRound(ActionEvent e) {
		
		String out = "";
		
		switch (e.getActionCommand()) {
			case "Gems":
				gem --;
				out = calculate();
				break;
			case "Spider":
				spiN ++;
				if (spiN == 2) {
					spiMax --;
					out = roundOver();
				} else {
					hazard += spiMax - 1;
					out = calculate();
				}
				break;
			case "Artifact":
				artN --;
				out = calculate();
				break;
			case "Rocks":
				rocN ++;
				if (rocN == 2) {
					rocMax --;
					out = roundOver();
				} else {
					hazard += rocMax - 1;
					out = calculate();
				}
				break;
			case "Snake":
				snaN ++;
				if (snaN == 2) {
					snaMax --;
					out = roundOver();
				} else {
					hazard += snaMax - 1;
					out = calculate();
				}
				break;
			case "Mummy":
				mumN ++;
				if (mumN == 2) {
					mumMax --;
					out = roundOver();
				} else {
					hazard += mumMax - 1;
					out = calculate();
				}
				break;
			case "Fire":
				firN ++;
				if (firN == 2) {
					firMax --;
					out = roundOver();
				} else {
					hazard += firMax - 1;
					out = calculate();
				}
				break;
			case "Escape":
				out = roundOver();
				break;
			case "Steal":
				artS ++;
				out = ("Artifact Stolen!\n"+"("+artS+")");
				break;
			
		}
		
		deck = gem + artN +
				(spiMax-spiN) + (rocMax-rocN) + (snaMax-snaN) + (mumMax-mumN) + (firMax-firN);
		
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
}
