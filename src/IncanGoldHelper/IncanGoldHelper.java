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
			artN = 1,
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
		
		//welcome message and instructions.
		System.out.print("Welcome! \nType the newest card drawn as follows:"
				+ "\n'gem', 'artifact', 'spider', 'rock', 'snake', 'mummy', 'fire'."
				+ "\n'escape' when all players have safely left the cave"
				+ "\n'steal' when a player leaves with an artifact card"
				+ "\n'exit' to end the program"
				+ "\n");
		
		new GUI();
		

	}
	

	
	
	public String newRound(ActionEvent e) {
		deck = gem + artN +
				(spiMax-spiN) + (rocMax-rocN) + (snaMax-snaN) + (mumMax-mumN) + (firMax-firN);
		
		String txt = ("Round "+round+"("+deck+" left)"+": \n");
		String out = "";
		
		switch (e.getActionCommand()) {
			case "gem":
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
			case "artifact":
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
			case "snake":
				snaN ++;
				if (snaN == 2) {
					snaMax --;
					out = roundOver();
				} else {
					hazard += snaMax - 1;
					out = calculate();
				}
				break;
			case "mummy":
				mumN ++;
				if (mumN == 2) {
					mumMax --;
					out = roundOver();
				} else {
					hazard += mumMax - 1;
					out = calculate();
				}
				break;
			case "fire":
				firN ++;
				if (firN == 2) {
					firMax --;
					out = roundOver();
				} else {
					hazard += firMax - 1;
					out = calculate();
				}
				break;
			case "escape":
				out = roundOver();
				break;
			case "steal":
				artS ++;
				out = ("Artifact Stolen!\n");
				break;
			case "exit":
				round = 6;
				break;
			
		}
		
		return txt + out;
		
	}


	private String roundOver() {
		round ++;
		artN = round - artS;
		hazard = 0; spiN = 0; rocN = 0; snaN = 0; mumN = 0; firN = 0; gem = 15;
		return ("Round "+round+" over!\n");
	}
	
	
	private String calculate() {
		deck = gem + artN +
				(spiMax-spiN) + (rocMax-rocN) + (snaMax-snaN) + (mumMax-mumN) + (firMax-firN);
		failRate = Math.round(100 * (hazard / deck));
		return (failRate + "% chance to fail\n");
	}
}
