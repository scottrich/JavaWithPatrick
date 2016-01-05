package montyhall;

public class Host {
	private String name;
	private Game game;

	public void setGame(Game game) {
		this.game = game;
	}

	public String getName() {
		return name;
	}

	public Host(String inName) {
		name = inName;
	}

	@Override
	public String toString() {
		return "Your host, " + getName();
	}

	public int pickDoorToShow() {
		int skip = (game.contestantWins()) ? (int) (Math.random() * 2) : 0;

		for (int i = 0; i < game.doors.length; i++) {
			if (i != game.getPicked() && game.doors[i] == Game.contents.GOAT && (skip-- <= 0))
				return i;
		}

		return -1;
	}
}