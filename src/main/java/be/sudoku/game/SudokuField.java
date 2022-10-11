package be.sudoku.game;

import be.sudoku.utils.Utils;
import be.sudoku.utils.Pair;

import java.util.ArrayList;

public class SudokuField {
    Short[][] field;

    public SudokuField(){
        generateNewField();
    }

    private Boolean generateField(int x, int y){
        Short[] available = getAvailable(x, y);
        Pair index = Utils.advanceIndex(x, y);
        for (Short shor : available) {
            field[x][y] = shor;
            if(index == null || generateField(index.x, index.y)){
                return true;
            }
        }
        field[x][y] = 0;
        return false;
    }

    private Short[] getAvailable(int x, int y) {
        ArrayList<Short> nums = Utils.allNums();
        ArrayList<Pair> indices = Utils.relevantIndices(x, y);
        for (Pair i : indices) {
            if(nums.contains(field[i.x][i.y])){
                nums.remove(field[i.x][i.y]);
            }
        }
        return nums.toArray(new Short[nums.size()]);
    }

    private void generateNewField() {
        field = new Short[9][9];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
        generateField(0, 0);
    }

    public void makePuzzle(){
        //TODO: impl
    }

    @Override
    public String toString() {
        String s = "";
        for (Short[] shorts : field) {
            for (Short shor : shorts) {
                s += shor;
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        SudokuField f = new SudokuField();
        System.out.println(f);
    }
}
