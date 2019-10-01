package application;

import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecheckAnimation extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("shape Animation");
        Scene scene = new Scene(RectangleAnimation.animateRect());
        stage.setScene(scene);
        stage.show();
    }
}

