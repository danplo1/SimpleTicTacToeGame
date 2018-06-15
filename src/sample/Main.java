package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Main extends Application implements EventHandler<ActionEvent> {

    private void addButtons(GridPane gridPane, int row) {
        for (int i = 1; i <= 3; i++) {

            Button button = new Button("");
            button.setPrefSize(450, 450);
            gridPane.add(button, i - 1, row);

            //wzorzec projektowy
            button.setOnAction(this); //alt +Enter
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane gridPane = new GridPane();
        addButtons(gridPane, 0);
        addButtons(gridPane, 1);
        addButtons(gridPane, 2);


        /*GridPane - metoda na "siatkę" do TicTacToe
        Button button = new Button();
        button.setPrefHeight(300);
        button.setPrefWidth(300); lub zamiast tego:
        button.setPrefSize(150, 150);
        gridPane.add(button, 0, 0);*/

        /*Button button1 = new Button("");
        button1.setPrefSize(150, 150);
        gridPane.add(button1, 0, 0);

        Button button2 = new Button("");
        button2.setPrefSize(150, 150);
        gridPane.add(button2, 1, 1);

        Button button3 = new Button("");
        button3.setPrefSize(150, 150);
        gridPane.add(button3, 2, 2);*/


        primaryStage.setTitle("Simple TicTacToe");
        primaryStage.setScene(new Scene(gridPane, 450, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private int counter = 0;


    @Override
    public void handle(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (counter % 2 == 0) {
            button.setText("X");
        } else {
            button.setText("0");
        }
        button.setDisable(true);
        counter++;


    }
}
