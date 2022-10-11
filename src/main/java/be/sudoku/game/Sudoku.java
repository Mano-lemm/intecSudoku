package be.sudoku.game;

public class Sudoku {
    private SudokuField game;

    private static final int EASY = 20;
    private static final int MEDI = 30;
    private static final int HARD = 40;


    public Sudoku(){
        game = new SudokuField();
    }    

    public void setDifficulty(String difficulty){
        switch (difficulty) {
            case "easy":
                game.makePuzzle(EASY);
                break;
            case "medium":
                game.makePuzzle(MEDI);
                break;
            case "hard":
                game.makePuzzle(HARD);
                break;
            default:
                game.makePuzzle(EASY);
        }
    }
}
