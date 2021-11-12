import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SimulationEngineTest {
    @Test
    public void startingPositionTest(){
        // check if animals are correctly placed on the map
        String[] argsTest = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse(argsTest);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        List<Animal> animals = engine.animals;
        int n = positions.length;

        // check if they have assigned correct position and orientation
        for (int i=0; i<n; i++){
            assertEquals(MapDirection.NORTH, animals.get(i).getOrientation());
            assertEquals(positions[i], animals.get(i).getPosition());
        }

        // check if animals have different positions pairwise
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i == j){
                    continue;
                }
                assertNotEquals(animals.get(i).getPosition(), animals.get(j).getPosition());
            }
        }
    }

    @Test
    public void finalPositionTest(){
        String[] argsTest = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse(argsTest);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        List<Animal> animals = engine.animals;
        int n = positions.length;
        engine.run();

        Vector2D[] finalPositions = {new Vector2D(2, 0), new Vector2D(3, 5)};
        for (int i=0; i<n; i++){
            assertEquals(finalPositions[i], animals.get(i).getPosition());
        }
    }
}
