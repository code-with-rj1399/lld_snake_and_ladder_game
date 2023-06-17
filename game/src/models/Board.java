package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 The Board class contains information about the game board,
 including player and snake/ladder positions.
 It has a relationship of association with the Player,
 Snake, and Ladder classes as it uses their attributes and methods
 to move players and check for snakes and ladders.
 */

public class Board {
    public static int size ;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    private Map<Integer, Player> playerPositions;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders){
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        playerPositions = new HashMap<>();
    }

    public void movePlayer(Player player, int distance){

    }

    public boolean checkWinner(Player player){
        return player.getPosition()==size;
    }
}
