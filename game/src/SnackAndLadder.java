import exceptions.GameOverException;
import exceptions.InvalidPositionExceptio;
import models.*;

import java.util.ArrayList;
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
    SnackAndLadder( int boardSize, IDice dice, List<String> playerNames, List<int[]> ladderPositions, List<int[]> snakePositions){
        this.dice = dice;
        List<Player> players = getPlayeres(playerNames);
        List<Snake> snakes = getSnakes(snakePositions);
        List<Ladder> ladders = getLadders(ladderPositions);
        playerQueue = new LinkedList<>(players);
        this.board = new Board(boardSize, snakes,ladders );
    }

    private List<Ladder> getLadders(List<int[]> ladderPositions) {
        List<Ladder> ladders = new ArrayList<>();
        ladderPositions.forEach(position -> {
            if(position.length!=2) throw new InvalidPositionExceptio("Invalid position");
            ladders.add(new Ladder(position[0], position[1]));
        });
        return ladders;
    }

    private List<Snake> getSnakes(List<int[]> snakePositions) {
        List<Snake> snakes = new ArrayList<>();
        snakePositions.forEach(position -> {
            if(position.length!=2) throw new InvalidPositionExceptio("Invalid position");
            snakes.add(new Snake(position[0], position[1]));
        });
        return snakes;
    }

    private List<Player> getPlayeres(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        playerNames.forEach(playerName -> players.add(new Player(playerName)));
        return players;
    }

    public Player getNextPlayerToPlay() throws GameOverException {
        if (playerQueue.size() <= 1)
            throw new GameOverException("Game is already over");
        return playerQueue.poll();
    }

    public void startGame(){
        while(true){
            Player player = getNextPlayerToPlay();
            int roll = dice.roll();
            board.movePlayer(player,roll);
            if(board.checkWinner(player)){
                System.out.println("Player has won : "+ player.getName());
            }
        }
    }
}
