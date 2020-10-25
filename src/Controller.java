import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private MenuBar menuBar;
    public TextArea textArea;
    public void openFile(ActionEvent event)
    {
        System.out.println("Open File Clicked");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        File file = fileChooser.showOpenDialog(null);
        if(file != null)
            System.out.println(file.getPath());
    }
    public void saveFile(ActionEvent event)
    {
        System.out.println("Save File Clicked");
//        FileWriter fw = new FileWriter()
    }
    public void exitFile(ActionEvent event)
    {
        System.out.println("Exit File Clicked");
    }
    public void spellCheck(ActionEvent event)
    {
        System.out.println("Spell Check Clicked");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        menuBar.setFocusTraversable(true);
    }
}
