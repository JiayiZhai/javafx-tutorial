import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/** Displays the JavaFX tutorial application. */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("/view/MainWindow.fxml"));
        AnchorPane mainLayout = fxmlLoader.load();
        MainWindow mainWindow = fxmlLoader.getController();
        mainWindow.setDuke(new Duke());
        Scene scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.setTitle("Duke");
        stage.setResizable(true);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);
        stage.show();
    }
}
