import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

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
        Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Words.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            hashtable.put(line.hashCode(), line);
        }
        launch(args);
    }
}
