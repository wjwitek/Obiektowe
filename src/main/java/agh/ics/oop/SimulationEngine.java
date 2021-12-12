package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{
    final private MoveDirection[] moves;
    public final List<Animal> animals = new ArrayList<>();
    private final App app;
    private int i = 0;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2D[] animals, App app){
        this.moves = moves;
        this.app = app;

        // add animals to the map
        for (Vector2D elem: animals){
            Animal temp = new Animal(map, elem);
            if (map.place(temp)){
                this.animals.add(temp);
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Thread started.");
        int n = this.animals.size();
        this.animals.get(i % n).move(moves[i]);
        try {
            this.app.drawNewGrid();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        i ++;
    }

//    @Override
//    public void run() {
//        System.out.println("Thread started.");
//        int n = this.animals.size();
//        for (int i=0; i<moves.length; i++){
//            try {
//                Thread.sleep(1500);
//            } catch (InterruptedException ex) {
//                System.out.println(ex.getMessage());
//                System.exit(1);
//            }
//            this.animals.get(i % n).move(moves[i]);
//            try {
//                this.app.drawNewGrid();
//            }
//            catch (Exception ex){
//                System.out.println(ex.getMessage());
//                System.exit(1);
//            }
//        }
//        //i ++;
//    }
}
