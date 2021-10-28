package agh.ics.oop;

public class Animal {
    private MapDirection orientation;
    private Vector2D position;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2D(2,2);
    }

    public String toString() {
        return "orientation: " + orientation +
                ", position: " + position;
    }

    public boolean isAt(Vector2D position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        if (direction == MoveDirection.LEFT){
            this.orientation = this.orientation.previous();
        }
        else if (direction == MoveDirection.RIGHT){
            this.orientation = this.orientation.next();
        }
        else {
            Vector2D change = this.orientation.toUnitVector();
            Vector2D newPosition;
            if (direction == MoveDirection.BACKWARD){
                newPosition = this.position.subtract(change);
            }
            else {
                newPosition = this.position.add(change);
            }
            // check if new position is inside the map
            if (newPosition.follows(new Vector2D(0,0)) && newPosition.precedes(new Vector2D(4, 4))){
                this.position = newPosition;
            }
        }
    }
}
