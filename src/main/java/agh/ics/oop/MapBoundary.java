package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    // assumption: point of this class is only to set map boundaries, so resolving multiple animals on one position is
    // not important
    private SortedSet<Vector2D> animalsX = new TreeSet<>(Vector2D::compareX);
    private SortedSet<Vector2D> animalsY = new TreeSet<>(Vector2D::compareY);
    private SortedSet<Vector2D> grassesX = new TreeSet<>(Vector2D::compareX);
    private SortedSet<Vector2D> grassesY = new TreeSet<>(Vector2D::compareY);

    public void positionChanged(Vector2D oldPosition, Vector2D newPosition) {
        // assumption: only animals change position, grass can be only added or deleted
        animalsX.remove(oldPosition);
        animalsY.remove(oldPosition);

        animalsX.add(newPosition);
        animalsY.add(newPosition);
    }

    public void addObject(Object object){
        if (object instanceof Animal){
            animalsX.add(((Animal) object).getPosition());
            animalsY.add(((Animal) object).getPosition());
        }
        else if (object instanceof Grass){
            grassesX.add(((Grass) object).getPosition());
            grassesY.add(((Grass) object).getPosition());
        }
        else {
            throw new IllegalArgumentException("MapBoundary uses only Grass and Animal");
        }
    }

    public void removeObject(Object object){
        if (object instanceof Animal){
            animalsX.remove(((Animal) object).getPosition());
            animalsY.remove(((Animal) object).getPosition());
        }
        else if (object instanceof Grass){
            grassesX.remove(((Grass) object).getPosition());
            grassesY.remove(((Grass) object).getPosition());
        }
        else {
            throw new IllegalArgumentException("MapBoundary uses only Grass and Animal");
        }
    }

    public Vector2D leftCorner(){
        Vector2D result = new Vector2D(this.animalsX.first().x, this.animalsY.first().y);
        if (this.grassesX.first().x < result.x){
            result.x = this.grassesX.first().x;
        }
        if (this.grassesY.first().y < result.y){
            result.y = this.grassesY.first().y;
        }
        return result;
    }

    public Vector2D rightCorner(){
        Vector2D result = new Vector2D(this.animalsX.last().x, this.animalsY.last().y);
        if (this.grassesX.last().x > result.x){
            result.x = this.grassesX.last().x;
        }
        if (this.grassesY.last().y > result.y){
            result.y = this.grassesY.last().y;
        }
        return result;
    }
}
