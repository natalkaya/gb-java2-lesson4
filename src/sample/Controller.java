package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Controller {
    @FXML
    public TextArea messagesArea;
    @FXML
    public Button sendMessageButton;
    @FXML
    public TextField newMessageField;
    @FXML
    public Button closeBtn;

    private void sendMessageAction() {
        messagesArea.appendText(newMessageField.getText() + "\n");
        newMessageField.clear();
    }

    public void sendMessageByButton(ActionEvent actionEvent) {
        sendMessageAction();
    }


    public void sendMessageByEnter(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            sendMessageAction();
        }
    }

    public void closeApp(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            Stage stage = (Stage) closeBtn.getScene().getWindow();
            stage.close();
        });
    }
}
