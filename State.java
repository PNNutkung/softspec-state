
public abstract class State {
	protected Player player;
	public State(Player player) {
		this.player = player;
	}
	public abstract void doAction();
}
