import java.util.Random;

public class RPS_Player {
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private String name;

    private static final int ROCK = 0;
    private static final int SCISSORS = 1;
    private static final int PAPER = 2;

    public RPS_Player(String name){
        this.name = name;
        clear();
    }

    public String getName(){
        return name;
    }

    /**
     * Returns the number of games played since a clear() was issued.
     * @return returns the number of games played.
     */
    public int getNumberOfGamesPlayed(){
        return numberOfGamesPlayed;
    }

    /**
     * Returns the number of games won since a clear() was issued.
     * @return returns the number of games won.
     */
    public int getNumberOfGamesWon(){
        return numberOfGamesWon;
    }

    /**
     * Returns the win percentage as number between 0 and 1.
     * @return win percentage as a double.
     */
    public double getWinPercentage(){
        return ((double) numberOfGamesWon / numberOfGamesPlayed);
    }

    /**
     * Starts a new game.
     */
    public void clear(){
        numberOfGamesWon = 0;
        numberOfGamesPlayed = 0;
    }

    /**
     * This player challenges anotherPlayer whereby both players make a
     * random choice of rock, paper, scissors.  A reference to the winning
     * player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player challenge(RPS_Player anotherPlayer){
        Random rand = new Random();
        choice = rand.nextInt(3);
        anotherPlayer.choice = rand.nextInt(3);

        RPS_Player result = null;

        if (choice == ROCK) {
            if (anotherPlayer.choice == SCISSORS) {
                result = new RPS_Player(name);
                numberOfGamesWon++;
            } else if (anotherPlayer.choice == PAPER) {
                result = anotherPlayer;
                anotherPlayer.numberOfGamesWon++;
            }
        } else if (choice == SCISSORS) {
            if (anotherPlayer.choice == ROCK) {
                result = anotherPlayer;
                anotherPlayer.numberOfGamesWon++;
            } else if (anotherPlayer.choice == PAPER) {
                result = new RPS_Player(name);
                numberOfGamesWon++;
            }
        } else {
            if (anotherPlayer.choice == ROCK) {
                result = new RPS_Player(name);
                numberOfGamesWon++;
            } else if (anotherPlayer.choice == SCISSORS) {
                result = anotherPlayer;
                anotherPlayer.numberOfGamesWon++;
            }
        }

        return result;
    }

    /**
     * This player challenges anotherPlayer whereby this player uses the previous
     * choice made and anotherPlayer makes a random choice of rock, paper, scissors.
     * A reference to the winning player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer){



        return challenge(anotherPlayer);
    }

}
