package sample;

import controller.Translator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
public class TranslateControl implements Initializable {
    @FXML
    public Button btnTranslate;

    public TextArea txtLangTo;
    @FXML
    public TextArea txtToLang;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("okok");
        btnTranslate.setOnMouseClicked(event -> {
            String fromLangText = txtLangTo.getText();
            String toLangTxt = Translator.translateText( "vi", "en",fromLangText);
            txtToLang.setText(toLangTxt);
        });
    }

}
