import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private MenuBar menuBar;
    @FXML
    public void handleMouseClick(MouseEvent event)
    {
        System.out.println("Testing");
    }
    @FXML
    public void openFile(ActionEvent event)
    {
        System.out.println("Testing Testing Testing");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        File file = fileChooser.showOpenDialog(null);
        if(file != null)
            System.out.println(file.getPath());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        menuBar.setFocusTraversable(true);
    }
}
