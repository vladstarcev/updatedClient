package application;

import java.io.IOException;

import entities.User;
import interfaces.IController;
import javafx.application.Platform;
import OCSF.*;

public class SchoolClient extends AbstractClient {
	private boolean runOnUi = true;
	public User user;
	public IController controller;

	public SchoolClient(String host, int port) throws IOException {
		super(host, port);
		openConnection();
	}

	public void runOnUiThread(boolean run) {
		runOnUi = run;
	}

	public void handleMessageFromServer(Object msg) {
		if (controller != null) {
			try {
				if (!runOnUi) {
					controller.handleAnswer(msg);
					return;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						controller.handleAnswer(msg);
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}
