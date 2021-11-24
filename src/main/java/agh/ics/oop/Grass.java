package agh.ics.oop;

public class Grass {
    private final Vector2D position;

    public Grass(Vector2D pos){
        this.position = pos;
    }

    public Vector2D getPosition(){
        return this.position;
    }

    public String toString(){
        return "*";
    }
}
