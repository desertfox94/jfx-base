package application.dialogs;

import java.io.IOException;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;

import application.Decorater;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ProgressViewController<T> {

	private static final String VIEW = "ProgressView.fxml";

	@FXML
	private JFXProgressBar progressBar;

	@FXML
	private Label header;

	@FXML
	private Label details;

	@FXML
	private JFXButton cancelButton;

	@FXML
	private GridPane root;

	public void initialize() {
	}

	public Pane getRoot() {
		return root;
	}

	public void start(Task<T> task) {
		start(task, null);
	}

	public void start(Task<T> task, Window owner) {

		progressBar.setProgress(-1);
		progressBar.progressProperty().bind(task.progressProperty());
		header.textProperty().bind(task.titleProperty());
		details.textProperty().bind(task.messageProperty());

		root.layout();

		Stage dialog = new Stage();
		Decorater decorater = new Decorater(dialog, root, "Progress");
		Scene scene = new Scene(decorater);
		scene.getStylesheets().add(ProgressViewController.class.getResource("dialog.css").toExternalForm());
		dialog.setScene(scene);
		dialog.initOwner(owner);
		dialog.initModality(Modality.APPLICATION_MODAL);

		cancelButton.setOnAction(e -> task.cancel(true));
		task.runningProperty().addListener((v, o, n) -> {
			if (o == null) {
				return;
			}
			if (o == true && n == false) {
				dialog.close();
			}
		});
		new Thread(task).start();
		dialog.showAndWait();
	}

	public void setCancelable(boolean cancelable) {
		cancelButton.setDisable(!cancelable);
	}

	public static <S> void show(Task<S> task, EventHandler<WorkerStateEvent> onSucceed, EventHandler<WorkerStateEvent> onFailed) {
		show(task, Optional.ofNullable(onSucceed), Optional.ofNullable(onFailed));
	}

	private static <S> void show(Task<S> task, Optional<EventHandler<WorkerStateEvent>> onSucceed, Optional<EventHandler<WorkerStateEvent>> onFailed) {
		try {
			FXMLLoader loader = new FXMLLoader(ProgressViewController.class.getResource(VIEW));
			loader.load();
			ProgressViewController<S> controller = loader.getController();
			onSucceed.ifPresent(task::setOnSucceeded);
			onFailed.ifPresent(task::setOnFailed);
			controller.start(task);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
