package application;
import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BallAnimation extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Ball-Animation");
        Ball ball = new Ball(500, 400, 300, 200, 50, 3, 2, 20);
        Scene scene = new Scene(ball.animateBall());
        stage.setScene(scene);
        stage.show();
    }
}

