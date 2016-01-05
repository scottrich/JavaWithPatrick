package montyhall;

public class Contestant {
	private String name;
	private Game game;

	public void setGame(Game game) {
		this.game = game;
	}

	public String getName() {
		return name;
	}

	public Contestant(String inName) {
		name = inName;
	}

	@Override
	public String toString() {
		return "Your Contestant, " + getName();
	}

	public int pickDoor() {
		return (int) (Math.random() * 3);
	}

	public void switchDoors() {
		int picked = -1;
		for (int i = 0; i < 3; i++) {
			if (i != game.getPicked() && i != game.getHostShows())
				picked = i;
		}
		game.setPicked(picked);
	}
}