package src.logic;

public class Player {

    private final GameEngine engine;

    public Player(GameEngine engine) {
        this.engine = engine;
    }





    public int diceRoll(){
        return (int)(Math.random() * 6) + 1;
    }

    public void startMove(){
        move(diceRoll());
    }

    public void move(int rolls){

        //Loop through the linked list, decrementing the roll by 1 each tile. At the end, check for a slide or ladder

    }
}
