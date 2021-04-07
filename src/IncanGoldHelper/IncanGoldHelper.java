package IncanGoldHelper;

import java.awt.event.ActionEvent;

public class IncanGoldHelper {
	
	BadCard spider = new BadCard();
	BadCard snake = new BadCard();
	BadCard rocks = new BadCard();
	BadCard mummy = new BadCard();
	BadCard fire = new BadCard();

	Gem gem = new Gem();
	Artifact art = new Artifact();
	
	int  round = 1;
			
	//used to calculate the odds of failure if one decides to stay in that round.
	float failRate = 0,
			deck = 0,
			hazard = 0;
	private String x;
	
	public static void main(String[] args) {	

		new GUI();
	}

	public String newRound(ActionEvent e) {
		String x = e.getActionCommand();

		switch (x){
			case "Spider":
				if (spider.draw()){
					roundOver();
				}
				break;
			case "Snake":
				if (snake.draw()){
					roundOver();
				}
				break;
			case "Rocks":
				if (rocks.draw()){
					roundOver();
				}
				break;
			case "Mummy":
				if (mummy.draw()){
					roundOver();
				}
				break;
			case "Fire":
				if (fire.draw()){
					roundOver();
				}
				break;
				
		}
		return calculate();
	}


	private String roundOver() {
		round ++;
		spider.drawn = 0;
		rocks.drawn = 0;
		snake.drawn = 0;
		mummy.drawn = 0;
		fire.drawn = 0;

		if (round < 6) {
			return ("Round "+(round-1)+" over!\n");
		} else {
			round = 1;
			return ("Game over");
		}
		
	}
	
	
	public String calculate() {
		deck = spider.amt + snake.amt + rocks.amt + mummy.amt + fire.amt + gem.amt + art.amt;
		hazard = spider.left + snake.left + rocks.left + mummy.left + fire.left;
		failRate = Math.round(100 * (hazard / deck));
		String txt = ("<html>"+deck+" cards left in Round: "+round+": <br>");
		return txt + (failRate + "% chance to fail</html>");
	}

	public String history(ActionEvent e) {
		return "Last card:"+e.getActionCommand();
	}
}
