import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.*;
import javafx.stage.Stage;


public class SquareDemo extends Application {

    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;

    @Override
    public void start(Stage primaryStage) {
        // Create the Rectangle
        Rectangle rect = new Rectangle(200, 200, Color.AQUA);

        //Prepare transformable Group container
        SmartGroup group = new SmartGroup();
        group.getChildren().add(rect);

        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.WHITE);
        scene.setCamera(camera);

        //Move to center of the screen
        group.translateXProperty().set(WIDTH / 2);
        group.translateYProperty().set(HEIGHT / 2);


        //Add keyboard control.
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case Z:
                    group.scale(1.2);
                    break;
                case X:
                    group.scale(0.83333333);
                case W:
                    group.translateY(-10);
                    break;
                case S:
                    group.translateY(10);
                    break;
                case Q:
                    group.rotate(10);
                    break;
                case E:
                    group.rotate(-10);
                    break;
                case D:
                    group.translateX(10);
                    break;
                case A:
                    group.translateX(-10);
                    break;
                case F:
                    group.shear(0.5);
                    break;
                case R:
                    group.shear(-0.5);
            }
        });

        primaryStage.setTitle("2D Transform");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    class SmartGroup extends Group {

        Translate tran;
        Rotate rot;
        Scale sca;
        Shear sh;

        Transform t;


        void translateX(int x) {
            tran = new Translate();
            tran.setX(x);
            this.getTransforms().addAll(tran);
        }

        void translateY(int y) {
            tran = new Translate();
            tran.setY(y);
            this.getTransforms().addAll(tran);
        }

        void rotate(int ang) {
            rot = new Rotate();
            rot.setAngle(ang);
            this.getTransforms().addAll(rot);
        }

        void scale(double rate) {
            sca = new Scale();
            sca.setX(rate);
            sca.setY(rate);
            this.getTransforms().addAll(sca);
        }

        void shear(double rate) {
            sh = new Shear(rate, rate);
            this.getTransforms().addAll(sh);
        }


    }
}