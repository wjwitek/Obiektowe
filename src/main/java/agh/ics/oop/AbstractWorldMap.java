package agh.ics.oop;

import java.util.LinkedHashMap;

public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    public Vector2D leftCorner;
    public Vector2D rightCorner;
    public LinkedHashMap<Vector2D, Animal> animals = new LinkedHashMap<>();

    public AbstractWorldMap(int width, int height) {
        this.leftCorner = new Vector2D(0, 0);
        this.rightCorner = new Vector2D(width, height);
    }

    public AbstractWorldMap(int n) {
        int sqr_n = (int) Math.sqrt(n * 10);
        this.leftCorner = new Vector2D(0, 0);
        this.rightCorner = new Vector2D(sqr_n, sqr_n);
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
        if (this.isOccupied(animal.getPosition()) && !(objectAt(animal.getPosition()) instanceof Grass)) {
            throw new IllegalArgumentException("Cannot add animal to" + animal.getPosition());
        }
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);
        return true;
    }

    public boolean isOccupied(Vector2D position) {
        return animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2D position) {
        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2D oldPosition, Vector2D newPosition){
        Animal temp = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, temp);
    }
}
