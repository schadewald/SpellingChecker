import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.*;
import java.net.URL;
import java.util.*;

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
    private void saveTextToFile(String content, File file)
    {
        try
        {
            PrintWriter out = new PrintWriter(file);
            out.println(content);
            out.close();
        }
        catch (FileNotFoundException e)
        { e.printStackTrace(); }
    }
    public void openFile(ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setInitialDirectory(new File("."));
        File file = fileChooser.showOpenDialog(null);
        if(file != null)
            textArea.setText(readFile(file));
    }
    public void saveFile(ActionEvent event) throws FileNotFoundException
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showSaveDialog(null);
        if (file != null)
        {
            saveTextToFile(textArea.getText(), file);
        }
    }
    public void exitFile(ActionEvent event)
    {
        textArea.clear();
    }
    public void spellCheck(ActionEvent event)
    {
        if (textArea.getText().equals(""))
        {
            System.out.println("Blank Input."); //TODO: add action
        }
        List<String> words;
        String regex = "[!._,'@? \n]";
        String[] splitString = textArea.getText().split(regex);
        words = new ArrayList<>(Arrays.asList(splitString));
        words.removeAll(Arrays.asList("", null));
        for (String word: words)
        {
            System.out.println(word);
        }
        System.out.println(words.size());
        System.out.println("Spell Check Clicked");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        menuBar.setFocusTraversable(true);
    }
}
