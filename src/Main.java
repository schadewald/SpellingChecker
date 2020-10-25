import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception //TODO:: add catch
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        MenuItem openFileItem = createOpenFileItem();
        MenuItem saveFileItem = createSaveFileItem();
        MenuItem exitItem = createExitItem();
        fileMenu.getItems().addAll(openFileItem, saveFileItem, exitItem);
        menuBar.getMenus().addAll(fileMenu, editMenu);

        primaryStage.setTitle("Welcome to Spelling Checker!");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    private MenuItem createOpenFileItem()
    {
        MenuItem openFileItem = new MenuItem("Open");
        openFileItem.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new File("."));
                File file = fileChooser.showOpenDialog(null);
                if(file != null)
                    System.out.println(file.getPath());
            }
        });
        return openFileItem;
    }
    private MenuItem createSaveFileItem()
    {
        MenuItem createSaveItem = new MenuItem("Save");
        createSaveItem.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Save Clicked!");
            }
        });
        return createSaveItem;
    }
    private MenuItem createExitItem()
    {
        MenuItem createExitItem = new MenuItem("Exit");
        createExitItem.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Exit Clicked!");
            }
        });
        return createExitItem;
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
