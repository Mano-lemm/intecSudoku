package be.sudoku.gui;

import java.io.IOException;

import be.sudoku.game.Sudoku;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class sudokuGUI extends Application{
    @FXML
    private Button newGameButton;
    @FXML
    private GridPane grid;
    @FXML
    private TextField numberField;

    private Sudoku game;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(loadFXML("sudokuBase"), 1000, 800);
        stage.setTitle("Sudoku");
        stage.setScene(scene);
        stage.show();
    }

    private Labeled createItem(int x, int y){
        Labeled r;
        if(game.getField(x, y) == 0){
            r = createEmptyButton(x, y);
        } else {
            r = new Label();
            r.setText(String.valueOf(game.getField(x, y)));
        }
        r.setAlignment(Pos.CENTER);
        r.setPrefHeight(Double.MAX_VALUE);
        r.setPrefWidth(Double.MAX_VALUE);
        String style = "";
        style += "-fx-border-width: 0 0 1 1;";
        style += "-fx-border-color: black;";
        r.setStyle(style);
        return r;
    }

    private Labeled createEmptyButton(int x, int y) {
        Button r = new Button();
        r.setText("");
        r.setOnAction(e -> {
            if(!numberField.getText().isBlank()){
                try {
                    if(game.setField(x, y, Integer.valueOf(numberField.getText()))){
                        r.setText(numberField.getText());
                    }
                } catch (NumberFormatException except) {
                    r.setText("NaN");
                }
            }
            numberField.setText("");
        }); 
        return r;
    }

    public void initGridChildren(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid.add(createItem(j, i), i, j);
            }
        }
    }

    public void initGrid(){
        for (int i = 0; i < 9; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100);
            col.setHalignment(HPos.CENTER);
            col.setHgrow(Priority.ALWAYS);
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100);
            row.setValignment(VPos.CENTER);
            row.setVgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(col);
            grid.getRowConstraints().add(row);
        }
        initGridChildren();
    }

    public void initialize(){
        game = new Sudoku();
        game.setDifficulty("easy");
        initGrid();
        newGameButton.setOnAction(e -> {
            game.newField();
            game.setDifficulty("medium");
            grid.getChildren().clear();
            initGridChildren();
        });
    }

    private Parent loadFXML(String name) throws IOException{
        FXMLLoader loader = new FXMLLoader(sudokuGUI.class.getClassLoader().getResource(name + ".fxml"));
        return loader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
