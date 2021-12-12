package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.InputStream;

public class GuiElementBox {
    VBox box;

    public GuiElementBox(IMapElement object) throws Exception{
        // import image
        InputStream stream = new FileInputStream(object.getPath());
        Image objectImage = new Image(stream, 20, 20, true, true);
        ImageView objectImageView = new ImageView(objectImage);

        // create virtual box and image
        this.box = new VBox(objectImageView);

        // crate label if object is an animal
        if (object instanceof Animal){
            Label position = new Label(object.getPosition().toString());
            box.getChildren().add(position);
        }

        box.setAlignment(Pos.CENTER);
    }
}
