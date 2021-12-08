package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{
    public RectangularMap(int width, int height) {
        super(width, height);
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.leftCorner, this.rightCorner);
    }
}
