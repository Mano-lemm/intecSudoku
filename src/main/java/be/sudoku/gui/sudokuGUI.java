package be.sudoku.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sudokuGUI extends Application{
    @FXML
    private Button newGameButton;
    @FXML
    private GridPane grid;

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("run");
        Scene scene = new Scene(loadFXML("sudokuBase"), 1000, 800);
        stage.setTitle("Sudoku");
        stage.setScene(scene);
        stage.show();
    }

    public void initialise(){
        System.out.println("found");
    }

    private Parent loadFXML(String name) throws IOException{
        System.out.println("load?");
        FXMLLoader loader = new FXMLLoader(sudokuGUI.class.getClassLoader().getResource(name + ".fxml"));
        return loader.load();
    }
    
    public static void main(String[] args) {
        System.out.println("huh");
    }
}
