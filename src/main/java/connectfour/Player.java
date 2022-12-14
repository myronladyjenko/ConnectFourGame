package connectfour;

/**
 * This class represents a player for the ConnectFour game. The purpose of this class is 
 * to know information about current player's turn. The class provides methods to access information
 * about player and switch between players.
 * 
 * @author Myron Ladyjenko
 */
public class Player {
        private char playerTurn;

    /**
     * This is an empty constructor used to initialize private members of the class to 
     * the player, who will start the game (randomly selects either 'X' or 'O').
     */
    public Player() {
        setFirstTurn();
    }

    /**
     * This is an overloaded constructor used to set player turn to be the player passed in
     * as a prameter
     * @param currPLayerTurn this is current player to make a turn
     */
    public Player(char currPLayerTurn) {
        setCurrentTurn(currPLayerTurn);
    }

    /**
     * This method sets the next players turn 'X' or 'O' into the variable playerTurn. 
     * If the current turn is X, set the current turn to O, otherwise set the current turn to X
     * 
     * @param currTurn The current turn of the game.
     */
    public void updateTurn(char currTurn) {
        if (currTurn == 'X') {
            setCurrentTurn('O');
        } else {
            setCurrentTurn('X');
        }
    }

    /**
     * This function returns the current player's turn
     * 
     * @return The char playerTurn variable is being returned.
     */
    public char getTurn() {
        return playerTurn;
    }

    private void setFirstTurn() {
        int max = 2;
        int min = 1;
        int range = max - min + 1;

        int rand = (int)(Math.random() * range) + min;
        if (rand == 1) {
            setCurrentTurn('X');
        } else {
            setCurrentTurn('O');
        }
    }

    private void setCurrentTurn(char currPlayerTurn) {
        playerTurn = currPlayerTurn;
    }

    public String toString() {
        return "Current player is: " + Character.toString(getTurn());
    }
    
}
