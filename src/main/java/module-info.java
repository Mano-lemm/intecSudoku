module be.sudoku {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens be.sudoku.gui to javafx.fxml;
    exports be.sudoku.gui;
}
