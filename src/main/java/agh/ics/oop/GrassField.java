package agh.ics.oop;

import java.lang.Math;
import java.util.LinkedHashMap;

public class GrassField extends AbstractWorldMap{
    public final LinkedHashMap<Vector2D, Grass> grasses = new LinkedHashMap<>();
    public final MapBoundary mapBoundary = new MapBoundary();

    public GrassField(int n){
        super(n);

        int sqr_n = (int)Math.sqrt(n * 10);

        // choose random position for grass
        for (int i=0; i<n; i++){
            int x, y;
            Vector2D position = new Vector2D(0, 0);
            boolean same = true;
            while (same){
                x = (int)(Math.random() * (sqr_n + 1));
                y = (int)(Math.random() * (sqr_n + 1));
                position.modifyY(y);
                position.modifyX(x);
                same = this.grasses.containsKey(position);
            }
            Grass newGrass = new Grass(position);
            this.grasses.put(position, newGrass);
            this.mapBoundary.addObject(newGrass);

        }
    }

//    public boolean isOccupied(Vector2D position) {
//        return super.isOccupied(position) || this.grasses.containsKey(position);
//    }

    public boolean canMoveTo(Vector2D position){
        if (objectAt(position) instanceof Animal){
            return false;
        }
        //update corners
        if (position.x < this.leftCorner.x){
            this.leftCorner.modifyX(position.x);
        }
        if (position.y < this.leftCorner.y){
            this.leftCorner.modifyY(position.y);
        }
        if (position.x > this.rightCorner.x){
            this.rightCorner.modifyX(position.x);
        }
        if (position.y > this.rightCorner.y){
            this.rightCorner.modifyY(position.y);
        }
        return super.canMoveTo(position);
    }

    public Object objectAt(Vector2D position) {
        if (this.animals.containsKey(position)){
            return this.animals.get(position);
        }
        else if (this.grasses.containsKey(position)){
            return this.grasses.get(position);
        }
        return null;
    }

    public boolean place(Animal animal){
        this.mapBoundary.addObject(animal);
        return super.place(animal);
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.mapBoundary.leftCorner(), this.mapBoundary.rightCorner());
    }
}


