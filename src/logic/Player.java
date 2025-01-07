package src.logic;

public class Player {

    public String name;

    public String getName(){
        return this.name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }

    //Is this necessary?
    private final GameEngine engine;

    public Player(GameEngine engine) {
        this.engine = engine;
    }

}
