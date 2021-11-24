package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class AbstractWorldMap implements IWorldMap{
    protected Vector2D leftCorner;
    protected Vector2D rightCorner;
    public List<Animal> animals = new ArrayList<>();

    public AbstractWorldMap(int width, int height){
        this.leftCorner = new Vector2D(0, 0);
        this.rightCorner = new Vector2D(width, height);
    }

    public AbstractWorldMap(int n){
        int sqr_n = (int)Math.sqrt(n * 10);
        this.leftCorner = new Vector2D(0, 0);
        this.rightCorner = new Vector2D(sqr_n, sqr_n);
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.leftCorner, this.rightCorner);
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
}
