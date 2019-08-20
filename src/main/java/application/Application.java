package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			AppController controller = StageController.load(AppController.VIEW_URL, primaryStage);
			controller.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class WindowButtons extends HBox {

		public WindowButtons() {
			Button closeBtn = new Button("X");

			closeBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent actionEvent) {
					Platform.exit();
				}
			});

			this.getChildren().add(closeBtn);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
