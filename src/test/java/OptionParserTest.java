import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionParserTest {

    @Test
    public void parseTest(){
        MoveDirection[] correctOutput = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD};
        String[] input = {"r", "gsf", "forward", "lekd", "l", "sdfj", "backward"};
        String[] otherInput = {"right", "f", "left", "b", "v", "g"};
        assertArrayEquals(correctOutput, new OptionParser().parse(input));
        assertArrayEquals(correctOutput, new OptionParser().parse(otherInput));
    }
}
