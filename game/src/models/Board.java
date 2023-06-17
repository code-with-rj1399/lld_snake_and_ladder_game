package models;

import java.util.List;

/*
 The Board class contains information about the game board,
 including player and snake/ladder positions.
 It has a relationship of association with the Player,
 Snake, and Ladder classes as it uses their attributes and methods
 to move players and check for snakes and ladders.
 */

public class Board {
    int size ;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    public Board(List<Snake> snakes, List<Ladder> ladders){
        this.snakes = snakes;
        this.ladders = ladders;
    }
}
