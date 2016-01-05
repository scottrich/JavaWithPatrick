package montyhall;

public class Game {

	public static boolean VERBOSE = false;
	private static int naturalWinners = 0, switchWinners = 0;

	Host fHost;
	Contestant fContestant;

	public enum contents {
		GOAT, CAR
	};

	private int fPicked = -1, fCarLocation = -1, fHostShows = -1;

	public int getHostShows() {
		return fHostShows;
	}

	public void setHostShows(int hostShows) {
		this.fHostShows = hostShows;
	}

	contents[] doors = { contents.GOAT, contents.GOAT, contents.GOAT };

	public Game(Host host, Contestant contestant) {
		fHost = host;
		fHost.setGame(this);
		fContestant = contestant;
		fContestant.setGame(this);
		initialize();
	}

	private void initialize() {
		fCarLocation = (int) (Math.random() * 3);
		doors[fCarLocation] = contents.CAR;
	}

	public boolean contestantWins() {
		return fPicked == fCarLocation;
	}

	public void setPicked(int pick) {
		fPicked = pick;
	}

	public int getPicked() {
		return fPicked;
	}

	public void play() {
		if (VERBOSE)
			System.out.println(this);

		setPicked(fContestant.pickDoor());
		if (VERBOSE)
			System.out.println("Contestant picked door #" + fPicked);

		setHostShows(fHost.pickDoorToShow());
		if (VERBOSE)
			System.out.println("Host shows a goat behind door #" + fHostShows);

		if (VERBOSE)
			System.out.println(contestantWins() ? "Winner!" : "Loser.");
		if (contestantWins())
			naturalWinners++;

		fContestant.switchDoors();
		if (VERBOSE)
			System.out.println("Contestant switches to door #" + fPicked);
		if (contestantWins())
			switchWinners++;

		if (VERBOSE)
			System.out.println("After switching: " + (contestantWins() ? "Winner!" : "Loser.") + "\n");
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("Monty Hall Game: ");
		for (int i = 0; i < doors.length; i++) {
			out.append(doors[i] == contents.CAR ? "Car!" : "Goat");
			if (i < doors.length - 1)
				out.append(",");
		}
		return out.toString();
	}

	public static void main(String[] args) {
		VERBOSE = true;
		naturalWinners = 0;
		switchWinners = 0;

		Host bob = new Host("Bob");
		Contestant alice = new Contestant("Alice");

		for (int i = 0; i < 10000; i++) {
			Game game = new Game(bob, alice);
			game.play();
		}

		System.out.println("Natural winners: " + naturalWinners);
		System.out.println("Switch winners: " + switchWinners);

	}

}
