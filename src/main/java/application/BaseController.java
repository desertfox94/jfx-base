package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public abstract class BaseController {

	@FXML
	public Pane root;

	@FXML
	public void initialize() {
		init();
	}

	@FXML
	protected abstract void init();

	public static BaseController load(URL url) throws IOException {
		FXMLLoader loader = new FXMLLoader(url);
		loader.load();
		return loader.getController();
	}

	public Pane getRoot() {
		return root;
	}

}
