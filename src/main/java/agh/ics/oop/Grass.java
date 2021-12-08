package agh.ics.oop;

import java.util.ArrayList;

public class Grass implements IMapElement{
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
