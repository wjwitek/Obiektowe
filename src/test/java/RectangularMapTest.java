import agh.ics.oop.Animal;
import agh.ics.oop.RectangularMap;
import agh.ics.oop.Vector2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    // check if movement is correctly restricted
    @Test
    public void canMoveTest(){
        RectangularMap map = new RectangularMap(10, 5);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        for (Vector2D elem: positions){
            Animal temp = new Animal(map, elem);
            map.place(temp);
        }

        assertTrue(map.canMoveTo(new Vector2D(1, 1)));
        assertFalse(map.canMoveTo(new Vector2D(-1, 0)));
        assertFalse(map.canMoveTo(new Vector2D(2, 2)));
        assertFalse(map.canMoveTo(new Vector2D(3, 4)));
    }

    // check if objects are found correctly
    @Test
    public void objectAtTest(){
        RectangularMap map = new RectangularMap(10, 5);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        for (Vector2D elem: positions){
            Animal temp = new Animal(map, elem);
            map.place(temp);
        }

        assertEquals(new Animal(map, new Vector2D(2, 2)), map.objectAt(new Vector2D(2, 2)));
        assertEquals(new Animal(map, new Vector2D(3, 4)), map.objectAt(new Vector2D(3, 4)));
        assertNull(map.objectAt(new Vector2D(1, 1)));
    }
}
