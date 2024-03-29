package application;

import java.util.Random; 

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class RectangleAnimation{

    public static Pane animateRect() {

        Random random = new Random();
        Pane animationPane = new Pane();
        animationPane.setPrefSize(500,200);
        Rectangle rect = new Rectangle(75, 75, 100, 50);
        animationPane.getChildren().add(rect);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        
        
        
        
        KeyValue kVMoveX = new KeyValue(rect.xProperty(), random.nextInt(200) + 200);
        KeyValue kVRotate = new KeyValue(rect.rotateProperty(), random.nextInt(1) + 180);
        KeyValue kVArcHeight = new KeyValue(rect.arcHeightProperty(), 60);
        KeyValue kVArcWidth = new KeyValue(rect.arcWidthProperty(), 100);
        
        KeyFrame keyFrame = new KeyFrame(Duration.millis(random.nextInt(10) + 2000), 
                		kVMoveX,
                		kVRotate, kVArcHeight,
                		kVArcWidth);


        

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        

        return animationPane;
    }
}