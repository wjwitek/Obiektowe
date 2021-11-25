package agh.ics.oop;

public class World {
    public World() {
    }

    public static void main(String[] args) {
        String[] argsTest = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse(argsTest);
        IWorldMap map = new GrassField(10);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) , new Vector2D(8, 5)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}