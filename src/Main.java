import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Chad Schadewald
 * Main.java
 * Project 2
 */
public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        primaryStage.setTitle("Welcome to Spelling Checker!");
        primaryStage.setScene(new Scene(root, 400, 375));
        primaryStage.show();
    }
    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
