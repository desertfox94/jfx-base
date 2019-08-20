package application;

import java.net.URL;

public class AppController extends StageController {

	private static final String VIEW_FXML = "app.fxml";

	public static final URL VIEW_URL = AppController.class.getResource(VIEW_FXML);

	@Override
	protected void init() {
	}

}
