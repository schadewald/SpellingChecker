import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();

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
    private void hashtableBuilder() throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Words.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            hashtable.put(line.hashCode(), line);
        }
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
    public void spellCheck(ActionEvent event) throws IOException
    {
        if (textArea.getText().equals(""))
        {
            Alert blankInput = new Alert(Alert.AlertType.ERROR);
            blankInput.setContentText("Nothing To Spell Check!");
            blankInput.setTitle("Blank Input");
            blankInput.show();
        }
        hashtableBuilder();
        List<String> words;
        String regex = "[!._,'@? \n]";
        String[] splitString = textArea.getText().split(regex);
        words = new ArrayList<>(Arrays.asList(splitString));
        words.removeAll(Arrays.asList("", null));
        String textAreaReturn = "";
        for (String word: words)
        {
            textAreaReturn = textAreaReturn.concat(word + " ");
        }
        textArea.setText(textAreaReturn);
        Alert misspelledAlert = new Alert(Alert.AlertType.ERROR);
        for (String word: words)
        {
            word = word.toLowerCase();
            int stringHash = word.hashCode();
            if (hashtable.get(stringHash) == null)
            {
                misspelledAlert.setContentText("\"" + word + "\" is misspelled.");
                misspelledAlert.setTitle("Misspelled Word!");
                misspelledAlert.showAndWait();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        menuBar.setFocusTraversable(true);
    }
}
