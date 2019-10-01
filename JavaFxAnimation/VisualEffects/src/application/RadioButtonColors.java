package application;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RadioButtonColors extends RadioButtonEffects {

	protected BorderPane getPane() {
		BorderPane pane = super.getPane();

		VBox paneForRadioButtons = new VBox(20);
		paneForRadioButtons.setPadding(new Insets(4, 4, 4, 4));
		
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbGreen = new RadioButton("Green");
		RadioButton rbBlue = new RadioButton("blue");
		RadioButton rbBlack = new RadioButton("Black");
		paneForRadioButtons.getChildren().addAll(rbRed,rbGreen,rbBlue,rbBlack);
		pane.setLeft(paneForRadioButtons);
		
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		rbBlue.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		
		rbRed.setOnAction(e-> {
			if(rbRed.isSelected()){
				text.setFill(Color.RED);
			}
		});
		
		rbGreen.setOnAction(e-> {
			if(rbGreen.isSelected()){
				text.setFill(Color.GREEN);
			}
		});
		
		rbBlue.setOnAction(e-> {
			if(rbBlue.isSelected()){
				text.setFill(Color.BLUE);
			}
		});
		
		rbBlack.setOnAction(e-> {
			if(rbBlack.isSelected()){
				text.setFill(Color.BLACK);
			}
		});
		
		
		return pane;
	}
	public static void main(String[] args){
		Application.launch(args);
	}
}
