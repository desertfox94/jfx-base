package application.dialogs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import application.StageController;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Dialogs {

	private static final String DIALOG_CSS = resource("dialog.css").toExternalForm();

	private static final String DIALOG_FXML = "Dialog.fxml";

	private static final String ICON_SUCCESS = "success.png";

	private static final String ICON_ERROR = "cancel.png";

	public static void show(String title, String header, String message, String icon) {
		try {
			DialogController controller = StageController.load(resource(DIALOG_FXML), new Stage(), title, DIALOG_CSS);
			controller.setIconImage(new Image(resourceStream(icon)));
			controller.open(header, message);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void success(String title, String header, String message) {
		show(title, header, message, ICON_SUCCESS);
	}

	public static void error(String title, String header, String message) {
		show(title, header, message, ICON_ERROR);
	}

	private static URL resource(String name) {
		return DialogController.class.getResource(name);
	}

	private static InputStream resourceStream(String name) {
		return DialogController.class.getResourceAsStream(name);
	}

}
