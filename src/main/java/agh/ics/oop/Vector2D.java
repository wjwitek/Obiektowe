package agh.ics.oop;

import java.util.Objects;

public class Vector2D {
    public int x;
    public int y;

    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean precedes(Vector2D other){
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2D other){
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2D upperRight(Vector2D other){
        int x = Math.max(this.x, other.x);
        int y = Math.max(this.y, other.y);
        return new Vector2D(x, y);
    }

    public Vector2D lowerLeft(Vector2D other){
        int x = Math.min(this.x, other.x);
        int y = Math.min(this.y, other.y);
        return new Vector2D(x, y);
    }

    public Vector2D add(Vector2D other){
        int x = this.x + other.x;
        int y = this.y + other.y;
        return new Vector2D(x, y);
    }

    public Vector2D subtract(Vector2D other){
        int x = this.x - other.x;
        int y = this.y - other.y;
        return new Vector2D(x, y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2D that))
            return false;
        return this.x == that.x && this.y == that.y;
    }

    public Vector2D opposite(){
        int x = -this.x;
        int y = -this.y;
        return new Vector2D(x, y);
    }

    public void modifyX(int newX){
        this.x = newX;
    }

    public void modifyY(int newY){
        this.y = newY;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.x, this.y);
    }
}
