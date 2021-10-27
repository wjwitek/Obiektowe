package agh.ics.oop;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;
    
    public String toString(){
        String result = null;
        switch (this){
            case NORTH -> result = "Północ";
            case SOUTH -> result = "Południe";
            case WEST -> result = "Zachód";
            case EAST -> result = "Wschód";
        }
        return result;
    }

    public MapDirection next(){
        MapDirection result = null;
        switch (this){
            case NORTH -> result = EAST;
            case EAST -> result = SOUTH;
            case SOUTH -> result = WEST;
            case WEST -> result = NORTH;
        }
        return result;
    }

    public MapDirection previous(){
        MapDirection result = null;
        switch (this){
            case NORTH -> result = WEST;
            case WEST -> result = SOUTH;
            case SOUTH -> result = EAST;
            case EAST -> result = NORTH;
        }
        return result;
    }

    public Vector2D toUnitVector(){
        Vector2D result = null;
        switch (this){
            case NORTH -> result = new Vector2D(0, 1);
            case WEST -> result = new Vector2D(1, 0);
            case SOUTH -> result = new Vector2D(0, -1);
            case EAST -> result = new Vector2D(-1, 0);
        }
        return result;
    }
}
