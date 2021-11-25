package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    final private MoveDirection[] moves;
    final private IWorldMap map;
    public final List<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2D[] animals){
        this.moves = moves;
        this.map = map;

        // add animals to the map
        for (Vector2D elem: animals){
            Animal temp = new Animal(map, elem);
            if (map.place(temp)){
                this.animals.add(temp);
            }
        }

        System.out.println(this.map);
    }

    @Override
    public void run() {
        int numOfMoves = moves.length;
        int n = this.animals.size();
        for (int i=0; i<numOfMoves; i++){
            this.animals.get(i % n).move(moves[i]);
            System.out.println(this.map);
        }
    }
}
