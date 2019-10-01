package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class ReflectionEffect extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Text text = new Text(100,100, "JavaFX Programming");
			
			// Initialization of Reflection
			Reflection reflection = new Reflection();
			
			// setting the bottom opacity of the reflection
			reflection.setBottomOpacity(0.2);

			// setting the top opacity of the reflection
			reflection.setTopOpacity(20);

			// setting the top offset of the reflection
			reflection.setTopOffset(20);

			// Setting the fraction of the reflection
			reflection.setFraction(.5);

			// Applying reflection effect to the text
			text.setEffect(reflection);

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
