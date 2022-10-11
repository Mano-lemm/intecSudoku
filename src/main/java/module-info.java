// most stable java
// if it breaks, delete be.sudoku
// type be.sudoku in its place after
// wcyd

module be.sudoku {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens be.sudoku.gui to javafx.fxml;
    exports be.sudoku.gui;
}
