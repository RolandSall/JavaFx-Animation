package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
 

public class GlowEffect extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Text text = new Text(100,100, "JavaFX Programming");
			
			
			// Initialization of Glow
			Glow glow = new Glow();
			
			// setting the level of intensity
			glow.setLevel(0.5);
			
			//Applying glow effect to the text
			text.setEffect(glow);

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
