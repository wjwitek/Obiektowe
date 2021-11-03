import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void orientationTest(){
        // check if animal has correct orientation calling move method
        Animal testAnimal = new Animal();
        assertEquals(MapDirection.NORTH, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, testAnimal.getOrientation());
    }

    @Test
    public void positionTest(){
        Animal testAnimal = new Animal();

        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2D(1, 2), testAnimal.getPosition());

        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2D(1, 1), testAnimal.getPosition());

        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2D(2, 1), testAnimal.getPosition());
    }

    @Test
    public void mapRangeTest(){
        // check if animal stays inside map
        Animal testAnimal = new Animal();
        // try going left too far
        MoveDirection[] testMovesLeft ={MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        for (MoveDirection elem : testMovesLeft){
            testAnimal.move(elem);
        }
        assertEquals(new Vector2D(0, 2), testAnimal.getPosition());

        // try going right too far
        testAnimal = new Animal();
        MoveDirection[] testMovesRight = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        for (MoveDirection elem : testMovesRight){
            testAnimal.move(elem);
        }
        assertEquals(new Vector2D(4, 2), testAnimal.getPosition());

        // try going up too far
        testAnimal = new Animal();
        MoveDirection[] testMovesUp = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        for (MoveDirection elem : testMovesUp){
            testAnimal.move(elem);
        }
        assertEquals(new Vector2D(2, 4), testAnimal.getPosition());

        // try going down too far
        testAnimal = new Animal();
        MoveDirection[] testMovesDown = {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        for (MoveDirection elem : testMovesDown){
            testAnimal.move(elem);
        }
        assertEquals(new Vector2D(2, 0), testAnimal.getPosition());
    }

    @Test
    public void moveWithParser(){
        MoveDirection[] testMoves = new OptionParser().parse(new String[]{"f", "l", "x", "b"});
        Animal testAnimal = new Animal();
        for (MoveDirection elem : testMoves){
            testAnimal.move(elem);
        }
        assertEquals("orientation: Zachód, position: (3, 3)", testAnimal.toString());
    }
}
