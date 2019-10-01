import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;


public class BoxDemo extends Application {

    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;

    @Override
    public void start(Stage primaryStage) {
        //Create box
        Box box = new Box(100, 20, 50);
        PhongMaterial pm = new PhongMaterial();

        pm.setDiffuseColor(Color.PALEGOLDENROD);
        box.setMaterial(pm);

        //Prepare transformable Group container
        SmartGroup group = new SmartGroup();
        group.getChildren().add(box);

        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        //Move to center of the screen
        group.translateXProperty().set(WIDTH / 2);
        group.translateYProperty().set(HEIGHT / 2);
        group.translateZProperty().set(-1200);

        //Add keyboard control.
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case A:
                    group.translateX(-10);
                    break;
                case D:
                    group.translateX(+10);
                    break;
                case W:
                    group.translateY(-10);
                    break;
                case S:
                    group.translateY(10);
                    break;
                case Z:
                    group.translateZ(-10);
                    break;
                case X:
                    group.translateZ(10);
                    break;
                case I:
                    group.rotateByX(10);
                    break;
                case K:
                    group.rotateByX(-10);
                    break;
                case J:
                    group.rotateByY(10);
                    break;
                case L:
                    group.rotateByY(-10);
                    break;
                case O:
                    group.rotateByZ(10);
                    break;
                case U:
                    group.rotateByZ(-10);
                    break;
                case R:
                    group.scale(1.1);
                    break;
                case F:
                    group.scale(0.91);
                    break;


            }
        });

        primaryStage.setTitle("3D Transform");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    class SmartGroup extends Group {

        Rotate r;
        Translate tran;
        Scale sca;
        Transform t = new Rotate();

        void rotateByX(int ang) {
            r = new Rotate(ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang) {
            r = new Rotate(ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByZ(int ang) {
            r = new Rotate(ang, Rotate.Z_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

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
        void translateZ(int z) {
            tran = new Translate();
            tran.setZ(z);
            this.getTransforms().addAll(tran);
        }

        void scale(double rate) {
            sca = new Scale();
            sca.setX(rate);
            sca.setY(rate);
            sca.setZ(rate);
            this.getTransforms().addAll(sca);
        }
    }
}