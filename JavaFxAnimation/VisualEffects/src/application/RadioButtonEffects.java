package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RadioButtonEffects extends PaneDemo {
	// Initialization of Glow
	Glow glow = new Glow();

	// Initialization of Blur
	GaussianBlur gaussianBlur = new GaussianBlur();

	// Initialization of Reflection
	Reflection reflection = new Reflection();

	
	// Instantiating the Lighting class
	Lighting lighting = new Lighting();

	// Instantiating the Shadow class
	DropShadow dropShadow = new DropShadow();

	@Override // Override the getPane() method in the super class
	protected BorderPane getPane() {
		BorderPane pane = super.getPane();

		VBox paneForCheckBoxes = new VBox(20);
		paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5));

		// CheckBox List

		RadioButton rdGlow = new RadioButton("Glow");
		RadioButton rdBlur = new RadioButton("Blur");
		RadioButton rdReflection = new RadioButton("Reflection");
		RadioButton rdLighting = new RadioButton("Lighting");
		RadioButton rdDropShadow = new RadioButton("DropShadow");

		// Condition
		ToggleGroup group = new ToggleGroup();
		rdGlow.setToggleGroup(group);
		rdBlur.setToggleGroup(group);
		rdReflection.setToggleGroup(group);
		rdLighting.setToggleGroup(group);
		rdDropShadow.setToggleGroup(group);

		// Adding To the Pane
		paneForCheckBoxes.getChildren().addAll(rdGlow, rdBlur, rdReflection, rdLighting,rdDropShadow);
		pane.setRight(paneForCheckBoxes);

		EventHandler<ActionEvent> handler = e -> {

			if (rdGlow.isSelected())
				ActivateGlowEffect();

			else if (rdLighting.isSelected())
				ActivateLightingEffect();

			else if (rdBlur.isSelected())
				ActivateBlurEffect();

			else if (rdReflection.isSelected())
				ActivateReflectionEffect();
			
			else if(rdDropShadow.isSelected())
				ActivateDropShadowEffect();

		};

		rdGlow.setOnAction(handler);
		rdBlur.setOnAction(handler);
		rdReflection.setOnAction(handler);
		rdLighting.setOnAction(handler);
		rdDropShadow.setOnAction(handler);

		return pane; // Return a new pane
	}

	private void ActivateLightingEffect() {

		// Instantiating the Light.Distant class
		Light.Distant light = new Light.Distant();

		// Setting the properties of the light source
		light.setAzimuth(100.0);
		light.setElevation(35.0);

		// Setting the source of the light
		lighting.setLight(light);

		// Applying the lighting effect to the text
		text.setEffect(lighting);

	}

	private void ActivateReflectionEffect() {
		// setting the bottom opacity of the reflection
		reflection.setBottomOpacity(0.2);

		// setting the top opacity of the reflection
		reflection.setTopOpacity(10);

		// setting the top offset of the reflection
		reflection.setTopOffset(0.0);

		// Setting the fraction of the reflection
		reflection.setFraction(1);

		// Applying reflection effect to the text
		text.setEffect(reflection);

	}

	private void ActivateGlowEffect() {

		// Setting the intensity of Glow
		glow.setLevel(2);

		// Applying bloom effect to text
		text.setEffect(glow);

	}

	private void ActivateBlurEffect() {

		// Setting the radius of Blur
		gaussianBlur.setRadius(10.5);

		// Applying Blur effect to text
		text.setEffect(gaussianBlur);

	}

	private void ActivateDropShadowEffect() {

		// setting the type of blur for the shadow
		dropShadow.setBlurType(BlurType.GAUSSIAN);

		// Setting color for the shadow
		dropShadow.setColor(Color.BLUEVIOLET);

		// Setting the height of the shadow
		dropShadow.setHeight(10);

		// Setting the width of the shadow
		dropShadow.setWidth(10);

		// Setting the radius of the shadow
		dropShadow.setRadius(0);

		// setting the offset of the shadow
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(7);

		// Setting the spread of the shadow
		dropShadow.setSpread(2);

		// Applying shadow effect to the text
		text.setEffect(dropShadow);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}