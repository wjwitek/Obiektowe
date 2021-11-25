import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    // check if movement is correctly restricted
    @Test
    public void canMoveTest(){
        GrassField map = new GrassField(10);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        for (Vector2D elem: positions){
            Animal temp = new Animal(map, elem);
            map.place(temp);
        }

        assertFalse(map.canMoveTo(new Vector2D(2, 2)));
        assertFalse(map.canMoveTo(new Vector2D(3, 4)));
    }

    // check if objects are found correctly
    @Test
    public void objectAtTest(){
        GrassField map = new GrassField(10);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        for (Vector2D elem: positions){
            Animal temp = new Animal(map, elem);
            map.place(temp);
        }

        assertEquals(new Animal(map, new Vector2D(2, 2)), map.objectAt(new Vector2D(2, 2)));
        assertEquals(new Animal(map, new Vector2D(3, 4)), map.objectAt(new Vector2D(3, 4)));
        assertNull(map.objectAt(new Vector2D(1, 1)));
    }

    // check if animal is more important than grass
    @Test
    public void animalImportance(){
        GrassField map = new GrassField(10);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        for (Vector2D elem: positions){
            Animal temp = new Animal(map, elem);
            map.place(temp);
        }
        map.grasses.put(new Vector2D(2, 2), new Grass(new Vector2D(2, 2)));
        assertEquals(new Animal(map, new Vector2D(2, 2)), map.objectAt(new Vector2D(2, 2)));
    }
}
