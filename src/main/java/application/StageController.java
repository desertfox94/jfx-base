package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageController extends BaseController {

	private Stage stage;

	private Scene scene;

	@Override
	protected void init() {
	}

	public static <S extends StageController> S load(URL url, Stage stage, String title, Image icon) throws IOException {
		return load(url, stage, title, icon, AppConstants.APP_CSS);
	}

	public static <S extends StageController> S load(URL url, Stage stage, String title, Image icon, String css) throws IOException {
		FXMLLoader loader = new FXMLLoader(url);
		loader.load();
		S controller = loader.getController();
		stage.initStyle(StageStyle.UNDECORATED);
		Decorater decorator = new Decorater(stage, controller.getRoot(), title, icon);
		Scene scene = new Scene(decorator);
		stage.getIcons().add(icon);
		controller.setScene(scene);
		controller.setStage(stage);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		return loader.getController();
	}

	public static <S extends StageController> S load(URL url, Stage stage) throws IOException {
		return load(url, stage, AppConstants.TITLE, new Image(AppConstants.ICON_URL));
	}

	public Stage getStage() {
		return stage;
	}

	void setStage(Stage stage) {
		this.stage = stage;
	}

	public Scene getScene() {
		return scene;
	}

	void setScene(Scene scene) {
		this.scene = scene;
	}

	public void show() {
		stage.show();
	}

	public void showModal() {
		stage.initModality(Modality.APPLICATION_MODAL);
		show();
	}

	public static <S extends StageController> S load(URL url, Stage stage, String title, String css) throws IOException {
		return load(url, stage, title, AppConstants.ICON, css);
	}

}
