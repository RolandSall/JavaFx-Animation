package hadi;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ParallelTX extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        // Create the Rectangle
        Rectangle rect = new Rectangle(200, 200, Color.RED);
        // Create the HBox
        HBox root = new HBox(rect);
        // Set the Margin for the HBox
        HBox.setMargin(rect, new Insets(50));
        // Set the Style-properties of the HBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Set the Title of the Stage
        stage.setTitle("A Parallel Transition Example");
        // Display the Stage
        stage.show();

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1));
        scaleTransition.setFromX(1.5);
        scaleTransition.setToX(0.2);
        scaleTransition.setFromY(1.5);
        scaleTransition.setToY(0.2);
        // Let the animation run forever
        scaleTransition.setCycleCount(2);
        // Reverse direction on alternating cycles
        scaleTransition.setAutoReverse(true);

        // Set up a Fade Transition
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1));
        fadeTransition.setFromValue(0.20);
        fadeTransition.setToValue(1.0);
        // Let the animation run two times
        fadeTransition.setCycleCount(2);
        // Reverse direction on alternating cycles
        fadeTransition.setAutoReverse(true);

        // Set up a Rotate Transition
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2));
        rotateTransition.setFromAngle(0.0);
        rotateTransition.setToAngle(360.0);
        // Let the animation run two times
        rotateTransition.setCycleCount(2);
        // Reverse direction on alternating cycles
        rotateTransition.setAutoReverse(true);

        // Create and start a Parallel Transition
        ParallelTransition parTransition = new ParallelTransition();
        parTransition.setNode(rect);
        // Add the Children to the ParallelTransition
        parTransition.getChildren().addAll(fadeTransition, rotateTransition,scaleTransition);
        // Let the animation run forever
        parTransition.setCycleCount(PathTransition.INDEFINITE);
        // Play the Animation
        parTransition.play();
    }
}