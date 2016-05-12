
public class Fleeing extends State {

	public Fleeing(Player player) {
		super(player);
	}

	@Override
	public void doAction() {
		if(!player.isWounded()) {
			System.out.println("My blade is at your service.");
			player.setState(new Waiting(player));
		} else {
			System.out.println("You are under attack!!");
		}
	}

}
