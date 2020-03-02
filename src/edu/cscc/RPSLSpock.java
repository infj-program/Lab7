package edu.cscc;
import java.util.Random;

/**
 * This class provides the bulk of the logic for a computerized version of the
 * game Rock, Paper, Scissors, Lizard, Spock.
 * @author Robert Allen
 */
public class RPSLSpock {

    static Random rand = new Random(System.currentTimeMillis());

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    public static final String LIZARD = "lizard";
    public static final String SPOCK = "spock";

    /**
     * This method tests the validity of the users input.
     * @param pick The user's input
     * @return false If a null value is detected. Returning false will trigger the prompt
     * to enter a valid response.
     * @return ROCK, PAPER, SCISSORS, LIZARD, SPOCK If, after trimming any spaces, the
     * user has entered any of the valid return values - ignoring case.
     */
    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }

    /**
     * This method generates the computer's choice in a game of Rock, Paper, Scissors,
     * Lizard, Spock.
     * @return pick Each possible choice (rock, paper, scissors, lizard, spock) is
     * assigned to a number from 0-4. Using a random number generator, a random
     * integer between 0 and 4 is generated. The choice associated with the generated
     * number is returned as the computer's choice in the game.
     */
    public static String generatePick() {
        String pick = null;
        switch (rand.nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }

    /**
     * This method determines if the computer won the game.
     * @param c_pick The computer's choice for the game.
     * @param h_pick The user's choice for the game.
     * @return true or false The possible conditions for a computer win are checked. If
     * one of the conditions is met, true is returned. Otherwise, false is returned.
     */
    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}