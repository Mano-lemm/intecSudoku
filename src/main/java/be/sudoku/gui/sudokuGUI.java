package be.sudoku.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class sudokuGUI extends Application{
    @FXML
    private Button commitButton;
    @FXML
    private GridPane grid;
    @FXML
    private TextField numberField;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(loadFXML("sudokuBase"), 1000, 800);
        stage.setTitle("Sudoku");
        stage.setScene(scene);
        stage.show();
    }

    public void initGrid(){
        for (int i = 0; i < 9; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100);
            col.setHalignment(HPos.CENTER);
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100);
            row.setValignment(VPos.CENTER);
            grid.getColumnConstraints().add(col);
            grid.getRowConstraints().add(row);
        }
    }

    public void initialize(){
        initGrid();
    }

    private Parent loadFXML(String name) throws IOException{
        FXMLLoader loader = new FXMLLoader(sudokuGUI.class.getClassLoader().getResource(name + ".fxml"));
        return loader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
