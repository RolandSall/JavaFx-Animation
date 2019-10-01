package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class TextFieldDemo extends RadioButtonColors {

	@Override
	protected BorderPane getPane(){
		
		BorderPane pane = super.getPane();
		//Pane For the text field above
		BorderPane paneForTextField = new BorderPane();
		
		//Design
		paneForTextField.setPadding(new Insets(10,10,10,10));		
		paneForTextField.setLeft(new Label("Enter a new message"));
		
		//Pane for the secret text field below
		BorderPane paneForTextFieldSecret = new BorderPane();
				
		//Design
		paneForTextFieldSecret.setPadding(new Insets(10,10,10,10));		
		paneForTextFieldSecret.setLeft(new Label("Enter a hidden message"));
		
		
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(tf);
		pane.setTop(paneForTextField);
		
	
		PasswordField tf1 = new PasswordField();
		tf1.setAlignment(Pos.BASELINE_LEFT);
		paneForTextFieldSecret.setCenter(tf1);
		pane.setBottom(paneForTextFieldSecret);
		
		tf.setOnAction(e-> text.setText(tf.getText()));
		tf1.setOnAction(e-> text.setText(tf1.getText()));
		
		return pane;
		
		
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	
}
