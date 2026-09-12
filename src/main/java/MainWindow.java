import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

/** Controls the tutorial's main chat window. */
public class MainWindow {
    private final Image userImage = new Image(
            getClass().getResourceAsStream("/images/DaUser.png"));
    private final Image dukeImage = new Image(
            getClass().getResourceAsStream("/images/DaDuke.png"));

    private Duke duke;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox dialogContainer;

    @FXML
    private TextField userInput;

    /** Connects this controller to Duke's response logic. */
    public void setDuke(Duke duke) {
        this.duke = duke;
    }

    @FXML
    private void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage));
        userInput.clear();
    }
}
