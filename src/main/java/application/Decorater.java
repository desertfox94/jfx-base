package application;

import com.jfoenix.controls.JFXDecorator;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Decorater extends JFXDecorator {

	public Decorater(Stage stage, Node node, String title) {
		this(stage, node, title, null);
	}

	public Decorater(Stage stage, Node node, String title, Image icon) {
		super(stage, node, false, false, true);
		btnClose.setFocusTraversable(false);
		btnMin.setFocusTraversable(false);
		setText(title);
		if (icon != null) {
			ImageView iconView = new ImageView(icon);
			iconView.setFitHeight(20);
			iconView.setFitWidth(20);
			graphicContainer.getChildren().add(iconView);
		}
	}

}
