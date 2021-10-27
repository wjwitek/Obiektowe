import agh.ics.oop.MapDirection;
import agh.ics.oop.Vector2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class vector2DTest {
    @Test
    public void equalsTest(){
        assertTrue(new Vector2D(1, 2).equals(new Vector2D(1, 2)));
        assertFalse(new Vector2D(1, 2).equals(new Vector2D(1, 3)));
        assertFalse(new Vector2D(1, 2).equals(MapDirection.EAST));
    }

    @Test
    public void toStringTest(){
        assertEquals(new Vector2D(1,2).toString(), "(1, 2)");
    }

    @Test
    public void precedesTest(){
        assertTrue(new Vector2D(1,2).precedes(new Vector2D(1, 3)));
        assertTrue(new Vector2D(1,2).precedes(new Vector2D(2, 3)));
        assertFalse(new Vector2D(1,2).precedes(new Vector2D(1, 1)));
    }

    @Test
    public void followsTest(){
        assertTrue(new Vector2D(1,2).follows(new Vector2D(1, 1)));
        assertTrue(new Vector2D(1,2).follows(new Vector2D(0, -1)));
        assertFalse(new Vector2D(1,2).follows(new Vector2D(1, 3)));
    }

    @Test
    public void upperRightTest(){
        assertEquals(new Vector2D(1, 3).upperRight(new Vector2D(3, 1)), new Vector2D(3, 3));
    }

    @Test
    public void lowerLeftTest(){
        assertEquals(new Vector2D(1, 3).lowerLeft(new Vector2D(3, 1)), new Vector2D(1, 1));
    }

    @Test
    public void addTest(){
        assertEquals(new Vector2D(1, 2).add(new Vector2D(1, 1)), new Vector2D(2, 3));
    }

    @Test
    public void subtractTest(){
        assertEquals(new Vector2D(1, 2).subtract(new Vector2D(1, 1)), new Vector2D(0, 1));
    }

    @Test
    public void oppositeTest(){
        assertEquals(new Vector2D(1, 2).opposite(), new Vector2D(-1, -2));
    }
}
