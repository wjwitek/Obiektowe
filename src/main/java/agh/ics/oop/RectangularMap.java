package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private final Vector2D leftCorner;
    private final Vector2D rightCorner;
    public List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.leftCorner = new Vector2D(0, 0);
        this.rightCorner = new Vector2D(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2D position) {
        if (this.isOccupied(position)) {
            return false;
        }
        return position.follows(this.leftCorner) && position.precedes(this.rightCorner);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.isOccupied(animal.getPosition())){
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2D position) {
        for (Animal elem: animals){
            if (position.equals(elem.getPosition())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2D position) {
        for (Animal elem: animals){
            if (position.equals(elem.getPosition())){
                return elem;
            }
        }
        return null;
    }

    public String toString(){
        MapVisualizer visualize = new MapVisualizer(this);
        return visualize.draw(this.leftCorner, this.rightCorner);
    }
}
