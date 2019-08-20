package application;

import javafx.scene.image.Image;

public interface AppConstants {

	public static final String APP_CSS = Application.class.getResource("app.css").toExternalForm();

	public static final String TITLE = "Application";

	public static final String ICON_RELATIVE_PATH_PNG = "img/appicon.png";

	public static final String ICON_URL = Application.class.getResource(ICON_RELATIVE_PATH_PNG).toExternalForm();

	public static final Image ICON = new Image(Application.class.getResourceAsStream(ICON_RELATIVE_PATH_PNG));

}
