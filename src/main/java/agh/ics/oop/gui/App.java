package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.LinkedHashMap;

public class App extends Application {
    // important constants
    private final int CELL_WIDTH = 40;
    private final int CELL_HEIGHT = 40;
    private int height;
    private int width;
    private Vector2D leftCorner;
    private Vector2D rightCorner;
    public GridPane gridPane;
    private GrassField map;

    @Override
    public void start(Stage primaryStage) throws Exception{
        // test simulation arguments
        init(primaryStage);

        //Platform.runLater(Thread.currentThread());
    }

    public void init(Stage primaryStage) throws Exception {
        // test simulation arguments
        String[] argsTest = {"f", "b", "r", "r", "r", "r"};
        MoveDirection[] directions = new OptionParser().parse(argsTest);
        map = new GrassField(10);
        Vector2D[] positions = {new Vector2D(2, 2), new Vector2D(3, 4), new Vector2D(8, 5)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions, this);

        setMapParameters();
        initGridPane();

        Scene scene = new Scene(gridPane, (width + 1) * CELL_WIDTH, (height + 1) * CELL_HEIGHT);

        drawNewGrid();

        Thread engineThread = new Thread(() -> {
            for (int i=0; i < argsTest.length; i++) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                    System.exit(1);
                }

                // UI update is run on the Application thread
                Platform.runLater(engine);
            }
        });

        engineThread.setDaemon(true);
        engineThread.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label getLabel(String text){
        Label num = new Label(text);
        num.setMinHeight(CELL_HEIGHT);
        num.setMinWidth(CELL_WIDTH);
        num.setAlignment(Pos.CENTER);
        return num;
    }

    private void initGridPane() {
        gridPane = new GridPane();
        gridPane.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        gridPane.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));

        // add column constraints
        for (int i = 0; i < width; i++){
            ColumnConstraints column = new ColumnConstraints(CELL_WIDTH);
            gridPane.getColumnConstraints().add(column);
        }

        // add row constraints
        for (int i = 0; i < height + 1; i++){
            RowConstraints row = new RowConstraints(CELL_HEIGHT);
            gridPane.getRowConstraints().add(row);
        }
    }

    private void setGrass() throws Exception{
        LinkedHashMap<Vector2D, Grass> grasses = map.grasses;

        for (Vector2D key : grasses.keySet()){
            if (!(map.isOccupied(key))){
                gridPane.add(new GuiElementBox(grasses.get(key)).box, relativeX(key.x), relativeY(key.y), 1, 1);
            }
        }
    }

    private void setAnimals() throws Exception{
        LinkedHashMap<Vector2D, Animal> animals = map.animals;

        for (Vector2D key : animals.keySet()){
            gridPane.add(new GuiElementBox(animals.get(key)).box, relativeX(key.x), relativeY(key.y), 1, 1);
        }
    }

    private int relativeX(int x){ return x - leftCorner.x + 1; }

    private int relativeY(int y){ return height + leftCorner.y - y; }

    private void setMapParameters(){
        leftCorner = map.mapBoundary.leftCorner();
        rightCorner = map.mapBoundary.rightCorner();

        height = rightCorner.y - leftCorner.y + 1;
        width = rightCorner.x - leftCorner.x + 1;
    }

    public void drawNewGrid() throws Exception {
        gridPane.setGridLinesVisible(false);
        gridPane.getChildren().clear();

        // add column and row numbers
        gridPane.add(getLabel("y\\x"),0, 0, 1, 1);

        for (int i = leftCorner.x; i <= rightCorner.x; i++){
            gridPane.add(getLabel(Integer.toString(i)), relativeX(i), 0, 1, 1);
        }
        for (int i = leftCorner.y; i <= rightCorner.y; i++){
            gridPane.add(getLabel(Integer.toString(i)), 0, relativeY(i), 1, 1);
        }

        gridPane.setGridLinesVisible(true);

        // add grass
        setGrass();

        // add animals
        setAnimals();
    }
}
