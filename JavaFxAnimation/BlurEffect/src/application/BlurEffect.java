package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class BlurEffect extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Text text = new Text(100,100, "JavaFX Programming \n");
			
			// Initialization of Blur
			GaussianBlur gaussianBlur = new GaussianBlur();
			
			// Setting the radius of Blur
			gaussianBlur.setRadius(12);
			
			BoxBlur boxblur = new BoxBlur();
			boxblur.setHeight(7);					
			boxblur.setWidth(7);				    
			boxblur.setIterations(1);
			
			// Applying boxBlur Blur effect to text
			/*text.setEffect(boxblur);*/
						
			

			// Applying Guassian Blur effect to text
			text.setEffect(gaussianBlur);
			

			//border property 
			BorderPane root = new BorderPane();
			root.getChildren().add(text);
			text.setTextAlignment(TextAlignment.CENTER);
			
		
			
			//Text Property
			 text.setFont(Font.font("Verdana",40));
			 text.setFill(Color.RED);
			 
			 
			Scene scene = new Scene(root,600,200);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
