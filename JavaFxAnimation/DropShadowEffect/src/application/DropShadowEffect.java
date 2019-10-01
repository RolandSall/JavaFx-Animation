package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class DropShadowEffect extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Text text = new Text(100, 100, "JavaFX Programming");

			// Instantiating the Shadow class
			DropShadow dropShadow = new DropShadow();
			
			// setting the type of blur for the shadow
			dropShadow.setBlurType(BlurType.GAUSSIAN);

			// Setting color for the shadow
			dropShadow.setColor(Color.BLACK);

			// Setting the height of the shadow
			dropShadow.setHeight(10);

			// Setting the width of the shadow
			dropShadow.setWidth(10);

			// Setting the radius of the shadow
			dropShadow.setRadius(7);

			// setting the offset of the shadow
			dropShadow.setOffsetX(50);
			dropShadow.setOffsetY(30);

			// Setting the spread of the shadow
			dropShadow.setSpread(0);

			// Applying shadow effect to the text
			text.setEffect(dropShadow);

			// border property
			BorderPane root = new BorderPane();
			root.getChildren().add(text);
			text.setTextAlignment(TextAlignment.CENTER);

			// Text Property
			text.setFont(Font.font("Verdana", 40));
			text.setFill(Color.RED);

			Scene scene = new Scene(root, 600, 200);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}
