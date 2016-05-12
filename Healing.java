
public class Healing extends State {

	public Healing(Player player) {
		super(player);
	}

	@Override
	public void doAction() {
		if(player.isOpponentNearby()) {
			System.out.println("An enemy is on your sight!!!!");
			player.setState(new Attacking(player));
		} else if(player.isWounded()) {
			System.out.println("You are under attack!!");
			player.setState(new Fleeing(player));
		} else if (!player.isFriendWounded()) {
			System.out.println("You are under attack!!");
			player.setState(new Fleeing(player));
		} else {
			System.out.println("Stars hear me!");
		}
	}

}
