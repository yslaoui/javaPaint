package miniPaint;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Paint extends Application {
    @Override
    public void start(Stage window) {

        BorderPane pane = new BorderPane();
        Canvas canvas = new Canvas(640, 480);
        GraphicsContext context = canvas.getGraphicsContext2D();
        ColorPicker colorPalette = new ColorPicker();

        canvas.setOnMouseDragged(event -> {
            double xPos = event.getX();
            double yPos = event.getY();
            context.setFill(colorPalette.getValue());
            context.fillOval(xPos, yPos, 4, 4);
        });


        pane.setRight(colorPalette);
        pane.setCenter(canvas);

        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(Paint.class);
    }

}
