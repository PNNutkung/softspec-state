import java.util.Scanner;

public class Player {
	private boolean wounded;
	private boolean friendWounded;
	private boolean opponentNearby;
	
	private State state;
	
	public Player() {
		this.wounded = false;
		this.friendWounded = false;
		this.opponentNearby = false;
		state = new Waiting(this);
		startEventLoop();
	}
	
	public boolean isWounded() {
		return this.wounded;
	}
	
	public boolean isFriendWounded() {
		return friendWounded;
	}

	public boolean isOpponentNearby() {
		return opponentNearby;
	}

	public State getState() {
		return state;
	}

	public void setWounded(boolean wounded) {
		this.wounded = wounded;
	}

	public void setFriendWounded(boolean friendWounded) {
		this.friendWounded = friendWounded;
	}

	public void setOpponentNearby(boolean opponentNearby) {
		this.opponentNearby = opponentNearby;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void startEventLoop() {
		Thread t = new Thread() {
			@Override
			public void run() {
				while(true) {
					state.doAction();
					try {
						sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
	
	public static void main(String[] args) {
		Player player = new Player();
		Scanner input = new Scanner(System.in);
		while(true) {
			int st = input.nextInt();
			switch(st) {
				case 1:
					player.setWounded(true);
					break;
				case 2:
					player.setWounded(false);
					break;
				case 3:
					player.setFriendWounded(true);
					break;
				case 4:
					player.setFriendWounded(false);
					break;
				case 5:
					player.setOpponentNearby(true);
					break;
				case 6:
					player.setOpponentNearby(false);
					break;
			}
		}
	}
}
