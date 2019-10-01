package application;
	
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle; 
import javafx.stage.Stage; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 

public class Lighting extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Text text = new Text(100,100, "JavaFX Programming");
			
			Circle circle = new Circle();         
		      
		      //Setting the center of the circle 
		      circle.setCenterX(300.0f); 
		      circle.setCenterY(160.0f); 
		      
		      //Setting the radius of the circle 
		      circle.setRadius(100.0f); 
		      
		      //setting the fill color of the circle 
		      circle.setFill(Color.CORNFLOWERBLUE);   
		       
		      //Instantiating the Light.Distant class
		      Light.Distant light = new Light.Distant(); 
		      
		      //Setting the properties of the light source 
		      light.setAzimuth(45.0); 
		      light.setElevation(30.0);       
		       
		      //Instantiating the Lighting class  
		      Lighting lighting = new Lighting(); 
		      
		      //Setting the source of the light 
		      lighting.setLight(light);  
		      
		      //Applying the lighting effect to the text 
		      text.setEffect(lighting);      
		      
		      //Applying the lighting effect to the circle 
		      circle.setEffect(lighting);

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
