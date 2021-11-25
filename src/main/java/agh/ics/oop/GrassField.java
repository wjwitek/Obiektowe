package agh.ics.oop;

import java.lang.Math;
import java.util.LinkedHashMap;

public class GrassField extends AbstractWorldMap{
    public final LinkedHashMap<Vector2D, Grass> grasses = new LinkedHashMap<>();

    public GrassField(int n){
        super(n);

        int sqr_n = (int)Math.sqrt(n * 10);

        // choose random position for grass
        for (int i=0; i<n; i++){
            int x = (int)(Math.random() * (sqr_n + 1));
            int y = (int)(Math.random() * (sqr_n + 1));
            Vector2D position = new Vector2D(x, y);
            boolean same = true;
            while (same){
                same = this.grasses.containsKey(position);
                x = (int)(Math.random() * (sqr_n + 1));
                y = (int)(Math.random() * (sqr_n + 1));
                position = new Vector2D(x, y);
            }
            this.grasses.put(position, new Grass(position));
        }
    }

    public boolean isOccupied(Vector2D position) {
        return super.isOccupied(position) || this.grasses.containsKey(position);
    }

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
}


