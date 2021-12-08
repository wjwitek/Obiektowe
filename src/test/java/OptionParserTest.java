import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionParserTest {

    @Test
    public void parseTest(){
        MoveDirection[] correctOutput = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD};
        String[] input = {"r", "forward", "l", "l", "f", "backward"};
        String[] otherInput = {"right", "f", "left", "b"};
        assertArrayEquals(correctOutput, new OptionParser().parse(input));
        assertArrayEquals(correctOutput, new OptionParser().parse(otherInput));
    }

    @Test
    public void illegalArgumentTest(){
        boolean test = true;
        try{
            String[] input = {"r", "forward", "l", "l", "f", "backward"};
            MoveDirection[] parsedInput = new OptionParser().parse(input);
        }
        catch (IllegalArgumentException ex){
            test = false;
        }
        assertFalse(test);
    }
}
