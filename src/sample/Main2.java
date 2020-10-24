package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application {
    Stage window;
    Scene scene, scene2;
    public void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Label label=new Label("Nhập từ :");
        Button button = new Button("OK");
        button.setOnAction(event -> {
            window.setScene(scene2);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label,button);
        scene= new Scene(layout1,300,200);

        Button button2 = new Button("Close");
        button2.setOnAction(event -> {
            window.setScene(scene);
        });
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(button2);
        scene2= new Scene(layout2,600,470);


    }
}
