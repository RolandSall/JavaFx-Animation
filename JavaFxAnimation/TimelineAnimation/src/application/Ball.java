package application;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball {

    private Random rnd;
    private int paneWidth, paneHeight;
    private int startPositionX, startPositonY, radius;
    private Color color;
    private int xAxisMovement, yAxisMovement;
    private final int dx_start, dy_start;
    private int intervall;
    private Circle circle;
    private Pane animationPane;

    public Ball(int paneWidth, int paneHeight, int startPositionX,
    		int startPoistionY, int radius, int dx, int dy, 
    		int intervall) {

    	rnd = new Random();
        this.paneWidth = paneWidth;
        this.paneHeight = paneHeight;
        this.startPositionX = startPositionX;
        this.startPositonY = startPoistionY;
        this.radius = radius;
        this.color = new Color(rnd.nextDouble(), rnd.nextDouble(), rnd.nextDouble(), 1);
        this.xAxisMovement = dx;
        this.yAxisMovement = dy;
        this.dx_start = dx;
        this.dy_start = dy;
        this.intervall = intervall;
    }

    public Pane animateBall() {
        animationPane = new Pane();
        animationPane.setPrefSize(paneWidth, paneHeight);
        circle = new Circle(startPositionX, startPositonY, radius, color);
        Timeline timeline = new Timeline();
        timeline.stop();
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame moveBall = new KeyFrame(Duration.millis(intervall), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (((circle.getCenterX() + xAxisMovement < radius) && (xAxisMovement < 0)) || 
                		((circle.getCenterX() + xAxisMovement > animationPane.getWidth() - radius) && (xAxisMovement > 0))) {
                    xAxisMovement = -xAxisMovement;
                }
                 circle.setCenterX(circle.getCenterX() + xAxisMovement);
                 						
                
                if (((circle.getCenterY() + yAxisMovement < radius) && (yAxisMovement < 0)) || 
                		((circle.getCenterY() + yAxisMovement > animationPane.getHeight() - radius) && (yAxisMovement > 0))) {
                    yAxisMovement = -yAxisMovement;
                }
                circle.setCenterY(circle.getCenterY() + yAxisMovement);
            }
        });

        timeline.getKeyFrames().add(moveBall);
        timeline.play();

        HBox hBox = navigateAnimation(timeline);
        animationPane.getChildren().addAll(circle, hBox);
        return animationPane;
    }

    private HBox navigateAnimation(Timeline tl) {
        HBox hBox = new HBox();
        hBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        Label status = new Label("Bouncing Ball.");
        
        Button play = new Button("Start"), pause =
        		new Button("Pause"), stop 
        		= new Button("Stop"), restart
        		= new Button("Restart");
        
        play.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tl.play();
                status.setText("Play Bouncing Balls.");
            }
        });
        /*  The same for the rest of the buttons */
        
        pause.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tl.pause();
                status.setText("Pause Bouncing Balls.");
            }
        });
        
        stop.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tl.stop();
                circle.setCenterX(startPositionX);
                circle.setCenterY(startPositonY);
                xAxisMovement = dx_start;
                yAxisMovement = dy_start;
                status.setText("Stop Bouncing Balls.");
            }
        });
        restart.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                circle.setCenterX(startPositionX);
                circle.setCenterY(startPositonY);
                xAxisMovement = dx_start;
                yAxisMovement = dy_start;
                tl.playFromStart();
                status.setText("Restart Boucing Balls.");
            }
        });

        hBox.getChildren().addAll(play, pause, stop, restart, status);

        return hBox;
    }
}



















