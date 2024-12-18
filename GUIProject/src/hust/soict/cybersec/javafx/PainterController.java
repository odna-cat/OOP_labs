package hust.soict.cybersec.javafx;

import java.awt.Color;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class PainterController {

    private Color currentColor;

    @FXML
    private VBox drawingAreaPane;

    @FXML
    void penSelected(ActionEvent event) {
        this.currentColor = Color.BLACK;
    }

    @FXML
    void eraseSelected(ActionEvent event) {
        this.currentColor = Color.WHITE;
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(),
                event.getY(), 4, Color.currentColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
