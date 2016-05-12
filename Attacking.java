
public class Attacking extends State {

	public Attacking(Player player) {
		super(player);
	}

	@Override
	public void doAction() {
		if(player.isWounded()) {
			System.out.println("You are under attack!!");
			player.setState(new Fleeing(player));
		} else if(player.isFriendWounded()) {
			System.out.println("Stars hear me!");
			player.setState(new Healing(player));
		} else {
			System.out.println("Bam! Bam! Bam!");
		}
	}

}
