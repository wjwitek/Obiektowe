package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{
    public RectangularMap(int width, int height) {
        super(width, height);
    }

    public String toString(){
        MapVisualizer visualize = new MapVisualizer(this);
        return visualize.draw(this.leftCorner, this.rightCorner);
    }
}
