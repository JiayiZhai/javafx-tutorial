import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/** Displays one message and its speaker image. */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;

    @FXML
    private ImageView displayPicture;

    private DialogBox(String message, Image image) {
        FXMLLoader fxmlLoader = new FXMLLoader(
                DialogBox.class.getResource("/view/DialogBox.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load dialog box FXML.", exception);
        }
        dialog.setText(message);
        displayPicture.setImage(image);
    }

    /** Creates a dialog box for a user message. */
    public static DialogBox getUserDialog(String text, Image image) {
        return new DialogBox(text, image);
    }

    /** Creates a flipped dialog box for a Duke response. */
    public static DialogBox getDukeDialog(String text, Image image) {
        DialogBox dialogBox = new DialogBox(text, image);
        dialogBox.flip();
        return dialogBox;
    }

    private void flip() {
        ObservableList<Node> children = FXCollections.observableArrayList(getChildren());
        Collections.reverse(children);
        getChildren().setAll(children);
        setAlignment(Pos.TOP_LEFT);
        dialog.getStyleClass().add("reply-label");
    }
}
