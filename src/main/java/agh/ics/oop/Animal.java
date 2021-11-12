package agh.ics.oop;

public class Animal {
    private MapDirection orientation;
    private Vector2D position;
    private IWorldMap map;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2D(2,2);
    }

    public Animal(IWorldMap map){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2D(2,2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2D initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public String toString() {
        switch (this.orientation) {
            case NORTH -> {return "^";}
            case EAST -> {return ">";}
            case WEST -> {return "<";}
            default ->  {return "v";}
        }
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
            if (this.map.canMoveTo(newPosition)){
                this.position = newPosition;
            }
        }
    }

    public MapDirection getOrientation(){
        return this.orientation;
    }

    public Vector2D getPosition(){
        return this.position;
    }
}
