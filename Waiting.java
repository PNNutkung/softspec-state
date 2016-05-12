
public class Waiting extends State {
	
	public Waiting(Player player) {
		super(player);
	}

	@Override
	public void doAction() {
		if(player.isFriendWounded()) {
			System.out.println("Your friend is under attack!!");
			player.setState(new Healing(player));
		} else if (player.isOpponentNearby()) {
			System.out.println("An enemy is on your sight!!!!");
			player.setState(new Attacking(player));
		} else
			System.out.println("My blade is at your service.");
	}	
}
