package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PaneDemo extends Application {
	
protected Text text = new Text(100,100, "JavaFX Programming");
	 	
	 BorderPane getPane() {	
	 BorderPane pane = new BorderPane();
	 Pane paneForText = new Pane();
	 text.setTextAlignment(TextAlignment.CENTER);
	 paneForText.getChildren().add(text);
	 pane.setCenter(paneForText);
	 pane.setCenter(text);
	 text.setFont(Font.font("Verdana",40));
	 text.setFill(Color.RED);
		 return pane;
	 }

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		
		Scene scene = new Scene(getPane(), 800, 300);
		primaryStage.setTitle("Visual Effect Demo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); 
		text.requestFocus();
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}