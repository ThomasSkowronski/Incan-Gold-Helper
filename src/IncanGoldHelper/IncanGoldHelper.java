package IncanGoldHelper;

import java.util.Scanner;

public class IncanGoldHelper {

	int  round = 1,
			spiN = 0,
			rocN = 0,
			snaN = 0,
			mumN = 0,
			firN = 0,
			gem = 15,
			artN = 1,
			artS = 0,
			spiMax = 3,
			rocMax = 3,
			snaMax = 3,
			mumMax = 3,
			firMax = 3;
			
	float failRate = 0,
			deck = 0,
			hazard = 0;
	
	Scanner inScan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Welcome! \nType the newest card drawn as follows:"
				+ "\n'gem', 'artifact', 'spider', 'rock', 'snake', 'mummy', 'fire'."
				+ "\n'escape' when all players have safely left the cave"
				+ "\n'steal' when a player leaves with an artifact card"
				+ "\n'exit' to end the program"
				+ "\n");
		
		IncanGoldHelper obj = new IncanGoldHelper();
		obj.newRound();

	}
	

		
	public void newRound() {
		deck = gem + artN +
				(spiMax-spiN) + (rocMax-rocN) + (snaMax-snaN) + (mumMax-mumN) + (firMax-firN);
		System.out.print("Round "+round+"("+deck+" left)"+": \n");
		String card = inScan.nextLine();
		
		switch (card) {
			case "gem":
				gem --;
				calculate();
				break;
			case "spider":
				spiN ++;
				if (spiN == 2) {
					spiMax --;
					roundOver();
				} else {
					hazard += spiMax - 1;
					calculate();
				}
				break;
			case "artifact":
				artN --;
				calculate();
				break;
			case "rock":
				rocN ++;
				if (rocN == 2) {
					rocMax --;
					roundOver();
				} else {
					hazard += rocMax - 1;
					calculate();
				}
				break;
			case "snake":
				snaN ++;
				if (snaN == 2) {
					snaMax --;
					roundOver();
				} else {
					hazard += snaMax - 1;
					calculate();
				}
				break;
			case "mummy":
				mumN ++;
				if (mumN == 2) {
					mumMax --;
					roundOver();
				} else {
					hazard += mumMax - 1;
					calculate();
				}
				break;
			case "fire":
				firN ++;
				if (firN == 2) {
					firMax --;
					roundOver();
				} else {
					hazard += firMax - 1;
					calculate();
				}
				break;
			case "escape":
				roundOver();
				break;
			case "steal":
				artS ++;
				System.out.print("Artifact Stolen!\n");
				break;
			case "exit":
				round = 6;
				break;
			
		}
		
		if (round < 6) {
			newRound();
		} else {
			System.out.print("Game Over!!!!");
		}
	}


	private void roundOver() {
		System.out.print("Round "+round+" over!\n");
		round ++;
		artN = round - artS;
		hazard = 0; spiN = 0; rocN = 0; snaN = 0; mumN = 0; firN = 0; gem = 15;
	}
	
	
	private void calculate() {
		deck = gem + artN +
				(spiMax-spiN) + (rocMax-rocN) + (snaMax-snaN) + (mumMax-mumN) + (firMax-firN);
		failRate = Math.round(100 * (hazard / deck));
		System.out.print(failRate + "% chance to fail\n");
	}


}
