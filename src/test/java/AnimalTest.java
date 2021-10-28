import agh.ics.oop.Animal;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void orientationPositionTest(){
        // check if animal has correct orientation and position after calling move method
        Animal testAnimal = new Animal();
        MoveDirection[] testMoves = {MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.FORWARD};
        String[] correctOutputs = {"orientation: Zachód, position: (2, 2)", "orientation: Północ, position: (2, 2)",
                "orientation: Wschód, position: (2, 2)", "orientation: Wschód, position: (1, 2)",
                "orientation: Wschód, position: (2, 2)"};

        for (int i=0; i<testMoves.length; i++){
            testAnimal.move(testMoves[i]);
            assertEquals(correctOutputs[i], testAnimal.toString());
        }
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
        assertEquals("orientation: Zachód, position: (0, 2)", testAnimal.toString());

        // try going right too far
        testAnimal = new Animal();
        MoveDirection[] testMovesRight = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        for (MoveDirection elem : testMovesRight){
            testAnimal.move(elem);
        }
        assertEquals("orientation: Wschód, position: (4, 2)", testAnimal.toString());

        // try going up too far
        testAnimal = new Animal();
        MoveDirection[] testMovesUp = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        for (MoveDirection elem : testMovesUp){
            testAnimal.move(elem);
        }
        assertEquals("orientation: Północ, position: (2, 4)", testAnimal.toString());

        // try going down too far
        testAnimal = new Animal();
        MoveDirection[] testMovesDown = {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        for (MoveDirection elem : testMovesDown){
            testAnimal.move(elem);
        }
        assertEquals("orientation: Południe, position: (2, 0)", testAnimal.toString());
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
