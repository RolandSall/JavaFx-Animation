package hadi;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotateTX extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        // Create a Square
        Rectangle rect = new Rectangle(150, 150, Color.RED);

        // Create the HBox
        HBox root = new HBox(rect);
        // Set the Margin for the HBox
        HBox.setMargin(rect, new Insets(80));

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
        stage.setTitle("A Rotate Transition Example");
        // Display the Stage
        stage.show();

        // Set up a Rotate Transition the Rectangle
        RotateTransition trans = new RotateTransition(Duration.seconds(2), rect);
        trans.setFromAngle(0.0);
        trans.setToAngle(360.0);
        // Let the animation run forever
        trans.setCycleCount(RotateTransition.INDEFINITE);
        // Reverse direction on alternating cycles
        trans.setAutoReverse(true);
        // Play the Animation
        trans.play();
    }
}