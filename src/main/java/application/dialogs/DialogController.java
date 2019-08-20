package application.dialogs;

import com.jfoenix.controls.JFXButton;

import application.StageController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class DialogController extends StageController {

	@FXML
	private Label header;

	@FXML
	private Label details;

	@FXML
	private ImageView icon;

	@FXML
	private JFXButton okButton;

	@FXML
	private GridPane root;

	private Image iconImage;

	@Override
	public Pane getRoot() {
		return root;
	}

	@Override
	protected void init() {
		okButton.setOnAction((e) -> getStage().hide());
	}

	public void open(String header, String message) {
		this.icon.setImage(iconImage);
		this.header.setText(header);
		details.setText(message);
		root.layout();
		showModal();
	}

	public void setCancelable(boolean cancelable) {
		okButton.setDisable(!cancelable);
	}

	public void setIconImage(Image iconImage) {
		this.iconImage = iconImage;
	}

}
