package sample;

import Model.Word;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import controller.DictionaryManagement;
import controller.DictionaryManagementData;
import controller.InputTxt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

public class SearchControl implements Initializable {
    @FXML
    public Button searchMenu;
    @FXML
    public Button btSearch;
    @FXML
    public Button btnVoice;
    @FXML
    public TextField tfSearchedWord;

    @FXML
    public ListView<String> lvWords ;

    @FXML
    public TextArea taMeaning;

    List<Word> listEV = new ArrayList<>();
    DictionaryManagement dicM = new DictionaryManagement();
    DictionaryManagementData dicMD = new DictionaryManagementData();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.initializeWordList();

        btnVoice.setOnMouseClicked(event -> {
            System.out.println("Click Button Voice!!!");
            String searchedWord = tfSearchedWord.getText();
            if(searchedWord != null){
                System.out.println("World to Speech: " + searchedWord);
                TextToSpeech(searchedWord);
            }
        });
        btSearch.setOnMouseClicked(event -> {
            System.out.println("Button Serach!!!");
            String searchedWord = tfSearchedWord.getText();
            if (searchedWord != null ) {
                System.out.println("Searched World: " + searchedWord);
                String expalain = dicM.dictionarySearcher(new Word(searchedWord, ""), listEV);
                if (!expalain.equals("")) {
                    taMeaning.setText(expalain);

                } else {
                    taMeaning.setText("@ Từ vựng không tồn tại @");
                }
            }
        });
        lvWords.setOnMouseClicked(event -> {
            String searchedWord = lvWords.getSelectionModel().getSelectedItem();
            if (searchedWord != null ) {
                tfSearchedWord.setText(searchedWord);
                System.out.println("Click Item Searched World: " + searchedWord);
                String expalain = dicM.dictionarySearcher(new Word(searchedWord, ""), listEV);
                taMeaning.setText(expalain);
            }
        });
    }
    public void initializeWordList() {
        dicMD.showAllWords("A_V", listEV);
        ObservableList<String> data = FXCollections.observableArrayList();
        System.out.println("Size E_V = " + listEV.size());
        for (Word word: this.listEV){
            data.add(word.getWordTarget());
        }
        data.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        FilteredList<String> filteredData = new FilteredList<>(data, s -> true);
        tfSearchedWord.textProperty().addListener(obs->{
            String filter = tfSearchedWord.getText();
            if(filter == null || filter.length() == 0) {
                filteredData.setPredicate((String s) -> true);
            }
            else {
                filteredData.setPredicate(s -> s.contains(filter));
            }
        });
        lvWords.setItems(filteredData);
        System.out.println("====Hien thi list Word ok=========!");
    }

    private void TextToSpeech(String searchedWord) {
        try {
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice("kevin16");
            voice.allocate();
            voice.speak(searchedWord);
        } catch (Exception e) {
            System.out.println("@@@@@@loi ham Voice");
        }

    }
}