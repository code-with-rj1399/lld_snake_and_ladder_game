import exceptions.GameOverException;
import models.Board;
import models.IDice;
import models.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

This class acts as the main controller of the game.
It has a composition relationship with the Board, Player, Snake,
 and Ladder classes.
It contains an object of the Board class, an array of Player objects,
 an array of Snake objects, and an array of Ladder objects.
 */
public class SnackAndLadder {

    private final Board board;
    private final IDice dice;
    private final Queue<Player> playerQueue ;
    private
    SnackAndLadder(Board board, IDice dice, List<Player> players){
        this.board = board;
        this.dice = dice;
        playerQueue = new LinkedList<>(players);
    }

    public Player getNextPlayerToPlay() throws GameOverException {
        if (playerQueue.size() <= 1)
            throw new GameOverException("Game is already over");
        return playerQueue.poll();
    }

    public void play(Player player){

    }

}
