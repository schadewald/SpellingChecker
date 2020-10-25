import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Chad Schadewald
 * Controller.java
 * Project 2
 */
public class Controller implements Initializable
{
    public MenuBar menuBar;
    public TextArea textArea;

    private String readFile(File file)
    {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(text);
                stringBuilder.append("\n");
            }
        }
        catch (IOException e)
        { e.printStackTrace(); }
        finally
        {
            try
            { bufferedReader.close(); }
            catch (IOException e)
            { e.printStackTrace(); }
        }
        return stringBuilder.toString();
    }
    public void openFile(ActionEvent event)
    {
        System.out.println("Open File Clicked");
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setInitialDirectory(new File("."));
        File file = fileChooser.showOpenDialog(null);
        if(file != null)
            textArea.setText(readFile(file));
    }
    public void saveFile(ActionEvent event) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter("SpellCheckerFile.txt");)
        {
            out.println(textArea.getText());
        }
    }
    public void exitFile(ActionEvent event)
    {
        textArea.clear();
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
