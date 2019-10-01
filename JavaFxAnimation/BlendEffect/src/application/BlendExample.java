package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.paint.Color;

public class BlendExample extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		//Creating Circles
		Circle circle1 = new Circle(400, 400, 120);
		Circle circle2 = new Circle(300, 300, 120);
		Circle circle3 = new Circle(200, 200, 120);
		
		//Filling the circles
		circle1.setFill(Color.RED);
		circle2.setFill(Color.GREY);
		circle3.setFill(Color.YELLOW);
		
		
		//Creating the Blend 
		Blend blend = new Blend();
		blend.setMode(BlendMode.SRC_OVER);
		
		ColorInput color = new ColorInput(200, 200, 230, 230, Color.LIMEGREEN);  
		blend.setTopInput(color);  
		
		
		circle1.setEffect(blend);
		circle2.setEffect(blend);
		circle3.setEffect(blend);
		
		
		Group root = new Group(circle1,circle2,circle3);
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setTitle("Blend Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}