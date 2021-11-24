package agh.ics.oop;

import java.util.ArrayList;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{
    public ArrayList<Grass> grasses = new ArrayList<>();

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
                same = false;
                for (Grass elem : this.grasses){
                    if (elem.getPosition().equals(position)){
                        same = true;
                        break;
                    }
                }
                x = (int)(Math.random() * (sqr_n + 1));
                y = (int)(Math.random() * (sqr_n + 1));
                position = new Vector2D(x, y);
            }
            this.grasses.add(new Grass(position));
        }
    }

    public boolean isOccupied(Vector2D position) {
        for (Grass elem: this.grasses){
            if (position.equals(elem.getPosition())){
                return true;
            }
        }
        return super.isOccupied(position);
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
        for (Animal elem: this.animals){
            if (position.equals(elem.getPosition())){
                return elem;
            }
        }
        for (Grass elem: this.grasses){
            if (position.equals(elem.getPosition())){
                return elem;
            }
        }
        return null;
    }
}


