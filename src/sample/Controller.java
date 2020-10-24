package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Button Search;

    @FXML
    public TextField SearchedWord;

    @FXML
    public ListView<String> ListViewWords;

    @FXML
    public TextArea TexAreaMeaning;

    Map<String, String> dictionary = new HashMap<String, String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       Search.setOnMouseClicked(event -> {
            System.out.println("Seach");
            String searchedWord = SearchedWord.getText();
            if(searchedWord != null ){
                System.out.println("Searched World: " + searchedWord);
                String wordMeaning = dictionary.get(searchedWord);
                TexAreaMeaning.setText(wordMeaning);
            }
        });
        this.initializeWordList();
        ListViewWords.setOnMouseClicked(event -> {
            String searchedWord = ListViewWords.getSelectionModel().getSelectedItem();
            if (searchedWord != null ){
                System.out.println("Searched Word: " + searchedWord);
                String wordMeaning = dictionary.get(SearchedWord);
                TexAreaMeaning.setText(wordMeaning);
            }
        });

    }

    public void initializeWordList() {
        dictionary.put("hello", "Xin chao");
        dictionary.put("thank you", "Cam on");
        dictionary.put("school", "Truong hoc");
        dictionary.put("class", "Lop hoc");
        ListViewWords.getItems().addAll(dictionary.keySet());
    }

}

