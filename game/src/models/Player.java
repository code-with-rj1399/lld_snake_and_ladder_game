package models;

/*
The Player class contains information about individual players,
 including their names and the number of moves.
 It has a relationship of association with the Board class as it uses
  the attributes and methods of the Board class to move the player on the board.
 */
public class Player {

    private final String name;
    private int position;

    public Player(String name, int position){
        this.name = name;
        this.position = position;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void move(int distance){

    }
}